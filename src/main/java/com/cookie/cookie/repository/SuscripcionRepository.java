package com.cookie.cookie.repository;

import com.cookie.cookie.entity.Suscripcion;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SuscripcionRepository extends MongoRepository<Suscripcion, Integer> {
    
}
