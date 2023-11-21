package tecnologias;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

class FacturacionDAO extends BaseConexion {
    
        public boolean guardarFactura(Facturacion factura) {

            String query = "INSERT INTO facturas (codigo_factura, detalles, fecha) VALUES (?, ?, ?)";
            try (PreparedStatement statement = conexion.prepareStatement(query)) {
                // Pasamos los valores al query
                statement.setString(1, factura.getCodigoFactura());
                statement.setString(2, factura.getVentaServicio().getDetalleVentaServicio().getDetalle());
                statement.setString(3, factura.getFecha());

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

    public boolean editarFactura(int idFactura, Facturacion factura) {
        String query = "UPDATE facturas SET codigo_factura = ?, detalles = ?, fecha = ? WHERE id = ?";
        try (PreparedStatement statement = conexion.prepareStatement(query)) {
            statement.setString(1, factura.getCodigoFactura());
            statement.setString(2, factura.getVentaServicio().getDetalleVentaServicio().getDetalle()); // Asume que Facturacion tiene un método getDetalles() que deberías agregar
            statement.setString(3, factura.getFecha());
            statement.setInt(4, idFactura);
            int rowsUpdated = statement.executeUpdate();
            System.out.println("Factura editada con éxito.");
            return rowsUpdated > 0;
        } catch (SQLException e) {
            System.out.println("Error al editar la factura.");
            e.printStackTrace();
            return false;
        }
    }

    public boolean eliminarFactura(int id) {
        String query = "DELETE FROM facturas WHERE id = ?";
        try (PreparedStatement statement = conexion.prepareStatement(query)) {
            statement.setInt(1, id);
            int rowsDeleted = statement.executeUpdate();
            System.out.println("Factura eliminada con éxito.");
            return rowsDeleted > 0;
        } catch (SQLException e) {
            System.out.println("Error al eliminar la factura.");
            e.printStackTrace();
            return false;
        }
    }
    
    public String procesoConACID(String detalle) {

        String resultado = "";

        try {
            conexion.setAutoCommit(false);

            // Crear una nueva factura
            String insertQuery = "INSERT INTO facturas (codigo_factura, detalles, fecha) VALUES (?, ?, '2023-09-10')";
            PreparedStatement insertStatement = conexion.prepareStatement(insertQuery);
            insertStatement.setString(1, "111");
            insertStatement.setString(2, "Trabajo realizado");
            insertStatement.executeUpdate();
            resultado += "Factura creada. ";

            // Actualizar la factura recién creada
            String updateQuery = "UPDATE facturas SET detalles = ? WHERE codigo_factura = ?";
            PreparedStatement updateStatement = conexion.prepareStatement(updateQuery);
            updateStatement.setString(1, detalle);
            updateStatement.setString(2, "111");
            updateStatement.executeUpdate();
            resultado += "Factura actualizada. ";

            // Traer el registro actualizado
            String selectQuery = "SELECT * FROM facturas WHERE codigo_factura = ?";
            PreparedStatement selectStatement = conexion.prepareStatement(selectQuery);
            selectStatement.setString(1, "111");
            ResultSet rs = selectStatement.executeQuery();

            if (rs.next()) {
                resultado += "Detalles de la factura: " + rs.getString("detalles");
            }

            // Confirmar la transacción
            conexion.commit();
        } catch (SQLException e) {
            try {
                if (conexion != null) {
                    conexion.rollback();
                    conexion.close();
                }
            } catch (SQLException rollbackException) {
                rollbackException.printStackTrace();
            }
            resultado = "Error en la transacción: " + e.getMessage();
        } 

        return resultado;
    }
    
    public String procesoSinACID(String codigo_factura, String detalle) {

        String resultado = "";

        try {

            // Crear una nueva factura
            String insertQuery = "INSERT INTO facturas (codigo_factura, detalles, fecha) VALUES (?, ?, '2023-09-10')";
            PreparedStatement insertStatement = conexion.prepareStatement(insertQuery);
            insertStatement.setString(1, codigo_factura);
            insertStatement.setString(2, "Trabajo realizado");
            insertStatement.executeUpdate();
            resultado += "Factura creada. ";

            // Actualizar la factura recién creada
        String updateQuery = "UPDATE facturas SET detalles = ? WHERE codigo_factura = ?";
            PreparedStatement updateStatement = conexion.prepareStatement(updateQuery);
            updateStatement.setString(1, detalle);
            updateStatement.setString(2, codigo_factura);
            updateStatement.executeUpdate();
            resultado += "Factura actualizada. ";

            // Traer el registro actualizado
            String selectQuery = "SELECT * FROM facturas WHERE codigo_factura = ?";
            PreparedStatement selectStatement = conexion.prepareStatement(selectQuery);
            selectStatement.setString(1, codigo_factura);
            ResultSet rs = selectStatement.executeQuery();

            if (rs.next()) {
                resultado += "Detalles de la factura: " + rs.getString("detalles");
            }

        } catch (SQLException e) {
            
            try {
                if (conexion != null) {
                    conexion.close();
                }
            } catch (SQLException closeException) {
                //closeException.printStackTrace();
            }
            resultado = "Error en la transacción: " + e.getMessage();
        }

        return resultado;
    }
}
