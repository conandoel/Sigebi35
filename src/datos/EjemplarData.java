/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package datos;

import entidades.Ejemplar;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author conandoel
 */
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
    public void modificarEjemplar(){}
    public void eliminarEjemplar(){}
    
}
