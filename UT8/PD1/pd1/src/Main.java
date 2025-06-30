import java.util.Collection;

public class Main {

    public static void main(String[] args) {
        TGrafoNoDirigido gnd = UtilGrafos.cargarGrafo("C:\\Users\\bruni\\OneDrive\\Documents\\Facultad\\Algoritmos 2ndo AÑO\\UT8\\PD4\\pd4\\src\\pruebaV.txt","C:\\Users\\bruni\\OneDrive\\Documents\\Facultad\\Algoritmos 2ndo AÑO\\UT8\\PD4\\pd4\\src\\pruebaA.txt", false, TGrafoNoDirigido.class);
        Collection<TVertice> pruebaBea = gnd.bea();
        System.out.println("");
    }
}
