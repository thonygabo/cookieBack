package com.cookie.cookie.service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import com.cookie.cookie.entity.Distrito;
import com.cookie.cookie.repository.DistritoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DistritoServiceImpl implements DistritoService {
    @Autowired
    private DistritoRepository repository;

    @Override
    public List<Distrito> lista() {
        List<Distrito> distrito = StreamSupport.stream(this.repository.findAll().spliterator(), false).collect(Collectors.toList());
        return distrito;
    }

    
}
