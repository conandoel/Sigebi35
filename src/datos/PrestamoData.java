package datos;

import java.sql.Connection;

public class PrestamoData {
    private Connection con = null;

    public PrestamoData() {
        con = Conexion.getConexion();
    }
    
    public void agregarPrestamo(){}
    public void eliminarPrestamos(){}
}
