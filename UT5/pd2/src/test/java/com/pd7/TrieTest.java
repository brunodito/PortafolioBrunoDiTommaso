package com.pd7;

import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

public class TrieTest {

    @Test
    public void testInsercionYBusqueda() {
        Trie trie = new Trie();
        trie.insertar("5989912345", "Pedro");
        trie.insertar("5989923456", "Ana");
        trie.insertar("5989934567", "Luis");

        List<Abonado> abonados = trie.buscarTelefonos("598", "99");
        assertEquals(3, abonados.size());
        assertEquals("Ana", abonados.get(0).getNombre());
        assertEquals("Luis", abonados.get(1).getNombre());
        assertEquals("Pedro", abonados.get(2).getNombre());
    }

    @Test
    public void testBusquedaSinResultados() {
        Trie trie = new Trie();
        trie.insertar("5989912345", "Pedro");

        List<Abonado> abonados = trie.buscarTelefonos("123", "45");
        assertTrue(abonados.isEmpty());
    }
}
