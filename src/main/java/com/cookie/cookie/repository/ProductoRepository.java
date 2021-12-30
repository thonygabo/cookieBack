package com.cookie.cookie.repository;

import java.util.List;

import com.cookie.cookie.entity.Producto;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ProductoRepository extends JpaRepository<Producto, Integer> {

    @Query(value="select * from tb_producto order by producto_stock desc limit 8", nativeQuery=true)
	List<Producto> getProductosTop8ByStock();
	    
	@Query(value="select * from tb_producto t where t.categoria_id = :categ and t.producto_id != :prod  ORDER BY producto_stock desc LIMIT 8", nativeQuery=true)
	List<Producto> getProductosTop8ByCategoriaByStock(int categ,int prod);

}
