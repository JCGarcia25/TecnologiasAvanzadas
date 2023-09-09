/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tecnologias;

/**
 *
 * @author Estudiante_MCA
 */
class Empresa implements toStringInterface{
    
    private String empresa;

    public Empresa(String empresa) {
        this.empresa = empresa;
    }

    @Override
    public String toString() {
        return "Empresa{" + "empresa=" + empresa + '}';
    }
}
