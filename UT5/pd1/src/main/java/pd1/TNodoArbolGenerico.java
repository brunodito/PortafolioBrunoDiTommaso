package pd1;

public class TNodoArbolGenerico {
    private String etiqueta;
    private TNodoArbolGenerico primerHijo;
    private TNodoArbolGenerico hermanoDerecho;

    public TNodoArbolGenerico(String etiqueta) {
        this.etiqueta = etiqueta;
        this.primerHijo = null;
        this.hermanoDerecho = null;
    }

    public String getEtiqueta() {
        return etiqueta;
    }

    public TNodoArbolGenerico getPrimerHijo() {
        return primerHijo;
    }

    public void setPrimerHijo(TNodoArbolGenerico hijo) {
        this.primerHijo = hijo;
    }

    public TNodoArbolGenerico getHermanoDerecho() {
        return hermanoDerecho;
    }

    public void setHermanoDerecho(TNodoArbolGenerico hermano) {
        this.hermanoDerecho = hermano;
    }

    public TNodoArbolGenerico buscar(String unaEtiqueta) {
        if (this.etiqueta.equals(unaEtiqueta)) {
            return this;
        }

        if (primerHijo != null) {
            TNodoArbolGenerico resultado = primerHijo.buscar(unaEtiqueta);
            if (resultado != null) {
                return resultado;
            }
        }

        if (hermanoDerecho != null) {
            return hermanoDerecho.buscar(unaEtiqueta);
        }

        return null;
    }

    public void listarIndentado(String prefijo) {
        System.out.println(prefijo + etiqueta);

        if (primerHijo != null) {
            primerHijo.listarIndentado(prefijo + "  ");
        }

        if (hermanoDerecho != null) {
            hermanoDerecho.listarIndentado(prefijo);
        }
    }
}

