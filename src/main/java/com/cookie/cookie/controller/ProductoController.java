package com.cookie.cookie.controller;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import com.cookie.cookie.entity.Producto;
import com.cookie.cookie.file.WriteJSONProductos;
import com.cookie.cookie.service.ProductoService;
import com.cookie.cookie.utils.Constantes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cookie/producto")
@CrossOrigin(origins = Constantes.URL_PROYECTO)
public class ProductoController {
    @Autowired
    private ProductoService service;

    @GetMapping
    @ResponseBody
    public ResponseEntity<List<Producto>> listaProducto(){
        List<Producto> lista=service.listaProducto();
        return ResponseEntity.ok(lista);
    }

    @GetMapping("/json")
	@ResponseBody
	public ResponseEntity<List<Producto>> usuarioJson() {
		List<Producto> lista = service.listaProducto();
        // System.out.println(lista.get(1).getId());
        // System.out.println(lista.get(1).getE());
        WriteJSONProductos.imprimeJson(lista);
		return ResponseEntity.ok(lista);
	}

    @GetMapping("/id/{idProducto}")
    @ResponseBody
    public ResponseEntity< Optional<Producto> > listaProductoId( @PathVariable("idProducto") int idProducto){
        Optional<Producto> lista=service.listaProductoPorId(idProducto);
        return ResponseEntity.ok(lista);
    }

    @GetMapping("/filtro")
    @ResponseBody
    public ResponseEntity<List<Producto>> listaProductoFiltro(@RequestParam("categoria") int categoria, @RequestParam("idProducto") int idProducto ){
        List<Producto> lista=new ArrayList<Producto>();
		if(idProducto != 0 && categoria != 0){
			lista = service.listaProductosPorStockYCategoria(categoria,idProducto);
		}else{
		    lista = service.listaProductosPorStock();
		}
		return ResponseEntity.ok(lista);
    }

    @PostMapping
	@ResponseBody
	public ResponseEntity<Map<String,Object>> registrar(@RequestBody Producto p) throws ParseException{   
        System.out.println("entro al post");
        System.out.println(p.getId());
        
        Map<String,Object> salida= new HashMap<>();

        service.insertaActualizaProducto(p);
        salida.put("mensaje",Constantes.MENSAJE_REG_EXITOSO);
        
        return ResponseEntity.ok(salida);
	}

    @DeleteMapping("/{paramId}")
	@ResponseBody
	public ResponseEntity<Producto> eliminaAlumno(@PathVariable("paramId") int idProducto){
        Optional<Producto> opAlumno=service.listaProductoPorId(idProducto);
        if(opAlumno.isPresent()){

            Producto produ = service.eliminaProducto(idProducto);
            return ResponseEntity.ok(produ);

        }else{
                return ResponseEntity.noContent().build();
        }
	}
}
