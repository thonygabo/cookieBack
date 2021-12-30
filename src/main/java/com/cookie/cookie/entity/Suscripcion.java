package com.cookie.cookie.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@Document("suscripcion")
@ToString
@AllArgsConstructor
public class Suscripcion {
    
    @Id
    private String id;
    @Field
    private String email;
}
