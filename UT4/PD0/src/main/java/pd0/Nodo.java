package pd0;

public class Nodo {
    String valor;
    Nodo izquierdo, derecho;

    public Nodo(String valor) {
        this.valor = valor;
        this.izquierdo = null;
        this.derecho = null;
    }

    public boolean esHoja() {
        return izquierdo == null && derecho == null;
    }
}
