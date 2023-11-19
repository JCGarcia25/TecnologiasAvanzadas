package tecnologias;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;

class HelperPostgresql extends BaseConexion implements IHelper {

    public String obtenerHora() {
        try {
            Statement statement = conexion.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT CURRENT_TIME");

            if (resultSet.next()) {
                // Obtener la hora del resultado y formatearla si es necesario
                Timestamp timestamp = resultSet.getTimestamp(1);
                SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
                return dateFormat.format(timestamp);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return "Error al obtener la hora";
    }
    
    public String obtenerFecha() {
        try (
            Statement statement = conexion.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT CURRENT_DATE")) {

            if (resultSet.next()) {
                // Obtener la fecha del resultado y formatearla si es necesario
                java.sql.Date date = resultSet.getDate(1);
                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                return dateFormat.format(date);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return "Error al obtener la fecha";
    }
}
