/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tecnologias;

/**
 *
 * @author Estudiante_MCA
 */
class Estudiante extends Persona{
    
    protected String institucion;
    
    public Estudiante(String nombre, int edad, int cedula, String institucion)
    {
        super(nombre, edad, cedula);
        this.institucion = institucion;
    }
    
    public String getInstitucion()
    {
        return this.institucion;
    }

    @Override
    public String toString() {
        return super.toString() + "Estudiante{" + "institucion=" + institucion + '}';
    }
}
