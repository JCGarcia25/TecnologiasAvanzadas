/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package tecnologias;

/**
 *
 * @author johancgarcia
 */
import java.util.Scanner;
import java.util.List;

public class Tecnologias {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {
        // instanciar la conexión a base de datos
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        Scanner scanner = new Scanner(System.in);

        // Crear un nuevo usuario con los tres argumentos requeridos
        System.out.print("Crearemos 2 usuarios ");
        Usuario nuevoUsuario = new Usuario(0, "Nelson Arango", "123");
        boolean exitoCreacion = usuarioDAO.agregarUsuario(nuevoUsuario);
        if (exitoCreacion) {
            System.out.println("Usuario creado con éxito.");
        } else {
            System.out.println("Error al crear el usuario.");
        }
        Usuario nuevoUsuario2 = new Usuario(0, "Brayan Avila", "123");
        boolean exitoCreacion2 = usuarioDAO.agregarUsuario(nuevoUsuario2);
        if (exitoCreacion2) {
            System.out.println("Usuario creado con éxito.");
        } else {
            System.out.println("Error al crear el usuario.");
        }

        System.out.println("Lista de todos los usuarios:");
        usuarioDAO.obtenerTodosLosUsuarios();

        System.out.println("Editaremos el usuario Brayan Avila");
        boolean exitoEdicion = usuarioDAO.editarUsuario(2, "Martin Avila", "123");
        if (exitoEdicion) {
            System.out.println("Usuario editado con éxito.");
        } else {
            System.out.println("Error al editar el usuario.");
        }

        System.out.println("Lista de todos los usuarios:");
        usuarioDAO.obtenerTodosLosUsuarios();

        System.out.println("Ahora vamos a eliminar el usuario Nelson Arango");
        boolean eliminacionExitosa = usuarioDAO.eliminarUsuario(1);
        if (eliminacionExitosa) {
            System.out.println("Usuario eliminado con éxito.");
        } else {
            System.out.println("Error al eliminar el usuario.");
        }

        System.out.println("Lista de todos los usuarios:");
        usuarioDAO.obtenerTodosLosUsuarios();

        Conexion conexion = new Conexion();
        
        // Instanciar la clase para realizar el login de los usuarios en la aplicacion
        LoginUsuarios login = new LoginUsuarios(conexion);

        // Generar personas
        Persona persona1 = new Persona("johan", 21, 1006700371);
        Persona persona2 = new Persona();
        
        // Generar Estudiante - Empleado - Docente
        Estudiante estudiante = new Estudiante("Nelson", 23, 1121967543, "Unillanos");
        
        // Generar Empleado
        Empleado empleado = new Empleado("Daniel", 20, 1002735678, "TL");
        
        // Generar Docente
        Docente docente = new Docente("FajarGOD", 65, 77777777);
        
        

        // Instanciar cargo - Empresa
        Cargo cargo = new Cargo("Ingeniero");
        
        Empresa empresa = new Empresa("ignicion games");
        
        // Instanciar servicios
        Servicios servicio1 = new Servicios("programar");
        Servicios servicio2 = new Servicios("diseñar");
        
        DetalleVentaServicio detalleVentaServicio = new DetalleVentaServicio(servicio1, "se hizo la chamba", 10000);
        
        VentaServicio ventaServicio = new VentaServicio(persona2, detalleVentaServicio, 1);

        // Generar Persona Cargo
        PersonaCargo personaCargo1 = new PersonaCargo(docente, cargo, empresa);
        
        // Generar Facturacion
        Facturacion factura1 = new Facturacion(ventaServicio, "1");
        
        // Parte derecha LOGIN
        Usuario usuario1 = new Usuario(0,"johan", "johan");
        Usuario usuario2 = new Usuario(0,"esneyder", "caicedo");
        
        // Instanciar plataformas
        Plataforma plataforma1 = new Plataforma("Netflix");
        Plataforma plataforma2 = new Plataforma("HBO");
 
        // Instaciar los usuarios registrados, dependerá de si este está o no resgitrado en DB
        UsuarioRegistrado usuarioR1 = new UsuarioRegistrado(usuario1, login, plataforma1);
        UsuarioRegistrado usuarioR2 = new UsuarioRegistrado(usuario2, login, plataforma2);
        
        // Generamos cuantos estudiantes estan registrados por materia
        String estudiantesMaterias = docente.estudiantesPorMateria();
        System.out.println(estudiantesMaterias);
        
        // Generamos cuales son las notas del estudiante por materia
        String notasPorMateria = estudiante.notasPorMateria();
        System.out.println(notasPorMateria);
        
        // Guardar factura en la base de datos
        String respuesta = factura1.guardarFactura("123", detalleVentaServicio.getDetalle());
        System.out.println(respuesta);
        
        // Aplicamos el descuento en la factura
        Double detalleServicio = detalleVentaServicio.aplicarDescuento();
        System.out.println("Con el descuento quedaria en: $" + detalleServicio);
        
        // Generamos la fecha de las proximas vacaciones del empleado
        String vacaciones = empleado.proximasVacaciones();
        System.out.println( vacaciones);
        
        // Mostramos el cargo actual para luego modificarlo
        System.out.println( "Cargo Actual: " + cargo.getNombre());
        cargo.cambiarCargo("Arquitecto");
        // Mostramos el cargo modificado
        System.out.println( "Cargo cambiado: " + cargo.getNombre());
        
        // Mostramos cuando seran las proximas contrataciones de la empresa
        String contrataciones = empresa.proximasContrataciones();
        System.out.println( contrataciones);
    }
}
