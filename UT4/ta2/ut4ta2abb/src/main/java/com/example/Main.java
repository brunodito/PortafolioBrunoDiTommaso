package com.example;


public class Main {
    public static void main(String[] args) {
        String[] lineasArchivo = ManejadorArchivos.leerArchivo("");
        TArbolBB arbol = new TArbolBB<>();
        arbol.insertar(12, 12);  
        arbol.insertar(25, 25); 
        arbol.insertar(14, 14); 
        arbol.insertar(1, 1); 
        arbol.insertar(33, 33); 
        arbol.insertar(88, 88); 
        arbol.insertar(45, 45);  
        arbol.insertar(2, 2);  
        arbol.insertar(7, 7);  
        arbol.insertar(66, 66);  
        arbol.insertar(5, 5);  
        arbol.insertar(99, 99);  
        
        System.out.println(arbol.inOrden());
    }
}

