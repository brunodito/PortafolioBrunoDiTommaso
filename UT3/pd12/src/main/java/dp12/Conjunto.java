package dp12;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ernesto
 * @param <T>
 */
import java.util.*;
import java.io.*;

public class Conjunto implements IConjunto {
    private List<Alumno> alumnos;

    public Conjunto() {
        alumnos = new ArrayList<>();
    }

    @Override
    public void agregar(Alumno alumno) {
        if (!contiene(alumno)) {
            alumnos.add(alumno);
        }
    }

    @Override
    public boolean contiene(Alumno alumno) {
        return alumnos.contains(alumno);
    }

    @Override
    public IConjunto union(IConjunto otro) {
        Conjunto resultado = new Conjunto();
        for (Alumno a : alumnos) {
            resultado.agregar(a);
        }
        for (Alumno a : ((Conjunto) otro).alumnos) {
            resultado.agregar(a); // evita duplicados
        }
        return resultado;
    }

    @Override
    public IConjunto interseccion(IConjunto otro) {
        Conjunto resultado = new Conjunto();
        for (Alumno a : alumnos) {
            if (((Conjunto) otro).contiene(a)) {
                resultado.agregar(a);
            }
        }
        return resultado;
    }

    @Override
    public void guardarEnArchivo(String nombreArchivo) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(nombreArchivo))) {
            for (Alumno a : alumnos) {
                writer.write(a.toString());
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error al guardar archivo: " + e.getMessage());
        }
    }

    @Override
    public void cargarDesdeArchivo(String nombreArchivo) {
        try (BufferedReader reader = new BufferedReader(new FileReader(nombreArchivo))) {
            String linea;
            while ((linea = reader.readLine()) != null) {
                String[] partes = linea.split(",");
                int cod = Integer.parseInt(partes[0]);
                String nombre = partes[1];
                agregar(new Alumno(cod, nombre));
            }
        } catch (IOException e) {
            System.out.println("Error al leer archivo: " + e.getMessage());
        }
    }
}


