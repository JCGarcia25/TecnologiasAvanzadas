/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tecnologias;

/**
 *
 * @author Estudiante_MCA
 */
public class Docente extends Persona{
    
    protected String materia;

    public Docente(String nombre, int edad, int cedula, String materia) {
        super(nombre, edad, cedula);
        this.materia = materia;
    }

    @Override
    public String toString() {
        return super.toString() + "Docente{" + "materia=" + materia + '}';
    }
}
