package datos;

import java.sql.Connection;

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
