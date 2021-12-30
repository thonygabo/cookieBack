package com.cookie.cookie.repository;

import com.cookie.cookie.entity.Distrito;

import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface DistritoRepository extends CrudRepository<Distrito, Integer> {
    
}
