package pd3;

public interface IArbolBB {
    void insertar(TElementoAB elemento);
    int contarHojas();
    int sumaClaves();
    int contarNodosEnNivel(int nivel);
}