


package alvaro.taller1.biblioteca.git; 

import java.time.LocalDate;
import java.util.ArrayList; 
import java.util.Scanner; 

public class Main { 
    static ArrayList<Cliente> clientes = new ArrayList<>(); 
    static Scanner sc = new Scanner(System.in); 
    static ArrayList<Prestamo> prestamos = new ArrayList<>(); 
    
    static ArrayList<Libro> libros = new ArrayList<>();
    
    public static void listarPrestamos() {
    System.out.println("\n--- LISTA DE PRÉSTAMOS ---");
    if (prestamos.isEmpty()) {
        System.out.println("No hay préstamos registrados.");
    } else {
        for (Prestamo p : prestamos) {
            System.out.println("ID Préstamo: " + p.getIdPrestamo() +
                               " | Cliente: " + p.getCliente().getNombre() +
                               " | Libro: " + p.getLibro().getTitulo() +
                               " | Fecha: " + p.getFecha() +
                               " | Estado: " + p.getEstado());
        }
    }
}
    
    public static void crearPrestamo() {
    System.out.println("\n--- REGISTRAR PRÉSTAMO ---");
    if (clientes.isEmpty()) {
        System.out.println("No hay clientes registrados. Registre un cliente primero.");
        return;
    }
    if (libros.isEmpty()) {
        System.out.println("No hay libros registrados. Registre un libro primero.");
        return;
    }

    System.out.print("Ingrese el ID del préstamo: ");
    String idPrestamo = sc.nextLine();

    System.out.print("Ingrese el ID del cliente: ");
    String idCliente = sc.nextLine();
    sc.nextLine(); // Limpiar búfer

    Cliente clienteEncontrado = null;
    for (Cliente c : clientes) {
        if (c.getId() == idCliente) {
            clienteEncontrado = c;
            break;
        }
    }

    if (clienteEncontrado == null) {
        System.out.println("No se encontró ningún cliente con ID: " + idCliente);
        return;
    }

    System.out.print("Ingrese el código del libro: ");
    String codigoLibro = sc.nextLine();

    Libro libroEncontrado = null;
    for (Libro l : libros) {
        if (l.getCodigo().equalsIgnoreCase(codigoLibro)) {
            libroEncontrado = l;
            break;
        }
    }

    if (libroEncontrado == null) {
        System.out.println("No se encontró ningún libro con código: " + codigoLibro);
        return;
    }

    if (!libroEncontrado.isDisponible()) {
        System.out.println("El libro '" + libroEncontrado.getTitulo() + "' no está disponible actualmente.");
        return;
    }

    // Actualizar disponibilidad del libro y registrar el préstamo
    libroEncontrado.setDisponible(false);
    Prestamo nuevoPrestamo = new Prestamo(idPrestamo, clienteEncontrado, libroEncontrado, LocalDate.now(), "PRESTADO");
    prestamos.add(nuevoPrestamo);

    System.out.println("¡Préstamo registrado exitosamente!");
}
    
    public static void devolverPrestamo() {
    System.out.println("\n--- DEVOLUCIÓN DE PRÉSTAMO ---");
    if (prestamos.isEmpty()) {
        System.out.println("No hay préstamos registrados en el sistema.");
        return;
    }

    System.out.print("Ingrese el ID del préstamo a devolver: ");
    String idBuscar = sc.nextLine();

    boolean encontrado = false;
    for (Prestamo p : prestamos) {
        if (p.getIdPrestamo().equalsIgnoreCase(idBuscar)) {
            if (p.getEstado().equalsIgnoreCase("DEVUELTO")) {
                System.out.println("Este préstamo ya fue devuelto anteriormente.");
                encontrado = true;
                break;
            }

            // Cambiar estado del préstamo y restaurar disponibilidad del libro
            p.setEstado("DEVUELTO");
            p.getLibro().setDisponible(true);

            System.out.println("¡Devolución registrada exitosamente!");
            System.out.println("El libro '" + p.getLibro().getTitulo() + "' vuelve a estar disponible.");
            encontrado = true;
            break;
        }
    }

    if (!encontrado) {
        System.out.println("No se encontró ningún préstamo con ID: " + idBuscar);
    }
}
    
    public static void crearCliente() {
    System.out.println("\n--- CREAR CLIENTE ---");
    System.out.print("Ingrese el ID del cliente: ");
    String id = sc.nextLine();
    sc.nextLine(); // Limpiar el búfer de entrada

    System.out.print("Ingrese el nombre del cliente: ");
    String nombre = sc.nextLine();

    System.out.print("Ingrese el correo electrónico: ");
    String email = sc.nextLine();
    
    System.out.print("Ingrese el telefono: ");
    String telefono = sc.nextLine();

    Cliente nuevoCliente = new Cliente(email, id, nombre, telefono);
    clientes.add(nuevoCliente);

    System.out.println("¡Cliente registrado exitosamente!");
}
   public static void listarClientes() {
    System.out.println("\n--- LISTA DE CLIENTES ---");
    if (clientes.isEmpty()) {
        System.out.println("No hay clientes registrados en el sistema.");
    } else {
        for (Cliente c : clientes) {
            System.out.println(c);
        }
    }
}
    
