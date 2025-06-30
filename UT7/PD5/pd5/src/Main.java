import java.util.Collection;

public class Main {

    public static void main(String[] args) {
        TGrafoDirigido gd = UtilGrafos.cargarGrafo("UT7\\PD5\\pd5\\src\\preubaVAciclico.txt", "UT7\\PD5\\pd5\\src\\pruebaAAciclico.txt", false, TGrafoDirigido.class);
        System.out.println(gd.esAciclico());
        TGrafoDirigido gd2 = UtilGrafos.cargarGrafo("UT7\\PD5\\pd5\\src\\pruebaVComponentes.txt", "UT7\\PD5\\pd5\\src\\PruebaAcomponentes.txt", false, TGrafoDirigido.class);
        Collection<TComponenteConexo> componentes = gd2.ComponentesConexos();
        for (TComponenteConexo componente : componentes) {
            componente.imprimirComponentes();
        }
    }
}
