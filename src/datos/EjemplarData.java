package datos;

import java.sql.Connection;

public class EjemplarData {
    private Connection con = null;

    public EjemplarData() {
        con = Conexion.getConexion();
    }
    
    public void agregarEjemplar(){}
    public void modificarEjemplar(){}
    public void eliminarEjemplar(){}
    
}
