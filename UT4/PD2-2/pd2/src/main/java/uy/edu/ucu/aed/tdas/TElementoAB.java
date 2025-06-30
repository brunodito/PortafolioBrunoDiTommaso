/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uy.edu.ucu.aed.tdas;

import java.util.LinkedList;

public class TElementoAB<T> implements IElementoAB<T> {

    protected IElementoAB<T> hijoIzquierdo;
    protected IElementoAB<T> hijoDerecho;
    protected Comparable etiqueta;
    protected T unDato;
    protected int longi = 1;

    public TElementoAB(Comparable etiqueta, T unDato) {
        this.etiqueta = etiqueta;
        this.unDato = unDato;
        this.hijoDerecho = null;
        this.hijoIzquierdo = null;
    }

    @Override
    public Comparable getEtiqueta() {
        return etiqueta;
    }

    @Override
    public IElementoAB<T> getHijoIzq() {
        return hijoIzquierdo;
    }

    @Override
    public IElementoAB<T> getHijoDer() {
        return hijoDerecho;
    }

    @Override
    public void setHijoIzq(IElementoAB<T> elemento) {
        this.hijoIzquierdo = (TElementoAB<T>) elemento;
    }

    @Override
    public void setHijoDer(IElementoAB<T> elemento) {
        this.hijoDerecho = (TElementoAB<T>) elemento;
    }

    /*
     * Se busca en el nodo porque es donde se da la recursividad entre los hijos
     */
    @Override
    public IElementoAB<T> buscar(Comparable unaEtiqueta) {
        if (unaEtiqueta.compareTo(this.getEtiqueta()) == 0) {
            return this;
        } else if (unaEtiqueta.compareTo(this.getEtiqueta()) < 0) {
            if (this.getHijoIzq() != null) {
                return this.getHijoIzq().buscar(unaEtiqueta);
            } else {
                return null;
            }
        } else {
            if (this.getHijoDer() != null) {
                return this.getHijoDer().buscar(unaEtiqueta);
            } else {
                return null;
            }
        }
    }


    @Override
    public boolean insertar(IElementoAB<T> elemento) {
        if (elemento.getEtiqueta().compareTo(this.getEtiqueta()) < 0) {
            if (this.getHijoIzq() == null) {
                this.hijoIzquierdo = (TElementoAB<T>) elemento;
                longi++;
                return true;
            }
            return hijoIzquierdo.insertar(elemento);
        } else if (elemento.getEtiqueta().compareTo(this.getEtiqueta()) > 0) {
            if (this.getHijoDer() == null) {
                this.hijoDerecho = (TElementoAB<T>) elemento;
                longi++;
                return true;
            }
            return hijoDerecho.insertar(elemento);
        } else {
            return false;
        }
    }

    @Override
    public void preOrden(LinkedList unaLista) {
        if (this.etiqueta != null) {
            unaLista.add(this.etiqueta);
        }
        if (hijoIzquierdo != null) {
            hijoIzquierdo.preOrden(unaLista);
        }
        if (hijoDerecho != null) {
            hijoDerecho.preOrden(unaLista);
        }
    }

    @Override
    public void inOrden(LinkedList unaLista) {
        if (hijoIzquierdo != null) {
            hijoIzquierdo.inOrden(unaLista);
        }
        if (this.etiqueta != null) {
            unaLista.add(this.etiqueta);
        }
        if (hijoDerecho != null) {
            hijoDerecho.inOrden(unaLista);
        }
    }

    @Override
    public void postOrden(LinkedList unaLista) {
        if (hijoIzquierdo != null) {
            hijoIzquierdo.postOrden(unaLista);
        }
        if (hijoDerecho != null) {
            hijoDerecho.postOrden(unaLista);
        }
        if (this.etiqueta != null) {
            unaLista.add(this.etiqueta);
        }
    }

    @Override
    public T getDatos() {
        return unDato;
    }

    @Override
    public IElementoAB eliminar(Comparable unaEtiqueta) {
        throw new UnsupportedOperationException("Not supported yet."); // nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public int obtenerTamaño() {
        return longi;
    }

    public int altura() {
        int alturaHijoIzquierdo = 0;
        int alturaHijoDerecho = 0;
        if (this.hijoIzquierdo != null) {
            alturaHijoIzquierdo = ((TElementoAB<T>) this.hijoIzquierdo).altura() + 1;
        }
        if (this.hijoDerecho != null) {
            alturaHijoDerecho = ((TElementoAB<T>) this.hijoDerecho).altura() + 1;
        }
        if (alturaHijoDerecho > alturaHijoIzquierdo) {
            return alturaHijoDerecho;
        } else {
            return alturaHijoIzquierdo;
        }
    }

    public TElementoAB<T> obtenerMinimo() {
        if (this.hijoIzquierdo == null) {
            return this;
        } else {
            return ((TElementoAB<T>) this.hijoIzquierdo).obtenerMinimo();
        }
    }

}
