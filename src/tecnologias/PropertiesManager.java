package tecnologias;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesManager {
    private static Properties properties;

    static {
        properties = new Properties();
        try {
            // Obtener la ruta al escritorio del usuario
            String desktopPath = System.getProperty("user.home") + "/Desktop";
            // Construir la ruta completa al archivo config.properties
            String configPath = desktopPath + "/config.properties";

            // Cargar las propiedades desde el archivo
            try (InputStream input = new FileInputStream(configPath)) {
                properties.load(input);
            }
        } catch (IOException e) {
            e.printStackTrace();
            // Manejar la excepción apropiadamente
        }
    }
    
    public static String getConection()
    {
        return properties.getProperty("db.connection");
    }
    
    public static String getHost()
    {
        return properties.getProperty("db.host");
    }
    
    public static String getPort()
    {
        return properties.getProperty("db.port");
    }
    
    public static String getDatabase()
    {
        return properties.getProperty("db.database");
    }
    
    public static String getUsername()
    {
        return properties.getProperty("db.username");
    }
    
    public static String getPassword()
    {
        return properties.getProperty("db.password");
    }
    
    public static String getDriver()
    {
        return properties.getProperty("db.driver");
    }
}
