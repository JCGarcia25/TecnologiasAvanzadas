/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tecnologias;

/**
 *
 * @author Estudiante_MCA
 */
class DetalleVentaServicio {
    
    private Servicio servicio;
    private String detalle;
    private float precio;

    public DetalleVentaServicio(Servicio servicio, String detalle, float precio) {
        this.servicio = servicio;
        this.detalle = detalle;
        this.precio = precio;
    }

    public String getDetalle() {
        return detalle;
    }
    
    public double aplicarDescuento()
    {
        return this.precio - (this.precio * 0.2);
    }

    @Override
    public String toString() {
        return "DetalleVentaServicio{" + "servicio=" + servicio + ", detalle=" + detalle + ", precio=" + precio + '}';
    }
}
