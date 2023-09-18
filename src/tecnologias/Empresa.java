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
        
    private int id;
    private String nombre;
    private String direccion;
    private int max_empleados;
    private int actual_empleados;
    

    public Empresa(int id, String nombre, String direccion, int max_empleados, int actual_empleados) {
        this.id = id;
        this.nombre = nombre;
        this.direccion = direccion;
        this.max_empleados = max_empleados;
        this.actual_empleados = actual_empleados;    
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
        
        return ("En GAMES IGNICION La sigueinte fecha de contratación es: " + nextMonthDate);
    }
    
    public int getId() {
        return id;
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
        return max_empleados;
    }

    public void setMaxEmpleados(int max_empleados) {
        this.max_empleados = max_empleados;
    }

    public int getActualEmpleados() {
        return actual_empleados;
    }

    public void setActualEmpleados(int actual_empleados) {
        this.actual_empleados = actual_empleados;
    }

    @Override
    public String toString() {
        return "Empresa{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", direccion='" + direccion + '\'' +
                ", maxEmpleados=" + max_empleados +
                ", actualEmpleados=" + actual_empleados +
                '}';
    }
}
