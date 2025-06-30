package com.example;

import java.util.ArrayList;
import java.util.LinkedList;

public class ImprimirOrdenadas {
    public static void imprimirOrdenadas(String[] palabras){
        LinkedList<String> agregadas = new LinkedList<>();
        String[] ordenadas = new String[palabras.length];
        String menor = "";
        for(int i = 0; i<palabras.length; i++){
            for(int c = 0; c<palabras.length; c++){
                if(! agregadas.contains(palabras[c])){
                    if(menor == ""){
                        menor = palabras[c];
                    }
                    else if(palabras[c].length() < menor.length()){
                        menor = palabras[c];
                    }
                    else if(palabras[c].length() == menor.length()){
                        if(palabras[c].compareTo(menor) < 1){
                            menor = palabras[c];
                        }
                    }
                }
            }
            agregadas.add(menor);
            ordenadas[i] = menor;
            menor = "";
        }
        for(int i = 0; i < ordenadas.length; i++){
            System.out.println(ordenadas[i]);
        }

    }
}
