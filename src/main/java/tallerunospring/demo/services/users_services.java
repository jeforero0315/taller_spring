package tallerunospring.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tallerunospring.demo.models.users_model;
import tallerunospring.demo.repositories.users_repo;

import java.util.ArrayList;
@Service
public class users_services {

        @Autowired
        users_repo UserRepo;

    public ArrayList<users_model>getAllUsers(){
            return(ArrayList<users_model>) UserRepo.findAll();

        }
        public users_model createdUsers (users_model modeloUsuario){
            return UserRepo.save(modeloUsuario);


    }
}
