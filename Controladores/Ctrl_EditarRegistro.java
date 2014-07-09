/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Controladores;

import Modelos.*;
import java.sql.SQLException;

/**
 *
 * @author ain
 */
public class Ctrl_EditarRegistro 
{
    Propietario propietario;
    String propiet[];
    String general[];
    String vacunas[];
    String consultas[];
    int numrenglonmodicons[];
    
    public Ctrl_EditarRegistro( Propietario propietario)
    {
        this.propietario = propietario;
        propiet = new String[6];
        general = new String[5];
        vacunas = new String[4];
        consultas = new String[3];
        numrenglonmodicons = new int [propietario.getMascota().getListaConsultas().size()];
    }
    
    public void setPropietario(Propietario propietario)
    {
        this.propietario = propietario;
    }
    
    public Propietario getPropietario()
    {
        return propietario;
    }
    
    public void setPropiet( String propiet[])
    {
        this.propiet = propiet;
    }
    
    public void setGeneral( String general[])
    {
        this.general = general;
    }
    
    public void setVacunas( String vacunas[])
    {
        this.vacunas = vacunas;
    }
    
    public void setConsultas( String consultas[])
    {
        this.consultas = consultas;
    }
    
    public void actualizaRegistro( String propietario[],String general[], 
            String consultas[][], String vacunas[][] ) throws SQLException
    {
        //actualiza datos propietario
        this.propietario.setNombre(propietario[0]);
        this.propietario.setApellidoPaterno(propietario[1]);
        this.propietario.setApellidoMaterno(propietario[2]);
        this.propietario.setCalle(propietario[3]);
        this.propietario.setNumero(Integer.parseInt(propietario[4]));
        this.propietario.setTelefono(propietario[5]);
        this.propietario.actualizarDatos();
        
        //actualiza datos mascota
        this.propietario.getMascota().setNombre(general[0]);
        this.propietario.getMascota().setRaza(general[1]);
        this.propietario.getMascota().setSexo(general[2]);
        this.propietario.getMascota().setColor(general[3]);
        this.propietario.getMascota().setSeñasParticulares(general[4]);
        this.propietario.getMascota().almacenarEnBase();
        
        //actualiza datos consulta
        int indiceconsulta;
        for(int i = 0; i < consultas.length; i++)
        {
            indiceconsulta = this.propietario.getMascota().buscarEnListConsultas(consultas[i][0], 
                    consultas[i][1], consultas[i][2]);
            
            if( indiceconsulta> -1 && !consultas[i][0].equalsIgnoreCase("") )
            {
                Consultas aux;
                aux = this.propietario.getMascota().getListaConsultas().get(indiceconsulta);
                aux.setDiagnostico(consultas[i][0]);
                aux.setFecha_Diagnostico(consultas[i][1]);
                aux.setTratamiento(consultas[i][2]);
                aux.actualizarDatos();
                this.propietario.getMascota().getListaConsultas().add(indiceconsulta, aux);
            }
        }
        
        int indicevacuna;
        for(int i = 0; i < vacunas.length; i++)
        {
            indicevacuna = this.propietario.getMascota().buscarEnListVacunas(vacunas[i][0], 
                    vacunas[i][1], vacunas[i][2], vacunas[i][3]);
            if(indicevacuna > -1 && !vacunas[i][0].equalsIgnoreCase(""))
            {
                Vacuna aux;
                aux = this.propietario.getMascota().getListaVacunas().get(indicevacuna);
                aux.setVacuna(vacunas[i][0]);
                aux.setFechaAplicacion(vacunas[i][1]);
                aux.setLote(vacunas[i][2]);
                aux.setLaboratorio(vacunas[i][3]);
                aux.actualizarDatos();
                this.propietario.getMascota().getListaVacunas().add(indicevacuna, aux);
            }
        }
        
        
    }
    
}
