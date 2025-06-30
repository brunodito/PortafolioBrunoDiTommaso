package pd2;

public class SumaLineal {
    public static int sumaL(int[] A, int n) {
        if (n < 0) {
            throw new IllegalArgumentException("n no puede ser negativo.");
        }
        if (A.length == 0 || n == 0) {
            return 0;
        }
        return sumaL(A, n - 1) + A[n - 1];
    }
}


//PSEUDO

/*
 Algoritmo SumaL(A, n)
    Si n <= 0 entonces        
        devolver 0            // Caso base
    Sino
        devolver SumaL(A, n - 1) + A[n - 1] // Recursividad
FinAlgoritmo
 */