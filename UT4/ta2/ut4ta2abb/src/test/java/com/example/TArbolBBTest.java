package com.example;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import org.junit.Test;


public class TArbolBBTest {

    @Test
    public void TamañoArbolVacioTest()
    {
        TArbolBB arbol = new TArbolBB<>();
        int tamañoEsperado = 0;
        assertEquals(tamañoEsperado, arbol.getTamaño());
    }

    @Test
    public void TamañoArbolUnNodoTest()
    {
        TArbolBB arbol = new TArbolBB<>();
        arbol.insertar(5, 5);
        int tamañoEsperado = 1;
        assertEquals(tamañoEsperado, arbol.getTamaño());
    }

    @Test
    public void TamañoArbolVariosNodoTest()
    {
        TArbolBB arbol = new TArbolBB<>();
        arbol.insertar(5, 5);
        arbol.insertar(3, 3);
        arbol.insertar(8, 8);
        arbol.insertar(7, 7);
        arbol.insertar(2, 2);
        arbol.insertar(4, 4);
        arbol.insertar(6, 6);
        int tamañoEsperado = 7;
        assertEquals(tamañoEsperado, arbol.getTamaño());
    }

    @Test
    public void AlturaArbolVacioTest()
    {
        TArbolBB arbol = new TArbolBB<>();
        int alturaEsperada = 0;
        assertEquals(alturaEsperada, arbol.getAltura());
    }

    @Test
    public void AlturaArbolUnNodoTest()
    {
        TArbolBB arbol = new TArbolBB<>();
        arbol.insertar(5, 5);
        int alturaEsperada = 1;
        assertEquals(alturaEsperada, arbol.getAltura());
    }

    @Test
    public void AlturaArbolVariosNodosTest()
    {
        TArbolBB arbol = new TArbolBB<>();
        arbol.insertar(5, 5);
        arbol.insertar(3, 3);
        arbol.insertar(8, 8);
        arbol.insertar(7, 7);
        arbol.insertar(2, 2);
        arbol.insertar(4, 4);
        arbol.insertar(6, 6);
        int alturaEsperada = 4;
        assertEquals(alturaEsperada, arbol.getAltura());
    }


    @Test
    public void testGetNivel_ArbolVacio() {
        TArbolBB<String> arbol = new TArbolBB<>(); 
        int clave = 10;
        assertEquals(0, arbol.getNivel(clave)); 
    }

    @Test
    public void testGetNivel_NodoNoEnArbol() {
        TArbolBB<String> arbol = new TArbolBB<>(); 
        arbol.insertar(3, "Etiqueta 3");
        arbol.insertar(2, "Etiqueta 2");
        int clave = 5;
        assertEquals(0, arbol.getNivel(clave));
    }

    @Test
    public void testGetNivel_NodoEnRaiz() {
        TArbolBB<String> arbol = new TArbolBB<>();
        int clave = 10;
        arbol.insertar(clave, "Raíz");
        assertEquals(1, arbol.getNivel(clave));
    }

   

    @Test
    public void testGetNivel_NodoEnHoja() {
        TArbolBB<String> arbol = new TArbolBB<>();
        int clave = 5; 
        arbol.insertar(10, "Raíz"); 
        arbol.insertar(3, "Etiqueta 3");
        arbol.insertar(clave, "Etiqueta 5");
        assertEquals(3, arbol.getNivel(clave));
    }

    @Test
    public void testGetNivel_NodoEnNodoInterno() {
        TArbolBB<String> arbol = new TArbolBB<>();
        int clave = 5; 
        arbol.insertar(10, "Raíz"); 
        arbol.insertar(3, "Etiqueta 3");
        arbol.insertar(7, "Etiqueta 7");
        arbol.insertar(clave, "Nodo interno");
        arbol.insertar(8, "Etiqueta 8");
        arbol.insertar(6, "Etiqueta 6");
        arbol.insertar(4, "Etiqueta 4");

        assertEquals(4, arbol.getNivel(clave)); 
    }

    @Test
    public void testCantHojas_ArbolVacio() {
        TArbolBB<String> arbol = new TArbolBB<>();
        assertEquals(0, arbol.cantHojas()); 
    }

    @Test
    public void testCantHojas_UnNodoHoja() {
        TArbolBB<String> arbol = new TArbolBB<>(); 
        arbol.insertar(5, "Hoja"); 
        assertEquals(1, arbol.cantHojas());
    }

