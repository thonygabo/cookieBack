package com.cookie.cookie.repository;

import com.cookie.cookie.entity.Empresa;

import org.springframework.data.repository.CrudRepository;

public interface EmpresaRepository extends CrudRepository<Empresa, Integer> {
    
}
