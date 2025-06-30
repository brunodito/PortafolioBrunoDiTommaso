package pd5;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

public class TestArbolBB {

    @Test
    public void testArbolVacio() {
        IArbolBB arbol = new ArbolBinarioBusqueda();
        assertNull("Error: árbol vacío debe retornar null", arbol.obtenerMenorClave());
    }

    @Test
    public void testInsertarYObtenerMenorClave() {
        IArbolBB arbol = new ArbolBinarioBusqueda();

        // Árbol con un solo nodo
        arbol.insertar(new ElementoABB(10));
        assertEquals("Error: menor debería ser 10", 10, arbol.obtenerMenorClave());

        // Insertar más elementos
        arbol.insertar(new ElementoABB(5));
        arbol.insertar(new ElementoABB(2));
        arbol.insertar(new ElementoABB(1));
        arbol.insertar(new ElementoABB(8));

        assertEquals("Error: menor debería ser 1", 1, arbol.obtenerMenorClave());
    }

    @Test
    public void testInsertarYVerificarOrden() {
        IArbolBB arbol = new ArbolBinarioBusqueda();

        // Árbol con varios elementos
        arbol.insertar(new ElementoABB(20));
        arbol.insertar(new ElementoABB(10));
        arbol.insertar(new ElementoABB(30));

        assertEquals("Error: menor debería ser 10", 10, arbol.obtenerMenorClave());
    }

    @Test
    public void testObtenerMayorClave() {
        IArbolBB arbol = new ArbolBinarioBusqueda();
        assertNull("Error: árbol vacío debe retornar null", arbol.obtenerMayorClave());

        arbol.insertar(new ElementoABB(15));
        assertEquals("Error: mayor debería ser 15", 15, arbol.obtenerMayorClave());

        arbol.insertar(new ElementoABB(10));
        arbol.insertar(new ElementoABB(20));
        arbol.insertar(new ElementoABB(25));

        assertEquals("Error: mayor debería ser 25", 25, arbol.obtenerMayorClave());
    }

    @Test
    public void testObtenerClaveAnterior() {
        IArbolBB arbol = new ArbolBinarioBusqueda();

        arbol.insertar(new ElementoABB(50));
        arbol.insertar(new ElementoABB(30));
        arbol.insertar(new ElementoABB(70));
        arbol.insertar(new ElementoABB(20));
        arbol.insertar(new ElementoABB(40));
        arbol.insertar(new ElementoABB(60));
        arbol.insertar(new ElementoABB(80));

        assertEquals("Error: anterior a 70 debería ser 60", 60, arbol.obtenerClaveAnterior(70));
        assertEquals("Error: anterior a 40 debería ser 30", 30, arbol.obtenerClaveAnterior(40));
        assertNull("Error: anterior a 20 debe ser null", arbol.obtenerClaveAnterior(20)); // Es el menor
        assertNull("Error: anterior a valor inexistente debe ser null", arbol.obtenerClaveAnterior(100)); // No está
    }

    @Test
    public void testContarNodosEnNivel() {
        IArbolBB arbol = new ArbolBinarioBusqueda();

        /*
                10
            /  \
            5    15
            / \     \
            2   7     20
        */

        arbol.insertar(new ElementoABB(10));
        arbol.insertar(new ElementoABB(5));
        arbol.insertar(new ElementoABB(15));
        arbol.insertar(new ElementoABB(2));
        arbol.insertar(new ElementoABB(7));
        arbol.insertar(new ElementoABB(20));

        assertEquals("Error: nivel 0 debería tener 1 nodo", 1, arbol.contarNodosEnNivel(0));
        assertEquals("Error: nivel 1 debería tener 2 nodos", 2, arbol.contarNodosEnNivel(1));
        assertEquals("Error: nivel 2 debería tener 3 nodos", 3, arbol.contarNodosEnNivel(2));
        assertEquals("Error: nivel 3 debería tener 0 nodos", 0, arbol.contarNodosEnNivel(3));
    }

    @Test
    public void testListarHojasConNivel() {
        IArbolBB arbol = new ArbolBinarioBusqueda();

        arbol.insertar(new ElementoABB(10));
        arbol.insertar(new ElementoABB(5));
        arbol.insertar(new ElementoABB(15));
        arbol.insertar(new ElementoABB(2));
        arbol.insertar(new ElementoABB(7));
        arbol.insertar(new ElementoABB(20));

        System.out.println("Esperado (Hojas con nivel):\nHoja: 2 en nivel 2\nHoja: 7 en nivel 2\nHoja: 20 en nivel 2");
        arbol.listarHojasConNivel();
    }

    @Test
    public void testEsABB() {
        IArbolBB arbol = new ArbolBinarioBusqueda();

        // Árbol vacío
        assertTrue("Error: árbol vacío es un ABB", arbol.esABB());

        // Árbol válido
        arbol.insertar(new ElementoABB(10));
        arbol.insertar(new ElementoABB(5));
        arbol.insertar(new ElementoABB(15));
        arbol.insertar(new ElementoABB(3));
        arbol.insertar(new ElementoABB(7));

        assertTrue("Error: el árbol es ABB y debería devolver true", arbol.esABB());

        // Para probar un árbol inválido deberías modificarlo manualmente (setear izquierdo o derecho con nodos fuera de orden),
        // pero eso rompe el encapsulamiento y no es recomendable para test común.
    }

    @Test
    public void testNivelDeClave() {
        IArbolBB arbol = new ArbolBinarioBusqueda();

        /*
                10
            /  \
            5    15
            / \     \
            2   7     20
        */

        arbol.insertar(new ElementoABB(10));
        arbol.insertar(new ElementoABB(5));
        arbol.insertar(new ElementoABB(15));
        arbol.insertar(new ElementoABB(2));
        arbol.insertar(new ElementoABB(7));
        arbol.insertar(new ElementoABB(20));

        assertEquals("Error: nivel de 10 debería ser 0", 0, arbol.nivelDeClave(10));
        assertEquals("Error: nivel de 5 debería ser 1", 1, arbol.nivelDeClave(5));
        assertEquals("Error: nivel de 7 debería ser 2", 2, arbol.nivelDeClave(7));
        assertEquals("Error: nivel de 20 debería ser 2", 2, arbol.nivelDeClave(20));
        assertEquals("Error: clave inexistente debería devolver -1", -1, arbol.nivelDeClave(999));
    }

    @Test
    public void testCantidadHojas() {
        IArbolBB arbol = new ArbolBinarioBusqueda();

        // Árbol vacío
        assertEquals("Error: árbol vacío tiene 0 hojas", 0, arbol.contarHojas());

        /*
                10
            /  \
            5    15
            / \     \
            2   7     20
        */

        arbol.insertar(new ElementoABB(10));
        arbol.insertar(new ElementoABB(5));
        arbol.insertar(new ElementoABB(15));
        arbol.insertar(new ElementoABB(2));
        arbol.insertar(new ElementoABB(7));
        arbol.insertar(new ElementoABB(20));

        assertEquals("Error: debe haber 3 hojas (2, 7, 20)", 3, arbol.contarHojas());
    }

}


