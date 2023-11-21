package tecnologias;

/**
 *
 * @author johancgarcia
 */
import java.util.List;
import java.util.Scanner;

public class Tecnologias {

    public static void main(String[] args)
    {   
        Helper helper = new Helper();
        
        String hora = helper.obtenerHora();
        String fecha = helper.obtenerFecha();
        
        System.out.println(hora);
        System.out.println(fecha);
        
        ProductoDAO productoDAO = new ProductoDAO();
        
        /*Producto productoAVitrina = new Producto("producto A", 1000, "vitrina", 10);
        Producto productoBVitrina = new Producto("producto B", 500, "vitrina", 5);
        Producto productoCVitrina = new Producto("producto C", 800, "vitrina", 8);
        
        Producto productoABodega = new Producto("producto A", 1500, "bodega", 15);
        Producto productoCBodega = new Producto("producto C", 2000, "bodega", 20);
        Producto productoDBodega = new Producto("producto D", 1200, "bodega", 12);
        
        productoDAO.agregarProducto(productoAVitrina);
        productoDAO.agregarProducto(productoBVitrina);
        productoDAO.agregarProducto(productoCVitrina);
        productoDAO.agregarProducto(productoABodega);
        productoDAO.agregarProducto(productoCBodega);
        productoDAO.agregarProducto(productoDBodega);*/
        
        List<String> union = helper.totalProductos();
        System.out.println(union);
        
        String cantidadTotal = helper.cantidadTotalProductos();
        System.out.println(cantidadTotal);
        
        List<String> diferenciaVitrinaABodega = helper.diferenciaVitrinaABodega();
        System.out.println(diferenciaVitrinaABodega);
        
        List<String> diferenciaBodegaAVitrina = helper.diferenciaBodegaAVitrina();
        System.out.println(diferenciaBodegaAVitrina);
        
        // instanciar la conexión a base de datos
        /*UsuarioDAO usuarioDAO = new UsuarioDAO();
        EmpresaDAO empresaDAO = new EmpresaDAO();
        Scanner scanner = new Scanner(System.in);

        //USUARIOS
        // Crear un nuevo usuario con los tres argumentos requeridos
        
        System.out.print("Crearemos 2 usuarios ");
        Usuario nuevoUsuario = new Usuario("Nelson Arango", "123");
        usuarioDAO.agregarUsuario(nuevoUsuario);
      
        Usuario nuevoUsuario2 = new Usuario("Brayan Avila", "123");
        usuarioDAO.agregarUsuario(nuevoUsuario2);

        System.out.println("Lista de todos los usuarios:");
        usuarioDAO.obtenerTodosLosUsuarios();

        System.out.println("Editaremos el usuario Brayan Avila");
        usuarioDAO.editarUsuario(2, "Martin Avila", "123");

        System.out.println("Lista de todos los usuarios:");
        usuarioDAO.obtenerTodosLosUsuarios();

        System.out.println("Ahora vamos a eliminar el usuario Nelson Arango");
        usuarioDAO.eliminarUsuario(1);

        System.out.println("Lista de todos los usuarios:");
        usuarioDAO.obtenerTodosLosUsuarios();*/
        
        //EMPRESAS
        // Crear una nueva empresa con los argumentos requeridos
        /*System.out.print("Crearemos una nueva empresa ");
        Empresa nuevaEmpresa = new Empresa(0, "BITPOINTER", "Villacentro Oficina 403", 50, 32);
        empresaDAO.agregarEmpresa(nuevaEmpresa);
        Empresa nuevaEmpresa2 = new Empresa(0, "IGNICION GAMES", "Primavera Urbana Oficina 807", 40, 25);
        empresaDAO.agregarEmpresa(nuevaEmpresa2);

        // Obtener y mostrar los datos de todas las empresas
        System.out.print("Lista de todas las empresas:  ");
        empresaDAO.obtenerTodasLasEmpresas();

        // Editar los datos de una empresa
        System.out.print("Editaremos los datos de IGNICION GAMES");
        int empresaEditarId = 2; // Reemplaza con el ID de la empresa que deseas editar
        empresaDAO.editarEmpresa(new Empresa(empresaEditarId, "GAMES IGNICION", "Llanocentro Local 215", 30, 25));
        System.out.print("Lista de todas las empresas:  ");
        empresaDAO.obtenerTodasLasEmpresas();

        // Eliminar una empresa por su ID
        System.out.print("Eliminaremos la empresa BITPOINTER  ");
        int empresaEliminarId = 1; // Reemplaza con el ID de la empresa que deseas eliminar
        empresaDAO.eliminarEmpresa(empresaEliminarId);

        // Obtener y mostrar la lista de todas las empresas
        System.out.println("Lista de todas las empresas:");
        empresaDAO.obtenerTodasLasEmpresas();

        // Mostramos cuando seran las proximas contrataciones de la empresa
        String contrataciones = nuevaEmpresa2.proximasContrataciones();
        System.out.println( contrataciones);

        Conexion conexion = Conexion.getInstance();
        
        // Instanciar la clase para realizar el login de los usuarios en la aplicacion
        LoginUsuarios login = new LoginUsuarios(conexion);

        // Generar personas
        Persona persona1 = new Persona("johan", 21, 1006700371);
        Persona persona2 = new Persona();
        
        // Generar Estudiante - Empleado - Docente
        Estudiante estudiante = new Estudiante("Nelson", 23, 1121967543, "Unillanos");
        
        // Generar Empleado
        Empleado empleado = new Empleado("Daniel", 20, 1002735678, "TL");
        
        // Generar Docente
        Docente docente = new Docente("FajarGOD", 65, 77777777);
        
        // Instanciar cargo - Empresa
        Cargo cargo = new Cargo("Ingeniero");
                
        // Instanciar servicios
        Servicios servicio1 = new Servicios("programar");
        Servicios servicio2 = new Servicios("diseñar");
        
        DetalleVentaServicio detalleVentaServicio = new DetalleVentaServicio(servicio1, "se hizo la chamba", 10000);
        
        VentaServicio ventaServicio = new VentaServicio(persona2, detalleVentaServicio, 1);

        // Generar Persona Cargo
        PersonaCargo personaCargo1 = new PersonaCargo(docente, cargo, nuevaEmpresa2);
        
        // Generar Facturacion
        Facturacion factura1 = new Facturacion(ventaServicio, "1");
        
        // Parte derecha LOGIN
        Usuario usuario1 = new Usuario(0,"johan", "johan");
        Usuario usuario2 = new Usuario(0,"esneyder", "caicedo");
        
        // Instanciar plataformas
        Plataforma plataforma1 = new Plataforma("Netflix");
        Plataforma plataforma2 = new Plataforma("HBO");
 
        // Instaciar los usuarios registrados, dependerá de si este está o no resgitrado en DB
        UsuarioRegistrado usuarioR1 = new UsuarioRegistrado(usuario1, login, plataforma1);
        UsuarioRegistrado usuarioR2 = new UsuarioRegistrado(usuario2, login, plataforma2);
        
        // Generamos cuantos estudiantes estan registrados por materia
        String estudiantesMaterias = docente.estudiantesPorMateria();
        System.out.println(estudiantesMaterias);
        
        // Generamos cuales son las notas del estudiante por materia
        String notasPorMateria = estudiante.notasPorMateria();
        System.out.println(notasPorMateria);
        
        // Guardar factura en la base de datos
        String respuesta = factura1.guardarFactura("123", detalleVentaServicio.getDetalle());
        System.out.println(respuesta);
        
        // Aplicamos el descuento en la factura
        Double detalleServicio = detalleVentaServicio.aplicarDescuento();
        System.out.println("Con el descuento quedaria en: $" + detalleServicio);
        
        // Generamos la fecha de las proximas vacaciones del empleado
        String vacaciones = empleado.proximasVacaciones();
        System.out.println( vacaciones);
        
        // Mostramos el cargo actual para luego modificarlo
        System.out.println( "Cargo Actual: " + cargo.getNombre());
        cargo.cambiarCargo("Arquitecto");
        // Mostramos el cargo modificado
        System.out.println( "Cargo cambiado: " + cargo.getNombre());
        
        String proceso_con_acid_incorrecto = factura1.procesoConACID("Mas de veinte digitos seguramente");
        String proceso_con_acid_correcto = factura1.procesoConACID("funcional");
        
        String proceso_sin_acid_incorrecto = factura1.procesoSinACID("12345", "Mas de veinte digitos seguramente");
        String proceso_sin_acid_correcto = factura1.procesoSinACID( "54321","funcional Bien");

        System.out.println("Primero: " + proceso_con_acid_incorrecto);
        System.out.println("Segundo: " + proceso_con_acid_correcto);
        System.out.println("Tercero: " + proceso_sin_acid_incorrecto);
        System.out.println("Cuarto: " + proceso_sin_acid_correcto);*/
    }
}
