


package alvaro.taller1.biblioteca.git; 

import java.util.ArrayList; 
import java.util.Scanner; 

public class Main { 
    static ArrayList<Cliente> clientes = new ArrayList<>(); 
    static Scanner sc = new Scanner(System.in); 
    
    void crearCliente() {
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
   void listarClientes() {
    System.out.println("\n--- LISTA DE CLIENTES ---");
    if (clientes.isEmpty()) {
        System.out.println("No hay clientes registrados en el sistema.");
    } else {
        for (Cliente c : clientes) {
            System.out.println(c);
        }
    }
}
    
   void buscarCliente() {
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
   
   void eliminarCliente() {
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

    public static void main(String[] args) { 
        // Aquí irá el menú (Fase 8) 
    }
}
