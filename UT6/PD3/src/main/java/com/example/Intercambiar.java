package com.example;

import java.util.Set;
import java.util.HashMap;

public class Intercambiar {
    public static HashMap<String, String> intercambiar(HashMap<String, String> map){
        HashMap<String, String> nuevo = new HashMap<>();
        Set<String> claves = map.keySet();
        for (String clave : claves) {
            nuevo.put(map.get(clave), clave);
        }
        return nuevo;
    }
}
