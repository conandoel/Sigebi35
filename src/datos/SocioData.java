package datos;

import entidades.Socio;

import java.sql.*;
import java.util.*;
import entidades.Socio;
import java.awt.image.BufferedImage;
import java.io.*;
import java.sql.Blob;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import javax.imageio.ImageIO;
import vistas.SocioTarjeta;

public class SocioData {
    private Connection con = null;
    private List <Socio> socios;
    private List <String> columnas;
    private int [] idSocios;
    private Socio socio;
    
    public SocioData() {
        con = Conexion.getConexion();
    }
    
    public void agregarLector(){}
    public void modificarSocio(){}
    
    
    //Método para eliminar un socio
    public Socio eliminarSocio(String criterio, String valor){
        //PROBLEMA DE CRITERIO SEA ESTADO CON VALOR 1 //<-- Comentario legacy, hasta que no sepa por qué lo voy a dejar
        //Se toma el valor del JComboBox que contiene los criterios de búsqueda y se adapta a su valor en BASE DE DATOS
        if(criterio.equals("Número de Socio") | criterio.equals("Estado")){
            criterio = "idSocio";
        }else{
            //Para "idSocio" el cambio es radical, pero para los demás como "Estado" sólo basta pasarlos a minúsculas
            criterio = criterio.toLowerCase();
        }
        //Se crea la consulta con la actualización de estado por ejemplo WHERE "domicilio" = "Brown 333"
        String sql = "UPDATE lector SET estado = 0 WHERE " + criterio + " = '" + valor + "';";
                               

        //Se ejecuta la consulta SQL
        try{
            PreparedStatement ps = con.prepareStatement(sql);
            int filas = ps.executeUpdate();
            //Se crea un ArrayList que se llena con los nombres de las columnas con el método utilitario
            columnas = new ArrayList<>();
            columnas = listarColumnas();
            
            if(filas > 0){
                //Si se eliminó algo se crea un socio
                Socio socio = new Socio();
                //Se itera por la columna buscando el match entre criterio y columna
                for(String columna : columnas){
                    if(criterio.equals(columna)){
                        //En el List de socios se guarda el socio eliminado con el criterio-valor establecido en la búsqueda
                        //Podría hacerse una sobrecarga de buscarHistorialSocios para que pueda devolver un socio
                        socios = buscarHistorialSocios(criterio, valor);
                    }
                }
            }
            //el primer socio (Siempre va a ser uno) se guarda en una instancia de socio
            socio = socios.get(0);
        }catch(SQLException ex){
            
        }
        //Se devuelve un objeto Socio (Aunque aún no sé para qué. Supongo que preveo)
        return socio;
    }
    
    public void buscarLectorPorDNI(){}
    
