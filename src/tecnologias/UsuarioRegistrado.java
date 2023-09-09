/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tecnologias;

/**
 *
 * @author Estudiante_MCA
 */
public class UsuarioRegistrado {
    
    private Usuario usuario;
    private LogUsuarios login;
    private Plataforma plataforma;

    public UsuarioRegistrado(Usuario usuario, LogUsuarios login, Plataforma plataforma) {
        this.usuario = usuario;
        this.login = login;
        this.plataforma = plataforma;
    }

    @Override
    public String toString() {
        return "UsuarioRegistrado{" + "usuario=" + usuario + ", login=" + login + ", plataforma=" + plataforma + '}';
    }
    
    
}
