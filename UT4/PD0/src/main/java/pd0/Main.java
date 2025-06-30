package pd0;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class Main {
    public static void main(String[] args) {
        try {
            String expresion = "+ x * 3 y";
            Queue<String> tokens = new LinkedList<>(Arrays.asList(expresion.split(" ")));
            ArbolExpresion arbol = new ArbolExpresion();
            arbol.raiz = arbol.construirDesdePrefijo(tokens);

            Map<String, String> valores = new HashMap<>();
            valores.put("x", "5");
            valores.put("y", "2");

            arbol.sustituirVariables(arbol.raiz, valores);

            double resultado = arbol.evaluar(arbol.raiz);
            System.out.println("Resultado: " + resultado); //5 + (3*2) = 11

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
