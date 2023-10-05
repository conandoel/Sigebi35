package datos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.ArrayList;
import entidades.Socio;
import java.time.format.DateTimeFormatter;

public class SocioData {
    private Connection con = null;
    private List <Socio> socios;
    private Socio socio;
    
    public SocioData() {
        con = Conexion.getConexion();
    }
    public void agregarLector(){}
    public void modificarLector(){}
    public void eliminarLector(){}
    public void buscarLectorPorDNI(){}
    public void listarLector(){}
    
    
    
    
    public List buscarHistorialSocios(String criterio, String valor){
        String sql = "SELECT * FROM lector WHERE " + criterio + " = ?;";
        socios = new ArrayList<>();
        
        try{
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, valor);
            
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){
                socio = new Socio();
                socio.setIdSocio(rs.getInt("idSocio"));
                socio.setApellido(rs.getString("apellido"));
                socio.setNombre(rs.getString("nombre"));
                socio.setDomicilio(rs.getString("domicilio"));
                socio.setMail(rs.getString("mail"));
                socio.setFechaDeAlta(rs.getDate("fechaDeAlta").toLocalDate());
                //Esta parte hay que arreglarla
                socio.setFechaDeBaja(rs.getBoolean("estado")? rs.getDate("fechaDeAlta").toLocalDate() : rs.getDate("fechaDeBaja").toLocalDate() );
                socio.setEstado(rs.getBoolean("estado"));
                socios.add(socio);
            }
        }catch(SQLException ex){
            
        }

        return socios;
    }
    
    public List listarColumnas(){
        String sql = "SELECT COLUMN_NAME FROM INFORMATION_SCHEMA.COLUMNS WHERE TABLE_SCHEMA = 'biblioteca' AND TABLE_NAME = 'lector';";
        List <String> columnas = new ArrayList<>();
        try{
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){       
                columnas.add(rs.getString("COLUMN_NAME"));
            }
        }catch(SQLException ex){
            
        }
        
        return columnas;
    }
}
