/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tecnologias;

/**
 *
 * @author Estudiante_MCA
 */
public class LogUsuarios {
    
    private String fecha;
    private String hora;
    private String accion;
    private String formulario;

    public LogUsuarios(String fecha, String hora, String accion, String formulario) {
        this.fecha = fecha;
        this.hora = hora;
        this.accion = accion;
        this.formulario = formulario;
    }

    @Override
    public String toString() {
        return "LogUsuarios{" + "fecha=" + fecha + ", hora=" + hora + ", accion=" + accion + ", formulario=" + formulario + '}';
    }
}
