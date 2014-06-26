package Controladores;
/**
 *
 * @author ain
 */

import java.sql.*;

public class Conexion 
{
    private Connection conexion;
    
    Conexion(){}
    
    public void establecerConexion() throws SQLException, ClassNotFoundException
    {
        Class.forName( "com.mysql.jdbc.Driver" );
        conexion = DriverManager.getConnection("jdbc:mysql://localhost/Veterinaria", "root", "root");
    }
    
    public Connection getConexion()
    {
        return conexion;
    }
    
    public void desconectar() throws SQLException
    {
        conexion.close();
    }
    
    
}
