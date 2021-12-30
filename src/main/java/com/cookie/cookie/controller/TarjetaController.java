package com.cookie.cookie.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import com.cookie.cookie.entity.Tarjeta;
import com.cookie.cookie.service.TarjetaService;
import com.cookie.cookie.utils.Constantes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cookie/tarjeta")
@CrossOrigin(origins = Constantes.URL_PROYECTO)
public class TarjetaController {
    @Autowired
    private TarjetaService service;

    @GetMapping("/usuario/{idUsuario}")
	@ResponseBody
	public ResponseEntity<List<Tarjeta>> listaPorUsuario(@PathVariable("idUsuario") int idUsuario){
        List<Tarjeta> lista = service.findByUsuario(idUsuario);
		return ResponseEntity.ok(lista);
	}

    @GetMapping("/{idTarjeta}")
	@ResponseBody
	public ResponseEntity<Optional<Tarjeta>> tarjetaPorId(@PathVariable("idTarjeta") int idTarjeta){
        Optional<Tarjeta> tarjeta = service.findById(idTarjeta);
		return ResponseEntity.ok(tarjeta);
	}

    @PostMapping
    @ResponseBody
    public ResponseEntity<Map<String,Object>> crearTarjeta(@RequestBody Tarjeta obj){
        Map<String,Object> salida= new HashMap<>();
        obj.setEstado(1);
        Tarjeta tarjeta= service.save(obj);
        if(tarjeta!=null){
            salida.put("mensaje","Tarjeta creada con exito.");
        }else{
            salida.put("error","Error al crear la tarjeta, vuelva a intentarlo.");
        }
        return ResponseEntity.ok(salida);
    }


    @PutMapping
    @ResponseBody
    public ResponseEntity<Map<String,Object>> editarTarjeta(@RequestBody Tarjeta obj){
        Map<String,Object> salida= new HashMap<>();
        if(obj.getId()==0){
            salida.put("error", "El id de tarjeta debe ser diferente cero");
            return ResponseEntity.ok(salida); 
        }
        Optional<Tarjeta> tarjeta = service.findById(obj.getId());
        if(tarjeta.isPresent()){
            Tarjeta tarjetaEditada = service.save(obj);
            if(tarjetaEditada!=null){
                salida.put("mensaje","Tarjeta editada con exito.");
            }else{
                salida.put("error","Error al editar la tarjeta, vuelva a intentarlo.");
            }
        }else{
            salida.put("error","Tarjeta no encontrada.");
        }
        return ResponseEntity.ok(salida);
    }

    @DeleteMapping("/{idTarjeta}")
    @ResponseBody
    public ResponseEntity<Map<String,Object>> eliminarTarjeta(@PathVariable("idTarjeta") int idTarjeta){
        Map<String,Object> salida= new HashMap<>();
        Optional<Tarjeta> tarjeta = service.findById(idTarjeta);
        if(tarjeta.isPresent()){
            if(service.delete(idTarjeta)!=null){
                if(tarjeta.get().getEstado()==1){
                    salida.put("mensaje","Tarjeta eliminada con exito.");
                }else{
                    salida.put("mensaje","Tarjeta recuperada con exito.");
                }
            }else{
                salida.put("error","Error al eliminar la tarjeta, vuelva a intentarlo.");
            }
        }else{
            salida.put("error","Tarjeta no encontrada.");
        }
        return ResponseEntity.ok(salida);
    }
}
