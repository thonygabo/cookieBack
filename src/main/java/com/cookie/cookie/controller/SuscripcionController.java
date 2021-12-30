package com.cookie.cookie.controller;

import java.util.List;

import com.cookie.cookie.entity.Suscripcion;
import com.cookie.cookie.repository.SuscripcionRepository;
import com.cookie.cookie.utils.Constantes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cookie/suscripcion")
@CrossOrigin(origins =  Constantes.URL_PROYECTO)
public class SuscripcionController {
    
    @Autowired
    private SuscripcionRepository repository;

    @GetMapping
    @ResponseBody
    public List<Suscripcion> listaSuscripcion(){
        return repository.findAll();
    }

    @PostMapping
    @ResponseBody
    public Suscripcion insertar(@Validated @RequestBody Suscripcion suscripcion){
        return repository.insert(suscripcion);
    }
}
