package com.cookie.cookie.controller;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Optional;

import com.cookie.cookie.entity.Empresa;
import com.cookie.cookie.entity.Rol;
import com.cookie.cookie.entity.TokenDto;
import com.cookie.cookie.entity.Usuario;
import com.cookie.cookie.service.OauthUService;
import com.cookie.cookie.service.UsuarioService;
import com.cookie.cookie.utils.Constantes;

import com.google.api.client.googleapis.auth.oauth2.GoogleIdToken;
import com.google.api.client.googleapis.auth.oauth2.GoogleIdTokenVerifier;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.jackson2.JacksonFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
//import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.social.facebook.api.Facebook;
import org.springframework.social.facebook.api.User;
import org.springframework.social.facebook.api.impl.FacebookTemplate;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cookie/oauth")
@CrossOrigin(origins = Constantes.URL_PROYECTO)
public class OauthController {

    @Value("${google.clientId}")
    String googleClientId;

    @Autowired
    OauthUService oauthUService;

    @Autowired
    UsuarioService service;

    @PostMapping("/google")
    public ResponseEntity<Map<String, Object>> google(@RequestBody TokenDto tokenDto) throws IOException {
        final NetHttpTransport transport = new NetHttpTransport();
        final JacksonFactory jacksonFactory = JacksonFactory.getDefaultInstance();
        GoogleIdTokenVerifier.Builder verifier = new GoogleIdTokenVerifier.Builder(transport, jacksonFactory)
                .setAudience(Collections.singletonList(googleClientId));
        final GoogleIdToken googleIdToken = GoogleIdToken.parse(verifier.getJsonFactory(), tokenDto.getValue());
        final GoogleIdToken.Payload payload = googleIdToken.getPayload();
        /*
         * Usuario usuario = new Usuario();
         * if(oauthUService.existsCorreo(payload.getEmail())) usuario =
         * oauthUService.getByCorreo(payload.getEmail()).get(); else usuario =
         * saveUsuario(payload.getEmail()); TokenDto tokenRes = login(usuario);
         */
        Usuario usuario = new Usuario();
        usuario.setCorreo(payload.getEmail());
        // usuario.setNombre(payload.);
        // System.out.println(payload.getEmail());
        // System.out.println(payload.getUnknownKeys());

        Map<String, Object> salida = new HashMap<>();
        Usuario opUsuario = service.usuarioPorCorreoYContrasenia(usuario.getCorreo(), "");

        if (opUsuario == null) {
            salida.put("mensaje", "Registro y acceso exitoso");
            Iterator<Map.Entry<String, Object>> itr = payload.getUnknownKeys().entrySet().iterator();

            while (itr.hasNext()) {
                Map.Entry<String, Object> entry = itr.next();
                if (entry.getKey().equals("given_name")) {
                    usuario.setNombre(entry.getValue().toString());
                }
                if (entry.getKey().equals("family_name")) {
                    usuario.setApellidoPa(entry.getValue().toString());
                    usuario.setApellidoMa(entry.getValue().toString());
                }
                if (entry.getKey().equals("picture")) {
                    usuario.setFoto(entry.getValue().toString());
                }
                /*
                 * System.out.println("Key = " + entry.getKey() + ", Value = " +
                 * entry.getValue());
                 */
            }
            saveUsuario(usuario);
            opUsuario = service.usuarioPorCorreoYContrasenia(usuario.getCorreo(), "");
            salida.put("correo", opUsuario);
        } else {
            salida.put("mensaje", "Acceso exitoso");
            salida.put("correo", opUsuario);
        }

        return ResponseEntity.ok(salida);
    }

    @PostMapping("/facebook")
    public ResponseEntity<Map<String, Object>> facebook(@RequestBody TokenDto tokenDto) throws IOException {
        Facebook facebook = new FacebookTemplate(tokenDto.getValue());
        final String[] fields = { "email", "picture" };
        User user = facebook.fetchObject("me", User.class, fields);
        /*
         * if(oauthUService.existsCorreo(user.getEmail())) usuario =
         * oauthUService.getByCorreo(user.getEmail()).get(); else usuario =
         * saveUsuario(user.getEmail()); TokenDto tokenRes = login(usuario);
         */
        Usuario usuario = new Usuario();
        usuario.setCorreo(user.getEmail());
        // System.out.println(user.getExtraData());

        Map<String, Object> salida = new HashMap<>();
        Usuario opUsuario = service.usuarioPorCorreoYContrasenia(usuario.getCorreo(), "");

        if (opUsuario==null) {
            salida.put("mensaje", "Registro y acceso exitoso");
            System.out.println(user.getName());
            if (user.getName() != null) {
                usuario.setNombre(user.getName());
            } else {
                usuario.setNombre("Sin nombre");
            }

            if (user.getLastName() != null) {
                usuario.setApellidoPa(user.getLastName());
                usuario.setApellidoMa(user.getLastName());
            } else {
                usuario.setApellidoPa("Sin apellido");
                usuario.setApellidoMa("Sin apellido");
            }
            //usuario.setFechaNaci(user.getBirthday());

            Iterator<Map.Entry<String, Object>> itr = user.getExtraData().entrySet().iterator();
            while (itr.hasNext()) {
                Map.Entry<String, Object> entry = itr.next();
                if (entry.getKey().equals("picture")) {
                    /*
                    Iterator<Map.Entry<String, Object>> ite = ((Map<String, Object>) entry.getValue()).entrySet().iterator();
                    while (itr.hasNext()) {
                        Map.Entry<String, Object> entry2 = ite.next();
                        System.out.println("Key = " + entry.getKey() + ", Value = " +
                        entry.getValue());
                        
                        if (entry2.getKey().equals("url")) {
                            usuario.setFoto(entry2.getValue().toString());
                        }
                    }*/
                }
                /*
                 * System.out.println("Key = " + entry.getKey() + ", Value = " +
                 * entry.getValue());
                 */
            }
            saveUsuario(usuario);
            opUsuario = service.usuarioPorCorreoYContrasenia(usuario.getCorreo(), "");
            salida.put("correo", opUsuario);
        } else {
            salida.put("mensaje", "Acceso exitoso");
            salida.put("correo", opUsuario);
        }

        return ResponseEntity.ok(salida);
        // return new ResponseEntity(user, HttpStatus.OK);
    }

    /*
     * private TokenDto login(Usuario usuario){ TokenDto tokenDto = new TokenDto();
     * return tokenDto; }
     */

    private Usuario saveUsuario(Usuario usuario) {
        Rol rol = new Rol();
        rol.setId(4);
        usuario.setRol(rol);
        Empresa empresa = new Empresa();
        empresa.setId(1);
        usuario.setEmpresa(empresa);
        usuario.setFechaReg(LocalDateTime.now());
        usuario.setEstado(1);
        usuario.setContrasenia("");
        return oauthUService.save(usuario);
    }
}
