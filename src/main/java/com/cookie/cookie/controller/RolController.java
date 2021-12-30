package com.cookie.cookie.controller;

import java.util.List;

import com.cookie.cookie.entity.Rol;
import com.cookie.cookie.service.RolService;
import com.cookie.cookie.utils.Constantes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cookie/rol")
@CrossOrigin(origins = Constantes.URL_PROYECTO)
public class RolController {
    @Autowired
    private RolService service;

    @GetMapping
    @ResponseBody
    public ResponseEntity<List<Rol>> listaRol(){
        List<Rol> lista=service.listaRol();
        return ResponseEntity.ok(lista);
    }
}
