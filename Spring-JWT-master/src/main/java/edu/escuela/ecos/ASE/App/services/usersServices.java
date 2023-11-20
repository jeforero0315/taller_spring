package edu.escuela.ecos.ASE.App.services;


import edu.escuela.ecos.ASE.App.models.users;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import edu.escuela.ecos.ASE.App.repositories.usersRepository;

import java.security.Key;
import java.util.ArrayList;
import java.util.Date;

@Service
public class usersServices {

    @Autowired
    usersRepository usersRepo;

    private final Key secretKey = Keys.secretKeyFor(SignatureAlgorithm.HS512);

    public ArrayList<users> getAllUsers(){

        return (ArrayList<users>) usersRepo.findAll();
    }

    public users createUsers(users u){

        return usersRepo.save(u);
    }



    public String login(String username, String passwords){

        users user = usersRepo.findByUsernameAndPasswords(username, passwords);

        if (user != null) {
            // Generar el token JWT
            return generateJwtToken(username);
        } else {
            // Manejar el caso en el que las credenciales son incorrectas
            return "Credenciales erroneas";
        }
    }

    private String generateJwtToken(String username) {
        // Configuración de la expiración del token (en milisegundos)
        long expirationMs = 86400000; // 1 día
        Date expirationDate = new Date(System.currentTimeMillis() + expirationMs);

        // Crear el token JWT
        return Jwts.builder()
                .setSubject(username)
                .setExpiration(expirationDate)
                .signWith(SignatureAlgorithm.HS512, secretKey)
                .compact();
    }



}
