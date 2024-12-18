package Main;

import BaseDatos.DatosUnicosUsados;
import BaseDatos.UsuariosRegistrados;
import GUI.PrincipalAdministradores;
import GUI.PrincipalEstudiantes;
import RolesUsuario.Administrador;
import RolesUsuario.Estudiante;
import javax.swing.JOptionPane;

public class Login extends javax.swing.JFrame {
    
    boolean estado = false; //Para ver o ocultar el password.
    
    public Login() {
        initComponents();
        this.setLocationRelativeTo(null);

    }
    
    //Este metodo crea y agrega estudiantes y administradores hechos por defecto a la lista de usuariosRegistrados, y agrega sus passwords a la que estan en uso.
    public static void crearUsuariosPreestablecidos(){
        //Se ejecuta una sola vez en el main para evitar duplicados.

        //Estudiantes agregados por defecto:
        //            Constructor de Estudiante( carrera, nombreCompleto, edad, usuario, password, rol);
        Estudiante estudiante1 = new Estudiante("Informatica", "Juan Valverde Mora", 18, "Juan", "12345678", "Estudiante");
        Estudiante estudiante2 = new Estudiante("Electronica", "Adrian Mora", 20, "Adri", "helloworld", "Estudiante");

        UsuariosRegistrados.getListaEstudiantesRegistrados().add(estudiante1);
        UsuariosRegistrados.getListaEstudiantesRegistrados().add(estudiante2);

        //Administrador agregado por defecto:
        //         Constructor de Administrador( NombreCompleto, edad, usuario, password, rol);
        Administrador admin = new Administrador("Rodolfo Diaz", 34, "Fofo", "bueno123", "Administrador");

        UsuariosRegistrados.getListaAdminsRegistrados().add(admin);
        
        
        //agregar password a passwords en uso
        DatosUnicosUsados.getPasswordsEnUso().add(estudiante1.getPassword());
        DatosUnicosUsados.getPasswordsEnUso().add(estudiante2.getPassword());
        DatosUnicosUsados.getPasswordsEnUso().add(admin.getPassword());
    }
    
    //Este metodo valida que no existan espacios en blanco y retorna un valor booleano que representa si hay o no espacios sin llenar.
    public boolean validarEspaciosRellenos() {

        boolean espaciosLlenos = false;
        try {

            if (!txtUsuario.getText().trim().equals("") || !String.valueOf(txtPassword.getPassword()).trim().equals("")) {
                if (String.valueOf(txtPassword.getPassword()).length() >= 8) {
                    espaciosLlenos = true;
                }else{
                    JOptionPane.showMessageDialog(null, "El password debe tener 8 caracteres minimo");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Rellena todos los espacios");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error en los datos ingresados");
        }
        return espaciosLlenos;
    }

    //Este metodo recibe la condicion de espaciosRellenos y si es true valida los datos ingresados, en caso de que sean correctos entra al respectivo Jframe segun el rol.
    public void validarDatos(boolean permiso) {
        if (permiso == true) {

            try {
                boolean encontrado = false;
                String rol = "";
                int indiceUsuarioEncontrado = 0;

                for (Estudiante i : UsuariosRegistrados.getListaEstudiantesRegistrados()) {
                    if (i.getUsuario().equals(txtUsuario.getText()) && i.getPassword().equals(String.valueOf(txtPassword.getPassword()))) {
                        encontrado = true;
                        rol = i.getRol();
                        indiceUsuarioEncontrado = UsuariosRegistrados.getListaEstudiantesRegistrados().indexOf(i);
                    }
                }

                for (Administrador i : UsuariosRegistrados.getListaAdminsRegistrados()) {
                    if (i.getUsuario().equals(txtUsuario.getText()) && i.getPassword().equals(String.valueOf(txtPassword.getPassword()))) {
                        encontrado = true;
                        rol = i.getRol();
                        indiceUsuarioEncontrado = UsuariosRegistrados.getListaAdminsRegistrados().indexOf(i);
                    }
                }

                if (encontrado == true) {
                    JOptionPane.showMessageDialog(null, "Usuario correcto, bienvenido!");
                    switch (rol) {
                        case "Estudiante" -> {
                            PrincipalEstudiantes estudents = new PrincipalEstudiantes(indiceUsuarioEncontrado);
                            estudents.setVisible(true);
                            this.dispose();
                        }
                        case "Administrador" -> {
                            PrincipalAdministradores admins = new PrincipalAdministradores(indiceUsuarioEncontrado);
                            admins.setVisible(true);
                            this.dispose();
                        }
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Usuario o password incorrecto, intenta de nuevo");
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Error iniciando sesion");
            }
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        background = new javax.swing.JPanel();
        btnEntrar = new javax.swing.JButton();
        lblPass = new javax.swing.JLabel();
        txtUsuario = new javax.swing.JTextField();
        lblUser = new javax.swing.JLabel();
        txtPassword = new javax.swing.JPasswordField();
        lblInicioSesion = new javax.swing.JLabel();
        btnMostrar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        background.setBackground(new java.awt.Color(255, 255, 204));
        background.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnEntrar.setBackground(new java.awt.Color(102, 102, 0));
        btnEntrar.setFont(new java.awt.Font("Segoe UI", 1, 48)); // NOI18N
        btnEntrar.setForeground(new java.awt.Color(255, 255, 255));
        btnEntrar.setText("ENTRAR");
        btnEntrar.setToolTipText("");
        btnEntrar.setBorder(null);
        btnEntrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEntrarActionPerformed(evt);
            }
        });
        background.add(btnEntrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 560, 370, 80));

        lblPass.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        lblPass.setForeground(new java.awt.Color(51, 51, 51));
        lblPass.setText("Ingrese su password:");
        background.add(lblPass, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 340, 370, 50));

