
package BaseDatos;

import RolesUsuario.Administrador;
import RolesUsuario.Estudiante;
import java.util.ArrayList;


public class UsuariosRegistrados {
    
    public static ArrayList<Estudiante> listaEstudiantesRegistrados = new ArrayList<>();
    public static ArrayList<Administrador> listaAdminsRegistrados = new ArrayList<>();

    public static ArrayList<Estudiante> getListaEstudiantesRegistrados() {
        return listaEstudiantesRegistrados;
    }

    public static void setListaEstudiantesRegistrados(ArrayList<Estudiante> listaEstudiantesRegistrados) {
        UsuariosRegistrados.listaEstudiantesRegistrados = listaEstudiantesRegistrados;
    }

    public static ArrayList<Administrador> getListaAdminsRegistrados() {
        return listaAdminsRegistrados;
    }

    public static void setListaAdminsRegistrados(ArrayList<Administrador> listaAdminsRegistrados) {
        UsuariosRegistrados.listaAdminsRegistrados = listaAdminsRegistrados;
    }

   
}
