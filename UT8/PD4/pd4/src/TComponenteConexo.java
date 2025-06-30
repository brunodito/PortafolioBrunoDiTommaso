import java.util.Collection;
import java.util.List;
import java.util.LinkedList;

public class TComponenteConexo {
    private Collection<TVertice> vertices;

    public TComponenteConexo() {
        this.vertices = new LinkedList<>();
    }

    public TComponenteConexo(Collection<TVertice> vertices) {
        this.vertices = vertices;
    }

    public Collection<TVertice> getVertices() {
        return vertices;
    }

    public void addVertice(TVertice vertice) {
        vertices.add(vertice);
    }

    public void imprimirComponentes(){
        StringBuilder sb = new StringBuilder();
        for (TVertice vertice : vertices) {
            sb.append(vertice.getEtiqueta());
            sb.append(" ");
        }
        System.out.println(sb.toString());
    }
}
