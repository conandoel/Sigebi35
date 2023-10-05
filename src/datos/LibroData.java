package datos;

import entidades.Libro;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class LibroData {
    private Connection con = null;
    public LibroData() {
        con = Conexion.getConexion();
    }
    
    public void guardarLibro(Libro libro){
        try {
            String sql="insert into libro (isbn, titulo, autor, anio, genero, editorial, estado, cantEjemplares) values(?,?,?,?,?,?,?,?)";
            PreparedStatement ps = con.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, libro.getIsbn());
            ps.setString(2, libro.getTitulo());
            ps.setInt(3, libro.getAutor().getIdAutor());
            ps.setInt(4, libro.getAnio());
            ps.setString(5, libro.getGenero());
            ps.setString(6, libro.getEditorial());
            ps.setBoolean(7, true);
            ps.setInt(8, libro.getCantEjemplares());
            ps.executeUpdate();
            ps.close();
            JOptionPane.showMessageDialog(null, "Se agrego el Libro correctamente");
        } catch (SQLException ex) {
            int codigoError = ex.getErrorCode();
            // Comparación del código de error con el valor 1062
            if (codigoError == 1062) {
                // Mensaje al usuario indicando que el libro ya existe
                JOptionPane.showMessageDialog(null, "El Libro que intenta insertar ya existe.");
            } else {
                // Mensaje genérico de error
                JOptionPane.showMessageDialog(null, "Ha ocurrido un error al acceder a la base de datos.");
            }
        }
    }
    public void modificarLibro(){}
    public void eliminarLibro(){}
    public void buscarLibroPorISBN(){}
    public void buscarLibroPorAutor(){}
    public void buscarLibroPorTitulo(){}
    public void listarLibro(){}
}
