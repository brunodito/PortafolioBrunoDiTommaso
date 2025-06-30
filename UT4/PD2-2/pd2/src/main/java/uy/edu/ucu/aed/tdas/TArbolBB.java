/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uy.edu.ucu.aed.tdas;

import java.util.LinkedList;
import java.util.List;

public class TArbolBB<T> implements IArbolBB<T> {

    private TArbolBB izq, der;
    private IElementoAB<T> raiz;

    @Override
    public boolean insertar(Comparable etiqueta, T unDato) {
        IElementoAB<T> nodo = new TElementoAB(etiqueta, unDato);
        if (esVacio()) {
            raiz = nodo;
            return true;
        } else {
            return raiz.insertar(nodo);
        }
    }

    @Override
    public T buscar(Comparable unaEtiqueta) {
        if (raiz == null) {
            return null;
        }
        IElementoAB<T> nodo = raiz.buscar(unaEtiqueta);
        if (nodo == null) {
            return null;
        }
        return nodo.getDatos();
    }

    @Override
    public void eliminar(Comparable unaEtiqueta) {
        if (raiz != null) {
            raiz = raiz.eliminar(unaEtiqueta);
        }
    }

    @Override
    public List preOrden() {
        LinkedList<T> lista = new LinkedList<>();
        if (!esVacio()) {
            raiz.preOrden(lista);
            return lista;
        } else {
            return null;
        }
    }

    @Override
    public List inOrden() {
        LinkedList<T> lista = new LinkedList<>();
        if (!esVacio()) {
            raiz.inOrden(lista);
            return lista;
        } else {
            return null;
        }
    }

    @Override
    public List postOrden() {
        LinkedList<T> lista = new LinkedList<>();
        if (!esVacio()) {
            raiz.postOrden(lista);
            return lista;
        } else {
            return null;
        }
    }

    @Override
    public boolean esVacio() {
        return raiz == null;
    }

    @Override
    public boolean vaciar() {
        if (esVacio()) {
            return false;
        } else {
            raiz = null;
            return true;
        }
    }

}
