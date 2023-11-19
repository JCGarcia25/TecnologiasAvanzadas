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
    private Connection conexion;

    public UsuarioRegistrado(Usuario usuario, LoginUsuarios login, Plataforma plataforma) {
        
        conexion = Conexion.getInstance().getConexion();
        
        this.login = login;
        
        // Verificar si el usuario está registrado en la base de datos
        if (login.Autentificacion(usuario.getNickname(), usuario.getContraseña())) {
            this.usuario = usuario;
            this.plataforma = plataforma;
            System.out.println("El usuario: " + usuario.getNickname()+ " Ha ingresado");
        } else {
            System.out.println("El usuario: " + usuario.getNickname()+ " Tiene credenciales invalidas");
            // Puedes manejar la excepción de acuerdo a tus necesidades
        }
    }
    
    @Override
    public String toString() {
        return "UsuarioRegistrado{" + "usuario=" + usuario + ", login=" + login + ", plataforma=" + plataforma + '}';
    } 
}
