/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Controladores;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author ain
 */
public class OperacionesBD 
{
    public OperacionesBD(/*String usuario, String contrasenia*/) /*throws SQLException, ClassNotFoundException*/
    {
        //ControladorConec.getConec().establecerConexion(usuario, contrasenia);
    }
   
    
    /**
     * @param instruccionsql: instuccion sql de busqueda
     * @param ncolumnas: numero de columnas a mostrar por la busqueda
     * @return cadena con los resultados
     */
    
    public String busqueda( String instruccionsql, int ncolumnas ) throws SQLException
    {
        String cadena = "";
        //String [] cadenas = null ; 
        Statement s = ControladorConec.getConec().getConexion().createStatement();
        s.execute( "use Veterinaria" );
        ResultSet rs = s.executeQuery( instruccionsql );
        
        while( rs.next() )
        {
            int i = 0;
            for( i = 1; i <= ncolumnas; i++ )
            {
                if(ncolumnas > 1)
                {   
                    cadena = cadena + rs.getString(i) + ",";
                    //cadenas[i]=rs.getString(i);
                    
                }else
                {
                    cadena = cadena + rs.getString(i);
                    //cadenas[i]=rs.getString(i);
                }
            }
                
            cadena = cadena + "\n";
            
        }
        //conec.desconectar();
        System.out.println(cadena + "esta es la cadena");
        
        return cadena;
    }
    
    /**
     * 
     * @param instruccionsql: es la intruccion sql almacenar algo en la
     * base de datos
     */
    public void almacenarEnBase( String instruccionsql ) throws SQLException
    {
        Statement s = ControladorConec.getConec().getConexion().createStatement();
        s.execute( "use Veterinaria" );
        s.executeUpdate( instruccionsql );
        //conec.desconectar;
    }
    
    /**
     * utilizar este metodo para ejecutar una instruccion que no regrese informacion
     * @param intruccionsql: es la instruccion sql que se desea ejecutar
     */
    public void ejecutarInstruccion( String intruccionsql ) throws SQLException
    {
        Statement s = ControladorConec.getConec().getConexion().createStatement();
        s.execute( "use Veterinaria" );
        s.execute( intruccionsql );
        
    }
}
