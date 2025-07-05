import java.util.Collection;

public class Main {

    public static void main(String[] args) {
        TGrafoNoDirigido gnd = UtilGrafos.cargarGrafo("C:\\Users\\bruni\\OneDrive\\Documents\\Facultad\\Algoritmos 2ndo AÑO\\UT8\\PD4\\pd4\\src\\pruebaV.txt","C:\\Users\\bruni\\OneDrive\\Documents\\Facultad\\Algoritmos 2ndo AÑO\\UT8\\PD4\\pd4\\src\\pruebaA.txt", false, TGrafoNoDirigido.class);
        Collection<TVertice> pruebaBea = gnd.bea();
        System.out.println("");

        /*Pruebas*/
        TGrafoNoDirigido grafoND = UtilGrafos.cargarGrafo("C:\\Users\\bruni\\OneDrive\\Documents\\Facultad\\Algoritmos 2ndo AÑO\\UT8\\PD4\\pd4\\src\\pruebaV.txt", "C:\\Users\\bruni\\OneDrive\\Documents\\Facultad\\Algoritmos 2ndo AÑO\\UT8\\PD4\\pd4\\src\\pruebaA.txt", false, TGrafoNoDirigido.class);
        TGrafoDirigido grafoD = UtilGrafos.cargarGrafo("C:\\Users\\bruni\\OneDrive\\Documents\\Facultad\\Algoritmos 2ndo AÑO\\UT8\\PD4\\pd4\\src\\pruebaV.txt", "C:\\Users\\bruni\\OneDrive\\Documents\\Facultad\\Algoritmos 2ndo AÑO\\UT8\\PD4\\pd4\\src\\pruebaA.txt", true, TGrafoDirigido.class);

        System.out.println("Grafo no dirigido:");
        grafoND.imprimir();

        System.out.println("\n¿Grafo dirigido es fuertemente conexo?");
        System.out.println(grafoD.esFuertementeConexo() ? "Sí" : "No");

        String origen = "A";
        String destino = "D";

        System.out.println("\nCaminos desde " + origen + " a " + destino + " en grafo dirigido:");
        Collection<TCamino> caminos = (Collection<TCamino>) grafoD.todosLosCaminos(origen, destino);
        for (TCamino c : caminos) {
            System.out.println(c.imprimirEtiquetas() + " - Costo: " + c.getCostoTotal());
        }

        System.out.println("\nÁrbol de expansión mínima con PRIM");
        TGrafoNoDirigido agm = grafoND.Prim(origen);
        agm.imprimir();

        // === GUARDAR RESULTADOS EN ARCHIVO ===
        ManejadorArchivosGenerico.escribirArchivo("salida/caminos.txt", 
            caminos.stream().map(TCamino::imprimirEtiquetas).toArray(String[]::new)
        );
    }
}
