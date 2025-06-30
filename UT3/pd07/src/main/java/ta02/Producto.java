package ta02;

public class Producto implements IProducto {

    private String NombreProducto;
    private int PrecioProducto;
    private int CodigoProducto;
    private int Stock;

    public Producto(String nombreProducto, int precioProducto, int codigoProducto, int stock) {
        this.NombreProducto = nombreProducto;
        this.PrecioProducto = precioProducto;
        this.CodigoProducto = codigoProducto;
        this.Stock = stock;
    }

    @Override
    public Comparable getCodProducto() {
        return CodigoProducto;
    }

    @Override
    public Integer getPrecio() {
        return PrecioProducto;
    }

    @Override
    public void setPrecio(Integer precio) {
        this.PrecioProducto = precio;
    }

    @Override
    public Integer getStock() {
        return Stock;
    }

    @Override
    public void agregarCantidadStock(Integer stock) {
        this.Stock += stock;
    }

    @Override
    public void restarCantidadStock(Integer stock) {
        this.Stock -= stock;
    }

    @Override
    public String getNombre() {
        return NombreProducto;
    }

    @Override
    public void setNombre(String nombre) {
        this.NombreProducto = nombre;
    }

}
