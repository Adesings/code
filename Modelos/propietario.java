package Modelos;

import Controladores.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author miguelhernandez
 */
public class Propietario {

    private String nombre,apellidoPaterno,apellidoMaterno,calle,telefono;
    private Integer numero,IdPropietario,IdNombres,IdDireccion;
    private OperacionesBD operaciones;
    private Paciente mascota;
    private ArrayList<Paciente> lmascotas;
    private Iterator<Paciente> iteradormascotas;

    public Propietario (){
    nombre=null;
    apellidoPaterno=null;
    apellidoMaterno=null;
    calle=null;
    numero=0;
    telefono=null;
    
}
    public Propietario (Integer IdPropietario,String nombre,String apellidoPaterno,String apellidoMaterno,String calle,Integer numero,String telefono){
        
        this.IdPropietario=IdPropietario;
        this.nombre=nombre;
        this.apellidoPaterno=apellidoPaterno;
        this.apellidoMaterno=apellidoMaterno;
        this.calle=calle;
        this.numero=numero;
        this.telefono=telefono;
        lmascotas = new ArrayList<>();
        iteradormascotas = lmascotas.iterator();
        
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
    public void setTelefono(String telefono){
        this.telefono=telefono;
    }
    public void setNumero(Integer numero) {
        this.numero = numero;
    }
    public void setCalle(String calle) {
        this.calle = calle;
    }
    public void setIdPropietario(Integer IdPropietario) {
        this.IdPropietario = IdPropietario;
    }
    public void setIdDireccion(Integer IdDireccion) {
        this.IdDireccion = IdDireccion;
    }
    public void setIdNombres(Integer IdNombres) {
        this.IdNombres = IdNombres;
    }
    
    public void setMascota(Paciente mascota)
    {
        this.mascota = mascota;
    }
    
    public Paciente getMascota()
    {
        return mascota;
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
    public String getTelefono (){
        return telefono;
    }
    public String getCalle() {
        return calle;
    }
    public Integer getNumero() {
        return numero;
    }
    public Integer getIdPropietario() {
        return IdPropietario;
    }
    public Integer getIdNombres() {
        return IdNombres;
    }
    public Integer getIdDireccion() {
        return IdDireccion;
    }
    
    public ArrayList<Paciente> getLista()
    {
        return lmascotas;
    }
    
    public Iterator<Paciente> getIterador()
    {
        return iteradormascotas;
    }
    

     
    public void obtenerIds() throws SQLException {
        
        //Cadenas para obtener el ID de las tablas de la BD
        String idpro="select max(idClientes) as idClientes from Clientes;";
        String iddir="select max(idDireccion) as idClientes from Direccion;";
        String idnom="select max(idNombres) as idClientes from Nombres_Humanos;";
                
        
        //Conexión a la base de datos
        Statement s = ControladorConec.getConec().getConexion().createStatement();
        s.execute( "use Veterinaria;" );
           
            //Asigna el ID Propietario al obtener el número de la base de datos
            ResultSet rs = s.executeQuery( idpro );
            rs.next();//colocar un if no funciona si la bases de datos esta vacia!!!!!!!!!!!!!!!!!!!!!
            IdPropietario = rs.getInt(1) + 1;
            
            //Asigna el ID Direccion al obtener el número de la base de datos
            rs = s.executeQuery( iddir );
            rs.next();//colocar un if no funciona si la bases de datos esta vacia!!!!!!!!!!!!!!!!!!!!!
            IdDireccion=((Integer) rs.getInt(1) + 1);
            
            //Asigna el ID Nombres al obtener el número de la base de datos
            rs = s.executeQuery( idnom );
            rs.next();//colocar un if no funciona si la bases de datos esta vacia!!!!!!!!!!!!!!!!!!!!!
            IdNombres=((Integer) rs.getInt(1) + 1);
        
    }
            
    
    public void guardarBaseDatos() throws SQLException {
       
        //Cadenas con comandos para actualizar o guardar informacion en las tablas de la BD
       String actualizarClientes= "insert into Clientes (idClientes,Telefono,Nombres_Humanos_idNombres,Direccion_idDireccion) values ("+this.getIdPropietario()+",'"+this.getTelefono()+"',"+this.getIdNombres()+","+this.getIdDireccion()+");";
       String actualizarDireccion= "insert into Direccion (idDireccion,Calle,Numero) values ("+this.getIdDireccion()+",'"+this.getCalle()+"',"+this.getNumero()+");";
       String actualizarNombresHumanos= "insert into Nombres_Humanos (idNombres,Nombres,Apellido_Paterno,Apellido_Materno) values ("+this.getIdNombres()+",'"+this.getNombre()+"','"+this.getApellidoPaterno()+"','"+this.getApellidoMaterno()+"');";
       
       
       //Manda a llamar al método de Actualizar y pasando las cadenas con los datos para actualizar tablas de BD
       operaciones = new OperacionesBD();
       operaciones.almacenarEnBase(actualizarNombresHumanos);
       operaciones.almacenarEnBase(actualizarDireccion);
       operaciones.almacenarEnBase(actualizarClientes);
       
       
    }
    
    /**
     * regresa la pocicion del elemento buscado en la lista
     * @return posicion de elemento o -1 si no se encuentra
     */
    public int buscarEnListaMascotas(String nombre, String raza, String sexo, String señas_par)
    {
        for(int i =0; iteradormascotas.hasNext(); i++)
        {
            Paciente aux;
            aux = iteradormascotas.next();
            if(aux.getNombre().equalsIgnoreCase(nombre) & 
                    aux.getRaza().equalsIgnoreCase(raza) &
                    aux.getSexo().equalsIgnoreCase(sexo) &
                    aux.getSeñasParticulares().equalsIgnoreCase(señas_par))
            {
                return i;
            }
        }
        
        return -1;
    }
    
    public void actualizarDatos() throws SQLException
    {
        String sql;
        
        //tabla clientes;
        sql = "update Clientes set Telefono = " + getTelefono() +
                " where idClientes = " + this.getIdPropietario() + ";";
        operaciones.almacenarEnBase(sql);
        
        //tabla dirrecion
        sql = "update Direccion set Calle = " + this.getCalle()+","+ 
                "Numero = " +this.getNumero() + " where idDireccion = "+this.getIdDireccion() + ";";
        operaciones.almacenarEnBase(sql);
        
        //tabla Nombres_Humanos
        sql = "update Nombres_Humanos set Nombres = "+ this.getNombre()+",Apellido_Paterno = "+
                this.getApellidoPaterno()+",Apellido_Materno = "+this.getApellidoMaterno()+
                "where idNombres = "+ this.getIdNombres()+";";
        operaciones.almacenarEnBase(sql);
        
    }

}
