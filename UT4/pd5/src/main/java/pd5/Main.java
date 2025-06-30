package pd5;

public class Main {
    public static void main(String[] args) {
        ArbolBinarioBusqueda arbol = new ArbolBinarioBusqueda();

        // Insertamos algunos nodos
        arbol.insertar(new ElementoABB(50));
        arbol.insertar(new ElementoABB(30));
        arbol.insertar(new ElementoABB(70));
        arbol.insertar(new ElementoABB(20));
        arbol.insertar(new ElementoABB(40));
        arbol.insertar(new ElementoABB(60));
        arbol.insertar(new ElementoABB(80));
        arbol.insertar(new ElementoABB(90));
        arbol.insertar(new ElementoABB(100));

        // 1. Obtener la menor clave
        System.out.println("1. Menor clave: " + arbol.obtenerMenorClave());

        // 2. Obtener la mayor clave
        System.out.println("2. Mayor clave: " + arbol.obtenerMayorClave());

        // 3. Clave anterior a una dada
        Comparable clave = 60;
        Comparable anterior = arbol.obtenerClaveAnterior(clave);
        System.out.println("3. Clave anterior a " + clave + ": " + (anterior != null ? anterior : "No tiene"));

        // 4. Cantidad de nodos en el nivel 2
        int nivel = 2;
        int cantNivel = arbol.contarNodosEnNivel(nivel);
        System.out.println("4. Cantidad de nodos en nivel " + nivel + ": " + cantNivel);

        // 5. Listar hojas con su nivel
        System.out.println("5. Hojas con su nivel:");
        arbol.listarHojasConNivel();

        // 6. Nivel de una clave
        Comparable claveBuscada = 40;
        int nivelClave = arbol.nivelDeClave(claveBuscada);
        System.out.println("6. Nivel de clave " + claveBuscada + ": " + (nivelClave >= 0 ? nivelClave : "No encontrada"));

        // 7. Cantidad de hojas
        int cantidadHojas = arbol.contarHojas();
        System.out.println("7. Cantidad de hojas: " + cantidadHojas);

        // 8. Verificar si es ABB
        System.out.println("8. ¿Es ABB?: " + (arbol.esABB() ? "Sí" : "No"));
    }
}

