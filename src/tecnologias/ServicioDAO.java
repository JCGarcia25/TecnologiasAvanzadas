package tecnologias;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ServicioDAO extends BaseConexion {

    public boolean agregarServicio(Servicio servicio) {
        String query = "INSERT INTO servicios (nombre) VALUES (?)";

            try (PreparedStatement statement = conexion.prepareStatement(query)) {
            statement.setString(1, servicio.getNombre());

            int rowsInserted = statement.executeUpdate();
            System.out.println("Factura creada con éxito.");
            return rowsInserted > 0;
        } catch (SQLException e) {
            System.out.println("Error al crear la Factura.");
            e.printStackTrace();
            return false;
        }
    }
        
    public void obtenerTodasLasFacturas() {
        String query = "SELECT * FROM facturas";
        try (PreparedStatement statement = conexion.prepareStatement(query)) {
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String codigoFactura = resultSet.getString("codigo_factura");
                String detalles = resultSet.getString("detalles");
                String fecha = resultSet.getString("fecha");
                System.out.println("ID: " + id +
                        ", Código de Factura: " + codigoFactura +
                        ", Detalles: " + detalles +
                        ", Fecha: " + fecha);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void obtenerTodosLosServicios() {
        String query = "SELECT * FROM servicios";

        try (PreparedStatement statement = conexion.prepareStatement(query)) {
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String nombre = resultSet.getString("nombre");
                System.out.println("ID: " + id +
                        ", Nombre: " + nombre
                        );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public boolean eliminarServicio(int id) {
        String query = "DELETE FROM servicios WHERE id = ?";
        try (PreparedStatement statement = conexion.prepareStatement(query)) {
            statement.setInt(1, id);

            int rowsDeleted = statement.executeUpdate();
            System.out.println("Servicio eliminada con éxito.");
            return rowsDeleted > 0;
        } catch (SQLException e) {
            System.out.println("Error al eliminar la Servicio.");
            e.printStackTrace();
            return false;
        }
    }
}
