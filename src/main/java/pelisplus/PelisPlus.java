/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pelisplus;

import datos.AccesoDatosAdicImpl;
import datos.IAccesoDatos;
import java.sql.*;
import java.util.Scanner;
import negocio.CatalogoPeliculas;
import negocio.CatalogoPeliculasImpl;

/**
 *
 * @author Jesus Alberto
 */
public class PelisPlus {
    private static final Scanner scanner = new Scanner (System.in);
    private static int opcion = -1;
    private static final String url = "jdbc:mysql://localhost:3306/db_pelisplus?zeroDateTimeBehavior=convertToNull&useSSL=false&useTimezone=true&serverTimezone=UTC";
    private static final CatalogoPeliculas catalogoPeli = new CatalogoPeliculasImpl();
    
    public static void main(String[] args) {
         //Mientras la opcion elegida sea 0, preguntamos al usuario
        while (opcion != 0) {
            try {
                System.out.println("Elige opcion:\n"
                        + "1.- Listar Peliculas\n"
                        + "2.- Agregar pelicula\n"
                        + "3.- Buscar Pelicula\n"
                        + "4.- Eliminar pelicula\n"
                        + "0.- Salir");

                opcion = Integer.parseInt(scanner.nextLine());

                //Ejemplo de switch case en Java
                switch (opcion) {
                    case 1:
                        //1. listar catalogo completo
                        catalogoPeli.listarPeliculas(url);
                        break;
                    case 2:
                        //2. agregar informacion archivo
                        catalogoPeli.agregarPeliculas(url);
                        break;
                    case 3:
                         //4. Buscar pelicula
                        System.out.println("Introduce el nombre de una pelicula a buscar:");
                        String buscar = scanner.nextLine();
                        catalogoPeli.buscarPeliculas(url, buscar);
                        
                        break;
                    case 4:
                        //4. Eliminamos la pelicula
                        catalogoPeli.iniciarArchivo(url);
                        break;
                    case 0:
                        System.out.println("!Hasta pronto!");
                        break;
                    default:
                        System.out.println("Opcion no reconocida");
                        break;
                }
                System.out.println("\n");

            } catch (Exception e) {
                System.out.println("Error!");
            }
        }
    }
            
    
}
