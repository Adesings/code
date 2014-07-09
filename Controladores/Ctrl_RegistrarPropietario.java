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
public class Ctrl_RegistrarPropietario {
    
    private Propietario propi;
    
    public Ctrl_RegistrarPropietario(){}
    
    public void setPropietario( Propietario  prop)
    {
        propi = prop;
    }
    
    public Propietario getPropietario()
    {
        return propi;
    }
    
    public Propietario creaPropietario(String nombres, String apPaterno, String apMaterno, String telefono,String calle, int num) throws SQLException
    {
        propi = new Propietario();
        propi.setNombre( nombres );
        propi.setApellidoPaterno( apPaterno );
        propi.setApellidoMaterno( apMaterno );
        propi.setTelefono(telefono);
        propi.setCalle( calle );
        propi.setNumero( num );
        propi.obtenerIds();
        propi.guardarBaseDatos();
        
        return propi;
    }
}
