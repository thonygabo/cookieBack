package com.cookie.cookie.file;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.cookie.cookie.entity.Usuario;
import com.google.gson.Gson;

public class WriteJSONUsuarios {
    
    public static void imprimeJson(List<Usuario> lista2)
    {

        try
        {
            List<Usuario> lista = new ArrayList<Usuario>();

            for(int i = 0; i < lista2.size(); i++){
                Usuario u = new Usuario();

                if(lista2.get(i).getFoto() == null){
                    u.setFoto("");
                }
                if(lista2.get(i).getTelefono() == null){
                   u.setTelefono("");
                }

                u.setId(lista2.get(i).getId());
                u.setNombre(lista2.get(i).getNombre());
                u.setApellidoPa(lista2.get(i).getApellidoPa());
                u.setApellidoMa(lista2.get(i).getApellidoMa());
                u.setCorreo(lista2.get(i).getCorreo());
                u.setFechaReg(lista2.get(i).getFechaReg());
                u.setFechaNaci(lista2.get(i).getFechaNaci());
                //  u.setEmpresa(lista2.get(i).getEmpresa());
                // u.setRol(lista2.get(i).getRol());
                u.setEstado(lista2.get(i).getEstado());

                lista.add(u);

            }

            Gson gson = new Gson();

            List<String> jsonString = new ArrayList<String>();
            
            for(int i = 0; i < lista.size(); i++){
                if(lista.get(i).getFoto() == null){
                    lista.get(i).setFoto("");
                }
                if(lista.get(i).getTelefono() == null){
                    lista.get(i).setTelefono("");
                }
                jsonString.add(gson.toJson(lista.get(i)));
            }
            
            FileWriter fileWriter = new FileWriter("usuarios.json");
            
            for(int i = 0; i < jsonString.size(); i++){
                fileWriter.write(jsonString.get(i));
            }
            fileWriter.close();
            
        } catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}