   public static void buscarCliente() {
    System.out.println("\n--- BUSCAR CLIENTE ---");
    if (clientes.isEmpty()) {
        System.out.println("No hay clientes para buscar.");
        return;
    }

    System.out.print("Ingrese el ID del cliente a buscar: ");
    String idBuscar = sc.nextLine();
    sc.nextLine(); // Limpiar búfer

    boolean encontrado = false;
    for (Cliente c : clientes) {
        if (c.getId() == idBuscar) {
            System.out.println("Cliente encontrado:");
            System.out.println(c);
            encontrado = true;
            break;
        }
    }

    if (!encontrado) {
        System.out.println("No se encontró ningún cliente con el ID: " + idBuscar);
    }
}
   
   public static void actualizarCliente() {
    System.out.println("\n--- ACTUALIZAR CLIENTE ---");
    if (clientes.isEmpty()) {
        System.out.println("No hay clientes registrados para actualizar.");
        return;
    }

    System.out.print("Ingrese el ID del cliente a actualizar: ");
    String idBuscar = sc.nextLine();
    sc.nextLine(); // Limpiar el búfer

    boolean encontrado = false;
    for (Cliente c : clientes) {
        if (c.getId() == idBuscar) {
            System.out.print("Ingrese el nuevo nombre (actual: " + c.getNombre() + "): ");
            String nuevoNombre = sc.nextLine();
            
            System.out.print("Ingrese el nuevo correo (actual: " + c.getEmail() + "): ");
            String nuevoEmail = sc.nextLine();

            c.setNombre(nuevoNombre);
            c.setEmail(nuevoEmail);

            System.out.println("¡Cliente actualizado exitosamente!");
            encontrado = true;
            break;
        }
    }

    if (!encontrado) {
        System.out.println("No se encontró ningún cliente con el ID: " + idBuscar);
    }
}
   
   public static void eliminarCliente() {
    System.out.println("\n--- ELIMINAR CLIENTE ---");
    if (clientes.isEmpty()) {
        System.out.println("No hay clientes registrados para eliminar.");
        return;
    }

    System.out.print("Ingrese el ID del cliente a eliminar: ");
    String idBuscar = sc.nextLine();
    sc.nextLine(); // Limpiar el búfer

    boolean eliminado = false;
    for (int i = 0; i < clientes.size(); i++) {
        if (clientes.get(i).getId() == idBuscar) {
            clientes.remove(i);
            System.out.println("¡Cliente eliminado exitosamente!");
            eliminado = true;
            break;
        }
    }

    if (!eliminado) {
        System.out.println("No se encontró ningún cliente con el ID: " + idBuscar);
    }
}
   
   public static void crearLibro() {
    System.out.println("\n--- CREAR LIBRO ---");
    System.out.print("Ingrese el código del libro: ");
    String codigo = sc.nextLine();

    System.out.print("Ingrese el título: ");
    String titulo = sc.nextLine();

    System.out.print("Ingrese el año de publicación: ");
    String anioPublico = sc.nextLine();

    System.out.print("Ingrese el autor: ");
    String autor = sc.nextLine();

    // Por defecto se registra como disponible (true)
    Libro nuevoLibro = new Libro(autor, true, codigo, titulo, anioPublico);
    libros.add(nuevoLibro);

    System.out.println("¡Libro registrado exitosamente!");
}

   public static void listarLibros() {
    System.out.println("\n--- LISTA DE LIBROS ---");
    if (libros.isEmpty()) {
        System.out.println("No hay libros registrados.");
    } else {
        for (Libro l : libros) {
            System.out.println("Código: " + l.getCodigo() + 
                               " | Título: " + l.getTitulo() + 
                               " | Autor: " + l.getAutor() + 
                               " | Año: " + l.getAnioPublico() + 
                               " | Disponible: " + (l.isDisponible() ? "Sí" : "No"));
        }
    }
}
   
