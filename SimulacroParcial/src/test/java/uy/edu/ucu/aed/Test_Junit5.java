package uy.edu.ucu.aed;

import java.util.List;

import org.junit.jupiter.api.AfterEach;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import uy.edu.ucu.aed.parcial.RedDistribucion;
import uy.edu.ucu.aed.tda.Ciudad;
import uy.edu.ucu.aed.tda.Ruta;

/**
 * Unit test for implemented methods.
 */
public class Test_Junit5 {
    String instanceVariable;
    RedDistribucion red;
    Ciudad mvd, c1, c2, c3;

    @BeforeEach
    public void setUp() {
        // Initialize any resources or objects needed for the tests
        instanceVariable = "Value before test";
    }

    @AfterEach
    public void tearDown() {
        // Release any resources or clean up after the tests
        instanceVariable = null;
    }

    /**
     * Sample test in JUnit 5
     */
    @Test
    public void shouldAnswerWithTrueInJUnit5Test() {
        assertTrue(instanceVariable != null);
    }

    @Test
    public void testPrioridadEsRespetada() {
        red.insertarArista(new Ruta("A", "B", 20, true));
        red.insertarArista(new Ruta("A", "C", 5, false));
        red.insertarArista(new Ruta("B", "C", 6, false));

        red.insertarVertice(new Ciudad("A"));
        red.insertarVertice(new Ciudad("B"));
        red.insertarVertice(new Ciudad("C"));

        List<Ruta> resultado = red.construirRedMinimaConPrioridad();
        //boolean contienePrioritaria = resultado.stream().anyMatch(Ruta::isPrioritaria);
        //assertTrue(contienePrioritaria, "Debe incluir al menos una ruta prioritaria si ayuda a conectar");
    }

    @Test
    void testCostoTotalMST() {
        red.insertarArista(new Ruta("Montevideo", "Canelones", 5, true));
        red.insertarArista(new Ruta("Montevideo", "Florida", 10, false));
        red.insertarArista(new Ruta("Canelones", "Rivera", 3, false));
        red.insertarArista(new Ruta("Florida", "Rivera", 2, true));

        List<Ruta> resultado = red.construirRedMinimaConPrioridad();
        //int costoTotal = resultado.stream().mapToInt(Ruta::getCosto).sum();
        //assertEquals(10, costoTotal, "El costo total del MST debería ser 10 (5 + 3 + 2)");
    }

    @Test
    void testNoHayCiclos() {
        red.insertarArista(new Ruta("A", "B", 1, false));
        red.insertarArista(new Ruta("B", "C", 1, false));
        red.insertarArista(new Ruta("C", "A", 1, false)); // Cerraría ciclo

        red.insertarVertice(new Ciudad("A"));
        red.insertarVertice(new Ciudad("B"));
        red.insertarVertice(new Ciudad("C"));

        List<Ruta> resultado = red.construirRedMinimaConPrioridad();
        //assertEquals(2, resultado.size(), "El MST no debe tener ciclos, solo n-1 rutas");
    }
}
