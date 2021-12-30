package com.cookie.cookie.service;

import java.util.List;

import com.cookie.cookie.entity.Rol;
import com.cookie.cookie.repository.RolRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RolServiceImpl implements RolService{

    @Autowired
    private RolRepository repository;

    @Override
    public List<Rol> listaRol() {
        return repository.findAll();
    }
    
}
