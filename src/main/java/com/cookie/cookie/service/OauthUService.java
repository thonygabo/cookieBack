package com.cookie.cookie.service;

//import java.util.Optional;

import com.cookie.cookie.entity.Usuario;
import com.cookie.cookie.repository.UsuarioRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OauthUService {
    
    @Autowired
    UsuarioRepository usuarioRepository;

    /*public Optional<Usuario> getByCorreo(String correo){
        return usuarioRepository.findByCorreo(correo);
    }

    public boolean existsCorreo(String correo){
        return usuarioRepository.existsByCorreo(correo);
    }*/

    public Usuario save(Usuario usuario){
        return usuarioRepository.save(usuario);
    }
}
