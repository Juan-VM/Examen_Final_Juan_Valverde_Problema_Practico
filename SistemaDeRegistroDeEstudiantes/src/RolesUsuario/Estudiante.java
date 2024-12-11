package RolesUsuario;

import BaseDatos.UsuariosRegistrados;
import javax.swing.JOptionPane;

public class Estudiante extends Persona {

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

    public void eliminarEstudiante() {
        try {
            int indiceEstuduante = 0;
            for (Estudiante i : UsuariosRegistrados.getListaEstudiantesRegistrados()) {
                if (i.getPassword().equals(this.getPassword())) {
                    indiceEstuduante = UsuariosRegistrados.getListaEstudiantesRegistrados().indexOf(i);
                }
            }
            UsuariosRegistrados.getListaEstudiantesRegistrados().remove(indiceEstuduante);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error eliminado usuario");
        }
    }
}
