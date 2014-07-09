/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Modelos;
import Controladores.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author ain
 */
public class Consultas {
    int idconsultas;
    String diagnostico;
    String fecha_diagnostico;//formado aaaa-mm-dd
    String tratamiento;
    int mascota_idmascota;
    OperacionesBD operaciones;
    
    public Consultas()
    {
        idconsultas = 0;
        diagnostico = "";
        fecha_diagnostico = "";
        tratamiento = "";
        mascota_idmascota = 0;
        
    }
    
    public Consultas( int mascota_idmascota ) 
    {
        idconsultas = 0;
        diagnostico = "";
        fecha_diagnostico = "";
        tratamiento = "";
        this.mascota_idmascota = mascota_idmascota;
    }
    
    public void setIdConsultas( int idconsultas)
    {
        this.idconsultas = idconsultas;
    }
    
    public void setDiagnostico( String diagnostico )
    {
        this.diagnostico = diagnostico;
    }
    
    public void setFecha_Diagnostico( String fecha_diagnostico )
    {
        this.fecha_diagnostico = fecha_diagnostico;//falta verifiacar que este en el formato correcto
    }
    
    public void setTratamiento( String tratamiento )
    {
        this.tratamiento = tratamiento;
    }
    
    public void setMascota_Idmascota( int mascota_idmascota )
    {
        this.mascota_idmascota = mascota_idmascota;
    }
    
    public int getIdConsultas()
    {
        return idconsultas;
    }
    
    public String getDiagnostico()
    {
        return diagnostico;
    }
    
    public String getFecha_Diagnostico()
    {
        return fecha_diagnostico;
    }
    
    public String getTratamiento()
    {
        return tratamiento;
    }
    
    public int getMascota_Idmascota()
    {
        return mascota_idmascota;
    }
    
    public void obtenerIdBd() throws SQLException
    {
        String sql;
        sql = "select max(idConsultas) as idConsultas from Consultas;";
        //idconsultas = Integer.parseInt( operaciones.busqueda(sql, 1) );
        Statement s = ControladorConec.getConec().getConexion().createStatement();
        s.execute( "use Veterinaria;" );

        //Asigna el ID Paciente al obtener el número de la base de datos
        ResultSet rs = s.executeQuery( sql );
        rs.next();
        idconsultas = rs.getInt(1) + 1;
        
    }
    
    public void guardarenBaseDatos() throws SQLException
    {
        String sql;
        sql = "insert into Consultas(idConsultas,Diagnostico,Fecha_de_diagnostico,Tratamiento,"
                + "Mascota_idMascota) values"
                + "("+ getIdConsultas() + ",'" + getDiagnostico()+"','"+ getFecha_Diagnostico()+"','"+
                getTratamiento()+"',"+ getMascota_Idmascota() + ");";
        operaciones = new OperacionesBD();
        operaciones.almacenarEnBase(sql);
    }
    
    public void actualizarDatos() throws SQLException
    {
        String sql;
        sql = "update Consultas set Diagnostico = "+this.getDiagnostico()+", Fecha_de_diagnostico = "
                + this.getFecha_Diagnostico() + ", Tratamiento = "+ this.getTratamiento()+
                " where idConsultas = " + this.getIdConsultas() + ";";
        operaciones = new OperacionesBD();
        operaciones.almacenarEnBase(sql);
    }
}
