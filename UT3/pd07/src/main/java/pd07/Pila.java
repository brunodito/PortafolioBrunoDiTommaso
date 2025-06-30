package pd07;

public class Pila<T> implements IPila<T> {

    private class Nodo<T> {
        private final Comparable clave;
        private T dato;
        private Nodo<T> siguiente;

        public Nodo(Comparable clave, T dato) {
            this.clave = clave;
            this.dato = dato;
            this.siguiente = null;
        }
    }

    private Nodo<T> tope;

    public Pila() {
        tope = null;
    }

    @Override
    public void push(T dato, Comparable clave) {
        if (buscar(clave) != null)
            return;
        Nodo<T> nuevo = new Nodo<>(clave, dato);
        nuevo.siguiente = tope;
        tope = nuevo;
    }

    @Override
    public T pop() {
        if (esVacia())
            return null;
        T dato = tope.dato;
        tope = tope.siguiente;
        return dato;
    }

    @Override
    public T tope() {
        return (tope != null) ? tope.dato : null;
    }

    @Override
    public void anula() {
        tope = null;
    }

    @Override
    public boolean Vacia() {
        return esVacia();
    }

    // Métodos de ILista<T>

    @Override
    public void insertar(T dato, Comparable clave) {
        push(dato, clave);
    }

    @Override
    public T buscar(Comparable clave) {
        Nodo<T> actual = tope;
        while (actual != null) {
            if (actual.clave.equals(clave)) {
                return actual.dato;
            }
            actual = actual.siguiente;
        }
        return null;
    }

    @Override
    public boolean eliminar(Comparable clave) {
        if (esVacia())
            return false;

        if (tope.clave.equals(clave)) {
            pop();
            return true;
        }

        Nodo<T> anterior = tope;
        Nodo<T> actual = tope.siguiente;

        while (actual != null) {
            if (actual.clave.equals(clave)) {
                anterior.siguiente = actual.siguiente;
                return true;
            }
            anterior = actual;
            actual = actual.siguiente;
        }

        return false;
    }

    @Override
    public String imprimir() {
        return imprimir(" ");
    }

    @Override
    public String imprimir(String separador) {
        StringBuilder resultado = new StringBuilder();
        Nodo<T> actual = tope;
        while (actual != null) {
            resultado.append(actual.clave);
            if (actual.siguiente != null) {
                resultado.append(separador);
            }
            actual = actual.siguiente;
        }
        return resultado.toString();
    }

    @Override
    public int cantElementos() {
        int contador = 0;
        Nodo<T> actual = tope;
        while (actual != null) {
            contador++;
            actual = actual.siguiente;
        }
        return contador;
    }

    @Override
    public boolean esVacia() {
        return tope == null;
    }
}