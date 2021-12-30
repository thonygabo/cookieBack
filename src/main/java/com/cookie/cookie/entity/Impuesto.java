package com.cookie.cookie.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "tb_impuesto")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Impuesto {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "impuesto_id")
    private int id;

    @Column(name = "impuesto_descripcion")
    private String descripcion;

    @Column(name = "impuesto_porcentaje")
    private double porcentaje;
}
