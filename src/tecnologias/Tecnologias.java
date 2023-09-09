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
        // Generar personas
        Persona persona1 = new Persona("johan", 21, 1006700371);
        Persona persona2 = new Persona();
        
        // Generar Estudiante - Empleado - Docente
        Estudiante estudiante = new Estudiante("Nelson", 23, 1121967543, "Unillanos");
        Empleado empleado = new Empleado("Daniel", 20, 1002735678, "TL");
        Docente docente = new Docente("FajarGOD", 65, 77777777, "El papa de Denis Ritch");
        Cargo cargo = new Cargo("Ser faker");
        Empresa empresa = new Empresa("ignicion games");
        Servicios servicio = new Servicios("programar");
        DetalleVentaServicio detalleVentaServicio = new DetalleVentaServicio(servicio, "se hizo la chamba");
        VentaServicio ventaServicio = new VentaServicio(persona2, detalleVentaServicio, 1);

        // Generar Persona Cargo
        PersonaCargo personaCargo1 = new PersonaCargo(docente, cargo, empresa);
        
        // Generar Facturacion
        Facturacion factura1 = new Facturacion(ventaServicio, "1");
        
        System.out.println(factura1.toString());
        System.out.println(personaCargo1.toString());
    }
    
}
