package pd5;

public interface IElementoABB {
    public Comparable getClave();

    public boolean insertar(IElementoABB unElemento);

    public Comparable obtenerMenorClave();

    public Comparable obtenerMayorClave();

    public Comparable obtenerClaveAnterior(Comparable clave, Comparable anterior);

    public int contarNodosEnNivel(int nivelObjetivo, int nivelActual);

    public void listarHojasConNivel(int nivel);

    public boolean esABB(Comparable min, Comparable max);

    public int contarHojas();

    public int nivelDeClave(Comparable clave, int nivelActual);

    public ElementoABB buscar(Comparable unaClave);
}
