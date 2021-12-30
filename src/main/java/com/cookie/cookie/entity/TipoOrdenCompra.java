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
@Table(name = "tb_tipo_orden_compra")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TipoOrdenCompra {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "tipo_orden_compra_id")
    private int id;

    @Column(name = "tipo_orden_compra_descripcion")
    private String descripcion;
}
