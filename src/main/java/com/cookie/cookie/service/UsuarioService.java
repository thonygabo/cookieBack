package com.cookie.cookie.service;

import java.util.List;
import java.util.Optional;

import com.cookie.cookie.entity.Usuario;

public interface UsuarioService {

    public List<Usuario> listaUsuario();

    public Optional<Usuario> usuarioPorCorreo (String correo);

    public abstract Optional<Usuario> listaUsuarioPorId(int id);

    public Usuario usuarioPorCorreoYContrasenia(String correo, String contrasenia);

    public void insertaActualizaUsuario(Usuario obj);

    public abstract Usuario elimina(int id);
}
