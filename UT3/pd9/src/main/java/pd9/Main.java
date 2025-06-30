package pd9;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Casos de prueba
        List<Character> expresion1 = Arrays.asList('{', '}', '{', '{', '}', '}');
        List<Character> expresion2 = Arrays.asList('{', '{', '}', '{');
        List<Character> expresion3 = Arrays.asList('}', '{');
        
        // Probar el método
        System.out.println(Corchetes.controlCorchetes(expresion1)); // Debe devolver true
        System.out.println(Corchetes.controlCorchetes(expresion2)); // Debe devolver false
        System.out.println(Corchetes.controlCorchetes(expresion3)); // Debe devolver false
    }
}