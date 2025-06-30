/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uy.edu.ucu.aed;

/**
 *
 * @author jechague
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Hash tablaHash = new Hash(100);
        String[] claves = ManejadorArchivosGenerico.leerArchivo("PortafolioBrunoDiTommaso\\UT6\\PD2\\PD2\\src\\main\\java\\uy\\edu\\ucu\\aed\\claves_insertar.txt"); 
        int contador = 0;
        int contador70 = 0;  

        for (String clave : claves) {
            int c = Integer.parseInt(clave);
            int comp = tablaHash.insertar(c);
            //System.out.println(comp);
            contador70 += comp;
            contador ++;
            if(contador == 69){
                break;
            }
        }
        //System.out.println(contador70 / 100);
        for(int i=70; i<90; i++){
            int c = Integer.parseInt(claves[i]);
            int comp = tablaHash.insertar(c);
            System.out.println(comp);

        }
    }
    
    
}
