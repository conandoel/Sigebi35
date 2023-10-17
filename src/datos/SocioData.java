package datos;

import java.sql.*;
import java.util.*;
import entidades.Socio;
import java.awt.image.BufferedImage;
import java.io.*;
import java.sql.Blob;
import java.sql.Statement;
import javax.imageio.ImageIO;
import javax.swing.JOptionPane;
import java.io.IOException;
import java.time.LocalDate;

public class SocioData {

    private Connection con = null;
    private List <Socio> socios;
    private List <String> columnas;
    private int[] idSocios;
    private Socio socio;

    public SocioData() {
        con = Conexion.getConexion();
    }

    public void agregarLector(Socio socio) {
        String sql="insert into lector (idSocio,apellido,nombre,domicilio,mail,fechaDeAlta,fechaDeBaja,fotoPerfilNombre,estado) values(?,?,?,?,?,?,?,?,?)";
        
        try{
            PreparedStatement ps= con.prepareStatement(sql);
            ps.setInt(1, socio.getIdSocio());
            ps.setString(2, socio.getApellido());
            ps.setString(3, socio.getNombre());
            ps.setString(4, socio.getDomicilio());
            ps.setString(5, socio.getMail());
            ps.setDate(6, java.sql.Date.valueOf(socio.getFechaDeAlta()));
            ps.setDate(7, java.sql.Date.valueOf(socio.getFechaDeBaja()));
            ps.setString(8, socio.getFotoPerfilNombre());
            ps.setBoolean(9, socio.isEstado());
            System.out.println("Pasa despues de cargar datos");
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Se agrego el socio correctamente");
            ps.close();
        }catch(SQLException ex){
            int codigoError = ex.getErrorCode();
            // Comparación del código de error con el valor 1062
            if (codigoError == 1062) {
                // Mensaje al usuario indicando que el lector ya existe
                JOptionPane.showMessageDialog(null, "El Id de socio que intenta insertar ya existe.");
            } else {
                // Mensaje genérico de error
                JOptionPane.showMessageDialog(null, ex.getMessage());
            }
        }
    }


    //Método para eliminar un socio
    public Socio eliminarSocio(String efecto, String soloMod, String criterio, String valor, String idSocio) {
        //Se toma el valor del JComboBox que contiene los criterios de búsqueda y se adapta a su valor en BASE DE DATOS
        List <Socio> sociosLocal = new ArrayList<>();
        Socio socioLocal = new Socio();
        String sql;
        if (efecto.equals("E")) {
            if (criterio.equals("Número de Socio") | criterio.equals("Estado")) {
                criterio = "idSocio";
            } else {
                //Para "idSocio" el cambio es radical, pero para los demás como "Estado" sólo basta pasarlos a minúsculas
                criterio = criterio.toLowerCase();
            }
            //Se crea la consulta con la actualización de estado por ejemplo WHERE "domicilio" = "Brown 333"
            sql = "UPDATE lector SET estado = 0 WHERE " + criterio + " = '" + valor + "';";
        } else {
            if (criterio.equals("fechaDeAlta") || criterio.equals("fechaDeBaja")) {
                //Se crea la consulta con la actualización de estado por ejemplo WHERE "domicilio" = "Brown 333"
                sql = "UPDATE lector SET " + criterio + " = '" + valor + "' WHERE " + criterio + " = '" + soloMod + "';";
                valor = soloMod;
                JOptionPane.showMessageDialog(null, valor);
            } else if (criterio.equalsIgnoreCase("Número de Socio") | criterio.equalsIgnoreCase("Estado")) {//Ver si es Número de Socio o Socio número
                criterio = "idSocio";
                int valorInt = Integer.parseInt(valor);
                int soloModInt = Integer.parseInt(soloMod);
                sql = "UPDATE lector SET estado = " + valorInt + " WHERE " + criterio + " = " + soloModInt + ";";
                valor = String.valueOf(soloModInt);
            } else {
                criterio = criterio.toLowerCase();
                //Se crea la consulta con la actualización de estado por ejemplo WHERE "domicilio" = "Brown 333"
                sql = "UPDATE lector SET " + criterio + " = '" + valor + "' WHERE " + criterio + " = '" + soloMod + "';";
            }
        }
        System.out.println(sql);
        List <String> columnas;
        //Se ejecuta la consulta SQL
        try {
            
            PreparedStatement ps = con.prepareStatement(sql);
            int filas = ps.executeUpdate();
            //Se crea un ArrayList que se llena con los nombres de las columnas con el método utilitario
            columnas = new ArrayList<>();
            columnas = listarColumnas();

            if (filas > 0) {
                //Si se eliminó algo se crea un socio
                
                //Se itera por la columna buscando el match entre criterio y columna
                for (String columna : columnas) {
                    if (criterio.equals(columna)) {
                        //En el List de socios se guarda el socio eliminado con el criterio-valor establecido en la búsqueda
                        //Podría hacerse una sobrecarga de buscarHistorialSocios para que pueda devolver un socio
                        sociosLocal = buscarHistorialSocios("idSocio", String.valueOf(idSocio));
                    }
                }
            }
            
            //el primer socio (Siempre va a ser uno) se guarda en una instancia de socio
            socioLocal = sociosLocal.get(0);
        } catch (SQLException ex) {

        }
        //Se devuelve un objeto Socio (Aunque aún no sé para qué. Supongo que preveo)
        return socioLocal;
    }

