
package RolesUsuario;


public class Estudiante extends Persona{
    
    private String carrera;

    public Estudiante(String carrera, String nombreCompleto, int edad) {
        super(nombreCompleto, edad);
        this.carrera = carrera;
    }

    public String getCarrera() {
        return carrera;
    }

    public void setCarrera(String carrera) {
        this.carrera = carrera;
    }
    
    
}
