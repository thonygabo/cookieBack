package com.cookie.cookie.service;

import java.util.List;
import java.util.Optional;

import com.cookie.cookie.entity.OrdenCompra;
import com.cookie.cookie.repository.OrdenCompraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrdenCompraServiceImpl implements OrdenCompraService  {
    @Autowired
    private OrdenCompraRepository repository;

    @Override
    public List<OrdenCompra> listaOrdenCompra() {
        return repository.findAll();
    }

    @Override
    public Optional<OrdenCompra> listaOrdenCompraPorId(int id) {
        Optional<OrdenCompra> ordenCompra= repository.findById(id);
        return ordenCompra;
    }

	@Override
	public List<OrdenCompra> listaOrdenCompraPorUsuario(int idUsuario) {
		return repository.listaPorUsuario(idUsuario);
	}

    @Override
    public OrdenCompra insertaActualizaOrdenCompra(OrdenCompra obj) {
        return repository.save(obj);
    }
}
