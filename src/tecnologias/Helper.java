package tecnologias;


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
}
