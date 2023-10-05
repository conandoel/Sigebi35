package datos;

import entidades.Ejemplar;
import entidades.Prestamo;
import entidades.Socio;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class PrestamoData {
    private Connection con = null;

    public PrestamoData() {
        con = Conexion.getConexion();
    }
    
    public void agregarPrestamo(Prestamo pres){
        try {
            String sql="insert into prestamo (fechaInicio, fechaFin, idEjemplar, idSocio, estado) values(?,?,?,?,?)";
            PreparedStatement ps=con.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            ps.setDate(1, Date.valueOf(pres.getFechaInicio()));
            ps.setDate(2, Date.valueOf(pres.getFechaFin()));
            ps.setInt(3, pres.getEjemplar().getCodigo());
            ps.setInt(4, pres.getLector().getIdSocio());
            ps.setBoolean(5, true);
            
            int exito = ps.executeUpdate();

            //Se chequea si exito es mayor que 0 lo cual significa que se realizó un INSERT
            if(exito > 0){
                JOptionPane.showMessageDialog(null, "Prestamo Realizado Exitosamente.");
            }else{
                JOptionPane.showMessageDialog(null, "Prestamo Rechazado");
            }
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(PrestamoData.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void eliminarPrestamos(int id){
        try {
            String sql="delete * form prestamo where idPrestamo = "+id;
            PreparedStatement ps=con.prepareStatement(sql);
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Se ha eliminado el prestamo");
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(PrestamoData.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void devolucionPrestamo(int id){
        try {
            String sql="update prestamo set fechaFin= ?, estado= ? where idPrestamo = ?";
            PreparedStatement ps=con.prepareStatement(sql);
            ps.setDate(1, Date.valueOf(LocalDate.now()));
            ps.setBoolean(2, false);
            ps.setInt(3, id);
            
            int exito=ps.executeUpdate();
            if(exito>0){
                JOptionPane.showMessageDialog(null, "Devolucion completa");
            }else{
                JOptionPane.showMessageDialog(null, "Error al procesar la devolucion");
            }
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(PrestamoData.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public boolean buscarPrestamoEjemplar(int codigo){
        boolean flag=true;
        try {
            String sql="select * from prestamo where idEjemplar = ? and estado = 1";
            
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, codigo);
            ResultSet resultado = ps.executeQuery();
            if(resultado.next()){
                flag = false;
            }
        } catch (SQLException ex) {
            Logger.getLogger(PrestamoData.class.getName()).log(Level.SEVERE, null, ex);
        }
            return flag;
    }
    
    public Prestamo buscarPrestamo(int codigo){
        Prestamo pres=new Prestamo();
        try{
            String sql="";
            PreparedStatement ps=con.prepareStatement(sql);
            
        }catch(SQLException ex){
        
        }
        return pres;
    }
    
    public List<Prestamo> listarPrestamos(){
        List<Prestamo> prestamos=new ArrayList<>();
        try {
            
            String sql = "SELECT * FROM prestamo ";
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Ejemplar ejemplar = new Ejemplar();
                Socio socio = new Socio();
                Prestamo prestamo=new Prestamo();
                ejemplar.setCodigo(rs.getInt(4));
                socio.setIdSocio(rs.getInt(5));
                prestamo.setIdPrestamo(rs.getInt(1));
                prestamo.setFechaInicio(rs.getDate(2).toLocalDate());
                prestamo.setFechaFin(rs.getDate(3).toLocalDate());
                prestamo.setEjemplar(ejemplar);
                prestamo.setLector(socio);
                prestamo.setEstado(rs.getBoolean(6));
                
                prestamos.add(prestamo);
            }
        } catch (SQLException ex) {
            Logger.getLogger(PrestamoData.class.getName()).log(Level.SEVERE, null, ex);
        }
        return prestamos;
    }
}
