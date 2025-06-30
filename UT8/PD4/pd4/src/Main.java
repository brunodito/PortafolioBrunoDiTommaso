
public class Main {

    public static void main(String[] args) {
        TGrafoNoDirigido gnd = UtilGrafos.cargarGrafo("UT8\\PD4\\pd4\\src\\pruebaV.txt", "UT8\\PD4\\pd4\\src\\pruebaA.txt", false, TGrafoNoDirigido.class);
        System.out.println("Cantidad de vértices cargados: " + gnd.getVertices().size());
        gnd.imprimirCostoCaminos();
        System.out.println(gnd.conectados("cc1", "cc5"));
    }
}
