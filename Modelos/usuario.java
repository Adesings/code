package Modelos;

/**
 *
 * @author miguelhernandez
 */
public class Usuario {
    
    private String nombreUsuario,password;
    

    public Usuario (){
    nombreUsuario=null;
    password=null;
    
}
    public Usuario (String nombreUsuario,String password){        
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
