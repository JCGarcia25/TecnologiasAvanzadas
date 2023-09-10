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
class Empresa implements toStringInterface{
    
    private String nombre;
    private String direccion;
    private int max_empleados;
    private int actual_empleados;
    

    public Empresa(String empresa) {
        this.nombre = empresa;
    }
    
    public void actualizarDatos(String direccion, int max_empleados, int actual_empleados)
    {
       this.direccion = direccion;
       this.max_empleados = max_empleados;
       this.actual_empleados = actual_empleados;
    }
    
    public String proximasContrataciones()
    {
        // Obtén la fecha actual
        LocalDate currentDate = LocalDate.now();
        
        // Agregar un mes a la fecha actual
        LocalDate nextMonthDate = currentDate.plusMonths(1);
        
        return ("La sigueinte fecha de contratación es: " + nextMonthDate);
    }

    @Override
    public String toString() {
        return "Empresa{" + "nombre=" + nombre + ", direccion=" + direccion + ", max_empleados=" + max_empleados + ", actual_empleados=" + actual_empleados + '}';
    }
}
