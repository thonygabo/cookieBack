package com.cookie.cookie.repository;

import java.util.Optional;

import com.cookie.cookie.entity.Usuario;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer>{
    
    public Optional<Usuario> findByCorreo (String correo);
    //boolean existsByCorreo(String correo);
    @Query(value = "select * from tb_usuario x where x.usuario_correo= :correo and x.usuario_contrasenia= :contrasenia", nativeQuery=true)
    public Usuario usuarioPorCorreoYContrasenia( String correo,String contrasenia);
    public Optional<Usuario>  findByCorreoAndContrasenia( String correo, String contrasenia);
}
