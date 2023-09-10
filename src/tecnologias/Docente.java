/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tecnologias;

/**
 *
 * @author Estudiante_MCA
 */
class Docente extends Persona{
    
    private String[] materias = {"matematicas", "programacion", "algoritmia"};
    private float salario;
    private String[] estudiantes = {"10", "15", "20"};

    public Docente(String nombre, int edad, int cedula) {
        super(nombre, edad, cedula);
    }

    public float getSalario() {
        return this.salario;
    }
    
    public String estudiantesPorMateria()
    {
        // Verifica que ambos arreglos tengan la misma longitud
        if (this.materias.length != this.estudiantes.length) {
            throw new IllegalArgumentException("Hay diferente cantidad de materias y notas");
        }
        
        String resultado = "";

        for (int i = 0; i < this.materias.length; i++) {
            resultado += "La cantidad de estudiantes de: " + this.materias[i] + "es de: " + this.estudiantes[i] + "\n"; 
        }
        
        return resultado;
    }

    @Override
    public String toString() {
        return "Docente{" + "materias=" + materias + ", salario=" + salario + ", estudiantes=" + estudiantes + '}';
    }
}
