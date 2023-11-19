package tecnologias;

/**
 *
 * @author Estudiante_MCA
 */
class Servicio {
    
    private String nombre;

    public Servicio(String nombre) 
    {
        this.nombre = nombre;
    }
    
    public void cancelarServicio(Servicio servicio)
    {
        servicio = null;
    }

    @Override
    public String toString() {
        return "Servicio{" + "nombre=" + nombre + '}';
    }
}
