package pd7;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Trie trie = new Trie();

        try (BufferedReader br = new BufferedReader(new FileReader("abonados.txt"))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] partes = linea.split(",");
                String numero = partes[0];
                String nombre = partes[1];
                trie.insertar(numero, nombre);
            }
        } catch (IOException e) {
            System.err.println("Error al leer abonados.txt: " + e.getMessage());
        }

        try (BufferedReader br = new BufferedReader(new FileReader("codigos.txt"));
             BufferedWriter bw = new BufferedWriter(new FileWriter("salida.txt"))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] partes = linea.split(",");
                String codigoPais = partes[0];
                String codigoArea = partes[1];
                List<Abonado> abonados = trie.buscarTelefonos(codigoPais, codigoArea);

                for (Abonado abonado : abonados) {
                    bw.write(abonado.toString());
                    bw.newLine();
                }
            }
        } catch (IOException e) {
            System.err.println("Error con archivos de entrada/salida: " + e.getMessage());
        }
    }
}
