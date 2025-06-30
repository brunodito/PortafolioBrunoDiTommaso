package pd3;

public class TElementoAB implements IElementoAB {
    private int clave;
    private TElementoAB hijoIzq;
    private TElementoAB hijoDer;

    public TElementoAB(int unaClave) {
        this.clave = unaClave;
    }

    public int getClave() {
        return clave;
    }

    public void insertar(TElementoAB elemento) {
        if (elemento.getClave() < this.clave) {
            if (hijoIzq == null) {
                hijoIzq = elemento;
            } else {
                hijoIzq.insertar(elemento);
            }
        } else if (elemento.getClave() > this.clave) {
            if (hijoDer == null) {
                hijoDer = elemento;
            } else {
                hijoDer.insertar(elemento);
            }
        }
        // Si es igual, no se inserta (clave duplicada).
    }

    public int contarHojas() {
        if (hijoIzq == null && hijoDer == null) {
            return 1;
        }

        int hojasIzq = (hijoIzq != null) ? hijoIzq.contarHojas() : 0;
        int hojasDer = (hijoDer != null) ? hijoDer.contarHojas() : 0;

        return hojasIzq + hojasDer;
    }

    public int sumaClaves() {
        int sumaIzq = (hijoIzq != null) ? hijoIzq.sumaClaves() : 0;
        int sumaDer = (hijoDer != null) ? hijoDer.sumaClaves() : 0;

        return clave + sumaIzq + sumaDer;
    }

    public int contarNodosEnNivel(int nivelBuscado, int nivelActual) {
        if (nivelActual == nivelBuscado) {
            return 1;
        }

        int cantIzq = (hijoIzq != null) ? hijoIzq.contarNodosEnNivel(nivelBuscado, nivelActual + 1) : 0;
        int cantDer = (hijoDer != null) ? hijoDer.contarNodosEnNivel(nivelBuscado, nivelActual + 1) : 0;

        return cantIzq + cantDer;
    }
}
