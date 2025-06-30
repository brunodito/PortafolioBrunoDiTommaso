package pd2;

public class PotenciaNumero {
    public static double Potencia(double base, int exponente) {
        if (exponente < 0) {
            return 1.0 / Potencia(base, -exponente); //Recursividad caso exponente negativo
        }
        if (exponente == 0) {
            return 1;  //Caso base
        }
        return base * Potencia(base, exponente - 1); //Recursividad
    }
}

//PSEUDO

/*
Algoritmo Potencia(base, exponente)
    Si exponente < 0 entonces
        devolver 1 / Potencia(base, -exponente)
    Si exponente == 0 entonces
        devolver 1 // Caso base
    Sino
        devolver base * Potencia(base, exponente - 1) //Recursividad
FinAlgoritmo
 */