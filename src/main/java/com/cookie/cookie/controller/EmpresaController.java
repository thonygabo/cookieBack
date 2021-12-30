package com.cookie.cookie.controller;

import java.text.ParseException;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import com.cookie.cookie.entity.Empresa;
import com.cookie.cookie.file.WriteJSONEmpresas;
import com.cookie.cookie.service.EmpresaService;
import com.cookie.cookie.utils.Constantes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cookie/empresa")
@CrossOrigin(origins = Constantes.URL_PROYECTO)
public class EmpresaController {

    @Autowired
    private EmpresaService service;

	@RequestMapping(method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<List<Empresa>> listaEmpresa() {
		List<Empresa> lista = service.listaEmpresa();
		return ResponseEntity.ok(lista);
	}

	@RequestMapping(path = "/json", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<List<Empresa>> usuarioJson() {
		List<Empresa> lista = service.listaEmpresa();
        // System.out.println(lista.get(1).getId());
        // System.out.println(lista.get(1).getE());
        WriteJSONEmpresas.imprimeJson(lista);
		return ResponseEntity.ok(lista);
	}

	@RequestMapping(method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<Map<String,Object>> registrar(@RequestBody Empresa e) throws ParseException{   
        Map<String,Object> salida= new HashMap<>();

		if(e.getFechaReg() == null){
			e.setFechaReg(LocalDateTime.now());
		}

        service.insertaActualiza(e);
        salida.put("mensaje",Constantes.MENSAJE_REG_EXITOSO);
        
        return ResponseEntity.ok(salida);
	}

	@RequestMapping(path = "/{paramId}", method = RequestMethod.DELETE)
	@ResponseBody
	public ResponseEntity<Empresa> eliminaAlumno(@PathVariable("paramId") int id){
        Optional<Empresa> op=service.buscaPorId(id);
        if(op.isPresent()){
            Empresa empresa = service.elimina(id);
            return ResponseEntity.ok(empresa);

        }else{
                return ResponseEntity.noContent().build();
        }
	}
}
