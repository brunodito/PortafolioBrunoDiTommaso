package dp12;

public class ProgramaPD12 {

    public static void main(String[] args) {
        Conjunto basicoIng = new Conjunto();
        Conjunto basicoEmp = new Conjunto();

        basicoIng.cargarDesdeArchivo("basico-ing.txt");
        basicoEmp.cargarDesdeArchivo("basico-emp.txt");

        IConjunto integrador101 = basicoIng.union(basicoEmp);
        integrador101.guardarEnArchivo("Integrador101.txt");

        IConjunto exigente102 = basicoIng.interseccion(basicoEmp);
        exigente102.guardarEnArchivo("Exigente102.txt");

    }

}
