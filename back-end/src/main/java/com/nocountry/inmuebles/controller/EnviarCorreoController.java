package com.nocountry.inmuebles.controller;

import com.nocountry.inmuebles.service.impl.CorreoServiceImpl;
import com.nocountry.inmuebles.util.ContactoCliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/correo")

public class EnviarCorreoController {

    @Autowired
    CorreoServiceImpl correoService;

    @PostMapping("/enviar")
    public ResponseEntity<?> enviarCorreo(@RequestBody ContactoCliente cliente){
        Map<String, String> salida = new HashMap<>();

        Boolean resultado= correoService.enviarCorreo(cliente);
        if(resultado==true){
            salida.put("MENSAJE", "Se ha enviado el correo correctamente");
        }else{
            salida.put("MENSAJE", "Error en el envio del correo");
        }
        return ResponseEntity.ok(salida);
    }
}
