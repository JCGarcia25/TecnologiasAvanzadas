package tecnologias;


class Persona {
    
    protected String nombre;
    protected int edad;
    protected int telefono;

    public Persona () 
    {
        this.nombre = "Default";
        this.edad = 10;
        this.telefono = 41240901;
    }

    public Persona (String nombre, int edad, int telefono)
    {
        this.nombre = nombre;
        this.edad = edad;
        this.telefono = telefono;
    }

    @Override
    public String toString() {
        return "Persona{" + "nombre=" + nombre + ", edad=" + edad + ", telefono=" + telefono + '}';
    }
}
