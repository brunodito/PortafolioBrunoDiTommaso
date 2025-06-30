package ta3;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Principal {
    public static void main(String[] args) {
        File pruebaFile = new File("ta3\\src\\main\\java\\ta3\\UT1_TA3_ARCHIVO_EJEMPLO.txt");
        try (FileReader fr = new FileReader(pruebaFile);
            BufferedReader br = new BufferedReader(fr)){
                String linea = br.readLine();
                String frase = "";
                while (linea != null) {
                    frase += " " + linea;
                    linea = br.readLine();
                }
                ContadorPalabras prueba = new ContadorPalabras();
                System.out.println(prueba.contarPalabras(frase));
            } catch (FileNotFoundException e) {
            System.err.println("Error: No se encontró el archivo.");
        } catch (IOException e) {
            System.err.println("Error al leer el archivo.");
        }
    }
}