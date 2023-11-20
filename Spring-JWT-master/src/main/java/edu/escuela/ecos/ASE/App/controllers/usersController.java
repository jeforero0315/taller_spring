package edu.escuela.ecos.ASE.App.controllers;

import edu.escuela.ecos.ASE.App.models.users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import edu.escuela.ecos.ASE.App.services.usersServices;

import java.util.ArrayList;

@RestController
@RequestMapping("/users")
public class usersController {

    @Autowired
    usersServices services;

    @GetMapping()
    public ArrayList<users> getUsers() {
        return this.services.getAllUsers();
    }

    @PostMapping()
    public users createUser(@RequestBody users u) {
        return this.services.createUsers(u);
    }


    @PostMapping("/login")
    public ResponseEntity<String> loginUsers(@RequestBody users u) {
        String token = this.services.login(u.getUsername(), u.getPasswords());
        if (token.startsWith("Credenciales erroneas")) {
            return new ResponseEntity<>(token, HttpStatus.UNAUTHORIZED);
        } else {
            return new ResponseEntity<>(token, HttpStatus.OK);
        }
    }

}

