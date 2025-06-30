
public class Main {

    public static void main(String[] args) {
        TGrafoDirigido gd = (TGrafoDirigido) UtilGrafos.cargarGrafo("Juanma\\UT7\\UT7\\PD3\\EJ1\\pd3\\src\\aeropuertos.txt", "ej1\\pd3\\src\\conexiones.txt",
                false, TGrafoDirigido.class);
        Comparable[][] matriz = UtilGrafos.obtenerMatrizCostos(gd.getVertices());
        UtilGrafos.imprimirMatriz(matriz, gd.getVertices());
        Comparable[][] matrizFloyd = gd.floyd();
        UtilGrafos.imprimirMatriz(matrizFloyd, gd.getVertices());
        //System.out.println("");
        //System.out.println("mdo" + gd.obtenerExcentricidad("Montevideo"));
        //System.out.println("cur" + gd.obtenerExcentricidad("Curitiba"));
        //System.out.println("Porto" + gd.obtenerExcentricidad("Porto_Alegre"));
        //gd.bpfConImpresion("Montevideo");
        //TCaminos caminos = gd.todosLosCaminos("Montevideo", "Rio_de_Janeiro");
        //caminos.imprimirCaminosConsola();
    }
}
