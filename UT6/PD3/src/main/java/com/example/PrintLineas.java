package com.example;
import java.util.ArrayList;
import java.util.Random;

public class PrintLineas {
    public static void imprimir(String path, int numeroLineas){
        Random random = new Random();
        String[] lineas = ManejadorArchivosGenerico.leerArchivo(path);
        ArrayList<String> s = new ArrayList<>(lineas.length);
        for (String l : lineas) {
            s.add(l);
        }
        for(int i = 0; i < numeroLineas; i++){
            int indiceAleatorio = random.nextInt(s.size());
            System.out.println(s.get(indiceAleatorio));
        }
    }
}
