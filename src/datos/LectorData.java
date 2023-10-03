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
public class LectorData {
    private Connection con = null;

    public LectorData() {
        con = Conexion.getConexion();
    }
    public void agregarLector(){}
    public void modificarLector(){}
    public void eliminarLector(){}
    public void buscarLectorPorDNI(){}
    public void listarLector(){}
}