    @Test
    public void testCantHojas_VariosNodosConHojas() {
        TArbolBB<String> arbol = new TArbolBB<>();
        arbol.insertar(6, "Raíz");
        arbol.insertar(5, "NodoInterno1");
        arbol.insertar(8, "NodoInterno2");
        arbol.insertar(2, "NodoInterno3");
        arbol.insertar(9, "NodoInterno4");
        arbol.insertar(7, "Hoja1");
        arbol.insertar(4, "Hoja2");
        arbol.insertar(0, "Hoja3");
        arbol.insertar(18, "Hoja4");
        assertEquals(4, arbol.cantHojas()); 
    }

    @Test
    public void testEliminar_ArbolVacio() {
        TArbolBB<String> arbol = new TArbolBB<>();
        assertNull(arbol.eliminar(10)); 
    }

    @Test
    public void testEliminar_RaizConHijos() {
        TArbolBB<String> arbol = new TArbolBB<>(); 
        arbol.insertar(10, "Raíz");
        arbol.insertar(5, "Izquierda");
        arbol.insertar(15, "Derecha");
        assertNotNull(arbol.eliminar(10));
        assertNull(arbol.buscar(10));
        assertTrue((Integer)arbol.raiz.getEtiqueta() == 5);
    }

    @Test
    public void testEliminar_RaizSinHijos() {
        TArbolBB<String> arbol = new TArbolBB<>(); 
        arbol.insertar(10, "Raíz");
        assertTrue(arbol.inOrden().equals("10"));
        arbol.eliminar(10);
        assertNull(arbol.buscar(10)); 
    }

    @Test
    public void testEliminar_NodoHoja() {
        TArbolBB<String> arbol = new TArbolBB<>(); 
        arbol.insertar(6, "Raíz");
        arbol.insertar(5, "NodoInterno1");
        arbol.insertar(8, "NodoInterno2");
        arbol.insertar(2, "NodoInterno3");
        arbol.insertar(9, "NodoInterno4");
        arbol.insertar(7, "Hoja1");
        arbol.insertar(4, "Hoja2");
        arbol.insertar(0, "Hoja3");
        arbol.insertar(18, "Hoja4");
        assertNotNull(arbol.eliminar(4)); 
        assertNull(arbol.buscar(4)); 
    }

    @Test
    public void testEliminar_NodoConUnHijo() {
        TArbolBB<String> arbol = new TArbolBB<>(); 
        arbol.insertar(6, "Raíz");
        arbol.insertar(5, "NodoInterno1");
        arbol.insertar(8, "NodoInterno2");
        arbol.insertar(2, "NodoInterno3");
        arbol.insertar(9, "NodoInterno4");
        arbol.insertar(7, "Hoja1");
        arbol.insertar(4, "Hoja2");
        arbol.insertar(0, "Hoja3");
        arbol.insertar(18, "Hoja4");
        assertNotNull(arbol.eliminar(9)); 
        assertNull(arbol.buscar(9));
        assertTrue((Integer)arbol.buscar(8).getHijoDer().getEtiqueta() == 18);
    }

    @Test
    public void testEliminar_NodoConDosHijos() {
        TArbolBB<String> arbol = new TArbolBB<>(); 
        arbol.insertar(6, "Raíz");
        arbol.insertar(5, "NodoInterno1");
        arbol.insertar(8, "NodoInterno2");
        arbol.insertar(2, "NodoInterno3");
        arbol.insertar(9, "NodoInterno4");
        arbol.insertar(7, "Hoja1");
        arbol.insertar(4, "Hoja2");
        arbol.insertar(0, "Hoja3");
        arbol.insertar(18, "Hoja4");
        assertNotNull(arbol.eliminar(2)); 
        assertNull(arbol.buscar(2));
        assertTrue((Integer)arbol.buscar(5).getHijoIzq().getEtiqueta() == 0);
        assertTrue((Integer)arbol.buscar(0).getHijoDer().getEtiqueta() == 4);
    }

    @Test
    public void testPreOrden_ArbolVacio() {
        TArbolBB<String> arbol = new TArbolBB<>(); 
        assertEquals("Arbol vacío", arbol.preOrden());
    }

    @Test
    public void testPreOrden_ArbolConUnNodo() {
        TArbolBB<String> arbol = new TArbolBB<>(); 
        arbol.insertar(4, "Raiz");
        assertEquals("4", arbol.preOrden());
    }

