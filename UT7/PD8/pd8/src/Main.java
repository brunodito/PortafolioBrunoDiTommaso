import java.util.Collection;
import java.util.LinkedList;

public class Main {

    public static void main(String[] args) {
        TGrafoDirigido gd = (TGrafoDirigido) UtilGrafos.cargarGrafo("UT7\\PD8\\pd8\\src\\vertices.txt", "UT7\\PD8\\pd8\\src\\aristas.txt",
                false, TGrafoDirigido.class);
        Collection<TArista> aristasArbol = new LinkedList<>();
        Collection<TArista> arisatsAvance = new LinkedList<>();
        Collection<TArista> aristasRetroceso = new LinkedList<>();
        Collection<TArista> aristasCruzadas = new LinkedList<>();
        gd.clasificarArcos("a", aristasArbol, arisatsAvance, aristasRetroceso, aristasCruzadas);
        gd.imprimirArcos(aristasArbol, arisatsAvance, aristasRetroceso, aristasCruzadas);
    }
}
