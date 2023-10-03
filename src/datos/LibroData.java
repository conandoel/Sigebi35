/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package datos;

import java.sql.Connection;

/**
 *
 * @author conandoel
 */
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
}
