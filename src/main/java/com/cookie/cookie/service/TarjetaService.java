package com.cookie.cookie.service;

import java.util.List;
import java.util.Optional;

import com.cookie.cookie.entity.Tarjeta;

public interface TarjetaService {
    public List<Tarjeta> findByUsuario(int id);

    public Optional<Tarjeta> findById(int id);

    public Tarjeta save(Tarjeta tarjeta);

    public Tarjeta delete(int id);
}
