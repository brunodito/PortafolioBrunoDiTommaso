package pd3;

public class Main {
    public static void main(String[] args) {
        TArbolBB arbol = new TArbolBB();

        arbol.insertar(new TElementoAB(10));
        arbol.insertar(new TElementoAB(5));
        arbol.insertar(new TElementoAB(15));
        arbol.insertar(new TElementoAB(3));
        arbol.insertar(new TElementoAB(7));
        arbol.insertar(new TElementoAB(12));
        arbol.insertar(new TElementoAB(17));

        System.out.println("Cantidad de hojas: " + arbol.contarHojas());
        System.out.println("Suma de claves: " + arbol.sumaClaves());
        System.out.println("Nodos en nivel 2: " + arbol.contarNodosEnNivel(2));
    }
}

