package ta02;

import java.util.Arrays;
import java.util.Comparator;

import pd07.Lista;

public class Almacen implements IAlmacen {

    private String direccion;
    private String telefono;
    private String nombre;
    private Lista<IProducto> listaProductos;
    private long valorStock;
    private int cantidadProductos;
    

    @Override
    public String getDireccion() {
        return this.direccion;
    }

    @Override
    public void setDireccion(String direccion) {
        this.direccion=direccion;
    }

    @Override
    public String getTelefono() {
        return this.telefono;
    }

    @Override
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    @Override
    public String getNombre() {
        return this.nombre;
    }

    @Override
    public Lista<IProducto> getListaProductos() {
        return this.listaProductos;
    }

    @Override
    public long obtenerValorStock() {
        if (this.listaProductos == null){
            this.listaProductos = new Lista<IProducto>();
        }
        long total=0;
        String claves = listaProductos.imprimir();
        String[] clavesArray = claves.split(",");
        

        for (int i = 0; i < clavesArray.length; i++) {

            total += buscarPorCodigo(clavesArray[i]).getPrecio().longValue();
        }
        return total;

        
    }

    @Override
    public void insertarProducto(IProducto unProducto) {
        if (this.listaProductos == null){
            this.listaProductos = new Lista<IProducto>();
        }
        this.listaProductos.insertar(unProducto,unProducto.getNombre());
    }

    @Override
    public boolean eliminarProducto(Comparable codProducto) {
        if (this.listaProductos == null){
            this.listaProductos = new Lista<IProducto>();
        }
        this.listaProductos.eliminar(codProducto);
        return true;
    }

    @Override
    public String imprimirProductos() {
        if (this.listaProductos == null){
            this.listaProductos = new Lista<IProducto>();
        }
        return this.listaProductos.imprimir();
    }

    @Override
    public String imprimirSeparador(String separador) {
        if (this.listaProductos == null){
            this.listaProductos = new Lista<IProducto>();
        }
        return this.listaProductos.imprimir(separador);
    }

    @Override
    public Boolean agregarStock(Comparable codProducto, Integer cantidad) {
        if (this.listaProductos == null){
            this.listaProductos = new Lista<IProducto>();
        }
        this.listaProductos.buscar(codProducto).agregarCantidadStock(cantidad);
        return true;
    }

    @Override
    public Integer restarStock(Comparable codProducto, Integer cantidad) {
        if (this.listaProductos == null){
            this.listaProductos = new Lista<IProducto>();
        }
        this.listaProductos.buscar(codProducto).restarCantidadStock(cantidad);
        return this.listaProductos.buscar(codProducto).getStock();
        
    }

    @Override
    public IProducto buscarPorCodigo(Comparable codProducto) {
        if (this.listaProductos == null){
            this.listaProductos = new Lista<IProducto>();
        }
        return this.listaProductos.buscar(codProducto);
    }

    @Override
    public void listarOrdenadoPorNombre() {
        if (this.listaProductos == null){
            this.listaProductos = new Lista<IProducto>();
        }
        String claves = listaProductos.imprimir();
        String[] clavesArray = claves.split(",");
        Producto[] productosOrdenados = new Producto[clavesArray.length];

        for (int i = 0; i < clavesArray.length; i++) {
            productosOrdenados[i] = (Producto) buscarPorCodigo(clavesArray[i]);
        }
        Arrays.sort(productosOrdenados, Comparator.comparing(Producto::getNombre));
        for (Producto producto : productosOrdenados) {
            System.out.println("Nombre: " + producto.getNombre() + " | Stock: " + producto.getStock());
        }
        
    }

    @Override
    public IProducto buscarPorDescripcion(String descripcion) {
        if (this.listaProductos == null){
            this.listaProductos = new Lista<IProducto>();
        }
        return this.buscarPorDescripcion(descripcion);

    }

    @Override
    public int cantidadProductos() {
        if (this.listaProductos == null){
            this.listaProductos = new Lista<IProducto>();
        }
        
        return listaProductos.cantElementos();
    }
   

    
}
