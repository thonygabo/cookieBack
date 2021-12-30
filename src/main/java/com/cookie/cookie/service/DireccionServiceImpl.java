package com.cookie.cookie.service;

import java.util.List;
import java.util.Optional;
import com.cookie.cookie.entity.Direccion;
import com.cookie.cookie.repository.DireccionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DireccionServiceImpl  implements DireccionService {
    @Autowired
    private DireccionRepository repository;

    @Override
    public List<Direccion> findByUsuario(int id) {
        return repository.findByUsuario(id);
    }

    @Override
    public Optional<Direccion> findById(int id) {
        return repository.findById(id);
    }

    @Override
    public Direccion save(Direccion obj) {
        return repository.save(obj);
    }

    @Override
    public Direccion delete(int id) {
        Direccion d= repository.findById(id).get();
        if(d.getEstado() == 1){
            d.setEstado(0);
        }
        else{
            d.setEstado(1);
        }
        repository.save(d);
        Direccion obj= repository.findById(id).get();
        return obj;
    }


    
}
