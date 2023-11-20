package tecnologias;

import java.sql.Connection;
import javax.swing.JOptionPane;

class Conexion {
    
    private static volatile Conexion instance;
    
    private IConexion iConexion;

    private Conexion()
    {
        try {
            switch (PropertiesManager.getConection()) {
                case "postgresql":
                    iConexion = ConexionPostgresql.getInstance();
                    break;
                case "mysql":
                    iConexion = ConexionMysql.getInstance();
                    break;
                default:
                    throw new AssertionError();
            }
        } catch (Exception e) {
            e.printStackTrace();

            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
        }
    }
    
    public Connection getConexion() {
        return iConexion.getConexion();
    }
    
    public static synchronized Conexion getInstance() {
        if (instance == null) { // Bloqueo doble para la seguridad de los hilos
            instance = new Conexion(); // Crea la instancia si no existe
        }
        return instance;
    }
}


