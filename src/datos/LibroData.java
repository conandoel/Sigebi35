package datos;

import entidades.Libro;
import entidades.Autor;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class LibroData {
    private Connection con = null;
    private Libro libro = null;
    private Autor autor = null;
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
    
    public void modificarLibro(Libro libro1, Libro libro2){
        //Libro1 es el libro que se quiere modificar de la base de datos
        //Libro2 contiene los datos que se quieren modificar del libro 1
        /*En la vista donde se modificarian los libros, se implementa un boton "Modificar", que cuando se aprieta
        guarda en Libro1 los datos actuales del libro,
        y un boton "Aceptar cambios", que cuando se aprieta guarda los cambios
        que se quieran hacer sobre el libro1
        */
        String sql = "update libro set isbn = ?, titulo = '?', autor = ?, anio = ?, genero = '?'"
                + ", editorial = '?', estado = ?, cantEjemplares = ?"
                
                + "where isbn = ?, titulo = '?', autor = '?', anio =?, genero = '?', editorial = '?', estado = ? cantEjemplares = ?";
        
        try {
            
            PreparedStatement ps = con.prepareStatement(sql);
            
            ps.setInt(1, libro2.getIsbn());
            ps.setString(2, libro2.getTitulo());
            ps.setInt(3, libro2.getAutor().getIdAutor());
            ps.setInt(4, libro2.getAnio());
            ps.setString(5, libro2.getGenero());
            ps.setString(6, libro2.getEditorial());
            ps.setBoolean(7,libro2.isEstado());
            ps.setInt(8, libro2.getCantEjemplares());//Los datos por lo que se va a cambiar
            
            ps.setInt(9, libro.getIsbn());
            ps.setString(10, libro.getTitulo());
            ps.setInt(11, libro.getAutor().getIdAutor());
            ps.setInt(12, libro.getAnio());
            ps.setString(13, libro.getGenero());
            ps.setString(14, libro.getEditorial());
            ps.setBoolean(15,libro.isEstado());
            ps.setInt(16, libro.getCantEjemplares());//Los datos del libro que buscas cambiar
            
            int cambios = ps.executeUpdate();
            
            if(cambios == 0){
                JOptionPane.showMessageDialog(null, "No se encontraron libros para cambiar");
            }else{
                JOptionPane.showMessageDialog(null, "Se cambio el libro " + libro.getTitulo());
            }
            
            
            
            
            
            
        } catch (SQLException ex) {
            Logger.getLogger(LibroData.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public void eliminarLibro(int isbn){
        try {
            String sql = "UPDATE libro SET estado = 0 WHERE isbn = ? and cantEjemplares = 0";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, isbn);
            int fila = ps.executeUpdate();
            if (fila == 1) {
                JOptionPane.showMessageDialog(null, " Se eliminó el Libro.");
            }else{
                JOptionPane.showMessageDialog(null, "El libro aun posee ejemplares");
            }

            ps.close();

        } catch (SQLException e) {

            JOptionPane.showMessageDialog(null, " Error al acceder a la tabla Libro");
        }
    }
    
    public Libro buscarLibroPorISBN(int isbn){
        String sql = "select * from libro where isbn = '" + isbn +"'";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            String sql2 = "select * from autor where idAutor = '" + rs.getInt("autor") + "'";
            PreparedStatement ps2 = con.prepareStatement(sql2);
            ResultSet rs2 = ps2.executeQuery();
            
            autor.setIdAutor(rs2.getInt("idAutor"));
            autor.setNombre(rs2.getString("nombre"));
            autor.setApellido(rs2.getString("apellido"));
            autor.setGeneroFav(rs2.getString("generofav"));
            
            //autor.setIdAutor(rs.getInt("autor"));
            
            libro.setIsbn(rs.getInt("isbn"));
            libro.setTitulo(rs.getString("titulo"));
            libro.setAutor(autor);
            libro.setAnio(rs.getInt("anio"));
            libro.setGenero(rs.getString("genero"));
            libro.setEditorial(rs.getString("editorial"));
            libro.setEstado(rs.getBoolean("estado"));
            libro.setCantEjemplares(rs.getInt("cantEjemplares"));
        
        
        
        } catch (SQLException ex) {
            Logger.getLogger(LibroData.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        return libro;
    }
    
    public List<Libro> buscarLibroPorAutor(String nombre){
        List<Libro> listaLibro = new ArrayList<> ();
        
        String sql = "select * from libro inner join autor where autor.nombre = " + nombre + " AND libro.autor = autor.idAutor";
        //Busca los libros usando el nombre del autor como filtro, comparando el idAutor del autor y 'autor' del libro 
        
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){
                String sql2 = "select * from autor where nombre = '" + nombre + "' and idAutor = " + rs.getInt("autor");
                //Como puede haber distintos autores con el mismo nombre, se filtran los autores dependiendo de 'autor' del libro
                //que actualmente esta exponiendo 'rs'
                PreparedStatement ps2 = con.prepareStatement(sql2);
                ResultSet rs2 = ps2.executeQuery();
                
                autor.setIdAutor(rs2.getInt("idAutor"));
                autor.setNombre(nombre);
                autor.setApellido(rs2.getString("apellido"));
                autor.setGeneroFav(rs2.getString("generofav"));
                //Se crea un objeto Autor para asignarle a Libro ->
                
                libro.setIsbn(rs.getInt("isbn"));
                libro.setTitulo(rs.getString("titulo"));
                libro.setAutor(autor);//<-
                libro.setAnio(rs.getInt("anio"));
                libro.setGenero(rs.getString("genero"));
                libro.setEditorial(rs.getString("Editorial"));
                libro.setEstado(rs.getBoolean("estado"));
                libro.setCantEjemplares(rs.getInt("cantEjemplares"));
            
                listaLibro.add(libro);
            }
            
            
            
        } catch (SQLException ex) {
            Logger.getLogger(LibroData.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
        
        return listaLibro;
    }
    
    public Libro buscarLibroPorTitulo(String titulo){
        String sql = "select * from libro where titulo = '" + titulo + "'";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                String sql2 = "select * from autor where idAutor = " + rs.getInt("autor");
                PreparedStatement ps2 = con.prepareStatement(sql2);
                ResultSet rs2 = ps2.executeQuery();
                
                autor.setIdAutor(rs2.getInt("idAutor"));
                autor.setNombre(rs2.getString("nombre"));
                autor.setApellido(rs2.getString("apellido"));
                autor.setGeneroFav(rs2.getString("generofav"));
                
                libro.setIsbn(rs.getInt("isbn"));
                libro.setTitulo(rs.getString("titulo"));
                libro.setAutor(autor);
                libro.setAnio(rs.getInt("anio"));
                libro.setGenero(rs.getString("genero"));
                libro.setEditorial(rs.getString("Editorial"));
                libro.setEstado(rs.getBoolean("estado"));
                libro.setCantEjemplares(rs.getInt("cantEjemplares"));
            }
            
            
        } catch (SQLException ex) {
            Logger.getLogger(LibroData.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    return libro;
    }
    
    public List<Libro> listarLibro(){
        List<Libro> listaLibros = new ArrayList<> ();
        
        String sql = "select * from libro";
        try {
            
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while(rs.next()){
                
                String sql2 = "select * from autor where idAutor = '" + rs.getInt("autor") + "'";
                PreparedStatement ps2 = con.prepareStatement(sql2);
                ResultSet rs2 = ps2.executeQuery();
                
                autor.setIdAutor(rs2.getInt("idAutor"));
                autor.setNombre(rs2.getString("nombre"));
                autor.setApellido(rs2.getString("apellido"));
                autor.setGeneroFav(rs2.getString("generofav"));
                
                //autor.setIdAutor(rs.getInt("autor"));
                
                libro.setIsbn(rs.getInt("isbn"));
                libro.setTitulo(rs.getString("titulo"));
                libro.setAutor(autor);
                libro.setAnio(rs.getInt("anio"));
                libro.setGenero(rs.getString("genero"));
                libro.setEditorial(rs.getString("Editorial"));
                libro.setEstado(rs.getBoolean("estado"));
                libro.setCantEjemplares(rs.getInt("cantEjemplares"));
            
                listaLibros.add(libro);
            }    
        } catch (SQLException ex) {
            Logger.getLogger(LibroData.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listaLibros;
    }
    
    /*un ejemplo que hice para mi mismo, para comprencion
    
    Guardando solo el id del autor cuando se busca un libro
    isbn 13
    titulo Teoria de la ciencia
    idAutor 2
    genero Ciencia
    ...
    
    Generando un objeto Autor y asignandoselo al libro
    isbn 13
    titulo Teoria de la ciencia
    idAutor 2 => nombre Autor Stephen
                 apellido Autor Hawking
    Genero Ciencia
    ...
    
    se puede usar para:
    isbn 13
    titulo TDLC
    autor 2 => (sin guardar el autor) sql = select * from autor where idAutor = 2 -> prepareStatement -> rs ps.eQ -> rs.getString(nombre) -> rs.getString(apellido) 
          2 => (guardando el autor)libro.getAutor().getNombre() -> libro.getAutor().getApellido();
    genero ...
    anio ...
    
    se ahorraria lineas de codigo y conecciones a la base de datos en metodos que
    busquen/listen libros cuand se tenga que exponer el autor
    
    (testeo pendiente: como los metodos devuelven objetos y listas de tipo Libro,
    se necesita checkear si tambien pasa los objetos Autores asignados
    Si no los pasa, implementar metodos en las vistas donde se exponga el autor para
    que busque los autores por Id)
    
    yeh
    estoy seguro que hay forma mas facil de hacer esto mismo, pero se escapa de mis habilidades
    */
    
    
    
    
    
    
    
}
