package pd8;

public class Main {
    public static void main(String[] args) {
        short presion = 100;
        short frecuencia = 90;
        short azucar = 600;
        int fuerza = 2500000;
        float latidos = 66.7f;
        double bateria = 73.56;
        String codigo = "UY2004AR";

        Marcapasos m = new Marcapasos(presion, frecuencia, azucar, fuerza, latidos, bateria, codigo);
        m.mostrarDatos();
    }
}
