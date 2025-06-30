import java.util.LinkedList;


public class Main {

    /**
     * @param args
     */
    public static void main(String[] args){
        TTrieHashMap trie = new TTrieHashMap();
        TTrieHashMap trie2 = new TTrieHashMap();
        String[] palabrasclave2 = ManejadorArchivosGenerico.leerArchivo("PortafolioBrunoDiTommaso\\UT6\\PD1\\PD1\\src\\palabras.txt");   
        String[] palabrasclave = ManejadorArchivosGenerico.leerArchivo("PortafolioBrunoDiTommaso\\UT6\\PD1\\PD1\\src\\palabras1.txt");
        for (String p : palabrasclave) {
            trie.insertar(p);
        }
        for (String x : palabrasclave2) {
            trie2.insertar(x);
        }
        LinkedList<String> al = trie2.predecir("al");
        LinkedList<String> de = trie.predecir("de");
        for (String string : al) {
            System.out.println(string);
        }
        for (String string : de) {
            System.out.println(string);
        }
    }
}