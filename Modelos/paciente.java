package Modelos;
import Controladores.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author miguelhernandez
 */
public class Paciente {
    
    private String especie,nombre,raza,sexo,color,señasParticulares;
    private int idMascota,Clientes_idClientes,id_Cliente;
    private OperacionesBD operaciones;
    private Consultas consulta;
    private Vacuna vacuna;
    private ArrayList<Consultas> lconsultas;
    private ArrayList<Vacuna> lvacuna;
    private Iterator <Consultas> iteradorconsultas;
    private Iterator <Vacuna> iteradorvacunas;


    public Paciente (){
        
        idMascota=0;
        especie=null;
        nombre=null;
        raza=null;
        sexo=null;
        color=null;
        señasParticulares=null;
        lconsultas = new ArrayList<>();
        lvacuna = new ArrayList<>();
        iteradorconsultas = lconsultas.iterator();
        iteradorvacunas = lvacuna.iterator();
    
    }

    public Paciente(int id_Cliente){

        idMascota=0;
        especie=null;
        nombre=null;
        raza=null;
        sexo=null;
        color=null;
        señasParticulares=null;
        this.id_Cliente=id_Cliente;
        lconsultas = new ArrayList<>();
        lvacuna = new ArrayList<>();
        iteradorconsultas = lconsultas.iterator();
        iteradorvacunas = lvacuna.iterator();

    
    }

    /*public paciente (int idMascota; String especie,String nombre,String raza, String sexo, String color,String señasParticulares){
        
        this.idMascota=idMascota;
        this.especie=especie;
        this.nombre=nombre;
        this.raza=raza;
        this.sexo=sexo;
        this.color=color;
        this.señasParticulares=señasParticulares;
        
    }*/

    public void obtenerIDs () throws SQLException {

        String idPac="select max(idMascota) as idMascota from Mascota;";

        //Conexión a la base de datos
        Statement s = ControladorConec.getConec().getConexion().createStatement();
        s.execute( "use Veterinaria;" );

        //Asigna el ID Paciente al obtener el número de la base de datos
        ResultSet rs = s.executeQuery( idPac );
        rs.next();
        idMascota = rs.getInt(1) + 1;

    }
    
    public void setConsulta( Consultas consulta )
    {
        this.consulta = consulta;
    }
    
    public void setVacuna(Vacuna vacuna)
    {
        this.vacuna = vacuna;
    }
    
    public void setIdCliente(int id_Cliente){
        this.id_Cliente=id_Cliente;
    }
    public void setIdMAscota(int idMascota){
        this.idMascota=idMascota;
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


    public int id_Cliente(){
        return id_Cliente;
    }
    public int getIdMascota(){
        return idMascota;
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
    
    public Consultas getConsulta()
    {
        return consulta;
    }
    
    public Vacuna getVacuna()
    {
        return vacuna;
    }
    
    public ArrayList<Consultas> getListaConsultas()
    {
        return lconsultas;
    }
    
    public ArrayList<Vacuna> getListaVacunas()
    {
        return lvacuna;
    }
    
    public Iterator<Consultas> getIteradorConsultas()
    {
        return iteradorconsultas;
    }
    
    public Iterator<Vacuna> getIteradorVacunas()
    {
        return iteradorvacunas;
    }
    
    /**
     * regresa la pocicion del elemento buscado en la lista
     * @return posicion de elemento o -1 si no se encuentra
     */
    public int buscarEnListConsultas(String diagnostico, String fecha, String tratamiento)
    {
        for( int i = 0; iteradorconsultas.hasNext() ; i++ )
        {
            Consultas aux;
            aux = iteradorconsultas.next();
            if(aux.getDiagnostico().equalsIgnoreCase(diagnostico) & 
                    aux.getFecha_Diagnostico().equalsIgnoreCase(diagnostico) & 
                    aux.getTratamiento().equalsIgnoreCase(tratamiento))
            {
                return i;
            }
        }
        
        return -1;
    }
    
    /**
     * regresa la pocicion del elemento buscado en la lista
     * @return posicion de elemento o -1 si no se encuentra
     */
    public int buscarEnListVacunas(String vacuna, String fecha, String lote, String laboratorio)
    {
        for( int i = 0; iteradorconsultas.hasNext() ; i++ )
        {
            Vacuna aux;
            aux = iteradorvacunas.next();
            if(aux.getVacuna().equalsIgnoreCase(vacuna) & 
                    aux.getFechaAplicacion().equalsIgnoreCase(fecha) & 
                    aux.getLote().equalsIgnoreCase(lote) & aux.getLaboratorio().equalsIgnoreCase(laboratorio))
            {
                return i;
            }
        }
        
        return -1;
    }
    
    public void guardarBaseDatos() throws SQLException {

        String actualizarMascota = "insert into Mascota ( idMascota,Nombre,Especie,Raza,"
                + "Sexo,color,Señas_Particulares,Clientes_idClientes) values "
                + "( "+this.getIdMascota()+",'"+this.getNombre()+"','"+this.getEspecie()
                + "','"+this.getRaza()+"','"+this.getSexo()+"','"+this.getColor()+"','"
                + this.getSeñasParticulares()+"',"+id_Cliente+" );";

        operaciones = new OperacionesBD();
        operaciones.almacenarEnBase( actualizarMascota );

    }
    
    public void almacenarEnBase() throws SQLException
    {
        String sql = "update Mascota set Nombre = "+this.getNombre()+", Especie = "
                +this.getEspecie()+", Raza = "+this.getRaza()+", Sexo = "+this.getSexo()
                +", Color = "+ this.getColor() +", Señas_Particulares = "+this.getSeñasParticulares()
                + " where idMascota = "+ this.getIdMascota();
        operaciones = new OperacionesBD();
        operaciones.almacenarEnBase( sql );
    }
    
}
