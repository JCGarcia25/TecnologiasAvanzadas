/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tecnologias;

/**
 *
 * @author Estudiante_MCA
 */
public class Servicios {
    
    private String servicio;

    public Servicios(String servicio) 
    {
        this.servicio = servicio;
    }
    
    public void cancelarServicio(Servicios servicio)
    {
        servicio = null;
    }

    @Override
    public String toString() {
        return "Servicios{" + "servicio=" + servicio + '}';
    }
}