    @Test
    public void testPreOrden_ArbolGrande() {
        TArbolBB<String> arbol = new TArbolBB<>(); 
        arbol.insertar(6, "Raíz");
        arbol.insertar(5, "NodoInterno1");
        arbol.insertar(8, "NodoInterno2");
        arbol.insertar(2, "NodoInterno3");
        arbol.insertar(9, "NodoInterno4");
        arbol.insertar(7, "Hoja1");
        arbol.insertar(4, "Hoja2");
        arbol.insertar(0, "Hoja3");
        arbol.insertar(18, "Hoja4");
        assertEquals("6-5-2-0-4-8-7-9-18", arbol.preOrden());
    }    


    @Test
    public void testInOrden_ArbolVacio() {
        TArbolBB<String> arbol = new TArbolBB<>(); 
        assertEquals("Arbol vacío", arbol.inOrden());
    }

    @Test
    public void testInOrden_ArbolConUnNodo() {
        TArbolBB<String> arbol = new TArbolBB<>(); 
        arbol.insertar(4, "Raiz");
        assertEquals("4", arbol.inOrden());
    }

    @Test
    public void testInOrden_ArbolGrande() {
        TArbolBB<String> arbol = new TArbolBB<>(); 
        arbol.insertar(6, "Raíz");
        arbol.insertar(5, "NodoInterno1");
        arbol.insertar(8, "NodoInterno2");
        arbol.insertar(2, "NodoInterno3");
        arbol.insertar(9, "NodoInterno4");
        arbol.insertar(7, "Hoja1");
        arbol.insertar(4, "Hoja2");
        arbol.insertar(0, "Hoja3");
        arbol.insertar(18, "Hoja4");
        assertEquals("0-2-4-5-6-7-8-9-18", arbol.inOrden());
    }

    @Test
    public void testPostOrden_ArbolVacio() {
        TArbolBB<String> arbol = new TArbolBB<>(); 
        assertEquals("Arbol vacío", arbol.postOrden());
    }

    @Test
    public void testPostOrden_ArbolConUnNodo() {
        TArbolBB<String> arbol = new TArbolBB<>(); 
        arbol.insertar(4, "Raiz");
        assertEquals("4", arbol.postOrden());
    }

    @Test
    public void testPostOrden_ArbolGrande() {
        TArbolBB<String> arbol = new TArbolBB<>(); 
        arbol.insertar(6, "Raíz");
        arbol.insertar(5, "NodoInterno1");
        arbol.insertar(8, "NodoInterno2");
        arbol.insertar(2, "NodoInterno3");
        arbol.insertar(9, "NodoInterno4");
        arbol.insertar(7, "Hoja1");
        arbol.insertar(4, "Hoja2");
        arbol.insertar(0, "Hoja3");
        arbol.insertar(18, "Hoja4");
        assertEquals("0-4-2-5-7-18-9-8-6", arbol.postOrden());
    }

    @Test
    public void testBuscar_ArbolVacio() {
        TArbolBB<String> arbol = new TArbolBB<>();
        assertNull(arbol.buscar(10)); 
    }

    @Test
    public void testBuscar_UnicoNodoDeUnArbol() {
        TArbolBB<String> arbol = new TArbolBB<>(); 
        arbol.insertar(10, "Raíz");
        assertTrue(arbol.buscar(10).getDatos() == "Raíz");
    }

    @Test
    public void testBuscar_NodoHoja() {
        TArbolBB<String> arbol = new TArbolBB<>(); 
        arbol.insertar(6, "Raíz");
        arbol.insertar(5, "NodoInterno1");
        arbol.insertar(8, "NodoInterno2");
        arbol.insertar(2, "NodoInterno3");
        arbol.insertar(9, "NodoInterno4");
        arbol.insertar(7, "Hoja1");
        arbol.insertar(4, "Hoja2");
        arbol.insertar(0, "Hoja3");
        arbol.insertar(18, "Hoja4");
        assertTrue(arbol.buscar(4).getDatos() == "Hoja2"); 
        assertTrue(arbol.buscar(18).getDatos() == "Hoja4"); 
        assertTrue(arbol.buscar(7).getDatos() == "Hoja1"); 
        assertTrue(arbol.buscar(0).getDatos() == "Hoja3"); 
    }

    @Test
    public void testBuscar_NodoConUnHijo() {
        TArbolBB<String> arbol = new TArbolBB<>(); 
        arbol.insertar(6, "Raíz");
        arbol.insertar(5, "NodoInterno1");
        arbol.insertar(8, "NodoInterno2");
        arbol.insertar(2, "NodoInterno3");
        arbol.insertar(9, "NodoInterno4");
        arbol.insertar(7, "Hoja1");
        arbol.insertar(4, "Hoja2");
        arbol.insertar(0, "Hoja3");
        arbol.insertar(18, "Hoja4");
        assertTrue(arbol.buscar(5).getDatos() == "NodoInterno1"); 
        assertTrue(arbol.buscar(9).getDatos() == "NodoInterno4"); 
    }

