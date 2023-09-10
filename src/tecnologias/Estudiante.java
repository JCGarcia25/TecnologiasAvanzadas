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
    
    private String institucion;
    private String programa;
    private String[] materias = {"matematicas", "programacion", "algoritmia"};
    private String[] notas = {"4", "3", "5"};
    private String[] total;
    
    public Estudiante(String nombre, int edad, int cedula, String institucion)
    {
        super(nombre, edad, cedula);
        this.institucion = institucion;
    }
    
    public String notasPorMateria()
    {
        // Verifica que ambos arreglos tengan la misma longitud
        if (this.materias.length != this.notas.length) {
            throw new IllegalArgumentException("Hay diferente cantidad de materias y notas");
        }
        
        String resultado = "";

        for (int i = 0; i < materias.length; i++) {
            resultado += "La nota de " + this.materias[i] + "es de: " + this.notas[i] + "\n"; 
        }
        
        return resultado;
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
