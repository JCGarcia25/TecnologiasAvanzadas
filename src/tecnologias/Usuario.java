/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tecnologias;

/**
 *
 * @author Estudiante_MCA
 */
public class Usuario {
    private String usuario;
    private String contraseña;

    public Usuario(String usuario, String contraseña)
    {
        this.usuario = usuario;
        this.contraseña = contraseña;
    }

    public String getUsuario() {
        return usuario;
    }

    public String getContraseña() {
        return contraseña;
    }
    
    public boolean cambiarContraseña(String contraseña)
    {
        if (!contraseña.isEmpty()) {
            this.contraseña = contraseña;
        
            return true;
        } else {
            return false;
        }
        
    }

    @Override
    public String toString() {
        return "Usuario{" + "usuario=" + usuario + ", contrase\u00f1a=" + contraseña + '}';
    }
}
