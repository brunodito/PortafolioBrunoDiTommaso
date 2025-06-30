package ta02;

import java.util.ArrayList;
import java.util.List;

import pd07.ILista;
import pd07.Lista;
import ta02.utils.ManejadorArchivosGenerico;

public class VentaProducto {

    public static void main(String[] args) {
        try {
            // Leer el inventario utilizando ManejadorArchivosGenerico
            String[] inventarioArchivo = ManejadorArchivosGenerico.leerArchivo("UT3\\pd07\\src\\main\\java\\ta02\\altas.txt");
            ILista<IProducto> inventario = cargarInventario(inventarioArchivo);

            // Leer las ventas utilizando ManejadorArchivosGenerico
            String[] ventasArchivo = ManejadorArchivosGenerico.leerArchivo("UT3\\pd07\\src\\main\\java\\ta02\\ventas.txt");
            List<Venta> ventas = leerVentas(ventasArchivo);

            // Procesar las ventas
            double montoTotalVendido = 0;
            for (Venta venta : ventas) {
                IProducto producto = inventario.buscar(venta.getNombreProducto());
                if (producto != null && producto.getStock() >= venta.getCantidadVendida()) {
                    // Reducir stock
                    producto.restarCantidadStock(venta.getCantidadVendida());
                    // Calcular monto vendido
                    montoTotalVendido += producto.getPrecio() * venta.getCantidadVendida();
                } else {
                    System.out.println("No hay suficiente stock para " + venta.getNombreProducto());
                }
            }

            // Mostrar monto total vendido
            System.out.println("Monto total vendido: " + montoTotalVendido);

            // Actualizar el inventario en el archivo
            String[] inventarioActualizado = actualizarInventario(inventario);
            ManejadorArchivosGenerico.escribirArchivo("inventario.txt", inventarioActualizado);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Cargar el inventario desde el archivo de texto utilizando la Lista de
    // IProducto
    public static ILista<IProducto> cargarInventario(String[] archivo) {
        ILista<IProducto> inventario = new Lista<>();
        for (String linea : archivo) {
            String[] datos = linea.split(",");
            String codProductoString = datos[0]; // Suponiendo que el código del producto es el primer campo
            int codProducto = Integer.parseInt(codProductoString);
            String nombre = datos[1];
            Integer precio = Integer.parseInt(datos[2]);
            Integer stock = Integer.parseInt(datos[3]);
            IProducto producto = new Producto(nombre, precio, codProducto, stock);
            inventario.insertar(producto, codProducto); // Usamos el código del producto como clave
        }
        return inventario;
    }

    // Leer las ventas desde el archivo de texto
    public static List<Venta> leerVentas(String[] archivo) {
        List<Venta> ventas = new ArrayList<>();
        for (String linea : archivo) {
            String[] datos = linea.split(",");
            String nombreProducto = datos[0];
            int cantidadVendida = Integer.parseInt(datos[1]);
            ventas.add(new Venta(nombreProducto, cantidadVendida));
        }
        return ventas;
    }

    // Actualizar el inventario y devolver el contenido para guardar en el archivo
    public static String[] actualizarInventario(ILista<IProducto> inventario) {
        List<String> lineasInventario = new ArrayList<>();
        Nodo<IProducto> nodo = (Nodo<IProducto>) inventario.buscar("inicio"); // Método para iterar en la lista
        while (nodo != null) {
            IProducto producto = nodo.dato;
            String linea = producto.getCodProducto() + "," + producto.getNombre() + "," + producto.getPrecio() + ","
                    + producto.getStock();
            lineasInventario.add(linea);
            nodo = nodo.siguiente; // Avanzamos al siguiente nodo
        }
        return lineasInventario.toArray(new String[0]);
    }
}
