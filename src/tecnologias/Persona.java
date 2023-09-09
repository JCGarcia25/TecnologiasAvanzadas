/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tecnologias;

/**
 *
 * @author Estudiante_MCA
 */
class Persona implements toStringInterface {
    
    protected String nombre;
    protected int edad;
    protected int cedula;

    public Persona () 
    {
        this.nombre = "Default";
        this.edad = 10;
        this.cedula = 41240901;
    }

    public Persona (String nombre, int edad, int cedula)
    {
        this.nombre = nombre;
        this.edad = edad;
        this.cedula = cedula;
    }

    @Override
    public String toString() {
        return "Persona{" + "nombre=" + nombre + ", edad=" + edad + ", cedula=" + cedula + '}';
    }
}
