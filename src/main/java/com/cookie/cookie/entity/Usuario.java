package com.cookie.cookie.entity;

// import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
// import javax.persistence.GeneratedValue;
// import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "tb_usuario")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "usuario_id")
    private int id;
    
    @JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "empresa_id")
	private Empresa empresa;

    @JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "rol_id")
	private Rol rol;

    @Column(name = "usuario_nombre")
    private String nombre;

    @Column(name = "usuario_apellido_paterno")
    private String apellidoPa;

    @Column(name = "usuario_apellido_materno")
    private String apellidoMa;

    @JsonFormat(pattern = "yyyy-MM-dd", timezone="America/Lima")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
    @Temporal(TemporalType.DATE)
    @Column(name = "usuario_fecha_nacimiento")
    private Date fechaNaci;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone="America/Lima")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	// @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "usuario_fecha_registro")
    private LocalDateTime fechaReg;

    @Column(name = "usuario_contrasenia")
    private String contrasenia;

    @Column(name = "usuario_foto")
    private String foto;

    @Column(name = "usuario_estado")
    private int estado;

    @Column(name = "usuario_telefono")
    private String telefono;

    @Column(name = "usuario_correo")
    private String correo;

    @Column(name = "usuario_token")
    private String token;

    @Column(name = "usuario_api")
    private String api;

}