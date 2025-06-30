package pd2;

public class InvertirVector {
    public static void invertir(int[] A, int i, int j) {
        if (A == null || A.length == 0 || i >= j || i < 0 || j >= A.length) {
            return;
        }
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
        invertir(A, i + 1, j - 1); // Recursividad
    }

    public static void imprimir(int[] A) {
        for (int num : A) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}

//PSEUDO

/*
Algoritmo invertir(A, i, j)
    Si i >= j entonces
        salir
    intercambiar A[i] con A[j]
    invertir(A, i+1, j-1)
FinAlgoritmo
 */
