/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tecnologias;

import java.time.LocalDate;

/**
 *
 * @author Estudiante_MCA
 */
class Empleado extends Persona {
    
    private float salario;
    private Cargo cargo;
    
    public Empleado (String nombre, int edad, int telefono, Cargo cargo, float salario)
    {
        super(nombre, edad, telefono);
        this.cargo = cargo;
        this.salario = salario;
    }
    
    public String proximasVacaciones()
    {
        // Obtén la fecha actual
        LocalDate currentDate = LocalDate.now();
        
        // Agregar un mes a la fecha actual
        LocalDate nextMonthDate = currentDate.plusMonths(6);
        
        return ("La siguientes vacaciones serán el: " + nextMonthDate);
    }

    @Override
    public String toString() {
        return "Empleado{" + "salario=" + salario + ", cargo=" + cargo + '}';
    }
}
