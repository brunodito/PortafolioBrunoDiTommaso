package pd8;

public class Marcapasos {
    private Short presionSanguinea;
    private Short frecuenciaCardiaca;
    private Short nivelAzucarSangre;
    private Integer maximaFuerzaExpuesta;
    private Float minimoTiempoLatidos;
    private Double bateriaRestante;
    private char[] codigoFabricante = new char[8];

    public Marcapasos(short presion, short frecuencia, short azucar, int fuerza, float tiempo, double bateria, String codigo){
        this.presionSanguinea = presion;
        this.frecuenciaCardiaca = frecuencia;
        this.nivelAzucarSangre = azucar;
        this.maximaFuerzaExpuesta = fuerza;
        this.minimoTiempoLatidos = tiempo;
        this.bateriaRestante = bateria;
        System.arraycopy(codigo.toCharArray(), 0, this.codigoFabricante,0, Math.min(codigo.length(), 8));
    }

    public void mostrarDatos() {
        System.out.println("Presión Sanguínea: " + presionSanguinea);
        System.out.println("Frecuencia Cardíaca: " + frecuenciaCardiaca);
        System.out.println("Nivel de Azúcar: " + nivelAzucarSangre);
        System.out.println("Máxima Fuerza: " + maximaFuerzaExpuesta);
        System.out.println("Mínimo Tiempo entre Latidos: " + minimoTiempoLatidos);
        System.out.println("Batería Restante: " + bateriaRestante);
        System.out.println("Código del Fabricante: " + new String(codigoFabricante));
    }
}
