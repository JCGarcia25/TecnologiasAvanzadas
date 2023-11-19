package tecnologias;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class UsuarioDAO extends BaseConexion {

    // Método para agregar un usuario a la base de datos
    public boolean agregarUsuario(Usuario usuario) {
        String query = "INSERT INTO usuarios (usuario, contrasena) VALUES (?, ?)";
        try (PreparedStatement preparedStatement = conexion.prepareStatement(query)) {
            preparedStatement.setString(1, usuario.getNickname());
            preparedStatement.setString(2, usuario.getContraseña());
            int filasAfectadas = preparedStatement.executeUpdate();
            System.out.println("Usuario creado con éxito.");
            return filasAfectadas > 0;
        } catch (SQLException e) {
            System.out.println("Error al crear el usuario.");
            e.printStackTrace();
            return false;
        }
    }

    // Método para obtener un usuario por su ID
    public Usuario obtenerUsuarioPorId(int id) {
        String query = "SELECT * FROM usuarios WHERE id = ?";
        try (PreparedStatement preparedStatement = conexion.prepareStatement(query)) {
            preparedStatement.setInt(1, id);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    String usuario = resultSet.getString("usuario");
                    String contraseña = resultSet.getString("contraseña");
                    return new Usuario(usuario, contraseña);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    // Método para actualizar un usuario existente
    public boolean editarUsuario(int idUsuario, String nuevoNombreUsuario, String nuevaContraseña) {
        String query = "UPDATE usuarios SET usuario = ?, contrasena = ? WHERE id = ?";
        try (PreparedStatement preparedStatement = conexion.prepareStatement(query)) {
            preparedStatement.setString(1, nuevoNombreUsuario);
            preparedStatement.setString(2, nuevaContraseña);
            preparedStatement.setInt(3, idUsuario);

            int filasAfectadas = preparedStatement.executeUpdate();
            System.out.println("Usuario editado con éxito.");
            return filasAfectadas > 0;
        } catch (SQLException e) {
            System.out.println("Error al editar el usuario.");
            e.printStackTrace();
            return false;
        }
    }

    public void obtenerTodosLosUsuarios() {
        String query = "SELECT * FROM usuarios";

        try (PreparedStatement preparedStatement = conexion.prepareStatement(query)) {
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String usuario = resultSet.getString("usuario");
                String contrasena = resultSet.getString("contrasena");

                System.out.println("ID: " + id + ", Usuario: " + usuario);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Método para eliminar un usuario por su ID
    public boolean eliminarUsuario(int id) {
        String query = "DELETE FROM usuarios WHERE id = ?";
        try (PreparedStatement preparedStatement = conexion.prepareStatement(query)) {
            preparedStatement.setInt(1, id);
            int filasAfectadas = preparedStatement.executeUpdate();
            System.out.println("Usuario eliminado con éxito.");
            return filasAfectadas > 0;
        } catch (SQLException e) {
            System.out.println("Error al eliminar el usuario.");
            e.printStackTrace();
            return false;
        }
    }
   
    public int numUsuariosRegistrados() {

        String consulta = "SELECT COUNT(*) FROM usuarios";

        try (PreparedStatement ps = conexion.prepareStatement(consulta);
             ResultSet rs = ps.executeQuery()) {

            if (rs.next()) {
                // Obtenemos el valor del recuento de usuarios desde el ResultSet
                int numUsuarios = rs.getInt(1);
                return numUsuarios;
            } else {
                return 0; // No se encontraron registros
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.err.println("Han ocurrido errores hayando el número de usuarios");
        }
        return 0;
    }
}


