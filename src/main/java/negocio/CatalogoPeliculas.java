/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package negocio;

/**
 *
 * @author Jesus Alberto
 */
public interface CatalogoPeliculas {
    public void agregarPeliculas(String url);
    public void listarPeliculas(String url);
    public void buscarPeliculas (String url, String buscar);
    public void iniciarArchivo(String url);
}
