package pd07;

public class Conjunto<T> implements IConjunto<T> {
    private Lista<T> elementos;

    public Conjunto() {
        elementos = new Lista<T>();
    }

    @Override
    public IConjunto<T> union(IConjunto<T> otroConjunto) {
        Conjunto<T> resultado = new Conjunto<>();
        int i = 0, j = 0;
        
        while (i < elementos.cantElementos()() && j < otroConjunto.tamaño()) {
            if (elementos.obtener(i).compareTo(otroConjunto.obtener(j)) < 0) {
                resultado.insertar(elementos.obtener(i));
                i++;
            } else if (elementos.obtener(i).compareTo(otroConjunto.obtener(j)) > 0) {
                resultado.insertar(otroConjunto.obtener(j));
                j++;
            } else {
                resultado.insertar(elementos.obtener(i));
                i++;
                j++;
            }
        }
        
        // Añadir el resto de los elementos
        while (i < elementos.tamaño()) {
            resultado.insertar(elementos.obtener(i));
            i++;
        }
        
        while (j < otroConjunto.tamaño()) {
            resultado.insertar(otroConjunto.obtener(j));
            j++;
        }
        
        return resultado;
    }

    @Override
    public IConjunto<T> interseccion(IConjunto<T> otroConjunto) {
        Conjunto<T> resultado = new Conjunto<>();
        int i = 0, j = 0;
        
        while (i < elementos.tamaño() && j < otroConjunto.tamaño()) {
            if (elementos.obtener(i).compareTo(otroConjunto.obtener(j)) < 0) {
                i++;
            } else if (elementos.obtener(i).compareTo(otroConjunto.obtener(j)) > 0) {
                j++;
            } else {
                resultado.insertar(elementos.obtener(i));
                i++;
                j++;
            }
        }
        
        return resultado;
    }

    @Override
    public void insertar(T dato, Comparable clave) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public T buscar(Comparable clave) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public boolean eliminar(Comparable clave) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public String imprimir() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public String imprimir(String separador) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public int cantElementos() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public boolean esVacia() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
