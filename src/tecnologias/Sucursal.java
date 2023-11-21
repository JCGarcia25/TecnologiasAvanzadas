package tecnologias;

import java.util.ArrayList;
import java.util.List;

class Sucursal {
    
    private String nombre;
    private String direccion;
    private Empresa empresa;
    private List<Producto> productos;
    
    public Sucursal(String nombre, String direccion, Empresa empresa, List<Producto> productos) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.empresa = empresa;
        this.productos = new ArrayList<>();
    }

    public void agregarProducto (Producto producto) {
        this.productos.add(producto);
    }

    public void eliminarProducto (Producto producto) {
        this.productos.remove(producto);
    }
}
