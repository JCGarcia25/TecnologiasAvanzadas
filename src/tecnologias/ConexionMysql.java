package tecnologias;

import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;

class ConexionMysql implements IConexion {
    
    private static volatile ConexionMysql instance;
    private Connection connection;
    
    private ConexionMysql()
    {
        if (connection == null) {
            JOptionPane.showMessageDialog(null, "Creando nueva conexion MySQL");
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                String url = getUrl();
                connection = DriverManager.getConnection(url, PropertiesManager.getUsername(), PropertiesManager.getPassword());
            } catch (Exception e) {
                e.printStackTrace();
                
                JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
            }
        }
    }
    
    public static synchronized ConexionMysql getInstance() {
        if (instance == null) {
            instance = new ConexionMysql();
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
