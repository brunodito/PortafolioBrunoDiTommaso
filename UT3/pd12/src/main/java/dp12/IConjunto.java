package dp12;
/**
 *
 * @author ernesto
 * @param <T>
 */
public interface IConjunto {
    public IConjunto union(IConjunto otroConjunto);
    public IConjunto interseccion(IConjunto otroConjunto);
    public void agregar(Alumno alumno); 
    public boolean contiene(Alumno alumno);
    public void guardarEnArchivo(String nombreArchivo);
    public void cargarDesdeArchivo(String nombreArchivo);
}
