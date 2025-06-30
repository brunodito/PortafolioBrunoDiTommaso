package com.example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
       HashMap mapa = Palabras.frecuenciaPalabras("PortafolioBrunoDiTommaso\\UT6\\PD4\\PD4\\src\\main\\java\\com\\example\\libro.txt");
       List<Map.Entry<String, Integer>> entradas = new ArrayList<>(mapa.entrySet());
       entradas.sort((e1, e2) -> e2.getValue().compareTo(e1.getValue()));
       List<Map.Entry<String, Integer>> diez = entradas.subList(0, Math.min(10, entradas.size()));
       for (Map.Entry<String,Integer> entry : diez) {
            System.out.println(entry.getKey() + " "+ entry.getValue());
       }
    }
}