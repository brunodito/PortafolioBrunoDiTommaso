import java.util.Collection;
import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

public class TGrafoNoDirigido extends TGrafoDirigido implements IGrafoNoDirigido {
    public TGrafoNoDirigido(Collection<TVertice> vertices, Collection<TArista> aristas) {
        super(vertices, aristas);
    }

    private int getIndiceVertice(Comparable etiquetaVertice) {
        Object[] etiquetas = this.getVertices().keySet().toArray();
        for (int i = 0; i < etiquetas.length; i++) {
            if (etiquetas[i].equals(etiquetaVertice)) {
                return i;
            }
        }
        return -1;
    }

    public boolean insertarArista(TArista arista) {
        if ((arista.getEtiquetaOrigen() != null) && (arista.getEtiquetaDestino() != null)) {
            TVertice vertOrigen = buscarVertice(arista.getEtiquetaOrigen());
            TVertice vertDestino = buscarVertice(arista.getEtiquetaDestino());
            if ((vertOrigen != null) && (vertDestino != null)) {
                vertOrigen.insertarAdyacencia(arista.getCosto(), vertDestino);
                vertDestino.insertarAdyacencia(arista.getCosto(), vertOrigen);
                return true;
            }
        }
        return false;
    }

    public boolean eliminarArista(Comparable nomVerticeOrigen, Comparable nomVerticeDestino) {
        if ((nomVerticeOrigen != null) && (nomVerticeDestino != null)) {
            TVertice vertOrigen = buscarVertice(nomVerticeOrigen);
            TVertice vertDestino = buscarVertice(nomVerticeDestino);
            if (vertOrigen != null) {
                vertOrigen.eliminarAdyacencia(nomVerticeDestino);
            }
            if(vertDestino != null) {
                vertDestino.eliminarAdyacencia(nomVerticeOrigen);
            }
            return true;
        }
        return false;
    }

    public boolean existeArista(Comparable etiquetaOrigen, Comparable etiquetaDestino) {
        TVertice vertOrigen = buscarVertice(etiquetaOrigen);
        TVertice vertDestino = buscarVertice(etiquetaDestino);
        if ((vertOrigen != null) && (vertDestino != null)) {
            return vertOrigen.buscarAdyacencia(vertDestino) != null;
        }
        return false;
    }

    public boolean existeVertice(Comparable unaEtiqueta) {
        return getVertices().get(unaEtiqueta) != null;
    }

    private TVertice buscarVertice(Comparable unaEtiqueta) {
        return getVertices().get(unaEtiqueta);
    }

    public boolean insertarVertice(Comparable unaEtiqueta) {
        if ((unaEtiqueta != null) && (!existeVertice(unaEtiqueta))) {
            TVertice vert = new TVertice(unaEtiqueta);
            getVertices().put(unaEtiqueta, vert);
            return getVertices().containsKey(unaEtiqueta);
        }
        return false;
    }

    public boolean insertarVertice(TVertice vertice) {
        Comparable unaEtiqueta = vertice.getEtiqueta();
        if ((unaEtiqueta != null) && (!existeVertice(unaEtiqueta))) {
            getVertices().put(unaEtiqueta, vertice);
            return getVertices().containsKey(unaEtiqueta);
        }
        return false;
    }

    @Override
    public TGrafoNoDirigido Prim(Comparable origen) {
        Collection<TVertice> verticesVacio = new LinkedList<>();
        Collection<TArista> aristasVacio = new LinkedList<>();
        TGrafoNoDirigido grafoPrim = new TGrafoNoDirigido(verticesVacio,aristasVacio);
        Collection<TVertice> visitados = new LinkedList<>();
        TVertice inicial = buscarVertice(origen);
        visitados.add(inicial);
        TVertice actual = null;
        TVertice actualDestino = null;
        TAdyacencia masCercano = null;
        grafoPrim.insertarVertice(new TVertice(inicial.getEtiqueta()));
        while(this.getVertices().size() != visitados.size()){
            actual = null;
            actualDestino = null;
            masCercano = null;
            for (TVertice vertice : visitados) {
                for(Object ady : vertice.getAdyacentes()){
                    TAdyacencia adyacencia = (TAdyacencia) ady;
                    if(masCercano == null && !visitados.contains(adyacencia.getDestino())){
                        masCercano = adyacencia;
                        actual = vertice;
                        actualDestino = adyacencia.getDestino();
                    }
                    if(masCercano != null){
                        if(adyacencia.getCosto() < masCercano.getCosto() && !visitados.contains(adyacencia.getDestino())){
                            actual = vertice;
                            actualDestino = adyacencia.getDestino();
                            masCercano = adyacencia;
                        }
                    }
                }
            }
            visitados.add(actualDestino);
            grafoPrim.insertarVertice(new TVertice(actualDestino.getEtiqueta()));
            grafoPrim.insertarArista(new TArista(actual.getEtiqueta(), actualDestino.getEtiqueta(), masCercano.getCosto()));
        }
        return grafoPrim;
    }

    @Override
    public Collection<TVertice> bea(Comparable verticeEti) {
        TVertice inicial = buscarVertice(verticeEti);
        Collection<TVertice> visitados = new LinkedList<>();
        Queue<TVertice> cola = new ConcurrentLinkedQueue<>();
        visitados.add(inicial);
        cola.add(inicial);
        while(!cola.isEmpty()){
            TVertice x = cola.remove();
            for (Object ady : x.getAdyacentes()) {
                TAdyacencia adyacencia = (TAdyacencia) ady;
                if(!visitados.contains(adyacencia.getDestino())){
                    visitados.add(adyacencia.getDestino());
                    cola.add(adyacencia.getDestino());
                }
            }
        }
        return visitados;
    }

    @Override
    public Collection<TVertice> bea() {
        Object[] ver = this.getVertices().values().toArray();
        TVertice inicial = (TVertice) ver[0];
        Collection<TVertice> visitados = new LinkedList<>();
        Queue<TVertice> cola = new ConcurrentLinkedQueue<>();
        visitados.add(inicial);
        cola.add(inicial);
        while(!cola.isEmpty()){
            TVertice x = cola.remove();
            for (Object ady : x.getAdyacentes()) {
                TAdyacencia adyacencia = (TAdyacencia) ady;
                if(!visitados.contains(adyacencia.getDestino())){
                    visitados.add(adyacencia.getDestino());
                    cola.add(adyacencia.getDestino());
                }
            }
        }
        return visitados;
    }
    

    public void imprimir(){
        for (TVertice ver : this.getVertices().values()) {
            StringBuilder sb = new StringBuilder();
            System.out.println(ver.getEtiqueta());
            for (Object ady : ver.getAdyacentes()) {
                TAdyacencia adyacencia = (TAdyacencia) ady;
                sb.append(adyacencia.getDestino().getEtiqueta() + " ");
            }
            System.out.println(sb.toString());
        }
    }

    private int getCostoCaminos(){
        int costo = 0;
        for (TVertice vertice : this.getVertices().values()) {
            for (Object ady : vertice.getAdyacentes()) {
                TAdyacencia adyacencia = (TAdyacencia) ady;
                costo += adyacencia.getCosto();
            }
        }
        return costo/2;
    }

    public void imprimirCostoCaminos(){
        System.out.println(getCostoCaminos());
    }

    public boolean conectados(Comparable v, Comparable w){
        Double[][] caminos = floyd();
        if(caminos[getIndiceVertice(v)][getIndiceVertice(w)] != Double.MAX_VALUE){
            return true;
        }
        return false;
    }

}
