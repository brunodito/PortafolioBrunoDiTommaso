package uy.edu.ucu.aed.tdas;

public class TElementoAVL<T> extends TElementoAB<T> {

    private int altura;

    public TElementoAVL(Comparable etiqueta, T dato) {
        super(etiqueta, dato);
        this.altura = 0;
    }

    public int getAltura() {
        return this.altura;
    }

    public void setAltura(int altura) {
        this.altura = altura;
    }

    @Override
    public boolean insertar(IElementoAB<T> elemento) {
        if (elemento.getEtiqueta().compareTo(this.etiqueta) < 0) {
            if (this.hijoIzquierdo == null) {
                this.hijoIzquierdo = (TElementoAVL<T>) elemento;
                actualizarAltura();
                return true;
            } else {
                if (((TElementoAVL<T>) this.hijoIzquierdo).insertar(elemento)) {
                    this.hijoIzquierdo = ((TElementoAVL<T>) this.hijoIzquierdo).balancear();
                    actualizarAltura();
                    return true;
                }
                return false;
            }
        } else if (elemento.getEtiqueta().compareTo(this.etiqueta) > 0) {
            if (this.hijoDerecho == null) {
                this.hijoDerecho = (TElementoAVL<T>) elemento;
                actualizarAltura();
                return true;
            } else {
                if (((TElementoAVL<T>) this.hijoDerecho).insertar(elemento)) {
                    this.hijoDerecho = ((TElementoAVL<T>) this.hijoDerecho).balancear();
                    actualizarAltura();
                    return true;
                }
                return false;
            }
        }
        return false;

    }

    @Override
    public TElementoAB<T> eliminar(Comparable unaEtiqueta) {
        if (unaEtiqueta.compareTo(this.etiqueta) < 0) {
            if (this.hijoIzquierdo != null) {
                this.hijoIzquierdo = (TElementoAVL<T>) this.hijoIzquierdo.eliminar(unaEtiqueta);
            }
        } else if (unaEtiqueta.compareTo(this.etiqueta) > 0) {
            if (this.hijoDerecho != null) {
                this.hijoDerecho = (TElementoAVL<T>) this.hijoDerecho.eliminar(unaEtiqueta);
            }
        } else {
            if (this.hijoIzquierdo == null && this.hijoDerecho == null) {
                return null;
            } else if (this.hijoIzquierdo == null) {
                return (TElementoAB<T>) this.hijoDerecho;
            } else if (this.hijoDerecho == null) {
                return (TElementoAB<T>) this.hijoIzquierdo;
            } else {
                TElementoAVL<T> sucesor = (TElementoAVL<T>) ((TElementoAVL<T>) this.hijoDerecho).obtenerMinimo();
                this.etiqueta = sucesor.getEtiqueta();
                this.unDato = sucesor.getDatos();
                this.hijoDerecho = (TElementoAVL<T>) this.hijoDerecho.eliminar(this.etiqueta);
            }
        }

        actualizarAltura();

        return (TElementoAB<T>) balancear();
    }

    void actualizarAltura() {
        int alturaIzquierda = (this.hijoIzquierdo != null) ? ((TElementoAVL<T>) this.hijoIzquierdo).getAltura() : -1;
        int alturaDerecha = (this.hijoDerecho != null) ? ((TElementoAVL<T>) this.hijoDerecho).getAltura() : -1;
        this.altura = Math.max(alturaIzquierda, alturaDerecha) + 1;
    }

    public int obtenerBalance() {
        int alturaIzquierda = (this.hijoIzquierdo != null) ? ((TElementoAVL<T>) this.hijoIzquierdo).getAltura() : -1;
        int alturaDerecha = (this.hijoDerecho != null) ? ((TElementoAVL<T>) this.hijoDerecho).getAltura() : -1;
        return alturaIzquierda - alturaDerecha;
    }

    public boolean esBalanceado() {
        return Math.abs(obtenerBalance()) <= 1;
    }

    public TElementoAVL<T> balancear() {
        if (this.obtenerBalance() > 1) {
            if (((TElementoAVL<T>) this.hijoIzquierdo).obtenerBalance() >= 0) {
                return rotacionLL();
            } else {
                return rotacionLR();
            }
        } else if (this.obtenerBalance() < -1) {
            if (((TElementoAVL<T>) this.hijoDerecho).obtenerBalance() <= 0) {
                return rotacionRR();
            } else {
                return rotacionRL();
            }
        }
        return this;
    }

    private TElementoAVL<T> rotacionLL() {
        TElementoAVL<T> k1 = (TElementoAVL<T>) this.hijoIzquierdo;
        TElementoAVL<T> k2 = this;
        this.hijoIzquierdo = k1.hijoDerecho;
        k1.hijoDerecho = k2;
        k2.actualizarAltura();
        k1.actualizarAltura();
        return k1;
    }

    public TElementoAVL<T> rotacionRR() {
        TElementoAVL<T> k1 = this;
        TElementoAVL<T> k2 = (TElementoAVL<T>) this.hijoDerecho;
        k1.hijoDerecho = k2.hijoIzquierdo;
        k2.hijoIzquierdo = k1;
        k1.actualizarAltura();
        k2.actualizarAltura();
        return k2;
    }

    public TElementoAVL<T> rotacionLR() {
        this.hijoIzquierdo = ((TElementoAVL<T>) this.hijoIzquierdo).rotacionRR();
        return this.rotacionLL();
    }

    private TElementoAVL<T> rotacionRL() {
        this.hijoDerecho = ((TElementoAVL<T>) this.hijoDerecho).rotacionLL();
        return this.rotacionRR();
    }

    public TElementoAVL<T> buscarDesbalanceado() {
        if (!esBalanceado()) {
            return this;
        }

        if (this.hijoIzquierdo != null) {
            TElementoAVL<T> desbalanceadoIzq = ((TElementoAVL<T>) this.hijoIzquierdo).buscarDesbalanceado();
            if (desbalanceadoIzq != null) {
                return desbalanceadoIzq;
            }
        }

        if (this.hijoDerecho != null) {
            TElementoAVL<T> desbalanceadoDer = ((TElementoAVL<T>) this.hijoDerecho).buscarDesbalanceado();
            if (desbalanceadoDer != null) {
                return desbalanceadoDer;
            }
        }

        return null;
    }
}