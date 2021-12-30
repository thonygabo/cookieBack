package com.cookie.cookie.service;

import java.util.List;

import com.cookie.cookie.entity.DetalleOrdenCompra;
import com.cookie.cookie.repository.DetalleOrdenCompraRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DetalleOrdenCompraServiceImpl implements DetalleOrdenCompraService {

    @Autowired
    private DetalleOrdenCompraRepository repository;
    
    @Override
    public List<DetalleOrdenCompra> buscarPorOrdenCompra(int id) {
        List<DetalleOrdenCompra> lista = repository.listaDetalle(id);
        return lista;
    }

    @Override
    public void insertaActualizaDetalleOrdenCompra(DetalleOrdenCompra obj) {
        repository.save(obj);
    }
    
}
