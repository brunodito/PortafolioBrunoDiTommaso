package com.example;

import java.util.HashMap;

// elegí un hashMap por el tiempo de acceso a los elementos O(1)

public class Palabras {
    public static HashMap<String, Integer> frecuenciaPalabras(String path){
        HashMap<String, Integer> p = new HashMap<>();
        String[] lineas = ManejadorArchivosGenerico.leerArchivo(path);
        for (String linea : lineas) {
            String[] palabras = linea.split(" ");
            for (String palabra : palabras) {
                palabra.replaceAll("-,.?¿" , "");
                palabra.toLowerCase();
                if(p.containsKey(palabra)){
                    int valor = p.get(palabra);
                    valor ++;
                    p.replace(palabra, valor);
                }
                else{
                    p.put(palabra, 1);
                }
            }
        }
        return p;
    }
}
