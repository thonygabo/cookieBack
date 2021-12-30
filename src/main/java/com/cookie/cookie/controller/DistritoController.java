package com.cookie.cookie.controller;

import java.util.List;

import com.cookie.cookie.entity.Distrito;
import com.cookie.cookie.service.DistritoService;
import com.cookie.cookie.utils.Constantes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cookie/distrito")
@CrossOrigin(origins = Constantes.URL_PROYECTO)
public class DistritoController {

    @Autowired
    private DistritoService service;

    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<List<Distrito>> lista(){
        List<Distrito> lista = service.lista();
        return ResponseEntity.ok(lista);
    }
}
