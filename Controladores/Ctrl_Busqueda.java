package Controladores;
import Modelos.*;
import Controladores.*;
import Vistas.ResultadosBusquedaPac;
import java.sql.SQLException;
import java.util.StringTokenizer;
/**
 *
 * @author miguelhernandez
 */
public class Ctrl_Busqueda {
    
    private String nombrePropietario,apellidoPaterno;
    private OperacionesBD operaciones;
    //private Ctrl_ResultadosBusquedaPac resul;
    private String data []=null;
    private String s;
    
    public Ctrl_Busqueda(){
    }
    
    public Ctrl_Busqueda(String nombrePropietario,String apellidoPaterno){
        this.nombrePropietario=nombrePropietario;
        this.apellidoPaterno=apellidoPaterno;
    }
    
    public void setNombrePropietario(String nombrePropietario){
        this.nombrePropietario=nombrePropietario;
    } 
    public void setApellidoPaterno(String apellidoPaterno){
        this.apellidoPaterno=apellidoPaterno;
    }
    
    public void buscar(String nombrePropietario,String apellidoPaterno)throws SQLException{
        
        this.nombrePropietario=nombrePropietario;
        this.apellidoPaterno=apellidoPaterno;
        
        String resultados;  
        //,c.idClientes
        String sql = " select Nh.Nombres,Nh.Apellido_Paterno "
                + "from Nombres_Humanos Nh inner join Clientes c "
                + "on c.Nombres_Humanos_idNombres = Nh.idNombres Where Nh.Nombres = \"" 
                + this.nombrePropietario  +"\" and Nh.Apellido_Paterno = \"" + this.apellidoPaterno + "\";";
        
        
        
        operaciones = new OperacionesBD(); 
        
        resultados = operaciones.busqueda(sql, 2);
        
        int numeroTokens;
        
        StringTokenizer aux = new StringTokenizer(resultados,",");
        numeroTokens=aux.countTokens();
        numeroTokens=numeroTokens-1;
        
        
        data=new String [numeroTokens];
        
        for(int i=0 ; i<data.length;i++){
            s=aux.nextToken();
            data [i]=s;
        
        
        }
       
        
        //resul.rellenaResultadosBusquedaPac(resultados);
        
        
        ResultadosBusquedaPac RBP = new ResultadosBusquedaPac(data);
        //ResultadosBusquedaPac RBP = new ResultadosBusquedaPac();
        RBP.setVisible(true);
            
        
        
        
    }  
}
