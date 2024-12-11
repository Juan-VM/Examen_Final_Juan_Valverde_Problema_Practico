
package RolesUsuario;


public class Estudiante extends Persona{
    
    private String carrera;

    public Estudiante(String carrera, String nombreCompleto, int edad, String usuario, String password, String rol) {
        super(nombreCompleto, edad, usuario, password, rol);
        this.carrera = carrera;
    }

    

    public String getCarrera() {
        return carrera;
    }

    public void setCarrera(String carrera) {
        this.carrera = carrera;
    }
    
    
}
