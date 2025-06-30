

import java.util.LinkedList;


public class TTrieHashMap implements IArbolTrie {

    private TNodoTrieHashMap raiz;
    private String altura = "";
    private int indice = 0;

    @Override
    public void insertar(String palabra) {
        if (raiz == null) {
            raiz = new TNodoTrieHashMap();
        }
        raiz.insertar(palabra, indice);
        indice += palabra.length();
        if(palabra.length() > altura.length()){
            altura = palabra;
        }
    }

    @Override
    public void imprimir() {
        if (raiz != null) {
            raiz.imprimir();
        }
    }

    @Override
    public int buscar(String palabra) {
        if (raiz != null) {
            return raiz.buscar(palabra);
        }
        return 0;
    }

    @Override
    public LinkedList<String> predecir(String prefijo) {
        LinkedList<String> palabras = new LinkedList<>();
        if (raiz != null) {
            raiz.predecir(prefijo, palabras);
        }
        return palabras;
    }

    public int obtenerAltura(){
        return altura.length();
    }

    public int obtenerTamanio(){
        if(raiz != null){
            return raiz.obtenerTamanio();
        }
        return 0;
    }
    
    
}
