package tecnologias;

import java.time.LocalDate;

/**
 *
 * @author Estudiante_MCA
 */
class Facturacion {
        
    private VentaServicio ventaServicio;
    private String getCodigoFactura;
    private String fecha = LocalDate.now().toString();
    private int id;

    public Facturacion(VentaServicio ventaServicio, String getCodigoFactura) {
        this.ventaServicio = ventaServicio;
        this.getCodigoFactura = getCodigoFactura;
    }

    public VentaServicio getVentaServicio() {
        return ventaServicio;
    }

    public String getCodigoFactura() {
        return getCodigoFactura;
    }

    public String getFecha() {
        return fecha;
    }

    public int getId() {
    return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    @Override
    public String toString() {
        return "Facturacion{" + "ventaServicio=" + ventaServicio + ", getCodigoFactura=" + getCodigoFactura + ", fecha=" + fecha + '}';
    }
}
