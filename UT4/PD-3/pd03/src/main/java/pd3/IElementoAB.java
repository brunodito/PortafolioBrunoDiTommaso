package pd3;

public interface IElementoAB {
    int getClave();
    void insertar(TElementoAB elemento);
    int contarHojas();
    int sumaClaves();
    int contarNodosEnNivel(int nivelBuscado, int nivelActual);
}