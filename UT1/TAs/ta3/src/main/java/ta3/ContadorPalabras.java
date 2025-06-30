package ta3;

public class ContadorPalabras {
    public String contarPalabras(String frase) {
        int contador = 0;
        int aux = 0;
        int consonante = 0;
        int vocal = 0;
        String vocales = "AEIOUaeiou";
        for (int i = 0; i < frase.length(); i++) {

            char letra = frase.charAt(i);

            if (Character.isLetter(letra)) {
                aux++;
                if (vocales.contains(Character.toString(letra))) {
                    vocal++;
                } else {
                    consonante++;
                }

            }
            if (frase.charAt(i) == ' ' && (aux > 0)) {
                contador++;
                aux = 0;
            }

        }

        if (aux != 0) {
            contador++;
        }
        System.out.println("vocales: " + vocal + " consonante: " + consonante);
        return "palabras: " + contador;
    }
}