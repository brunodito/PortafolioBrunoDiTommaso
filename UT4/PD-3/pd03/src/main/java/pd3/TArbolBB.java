package pd3;

public class TArbolBB implements IArbolBB {
    private TElementoAB raiz;

    public void insertar(TElementoAB elemento) {
        if (raiz == null) {
            raiz = elemento;
        } else {
            raiz.insertar(elemento);
        }
    }

    public int contarHojas() {
        if (raiz == null) {
            return 0;
        }
        return raiz.contarHojas();
    }

    public int sumaClaves() {
        if (raiz == null) {
            return 0;
        }
        return raiz.sumaClaves();
    }

    public int contarNodosEnNivel(int nivel) {
        if (raiz == null) {
            return 0;
        }
        return raiz.contarNodosEnNivel(nivel, 0);
    }
}
