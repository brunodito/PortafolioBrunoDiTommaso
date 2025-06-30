package pd2;

public class Main {
    public static void main(String[] args) {
        //Ejercicio 1
        System.out.println("-----------------Ejercicio 1-----------------");
        System.out.println("factorial(4) = " + FactorialRecursivo.calcular(4));
        System.out.println("factorial(5) = " + FactorialRecursivo.calcular(5)); 
        System.out.println("factorial(0) = " + FactorialRecursivo.calcular(0)); 

        try {
            System.out.println("factorial(-3) = " + FactorialRecursivo.calcular(-3));
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }

        //Ejercicio 2
        System.out.println("-----------------Ejercicio 2-----------------");
        int[] A = {2, 4, 6, 8};

        System.out.println("Suma lineal(A, 3) = " + SumaLineal.sumaL(A,3));
        System.out.println("Suma lineal(A, 4) = " + SumaLineal.sumaL(A, 4));

        try {
            System.out.println("Suma lineal(A, -2) = " + SumaLineal.sumaL(A, -2));
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        int[] vacio = {};
        System.out.println("Suma lineal(vacio, 0) = " + SumaLineal.sumaL(vacio, 0));

        //Ejercicio 3
        System.out.println("-----------------Ejercicio 3-----------------");
        System.out.println("2^3 = " + PotenciaNumero.Potencia(2, 3)); 
        System.out.println("5^0 = " + PotenciaNumero.Potencia(5, 0));  
        System.out.println("2^-2 = " + PotenciaNumero.Potencia(2, -2));  
        System.out.println("(-2)^3 = " + PotenciaNumero.Potencia(-2, 3)); 

        //Ejercicio 4
        System.out.println("-----------------Ejercicio 4-----------------");
        int[] v1 = {1, 2, 3, 4, 5};
        InvertirVector.invertir(v1, 0, v1.length - 1);
        InvertirVector.imprimir(v1);

        int[] v2 = {10};
        InvertirVector.invertir(v2, 0, 0);
        InvertirVector.imprimir(v2);

        int[] v3 = {};
        InvertirVector.invertir(v3, 0, 0);
        InvertirVector.imprimir(v3);

        int[] v4 = {7, 8, 9};
        InvertirVector.invertir(v4, 1, 2);
        InvertirVector.imprimir(v4);
    }
}
