package com.cookie.cookie.service;

import java.util.List;
import java.util.Optional;

import com.cookie.cookie.entity.OrdenCompra;

public interface OrdenCompraService {
    
    public List<OrdenCompra> listaOrdenCompra();
    public abstract Optional<OrdenCompra> listaOrdenCompraPorId(int id);
    public List<OrdenCompra> listaOrdenCompraPorUsuario(int idUsuario);
    public OrdenCompra insertaActualizaOrdenCompra(OrdenCompra obj);
}
