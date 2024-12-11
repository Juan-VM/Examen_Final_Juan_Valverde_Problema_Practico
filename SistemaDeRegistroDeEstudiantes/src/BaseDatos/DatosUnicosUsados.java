
package BaseDatos;

import java.util.ArrayList;


public class DatosUnicosUsados {
    
    public static ArrayList<String> passwordsEnUso = new ArrayList<>();
   
    
    public static ArrayList<String> getPasswordsEnUso() {
        return passwordsEnUso;
    }

    public static void setPasswordsEnUso(ArrayList<String> passwordsEnUso) {
        DatosUnicosUsados.passwordsEnUso = passwordsEnUso;
    }

}
