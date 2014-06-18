package Modelos;

/**
 *
 * @author miguelhernandez
 */
public class usuario {
    
    private String nombreUsuario,password;
    

    public usuario (){
    nombreUsuario=null;
    password=null;
    
}
    public usuario (String nombreUsuario,String password){        
        this.nombreUsuario=nombreUsuario;
        this.password=password;    
    }
    
    public void setNombreUsuario (String nombreUsuario){
        this.nombreUsuario=nombreUsuario;
    }
    public void setPassword (String Password){
        this.password= password;
    }
  
    public String getNombreUsuario (){
        return nombreUsuario;
    }
    public String getPassword(){
        return password;
    }
   
}
