
package RolesUsuario;


public class Profesor extends Persona{
    
    private String nombreCurso;
    private int year;

    public Profesor(String nombreCurso, int year, String nombreCompleto, int edad, String usuario, String password, String rol) {
        super(nombreCompleto, edad, usuario, password, rol);
        this.nombreCurso = nombreCurso;
        this.year = year;
    }

    

    public String getNombreCurso() {
        return nombreCurso;
    }

    public void setNombreCurso(String nombreCurso) {
        this.nombreCurso = nombreCurso;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }
    
}
