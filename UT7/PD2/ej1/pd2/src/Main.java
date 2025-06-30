
public class Main {

    public static void main(String[] args) {
        TGrafoDirigido gd = (TGrafoDirigido) UtilGrafos.cargarGrafo("pd2\\src\\Vertices.txt", "pd2\\src\\Aristas.txt",
                false, TGrafoDirigido.class);
        Comparable[][] matriz = UtilGrafos.obtenerMatrizCostos(gd.getVertices());
        //UtilGrafos.imprimirMatriz(matriz, gd.getVertices());
        Comparable[][] matrizFloyd = gd.floyd();
        //UtilGrafos.imprimirMatriz(matrizFloyd, gd.getVertices());
        Comparable centro = gd.centroDelGrafo();
        System.out.println(centro);
    }
}