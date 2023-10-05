package datos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PrestamoData {
    private Connection con = null;

    public PrestamoData() {
        con = Conexion.getConexion();
    }
    
    public void agregarPrestamo(){}
    public void eliminarPrestamos(){}
    
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
}
