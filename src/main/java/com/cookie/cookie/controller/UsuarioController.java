package com.cookie.cookie.controller;

import java.text.ParseException;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import com.cookie.cookie.entity.Login;
import com.cookie.cookie.entity.Usuario;
import com.cookie.cookie.file.WriteJSONUsuarios;
import com.cookie.cookie.service.UsuarioService;
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
// import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
// import org.springframework.security.crypto.password.PasswordEncoder;

@RestController
@RequestMapping("/cookie/usuario")
@CrossOrigin(origins =  Constantes.URL_PROYECTO)
public class UsuarioController {
    @Autowired
    private UsuarioService service;

    // PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    @GetMapping("/json")
	@ResponseBody
	public ResponseEntity<List<Usuario>> usuarioJson() {
		List<Usuario> lista = service.listaUsuario();
        // System.out.println(lista.get(1).getId());
        // System.out.println(lista.get(1).getE());
        WriteJSONUsuarios.imprimeJson(lista);
		return ResponseEntity.ok(lista);
	}

    @GetMapping
	@ResponseBody
	public ResponseEntity<List<Usuario>> listaUsuario() {
		List<Usuario> lista = service.listaUsuario();
		return ResponseEntity.ok(lista);
	}

    @GetMapping("/{paramId}")
	@ResponseBody
	public ResponseEntity<Optional<Usuario>> obtenerUsuario(@PathVariable("paramId") int idUsuario){
        Optional<Usuario> usu = service.listaUsuarioPorId(idUsuario);
		return ResponseEntity.ok(usu);
	}

    @PostMapping    
	@ResponseBody
	public ResponseEntity<Map<String,Object>> registrarCliente(@RequestBody Usuario u) throws ParseException{   
        
        Map<String,Object> salida= new HashMap<>();

        if(u.getFechaReg() == null){
			u.setFechaReg(LocalDateTime.now());
        }

        // if(u.getContrasenia().length()<30){
            // System.out.println("a");
            // System.out.println(passwordEncoder.encode("ssss"));
        // }
        // System.out.println(u.getContrasenia().length());
        // u.setContrasenia(passwordEncoder.encode(u.getContrasenia()));

        service.insertaActualizaUsuario(u);
        System.out.println(u.getFechaReg());
        salida.put("mensaje",Constantes.MENSAJE_REG_EXITOSO);
        
        return ResponseEntity.ok(salida);
	}

    @PostMapping("/login")
    @ResponseBody
    public ResponseEntity<Map<String, Object>> login(@RequestBody Login l){
        
        Map<String,Object> salida = new HashMap<>();
        Usuario opUsuario = service.usuarioPorCorreoYContrasenia(l.getCorreo(),l.getContrasenia());
    
        if(opUsuario==null){
            salida.put("mensaje", "Credenciales no válidas");
        }else{
            salida.put("mensaje", "Acceso exitoso");
            salida.put("correo", opUsuario);
        }

        return ResponseEntity.ok(salida);
    }

    @GetMapping("/filtro")
    @ResponseBody
    public ResponseEntity<Map<String, Object>> usuarioPorCorreoYContrasenia(@RequestParam("correo") String correo,
    @RequestParam("contrasenia") String contrasenia){
        Map<String, Object> salida = new HashMap<>();
        try {
            Usuario usuario= service.usuarioPorCorreoYContrasenia(correo, contrasenia);
            if(usuario!=null){
                salida.put("usuario", usuario);
            }else{
                salida.put("mensaje",Constantes.MENSAJE_BU_NO_EXISTE_CORREO_CONTRASENIA );
            }
        } catch (Exception e) {
			e.printStackTrace();
            salida.put("mensaje", "Error al ingresar los campos, vuelva a intentarlo");
        }
        return ResponseEntity.ok(salida);
    }

    @DeleteMapping("/{paramId}")
	@ResponseBody
	public ResponseEntity<Usuario> elimina(@PathVariable("paramId") int idUsuario){
        Optional<Usuario> opUsuario = service.listaUsuarioPorId(idUsuario);
        if(opUsuario.isPresent()){

            Usuario usua = service.elimina(idUsuario);
            return ResponseEntity.ok(usua);

        }else{
                return ResponseEntity.noContent().build();
        }
	}
}
