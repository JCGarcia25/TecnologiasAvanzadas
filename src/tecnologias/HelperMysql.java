package tecnologias;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.sql.PreparedStatement;
import java.util.Collections;

class HelperMysql extends BaseConexion implements IHelper {

    @Override
    public String obtenerHora() {
        try {
            Statement statement = conexion.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT CURTIME()");

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
    
    @Override
    public String obtenerFecha() {
        try (
            Statement statement = conexion.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT CURDATE()")) {

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
    
    @Override
    public List<String> totalProductos() {
        List<String> resultados = new ArrayList<>();

        String query = "SELECT nombre, SUM(cantidad) AS cantidad_total, SUM(valor) AS valor_total " +
                       "FROM (SELECT nombre, cantidad, valor FROM vitrina " +
                             "UNION ALL " +
                             "SELECT nombre, cantidad, valor FROM bodega) AS t1 " +
                       "GROUP BY nombre " +
                       "ORDER BY nombre";

        try (PreparedStatement statement = conexion.prepareStatement(query)) {
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                String nombre = resultSet.getString("nombre");
                int cantidadTotal = resultSet.getInt("cantidad_total");
                int valorTotal = resultSet.getInt("valor_total");

                String resultado = String.format("%nNombre: %s, Cantidad Total: %d, Valor Total: %d", nombre, cantidadTotal, valorTotal);
                resultados.add(resultado);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        // Ordenar la lista de resultados alfabéticamente por el nombre
        Collections.sort(resultados);

        return resultados;
    }

    @Override
    public String cantidadTotalProductos() {
        String query = "SELECT SUM(cantidad) AS cantidad_total " +
                       "FROM (" +
                           "SELECT cantidad FROM vitrina " +
                           "UNION ALL " +
                           "SELECT cantidad FROM bodega" +
                       ") AS combined_data";

        try (PreparedStatement statement = conexion.prepareStatement(query)) {
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                int cantidad = resultSet.getInt("cantidad_total");

                return "La cantidad total de productos de bodega y vitrina es: " + cantidad;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return "";
    }

    @Override
    public List<String> diferenciaVitrinaABodega() {
        List<String> resultados = new ArrayList<>();

        String query = "SELECT nombre, cantidad, valor FROM vitrina " +
                       "WHERE nombre NOT IN (SELECT nombre FROM bodega)";

        try (PreparedStatement statement = conexion.prepareStatement(query)) {
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                String nombre = resultSet.getString("nombre");
                int cantidad = resultSet.getInt("cantidad");
                int valor = resultSet.getInt("valor");

                String resultado = String.format("%nNombre: %s, Cantidad: %d, Valor: %d%n", nombre, cantidad, valor);
                resultados.add(resultado);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return resultados;
    }

    @Override
    public List<String> diferenciaBodegaAVitrina() {
        List<String> resultados = new ArrayList<>();

        String query = "SELECT nombre, cantidad, valor FROM bodega " +
                       "WHERE nombre NOT IN (SELECT nombre FROM vitrina)";

        try (PreparedStatement statement = conexion.prepareStatement(query)) {
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                String nombre = resultSet.getString("nombre");
                int cantidad = resultSet.getInt("cantidad");
                int valor = resultSet.getInt("valor");

                String resultado = String.format("%nNombre: %s, Cantidad: %d, Valor: %d%n", nombre, cantidad, valor);
                resultados.add(resultado);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return resultados;
    }
}
