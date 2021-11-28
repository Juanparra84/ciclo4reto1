package com.ciclo4.reto.controller;

import java.util.List;

import com.ciclo4.reto.model.User;
import com.ciclo4.reto.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;



    @RestController
    @RequestMapping("/api/user")
    @CrossOrigin("*")
    public class UserController {
        @Autowired
        private UserService userService;

        @GetMapping("/all")
        public List<User> getAll() {
            return userService.getAll();
        }

        @PostMapping("/new")
        @ResponseStatus(HttpStatus.CREATED)
        public User registrar(@RequestBody User user) {
            return userService.registrar(user);
        }

        @GetMapping("/{email}/{password}")
        public User autenticarUsuario(@PathVariable("email") String email, @PathVariable("password") String password) {
            return userService.autenticarUsuario(email, password);
        }

        @GetMapping("/{email}")
        public boolean existeEmail(@PathVariable("email") String email) {
            return userService.existeEmail(email);
        }
    }

