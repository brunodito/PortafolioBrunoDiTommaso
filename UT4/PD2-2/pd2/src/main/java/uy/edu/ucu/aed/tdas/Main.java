package uy.edu.ucu.aed.tdas;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        // === EJECUCIÓN #2 ===
        System.out.println("== EJECUCIÓN #2 ==");
        TArbolBB arbolPrueba = new TArbolBB();
        cargarArchivoYConstruirABB("UT4\\PD2-2\\pd2\\src\\main\\java\\uy\\edu\\ucu\\aed\\tdas\\claves1.txt", arbolPrueba);
        guardarRecorridos(arbolPrueba, "PRUEBA");

        // === EJECUCIÓN #3 ===
        System.out.println("\n== EJECUCIÓN #3 ==");
        TArbolBB arbolGrande = new TArbolBB();
        cargarArchivoYConstruirABB("UT4\\PD2-2\\pd2\\src\\main\\java\\uy\\edu\\ucu\\aed\\tdas\\claves1.txt", arbolGrande);
        buscarClaves(arbolGrande, new String[]{"10635", "4567", "12", "8978"});
        mostrarDecimaClavePreorden(arbolGrande);
        guardarRecorridos(arbolGrande, "GRANDE");
    }

    private static void cargarArchivoYConstruirABB(String archivo, TArbolBB arbol) {
        String[] lineas = ManejadorArchivosGenerico.leerArchivo(archivo);
        for (String linea : lineas) {
            try {
                int clave = Integer.parseInt(linea.trim());
                arbol.insertar(clave, null);
            } catch (Exception e) {
                System.err.println("Error con clave: " + linea);
            }
        }
    }

    private static void guardarRecorridos(TArbolBB arbol, String sufijo) {
        ManejadorArchivosGenerico.escribirArchivo("preorden_" + sufijo + ".txt", convertirAStringArray(arbol.preOrden()));
        ManejadorArchivosGenerico.escribirArchivo("inorden_" + sufijo + ".txt", convertirAStringArray(arbol.inOrden()));
        ManejadorArchivosGenerico.escribirArchivo("postorden_" + sufijo + ".txt", convertirAStringArray(arbol.postOrden()));
    }

    private static String[] convertirAStringArray(List<Integer> lista) {
        String[] resultado = new String[lista.size()];
        for (int i = 0; i < lista.size(); i++) {
            resultado[i] = lista.get(i).toString();
        }
        return resultado;
    }

    private static void buscarClaves(TArbolBB arbol, String[] claves) {
        for (String claveStr : claves) {
            try {
                int clave = Integer.parseInt(claveStr);
                if (arbol.buscar(clave) != null) {
                    System.out.println("Clave " + clave + " encontrada en el árbol.");
                } else {
                    System.out.println("Clave " + clave + " NO está en el árbol.");
                }
            } catch (NumberFormatException e) {
                System.err.println("Clave inválida: " + claveStr);
            }
        }
    }

    private static void mostrarDecimaClavePreorden(TArbolBB arbol) {
        List<Integer> claves = arbol.preOrden();
        if (claves.size() >= 10) {
            System.out.println("La décima clave en preorden es: " + claves.get(9));
        } else {
            System.out.println("El árbol no tiene 10 claves en preorden.");
        }
    }

}
