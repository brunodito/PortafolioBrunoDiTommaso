package com.example;

public class TArbolAVL<T> extends TArbolBB<T> implements IArbolAVL<T>{

    @Override
    public TElementoAB<T> rotacionLL(TElementoAB<T> k2) {
        TElementoAB<T> k1 = k2.getHijoIzq();
        k2.setHijoIzq(k1.getHijoDer());
        k1.setHijoDer(k2);
        return k1;
    }

    @Override
    public TElementoAB<T> rotacionRR(TElementoAB<T> k1) {
        TElementoAB<T> k2 = k1.getHijoDer();
        k1.setHijoDer(k2.getHijoIzq());
        k2.setHijoIzq(k1);
        return k1;
    }

    @Override
    public TElementoAB<T> rotacionLR(TElementoAB<T> k3) {
        k3.setHijoIzq(rotacionRR(k3.getHijoIzq()));
        return rotacionLL(k3);
    }

    @Override
    public TElementoAB<T> rotacionRL(TElementoAB<T> k1) {
        k1.setHijoDer(rotacionLL(k1.getHijoDer()));
        return rotacionRR(k1);
    }

}
