package com.cookie.cookie.repository;

import com.cookie.cookie.entity.Departamento;

import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartamentoRepository extends JpaRepository<Departamento, Integer> {
    
}
