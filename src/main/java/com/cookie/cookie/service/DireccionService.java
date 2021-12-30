package com.cookie.cookie.service;

import java.util.List;
import java.util.Optional;
import com.cookie.cookie.entity.Direccion;

public interface DireccionService {
    public List<Direccion> findByUsuario(int id);

    public Optional<Direccion> findById(int id);

    public Direccion save(Direccion obj);

    public Direccion delete(int id);

}
