package tecnologias;

import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;

class Conexion {
    
    private static volatile Conexion instance;
    private Connection connection;

    private Conexion()
    {
        // Si la conexión aún no existe o está cerrada, crea una nueva
        if (connection == null) {
            JOptionPane.showMessageDialog(null, "Creando nueva conexion");
            try {
                Class.forName(PropertiesManager.getDriver());
                String url = getUrl();
                connection = DriverManager.getConnection(url, PropertiesManager.getUsername(), PropertiesManager.getPassword());
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e.getMessage());
            }
        }
    }
    
    public Connection getConexion() {
        return connection;
    }
    
    public static synchronized Conexion getInstance() {
        if (instance == null) { // Bloqueo doble para la seguridad de los hilos
            instance = new Conexion(); // Crea la instancia si no existe
        }
        return instance;
    }
    
    private String getUrl()
    {
       return "jdbc:" + PropertiesManager.getConection() + "://"+ PropertiesManager.getHost() +":"+ PropertiesManager.getPort()+"/"+ PropertiesManager.getDatabase(); 
    }
}


