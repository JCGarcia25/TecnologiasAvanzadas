package tecnologias;

import java.sql.Connection;


public class BaseConexion {
    
    protected Connection conexion;

    protected BaseConexion() {
        if (Conexion.getInstance() != null) {
            conexion = Conexion.getInstance().getConexion();
        } else {
            throw new IllegalStateException("La instancia de conexión es nula");
        }
    }
}
