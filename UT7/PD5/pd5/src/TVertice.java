
import java.util.Collection;
import java.util.LinkedList;

public class TVertice<T> implements IVertice {

    private final Comparable etiqueta;
    private LinkedList<TAdyacencia> adyacentes;
    private boolean visitado;
    private T datos;
    private Comparable numero;

    public Comparable getNumero(){
        return numero;
    }

    public void setNumero(Comparable num){
        this.numero = num;
    }

    public Comparable getEtiqueta() {
        return etiqueta;
    }

    @Override
    public LinkedList<TAdyacencia> getAdyacentes() {
        return adyacentes;
    }

    public TVertice(Comparable unaEtiqueta) {
        this.etiqueta = unaEtiqueta;
        adyacentes = new LinkedList();
        visitado = false;
    }

    public void setVisitado(boolean valor) {
        this.visitado = valor;
    }

    public boolean getVisitado() {
        return this.visitado;
    }

    @Override
    public TAdyacencia buscarAdyacencia(TVertice verticeDestino) {
        if (verticeDestino != null) {
            return buscarAdyacencia(verticeDestino.getEtiqueta());
        }
        return null;
    }

    @Override
    public Double obtenerCostoAdyacencia(TVertice verticeDestino) {
        TAdyacencia ady = buscarAdyacencia(verticeDestino);
        if (ady != null) {
            return ady.getCosto();
        }
        return Double.MAX_VALUE;
    }

    @Override
    public boolean insertarAdyacencia(Double costo, TVertice verticeDestino) {
        if (buscarAdyacencia(verticeDestino) == null) {
            TAdyacencia ady = new TAdyacencia(costo, verticeDestino);
            return adyacentes.add(ady);
        }
        return false;
    }

    @Override
    public boolean eliminarAdyacencia(Comparable nomVerticeDestino) {
        TAdyacencia ady = buscarAdyacencia(nomVerticeDestino);
        if (ady != null) {
            adyacentes.remove(ady);
            return true;
        }
        return false;
    }

    @Override
    public TVertice primerAdyacente() {
        if (this.adyacentes.getFirst() != null) {
            return this.adyacentes.getFirst().getDestino();
        }
        return null;
    }

    @Override
    public TVertice siguienteAdyacente(TVertice w) {
        TAdyacencia adyacente = buscarAdyacencia(w.getEtiqueta());
        int index = adyacentes.indexOf(adyacente);
        if (index + 1 < adyacentes.size()) {
            return adyacentes.get(index + 1).getDestino();
        }
        return null;
    }

    @Override
    public TAdyacencia buscarAdyacencia(Comparable etiquetaDestino) {
        for (TAdyacencia adyacencia : adyacentes) {
            if (adyacencia.getDestino().getEtiqueta().compareTo(etiquetaDestino) == 0) {
                return adyacencia;
            }
        }
        return null;
    }

    /**
     *
     * @return
     */
    public T getDatos() {
        return datos;
    }

    @Override
    public void bpf(Collection<TVertice> visitados) {
        if (!visitados.contains(this)) {
            visitados.add(this);
            for (TAdyacencia adyacencia : adyacentes) {
                adyacencia.getDestino().bpf(visitados);
            }
        }
    }

    public TCaminos todosLosCaminos(Comparable etVertDest, TCamino caminoPrevio, TCaminos todosLosCaminos) {
        this.setVisitado(true);
        for (TAdyacencia adyacencia : this.getAdyacentes()) {
            TVertice destino = adyacencia.getDestino();
            if (!destino.getVisitado()) {
                if (destino.getEtiqueta().compareTo(etVertDest) == 0) {
                    TCamino copia = caminoPrevio.copiar();
                    copia.agregarAdyacencia(adyacencia);
                    todosLosCaminos.getCaminos().add(copia);
                } else {
                    TCamino copia = caminoPrevio.copiar();
                    copia.agregarAdyacencia(adyacencia);
                    destino.todosLosCaminos(etVertDest, copia, todosLosCaminos);
                }
            }
        }
        this.setVisitado(false);
        return todosLosCaminos;
    }

    public void bpfConImpresion(Collection<TVertice> visitados) {
        if (!visitados.contains(this)) {
            visitados.add(this);
            System.out.println(this.getEtiqueta());
            for (TAdyacencia adyacencia : adyacentes) {
                adyacencia.getDestino().bpfConImpresion(visitados);
            }
        }
    }


    public boolean esAciclico(Collection<TVertice> visitados) {
        if (!visitados.contains(this)) {
            visitados.add(this);
            for (TAdyacencia adyacencia : adyacentes) {
                return adyacencia.getDestino().esAciclico(visitados);
            }
        }
        else{
            for (TAdyacencia adyacencia : adyacentes) {
                if(visitados.contains(adyacencia.getDestino())){
                    return  false;
                }
            }
        }
        return true;
    }

    
    public void clasificacionTopologica(LinkedList<TVertice> listaOrdenada) {
        this.setVisitado(true);

        for (TAdyacencia adyacencia : adyacentes) {
            TVertice verticeDestino = adyacencia.getDestino();
            if (!verticeDestino.getVisitado()) {
                verticeDestino.clasificacionTopologica(listaOrdenada);
            }
        }
        listaOrdenada.addFirst(this);
    }


    public void asignacionDeNumeros(int numero) {
        setVisitado(true);
        for (TAdyacencia adyacente : adyacentes) {
            TVertice vertAdy = adyacente.getDestino();
            if (!vertAdy.getVisitado()) {
                vertAdy.asignacionDeNumeros(numero - 1);
            }
        }
        setNumero(numero);   
    }

    public void buscarComponentes(TComponenteConexo componente) {
        setVisitado(true);
        componente.addVertice(this);
        for (TAdyacencia adyacente : adyacentes) {
            TVertice vertAdy = adyacente.getDestino();
            if (!vertAdy.getVisitado()) {
                vertAdy.buscarComponentes(componente);
            }
        }
    }
    

}