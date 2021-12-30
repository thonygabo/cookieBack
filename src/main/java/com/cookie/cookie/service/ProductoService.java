package com.cookie.cookie.service;

import java.util.List;
import java.util.Optional;

import com.cookie.cookie.entity.Producto;

public interface ProductoService {
    public abstract List<Producto> listaProducto();
    public abstract Optional<Producto> listaProductoPorId(int id);
    public abstract Producto eliminaProducto(int id);
    public abstract List<Producto> listaProductosPorStock();
    public abstract List<Producto> listaProductosPorStockYCategoria(int categ,int idProd);
    public void insertaActualizaProducto(Producto p);
}
