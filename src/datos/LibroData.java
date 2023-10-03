package datos;
import entidades.Libro;
import entidades.Autor;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class LibroData {
    private Connection con = null;
    private Libro lib = null;
    private Autor autor = null;
    public LibroData() {
        con = Conexion.getConexion();
    }
    
    public void guardarLibro(Libro libro){
        String sql = "select * from libro";
        String sql2 = "insert into libro (isbn, titulo, autor, anio, genero, editorial, estado, ejemplares)"
            + "values (?, ?, ?, ?, ?, ?, ?, ?)";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){//Recorre los libros existentes en la base de datos
                if(rs.getString("titulo").equalsIgnoreCase(libro.getTitulo())|| rs.getInt("isbn") == libro.getIsbn()){
                    JOptionPane.showMessageDialog(null, "El libro ya existe");
                    break;//Si ya existe un libro con el mismo titulo O el mismo ISBN, te informa y fuerza una salida del bucle
                }
                if(!rs.next()){//Si se recorrio todos los libros y no encontro uno igual, entonces lo inserta en la base de dato (SE PUEDE MEJORAR)
                    PreparedStatement ps2 = con.prepareStatement(sql2,Statement.RETURN_GENERATED_KEYS);
                    ps.setInt(1, libro.getIsbn());
                    ps.setString(2, libro.getTitulo());
                    //Falta poner el autor. Me quede sin tiempo
                    ps.setInt(4, libro.getAnio());
                    ps.setString(5, libro.getGenero());
                    ps.setString(6, libro.getEditorial());
                    ps.setBoolean(7, libro.isEstado());
                    ps.setInt(8, libro.getCantEjemplares());
                }
            }
            
            
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al conectar a la base de datos");
        }
    }
    
    
    public void modificarLibro(){}
    public void eliminarLibro(){}
    public void buscarLibroPorISBN(){}
    public void buscarLibroPorAutor(){}
    public void buscarLibroPorTitulo(){}
    
    public List<Libro> listarLibro(){
        List<Libro> listaLibros = new ArrayList<>();//Crea una lista de los libros de la base de datos
        String sql = "select * from libro";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){
                
                String sql2 = "select * from autor where nombre = '" + rs.getString("autor") + "'";
                    //Busca el autor en la base de dato, usando el nombre del autor encontrado en el libro
                PreparedStatement ps2 = con.prepareStatement(sql2);
                ResultSet rs2 = ps2.executeQuery();
                
                autor.setNombre(rs2.getString("nombre"));
                autor.setApellido(rs2.getString("apellido"));
                autor.setGeneroFav(rs2.getString("generofav"));
                //Se crea un objeto Autor con lo encontrado en la base de datos para asignarselo al libro
                
                lib.setIsbn(rs.getInt("isbn"));
                lib.setTitulo(rs.getString("titulo"));
                lib.setAutor(autor);
                lib.setAnio(rs.getInt("anio"));
                lib.setGenero(rs.getString("genero"));
                lib.setEditorial(rs.getString("editorial"));
                lib.setEstado(rs.getBoolean("estado"));
                lib.setCantEjemplares(rs.getInt("cantEjemplares"));
                
                listaLibros.add(lib);
                
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al conectar con la base de dato");
        }
        return listaLibros;
    }
}