   public static void buscarLibro() {
    System.out.println("\n--- BUSCAR LIBRO ---");
    if (libros.isEmpty()) {
        System.out.println("No hay libros para buscar.");
        return;
    }

    System.out.print("Ingrese el código a buscar: ");
    String codigoBuscar = sc.nextLine();

    boolean encontrado = false;
    for (Libro l : libros) {
        if (l.getCodigo().equalsIgnoreCase(codigoBuscar)) {
            System.out.println("Libro encontrado:");
            System.out.println("Código: " + l.getCodigo() + 
                               " | Título: " + l.getTitulo() + 
                               " | Autor: " + l.getAutor() + 
                               " | Año: " + l.getAnioPublico() + 
                               " | Disponible: " + (l.isDisponible() ? "Sí" : "No"));
            encontrado = true;
            break;
        }
    }

    if (!encontrado) {
        System.out.println("No se encontró ningún libro con el código: " + codigoBuscar);
    }
}
   
   public static void actualizarLibro() {
    System.out.println("\n--- ACTUALIZAR LIBRO ---");
    if (libros.isEmpty()) {
        System.out.println("No hay libros registrados para actualizar.");
        return;
    }

    System.out.print("Ingrese el código del libro a actualizar: ");
    String codigoBuscar = sc.nextLine();

    boolean encontrado = false;
    for (Libro l : libros) {
        if (l.getCodigo().equalsIgnoreCase(codigoBuscar)) {
            System.out.print("Ingrese nuevo título (actual: " + l.getTitulo() + "): ");
            l.setTitulo(sc.nextLine());

            System.out.print("Ingrese nuevo autor (actual: " + l.getAutor() + "): ");
            l.setAutor(sc.nextLine());

            System.out.print("Ingrese nuevo año de publicación (actual: " + l.getAnioPublico() + "): ");
            l.setAnioPublico(sc.nextLine());

            System.out.println("¡Libro actualizado exitosamente!");
            encontrado = true;
            break;
        }
    }

    if (!encontrado) {
        System.out.println("No se encontró ningún libro con el código: " + codigoBuscar);
    }
}
   
   public static void eliminarLibro() {
    System.out.println("\n--- ELIMINAR LIBRO ---");
    if (libros.isEmpty()) {
        System.out.println("No hay libros registrados para eliminar.");
        return;
    }

    System.out.print("Ingrese el código del libro a eliminar: ");
    String codigoBuscar = sc.nextLine();

    boolean eliminado = false;
    for (int i = 0; i < libros.size(); i++) {
        if (libros.get(i).getCodigo().equalsIgnoreCase(codigoBuscar)) {
            libros.remove(i);
            System.out.println("¡Libro eliminado exitosamente!");
            eliminado = true;
            break;
        }
    }

    if (!eliminado) {
        System.out.println("No se encontró ningún libro con el código: " + codigoBuscar);
    }
}
    public static void main(String[] args) {
    int opcion = 0;

    do {
        System.out.println("\n==========================================");
        System.out.println("   SISTEMA DE GESTIÓN DE BIBLIOTECA");
        System.out.println("==========================================");
        System.out.println("--- GESTIÓN DE CLIENTES ---");
        System.out.println("1. Crear Cliente");
        System.out.println("2. Listar Clientes");
        System.out.println("3. Buscar Cliente");
        System.out.println("4. Actualizar Cliente");
        System.out.println("5. Eliminar Cliente");
        System.out.println("\n--- GESTIÓN DE LIBROS ---");
        System.out.println("6. Crear Libro");
        System.out.println("7. Listar Libros");
        System.out.println("8. Buscar Libro");
        System.out.println("9. Actualizar Libro");
        System.out.println("10. Eliminar Libro");
        System.out.println("\n--- GESTIÓN DE PRÉSTAMOS ---");
        System.out.println("11. Registrar Préstamo");
        System.out.println("12. Registrar Devolución");
        System.out.println("13. Listar Préstamos");
        System.out.println("\n0. Salir");
        System.out.println("==========================================");
        System.out.print("Seleccione una opción: ");

        try {
            opcion = sc.nextInt();
            sc.nextLine(); // Limpiar búfer

            switch (opcion) {
                // Clientes
                case 1 -> crearCliente();
                case 2 -> listarClientes();
                case 3 -> buscarCliente();
                case 4 -> actualizarCliente();
                case 5 -> eliminarCliente();

                // Libros
                case 6 -> crearLibro();
                case 7 -> listarLibros();
                case 8 -> buscarLibro();
                case 9 -> actualizarLibro();
                case 10 -> eliminarLibro();

                // Préstamos
                case 11 -> crearPrestamo();
                case 12 -> devolverPrestamo();
                case 13 -> listarPrestamos();

                case 0 -> System.out.println("\n¡Gracias por usar el sistema de biblioteca! Hasta luego.");
                default -> System.out.println("\nOpción inválida. Intente nuevamente.");
            }
        } catch (Exception e) {
            System.out.println("\nError: Debe ingresar un número entero válido.");
            sc.nextLine(); // Limpiar búfer en caso de excepción
            opcion = -1;
        }

    } while (opcion != 0);
}
}
