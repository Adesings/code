package Controladores;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author ain
 */
public class ControladorConec 
{
    private Connection conexion;
    private static ControladorConec conec;
    
    ControladorConec(){}
    
    public void establecerConexion( String usuario, String contraseña ) throws SQLException, ClassNotFoundException
    {
        Class.forName( "com.mysql.jdbc.Driver" );
        conexion = DriverManager.getConnection("jdbc:mysql://localhost/Veterinaria", usuario, contraseña);
    }
    
    public Connection getConexion()
    {
        return conexion;
    }
    
    public void desconectar() throws SQLException
    {
        conexion.close();
    }
    
    public static synchronized ControladorConec getConec()
    {
        if (conec == null)
        {
            conec = new ControladorConec();
        }
        return conec;
    }
}
