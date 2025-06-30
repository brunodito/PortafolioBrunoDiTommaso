package pd07;

public class Cola<T> implements ICola<T> {

    public class Nodo<T> {
        private final Comparable clave;
        private T dato;
        private Nodo<T> siguiente;

        public Nodo(Comparable clave, T dato) {
            this.clave = clave;
            this.dato = dato;
            this.siguiente = null;
        }
    }

    private Nodo<T> primero;
    private Nodo<T> ultimo;

    public Cola() {
        primero = null;
        ultimo = null;
    }

    @Override
    public void Anula() {
        primero = null;
        ultimo = null;
    }

    @Override
    public T Frente() {
        return (primero != null) ? primero.dato : null;
    }

    @Override
    public void PoneEnCola(T dato, Comparable clave) {
        if (buscar(clave) != null)
            return;
        Nodo<T> nuevo = new Nodo<>(clave, dato);
        if (esVacia()) {
            primero = nuevo;
        } else {
            ultimo.siguiente = nuevo;
        }
        ultimo = nuevo;
    }

    @Override
    public T QuitaDeCola(Comparable clave) {
        if (esVacia())
            return null;
        T dato = primero.dato;
        primero = primero.siguiente;
        if (primero == null) {
            ultimo = null;
        }
        return dato;
    }

    @Override
    public boolean Vacía() {
        return esVacia();
    }

    // Métodos heredados de ILista<T>

    @Override
    public void insertar(T dato, Comparable clave) {
        PoneEnCola(dato, clave);
    }

    @Override
    public T buscar(Comparable clave) {
        Nodo<T> actual = primero;
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

        if (primero.clave.equals(clave)) {
            QuitaDeCola(clave);
            return true;
        }

        Nodo<T> anterior = primero;
        Nodo<T> actual = primero.siguiente;

        while (actual != null) {
            if (actual.clave.equals(clave)) {
                anterior.siguiente = actual.siguiente;
                if (actual == ultimo) {
                    ultimo = anterior;
                }
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
        Nodo<T> actual = primero;
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
        Nodo<T> actual = primero;
        while (actual != null) {
            contador++;
            actual = actual.siguiente;
        }
        return contador;
    }

    @Override
    public boolean esVacia() {
        return primero == null;
    }
}