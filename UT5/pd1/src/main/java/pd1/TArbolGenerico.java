package pd1;

public class TArbolGenerico {
    private TNodoArbolGenerico raiz;

    public TArbolGenerico() {
        this.raiz = null;
    }

    public boolean insertar(String unaEtiqueta, String etiquetaPadre) {
        if (raiz == null) {
            if (etiquetaPadre.equals("")) {
                raiz = new TNodoArbolGenerico(unaEtiqueta);
                return true;
            } else {
                return false;
            }
        }

        if (etiquetaPadre.equals("")) {
            return false;
        }

        TNodoArbolGenerico nodoPadre = raiz.buscar(etiquetaPadre);
        if (nodoPadre == null) {
            return false;
        }

        TNodoArbolGenerico nuevoNodo = new TNodoArbolGenerico(unaEtiqueta);

        if (nodoPadre.getPrimerHijo() == null) {
            nodoPadre.setPrimerHijo(nuevoNodo);
        } else {
            TNodoArbolGenerico actual = nodoPadre.getPrimerHijo();
            while (actual.getHermanoDerecho() != null) {
                actual = actual.getHermanoDerecho();
            }
            actual.setHermanoDerecho(nuevoNodo);
        }

        return true;
    }

    public TNodoArbolGenerico buscar(String unaEtiqueta) {
        if (raiz == null) return null;
        return raiz.buscar(unaEtiqueta);
    }

    public void listarIndentado() {
        if (raiz != null) {
            raiz.listarIndentado("");
        } else {
            System.out.println("(Árbol vacío)");
        }
    }
}

