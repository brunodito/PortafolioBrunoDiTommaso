package com.example;
public interface IArbolBB<T> {

    /**
     * Inserta un elemento en el arbol. En caso de ya existir un elemento con la
     * clave indicada en "unElemento", retorna falso.
     *
     * @param etiqueta Etiqueta del nodo a insertar
     * @param dato Dato del nodo a insertar
     * @return Exito de la operacián
     */

    public boolean insertar(Comparable etiqueta, T dato);

 

    /**
     * Busca un elemento dentro del árbol.
     *
     *
     * @param unaEtiqueta Etiqueta identificadora del elemento a buscar.
     * .
     * @return Elemento encontrado. En caso de no encontrarlo, retorna nulo.
     */
    public TElementoAB<T> buscar(Comparable unaEtiqueta);

    /**
     * Imprime en PreOrden los elementos del árbol, separados por guiones.
     *
     * @return String conteniendo el preorden separado por guiones.
     */
    public String preOrden();

    /**
     * Imprime en InOrden los elementos del árbol, separados por guiones.
     *
     * @return String conteniendo el inorden separado por guiones.
     */
    public String inOrden();

    /**
     * Imprime en PostOrden los elementos del árbol, separados por guiones.
     *
     * @return String conteniendo el postorden separado por guiones.
     */
    public String postOrden();

   
       /**
     * Elimina un elemento dada una etiqueta.
     * @param unaEtiqueta 
     * @return Dato del nodo eliminado, null si no se encontró.
     */
    public T eliminar(Comparable unaEtiqueta);

    /**
     * Calcula la altura del arbol desde su raíz.
     * @return La altura de este árbol.
     */
    public int getAltura();

    /**
     * Obtiene cuantos nodos del árbol son hojas (no tienen hijos).
     * @return La cantidad de hojas en el árbol.
     */
    public int cantHojas();

    /**
     * Calcula el tamaño del árbol.
     * @return El tamaño de este árbol.
     */
    public int getTamaño();

    /**
     * Dada una clave, obtiene en qué nivel del árbol se encuentra.
     * @param clave La clave del nodo.
     * @return El nivel en el que se encuentra el nodo, 0 si el nodo no está en el arbol.
     */
    public int getNivel(Comparable clave);

    /**
     * Devuelve si el arbol está vacío o no.
     * @return true si es un arbol vacío, de lo contrario false.
     */
    public boolean esVacio();
	
}

