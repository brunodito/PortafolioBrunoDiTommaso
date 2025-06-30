package pd07;

public interface ICola<T> extends ILista<T> {

    /**
     * Vacia por completo la cola.
     *
     */
    public void Anula();

    /**
     * debuelve los datos del primer elemento de la cola.
     *
     */
    public T Frente();

    /**
     * Agrega un nuevo nodo en la cola.
     *
     * @param dato  - El valor que se almacenará en el nuevo nodo.
     * @param clave - La clave única que identificará al nuevo nodo.
     */
    public void PoneEnCola(T dato, Comparable clave);

    /**
     * Elimina un nodo de la cola utilizando su clave.
     *
     * @param clave - La clave del nodo a eliminar.
     * @return True si el nodo fue eliminado con éxito, false en caso contrario.
     */
    public T QuitaDeCola(Comparable clave);

    /**
     * verifica si la cola esta vacía
     *
     * @return True si la cola no contiene nodos, false en caso contrario.
     */
    public boolean Vacía();

}
