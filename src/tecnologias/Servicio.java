package tecnologias;

/**
 *
 * @author Estudiante_MCA
 */
class Servicio {
    
    private String nombre;
    private int id;

    public Servicio(String nombre) 
    {
        this.nombre = nombre;
    }
    
    public void cancelarServicio(Servicio servicio)
    {
        servicio = null;
    }
    
    public int getId() {
        return id;
    }
    
    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    @Override
    public String toString() {
        return "Servicio{" + "nombre=" + nombre + '}';
    }
}
