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

    public DetalleVentaServicio(Servicios servicios, String detalle) {
        this.servicios = servicios;
        this.detalle = detalle;
    }

    @Override
    public String toString() {
        return "DetalleVentaServicio{" + "servicios=" + servicios + ", detalle=" + detalle + '}';
    }
}
