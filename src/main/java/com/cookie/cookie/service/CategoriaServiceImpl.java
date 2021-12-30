package com.cookie.cookie.service;

import java.util.List;

import com.cookie.cookie.entity.Categoria;
import com.cookie.cookie.repository.CategoriaRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoriaServiceImpl implements CategoriaService{

    @Autowired
    private CategoriaRepository repository;

    @Override
    public List<Categoria> listaCategoria() {
        List<Categoria> lista= repository.findAll();
        return lista;
    }
    
}
