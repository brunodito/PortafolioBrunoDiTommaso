package pd0;

import java.util.Map;
import java.util.Queue;

public class ArbolExpresion {
    Nodo raiz;

    public ArbolExpresion() {
        this.raiz = null;
    }

    public Nodo construirDesdePrefijo(Queue<String> tokens) throws Exception {
        if (tokens.isEmpty()) throw new Exception("Expresión inválida");
        String token = tokens.poll();
        Nodo nodo = new Nodo(token);
        if (esOperador(token)) {
            nodo.izquierdo = construirDesdePrefijo(tokens);
            nodo.derecho = construirDesdePrefijo(tokens);
        }
        return nodo;
    }

    public void sustituirVariables(Nodo nodo, Map<String, String> mapaValores) {
        if (nodo == null) return;
        if (nodo.esHoja() && mapaValores.containsKey(nodo.valor)) {
            nodo.valor = mapaValores.get(nodo.valor);
        }
        sustituirVariables(nodo.izquierdo, mapaValores);
        sustituirVariables(nodo.derecho, mapaValores);
    }

    public double evaluar(Nodo nodo) {
        if (nodo == null) return 0;
        if (nodo.esHoja()) return Double.parseDouble(nodo.valor);
        double izq = evaluar(nodo.izquierdo);
        double der = evaluar(nodo.derecho);
        switch (nodo.valor) {
            case "+": return izq + der;
            case "-": return izq - der;
            case "*": return izq * der;
            case "/": return izq / der;
            default: throw new IllegalArgumentException("Operador inválido: " + nodo.valor);
        }
    }

    private boolean esOperador(String s) {
        return s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/");
    }
}

