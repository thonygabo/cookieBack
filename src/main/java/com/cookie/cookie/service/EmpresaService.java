package com.cookie.cookie.service;

import java.util.List;
import java.util.Optional;

import com.cookie.cookie.entity.Empresa;

public interface EmpresaService {
    
    public List<Empresa> listaEmpresa();
    public void insertaActualiza(Empresa e);
    public abstract Optional<Empresa> buscaPorId(int id);
    public abstract Empresa elimina(int id);
}
