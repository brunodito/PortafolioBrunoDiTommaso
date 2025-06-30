package uy.edu.ucu.aed;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Almacen{
    String direccion;
    String telefono;
    String nombre;
    Lista<IProducto> listaProductos;
    long valorStock;


    public String getDireccion()
    {
        return direccion;
    }

    public void setDireccion(String direccion)
    {
        this.direccion = direccion;
    }

    public String getTelefono()
    {
        return telefono;
    }

    public void setTelefono(String telefono)
    {
        this.telefono = telefono;
    }

    public String getNombre()
    {
        return nombre;
    }

    public void obtenerProducto(){
        ManejadorArchivosGenerico archivo = new ManejadorArchivosGenerico();
        String[] contenido = archivo.leerArchivo("altas.txt");
        for (String linea : contenido){
            String[] partes = linea.split(",",3);
            
        }
    }

    public void agregarProducto(Comparable codProducto, int precio, int stock){
    }

    public Lista<IProducto> getListaProductos() {
        return listaProductos;
    }
    
    public long obtenerValorStock()
    {
        return valorStock;
    }

    public Integer restarStock(Comparable codProducto, Integer cantidad)
    {
        IProducto producto = buscarPorCodigo(codProducto);
        producto.restarCantidadStock(cantidad);
        return producto.getStock();

    }

    public IProducto buscarPorCodigo(Comparable codProducto)
    {
        return listaProductos.buscar(codProducto);
    }

    public void realizarVentas(String path) throws IOException
    {
        File archivo = new File(path);
        FileReader fr = new FileReader(archivo);
        BufferedReader br = new BufferedReader(fr);
        
        String lineaActual = br.readLine();
        while(lineaActual != null)
        {
            lineaActual = br.readLine();
            String[] lineaSeparada = lineaActual.split(",");
            restarStock(lineaSeparada[0], Integer.parseInt(lineaSeparada[1]));
        }
        
    }
}
