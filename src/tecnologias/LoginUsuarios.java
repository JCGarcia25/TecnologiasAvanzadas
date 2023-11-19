/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tecnologias;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Estudiante_MCA
 */
class LoginUsuarios {
    
    private Connection conexion; // Conexión a la base de datos
    private String usuario;
    private String contraseña;

    public LoginUsuarios() {
        conexion = Conexion.getInstance().getConexion();
    }

    // Método para verificar las credenciales de inicio de sesión
    public boolean Autentificacion(String usuario, String contraseña) {
        
        String consulta = "SELECT * FROM usuarios WHERE usuario = ? AND contraseña = ?";
        try {
            PreparedStatement ps = conexion.prepareStatement(consulta);
            ps.setString(1, usuario);
            ps.setString(2, contraseña);
            ResultSet rs = ps.executeQuery();
            return rs.next(); // Devuelve true si se encuentra un usuario con esas credenciales
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
            //e.printStackTrace();
            return false; // En caso de error, devuelve false
        }
    }

    @Override
    public String toString() {
        return "LoginUsuarios{" + "usuario=" + usuario + ", contrase\u00f1a=" + contraseña + '}';
    }
}
