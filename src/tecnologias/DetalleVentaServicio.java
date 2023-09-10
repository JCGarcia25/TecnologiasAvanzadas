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
    
    private Servicios servicios;
    private String detalle;
    private float precio;

    public DetalleVentaServicio(Servicios servicios, String detalle, float precio) {
        this.servicios = servicios;
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
        return "DetalleVentaServicio{" + "servicios=" + servicios + ", detalle=" + detalle + '}';
    }
}
