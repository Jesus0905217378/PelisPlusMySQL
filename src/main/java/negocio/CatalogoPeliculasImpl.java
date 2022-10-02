/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package negocio;

import datos.AccesoDatosAdicImpl;

import excepciones.AccesoDatosEx;
import excepciones.EscrituraDatosEx;
import java.sql.*;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author Jesus Alberto
 */
public class CatalogoPeliculasImpl implements CatalogoPeliculas{
    
    //private final IAccesoDatos datos;
//    private final IAccesoDatos datos1;
     private static final Scanner scanner = new Scanner (System.in);
    private final datos.AccesoDatosAdicImpl datos;
    
    public CatalogoPeliculasImpl(){
        this.datos = new AccesoDatosAdicImpl();
    }

    @Override
    public void agregarPeliculas(String url) {
        
        try {
            
            System.out.println("Introduce el nombre de una pelicula");
            String nombre = scanner.nextLine();
            System.out.println("Introduce el anio de la pelicula");
            String anio = scanner.nextLine();
            datos.escribir(nombre, Integer.parseInt(anio),url);

         } catch (EscrituraDatosEx ex) {
             Logger.getLogger(CatalogoPeliculasImpl.class.getName()).log(Level.SEVERE, null, ex);
         }
    }

    @Override
    public void listarPeliculas(String url) {
        try {
            System.out.println("====== Listar Peliculas ======");
            datos.listar(url);
        } catch (Exception e) {
            System.out.println("Problemas con el acceso a datos");
        }
    }

    @Override
    public void buscarPeliculas(String url, String buscar) {

        try {
           datos.Buscar(url, buscar);
            
        } catch (EscrituraDatosEx e) {
            System.out.println("Error al buscar la peli");
        }
    }

    @Override
    public void iniciarArchivo(String url) {
        try {
            listarPeliculas(url);
            System.out.println("Ingresa el id de la pelicula a ELIMINAR ");
            String id = scanner.nextLine();
            if (id != null) {
                System.out.println("Presione 1 para confirmar la eliminacion");
                String confirmacion = scanner.nextLine();
                if (Integer.parseInt(confirmacion) == 1) {
                    datos.borrar(url, Integer.parseInt(id));
                }else{
                    System.out.println("Operacion cancelada");
                }
            }else{
                System.out.println("id no valido");
            }

        } catch (AccesoDatosEx e) {
            System.out.println("Error de acceso datos");
        }
    }

   
    }
