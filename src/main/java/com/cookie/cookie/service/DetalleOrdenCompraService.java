package com.cookie.cookie.service;

import java.util.List;

import com.cookie.cookie.entity.DetalleOrdenCompra;

public interface DetalleOrdenCompraService {
    public abstract List<DetalleOrdenCompra> buscarPorOrdenCompra(int id);
    public void insertaActualizaDetalleOrdenCompra(DetalleOrdenCompra obj);
}
