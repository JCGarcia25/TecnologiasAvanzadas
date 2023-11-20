package tecnologias;

import java.sql.Connection;


public interface IConexion {
    
    public String getUrl();
    
    public Connection getConexion();
}
