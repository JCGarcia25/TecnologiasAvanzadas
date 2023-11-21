package tecnologias;

import java.util.List;


public class Helper{
    
    private IHelper ihelper;
    
    public Helper() {
        switch (PropertiesManager.getConection()) {
            case "postgresql":
                ihelper = new HelperPostgresql();
                break;
            case "mysql":
                ihelper = new HelperMysql();
                break;
            default:
                throw new AssertionError();
        }
    }
    
    public String obtenerHora() {
        return ihelper.obtenerHora();
    }
    
    public String obtenerFecha() {
        return ihelper.obtenerFecha();
    }
    
    public List<String> totalProductos() {
        return ihelper.totalProductos();
    }
    
    public String cantidadTotalProductos() {
        return ihelper.cantidadTotalProductos();
    }
    
    public List<String> diferenciaVitrinaABodega() {
        return ihelper.diferenciaVitrinaABodega();
    }
    
    public List<String> diferenciaBodegaAVitrina() {
        return ihelper.diferenciaBodegaAVitrina();
    }
}
