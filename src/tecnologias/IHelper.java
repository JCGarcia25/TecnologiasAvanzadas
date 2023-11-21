package tecnologias;

import java.util.List;


public interface IHelper {
    
    public String obtenerHora();
    
    public String obtenerFecha();
    
    public List<String> totalProductos();
    
    public String cantidadTotalProductos();
    
    public List<String> diferenciaVitrinaABodega();
    
    public List<String> diferenciaBodegaAVitrina();
}
