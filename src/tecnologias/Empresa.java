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
class Empresa {
        
    private String nombre;
    private String direccion;
    private int maxEmpleados;
    private int actualEmpleados;
    

    public Empresa(String nombre, String direccion, int maxEmpleados, int actualEmpleados) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.maxEmpleados = maxEmpleados;
        this.actualEmpleados = actualEmpleados;    
    }
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public int getMaxEmpleados() {
        return maxEmpleados;
    }

    public void setMaxEmpleados(int max_empleados) {
        this.maxEmpleados = max_empleados;
    }

    public int getActualEmpleados() {
        return actualEmpleados;
    }

    public void setActualEmpleados(int actual_empleados) {
        this.actualEmpleados = actual_empleados;
    }
    
    public String proximasContrataciones()
    {
        // Obtén la fecha actual
        LocalDate currentDate = LocalDate.now();
        
        // Agregar un mes a la fecha actual
        LocalDate nextMonthDate = currentDate.plusMonths(1);
        
        return ("En GAMES IGNICION La sigueinte fecha de contratación es: " + nextMonthDate);
    }

    @Override
    public String toString() {
        return "Empresa{" + "nombre=" + nombre + ", direccion=" + direccion + ", maxEmpleados=" + maxEmpleados + ", actualEmpleados=" + actualEmpleados + '}';
    }
}
