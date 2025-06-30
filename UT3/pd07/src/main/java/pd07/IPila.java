package pd07;

public interface IPila<T> extends ILista<T> {

    /**
     * Agrega un nuevo nodo al final de la Pila.
     *
     * @param dato  - El valor que se almacenará en el nuevo nodo.
     * @param clave - La clave única que identificará al nuevo nodo.
     */
    public void push(T dato, Comparable clave);

    /**
     * Elimina y retorna el primer nodo de la pila (el último nodo agregado).
     *
     * @return El dato del nodo eliminado o un null en caso de que no alla nodos
     */
    public T pop();

    /**
     * Retorna el primer nodo de la pila (el último nodo agregado).
     *
     * @return El dato del nodo o un null en caso de que no alla nodos
     */
    public T tope();

    /**
     * Vacia por completo la pila.
     * .
     */
    public void anula();

    /**
     * Compruebo si la pila es vacia.
     * .
     * 
     * @return true si la pila esta vacia, false en caso contrario.
     */
    public boolean Vacia();
}