package com.cookie.cookie.controller;

import java.util.List;

import com.cookie.cookie.entity.Categoria;
import com.cookie.cookie.service.CategoriaService;
import com.cookie.cookie.utils.Constantes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cookie/categoria")
@CrossOrigin(origins = Constantes.URL_PROYECTO)
public class CategoriaController {
    @Autowired
    private CategoriaService service;

    @GetMapping
    @ResponseBody
    public ResponseEntity<List<Categoria>> listaCategoria(){
        List<Categoria> lista = service.listaCategoria();
        return ResponseEntity.ok(lista);
    }
}