    public void eliminarSocio(File file, FileInputStream fis, String rutaMasNombreDeFoto) throws FileNotFoundException {
        String sql = "UPDATE lector SET fotoPerfil = ? WHERE fotoPerfilNombre = '?';";

        PreparedStatement ps = null; // declarar el PreparedStatement fuera del bloque try
        try {
            ps = con.prepareStatement(sql);

            // Usar el fis y la longitud del archivo para establecer el valor del primer parámetro de la consulta SQL
            ps.setBlob(1, fis, file.length());
            // Usar la variable rutaMasNombreDeFoto para establecer el valor del segundo parámetro de la consulta SQL
            ps.setString(2, rutaMasNombreDeFoto);
            ps.executeUpdate();

        } catch (SQLException ex) {
            // manejar la excepción
            JOptionPane.showMessageDialog(null, "Error al actualizar el Blob en la base de datos", "Error", JOptionPane.ERROR_MESSAGE);
            // o lanzar la excepción
            // throw ex;
        } finally {
            // Cerrar el PreparedStatement y el FileInputStream en el bloque finally
            try {
                if (ps != null) {
                    ps.close();
                }
                if (fis != null) {
                    try {
                        fis.close();
                    } catch (IOException ex) {

                    }
                }
            } catch (SQLException ex) {
                // manejar la excepción al cerrar
                JOptionPane.showMessageDialog(null, "Error al cerrar los recursos", "Error", JOptionPane.ERROR_MESSAGE);

            }
        }
    }

    public void buscarLectorPorDNI() {
    }

    public Socio obtenerNombreDeImagen(String idSocioString) {
        int idSocio = Integer.parseInt(idSocioString);
        String sql = "SELECT fotoPerfilNombre FROM lector WHERE idSocio = " + idSocio;
        Socio socioLocal = null;
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, idSocio);

