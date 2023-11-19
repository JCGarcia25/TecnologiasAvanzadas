/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tecnologias;

/**
 *
 * @author Estudiante_MCA
 */
class Cargo {
    
    private String nombre;
    private int tiempoCargo = 0;

    public Cargo( String cargo) {
        this.nombre = cargo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setTiempo_de_cargo(int tiempoCargo) {
        this.tiempoCargo = tiempoCargo;
    }

    @Override
    public String toString() {
        return "Cargo{" + "cargo=" + nombre + ", tiempoCargo=" + tiempoCargo + '}';
    }
}
