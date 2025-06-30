package pd5;

public class ArbolBinarioBusqueda implements IArbolBB {

    private IElementoABB raiz;

    public boolean insertar(IElementoABB elem) {
        if (raiz == null) {
            raiz = elem;
            return true;
        }
        return raiz.insertar(elem);
    }

    public Comparable obtenerMenorClave() {
        if (raiz == null) {
            return null;
        }
        return raiz.obtenerMenorClave();
    }

    public Comparable obtenerMayorClave() {
        if (raiz == null) {
            return null;
        }
        return raiz.obtenerMayorClave();
    }

    public Comparable obtenerClaveAnterior(Comparable clave) {
        if (raiz == null || buscar(clave) == null ) {
            return null;
        }
        return raiz.obtenerClaveAnterior(clave, null);
    }

    public boolean esABB() {
        if (raiz == null) return true;
        return raiz.esABB(null, null);
    }

    public void listarHojasConNivel() {
        if (raiz != null) {
            raiz.listarHojasConNivel(0);
        }
    }

    public int contarNodosEnNivel(int nivel) {
        if (raiz == null) return 0;
        return raiz.contarNodosEnNivel(nivel, 0);
    }

    public int contarHojas() {
        if (raiz == null) return 0;
        return raiz.contarHojas();
    }

    public int nivelDeClave(Comparable clave) {
        if (raiz == null) return -1;
        return raiz.nivelDeClave(clave, 0);
    }

    public ElementoABB buscar(Comparable clave) {
        if (raiz != null) {
            return raiz.buscar(clave);
        }
        return null;
    }

}
