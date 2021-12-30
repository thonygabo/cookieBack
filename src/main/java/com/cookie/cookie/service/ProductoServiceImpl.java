package com.cookie.cookie.service;

import java.util.List;
import java.util.Optional;

import com.cookie.cookie.entity.Producto;
import com.cookie.cookie.repository.ProductoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductoServiceImpl implements ProductoService{

    @Autowired
    private ProductoRepository repository;

    @Override
    public List<Producto> listaProducto() {
        List<Producto> lista= repository.findAll();
        return lista;
    }

    @Override
    public List<Producto> listaProductosPorStock() {
        List<Producto> lista= repository.getProductosTop8ByStock();
        return lista;
    }

    @Override
    public List<Producto> listaProductosPorStockYCategoria(int categ,int idProd) {
        List<Producto> lista= repository.getProductosTop8ByCategoriaByStock(categ, idProd);
        return lista;
    }

    @Override
    public Optional<Producto> listaProductoPorId(int id) {
        Optional<Producto> producto= repository.findById(id);
        return producto;
    }

    @Override
    public void insertaActualizaProducto(Producto p) {
        repository.save(p);
    }

    @Override
    public Producto eliminaProducto(int id) {
        Producto p= repository.findById(id).get();
        if(p.getEstado() == 1){
            p.setEstado(0);
        }
        else{
            p.setEstado(1);
        }
        repository.save(p);
        Producto p2= repository.findById(id).get();
        return p2;
    }
    
}
