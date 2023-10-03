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
public class EjemplarData {
    private Connection con = null;

    public EjemplarData() {
        con = Conexion.getConexion();
    }
    
    public void agregarEjemplar(){}
    public void modificarEjemplar(){}
    public void eliminarEjemplar(){}
    
}
