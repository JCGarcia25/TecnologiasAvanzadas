/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tecnologias;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Estudiante_MCA
 */
class UsuarioRegistrado {
    
    private Usuario usuario;
    private LoginUsuarios login;
    private Plataforma plataforma;

    public UsuarioRegistrado(Usuario usuario, LoginUsuarios login, Plataforma plataforma) {
        this.login = login;
        
        // Verificar si el usuario está registrado en la base de datos
        if (login.Autentificacion(usuario.getUsuario(), usuario.getContraseña())) {
            this.usuario = usuario;
            this.plataforma = plataforma;
            System.out.println("El usuario: " + usuario.getUsuario() + " Ha ingresado");
        } else {
            System.out.println("El usuario: " + usuario.getUsuario() + " Tiene credenciales invalidas");
            // Puedes manejar la excepción de acuerdo a tus necesidades
        }
    }
    
    public int numUsuariosRegistrados()
    {
        Conexion conn = new Conexion();
        Connection conexion = conn.getConexion(); // Obtener la conexión

        String consulta = "SELECT COUNT(*) FROM usuarios";

        try (PreparedStatement ps = conexion.prepareStatement(consulta);
             ResultSet rs = ps.executeQuery()) {

            if (rs.next()) {
                // Obtenemos el valor del recuento de usuarios desde el ResultSet
                int numUsuarios = rs.getInt(1);
                return numUsuarios;
            } else {
                return 0; // No se encontraron registros
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.err.println("Han ocurrido errores hayando el número de usuarios");
        }
    }

    @Override
    public String toString() {
        return "UsuarioRegistrado{" + "usuario=" + usuario + ", login=" + login + ", plataforma=" + plataforma + '}';
    } 
}
