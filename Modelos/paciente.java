package Modelos;

/**
 *
 * @author miguelhernandez
 */
public class paciente {
    
    private String especie,nombre,raza,sexo,color,señasParticulares;
    

    public paciente (){
        especie=null;
        nombre=null;
        raza=null;
        sexo=null;
        color=null;
        señasParticulares=null;
    
}
    public paciente (String especie,String nombre,String raza, String sexo, String color,String señasParticulares){
        
        this.especie=especie;
        this.nombre=nombre;
        this.raza=raza;
        this.sexo=sexo;
        this.color=color;
        this.señasParticulares=señasParticulares;
        
    }
    
    public void setEspecie(String especie){
        this.especie=especie;
    }
    public void setNombre (String nombre){
        this.nombre=nombre;
    }
    public void setRaza(String raza){
        this.raza=raza;
    }
    public void setSexo(String sexo){
        this.sexo=sexo;
    }
    public void setColor(String color){
        this.color=color;
    }
    public void setSeñasParticulares(String señasParticulares){
        this.señasParticulares=señasParticulares;
    }
    
    public String getEspecie(){
        return especie;
    }
    public String getNombre (){
        return nombre;
    }
    public String getRaza(){
        return raza;
    }
    public String getSexo(){
        return sexo;
    }
    public String getColor(){
        return color;
    }
    public String getSeñasParticulares(){
        return señasParticulares;
    }
    
    
}

