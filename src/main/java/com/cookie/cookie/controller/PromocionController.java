package com.cookie.cookie.controller;

import java.util.List;
import com.cookie.cookie.entity.Promocion;
import com.cookie.cookie.service.PromocionService;
import com.cookie.cookie.utils.Constantes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cookie/promocion")
@CrossOrigin(origins = Constantes.URL_PROYECTO)
public class PromocionController {
    @Autowired
    private PromocionService service;

    @GetMapping
    @ResponseBody
    public ResponseEntity<List<Promocion>> listaPromocion(){
        List<Promocion> lista=service.listaPromocion();
        return ResponseEntity.ok(lista);
    }
}