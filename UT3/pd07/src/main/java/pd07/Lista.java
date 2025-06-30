package pd07;

public class Lista<T> implements ILista<T> {

    private class Nodo<T> {

        private final Comparable etiqueta;
        private T dato;
        private Nodo<T> siguiente;

        public Nodo(Comparable etiqueta, T dato) {
            this.etiqueta = etiqueta;
            this.dato = dato;
            this.siguiente = null;
        }
    }

    private Nodo<T> primero;

    public Lista() {
        primero = null;
    }

    @Override
    public void insertar(T dato, Comparable clave) {
        if (buscar(clave) != null) {
            return;
        }
        Nodo<T> nuevoNodo = new Nodo<>(clave, dato);
        Nodo<T> Actual = primero;
        if (primero == null) {
            primero = nuevoNodo;
        } else {
            while (Actual.siguiente != null) {
                Actual = Actual.siguiente;
            }
            Actual.siguiente = nuevoNodo;
        }
    }

    @Override
    public T buscar(Comparable clave) {
        Nodo<T> Actual = primero;
        while (Actual != null) {
            if (Actual.etiqueta.equals(clave)) {
                return Actual.dato;
            }
            Actual = Actual.siguiente;
        }
        return null;
    }

    @Override
    public boolean eliminar(Comparable clave) {
        if (primero == null)
            return false;

        if (primero.etiqueta.equals(clave)) {
            primero = primero.siguiente;
            return true;
        }
        Nodo<T> Anterior = primero;
        Nodo<T> Actual = primero.siguiente;

        while (Actual != null) {
            if (Actual.etiqueta.equals(clave)) {
                Anterior.siguiente = Actual.siguiente;
                return true;
            }
            Anterior = Actual;
            Actual = Actual.siguiente;
        }
        return false;
    }

    @Override
    public String imprimir() {
        return imprimir(" ");
    }

    @Override
    public String imprimir(String separador) {
        String resultado = "";
        Nodo<T> Actual = primero;

        while (Actual != null) {
            resultado += Actual.etiqueta;
            if (Actual.siguiente != null) {
                resultado += separador;
            }
            Actual = Actual.siguiente;
        }
        return resultado;
    }

    @Override
    public int cantElementos() {
        int contador = 0;
        Nodo<T> Actual = primero;
        while (Actual != null) {
            contador++;
            Actual = Actual.siguiente;
        }
        return contador;
    }

    @Override
    public boolean esVacia() {
        return primero == null;
    }

}
