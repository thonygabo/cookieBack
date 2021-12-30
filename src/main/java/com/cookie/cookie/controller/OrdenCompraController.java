package com.cookie.cookie.controller;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import com.cookie.cookie.entity.OrdenCompra;
import com.cookie.cookie.service.OrdenCompraService;
import com.cookie.cookie.utils.Constantes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cookie/ordenCompra")
@CrossOrigin(origins = Constantes.URL_PROYECTO)
public class OrdenCompraController {
    
    @Autowired
    private OrdenCompraService service;

    @GetMapping
	@ResponseBody
	public ResponseEntity<List<OrdenCompra>> listaOrdenCompra() {
		List<OrdenCompra> lista = service.listaOrdenCompra();
		return ResponseEntity.ok(lista);
	}

    @PostMapping
	@ResponseBody
	public ResponseEntity<Map<String,Object>> registraOrdenCompra(@RequestBody OrdenCompra oc) {
		Map<String,Object> salida= new HashMap<>();

		oc.setFechaReg(LocalDateTime.now());
		oc.setFechaEnt(LocalDateTime.now());
        OrdenCompra resp = service.insertaActualizaOrdenCompra(oc);

        salida.put("mensaje",Constantes.MENSAJE_REG_EXITOSO);
        salida.put("orden",resp);
        
        return ResponseEntity.ok(salida);
	}

	@GetMapping("/id/{idOrdenCompra}")
    @ResponseBody
    public ResponseEntity<Optional<OrdenCompra> > listaOrdenCompraId( @PathVariable("idOrdenCompra") int idOrdenCompra){
        Optional<OrdenCompra> lista = service.listaOrdenCompraPorId(idOrdenCompra);
        return ResponseEntity.ok(lista);
    }

    @GetMapping("/usuario/{idUsuario}")
    @ResponseBody
    public ResponseEntity<Map<String, Object>>  listaOrdenCompraPorUsuario( @PathVariable("idUsuario") int idUsuario){
             Map<String,Object> salida = new HashMap<>();
        List<OrdenCompra> lista = service.listaOrdenCompraPorUsuario(idUsuario);
        if(CollectionUtils.isEmpty(lista)){
            salida.put("mensaje","No hay ningun orden de compra");
        }else{
            salida.put("lista",lista);
        }
        return ResponseEntity.ok(salida);
    }
}