            ResultSet rs = ps.executeQuery();
            socioLocal = new Socio();
            while (rs.next()) {

                socioLocal.setFotoPerfilNombre(rs.getString("fotoPerfilNombre"));
                socioLocal.setIdSocio(idSocio);
            }
        } catch (SQLException ex) {

        }
        return socioLocal;
    }

    public List<Socio> buscarSociosPorFecha(String criterioFecha, String fecha) {

        String sql = "SELECT * FROM lector WHERE ? = '" + fecha + "';";

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, criterioFecha);

            ResultSet rs = ps.executeQuery();

            Socio socioLocal = new Socio();
            while (rs.next()) {

                socioLocal.setIdSocio(rs.getInt("idSocio"));
                socioLocal.setApellido(rs.getString("apellido"));
                socioLocal.setNombre(rs.getString("nombre"));
                socioLocal.setDomicilio(rs.getString("domicilio"));
                socioLocal.setMail(rs.getString("mail"));
                socioLocal.setEstado(rs.getBoolean("estado"));

                if (criterioFecha.equalsIgnoreCase("fechaDeAlta")) {
                    socioLocal.setFechaDeAlta(rs.getDate(criterioFecha).toLocalDate());
                } else {
                    socioLocal.setFechaDeAlta(rs.getDate(criterioFecha).toLocalDate());
                }

                socios.add(socioLocal);
            }
        } catch (SQLException ex) {

        }

        return socios;
    }

    
    //OTRA VEZ ME VOLVIÓ A TIRAR EL PUTO ERROR
    public List <Socio> buscarHistorialSocios(String criterio, String valorStringInt) {
        //ESE -1 EN ALGÚN LADO ME TIRÓ ERROR
        int valorInt = -1;
        String valorString = "";
        String sql;

        try {
            valorInt = Integer.parseInt(valorStringInt);
            sql = "SELECT * FROM lector WHERE " + criterio + " = " + valorInt + ";";
            System.out.println(sql);
        } catch (NumberFormatException ex) {
            valorString = valorStringInt;
            sql = "SELECT * FROM lector WHERE " + criterio + " = ?;";

        }
        
        List <Socio> sociosLocal = new ArrayList<>();
        Socio socioLocal;
        try {

            PreparedStatement ps = con.prepareStatement(sql);
            if (valorInt >= 0) {
                ps.setInt(1, valorInt);
            } else {
                ps.setString(1, valorString);
                
            }
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                socioLocal = new Socio();
                socioLocal.setIdSocio(rs.getInt("idSocio"));
                socioLocal.setApellido(rs.getString("apellido"));
                socioLocal.setNombre(rs.getString("nombre"));
                socioLocal.setDomicilio(rs.getString("domicilio"));
                socioLocal.setMail(rs.getString("mail"));
                socioLocal.setFechaDeAlta(rs.getDate("fechaDeAlta").toLocalDate());
                //Esta parte hay que arreglarla
                //si el campo es null en la base de datos se muere
                if(rs.getDate("fechaDeBaja") == null){
                    LocalDate dia= LocalDate.now();
                socioLocal.setFechaDeBaja(dia);
                }else{socioLocal.setFechaDeBaja(rs.getDate("fechaDeBaja").toLocalDate());}
                socioLocal.setEstado(rs.getBoolean("estado"));
                sociosLocal.add(socioLocal);
                System.out.println("Número de elementos en sociosLocal: " + sociosLocal.size());
            }

        } catch (SQLException ex) {

        }
        return sociosLocal;
    }

    //Método utilitario o función para obtener los nombres de las COLUMNAS de la TABLA
    public List listarColumnas() {
        //Consulta que devuelve el nombre de las COLUMNAS de la TABLA lector de la BASE DE DATOS biblioteca
        String sql = "SELECT COLUMN_NAME FROM INFORMATION_SCHEMA.COLUMNS WHERE TABLE_SCHEMA = 'biblioteca' AND TABLE_NAME = 'lector';";
        //Se crea un ArrayList (Parece ser que podría utilizarse el atributo pero hay que chequearlo) para guardar los nombres de las columnas en formato String
        List<String> columnas = new ArrayList<>();
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            //A cada iteración se agrega el nombre de la nueva COLUMNA al ArrayList
            while (rs.next()) {
                columnas.add(rs.getString("COLUMN_NAME"));
            }
        } catch (SQLException ex) {

        }
        //Se devuelve el ArrayList con todas las columnas de la TABLA lector
        return columnas;
    }

    //Método utilitario para obtener la cantidad de socios
    public int obtenerCantidadSocios() {
        //Esta consulta devuelve la cantidad de REGISTROS (o FILAS) de la TABLA lector
        String sql = "SELECT COUNT(*) AS total FROM lector;";
        //Se inicializa la variable que guardará la cantidad de REGISTROS
        int cantidad = 0;
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            //Se obtiene la cantidad que devuelve la consulta de existir registros
            if (rs.next()) {
                cantidad = rs.getInt(1);
            }
        } catch (SQLException ex) {
            // Manejar la excepción
        }
        //Devuelve la cantidad de REGISTROS (y por tanto SOCIOS). Si no hay devuelve 0
        return cantidad;
    }

    //Método encargado de cargar las imágenes en la PC, en el archivo "imagenes"
    public void obtenerImagenesSocio() {
        //Consulta que  devuelve las imágenes y su path de la TABLA lector
        String sql = "SELECT fotoPerfil, fotoPerfilNombre FROM lector";

        try {
            //Se crea un objeto Statement con la consulta
            Statement st = con.createStatement();
            //Se ejecutar la consulta y se obtiene el resultado
            ResultSet rs = st.executeQuery(sql);
            //Si hay un resultado, se obtiene la imagen y el nombre
            while (rs.next()) {
                //Se obtiene el objeto BLOB de la columna fotoPerfil
                Blob fotoPerfil = rs.getBlob("fotoPerfil");
                //Se obtiene el nombre de la columna "fotoPerfilNombre"
                String fotoPerfilNombre = rs.getString("fotoPerfilNombre");
                //Se convierte el objeto BLOB en un arreglo de bytes
                byte[] data = fotoPerfil.getBytes(1, (int) fotoPerfil.length());
                //Se crea un objeto BufferedImage con el arreglo de bytes
                try {
                    BufferedImage img = ImageIO.read(new ByteArrayInputStream(data));
                    //Se escribe la imagen en un archivo con el mismo nombre
                    ImageIO.write(img, "jpg", new File(fotoPerfilNombre + ".jpg"));
                } catch (IOException ex) {

                }
                //Se cierran los recursos
                rs.close();
                st.close();
            }
        } catch (SQLException ex) {

        }
    }

    //Método que se utiliza para cargar la BASE DE DATOS con todas las imágnenes de perfil de los socios
    public void insertarImagenesSocio() {
        //Se guarda el valor del número de socio más bajo de la BASE DE DATOS (DEBERÍA HACERSE UNA QUERY)
        int idSocio = 5556;
        //Se guarda el valor de la cantidad de socios
        int cantidadSocios = obtenerCantidadSocios();

        try {
            //Se itera por todos los socios utilizando el valor que nos dio el método utilitario obtenerCantidadSocios
            for (int i = 0; i < cantidadSocios; i++) {
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
        } catch (SQLException | IOException ex) {

        }
    }

    public Socio eliminarSocio(String efecto, String soloMod, String criterio, String valor) {
        //Se toma el valor del JComboBox que contiene los criterios de búsqueda y se adapta a su valor en BASE DE DATOS
        List <Socio> sociosLocal = new ArrayList<>();
        Socio socioLocal = new Socio();
        String sql;
        if (efecto.equals("E")) {
            if (criterio.equals("Número de Socio") | criterio.equals("Estado")) {
                criterio = "idSocio";
            } else {
                //Para "idSocio" el cambio es radical, pero para los demás como "Estado" sólo basta pasarlos a minúsculas
                criterio = criterio.toLowerCase();
            }
            //Se crea la consulta con la actualización de estado por ejemplo WHERE "domicilio" = "Brown 333"
            sql = "UPDATE lector SET estado = 0 WHERE " + criterio + " = '" + valor + "';";
        } else {
            if (criterio.equals("fechaDeAlta") || criterio.equals("fechaDeBaja")) {
                //Se crea la consulta con la actualización de estado por ejemplo WHERE "domicilio" = "Brown 333"
                sql = "UPDATE lector SET " + criterio + " = '" + valor + "' WHERE " + criterio + " = '" + soloMod + "';";
                valor = soloMod;
                JOptionPane.showMessageDialog(null, valor);
            } else if (criterio.equalsIgnoreCase("Número de Socio") | criterio.equalsIgnoreCase("Estado")) {//Ver si es Número de Socio o Socio número
                criterio = "idSocio";
                int valorInt = Integer.parseInt(valor);
                int soloModInt = Integer.parseInt(soloMod);
                sql = "UPDATE lector SET estado = " + valorInt + " WHERE " + criterio + " = " + soloModInt + ";";
                valor = String.valueOf(soloModInt);
            } else {
                criterio = criterio.toLowerCase();
                //Se crea la consulta con la actualización de estado por ejemplo WHERE "domicilio" = "Brown 333"
                sql = "UPDATE lector SET " + criterio + " = '" + valor + "' WHERE " + criterio + " = '" + soloMod + "';";
            }
        }
        System.out.println(sql);
        List <String> columnas;
        //Se ejecuta la consulta SQL
        try {
            
            PreparedStatement ps = con.prepareStatement(sql);
            int filas = ps.executeUpdate();
            //Se crea un ArrayList que se llena con los nombres de las columnas con el método utilitario
            columnas = new ArrayList<>();
            columnas = listarColumnas();

            if (filas > 0) {
                //Si se eliminó algo se crea un socio
                
                //Se itera por la columna buscando el match entre criterio y columna
                for (String columna : columnas) {
                    if (criterio.equals(columna)) {
                        //En el List de socios se guarda el socio eliminado con el criterio-valor establecido en la búsqueda
                        //Podría hacerse una sobrecarga de buscarHistorialSocios para que pueda devolver un socio
                        sociosLocal = buscarHistorialSocios(criterio, valor);
                    }
                }
            }
            
            //el primer socio (Siempre va a ser uno) se guarda en una instancia de socio
            socioLocal = sociosLocal.get(0);
        } catch (SQLException ex) {

        }
        //Se devuelve un objeto Socio (Aunque aún no sé para qué. Supongo que preveo)
        return socioLocal;
    }
    

    
    
}

