/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dominio;

/**
 *
 * @author Jesus Alberto
 */
public class PeliculaAmpliado extends Pelicula{
    
    //private String nombre;
    private String Fproduccion;

    
    public PeliculaAmpliado(String nombre_peli, String fecha_produccion){
        super(nombre_peli);
        this.Fproduccion = fecha_produccion;
    }

    public String getFproduccion() {
        return Fproduccion;
    }

    /**
     * @param Fproduccion the Fproduccion to set
     */
    public void setFproduccion(String Fproduccion) {
        this.Fproduccion = Fproduccion;
    }
}
