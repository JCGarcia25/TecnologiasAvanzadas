package tecnologias;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class ProductoDAO extends BaseConexion {
    
    public boolean agregarProducto(Producto producto) {
        String query = "INSERT INTO " + producto.getUbicacion() + " (valor, nombre, cantidad) VALUES (?, ?, ?)";
        try (PreparedStatement statement = conexion.prepareStatement(query)) {
            statement.setFloat(1, producto.getValor());
            statement.setString(2, producto.getNombre());
            statement.setInt(3, producto.getCantidad());
            int rowsInserted = statement.executeUpdate();
            System.out.println("Producto creado con éxito.");
            return rowsInserted > 0;
        } catch (SQLException e) {
            System.out.println("Error al crear el producto.");
            e.printStackTrace();
            return false;
        }
    }

    public String obtenerProductoVitrina(int id) {
        String query = "SELECT * FROM vitrina WHERE id = ?";
        try (PreparedStatement statement = conexion.prepareStatement(query)) {
            // Establecer el valor del parámetro en la consulta
            statement.setInt(1, id);
            
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                String nombre = resultSet.getString("nombre");
                int cantidad = resultSet.getInt("cantidad");
                float valor = resultSet.getInt("valor");

                return "Producto{" + "nombre=" + nombre + ", cantidad=" + cantidad + ", valor: " + valor +'}';
            }
           
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return "";
    }
    
    public String obtenerProductoBodega(int id) {
        String query = "SELECT * FROM bodega WHERE id = ?";
        try (PreparedStatement statement = conexion.prepareStatement(query)) {
            // Establecer el valor del parámetro en la consulta
            statement.setInt(1, id);

            ResultSet resultSet = statement.executeQuery();
            
            if (resultSet.next()) {
                String nombre = resultSet.getString("nombre");
                int cantidad = resultSet.getInt("cantidad");
                float valor = resultSet.getInt("valor");

                return "Producto{" + "nombre=" + nombre + ", cantidad=" + cantidad + ", valor: " + valor +'}';
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return "";
    }

    public boolean editarProducto(int id, Producto producto) {
        String query = "UPDATE " + producto.getUbicacion() + " SET valor = ?, nombre = ?, cantidad = ? WHERE id = ?";
        try (PreparedStatement statement = conexion.prepareStatement(query)) {
            statement.setFloat(1, producto.getValor());
            statement.setString(2, producto.getNombre());
            statement.setInt(3, producto.getCantidad());
            statement.setInt(4, id);
            int rowsUpdated = statement.executeUpdate();
            System.out.println("Producto editado con éxito.");
            return rowsUpdated > 0;
        } catch (SQLException e) {
            System.out.println("Error al editar el producto.");
            e.printStackTrace();
            return false;
        }
    }

    public boolean eliminarProductoVitrina(int id) {
        String query = "DELETE FROM vitrina WHERE id = ?";
        try (PreparedStatement statement = conexion.prepareStatement(query)) {
            statement.setInt(1, id);
            int rowsDeleted = statement.executeUpdate();
            System.out.println("Producto eliminado de la vitrina con éxito.");
            return rowsDeleted > 0;
        } catch (SQLException e) {
            System.out.println("Error al eliminar el producto.");
            e.printStackTrace();
            return false;
        }
    }
    
    public boolean eliminarProductoBodega(int id) {
        String query = "DELETE FROM bodega WHERE id = ?";
        try (PreparedStatement statement = conexion.prepareStatement(query)) {
            statement.setInt(1, id);
            int rowsDeleted = statement.executeUpdate();
            System.out.println("Producto eliminado de la bodega con éxito.");
            return rowsDeleted > 0;
        } catch (SQLException e) {
            System.out.println("Error al eliminar el producto.");
            e.printStackTrace();
            return false;
        }
    }
}
