package pd5;

public class ElementoABB implements IElementoABB {

    private Comparable clave;
    private IElementoABB izquierdo;
    private IElementoABB derecho;

    public ElementoABB(Comparable clave) {
        this.clave = clave;
    }

    public Comparable getClave() {
        return clave;
    }

    public ElementoABB buscar(Comparable unaClave) {
        int comparacion = unaClave.compareTo(this.clave);

        if (comparacion == 0) {
            return this;
        } else if (comparacion < 0 && izquierdo != null) {
            return izquierdo.buscar(unaClave);
        } else if (comparacion > 0 && derecho != null) {
            return derecho.buscar(unaClave);
        }
        return null; // No se encontró la clave
    }


    public boolean insertar(IElementoABB unElemento) {
        if (unElemento.getClave().compareTo(this.clave) < 0) {
            if (izquierdo == null) {
                izquierdo = unElemento;
                return true;
            } else {
                return izquierdo.insertar(unElemento);
            }
        } else if (unElemento.getClave().compareTo(this.clave) > 0) {
            if (derecho == null) {
                derecho = unElemento;
                return true;
            } else {
                return derecho.insertar(unElemento);
            }
        }
        return false; // quiere cdeicr que la clave esta duplicada
    }

    public Comparable obtenerMenorClave() {
        if (izquierdo == null) {
            return this.clave;
        } else {
            return izquierdo.obtenerMenorClave();
        }
    }

     public Comparable obtenerMayorClave() {
        if (derecho == null) {
            return this.clave;
        } else {
            return derecho.obtenerMayorClave();
        }
    }

    public Comparable obtenerClaveAnterior(Comparable clave, Comparable anterior) {
        if (clave.compareTo(this.clave) <= 0) {
            if (izquierdo != null) {
                return izquierdo.obtenerClaveAnterior(clave, anterior);
            }
        } else {
            anterior = this.clave;
            if (derecho != null) {
                return derecho.obtenerClaveAnterior(clave, anterior);
            }
        }
        return anterior;
    }

    public int contarNodosEnNivel(int nivelObjetivo, int nivelActual) {
        int cuenta = 0;
        if (nivelActual == nivelObjetivo) {
            return 1;
        }
        if (izquierdo != null) {
            cuenta += izquierdo.contarNodosEnNivel(nivelObjetivo, nivelActual + 1);
        }
        if (derecho != null) {
            cuenta += derecho.contarNodosEnNivel(nivelObjetivo, nivelActual + 1);
        }
        return cuenta;
    }

    public void listarHojasConNivel(int nivel) {
        if (izquierdo == null && derecho == null) {
            System.out.println("Hoja: " + clave + " en nivel " + nivel);
        }
        if (izquierdo != null) {
            izquierdo.listarHojasConNivel(nivel + 1);
        }
        if (derecho != null) {
            derecho.listarHojasConNivel(nivel + 1);
        }
    }

    public boolean esABB(Comparable min, Comparable max) {
        if ((min != null && clave.compareTo(min) <= 0) || (max != null && clave.compareTo(max) >= 0)) {
            return false;
        }
        boolean izquierdoValido = (izquierdo == null) || izquierdo.esABB(min, clave);
        boolean derechoValido = (derecho == null) || derecho.esABB(clave, max);
        return izquierdoValido && derechoValido;
    }

    public int contarHojas() {
        if (izquierdo == null && derecho == null) {
            return 1;
        }
        int hojasIzq = (izquierdo != null) ? izquierdo.contarHojas() : 0;
        int hojasDer = (derecho != null) ? derecho.contarHojas() : 0;
        return hojasIzq + hojasDer;
    }

    public int nivelDeClave(Comparable clave, int nivelActual) {
        int comparacion = clave.compareTo(this.clave);
        if (comparacion == 0) {
            return nivelActual;
        } else if (comparacion < 0 && izquierdo != null) {
            return izquierdo.nivelDeClave(clave, nivelActual + 1);
        } else if (comparacion > 0 && derecho != null) {
            return derecho.nivelDeClave(clave, nivelActual + 1);
        } else {
            return -1; // Clave no encontrada
        }
    }

}
