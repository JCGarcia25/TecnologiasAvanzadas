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

    @Override
    public String toString() {
        return "Facturacion{" + "ventaServicio=" + ventaServicio + ", codigo_factura=" + codigo_factura + ", fecha=" + fecha + '}';
    }
}
