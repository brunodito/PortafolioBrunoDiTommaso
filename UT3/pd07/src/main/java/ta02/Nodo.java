/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package ta02;


class Nodo<T> {
    public final Comparable clave;
    public T dato;
    public Nodo<T> siguiente;

    public Nodo(Comparable clave, T dato) {
        this.clave = clave;
        this.dato = dato;
        this.siguiente = null;
    }
}
