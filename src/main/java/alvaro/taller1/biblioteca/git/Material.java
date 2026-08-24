/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package alvaro.taller1.biblioteca.git;

/**
 *
 * @author ALVARO
 */
public class Material {
    
    private String codigo;
    private String titulo;
    private String anioPublico;

    public Material() {
    }

    public Material(String codigo, String titulo, String anioPublico) {
        this.codigo = codigo;
        this.titulo = titulo;
        this.anioPublico = anioPublico;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAnioPublico() {
        return anioPublico;
    }

    public void setAnioPublico(String anioPublico) {
        this.anioPublico = anioPublico;
    }
    
     
    
}
