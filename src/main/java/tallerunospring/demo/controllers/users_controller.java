package tallerunospring.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tallerunospring.demo.models.users_model;
import tallerunospring.demo.services.users_services;

import java.util.ArrayList;

@RestController
@RequestMapping("/users")
public class users_controller {

    @Autowired
    users_services service;
    @GetMapping
    public ArrayList <users_model> model (){
        return service.getAllUsers();

    }

}
