/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package datos;

import dominio.Pelicula;
import dominio.PeliculaAmpliado;
import excepciones.AccesoDatosEx;
import excepciones.EscrituraDatosEx;
import excepciones.LecturaDatosEx;
import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Jesus Alberto
 */
public class AccesoDatosImpl implements IAccesoDatos {
     public List<PeliculaAmpliado> peliFecha = new ArrayList<PeliculaAmpliado>();

    @Override
    public boolean existe(String nombreArchivo) throws AccesoDatosEx {
        
        File archivo = new File(nombreArchivo);
        return archivo.exists();
    }

    @Override
    public void listar(String url) throws LecturaDatosEx{

         try {
            Connection conexion = DriverManager.getConnection(url,"root","bb010901bb");
            Statement sentencia = conexion.createStatement();
            String sql = "SELECT * FROM db_pelisplus.tb_pelisplus";
            ResultSet resultado = sentencia.executeQuery(sql);
            
            while(resultado.next()){
            System.out.print(resultado.getInt(1)+"\t");   
            System.out.print(resultado.getString(2)+"\t");
            System.out.println(resultado.getInt(3)+"\t");
            }
        } catch (SQLException ex) {
           ex.printStackTrace(System.out);
        }
    }
    @Override
    public void escribir(String nombre, int anio, String url) throws EscrituraDatosEx {

        try {
            Connection conexion = DriverManager.getConnection(url,"root","bb010901bb");
            Statement sentencia = conexion.createStatement();
            
            String sql = "insert into tb_pelisplus (nombre, anio) values ('"+nombre+"',"+anio+");";
            
            sentencia.executeUpdate(sql);
            System.out.println("Se ha escrito el registro de pelicula");
            } 
            catch (SQLException ex) {
            ex.printStackTrace(System.out);
            System.out.println("Error al acceder a los datos");
        }
    }

    
    // aqui nos quedamos
    @Override
    public void Buscar(String url, String buscar) throws EscrituraDatosEx {
        
        try {
            Connection conexion = DriverManager.getConnection(url,"root","bb010901bb");
            Statement sentencia = conexion.createStatement();
            
            if(buscar != null || !buscar.equalsIgnoreCase(buscar)) {
            String consulta = "select * from tb_pelisplus  where nombre ='"+buscar+"'";
            ResultSet resultado = sentencia.executeQuery(consulta);
            
            while(resultado.next()){
            System.out.println("Pelicula encontrada en id = "+resultado.getInt(1));
            System.out.print(resultado.getInt(1)+"\t");   
            System.out.print(resultado.getString(2)+"\t");
            System.out.println(resultado.getInt(3)+"\t");
            } 
        }
            
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
    }

    @Override
    public void crear(String nombreArchivo) throws AccesoDatosEx {
        PrintWriter salida = null;
        
        try {
            File archivo = new File (nombreArchivo);
            salida = new PrintWriter (new FileWriter(archivo));
            salida.close();
        } catch (IOException ex) {
            System.out.println("Problema al crear archivo"+ex.getMessage());
        }
    }

    @Override
    public void borrar(String url, int id) throws AccesoDatosEx {
        try {
            Connection conexion = DriverManager.getConnection(url,"root","bb010901bb");
            Statement sentencia = conexion.createStatement();
            
            String sql = "delete from tb_pelisplus  where id ="+id;
            sentencia.executeUpdate(sql);
            
            System.out.println("El archivo se eliminó");

        } catch (Exception e) {
        }
      
    }
    
}
