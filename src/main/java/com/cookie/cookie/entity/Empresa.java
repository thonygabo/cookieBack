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
@Table(name = "tb_empresa")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Empresa {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "empresa_id")
    private int id;

    @JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "distrito_id")
	private Distrito distrito;

    @Column(name = "empresa_razon_social")
    private String razonSocial;

    @Column(name = "empresa_ruc")
    private String ruc;

    @Column(name = "empresa_correo")
    private String correo;

    @Column(name = "empresa_telefono")
    private String telefono;

    @Column(name = "empresa_direccion")
    private String direccion;

    @Column(name = "empresa_latitud")
    private double latitud;

    @Column(name = "empresa_longitud")
    private double longitud;

    @Column(name = "empresa_imagen")
    private String imagen;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone="America/Lima")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	// @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "empresa_fecha_reg")
    private LocalDateTime fechaReg;

    @Column(name = "empresa_estado")
    private int estado;
}
