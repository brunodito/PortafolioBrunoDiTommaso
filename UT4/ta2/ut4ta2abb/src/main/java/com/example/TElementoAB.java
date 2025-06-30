package com.example;
public class TElementoAB<T> implements IElementoAB<T> {

    private Comparable etiqueta;
    private T datos;
    private TElementoAB<T> hijoIzq = null;
    private TElementoAB<T> hijoDer = null;

    public TElementoAB(Comparable unaEtiqueta, T unosDatos) {
        this.etiqueta = unaEtiqueta;
        this.datos = unosDatos;
    }

    @Override
    public Comparable getEtiqueta() {
        return this.etiqueta;
    }

    @Override
    public String preOrden() {
        StringBuilder result = new StringBuilder();
        
        result.append(getEtiqueta() + "-");

        if(getHijoIzq() != null)
        {
            result.append(getHijoIzq().preOrden() + "-");
        }

        if(getHijoDer() != null)
        {
            result.append(getHijoDer().preOrden() + "-");
        }
        
        return result.substring(0, result.length()-1).toString();
    }

    @Override
    public String inOrden() {
        StringBuilder result = new StringBuilder();

        if(getHijoIzq() != null)
        {
            result.append(getHijoIzq().inOrden() + "-");
        }

        result.append(getEtiqueta() + "-");

        if(getHijoDer() != null)
        {
            result.append(getHijoDer().inOrden() + "-");
        }

        return result.substring(0, result.length()-1).toString();
    }

    @Override
    public String postOrden() {
        StringBuilder result = new StringBuilder();

        if(getHijoIzq() != null)
        {
            result.append(getHijoIzq().postOrden() + "-");
        }

        if(getHijoDer() != null)
        {
            result.append(getHijoDer().postOrden() + "-");
        }

        result.append(getEtiqueta() + "-");
        return result.substring(0, result.length()-1).toString();
    }

    @Override
    public T getDatos() {
        return datos;
    }

    @Override
    public TElementoAB eliminar(Comparable unaEtiqueta) {
        if(unaEtiqueta.compareTo(getEtiqueta()) == -1)
        {
            if(getHijoIzq() != null)
            {
                setHijoIzq(getHijoIzq().eliminar(unaEtiqueta));
            }
            return this;
        }
        if(unaEtiqueta.compareTo(getEtiqueta()) == 1)
        {
            if(getHijoDer() != null)
            {
                setHijoDer(getHijoDer().eliminar(unaEtiqueta));
            }
            return this;
        }
        return quitaElNodo();
    }

    public TElementoAB quitaElNodo()
    {
        if (getHijoIzq() == null)
        {
            return getHijoDer();
        }
        if (getHijoDer() == null)
        {
            return getHijoIzq();
        }
        TElementoAB elHijo = getHijoIzq();
        TElementoAB elPadre = this;
        while(elHijo.getHijoDer() != null)
        {
            elPadre = elHijo;
            elHijo = elHijo.getHijoDer();
        }
        if(elPadre != this)
        {
            elPadre.setHijoDer(elHijo.getHijoIzq());
            elHijo.setHijoIzq(getHijoIzq());
        }
        elHijo.setHijoDer(getHijoDer());
        return elHijo;
    }

    @Override
    public TElementoAB<T> getHijoIzq() {
        return hijoIzq;
    }

    @Override
    public TElementoAB<T> getHijoDer() {
        return hijoDer;
    }

    @Override
    public void setHijoIzq(TElementoAB<T> elemento) {
        hijoIzq = elemento;
    }

    @Override
    public void setHijoDer(TElementoAB<T> elemento) {
        hijoDer = elemento;
    }

    @Override
    public TElementoAB<T> buscar(Comparable unaEtiqueta) {
        if(unaEtiqueta.compareTo(getEtiqueta()) == 0)
        {
            return this;
        }
        else
        {
            if(unaEtiqueta.compareTo(getEtiqueta()) < 0)
            {
                if(getHijoIzq() != null){
                    return getHijoIzq().buscar(unaEtiqueta);
                }
                else
                {
                    return null;
                }
            }
            else
            {
                    if(getHijoDer() != null){
                        return getHijoDer().buscar(unaEtiqueta);
                    }
                    else
                    {
                        return null;
                    }
            }
        }
    }

    @Override
    public boolean insertar(TElementoAB<T> elemento) {
        if(this.etiqueta.equals(elemento.getEtiqueta()))
        {
            return false;
        }
        if (elemento.getEtiqueta().compareTo(this.etiqueta) < 0)
        {
            if (this.hijoIzq == null)
            {
                this.hijoIzq = elemento;
                return true;
            }
            else
            {
                return this.hijoIzq.insertar(elemento);
            }
        }
        else
        {
           if (this.hijoDer == null)
           {
            this.hijoDer = elemento;
            return true;    
           }
           else
           {
            return this.hijoDer.insertar(elemento);
           }
        }
    }

    @Override
    public int getAltura() {
        if(hijoDer == null && hijoIzq == null)
        {
            return 1;
        }
        else 
        {
            if(hijoDer == null)
            {
                return hijoIzq.getAltura() + 1;
            }
            else if(hijoIzq == null)
            {
                return hijoDer.getAltura() + 1;
            }
            else
            {
                return Math.max(hijoDer.getAltura(), hijoIzq.getAltura()) + 1;
            }
        }
        
    }

    @Override
    public int cantHojas() {
        if (hijoIzq == null && hijoDer == null)
        {
            return 1;
        }
        else if(hijoIzq == null)
        {
            return hijoDer.cantHojas();
        }
        else if(hijoDer == null)
        {
            return hijoIzq.cantHojas();
        }
        else
        {
            return hijoIzq.cantHojas() + hijoDer.cantHojas();
        }
    }

    @Override
    public int getTamaño() {
        if(hijoDer == null && hijoIzq == null)
        {
            return 1;
        }
        else 
        {
            if(hijoDer == null)
            {
                return hijoIzq.getTamaño() + 1;
            }
            else if(hijoIzq == null)
            {
                return hijoDer.getTamaño() + 1;
            }
            else
            {
                return hijoDer.getTamaño() + hijoIzq.getTamaño() + 1;
            }
        }   
    }

    @Override
    public int getNivel(Comparable clave) {
        if (getEtiqueta().compareTo(clave) == 0)
        {
            return 1;
        }
        else if(getEtiqueta().compareTo(clave) == 1)
        {
            return hijoIzq.getNivel(clave) + 1;
        }
        else
        {
            return hijoDer.getNivel(clave) + 1;
        }
    }
}
