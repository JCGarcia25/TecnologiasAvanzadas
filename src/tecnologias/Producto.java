package tecnologias;

class Producto {

    private String nombre;
    private float valor;
    private String ubicacion;
    private int cantidad;

    public Producto(String nombre, float valor, String ubicacion, int cantidad) {
        this.nombre = nombre;
        this.valor = valor;
        this.ubicacion = ubicacion;
        this.cantidad = cantidad;
    }

    public String getNombre() {
        return nombre;
    }

    public float getValor() {
        return valor;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    @Override
    public String toString() {
        return "Producto{" + "nombre=" + nombre + ", valor=" + valor + ", ubicacion=" + ubicacion + ", cantidad=" + cantidad + '}';
    }
}
