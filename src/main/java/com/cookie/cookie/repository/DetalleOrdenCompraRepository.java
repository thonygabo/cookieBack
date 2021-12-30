package com.cookie.cookie.repository;

import java.util.List;

import com.cookie.cookie.entity.DetalleOrdenCompra;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface DetalleOrdenCompraRepository extends JpaRepository<DetalleOrdenCompra, Integer> {
    
    @Query(value = "select * from tb_detalle_orden_compra d where d.orden_compra_id = :id", nativeQuery=true) 
    List<DetalleOrdenCompra> listaDetalle(int id);
}
