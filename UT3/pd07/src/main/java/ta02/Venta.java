package ta02;

public class Venta {
    private String nombreProducto;
    private int cantidadVendida;

    public Venta(String nombreProducto, int cantidadVendida) {
        this.nombreProducto = nombreProducto;
        this.cantidadVendida = cantidadVendida;
    }

    public String getNombreProducto() {
        return nombreProducto;
    }

    public int getCantidadVendida() {
        return cantidadVendida;
    }
}
