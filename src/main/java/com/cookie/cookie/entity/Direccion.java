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
@Table(name = "tb_direccion")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Direccion {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "direccion_id")
    private int id;

    @Column(name = "direccion_latitud")
    private double latitud;

    @Column(name = "direccion_longitud")
    private double longitud;

    @Column(name = "direccion_descripcion")
    private String descripcion;

    @Column(name = "direccion_etiqueta")
    private String etiqueta;

    @Column(name = "direccion_referencia")
    private String referencia;

    @JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "distrito_id")
	private Distrito distrito;

    @JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "usuario_id")
	private Usuario usuario;

    @Column(name = "direccion_estado")
    private int estado;
}
