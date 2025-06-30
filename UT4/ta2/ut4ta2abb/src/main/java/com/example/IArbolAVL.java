package com.example;

public interface IArbolAVL<T> extends IArbolBB<T>{

    /**
     * Realiza una rotación simple del subarbol izquierdo del hijo izquierdo.
     * @param k2
     * @return
     */
    public TElementoAB<T> rotacionLL(TElementoAB<T> k2);


    /**
     * Realiza una rotación simple del subarbol derecho del hijo derecho.
     * @param k1
     * @return
     */
    public TElementoAB<T> rotacionRR(TElementoAB<T> k1);


    /**
     * Realiza una rotación doble del subarbol derecho del hijo izquierdo
     * @param k3
     * @return
     */
    public TElementoAB<T> rotacionLR(TElementoAB<T>k3);


    /**
     * Realiza una rotación doble del subarbol izquierdo del hijo derecho
     * @param k3
     * @return
     */
    public TElementoAB<T> rotacionRL(TElementoAB<T> k1);
}
