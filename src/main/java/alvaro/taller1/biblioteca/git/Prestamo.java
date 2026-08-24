/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package alvaro.taller1.biblioteca.git;

/**
 *
 * @author ALVARO
 */
public class Prestamo {
    
    private String idPrestamo;
    private Cliente cliente;
    private Libro libro;
    private localDate fecha;
    private String estado;

    public Prestamo() {
    }

    public Prestamo(String idPrestamo, Cliente cliente, Libro libro, localDate fecha, String estado) {
        this.idPrestamo = idPrestamo;
        this.cliente = cliente;
        this.libro = libro;
        this.fecha = fecha;
        this.estado = estado;
    }

    public String getIdPrestamo() {
        return idPrestamo;
    }

    public void setIdPrestamo(String idPrestamo) {
        this.idPrestamo = idPrestamo;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Libro getLibro() {
        return libro;
    }

    public void setLibro(Libro libro) {
        this.libro = libro;
    }

    public localDate getFecha() {
        return fecha;
    }

    public void setFecha(localDate fecha) {
        this.fecha = fecha;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
    
    
    
}
