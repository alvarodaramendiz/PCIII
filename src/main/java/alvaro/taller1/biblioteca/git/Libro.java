/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package alvaro.taller1.biblioteca.git;

/**
 *
 * @author ALVARO
 */
public class Libro extends Material {
    
    String autor;
    boolean disponible;

    public Libro() {
    }

    public Libro(String autor, boolean disponible) {
        this.autor = autor;
        this.disponible = disponible;
    }

    public Libro(String autor, boolean disponible, String codigo, String titulo, String anioPublico) {
        super(codigo, titulo, anioPublico);
        this.autor = autor;
        this.disponible = disponible;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public boolean isDisponible() {
        return disponible;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }

    @Override
    public void setAnioPublico(String anioPublico) {
        super.setAnioPublico(anioPublico); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }

    @Override
    public String getAnioPublico() {
        return super.getAnioPublico(); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }

    @Override
    public void setTitulo(String titulo) {
        super.setTitulo(titulo); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }

    @Override
    public String getTitulo() {
        return super.getTitulo(); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }

    @Override
    public void setCodigo(String codigo) {
        super.setCodigo(codigo); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }

    @Override
    public String getCodigo() {
        return super.getCodigo(); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }

    @Override
    public String toString() {
        return "Libro{" + "autor=" + autor + ", disponible=" + disponible + '}';
    }
    
    
}
