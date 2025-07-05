package uy.edu.ucu.aed.parcial2;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import uy.edu.ucu.aed.ManejadorArchivosGenerico;
import uy.edu.ucu.aed.TCamino;
import uy.edu.ucu.aed.TCaminos;
import uy.edu.ucu.aed.UtilGrafos;

/**
 * Algoritmo y Estrucutras de Datos
 * Parcial 2 - Parte 3
 *
 */
public class MainParcial2 
{
    public static void main( String[] args )
    {
        // Cargar grafo a partir de archivos de entrada
        TGrafoDeLaRed grafo = UtilGrafos.cargarGrafo("ParcialDe2024\\Parcial1\\src\\main\\java\\uy\\edu\\ucu\\aed\\parcial2\\vertices.txt", "ParcialDe2024\\Parcial1\\src\\main\\java\\uy\\edu\\ucu\\aed\\parcial2\\aristas.txt", false, TGrafoDeLaRed.class, TVerticeDeLaRed.class);

        // Calculo de todos los caminos entre dos vertices
        TCaminos<TNodoDeLaRed> caminos = grafo.todosLosCaminos("Vertice_3", "Vertice_4");
        
        // Escribir archivo de salida con el resultado de la llamada anterior, con los caminos ordenados de menor a mayor costo, uno por línea.
        ManejadorArchivosGenerico mag = new ManejadorArchivosGenerico();
        Collection<TCamino<TNodoDeLaRed>> coleccionCaminos = caminos.getCaminos(); //Consiguo los caminos
        List<TCamino<TNodoDeLaRed>> listaCaminos2 = new ArrayList<>(coleccionCaminos); //Los paso a una lista
        Collections.sort(listaCaminos2, Comparator.comparingDouble(TCamino::getCostoTotal)); //Los ordeno de menor a mayor costo

        List<String> lineas = new ArrayList<>(); //Los agrego a una arrayList para luego pasarselo al manejador de archivos
        for (TCamino<TNodoDeLaRed> camino : listaCaminos2) {
            lineas.add(camino.toString()); 
        }

        mag.escribirArchivo("salida.txt", lineas.toArray(new String[0]));
    }
}
