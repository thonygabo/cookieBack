package com.cookie.cookie.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "tb_promocion")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Promocion {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "promocion_id")
    private int id;

    @Column(name = "promocion_cupon")
    private String cupon;

    @Column(name = "promocion_descripcion")
    private String descripcion;

    @Column(name = "promocion_descuento")
    private double descuento;

    @Column(name = "promocion_cantidad")
    private int cantidad;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@Temporal(TemporalType.TIMESTAMP)
    @Column(name = "usuario_fecha_registro")
    private Date fechaReg;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@Temporal(TemporalType.TIMESTAMP)
    @Column(name = "usuario_fecha_fin")
    private Date fechaFin;

    @Column(name = "usuario_estado")
    private String estado;
}
