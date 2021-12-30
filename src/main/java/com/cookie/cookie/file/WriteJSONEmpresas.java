package com.cookie.cookie.file;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.cookie.cookie.entity.Empresa;
import com.google.gson.Gson;

public class WriteJSONEmpresas {
    
    public static void imprimeJson(List<Empresa> lista2)
    {

        try
        {
            List<Empresa> lista = new ArrayList<Empresa>();

            for(int i = 0; i < lista2.size(); i++){
                Empresa u = new Empresa();

                if(lista2.get(i).getImagen() == null){
                    u.setImagen("");
                }
                u.setId(lista2.get(i).getId());
                u.setRazonSocial(lista2.get(i).getRazonSocial());
                u.setRuc(lista2.get(i).getRuc());
                u.setCorreo(lista2.get(i).getCorreo());
                u.setTelefono(lista2.get(i).getTelefono());
                u.setDireccion(lista2.get(i).getDireccion());

                lista.add(u);

            }

            Gson gson = new Gson();

            List<String> jsonString = new ArrayList<String>();
            
            for(int i = 0; i < lista.size(); i++){
                jsonString.add(gson.toJson(lista.get(i)));
            }
            
            FileWriter fileWriter = new FileWriter("empresas.json");
            
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
