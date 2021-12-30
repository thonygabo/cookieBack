package com.cookie.cookie.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import com.cookie.cookie.entity.Direccion;
import com.cookie.cookie.service.DireccionService;
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
@RequestMapping("/cookie/direccion")
@CrossOrigin(origins =  Constantes.URL_PROYECTO)
public class DireccionController {

    @Autowired
    private DireccionService service;

    @RequestMapping(path = "/usuario/{idUsuario}", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<List<Direccion>> listaPorUsuario(@PathVariable("idUsuario") int idUsuario){
        List<Direccion> lista = service.findByUsuario(idUsuario);
		return ResponseEntity.ok(lista);
	}

    @RequestMapping(path = "{idDireccion}", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<Optional<Direccion>> tarjetaPorId(@PathVariable("idDireccion") int idDireccion){
        Optional<Direccion> direccion = service.findById(idDireccion);
		return ResponseEntity.ok(direccion);
	}

    @RequestMapping(method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<Map<String,Object>> crearTarjeta(@RequestBody Direccion obj){
        Map<String,Object> salida= new HashMap<>();
        obj.setEstado(1);
        Direccion direccion= service.save(obj);
        System.out.println("direccion: ");
        System.out.println(direccion.getDescripcion());
        if(direccion!=null){
            salida.put("mensaje","Tarjeta creada con exito.");
        }else{
            salida.put("error","Error al crear la tarjeta, vuelva a intentarlo.");
        }
        return ResponseEntity.ok(salida);
    }

    @RequestMapping(method = RequestMethod.PUT)
    @ResponseBody
    public ResponseEntity<Map<String,Object>> editarTarjeta(@RequestBody Direccion obj){
        Map<String,Object> salida= new HashMap<>();
        if(obj.getId()==0){
            salida.put("error", "El id de tarjeta debe ser diferente cero");
            return ResponseEntity.ok(salida); 
        }
        Optional<Direccion> direccion = service.findById(obj.getId());
        if(direccion.isPresent()){
            Direccion tarjetaEditada = service.save(obj);
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

    @RequestMapping(path = "/{idDireccion}", method = RequestMethod.DELETE)
    @ResponseBody
    public ResponseEntity<Map<String,Object>> eliminarTarjeta(@PathVariable("idDireccion") int idDireccion){
        Map<String,Object> salida= new HashMap<>();
        Optional<Direccion> direccion = service.findById(idDireccion);
        if(direccion.isPresent()){
            if(service.delete(idDireccion)!=null){
                if(direccion.get().getEstado()==1){
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
