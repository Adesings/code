package Controladores;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ain
 */

import Modelos.*;
import java.sql.SQLException;

public class Ctrl_RegistrarPaciente 
{
    
    private Propietario propietario;
    
    public Ctrl_RegistrarPaciente(){}
    
    public void setPropietario( Propietario propietario)
    {
        this.propietario = propietario;
    }
    
    public Propietario getpropietario()
    {
        return propietario;
    }
    
    /**
     * crea un objeto tipo consultas, asigna los valores correspondientes a sus variables
     * y lo almacena en la base de datos
     * @param diagnostico: descripcion del padecimiento
     * @param fecha_de_diagnostico: 
     * @param tratamiento:
     * @param mascota_idmascota: llave primaria de la mascota
     * @throws SQLException:
     */
    public void creaConsulta( String diagnostico,
            String fecha_de_diagnostico, String tratamiento,
            int mascota_idmascota ) throws SQLException
    {
        propietario.getMascota().setConsulta( new Consultas( mascota_idmascota ));
        propietario.getMascota().getConsulta().setDiagnostico(diagnostico);
        propietario.getMascota().getConsulta().setFecha_Diagnostico( fecha_de_diagnostico );
        propietario.getMascota().getConsulta().setTratamiento( tratamiento );
        propietario.getMascota().getConsulta().obtenerIdBd();
        
        propietario.getMascota().getConsulta().guardarenBaseDatos();
        
        //return consulta;
        
    }
    
    /**
     * crea un objeto tipo vacuna, asigna los valores correspondientes a sus variables
     * y lo almacena en la base de datos
     * @param vacuna: nombre de la vacuna
     * @param fecha_aplicacion: fecha con el formato aaaa-mm-dd
     * @param lote: el lote de la vacuna
     * @param laboratorio: nombre del laboratorio
     * @param idmascota: id de la cascota
     * @throws SQLException
     */
    public void creaVacuna( String vacuna, String fecha_aplicacion, String lote,
            String laboratorio, int idmascota ) throws SQLException
    {
        propietario.getMascota().setVacuna(new Vacuna( idmascota ));
        
        propietario.getMascota().getVacuna().setVacuna(vacuna);
        propietario.getMascota().getVacuna().setFechaAplicacion(fecha_aplicacion);
        propietario.getMascota().getVacuna().setLote(lote);
        propietario.getMascota().getVacuna().setLaboratorio(laboratorio);
        propietario.getMascota().getVacuna().obtenerIds();
        propietario.getMascota().getVacuna().guardarBasesDatos();
        
        //return vacu;
        
    }
    
    
    /**
     * crea un objeto tipo paciente, asigna los valores correspondientes a las variables
     * y lo almacena en la base de datos
     * @param nombre: nombre de la mascota
     * @param especie: especie de la mascota
     * @param raza: raza de la mascota
     * @param sexo: sexo de la mascota
     * @param color: color de la mascota
     * @param señas_particulares:
     * @param idcliente: id del propietario
     * @throws SQLException
     */
    public void creaPaciente( String nombre, String especie, String raza, String sexo,
            String color, String señas_particulares, int idcliente) throws SQLException
    {
        propietario.setMascota( new Paciente( idcliente ) );
        propietario.getMascota().setNombre(nombre);
        propietario.getMascota().setEspecie(especie);
        propietario.getMascota().setRaza(raza);
        propietario.getMascota().setSexo(sexo);
        propietario.getMascota().setColor(color);
        propietario.getMascota().setSeñasParticulares(señas_particulares);
        propietario.getMascota().setIdCliente(idcliente);
        propietario.getMascota().obtenerIDs();
        
        propietario.getMascota().guardarBaseDatos();
        //return paciente;
    }
}
