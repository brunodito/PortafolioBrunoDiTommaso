package pd1;

public class Alumno {
    private String nombre;
    public Alumno (String a) {
        nombre = a;
    }
    public String getNombreAdmiracion() {
        return nombre.concat("!");
    }
    public static void main (String[] args) {
        String a = "Pedro";
        Alumno alumno = new Alumno(a);
        System.out.println(alumno.getNombreAdmiracion());
    }
}
