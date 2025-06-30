package pd1;

public class Main {
    public static void main(String[] args) {
        double a = 1.0;
        double b = 2.0;
        double c = 3.0;
        //System.out.println(Multsuma.multsuma(a, b, c));

        String recorrer1 = "Hola mundo!";
        System.out.println(OtrasFunciones.recorrer(recorrer1));

        System.out.println(OtrasFunciones.getValor());

        System.out.println(OtrasFunciones.getPrimerCaracter(recorrer1));

        int d = 1;
        System.out.println(OtrasFunciones.paraAString(d));

        Contador count = new Contador();
        count.displayCount();
    }
}