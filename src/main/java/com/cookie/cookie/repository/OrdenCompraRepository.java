package com.cookie.cookie.repository;

import com.cookie.cookie.entity.OrdenCompra;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
public interface OrdenCompraRepository extends JpaRepository<OrdenCompra, Integer> {
    
    @Query(value = "select * from tb_orden_compra o where o.usuario_id = :idUsuario", nativeQuery=true) 
    List<OrdenCompra> listaPorUsuario(int idUsuario);
}
