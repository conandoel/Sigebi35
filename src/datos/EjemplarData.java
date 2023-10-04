package datos;

import entidades.Ejemplar;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class EjemplarData {
    private Connection con = null;

    public EjemplarData() {
        con = Conexion.getConexion();
    }
    
    public void agregarEjemplar(Ejemplar ejemplar){
        String sql="insert into ejemplar (isbn, estado) values(?,?)";
        try{
            PreparedStatement ps = con.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, ejemplar.getLibro().getIsbn());
            ps.setString(2, ejemplar.getEstado());
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Se agrego el ejemplar correctamente");
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }
    public void modificarEjemplar(Ejemplar ejemplar){
        String sql = "update materia set estado = '" + ejemplar.getEstado() +  " where idEjemplar = " + ejemplar.getCodigo();
        try{
            PreparedStatement ps = con.prepareStatement(sql);
            int resultado = ps.executeUpdate();
            if(resultado == 0){
                JOptionPane.showMessageDialog(null, "No se afectaron filas.");
            }else{
                JOptionPane.showMessageDialog(null, "Se afectaron " + resultado + " filas.");
            }
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Error al realizar la accion");
        }
    }
    public void eliminarEjemplar(Ejemplar ejemplar){
        String sql ="delete ejemplar where codigo = "+ejemplar.getCodigo();
        PrestamoData pd=new PrestamoData();
        if(pd.buscarPrestamoEjemplar(ejemplar.getCodigo())){
            try {
                PreparedStatement ps = con.prepareStatement(sql);
                ps.execute();
            } catch (SQLException ex) {
                Logger.getLogger(EjemplarData.class.getName()).log(Level.SEVERE, null, ex);
            }
        }else{
            JOptionPane.showMessageDialog(null, "Aun hay prestamos activos de este ejemplar");
        }
    }
    
}
