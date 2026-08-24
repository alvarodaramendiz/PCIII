


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

    public static void main(String[] args) { 
        // Aquí irá el menú (Fase 8) 
    }
}
