
package RolesUsuario;

import Usuario.Usuario;


public class Persona extends Usuario{
    private String nombreCompleto;
    private int edad;

    public Persona(String nombreCompleto, int edad, String usuario, String password, String rol) {
        super(usuario, password, rol);
        this.nombreCompleto = nombreCompleto;
        this.edad = edad;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }
    
    
}
