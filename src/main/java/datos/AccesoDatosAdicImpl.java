/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package datos;

import dominio.PeliculaAmpliado;
import excepciones.LecturaDatosEx;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.*;
import java.util.*;

/**
 *
 * @author Jesus Alberto
 */
public class AccesoDatosAdicImpl extends AccesoDatosImpl{
    public List<PeliculaAmpliado> peliFecha = new ArrayList<PeliculaAmpliado>();
    
    public void cargarInformacion(){
       // peliFecha = new ArrayList<PeliculaAmpliado>();
            String URL = "jdbc:mysql://localhost:3306/db_pelisplus?zeroDateTimeBehavior=convertToNull&useSSL=false&useTimezone=true&serverTimezone=UTC";

         try {
           // BufferedReader entrada = null;
            //File archivo = new File(nombreArchivo);
            
            //entrada = new BufferedReader(new FileReader(archivo));
            Connection conexion = DriverManager.getConnection(URL,"root","bb010901bb");
            Statement sentencia = conexion.createStatement();
            String sql = "SELECT * FROM db_pelisplus.tb_pelisplus";
            ResultSet resultado = sentencia.executeQuery(sql);
            
            while(resultado.next()){
            System.out.print(resultado.getInt(1)+"\t");   
            System.out.print(resultado.getInt(2)+"\t");
            System.out.print(resultado.getInt(3)+"\t");
            }
//            String linea = null;
//            linea = entrada.readLine();
//            while(linea != null){
//                String nombrePe;
//                String Year;
//                String [] arreglo = linea.split(";");
//                nombrePe = arreglo[0];
//                Year = arreglo[1];
//                
//                PeliculaAmpliado pelicula = new PeliculaAmpliado(nombrePe, Year);
//                peliFecha.add(pelicula);
//                linea = entrada.readLine();
//                System.out.println("Peli = "+pelicula.getNombre() +" Year = "+ pelicula.getFproduccion());
//            }
            //entrada.close();
        } catch (SQLException ex) {
           ex.printStackTrace(System.out);
        }
    }
}
