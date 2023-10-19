package datos;

import entidades.Libro;
import entidades.Autor;
import java.sql.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class LibroData {
    private Connection con = null;
    public Libro libro = new Libro();
    List<Libro> listaLibros = new ArrayList<> ();
    private Autor autor = null;
    
    public LibroData() {
        con = Conexion.getConexion();
    }
    
    public void guardarLibro(Libro libro){
        try {
            String sql="insert into libro (isbn, titulo, autor, anio, genero, editorial, estado) values(?,?,?,?,?,?,?)";
            PreparedStatement ps = con.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
            ps.setLong(1, libro.getIsbn());
            ps.setString(2, libro.getTitulo());
            ps.setString(3, libro.getAutor());
            ps.setInt(4, libro.getAnio());
            ps.setString(5, libro.getGenero());
            ps.setString(6, libro.getEditorial());
            ps.setBoolean(7, true);

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
    
    public void modificarLibro(long isbn, Libro libro2){
        //Libro2 contiene los cambios que se quieren hacer al libro de la base de datos
        /*Implementar un boton "Modificar" en la vista para modificar que, cuando se presione, guarda el ISBN actual
        del libro que se quiere modificar.
        Implementar un boton "Confirmar Cambio" que genera un libro con los cambios que se quieran hacer al libro
        de la base de datos.
        Este metodo recibe el objeto Libro que contiene los cambios y usa el Isbn guardado por "Modificar" para
        saber que libro modificar en la base de datos
        
        ...revisar la utilidad de un boton "Cancelar Cambio"
        */
        
        String sql = "update libro set isbn = ?, titulo = '?', autor = ?, anio = ?, genero = '?'"
                    + ", editorial = '?', estado = ?"
                
                    + "where isbn = " + isbn;
        
        try {
            
            PreparedStatement ps = con.prepareStatement(sql);
            
            ps.setLong(1, libro2.getIsbn());
            ps.setString(2, libro2.getTitulo());
            ps.setString(3, libro2.getAutor());
            ps.setInt(4, libro2.getAnio());
            ps.setString(5, libro2.getGenero());
            ps.setString(6, libro2.getEditorial());
            ps.setBoolean(7,libro2.isEstado());
            
            int cambios = ps.executeUpdate();
            
            if(cambios == 0){
                JOptionPane.showMessageDialog(null, "No se encontraron libros para cambiar");
            }else{
                JOptionPane.showMessageDialog(null, "Libro modificado exitosamente");
            }
            
  
        } catch (SQLException ex) {
            Logger.getLogger(LibroData.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public void eliminarLibro(long isbn){
        try {
            String sql = "UPDATE libro SET estado = 0 WHERE isbn = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setLong(1, isbn);
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
    
    public List<Libro>buscarLibroPorISBN(long isbn){
        String sql = "select * from libro where titulo = '" + isbn +"%'";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){
            
                libro.setIsbn(rs.getLong("isbn"));
                libro.setTitulo(rs.getString("titulo"));
                libro.setAutor(rs.getString("autor"));
                libro.setAnio(rs.getInt("anio"));
                libro.setGenero(rs.getString("genero"));
                libro.setEditorial(rs.getString("editorial"));
                libro.setEstado(rs.getBoolean("estado"));
                
                listaLibros.add(libro);
            }
        } catch (SQLException ex) {
            Logger.getLogger(LibroData.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        return listaLibros;
    }
    
    public List<Libro> buscarLibroPorAutor(String nombre){
        
        String sql = "select * from libro where autor like '%" + nombre + "%'";
        //Busca los libros usando el nombre del autor como filtro, comparando el idAutor del autor y 'autor' del libro 
        
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){
                
                libro.setIsbn(rs.getLong("isbn"));
                libro.setTitulo(rs.getString("titulo"));
                libro.setAutor(rs.getString("autor"));
                libro.setAnio(rs.getInt("anio"));
                libro.setGenero(rs.getString("genero"));
                libro.setEditorial(rs.getString("Editorial"));
                libro.setEstado(rs.getBoolean("estado"));
            
                listaLibros.add(libro);
            }
        } catch (SQLException ex) {
            Logger.getLogger(LibroData.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listaLibros;
    }
    
    public List<Libro> buscarLibroPorTituloGenero(String filtro, String busqueda ){
        String sql = "select * from libro where " + filtro + " like '%" + busqueda + "%'";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                
                libro.setIsbn(rs.getLong("isbn"));
                libro.setTitulo(rs.getString("titulo"));
                libro.setAutor(rs.getString("autor"));
                libro.setAnio(rs.getInt("anio"));
                libro.setGenero(rs.getString("genero"));
                libro.setEditorial(rs.getString("Editorial"));
                libro.setEstado(rs.getBoolean("estado"));

            }
            
            
        } catch (SQLException ex) {
            Logger.getLogger(LibroData.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    return listaLibros;
    }
    
    public List<Libro> listarLibro(/*para algo debera servir, qsy*/){
        
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
                
                libro.setIsbn(rs.getLong("isbn"));
                libro.setTitulo(rs.getString("titulo"));
                libro.setAutor(rs.getString("autor"));
                libro.setAnio(rs.getInt("anio"));
                libro.setGenero(rs.getString("genero"));
                libro.setEditorial(rs.getString("Editorial"));
                libro.setEstado(rs.getBoolean("estado"));

            
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
    
    public Autor getEscritor(String nombre){
        Autor autito = new Autor();
        String sql = "select * from autor where nombre = '" + nombre + "'";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            rs.last(); int i = rs.getRow(); rs.first();
            if (i < 0){
                autor.setNombre(rs.getString("nombre"));
                autor.setNombre(rs.getString("apellido"));
                autor.setIdAutor(rs.getInt("idAutor"));
                autor.setGeneroFav(rs.getString("generoFav"));
            }else{
                JOptionPane.showMessageDialog(null, "Hay mas de 1 autor con ese nombre");
            }
        } catch (SQLException ex) {
            Logger.getLogger(LibroData.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return autito;
    }
}
