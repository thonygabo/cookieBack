package com.cookie.cookie.repository;

import java.util.List;

import com.cookie.cookie.entity.Direccion;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface DireccionRepository extends CrudRepository<Direccion, Integer> {

    @Query(value = "select * from tb_direccion x where x.usuario_id= :id", nativeQuery=true)
    public List<Direccion> findByUsuario(int id);
}
