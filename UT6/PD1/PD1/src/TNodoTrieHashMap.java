import java.util.LinkedList;
import java.util.*;
import java.util.Set;

public class TNodoTrieHashMap implements INodoTrie {

    private boolean esPalabra;
    private HashMap<Character, TNodoTrieHashMap> Hijos;

    public TNodoTrieHashMap() {
        Hijos = new HashMap<>();
        esPalabra = false;
    }

    @Override
    public void insertar(String unaPalabra) {
        TNodoTrieHashMap nodoActual = this;
        for (int i = 0; i < unaPalabra.length(); i++) {
            TNodoTrieHashMap hijo = nodoActual.Hijos.get(unaPalabra.charAt(i));
            if (hijo == null) {
                hijo = new TNodoTrieHashMap();
                nodoActual.Hijos.put(unaPalabra.charAt(i), hijo);
            }
            nodoActual = hijo;
        }
        nodoActual.esPalabra = true;
    }

    private void imprimir(String s, TNodoTrieHashMap nodo) {
        if (nodo != null) {
            if (nodo.esPalabra) {
                System.out.println(s);

            }
            Set<Character> claves = nodo.Hijos.keySet();
            for (Character clave : claves) {
                imprimir(s + clave, nodo.Hijos.get(clave));
            }
        }
    }

    @Override
    public void imprimir() {

        imprimir("", this);
    }

    private TNodoTrieHashMap buscarNodoTrie(String s) {
        TNodoTrieHashMap nodoActual = this;
        for (int i = 0; i < s.length(); i++) {
            TNodoTrieHashMap hijo = nodoActual.Hijos.get(s.charAt(i));
            if (hijo == null) {
                return null;
            }
            nodoActual = hijo;
        }
        return nodoActual;
    }

    private void predecir(String s, String prefijo, LinkedList<String> palabras, TNodoTrieHashMap nodo) {
        if (nodo != null) {
            if (nodo.esPalabra) {
                palabras.add(prefijo + s);
            }
            Set<Character> claves = nodo.Hijos.keySet();
            for (Character clave : claves) {
                predecir(s + clave, prefijo, palabras, nodo.Hijos.get(clave));
            }
        }
    }

    @Override
    public void predecir(String prefijo, LinkedList<String> palabras) {
        TNodoTrieHashMap nodo = buscarNodoTrie(prefijo);
        if (nodo != null) {
            predecir("", prefijo, palabras, nodo);
        }
    }

    @Override
    public int buscar(String s) {
        TNodoTrieHashMap nodoActual = this;
        int comparaciones = 0;

        for (int i = 0; i < s.length(); i++) {
            comparaciones++;

            if (nodoActual.Hijos.get(s.charAt(i)) == null) {
                return 0;
            }
            nodoActual = nodoActual.Hijos.get(s.charAt(i));
        }

        if (nodoActual.esPalabra) {
            return comparaciones;
        } else {
            return 0;
        }
    }


    public int obtenerTamanio(){
        int tamaño = 0;
        TNodoTrieHashMap nodo = this;
        Set<Character> claves = nodo.Hijos.keySet();
        for (Character character : claves) {
            tamaño += 1 + nodo.Hijos.get(character).obtenerTamanio();
        }
        return tamaño;
    }
}
