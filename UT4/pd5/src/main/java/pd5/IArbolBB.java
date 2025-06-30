package pd5;

public interface IArbolBB {
    public boolean insertar(IElementoABB unElemento);

    public Comparable obtenerMenorClave();

    public Comparable obtenerMayorClave(); 

    public Comparable obtenerClaveAnterior(Comparable clave);

    public int contarNodosEnNivel(int nivel);

    public void listarHojasConNivel();

    public boolean esABB();

    public int contarHojas();

    public int nivelDeClave(Comparable clave);

    public ElementoABB buscar(Comparable unaClave);

}

