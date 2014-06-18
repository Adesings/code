package Modelos;

/**
 *
 * @author miguelhernandez
 */
public class propietario {
    
    private String nombre,apellidoPaterno,apellidoMaterno,direccion,telefono;
    

    public propietario (){
    nombre=null;
    apellidoPaterno=null;
    apellidoMaterno=null;
    direccion=null;
    telefono=null;
}
    public propietario (String nombre,String apellidoPaterno,String apellidoMaterno,String direccion,String telefono){
        
        this.nombre=nombre;
        this.apellidoPaterno=apellidoPaterno;
        this.apellidoMaterno=apellidoMaterno;
        this.direccion=direccion;
        this.telefono=telefono;
        
    }
    
    public void setNombre (String nombre){
        this.nombre=nombre;
    }
    public void setApellidoPaterno(String apellidoPaterno){
        this.apellidoPaterno=apellidoPaterno;
    }
    public void setApellidoMaterno(String apellidoMaterno){
        this.apellidoMaterno=apellidoMaterno;
    }
    public void setDireccion(String direccion){
        this.direccion=direccion;
    }
    public void setTelefono(String telefono){
        this.telefono=telefono;
    }
    
    public String getNombre (){
        return nombre;
    }
    public String getApellidoPaterno (){
        return apellidoPaterno;
    }
    public String getApellidoMaterno (){
        return apellidoMaterno;
    }
    public String getDireccion (){
        return direccion;
    }
    public String getTelefono (){
        return telefono;
    }
    
}
