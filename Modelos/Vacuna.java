/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Modelos;

import Controladores.ControladorConec;
import Controladores.OperacionesBD;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author alexc_000
 */
public class Vacuna {
    
    private int IdVacunas;
    private String Vacuna,FechaAplicacion,Lote,Laboratorio; 
    private Integer IdMascotas;
     
    //Constructores
    public Vacuna(){
        
        IdVacunas=0;
        Vacuna="";
        FechaAplicacion="";
        Lote="";
        Laboratorio="";
        IdMascotas=0;                
    }

    public Vacuna (Integer idMascota){
        
        IdVacunas=0;
        Vacuna=null;
        FechaAplicacion=null;
        Lote=null;
        Laboratorio=null;
        this.IdMascotas =idMascota;
    }

//Inician Getters
    public Integer getIdVacunas() {
        return IdVacunas;
    }
    public String getVacuna() {
        return Vacuna;
    }
    public String getFechaAplicacion() {
        return FechaAplicacion;
    }
    public String getLote() {
        return Lote;
    }
    public String getLaboratorio() {
        return Laboratorio;
    }
    public Integer getIdMascotas() {
        return IdMascotas;
    }
    
    //Inician Setters
    public void setIdVacunas(Integer IdVacunas) {
        this.IdVacunas = IdVacunas;
    }
    public void setVacuna(String Vacuna) {
        this.Vacuna = Vacuna;
    }
    public void setFechaAplicacion(String FechaAplicacion) {
        this.FechaAplicacion = FechaAplicacion;
    }
    public void setLote(String Lote) {
        this.Lote = Lote;
    }
    public void setLaboratorio(String Laboratorio) {
        this.Laboratorio = Laboratorio;
    }
    public void setIdMascotas(Integer IdMascotas) {
        this.IdMascotas = IdMascotas;
    }
    
    //Inician métodos
    public void obtenerIds() throws SQLException {
    
        //Cadenas para obtener IdMascota
        //String idmasc="select max(idMascota) as idMascota from Mascota";
        String idvac="select max(idVacunas) as idVacunas from Vacunas";
        
        //Conexión a la base de datos
        Statement s = ControladorConec.getConec().getConexion().createStatement();
        s.execute( "use Veterinaria;" );
                      
        //Asigna el IdVacunas al obtener el número de la base de datos
        ResultSet rs = s.executeQuery( idvac );
        rs.next();//colocar un if no funciona si la bases de datos esta vacia!!!!!!!!!!!!!!!!!!!!!
        IdVacunas = rs.getInt(1) + 1;
        
        //Asigna el IdMascotas al obtener el número de la base de datos
        /*rs.next();//colocar un if no funciona si la bases de datos esta vacia!!!!!!!!!!!!!!!!!!!!!
        IdMascotas = rs.getInt(1) + 1;*/
        
      }    
      
      public void guardarBasesDatos() throws SQLException {
       
        OperacionesBD operaciones = new OperacionesBD();  
               
        //Cadenas con comandos para actualizar la informacion de las tablas en la BD
        String actualizarVacunas= "insert into Vacunas (idVacunas,Vacuna,Fecha_de_aplicacion,"
                + "Lote,Laboratorio,Mascota_idMascota) values ("+this.getIdVacunas()+",'"
                +this.getVacuna()+"','"+this.getFechaAplicacion()+"','"+this.getLote()+"','"+this.getLaboratorio()
                +"',"+this.getIdMascotas()+");";
        operaciones.almacenarEnBase( actualizarVacunas );
      }
       
      public void actualizarDatos() throws SQLException
      {
          String sql;
          sql = "update Vacunas set Vacuna = "+this.getVacuna()+", Fecha_de_aplicacion = "
                  + this.getFechaAplicacion() + ", Lote = "+this.getLote()+", Laboratorio = "
                  + this.getLaboratorio() + " where idVacunas = " + this.getIdVacunas()+";";
          OperacionesBD operaciones = new OperacionesBD();
          operaciones.almacenarEnBase( sql );
      }
           
    }

    
  
  
    