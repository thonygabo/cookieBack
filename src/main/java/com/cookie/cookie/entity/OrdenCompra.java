package com.cookie.cookie.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "tb_orden_compra")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OrdenCompra {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "orden_compra_id")
    private int id;
    
    @JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "usuario_id")
	private Usuario usuario;

    @JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "tarjeta_id")
	private Tarjeta tarjeta;

    @JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "direccion_id")
	private Direccion direccion;

    @JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "promocion_id")
	private Promocion promocion;

    @JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "impuesto_id")
	private Impuesto impuesto;

    @JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "tipo_orden_compra_id")
	private TipoOrdenCompra tipoOrdenCompra;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone="America/Lima")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Column(name = "orden_compra_fecha_registro")
    private LocalDateTime fechaReg;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone="America/Lima")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Column(name = "orden_compra_fecha_entrega")
    private LocalDateTime fechaEnt;

    @Column(name = "orden_compra_subtotal")
    private double subtotal;

    @Column(name = "orden_compra_promo")
    private double promo;

    @Column(name = "orden_compra_igv")
    private double igv;

    @Column(name = "orden_compra_total")
    private double total;

    @Column(name = "orden_compra_estado")
    private int estado;

}
