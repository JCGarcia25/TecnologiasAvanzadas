/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package tecnologias;

/**
 *
 * @author johancgarcia
 */
public class Tecnologias {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {
        // instanciar la conexión a base de datos
        Conexion conexion = new Conexion();
        
        // Instanciar la clase para realizar el login de los usuarios en la aplicacion
        LoginUsuarios login = new LoginUsuarios(conexion);

        // Generar personas
        Persona persona1 = new Persona("johan", 21, 1006700371);
        Persona persona2 = new Persona();
        
        // Generar Estudiante - Empleado - Docente
        Estudiante estudiante = new Estudiante("Nelson", 23, 1121967543, "Unillanos");
        
        Empleado empleado = new Empleado("Daniel", 20, 1002735678, "TL");
        
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
        Usuario usuario1 = new Usuario("johan", "johan");
        Usuario usuario2 = new Usuario("esneyder", "caicedo");
        
        // Instanciar plataformas
        Plataforma plataforma1 = new Plataforma("Netflix");
        Plataforma plataforma2 = new Plataforma("HBO");
 
        // Instaciar los usuarios registrados, dependerá de si este está o no resgitrado en DB
        UsuarioRegistrado usuarioR1 = new UsuarioRegistrado(usuario1, login, plataforma1);
        UsuarioRegistrado usuarioR2 = new UsuarioRegistrado(usuario2, login, plataforma2);
        
        // Guardar factura en la base de datos
        String respuesta = factura1.guardarFactura("123", detalleVentaServicio.getDetalle());
        System.out.println(respuesta);
    }
    
}
