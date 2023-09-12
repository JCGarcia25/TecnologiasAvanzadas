/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tecnologias;

import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;

/**
 *
 * @author johancgarcia
 */
class Conexion {
    
    private final String HOST = "localhost";
    private final String PUERTO = "5432";
    private final String DB = "tecnologias";
    private final String USER = "postgres";
    private final String PASSWORD = "root";
    
    public Connection getConexion()
    {
        Connection conexion = null;
        
        try {
            Class.forName("org.postgresql.Driver");
            String url = "jdbc:postgresql://"+HOST+":"+PUERTO+"/"+DB;
            conexion = DriverManager.getConnection(url, USER, PASSWORD);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        
        return conexion;
    }
    
}
