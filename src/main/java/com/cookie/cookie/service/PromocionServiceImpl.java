package com.cookie.cookie.service;

import java.util.List;

import com.cookie.cookie.entity.Promocion;
import com.cookie.cookie.repository.PromocionRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PromocionServiceImpl implements PromocionService {

    @Autowired
    private PromocionRepository repository;

    @Override
    public List<Promocion> listaPromocion() {
        List<Promocion> lista = repository.findAll();
        return lista;
    }
    
}
