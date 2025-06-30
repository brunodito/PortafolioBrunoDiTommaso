package pd9;

import java.util.List;
import java.util.Stack;

public class Corchetes {

    public static boolean controlCorchetes(List<Character> listaDeEntrada) {
        Stack<Character> stack = new Stack<>();
        
        // Recorremos cada caracter de la lista de entrada
        for (char c : listaDeEntrada) {
            if (c == '{') {
                stack.push(c);
            } else if (c == '}') {
                if (stack.isEmpty()) {
                    return false;
                }
                stack.pop();
            }
        }
        
        return stack.isEmpty();
    }
}

