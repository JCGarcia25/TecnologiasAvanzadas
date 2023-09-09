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
    
    private String cargo;

    public Cargo( String cargo) {
        this.cargo = cargo;
    }

    @Override
    public String toString() {
        return "Cargo{" + "cargo=" + cargo + '}';
    }
}
