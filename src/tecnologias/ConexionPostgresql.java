package tecnologias;

import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;

class ConexionPostgresql implements IConexion {
    
    private static volatile ConexionPostgresql instance;
    private Connection connection;
    
    private ConexionPostgresql()
    {
        if (connection == null) {
            JOptionPane.showMessageDialog(null, "Creando nueva conexion PostgreSQL");
            try {
                Class.forName("org.postgresql.Driver");
                String url = getUrl();
                connection = DriverManager.getConnection(url, PropertiesManager.getUsername(), PropertiesManager.getPassword());
            } catch (Exception e) {
                e.printStackTrace();
                
                JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
            }
        }
    }
    
    public static synchronized ConexionPostgresql getInstance() {
        if (instance == null) {
            instance = new ConexionPostgresql();
        }
        return instance;
    }

    @Override
    public Connection getConexion() {
        return connection;
    }

    @Override
    public String getUrl()
    {
       return "jdbc:" + PropertiesManager.getConection() + "://"+ PropertiesManager.getHost() +":"+ PropertiesManager.getPort()+"/"+ PropertiesManager.getDatabase(); 
    }
}
