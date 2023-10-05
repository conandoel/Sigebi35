package datos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.ArrayList;
import entidades.Socio;
import java.time.format.DateTimeFormatter;
import javax.swing.JOptionPane;

public class SocioData {
    private Connection con = null;
    private List <Socio> socios;
    private List <String> columnas;
    private Socio socio;
    
    public SocioData() {
        con = Conexion.getConexion();
    }
    public void agregarLector(){}
    public void modificarLector(){}
    
    public Socio eliminarLector(String criterio, String valor){
        //PROBLEMA DE CRITERIO SEA ESTADO CON VALOR 1
        String sql = "UPDATE lector SET estado = 0 WHERE " + criterio + " = " + valor + ";";
        JOptionPane.showMessageDialog(null, valor + " " + criterio);
        try{
            PreparedStatement ps = con.prepareStatement(sql);
            int filas = ps.executeUpdate();
            
            columnas = new ArrayList<>();
            columnas = listarColumnas();
            
            while(filas>0){       
                Socio socio = new Socio();
                if(criterio.equals("Número de Socio")){
                    criterio = "idSocio";
                }else{
                    criterio = criterio.toLowerCase();
                }
 
                for(String columna : columnas){
                    if(criterio.equals(columna)){
                        socios = buscarHistorialSocios(criterio, valor);
                    }
                }
            }
            socio = socios.get(0);
        }catch(SQLException ex){
            
        }
        
        return socio;
    }
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
