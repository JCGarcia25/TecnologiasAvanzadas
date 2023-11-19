package tecnologias;


public class Helper{
    
    private IHelper ihelper;
    
    public String obtenerHora() {

        switch (PropertiesManager.getConection()) {
            case "postgresql":
                ihelper = new HelperPostgresql();
                return ihelper.obtenerHora();
            case "mysql":
                ihelper = new HelperMysql();
                return ihelper.obtenerHora();
            default:
                throw new AssertionError();
        }
    }
    
    public String obtenerFecha() {

        switch (PropertiesManager.getConection()) {
            case "postgresql":
                ihelper = new HelperPostgresql();
                return ihelper.obtenerFecha();
            case "mysql":
                ihelper = new HelperMysql();
                return ihelper.obtenerFecha();
            default:
                throw new AssertionError();
        }
    }
}
