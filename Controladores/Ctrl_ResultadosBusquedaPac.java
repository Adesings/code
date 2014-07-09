package Controladores;
import Modelos.*;
import Controladores.*;
import Vistas.ResultadosBusquedaPac;
import java.sql.SQLException;
import java.util.StringTokenizer;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author miguelhernandez
 */
public class Ctrl_ResultadosBusquedaPac {
    
    private String nombrePropietario,apellidoPaterno;
    private OperacionesBD operaciones;
    private String data []=null;
    private String data1 []=null;
    private String s;
    
    
    public Ctrl_ResultadosBusquedaPac(){
         
    }
    
    public void buscar(String nombrePropietario,String apellidoPaterno)throws SQLException{
        
        this.nombrePropietario=nombrePropietario;
        this.apellidoPaterno=apellidoPaterno;
        
        String resultados,resultadosMascota;  
        
        String sql = " select Nh.Nombres,Nh.Apellido_Paterno,c.idClientes "
                + "from Nombres_Humanos Nh inner join Clientes c "
                + "on c.Nombres_Humanos_idNombres = Nh.idNombres Where Nh.Nombres = \"" 
                + this.nombrePropietario  +"\" and Nh.Apellido_Paterno = \"" + this.apellidoPaterno + "\";";
        
        operaciones = new OperacionesBD(); 
        
        resultados = operaciones.busqueda(sql, 3);
        
        
        
        int numeroTokens;
        
        StringTokenizer aux = new StringTokenizer(resultados,",");
        numeroTokens=aux.countTokens();
        numeroTokens=numeroTokens-1;
        
        
        data=new String [numeroTokens];
        
        for(int i=0 ; i<data.length;i++){
            s=aux.nextToken();
            data [i]=s;
        
        }
        
        
        
        
        System.out.println("Este es el numero de id: "+data[2]);
        
        String numIdPropietario = data[2];
        
        
        String sql2 = " select Nh.Nombres,Nh.Apellido_Paterno "
                + "from Nombres_Humanos Nh inner join Clientes c "
                + "on c.Nombres_Humanos_idNombres = Nh.idNombres Where Nh.Nombres = \"" 
                + this.nombrePropietario  +"\" and Nh.Apellido_Paterno = \"" + this.apellidoPaterno + "\";";
        
        resultados = operaciones.busqueda(sql2, 2);
        
        int numeroTokens2;
        
        StringTokenizer aux2 = new StringTokenizer(resultados,",");
        numeroTokens2=aux2.countTokens();
        numeroTokens2=numeroTokens2-1;
        
        
        data=new String [numeroTokens2];
        
        for(int i=0 ; i<data.length;i++){
            s=aux2.nextToken();
            data [i]=s;
        
        
        }
        
        
        
        
        String sql1 = " select Nombre,Raza "
              + "from Mascota "
              + "where Clientes_idClientes = " 
              + numIdPropietario  + ";";
        
        resultadosMascota = operaciones.busqueda(sql1, 2);
        
        
        int numeroTokens1;
        
        StringTokenizer aux1 = new StringTokenizer(resultadosMascota,",");
        numeroTokens1=aux1.countTokens();
        numeroTokens1=numeroTokens1-1;
        System.out.println("Numero Tokens Mascota: "+numeroTokens1);
        
        data1=new String [numeroTokens1];
        
        for(int i=0 ; i<data1.length;i++){
            s=aux1.nextToken();
            data1 [i]=s;
        
        
        }
        
        
        ResultadosBusquedaPac RBP = new ResultadosBusquedaPac(data,data1,numIdPropietario);
        
        RBP.setVisible(true);
        
        
    }
    
}
    
