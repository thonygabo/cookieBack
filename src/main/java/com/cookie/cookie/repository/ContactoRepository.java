package com.cookie.cookie.repository;

import com.cookie.cookie.entity.Contacto;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContactoRepository extends MongoRepository<Contacto, Integer>{
    
}