        txtUsuario.setBackground(new java.awt.Color(204, 204, 204));
        txtUsuario.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        txtUsuario.setForeground(new java.awt.Color(51, 51, 51));
        txtUsuario.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        background.add(txtUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 230, 560, 60));

        lblUser.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        lblUser.setForeground(new java.awt.Color(51, 51, 51));
        lblUser.setText("Ingrese su usuario:");
        background.add(lblUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 140, 330, 50));

        txtPassword.setBackground(new java.awt.Color(204, 204, 204));
        txtPassword.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        txtPassword.setForeground(new java.awt.Color(51, 51, 51));
        txtPassword.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        background.add(txtPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 430, 560, 60));

        lblInicioSesion.setFont(new java.awt.Font("Segoe UI", 1, 48)); // NOI18N
        lblInicioSesion.setForeground(new java.awt.Color(51, 51, 51));
        lblInicioSesion.setText("INICIO SESION");
        background.add(lblInicioSesion, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 40, -1, -1));

        btnMostrar.setBackground(new java.awt.Color(102, 102, 0));
        btnMostrar.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        btnMostrar.setForeground(new java.awt.Color(255, 255, 255));
        btnMostrar.setText("VER");
        btnMostrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMostrarActionPerformed(evt);
            }
        });
        background.add(btnMostrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 430, 160, 60));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(background, javax.swing.GroupLayout.DEFAULT_SIZE, 1060, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(background, javax.swing.GroupLayout.DEFAULT_SIZE, 685, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnEntrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEntrarActionPerformed
        validarDatos(validarEspaciosRellenos());
    }//GEN-LAST:event_btnEntrarActionPerformed

    //Muestra o oculta los caracteres del password.
    private void btnMostrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMostrarActionPerformed
        if(estado == false){ //password oculta
            txtPassword.setEchoChar( (char) 0);
            estado = true;
            btnMostrar.setText("OCULTAR");
        }else{
            txtPassword.setEchoChar('*');
            estado = false;
            btnMostrar.setText("VER");
        }
    }//GEN-LAST:event_btnMostrarActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);
                crearUsuariosPreestablecidos();
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel background;
    private javax.swing.JButton btnEntrar;
    private javax.swing.JButton btnMostrar;
    private javax.swing.JLabel lblInicioSesion;
    private javax.swing.JLabel lblPass;
    private javax.swing.JLabel lblUser;
    private javax.swing.JPasswordField txtPassword;
    private javax.swing.JTextField txtUsuario;
    // End of variables declaration//GEN-END:variables
}
