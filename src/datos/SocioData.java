package datos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.ArrayList;
import entidades.Socio;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Blob;
import java.sql.Statement;
import java.time.format.DateTimeFormatter;
import javax.imageio.ImageIO;

public class SocioData {
    private Connection con = null;
    private List <Socio> socios;
    private List <String> columnas;
    private Socio socio;
    
    public SocioData() {
        con = Conexion.getConexion();
    }
    public void agregarLector(){}
    public void modificarLector(){}
    
    public Socio eliminarLector(String criterio, String valor){
        //PROBLEMA DE CRITERIO SEA ESTADO CON VALOR 1
        String sql = "UPDATE lector SET estado = 0 WHERE " + criterio + " = " + valor + ";";
        
        try{
            PreparedStatement ps = con.prepareStatement(sql);
            int filas = ps.executeUpdate();
            
            columnas = new ArrayList<>();
            columnas = listarColumnas();
            
            while(filas>0){       
                Socio socio = new Socio();
                if(criterio.equals("Número de Socio")){
                    criterio = "idSocio";
                }else{
                    criterio = criterio.toLowerCase();
                }
 
                for(String columna : columnas){
                    if(criterio.equals(columna)){
                        socios = buscarHistorialSocios(criterio, valor);
                    }
                }
            }
            socio = socios.get(0);
        }catch(SQLException ex){
            
        }
        
        return socio;
    }
    public void buscarLectorPorDNI(){}
    public void listarLector(){}
    
    
    
    
    public List buscarHistorialSocios(String criterio, String valor){
        String sql = "SELECT * FROM lector WHERE " + criterio + " = ?;";
        socios = new ArrayList<>();
        
        try{
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, valor);
            
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){
                socio = new Socio();
                socio.setIdSocio(rs.getInt("idSocio"));
                socio.setApellido(rs.getString("apellido"));
                socio.setNombre(rs.getString("nombre"));
                socio.setDomicilio(rs.getString("domicilio"));
                socio.setMail(rs.getString("mail"));
                socio.setFechaDeAlta(rs.getDate("fechaDeAlta").toLocalDate());
                //Esta parte hay que arreglarla
                socio.setFechaDeBaja(rs.getBoolean("estado")? rs.getDate("fechaDeAlta").toLocalDate() : rs.getDate("fechaDeBaja").toLocalDate() );
                socio.setEstado(rs.getBoolean("estado"));
                socios.add(socio);
            }
        }catch(SQLException ex){
            
        }

        return socios;
    }
    
    public List listarColumnas(){
        String sql = "SELECT COLUMN_NAME FROM INFORMATION_SCHEMA.COLUMNS WHERE TABLE_SCHEMA = 'biblioteca' AND TABLE_NAME = 'lector';";
        List <String> columnas = new ArrayList<>();
        try{
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){       
                columnas.add(rs.getString("COLUMN_NAME"));
            }
        }catch(SQLException ex){
            
        }
        
        return columnas;
    }
    
    public int obtenerCantidadSocios(){
       String sql = "SELECT COUNT(*) AS total FROM lector;";
        int cantidad = 0;
        try{
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            if(rs.next()){       
                cantidad = rs.getInt(1);
            }
        }catch(SQLException ex){
            // Manejar la excepción
        }
        
        return cantidad; 
    }
    
    public void obtenerImagenesSocio(){
        Connection conexion = Conexion.getConexion();
        
        String sql = "SELECT fotoPerfil, fotoPerfilNombre FROM lector";
        
        try{
            // Crear un objeto Statement con la consulta
            Statement st = conexion.createStatement();
            // Ejecutar la consulta y obtener el resultado
            ResultSet rs = st.executeQuery(sql);
            // Si hay un resultado, obtener la imagen y el nombre
            while(rs.next()) {
                // Obtener el objeto BLOB de la columna imagen
                Blob fotoPerfil = rs.getBlob("fotoPerfil");
                // Obtener el nombre de la columna nombre
                String fotoPerfilNombre = rs.getString("fotoPerfilNombre");
                // Convertir el objeto BLOB en un arreglo de bytes
                byte[] data = fotoPerfil.getBytes(1, (int) fotoPerfil.length());
                // Crear un objeto BufferedImage con el arreglo de bytes
                try{
                    BufferedImage img = ImageIO.read(new ByteArrayInputStream(data));
                    // Escribir la imagen en un archivo con el mismo nombre
                    ImageIO.write(img, "jpg", new File(fotoPerfilNombre + ".jpg"));
                }catch(IOException ex){
                    
                }
                // Cerrar los recursos
                rs.close();
                st.close();
            }
        }catch(SQLException ex){
                    
        }
        
    }
    
    public void insertarImagenesSocio(){
        int idSocio = 5556;
        Connection conexion = Conexion.getConexion();
        
        int cantidadSocios = obtenerCantidadSocios();
        
        try{
            for(int i = 0; i < cantidadSocios; i++){
                // Crear un objeto File con la ruta de la imagen
                File fotoPerfil = new File("./src/vistas/imagenes/foto_" + idSocio + ".jpg");
                // Obtener la longitud del archivo en bytes
                int fotoPerfilLength = (int) fotoPerfil.length();
                // Crear un objeto FileInputStream con el archivo
                FileInputStream fis;
                fis = new FileInputStream(fotoPerfil);
 
                // Crear una consulta SQL para insertar la imagen y el nombre
                String sql = "UPDATE lector SET fotoPerfil = ?, fotoPerfilNombre = ? WHERE idSocio = ?;";
                // Crear un objeto PreparedStatement con la consulta
                PreparedStatement ps = conexion.prepareStatement(sql);
                // Establecer el primer parámetro con el flujo binario de la imagen y su longitud
                ps.setBinaryStream(1, fis, fotoPerfilLength);
                // Establecer el segundo parámetro con el nombre de la imagen
                ps.setString(2, "./src/vistas/imagenes/foto_" + idSocio);
                ps.setInt(3, idSocio);
                // Ejecutar la consulta
                ps.executeUpdate();
                // Cerrar los recursos
                ps.close();
                fis.close(); 
                idSocio++;
            }
            conexion.close();
        }catch(SQLException | IOException ex){
            
        }
    }
}
