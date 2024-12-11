
package BaseDatos;

import RolesUsuario.Estudiante;
import RolesUsuario.Profesor;
import java.util.ArrayList;


public class EstudiantesRegistrados {
    
    public static ArrayList<Estudiante> listaEstudiantesRegistrados = new ArrayList<>();
    public static ArrayList<Profesor> listaProfesoresRegistrados = new ArrayList<>();

    
    public static ArrayList<Estudiante> getListaEstudiantesRegistrados() {
        return listaEstudiantesRegistrados;
    }

    public static void setListaEstudiantesRegistrados(ArrayList<Estudiante> listaEstudiantesRegistrados) {
        EstudiantesRegistrados.listaEstudiantesRegistrados = listaEstudiantesRegistrados;
    }

    public static ArrayList<Profesor> getListaProfesoresRegistrados() {
        return listaProfesoresRegistrados;
    }

    public static void setListaProfesoresRegistrados(ArrayList<Profesor> listaProfesoresRegistrados) {
        EstudiantesRegistrados.listaProfesoresRegistrados = listaProfesoresRegistrados;
    }
    
    
}
