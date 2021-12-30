package com.cookie.cookie.service;

import java.util.List;
import java.util.Optional;

import com.cookie.cookie.entity.Usuario;
import com.cookie.cookie.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioServiceImpl implements UsuarioService {


    @Autowired
    private UsuarioRepository repository;

    @Override
    public Optional<Usuario> usuarioPorCorreo(String correo) {
        return repository.findByCorreo(correo);
    }

    @Override
    public Usuario usuarioPorCorreoYContrasenia(String correo, String contrasenia) {
        return repository.usuarioPorCorreoYContrasenia(correo, contrasenia);
    }

    @Override
    public void insertaActualizaUsuario(Usuario obj) {
        repository.save(obj);
    }

    @Override
    public List<Usuario> listaUsuario() {
        return repository.findAll();
    }

    @Override
    public Usuario elimina(int id) {
        Usuario u = repository.findById(id).get();
        if(u.getEstado() == 1){
            u.setEstado(0);
        }
        else{
            u.setEstado(1);
        }
        repository.save(u);
        Usuario u2 = repository.findById(id).get();
        return u2;
    }

    @Override
    public Optional<Usuario> listaUsuarioPorId(int id) {
        Optional<Usuario> usuario= repository.findById(id);
        return usuario;
    }
    
}