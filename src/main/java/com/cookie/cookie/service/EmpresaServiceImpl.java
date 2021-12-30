package com.cookie.cookie.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import com.cookie.cookie.entity.Empresa;
import com.cookie.cookie.repository.EmpresaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmpresaServiceImpl implements EmpresaService {
    
    @Autowired
    private EmpresaRepository repository;

    @Override
    public List<Empresa> listaEmpresa() {
        List<Empresa> empresa = StreamSupport.stream(this.repository.findAll().spliterator(), false).collect(Collectors.toList());
        return empresa;
    }

    @Override
    public void insertaActualiza(Empresa e) {
        repository.save(e);
    }

    @Override
    public Optional<Empresa> buscaPorId(int id) {
        Optional<Empresa> e= repository.findById(id);
        return e;
    }

    @Override
    public Empresa elimina(int id) {
        Empresa e= repository.findById(id).get();
        if(e.getEstado() == 1){
            e.setEstado(0);
        }
        else{
            e.setEstado(1);
        }
        repository.save(e);
        Empresa e2= repository.findById(id).get();
        return e2;
    }
}
