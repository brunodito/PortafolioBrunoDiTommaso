package uy.edu.ucu.aed.tdas;

public class TArbolAVL<T> extends TArbolBB<T> {
    protected TElementoAVL<T> raiz;

    public TArbolAVL() {
        raiz = null;
    }

    @Override
    public boolean insertar(Comparable etiqueta, T unDato) {
        if (raiz == null) {
            raiz = new TElementoAVL<>(etiqueta, unDato);
            return true;
        } else {
            TElementoAVL<T> nuevoElemento = new TElementoAVL<>(etiqueta, unDato);
            if (((TElementoAVL<T>) raiz).insertar(nuevoElemento)) {
                return true;
            }
            return false;
        }
    }

    @Override
    public void eliminar(Comparable unaEtiqueta) {
        if (raiz != null) {
            raiz = (TElementoAVL<T>) raiz.eliminar(unaEtiqueta);
        }
    }

    public boolean esBalanceado() {
        return (raiz == null) || raiz.esBalanceado();
    }

    private TElementoAVL<T> balancear(TElementoAVL<T> nodo) {
        if (nodo == null)
            return null;
        return (TElementoAVL<T>) nodo.balancear();
    }

    public TElementoAB<T> buscarDesbalanceado() {
        if (raiz == null) {
            return null;
        }
        return raiz.buscarDesbalanceado();
    }
}