    @Test
    public void testBuscar_NodoConDosHijos() {
        TArbolBB<String> arbol = new TArbolBB<>(); 
        arbol.insertar(6, "Raíz");
        arbol.insertar(5, "NodoInterno1");
        arbol.insertar(8, "NodoInterno2");
        arbol.insertar(2, "NodoInterno3");
        arbol.insertar(9, "NodoInterno4");
        arbol.insertar(7, "Hoja1");
        arbol.insertar(4, "Hoja2");
        arbol.insertar(0, "Hoja3");
        arbol.insertar(18, "Hoja4");
        assertTrue(arbol.buscar(2).getDatos() == "NodoInterno3"); 
        assertTrue(arbol.buscar(8).getDatos() == "NodoInterno2"); 
        assertTrue(arbol.buscar(6).getDatos() == "Raíz"); 
    }

    @Test
    public void testBuscar_NodoInexistente() {
        TArbolBB<String> arbol = new TArbolBB<>(); 
        arbol.insertar(6, "Raíz");
        arbol.insertar(5, "NodoInterno1");
        arbol.insertar(8, "NodoInterno2");
        arbol.insertar(2, "NodoInterno3");
        arbol.insertar(9, "NodoInterno4");
        arbol.insertar(7, "Hoja1");
        arbol.insertar(4, "Hoja2");
        arbol.insertar(0, "Hoja3");
        arbol.insertar(18, "Hoja4");
        assertNull(arbol.buscar(25)); 
        assertNull(arbol.buscar(1)); 
        assertNull(arbol.buscar(-7)); 
        assertNull(arbol.buscar(10)); 
        arbol.eliminar(8);
        assertNull(arbol.buscar(8)); 
    }


    @Test
    public void testInsertar_EnArbolVacio() {
        TArbolBB<String> arbol = new TArbolBB<>();
        assertTrue(arbol.insertar(10, "Dato")); 
        assertEquals("Dato", arbol.buscar(10).getDatos());
        assertEquals("10", arbol.inOrden());
    }

    @Test
    public void testInsertar_EtiquetaExistente() {
        TArbolBB<String> arbol = new TArbolBB<>();
        arbol.insertar(10, "Dato");
        assertFalse(arbol.insertar(10, "OtroDato")); 
        assertEquals("Dato", arbol.buscar(10).getDatos());
        assertEquals("10", arbol.inOrden());
    }

    @Test
    public void testInsertar_EnArbolNoVacio() {
        TArbolBB<String> arbol = new TArbolBB<>();
        arbol.insertar(10, "Raíz");
        assertTrue(arbol.insertar(5, "Izquierda"));
        assertTrue(arbol.insertar(15, "Derecha"));
        assertEquals("Izquierda", arbol.buscar(5).getDatos());
        assertEquals("Derecha", arbol.buscar(15).getDatos());
        assertTrue(arbol.inOrden().equals("5-10-15"));
    }

    @Test
    public void testInsertar_EnArbolGrande() {
        TArbolBB<String> arbol = new TArbolBB<>(); 
        arbol.insertar(6, "Raíz");
        assertTrue(arbol.postOrden().equals("6"));
        arbol.insertar(5, "NodoInterno1");
        assertTrue(arbol.postOrden().equals("5-6"));
        arbol.insertar(8, "NodoInterno2");
        assertTrue(arbol.postOrden().equals("5-8-6"));
        arbol.insertar(2, "NodoInterno3");
        assertTrue(arbol.postOrden().equals("2-5-8-6"));
        arbol.insertar(9, "NodoInterno4");
        assertTrue(arbol.postOrden().equals("2-5-9-8-6"));
        arbol.insertar(7, "Hoja1");
        assertTrue(arbol.postOrden().equals("2-5-7-9-8-6"));
        arbol.insertar(4, "Hoja2");
        assertTrue(arbol.postOrden().equals("4-2-5-7-9-8-6"));
        arbol.insertar(0, "Hoja3");
        assertTrue(arbol.postOrden().equals("0-4-2-5-7-9-8-6"));
        arbol.insertar(18, "Hoja4");
        assertTrue(arbol.postOrden().equals("0-4-2-5-7-18-9-8-6"));
    }

}