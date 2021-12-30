package com.cookie.cookie.file;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.cookie.cookie.entity.Producto;
import com.google.gson.Gson;

public class WriteJSONProductos {
    
    public static void imprimeJson(List<Producto> lista2)
    {

        try
        {
            List<Producto> lista = new ArrayList<Producto>();

            for(int i = 0; i < lista2.size(); i++){
                Producto u = new Producto();

                if(lista2.get(i).getImagen() == null){
                    u.setImagen("");
                }
                u.setId(lista2.get(i).getId());
                u.setNombre(lista2.get(i).getNombre());
                u.setDescripcion(lista2.get(i).getDescripcion());
                u.setEstado(lista2.get(i).getEstado());
                u.setStock(lista2.get(i).getStock());
                u.setPrecio(lista2.get(i).getPrecio());
                u.setGrasas(lista2.get(i).getGrasas());
                u.setProteinas(lista2.get(i).getProteinas());
                u.setAzucares(lista2.get(i).getAzucares());
                u.setCalorias(lista2.get(i).getCalorias());

                lista.add(u);

            }

            Gson gson = new Gson();

            List<String> jsonString = new ArrayList<String>();
            
            for(int i = 0; i < lista.size(); i++){
                jsonString.add(gson.toJson(lista.get(i)));
            }
            
            FileWriter fileWriter = new FileWriter("productos.json");
            
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
