package uy.edu.ucu.aed;
import uy.edu.ucu.aed.IProducto;

public class Producto implements IProducto{
    Comparable codProducto;
    Integer precio;
    Integer stock;
    String nombre;

    public Comparable getCodProducto()
    {
        return codProducto;
    }

    public Integer getPrecio()
    {
        return precio;
    }

    public void setPrecio(Integer precio)
    {
        this.precio = precio;
    }

    public Integer getStock()
    {
        return stock;
    }

    public void agregarCantidadStock(Integer stock)
    {
        this.stock += stock;
    }

    public void restarCantidadStock(Integer stock)
    {
        if(this.stock < stock)
        {
            this.stock = 0;
        }
        else
        {
            this.stock -= stock;
        }
    }

    public String getNombre()
    {
        return nombre;
    }

    public void setNombre(String nombre)
    {
        this.nombre = nombre;
    }
}
