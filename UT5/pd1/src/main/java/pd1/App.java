package pd1;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        TArbolGenerico organigrama = new TArbolGenerico();

        System.out.println(organigrama.insertar("Rectorado", ""));
        System.out.println(organigrama.insertar("Facultad de Ingeniería", "Rectorado"));
        System.out.println(organigrama.insertar("Facultad de Ciencias Humanas", "Rectorado"));
        System.out.println(organigrama.insertar("Departamento de Informática", "Facultad de Ingeniería"));
        System.out.println(organigrama.insertar("Departamento de Matemática", "Facultad de Ingeniería"));
        System.out.println(organigrama.insertar("Departamento de Psicología", "Facultad de Ciencias Humanas"));
        System.out.println(organigrama.insertar("Facultad de Medicina", "ViceRectorado"));
        System.out.println(organigrama.insertar("Otra Raíz", ""));

        System.out.println("Buscar 'Departamento de Informática': " + (organigrama.buscar("Departamento de Informática")));
        System.out.println("Buscar 'Facultad de Derecho': " + (organigrama.buscar("Facultad de Derecho")));

        organigrama.listarIndentado();
    }
}
