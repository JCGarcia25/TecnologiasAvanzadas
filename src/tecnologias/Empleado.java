/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tecnologias;

/**
 *
 * @author Estudiante_MCA
 */
public class Empleado extends Persona {
    
    protected String cargo;
    
    public Empleado (String nombre, int edad, int cedula, String cargo)
    {
        super(nombre, edad, cedula);
        this.cargo = cargo;
    }

    @Override
    public String toString() {
        return super.toString() + "Empleado{" + "cargo=" + cargo + '}';
    }
}
