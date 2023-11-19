/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tecnologias;

/**
 *
 * @author Estudiante_MCA
 */
public class Plataforma {
    
    private String plataforma;
    private String link;

    public Plataforma(String plataforma, String link)
    {
        this.plataforma = plataforma;
        this.link = link;
    }

    @Override
    public String toString() {
        return "Plataforma{" + "plataforma=" + plataforma + ", link=" + link + '}';
    }
}
