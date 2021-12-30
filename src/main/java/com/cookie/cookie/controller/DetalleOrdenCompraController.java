package com.cookie.cookie.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.cookie.cookie.entity.DetalleOrdenCompra;
import com.cookie.cookie.service.DetalleOrdenCompraService;
import com.cookie.cookie.utils.Constantes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cookie/detalleOrdenCompra")
@CrossOrigin(origins = Constantes.URL_PROYECTO)
public class DetalleOrdenCompraController {
    
    @Autowired
    private DetalleOrdenCompraService service;

	@GetMapping("/id/{idOrdenCompra}")
    @ResponseBody
    public ResponseEntity< List<DetalleOrdenCompra> > listaDetalleOrdenCompraId( @PathVariable("idOrdenCompra") int idOrdenCompra){
        List<DetalleOrdenCompra> lista = service.buscarPorOrdenCompra(idOrdenCompra);
        return ResponseEntity.ok(lista);
    }

    @PostMapping
	@ResponseBody
	public ResponseEntity<Map<String,Object>> registraOrdenCompra(@RequestBody DetalleOrdenCompra oc) {
		Map<String,Object> salida= new HashMap<>();
        
        service.insertaActualizaDetalleOrdenCompra(oc);

        salida.put("mensaje",Constantes.MENSAJE_REG_EXITOSO);
        
        return ResponseEntity.ok(salida);
	}
}
