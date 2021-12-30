package com.cookie.cookie.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "tb_producto")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Producto {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "producto_id")
    private int id;

    @JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "empresa_id")
	private Empresa empresa;
    
    @Column(name = "producto_nombre")
    private String nombre;

    @Column(name = "producto_descripcion")
    private String descripcion;

    @Column(name = "producto_grasas")
    private double grasas;

    @Column(name = "producto_azucares")
    private double azucares;

    @Column(name = "producto_proteinas")
    private double proteinas;

    @Column(name = "producto_calorias")
    private int calorias;

    @JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "categoria_id")
	private Categoria categoria;

    @Column(name = "producto_stock")
    private int stock;

    @Column(name = "producto_precio")
    private double precio;

    @Column(name = "producto_imagen")
    private String imagen;

    @Column(name = "producto_estado")
    private int estado;

}
