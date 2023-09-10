/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tecnologias;

/**
 *
 * @author Estudiante_MCA
 */
class Cargo implements toStringInterface{
    
    private String nombre;
    private int tiempo_de_cargo = 0;

    public Cargo( String cargo) {
        this.nombre = cargo;
    }
    
    public void cambiarCargo(String cargo)
    {
        this.tiempo_de_cargo = 0;
        this.nombre = cargo;
    }

    @Override
    public String toString() {
        return "Cargo{" + "cargo=" + nombre + ", tiempo_de_cargo=" + tiempo_de_cargo + '}';
    }
}
