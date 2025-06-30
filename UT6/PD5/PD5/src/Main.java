import java.util.LinkedList;


public class Main {

    /**
     * @param args
     */
    public static void main(String[] args){
        TTrieHashMap trie = new TTrieHashMap();

        String[] palabrasclave = ManejadorArchivosGenerico.leerArchivo("PortafolioBrunoDiTommaso\\UT6\\PD5\\PD5\\src\\palabras.txt");
        for (String p : palabrasclave) {
                trie.insertar(p);
        }

        LinkedList<String> al = trie.predecir("al");
        for (String string : al) {
            System.out.println(string);
        }
    }
    
}