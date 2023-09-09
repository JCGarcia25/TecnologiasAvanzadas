/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tecnologias;

/**
 *
 * @author Estudiante_MCA
 */
class VentaServicio {
    
    private Persona persona;
    private DetalleVentaServicio detalleVentaServicio;
    private int numero_venta;

    public VentaServicio(Persona persona, DetalleVentaServicio detalleVentaServicio, int numero_venta)
    {
        this.persona = persona;
        this.detalleVentaServicio = detalleVentaServicio;
        this.numero_venta = numero_venta;
    }

    @Override
    public String toString() {
        return "VentaServicio{" + "persona=" + persona + ", detalleVentaServicio=" + detalleVentaServicio + ", numero_venta=" + numero_venta + '}';
    }
}
