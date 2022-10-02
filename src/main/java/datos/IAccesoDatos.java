/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package datos;

import dominio.Pelicula;
import excepciones.AccesoDatosEx;
import excepciones.EscrituraDatosEx;
import excepciones.LecturaDatosEx;
import java.util.List;

/**
 *
 * @author Jesus Alberto
 */
public interface IAccesoDatos  { // Con throws llama a AccesoDatosEx si hay problemas 
    
    boolean existe (String nombreArchivo) throws AccesoDatosEx;
    public void listar(String url) throws LecturaDatosEx;
    void escribir(String nombre, int anio, String url) throws EscrituraDatosEx;
    public void Buscar(String url, String buscar) throws EscrituraDatosEx;
    public void crear (String nombreArchivo) throws AccesoDatosEx;
    public void borrar (String url, int id) throws AccesoDatosEx;
}
