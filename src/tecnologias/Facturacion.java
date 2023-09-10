/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tecnologias;

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

    @Override
    public String toString() {
        return "Facturacion{" + "ventaServicio=" + ventaServicio + ", codigo_factura=" + codigo_factura + ", fecha=" + fecha + '}';
    }
}
