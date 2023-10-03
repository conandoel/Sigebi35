package datos;

import java.sql.Connection;

public class LibroData {
    private Connection con = null;
    public LibroData() {
        con = Conexion.getConexion();
    }
    
    public void guardarLibro(){}
    public void modificarLibro(){}
    public void eliminarLibro(){}
    public void buscarLibroPorISBN(){}
    public void buscarLibroPorAutor(){}
    public void buscarLibroPorTitulo(){}
    public void listarLibro(){}
}
