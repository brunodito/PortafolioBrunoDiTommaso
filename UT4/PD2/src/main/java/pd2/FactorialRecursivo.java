package pd2;

public class FactorialRecursivo {
    public static long calcular(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("El número no puede ser negativo.");
        }
        if (n == 0) {
            return 1; // Caso base
        }
        return n * calcular(n - 1); // Recursividad
    }
}


//PSEUDOCODIGO

/*
 Algoritmo calcular(n)
    Si n < 0 entonces
        devolver "Error: número negativo"
    Si n == 0 entonces                        
        devolver 1                            // Caso base
    Sino
        devolver n * calcular(n - 1)          // Recursividad
FinAlgoritmo
 */