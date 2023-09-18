/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tecnologias;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Pyke
 */
public class EmpresaDAO {
    private Connection conexion;

    public EmpresaDAO() {
        Conexion conexionDB = new Conexion();
        conexion = conexionDB.getConexion();    
    }

    public boolean agregarEmpresa(Empresa empresa) {
        String query = "INSERT INTO empresas (nombre, direccion, max_empleados, actual_empleados) VALUES (?, ?, ?, ?)";
        try (PreparedStatement statement = conexion.prepareStatement(query)) {
            statement.setString(1, empresa.getNombre());
            statement.setString(2, empresa.getDireccion());
            statement.setInt(3, empresa.getMaxEmpleados());
            statement.setInt(4, empresa.getActualEmpleados());
            int rowsInserted = statement.executeUpdate();
            System.out.println("Empresa creada con éxito.");
            return rowsInserted > 0;
        } catch (SQLException e) {
            System.out.println("Error al crear la empresa.");
            e.printStackTrace();
            return false;
        }
    }

    public Empresa obtenerTodasLasEmpresas() {
    String query = "SELECT * FROM empresas";
        try (PreparedStatement statement = conexion.prepareStatement(query)) {
            ResultSet resultSet = statement.executeQuery();
            
            while (resultSet.next()) {
                    int id = resultSet.getInt("id");
                    String nombre = resultSet.getString("nombre");
                    String direccion = resultSet.getString("direccion");
                    int max_empleados = resultSet.getInt("max_empleados");
                    int actual_empleados = resultSet.getInt("actual_empleados");
                    System.out.println("ID: " + id + 
                            ", Nombre: " + nombre +
                            ", Direccion: " + direccion +
                            ", Maximo de Empleados: " + max_empleados +
                            ", N° Empleados Actuales: " + actual_empleados);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public boolean editarEmpresa(Empresa empresa) {
        String query = "UPDATE empresas SET nombre = ?, direccion = ?, max_empleados = ?, actual_empleados = ? WHERE id = ?";
        try (PreparedStatement statement = conexion.prepareStatement(query)) {
            statement.setString(1, empresa.getNombre());
            statement.setString(2, empresa.getDireccion());
            statement.setInt(3, empresa.getMaxEmpleados());
            statement.setInt(4, empresa.getActualEmpleados());
            statement.setInt(5, empresa.getId());
            int rowsUpdated = statement.executeUpdate();
            System.out.println("Empresa editada con éxito.");
            return rowsUpdated > 0;
        } catch (SQLException e) {
            System.out.println("Error al editar la empresa.");
            e.printStackTrace();
            return false;
        }
    }

    public boolean eliminarEmpresa(int id) {
        String query = "DELETE FROM empresas WHERE id = ?";
        try (PreparedStatement statement = conexion.prepareStatement(query)) {
            statement.setInt(1, id);
            int rowsDeleted = statement.executeUpdate();
            System.out.println("Empresa eliminada con éxito.");
            return rowsDeleted > 0;
        } catch (SQLException e) {
            System.out.println("Error al eliminar la empresa.");
            e.printStackTrace();
            return false;
        }
    }
}

