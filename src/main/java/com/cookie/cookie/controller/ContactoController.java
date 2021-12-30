package com.cookie.cookie.controller;

import java.util.List;

import com.cookie.cookie.entity.Contacto;
import com.cookie.cookie.repository.ContactoRepository;
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
@RequestMapping("/cookie/contacto")
@CrossOrigin(origins = Constantes.URL_PROYECTO)
public class ContactoController {
    
    @Autowired
    private ContactoRepository repository;

    @GetMapping
    @ResponseBody
    public List<Contacto> listaContacto(){
        return repository.findAll();
    }

    @PostMapping
    @ResponseBody
    public Contacto insertar(@Validated @RequestBody Contacto contacto){
        return repository.insert(contacto);
    }
}
