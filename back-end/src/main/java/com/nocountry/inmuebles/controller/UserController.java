package com.nocountry.inmuebles.controller;

import com.nocountry.inmuebles.model.entity.User;
import com.nocountry.inmuebles.service.impl.UserServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor

public class UserController {

    @Autowired
    private UserServiceImpl servicio;

/*
    @GetMapping("/list")
    public List<User> index() {

        return servicio.listAll();
    }*/

    @PostMapping("/save")
    public ResponseEntity<String> registrarUsuario(@RequestBody Map<String, String> requestMap){
        try{
            servicio.signUp(requestMap);
            return ResponseEntity.ok().body("Usuario registrado");
        }catch(Exception e){
            e.printStackTrace();
        }
        return ResponseEntity.badRequest().body("Error en el registro");
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody Map<String, String> requestMap){
        try{
            return servicio.login(requestMap);
        }catch(Exception e){
            e.printStackTrace();
        }

        return ResponseEntity.badRequest().body("Algo salio mal");
    }
}
