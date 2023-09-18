/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tecnologias;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

/**
 *
 * @author Estudiante_MCA
 */
class Facturacion {
        
    private int id;
    private VentaServicio ventaServicio;
    private String codigo_factura;
    private String fecha = LocalDate.now().toString();

    public Facturacion(VentaServicio ventaServicio, String codigo_factura) {
        this.ventaServicio = ventaServicio;
        this.codigo_factura = codigo_factura;
    }
    
    public String guardarFactura(String codigo_factura, String detalles) {

        Conexion conn = new Conexion();
        Connection conexion = conn.getConexion();
        String consulta = "INSERT INTO facturas (codigo_factura, detalles, fecha) VALUES (?, ?, ?)";

        try {
            // Pasamos los valores al query
            PreparedStatement ps = conexion.prepareStatement(consulta);
            ps.setString(1, codigo_factura);
            ps.setString(2, detalles);
            ps.setString(3, this.fecha);

            // Ejecutar el query
            int filasAfectadas = ps.executeUpdate();
            
            if (filasAfectadas > 0) {
                conexion.close();
                return "Guardado con éxito";
            } else {
                conexion.close();
                return "No se pudo guardar la factura";
            }
        } catch (SQLException e) {
            System.err.println("Han ocurrido errores al insertar una factura");
            e.printStackTrace();
            return "Error al guardar la factura";
        } finally {
            try {
                if (conexion != null) {
                    conexion.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    
    public String procesoConACID(String detalle) {
        Conexion conn = new Conexion();
        Connection conexion = conn.getConexion();
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
        Conexion conn = new Conexion();
        Connection conexion = conn.getConexion();
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

    @Override
    public String toString() {
        return "Facturacion{" + "ventaServicio=" + ventaServicio + ", codigo_factura=" + codigo_factura + ", fecha=" + fecha + '}';
    }
}
