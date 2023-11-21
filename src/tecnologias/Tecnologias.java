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
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        EmpresaDAO empresaDAO = new EmpresaDAO();
        ServicioDAO servicioDAO = new ServicioDAO();
        
        Producto productoAVitrina = new Producto("producto A", 1000, "vitrina", 10);
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
        productoDAO.agregarProducto(productoDBodega);
        
        List<String> union = helper.totalProductos();
        System.out.println(union);
        
        String cantidadTotal = helper.cantidadTotalProductos();
        System.out.println(cantidadTotal);
        
        List<String> diferenciaVitrinaABodega = helper.diferenciaVitrinaABodega();
        System.out.println(diferenciaVitrinaABodega);
        
        List<String> diferenciaBodegaAVitrina = helper.diferenciaBodegaAVitrina();
        System.out.println(diferenciaBodegaAVitrina);
        
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
        usuarioDAO.obtenerTodosLosUsuarios();

        //USUARIOS
        // Crear un nuevo usuario con los tres argumentos requeridos
        
        System.out.print("Crearemos 2 usuarios ");

        System.out.println("Lista de todos los usuarios:");
        usuarioDAO.obtenerTodosLosUsuarios();

        System.out.println("Editaremos el usuario Brayan Avila");
        usuarioDAO.editarUsuario(2, "Martin Avila", "123");

        System.out.println("Lista de todos los usuarios:");
        usuarioDAO.obtenerTodosLosUsuarios();

        System.out.println("Ahora vamos a eliminar el usuario Nelson Arango");
        usuarioDAO.eliminarUsuario(1);

        System.out.println("Lista de todos los usuarios:");
        usuarioDAO.obtenerTodosLosUsuarios();
        
        //EMPRESAS
        // Crear una nueva empresa con los argumentos requeridos
        System.out.print("Crearemos una nueva empresa ");
        Empresa nuevaEmpresa = new Empresa("BITPOINTER", "Villacentro Oficina 403", 50, 32);
        empresaDAO.agregarEmpresa(nuevaEmpresa);
        Empresa nuevaEmpresa2 = new Empresa("IGNICION GAMES", "Primavera Urbana Oficina 807", 40, 25);
        empresaDAO.agregarEmpresa(nuevaEmpresa2);

        // Obtener y mostrar los datos de todas las empresas
        System.out.print("Lista de todas las empresas:  ");
        empresaDAO.obtenerTodasLasEmpresas();

        // Editar los datos de una empresa
        System.out.print("Editaremos los datos de IGNICION GAMES");
        int empresaEditarId = 2;

        Empresa empresaNew = new Empresa("GAMES IGNICION", "Llanocentro Local 215", 30, 25);
        empresaDAO.editarEmpresa(empresaEditarId,empresaNew);
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
        
        // Generar personas
        Persona persona1 = new Persona("johan", 21, 1006700371);
        Persona persona2 = new Persona();
        
        // Generar Estudiante - Empleado - Docente
        Estudiante estudiante = new Estudiante("Nelson", 23, 1121967543, "Unillanos", "Ing. Sistemas");
        
        // Generar Empleado
        Cargo cargo = new Cargo("Programador");
        Empleado empleado = new Empleado("Daniel", 20, 4543,cargo, 3);
        
        // Generar Docente
        Docente docente = new Docente("FajarGOD", 65, 12321, 5000);
        
        // Instanciar cargo - Empresa
        Cargo cargo2 = new Cargo("Ingeniero");
                
        // Instanciar servicios
        Servicio servicio1 = new Servicio("programar");
        Servicio servicio2 = new Servicio("diseñar");
        
        DetalleVentaServicio detalleVentaServicio = new DetalleVentaServicio(servicio1, "se hizo la chamba", 10000);
        
        VentaServicio ventaServicio = new VentaServicio(persona2, detalleVentaServicio, 1);

        // Generar Persona Cargo
        PersonaCargo personaCargo1 = new PersonaCargo(docente, cargo, nuevaEmpresa2);
        
        // Generar Facturacion
        Facturacion factura1 = new Facturacion(ventaServicio, "1");
        FacturacionDAO facturacionDAO = new FacturacionDAO();
        
        // Instanciar plataformas
        Plataforma plataforma1 = new Plataforma("Netflix", "Netflix.com");
        Plataforma plataforma2 = new Plataforma("HBO", "HBO.com");
 
        // Generamos cuantos estudiantes estan registrados por materia
        String estudiantesMaterias = docente.estudiantesPorMateria();
        System.out.println(estudiantesMaterias);
        
        // Generamos cuales son las notas del estudiante por materia
        String notasPorMateria = estudiante.notasPorMateria();
        System.out.println(notasPorMateria);
        
        // Guardar factura en la base de datos
        boolean respuesta = facturacionDAO.guardarFactura(factura1);
        System.out.println(respuesta);
                
        //Obtenemos todas las facturas
        facturacionDAO.obtenerTodasLasFacturas();
        
        //Editamos una factura
        int facturacionEditarID = 1;
        facturacionDAO.editarFactura(facturacionEditarID, factura1);
        
        //Eliminamos una factura
        facturacionDAO.eliminarFactura(empresaEditarId);
        
        // Ejemplo de agregar un servicio
        Servicio nuevoServicio = new Servicio("Capacitaciones");
        boolean exito = servicioDAO.agregarServicio(nuevoServicio);

        if (exito) {
            System.out.println("Servicio agregado con éxito.");
        } else {
            System.out.println("Error al agregar el servicio.");
        }

        // Ejemplo de obtener todos los servicios
        servicioDAO.obtenerTodosLosServicios();

        //Editamos un servicio
        int servicioEditarId = 4;
        servicioDAO.eliminarServicio(servicioEditarId);
       
        /*
        String proceso_con_acid_incorrecto = factura1.procesoConACID("Mas de veinte digitos seguramente");
        String proceso_con_acid_correcto = factura1.procesoConACID("funcional");
        
        String proceso_sin_acid_incorrecto = factura1.procesoSinACID("12345", "Mas de veinte digitos seguramente");
        String proceso_sin_acid_correcto = factura1.procesoSinACID( "54321","funcional Bien");

        System.out.println("Primero: " + proceso_con_acid_incorrecto);
        System.out.println("Segundo: " + proceso_con_acid_correcto);
        System.out.println("Tercero: " + proceso_sin_acid_incorrecto);
        System.out.println("Cuarto: " + proceso_sin_acid_correcto);
        */
    }
}