    /*public List<Socio> listarLector(int activo){/*Ingresa 0 para listar lectores inactivos
                                                          1 para listar lectores activos
                                                          cualquier otro numero para listarlos todos*/
    /*List<Socio> listaLectores = new ArrayList<> ();
    
    String sql = "select * from lector ";
    switch(activo){
        case(0): sql = sql + "where estado = " + 0;
        case(1): sql = sql + "where estado = " + 1;
        default:
    }
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){ //Faltaria modificacion: No se contempla la foto de perfil
                socio.setIdSocio(rs.getInt("idSocio"));
                socio.setApellido(rs.getString("apellido"));
                socio.setNombre(rs.getString("nombre"));
                socio.setDomicilio(rs.getString("domicilio"));
                socio.setMail(rs.getString("mail"));
                socio.setFechaDeAlta(rs.getDate("fechaDeAlta").toLocalDate());
                //Tengo fe que esto funciona
                socio.setFechaDeBaja(rs.getDate("fechaDeBaja").toLocalDate());
                //No tengo mucha fe en que este ^ va a funcionar
                socio.setEstado(rs.getBoolean("estado"));
                
                listaLectores.add(socio);
            }   
            
        } catch (SQLException ex) {

        }
    return listaLectores;
    }*/
    public int[] buscarSocios(){
        int dimension = obtenerCantidadSocios();
        idSocios = new int[dimension];
        String sql = "SELECT idSocio FROM lector;";
        
        try{
            Statement st = con.createStatement();
            
             ResultSet rs = st.executeQuery(sql);
            
            int i = 0;
            while(rs.next()){
                idSocios[i++] = rs.getInt("idSocio");
            }
            
        }catch(SQLException ex){
            
        }
        return idSocios;
    }
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
                socio.setFechaDeBaja(rs.getDate("fechaDeBaja")==null? LocalDate.now() : rs.getDate("fechaDeBaja").toLocalDate() );
                socio.setEstado(rs.getBoolean("estado"));
                socios.add(socio);
            }
        }catch(SQLException ex){
            
        }

        return socios;
    }
    
    //Método utilitario o función para obtener los nombres de las COLUMNAS de la TABLA
    public List listarColumnas(){
        //Consulta que devuelve el nombre de las COLUMNAS de la TABLA lector de la BASE DE DATOS biblioteca
        String sql = "SELECT COLUMN_NAME FROM INFORMATION_SCHEMA.COLUMNS WHERE TABLE_SCHEMA = 'biblioteca' AND TABLE_NAME = 'lector';";
        //Se crea un ArrayList (Parece ser que podría utilizarse el atributo pero hay que chequearlo) para guardar los nombres de las columnas en formato String
        List <String> columnas = new ArrayList<>();
        try{
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            //A cada iteración se agrega el nombre de la nueva COLUMNA al ArrayList
            while(rs.next()){       
                columnas.add(rs.getString("COLUMN_NAME"));
            }
        }catch(SQLException ex){
            
        }
        //Se devuelve el ArrayList con todas las columnas de la TABLA lector
        return columnas;
    }
    
    //Método utilitario para obtener la cantidad de socios
    public int obtenerCantidadSocios(){
        //Esta consulta devuelve la cantidad de REGISTROS (o FILAS) de la TABLA lector
        String sql = "SELECT COUNT(*) AS total FROM lector;";
        //Se inicializa la variable que guardará la cantidad de REGISTROS
        int cantidad = 0;
        try{
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            //Se obtiene la cantidad que devuelve la consulta de existir registros
            if(rs.next()){       
                cantidad = rs.getInt(1);
            }
        }catch(SQLException ex){
            // Manejar la excepción
        }
        //Devuelve la cantidad de REGISTROS (y por tanto SOCIOS). Si no hay devuelve 0
        return cantidad; 
    }
    
    //Método encargado de cargar las imágenes en la PC, en el archivo "imagenes"
    public void obtenerImagenesSocio(){
        //Consulta que  devuelve las imágenes y su path de la TABLA lector
        String sql = "SELECT fotoPerfil, fotoPerfilNombre FROM lector";
        
        try{
            //Se crea un objeto Statement con la consulta
            Statement st = con.createStatement();
            //Se ejecutar la consulta y se obtiene el resultado
            ResultSet rs = st.executeQuery(sql);
            //Si hay un resultado, se obtiene la imagen y el nombre
            while(rs.next()) {
                //Se obtiene el objeto BLOB de la columna fotoPerfil
                Blob fotoPerfil = rs.getBlob("fotoPerfil");
                //Se obtiene el nombre de la columna "fotoPerfilNombre"
                String fotoPerfilNombre = rs.getString("fotoPerfilNombre");
                //Se convierte el objeto BLOB en un arreglo de bytes
                byte[] data = fotoPerfil.getBytes(1, (int) fotoPerfil.length());
                //Se crea un objeto BufferedImage con el arreglo de bytes
                try{
                    BufferedImage img = ImageIO.read(new ByteArrayInputStream(data));
                    //Se escribe la imagen en un archivo con el mismo nombre
                    ImageIO.write(img, "jpg", new File(fotoPerfilNombre + ".jpg"));
                }catch(IOException ex){
                    
                }
                //Se cierran los recursos
                rs.close();
                st.close();
            }
        }catch(SQLException ex){
                    
        }
    }
    //Método que se utiliza para cargar la BASE DE DATOS con todas las imágnenes de perfil de los socios
    public void insertarImagenesSocio(){
        //Se guarda el valor del número de socio más bajo de la BASE DE DATOS (DEBERÍA HACERSE UNA QUERY)
        int idSocio = 5556;
        //Se guarda el valor de la cantidad de socios
        int cantidadSocios = obtenerCantidadSocios();
        
        try{
            //Se itera por todos los socios utilizando el valor que nos dio el método utilitario obtenerCantidadSocios
            for(int i = 0; i < cantidadSocios; i++){
                //Se crea un objeto File con la ruta de la imagen
                //AQUÍ NO SÉ POR QUÉ NO ADAPTÉ "obtenerImagenesSocio" PARA LOGRAR ESTO. HAY QUE REVEER
                File fotoPerfil = new File("./src/vistas/imagenes/foto_" + idSocio + ".jpg");
                //Se obtiene la longitud del archivo en bytes
                int fotoPerfilLength = (int) fotoPerfil.length();
                //Se crea un objeto FileInputStream con el archivo
                FileInputStream fis;
                fis = new FileInputStream(fotoPerfil);
 
                //Esta consulta inserta la imagen y el nombre según el idSocio
                String sql = "UPDATE lector SET fotoPerfil = ?, fotoPerfilNombre = ? WHERE idSocio = ?;";
                //Se crea un objeto PreparedStatement con la consulta
                PreparedStatement ps = con.prepareStatement(sql);
                //Se establece el primer parámetro con el flujo binario de la imagen y su longitud
                ps.setBinaryStream(1, fis, fotoPerfilLength);
                //Se establece el segundo parámetro con el nombre de la imagen
                ps.setString(2, "./src/vistas/imagenes/foto_" + idSocio);
                ps.setInt(3, idSocio);
                //Se ejecuta la consulta
                ps.executeUpdate();
                //Se cierran los recursos
                ps.close();
                fis.close(); 
                idSocio++;
            }
            con.close();
        }catch(SQLException | IOException ex){
            
        }
    }
}
