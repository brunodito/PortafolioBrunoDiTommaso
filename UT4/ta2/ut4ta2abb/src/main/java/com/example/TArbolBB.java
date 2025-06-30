package com.example;
public class TArbolBB<T> implements IArbolBB<T> {


    TElementoAB<T> raiz = null;


    @Override
    public boolean insertar(Comparable etiqueta, T dato) 
    {
        if(esVacio())
        {
            raiz = new TElementoAB<T>(etiqueta, dato);
            return true;
        }
        else
        {
            return raiz.insertar(new TElementoAB<T>(etiqueta, dato));
        }
    }

    @Override
    public TElementoAB buscar(Comparable unaEtiqueta) {
        if(esVacio())
        {
            return null;
        }
        else
        {
            return raiz.buscar(unaEtiqueta);
        }
    }

    @Override
    public String preOrden() {
        if (esVacio())
        {
            return "Arbol vacío";
        }
        else
        {
            return raiz.preOrden();
        }
    }

    @Override
    public String inOrden() {
        if (esVacio())
        {
            return "Arbol vacío";
        }
        else
        {
            return raiz.inOrden();
        }
    }

    @Override
    public String postOrden() {
        if (esVacio())
        {
            return "Arbol vacío";
        }
        else
        {
            return raiz.postOrden();
        }
    }

    @Override
    public T eliminar(Comparable unaEtiqueta) {
        if(esVacio())
        {
            System.out.println("Arbol Vacío");
            return null;
        }
        else
        {
            T result;
            raiz = raiz.eliminar(unaEtiqueta);
            if(raiz == null)
            {
                result = null;
            }
            else
            {
                result = raiz.getDatos();
            }
            return result;
        }
    }

    @Override
    public int getAltura() {
        if(esVacio())
        {
            return 0;
        }
        else
        {
            return raiz.getAltura();
        }
    }

    @Override
    public int cantHojas() {
        if (esVacio())
        {
            return 0; 
        }
        else
        {
            return raiz.cantHojas();
        }
    }

    @Override
    public int getTamaño() {
        if(esVacio())
        {
            return 0;
        }
        else
        {
            return raiz.getTamaño();
        }
    }

    @Override
    public int getNivel(Comparable clave) {
        if(buscar(clave) == null)
        {
            return 0;
        }
        else
        {
            return raiz.getNivel(clave);
        }
    }

    @Override
    public boolean esVacio() {
        return raiz == null;
    }

}
