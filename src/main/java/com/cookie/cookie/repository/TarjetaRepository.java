package com.cookie.cookie.repository;

import java.util.List;

import com.cookie.cookie.entity.Tarjeta;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface TarjetaRepository extends JpaRepository<Tarjeta, Integer> {
    
    @Query(value = "select * from tb_tarjeta x where x.usuario_id= :id", nativeQuery=true)
    public List<Tarjeta> findByUsuario(int id);

}
