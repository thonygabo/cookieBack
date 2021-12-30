package com.cookie.cookie.service;

import java.util.List;
import java.util.Optional;

import com.cookie.cookie.entity.Tarjeta;
import com.cookie.cookie.repository.TarjetaRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TarjetaServiceImpl implements TarjetaService {

    @Autowired
    private TarjetaRepository repository;

    @Override
    public List<Tarjeta> findByUsuario(int id) {
        return repository.findByUsuario(id);
    }

    @Override
    public Optional<Tarjeta> findById(int id) {
        return repository.findById(id);
    }

    @Override
    public Tarjeta save(Tarjeta tarjeta) {
        return repository.save(tarjeta);
    }

    @Override
    public Tarjeta delete(int id) {
        Tarjeta e= repository.findById(id).get();
        if(e.getEstado() == 1){
            e.setEstado(0);
        }
        else{
            e.setEstado(1);
        }
        repository.save(e);
        Tarjeta tarjeta= repository.findById(id).get();
        return tarjeta;
    }

}
