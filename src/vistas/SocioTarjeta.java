package vistas;

import entidades.Socio;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import datos.SocioData;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.LinearGradientPaint;
import java.awt.MultipleGradientPaint.CycleMethod;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.Timer;
import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class SocioTarjeta extends javax.swing.JPanel {
    //Listas para utilizar en los métodos
    private List <Socio> socios;
    private List <String> columnas;
    private List <SocioTarjeta> tarjetas;
    
    private static SocioTarjeta socioTarjeta;
    
    private SocioData metodoDeSocio;
    //Cuadro de texto que emerge al modificar un campo de la TARJETA
    private JTextField jTFSocioMod;
    //JLabel temporal que va a guardar el JLabel con el nombre del campo
    private JLabel campoAModificar;
    //JLabel temporal qeu va a guardar el JLabel con el valor del campo
    private JLabel valorAModificar;
    
    private JComboBox <String> jCBEstado;
    private String numeroSocioAnterior;
    private Socio socio;
    private String placeholder;
    String[] estados = {"Socio Activo", "Desasociado"};
    
    /**
     * Creates new form SocioBuscarResultado
     */
    public SocioTarjeta() {
        initComponents();

        //Este es el TextField que se utiliza para MODIFICAR los DATOS en las TARJETAS
        jTFSocioMod = new JTextField();
        //Este es el ComboBox que se utiliza para MODIFICAR el ESTADO en las TARJETAS
        jCBEstado = new JComboBox<>(estados);
        
        //Esto es la ESCUCHA para cuando el usuario PRESIONA TECLAS en el TextField para MODIFICAR los DATOS en las TARJETAS
        jTFSocioMod.addKeyListener (new KeyListener () {
            //Override sobre keyReleased, o sea cuando SE SUELTA LA TECLA
            @Override
            public void keyReleased (KeyEvent evt) {
                //Llama al método jTFSocioModKeyReleased
                jTFSocioModKeyReleased (evt);
            }
            //Los otros métodos del KeyListener quedan vacíos para implementar según se necesite, o borrarlos luego
            @Override
            public void keyPressed (KeyEvent evt) {}
            @Override
            public void keyTyped (KeyEvent evt) {}
        });
        //Esto es la ESCUCHA de la TECLA ENTER en el TextField para MODIFICAR los DATOS en las TARJETAS
        jTFSocioMod.addActionListener (new ActionListener () {
            // Sobreescribe el método actionPerformed
            @Override
            public void actionPerformed (ActionEvent e) {
                //Llamar al método jTFSocioModActionPerformed
                jTFSocioModActionPerformed (e);
            }
        });
        
        //Se toma la instancia de esta TARJETA para PATRÓN DE DISEÑO Singleton
        socioTarjeta = this;
    }
    //Getter que devuelve "Desasociado" o "Socio Activo". Parte del Singleton
    public String getEstado(){
        return this.jLEstado.getText();
    }
    
    //Getter que devuelve el ÍCONO de MODIFICAR o ELIMINAR
    public JLabel getEfecto(){
        return this.jLEfecto;
    }
    public String getApellido(){
        return this.jLApellido.getText();
    }

    //Se crea el método getInstance para el PATRÓN DE DISEÑO Singleton
    public static SocioTarjeta getInstance() {
        // Si el atributo sbr es nulo, lo creamos con el constructor
        if (socioTarjeta == null) {
            socioTarjeta = new SocioTarjeta();
        }
        // Devolvemos el atributo sbr
        return socioTarjeta;
    }
    
    //Esto son los COLORES que utilizan las TARJETAS. Luego adecuaré los nombres
    private static final Color CELESTITO = new Color(226,135,67);
    private static final Color VERDECITO = new Color(234,182,118);
    private static final Color AZULCITO = new Color(135, 62, 35);
    //Estas son los dos Íconos que aparecen en las TARJETAS para MODIFICAR y ELIMINAR
    private final Image modificar = new ImageIcon(getClass().getResource("/vistas/imagenes/modificar.png")).getImage();
    private final Image eliminar = new ImageIcon(getClass().getResource("/vistas/imagenes/eliminar.png")).getImage();
    
    //Esto es un Override de paintComponent del JPanel SocioTarjeta para darle color
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        
        //Esto es un arreglo de COLORES ya establecidos anteriormente
        Color[] colors = {CELESTITO, VERDECITO, AZULCITO};
        //Esto es un arreglo de fracciones que indica cómo se distribuyen los colores
        float[] fractions = {0f, 0.2f, 1f};
        //Se crea el DEGRADADO LINEAL dándole indicaciones de en dónde comienza horizontal y verticalmente, cuánto ocuparán los colores con las fracciones, y el tipo de rellenado
        LinearGradientPaint gp = new LinearGradientPaint(0, 0, getHeight(), 0, fractions, colors, CycleMethod.NO_CYCLE);
        //Se aplica el degradado al panel
        g2d.setPaint(gp);
        //Se rellena el panel con el degradado
        g2d.fillRect(0, 0, getWidth(), getHeight());

    }
    public void temporizar(JComponent componente){
        
        Timer temporizador = new Timer(1000, new ActionListener(){
            private int parpadeos = 0;
            
            @Override
            public void actionPerformed(ActionEvent e){
                
                if(parpadeos < 4){
                    if(componente.getBackground() == null || componente.getBackground().getAlpha() == 0){
                        componente.setOpaque(false);
                        componente.setBackground(Color.GREEN);
                    }else{
                        componente.setOpaque(false);
                        componente.setBackground(null);
                        
                        parpadeos++;
                    }
                }else{
                    componente.setOpaque(true);
                    componente.setBackground(null);
                    componente.repaint();
                    ((Timer) e.getSource()).stop();
                }
                //Border borde = new MatteBorder(0, 0, 1, 0, Color.BLUE);
                //componente.setBorder(borde);
              
            }
        });
        temporizador.setRepeats(false);
        componente.setOpaque(true);
        componente.setBackground(null);
        temporizador.start();
    }   

    //Método que devuelve un LISTADO de OBJETOS tipo SocioTarjeta (TARJETAS). Pide criterio (Si es por Nombre, por Estado, etc), pide valor ("Juan", "Activo", etc), y EFECTO (NADA, MODIFICAR y ELIMINAR)
    public List <SocioTarjeta> listarSocio(String criterio, String valor, String EFECTO){
        //Llama al método actualizarSeccion y pasa como argumento el EFECTO utilizando el PATRÓN DE DISEÑO Singleton
        SocioBuscarView.getInstance().actualizarSeccion(EFECTO);
        //Se crean ArrayList utilizando los argumentos de clase. Son tipo Socio, String, y SocioTarjeta
        socios = new ArrayList<>();
        columnas = new ArrayList<>();
        tarjetas = new ArrayList<>();
        
        //Se crea un OBJETO socioData el cual MANIPULA las consultas con la BASE DE DATOS
        metodoDeSocio = new SocioData();
        //Se llena la LISTA columnas con los nombres de las columnas de la tabla "lector" de la BASE DE DATOS utilizando el método de SocioData listarColumnas (idSocio, nombre, fechaDeAlta, etc)
        columnas = metodoDeSocio.listarColumnas();
        
        //Se le da formato a la fecha de la manera 12 | 01 | 1995, pero al modificar la fecha en la TARJETA se puede poner 12/01/95 o 12-01-1995, etc
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd | MM | yyyy");
        //CANDIDATA A STATIC - Si el criterio de BÚSQUEDA es "Número de Socio" (como esté en el ComboBox de la vista SocioBuscarView, se cambia a idSocio para poder comparar con las columnas
        if(criterio.equals("Número de Socio")){
            criterio = "idSocio";
        }else{
            //Si no es "Número de Socio" el criterio, entonces se pasa a minúsculas. Por ejemplo "Estado" pasará a ser "estado" para poder ser comparado con el nombre de la columna en la BASE DE DATOS
            criterio = criterio.toLowerCase();
        }
        
        //Se itera por la LISTA de nombres de columnas de la TABLA lector y compara el valor de criterio con alguna de las columnas de lector 
        for(String columna : columnas){
            //Al encontrar coincidencia se llama al método buscarHistorialSocios de SocioData, el cual devuelve a todos los SOCIOS ya sean activos o no y lo guarda en la LISTA socios
            if(criterio.equals(columna)){
                socios = metodoDeSocio.buscarHistorialSocios(criterio, valor);
            }
        }
        
        //Se itera por la LISTA recién rellenada con los SOCIOS HISTÓRICOS
        for(Socio socio : socios){   
            //Se declara la variable tarjeta dentro del bucle para que cree una nueva TARJETA a cada iteración
            SocioTarjeta tarjeta = new SocioTarjeta();
            //Se guarda el idSocio en la variable NroX, por ejemplo "5560" utilizando el getter del objeto socio de tipo Socio
            int NroX = socio.getIdSocio();
            
            //Se rellenan los JLabel de las tarjetas con Número de Socio, Apellido, Nombre, etc
            tarjeta.jLNumeroDeSocio.setText(Integer.toString(socio.getIdSocio()));
            tarjeta.jLApellido.setText(socio.getApellido());
            tarjeta.jLNombre.setText(socio.getNombre());
            tarjeta.jLDomicilio.setText(socio.getDomicilio());
            tarjeta.jLEmail.setText(socio.getMail());
            tarjeta.jLFechaDeAlta.setText(socio.getFechaDeAlta().format(formato));
            //Para rellenar la fecha de baja del socio, se comprueba si está activo o desasociado. Fecha color verde para activos y rojo para los otros
            if(socio.isEstado()){
                tarjeta.jLFechaDeBaja.setForeground(Color.green);
            }else{
                tarjeta.jLFechaDeBaja.setForeground(Color.red);
            }
            //Y aquí finalmente se rellena la fecha en el JLabel correspondiente
            tarjeta.jLFechaDeBaja.setText(socio.getFechaDeBaja().format(formato));
            
            //Se le asigna un tamaño al JLabel que contiene los ÍCONOS de MODIFICAR y ELIMINAR según sea el caso
            tarjeta.jLEfecto.setSize(20, 20);
            
            
            try {
                //Se lee una IMAGEN (foto perfil) desde un archivo en la computadora. Los nombres de las fotos son por ejemplo "foto_5560.jpg" por tanto NroX crea la ruta dinámicamente
                File file = new File("./src/vistas/imagenes/foto_" + NroX + ".jpg");
                //Se  lee una imagen desde un archivo y se almacena en una variable de tipo BufferedImage
                BufferedImage fotoPerfil = ImageIO.read(file);
                
                //Se borra el texto POR DEFECTO "Imagen" del JLabel y se establece su tamaño contenedor
                tarjeta.jLFoto.setText("");
                tarjeta.jLFoto.setSize(71, 81);
                //Se dimensiona la IMAGEN para que tenga el mismo largo y ancho del JLabel
                Image dFotoPerfil = fotoPerfil.getScaledInstance(tarjeta.jLFoto.getWidth(), tarjeta.jLFoto.getHeight(), Image.SCALE_SMOOTH);
                //Se pone la imagen en el JLabel usando setIcon()
                tarjeta.jLFoto.setIcon(new ImageIcon(dFotoPerfil));
                //Se cambia el color de la fuente del JLabel que contiene los ÍCONOS de ELIMINAR y MODIFICAR para que parezcan invisibles, pues tienen el idSocio, por ejemplo "5560"
                tarjeta.jLEfecto.setForeground(AZULCITO);
                
            } catch (IOException e) {

            }
            //Se rellena el estado comprobando con el getter de estado del objeto socio de tipo Socio. Si es true, el JLabel se settea en "Socio Activo" y si no, en "Desasociado"
            tarjeta.jLEstado.setText(socio.isEstado()? "Socio Activo" : "Desasociado");
            
            //Según el EFECTO que fue pasado como argumento al llamar a este método se realizan acciones en consecuencia
            switch (EFECTO) {
                //Si EFECTO es MODIFICAR, un JLabel de la tarjeta toma el valor "M" para futuras manipulaciones. El JLabel de fuente "invisible" toma el valor de número de socio
                case "MODIFICAR" ->  {
                    tarjeta.jLABM.setText("M");
                    tarjeta.jLEfecto.setText(Integer.toString(NroX));
                    //Se establece el tamaño de la imagen el cual va a ser el mismo que asignamos anteriormente al JLabel correspondiente en este mismo método
                    Image dModificar = modificar.getScaledInstance(tarjeta.jLEfecto.getWidth(), tarjeta.jLEfecto.getHeight(), Image.SCALE_SMOOTH);
                    //Se crea un ÍCONO con la imagen redimensionada de MODIFICAR
                    ImageIcon iconModificar = new ImageIcon(dModificar);
                    //Se asigna el ÍCONO al JLabel correspondiente
                    tarjeta.jLEfecto.setIcon(iconModificar);
                }
                //Si EFECTO es ELIMINAR, un JLabel de la tarjeta toma el valor "E" para futuras manipulaciones. El JLabel de fuente "invisible" toma el valor de número de socio
                case "ELIMINAR" ->  {
                    tarjeta.jLABM.setText("E");
                    tarjeta.jLEfecto.setText(Integer.toString(NroX));
                    //Se establece el tamaño de la imagen el cual va a ser el mismo que asignamos anteriormente al JLabel correspondiente en este mismo método
                    Image dEliminar = eliminar.getScaledInstance(tarjeta.jLEfecto.getWidth(), tarjeta.jLEfecto.getHeight(), Image.SCALE_SMOOTH);
                    //Se crea un ÍCONO con la imagen redimensionada de ELIMINAR
                    ImageIcon iconEliminar = new ImageIcon(dEliminar);
                    //Se asigna el ÍCONO al JLabel correspondiente
                    tarjeta.jLEfecto.setIcon(iconEliminar);
                    if(tarjeta.jLEfecto.isVisible()){
                        tarjeta.jLEfecto.setVisible(true);
                    }else{
                        tarjeta.jLEfecto.setVisible(false);
                    }
                }
                default ->  {
                    //Si EFECTO tiene un valor diferente (Se utiliza "NADA" pero debería ser "BUSCAR") el JLabel toma valor "B" y se elimina el número de socio (No había necesidad)
                    tarjeta.jLABM.setText("B");
                    tarjeta.jLEfecto.setText("");
                    //Se invisibiliza el JLabel adecuado para no mostrar ÍCONOS
                    tarjeta.jLEfecto.setVisible(false);
                }
            }
            //La tarjeta ya rellenada con los datos se agrega a la LISTA tarjetas
            tarjetas.add(tarjeta);
            //Nrox aumenta en 1, por tanto si al momento su valor era 5560 pasará a ser 5561, con lo cual asignará los datos de las tarjetas
            //NOTA: SE CREAN LAS TARJETAS DE TODOS LOS SOCIOS DE LA BASE DE DATOS. CREO QUE ESTE ENFOQUE ES DEFICIENTE POR LA POSIBLE ENORME CANTIDAD DE SOCIOS POSIBLES EN EL MUNDO REAL
            NroX++;
        }
        //Finalmente el método devuelve la LISTA con todas las TARJETAS rellenadas
        return tarjetas;
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLNumSocio = new javax.swing.JLabel();
        jLFoto = new javax.swing.JLabel();
        jLApe = new javax.swing.JLabel();
        jLNom = new javax.swing.JLabel();
        jLDom = new javax.swing.JLabel();
        jLEst = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLFecAlta = new javax.swing.JLabel();
        jLFecBaja = new javax.swing.JLabel();
        jLEm = new javax.swing.JLabel();
        jLEmail = new javax.swing.JLabel();
        jLDomicilio = new javax.swing.JLabel();
        jLNombre = new javax.swing.JLabel();
        jLApellido = new javax.swing.JLabel();
        jLFechaDeAlta = new javax.swing.JLabel();
        jLFechaDeBaja = new javax.swing.JLabel();
        jLEstado = new javax.swing.JLabel();
        jLNumeroDeSocio = new javax.swing.JLabel();
        jLABM = new javax.swing.JLabel();
        jLEfecto = new javax.swing.JLabel();

        jLNumSocio.setForeground(new java.awt.Color(102, 102, 102));
        jLNumSocio.setText("Socio número:");
        jLNumSocio.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLNumSocioMouseClicked(evt);
            }
        });

        jLFoto.setText("Imagen");
        jLFoto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLFotoMouseClicked(evt);
            }
        });

        jLApe.setForeground(new java.awt.Color(102, 102, 102));
        jLApe.setText("Apellido:");
        jLApe.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLApeMouseClicked(evt);
            }
        });

        jLNom.setForeground(new java.awt.Color(102, 102, 102));
        jLNom.setText("Nombre:");
        jLNom.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLNomMouseClicked(evt);
            }
        });

        jLDom.setForeground(new java.awt.Color(102, 102, 102));
        jLDom.setText("Domicilio:");
        jLDom.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLDomMouseClicked(evt);
            }
        });

        jLEst.setForeground(new java.awt.Color(102, 102, 102));
        jLEst.setText("Estado:");
        jLEst.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLEstMouseClicked(evt);
            }
        });

        jLFecAlta.setForeground(new java.awt.Color(102, 102, 102));
        jLFecAlta.setText("Fecha de Alta:");
        jLFecAlta.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLFecAltaMouseClicked(evt);
            }
        });

        jLFecBaja.setForeground(new java.awt.Color(102, 102, 102));
        jLFecBaja.setText("Fecha de Baja:");
        jLFecBaja.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLFecBajaMouseClicked(evt);
            }
        });

        jLEm.setForeground(new java.awt.Color(102, 102, 102));
        jLEm.setText("E-Mail:");
        jLEm.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLEmMouseClicked(evt);
            }
        });

        jLEmail.setText("ivansdmonte@hotmail.com");

        jLDomicilio.setText("Rawson 693");

        jLNombre.setText("Iván Sergio");

        jLApellido.setText("Di Monte");

        jLFechaDeAlta.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLFechaDeAlta.setText("12 | 01 | 1984");

        jLFechaDeBaja.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLFechaDeBaja.setText("12 | 01 | 1989");

        jLEstado.setText("Socio Activo");

        jLNumeroDeSocio.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLNumeroDeSocio.setText("5556");

        jLEfecto.setText("MODIFICAR");
        jLEfecto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLEfectoMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(jLFoto, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLEst)
                                    .addComponent(jLFecBaja)
                                    .addComponent(jLFecAlta)))
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLNumSocio)))
                        .addGap(16, 16, 16)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLNom)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLNumeroDeSocio, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLFechaDeAlta, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLApe)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLApellido, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLDom)
                                    .addComponent(jLEm))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLDomicilio, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLFechaDeBaja, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLEfecto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGap(0, 17, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jSeparator1)
                            .addComponent(jLABM, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(18, Short.MAX_VALUE)
                .addComponent(jLABM)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLNumSocio)
                    .addComponent(jLNumeroDeSocio))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLFoto, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLApe)
                            .addComponent(jLApellido))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLNom)
                            .addComponent(jLNombre))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLDom)
                            .addComponent(jLDomicilio))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLEm)
                            .addComponent(jLEmail))))
                .addGap(7, 7, 7)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLFecAlta)
                    .addComponent(jLFechaDeAlta))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLFecBaja)
                            .addComponent(jLFechaDeBaja))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLEst)
                            .addComponent(jLEstado)))
                    .addComponent(jLEfecto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
    }// </editor-fold>//GEN-END:initComponents
    
    //Método que se ejecuta al clickear en el JLabel que contiene los ÍCONOS de MODIFICAR o ELIMINAR según sea el caso
    private void jLEfectoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLEfectoMouseClicked
        //Por medio del PATRÓN DE DISEÑO Singleton se toman valor y criterio que se guardaron al utilizar el ComboBox y el TextField de la vista de búsqueda, por ej "Nombre" y "Juan"
        String valor = SocioBuscarView.getInstance().getValor();
        String criterio = SocioBuscarView.getInstance().getCriterio(); 
        //Se crea una INSTANCIA de SocioData para poder comunicarse con la BASE DE DATOS
        metodoDeSocio = new SocioData();
        
        //Se obtiene el idSocio desde el texto "invisible" del JLabel que contienen los ÍCONOS de ELIMINAR o MODIFICAR
        String idSocio = this.jLEfecto.getText();
        String valorBME = this.jLABM.getText();
        //Antes que el JLabel que contiene el valor "B", "M", o "E" pierda su texto, se compara para realizar acciones adecuadas
        if(valorBME.equals("M")){
            //El JLabel que tiene valor "B", "M", o "E" pasa a tener el texto especificado debajo
            this.jLABM.setText("CLICKEE SOBRE EL CAMPO PARA EDITAR EL VALOR DESEADO");
            
            temporizar(this.jLNumSocio);

            
        }else{
            if(valorBME.equals("E")){
                //Se muestra un cuadro de diálogo preguntando si se quiere borrar el socio actual
                int respuesta = JOptionPane.showConfirmDialog(this, "Está seguro que desea dar de baja al socio Nº " + idSocio + "?", TOOL_TIP_TEXT_KEY, WIDTH);
                //Si se responde OK se hace invisible el ÍCONO ELIMINAR, se elimina el lector de la BASE DE DATOS y se RECARGAN LAS TARJETAS para actualizar los cambios
                if(respuesta==0){
                    
                    this.jLEfecto.setVisible(false);
                    //Si el criterio es "Estado" se enviará como valor el idSocio y se adaptará "Estado" porque sino borrará toda los socios
                    if(criterio.equals("Estado")){
                        socio = metodoDeSocio.eliminarSocio(valorBME, "", criterio, idSocio);
                        SocioBuscarView.getInstance().afectarSocio("ELIMINAR");
                    //Si el criterio no es "Estado" entonces se manda criterio y valor elegidos por el usuario
                    }else{
                        socio = metodoDeSocio.eliminarSocio(valorBME, "", criterio, valor);
                        SocioBuscarView.getInstance().afectarSocio("ELIMINAR");
                    }
                }
            }else{
                
            }
        }
        //jLEstado.setText(socio.isEstado()? "Socio Activo" : "Desasociado"); // NO SÉ QUÉ HACE ESTO AQUÍ. REVISAR. ESTABA COMENTADO.
    }//GEN-LAST:event_jLEfectoMouseClicked
    //Manejador que escucha cuándo se clickea sobre el JLabel de campos de la TARJETA
    private void jLNumSocioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLNumSocioMouseClicked
        //Cuando se presiona el click sobre el JLabel del campo Socio número en la TARJETA se llama al método indicado.
        this.campoAModificar = this.jLNumSocio;
        this.valorAModificar = this.jLNumeroDeSocio;
        this.placeholder = this.valorAModificar.getText();
        preEditarCamposSocio(this.campoAModificar);
    }//GEN-LAST:event_jLNumSocioMouseClicked
    //Manejador que escucha cuándo se clickea sobre el JLabel de campos de la TARJETA
    private void jLFotoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLFotoMouseClicked
        //Cuando se presiona el click sobre el JLabel del cuadro que tiene la foto de perfil en la TARJETA se llama al método indicado.
        campoAModificar = this.jLFoto;
        //valorAModificar = this.jLFoto;
        valorAModificar = new JLabel();
        preEditarCamposSocio(this.campoAModificar); //CREO QUE AÚN NO TIENE VALOR. PASO HARDCODE POR ESO MISO ---> EN CONSTRUCCIÓN!!!!!!!!!!!!!!!!!!!!!!
    }//GEN-LAST:event_jLFotoMouseClicked
    //Manejador que escucha cuándo se clickea sobre el JLabel de campos de la TARJETA
    private void jLApeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLApeMouseClicked
        //Cuando se presiona el click sobre el JLabel del campo Apellido en la TARJETA se llama al método indicado.
        this.campoAModificar = this.jLApe;
        this.valorAModificar = this.jLApellido;
        preEditarCamposSocio(this.campoAModificar);
    }//GEN-LAST:event_jLApeMouseClicked
    //Manejador que escucha cuándo se clickea sobre el JLabel de campos de la TARJETA
    private void jLFecBajaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLFecBajaMouseClicked
        //Cuando se presiona el click sobre el JLabel del campo Fecha de Baja en la TARJETA se llama al método indicado.
        this.campoAModificar = this.jLFecBaja;
        this.valorAModificar = this.jLFechaDeBaja;
        preEditarCamposSocio(this.campoAModificar);
    }//GEN-LAST:event_jLFecBajaMouseClicked
    //Manejador que escucha cuándo se clickea sobre el JLabel de campos de la TARJETA
    private void jLNomMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLNomMouseClicked
        //Cuando se presiona el click sobre el JLabel del campo Nombre en la TARJETA se llama al método indicado.
        this.campoAModificar = this.jLNom;
        this.valorAModificar = this.jLNombre;
        preEditarCamposSocio(this.campoAModificar);
    }//GEN-LAST:event_jLNomMouseClicked
    //Manejador que escucha cuándo se clickea sobre el JLabel de campos de la TARJETA
    private void jLDomMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLDomMouseClicked
        //Cuando se presiona el click sobre el JLabel del campo Domicilio en la TARJETA se llama al método indicado.
        this.campoAModificar = this.jLDom;
        this.valorAModificar = this.jLDomicilio;
        preEditarCamposSocio(this.campoAModificar);
    }//GEN-LAST:event_jLDomMouseClicked
    //Manejador que escucha cuándo se clickea sobre el JLabel de campos de la TARJETA
    private void jLEstMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLEstMouseClicked
        //Cuando se presiona el click sobre el JLabel del campo Estado en la TARJETA se llama al método indicado.
        this.campoAModificar = this.jLEst;
        this.valorAModificar = this.jLEstado;
        preEditarCamposSocio(this.campoAModificar);
    }//GEN-LAST:event_jLEstMouseClicked
    //Manejador que escucha cuándo se clickea sobre el JLabel de campos de la TARJETA
    private void jLFecAltaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLFecAltaMouseClicked
        //Cuando se presiona el click sobre el JLabel del campo Fecha de Alta en la TARJETA se llama al método indicado.
        this.campoAModificar = this.jLFecAlta;
        this.valorAModificar = this.jLFechaDeAlta;
        preEditarCamposSocio(this.campoAModificar);
    }//GEN-LAST:event_jLFecAltaMouseClicked
    //Manejador que escucha cuándo se clickea sobre el JLabel de campos de la TARJETA
    private void jLEmMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLEmMouseClicked
        //Cuando se presiona el click sobre el JLabel del campo E-mail en la TARJETA se llama al método indicado.
        this.campoAModificar = this.jLEm;
        this.valorAModificar = this.jLEmail;
        preEditarCamposSocio(this.campoAModificar);
    }//GEN-LAST:event_jLEmMouseClicked
    
    //Manejador de eventos para cuando se suelta una tecla en el JLabel jTFSocioMod
    public void jTFSocioModKeyReleased(java.awt.event.KeyEvent evt) {                                         
        //Al largarse la tecla se llama al método indicado (Esto está en construcción)
        this.modificarTextField(evt, this.campoAModificar, this.valorAModificar);
    }
    //Manejador del evento ENTER sobre el JTextField que surje en el modo MODIFICAR --- EN CONSTRUCCIÓN!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! NO SE VA A UTILIZAR CREOOOO
    public void jTFSocioModActionPerformed(java.awt.event.ActionEvent evt) {
        //Se pone dentro de un try para manejar la excepción de que pongan letras en lugar de números
        /*int forzarNullPointerException;
        try{
            if(this.jTFSocioMod.getText().length() == 4){
                forzarNullPointerException = Integer.valueOf(jTFSocioMod.getText());
                this.jLNumeroDeSocio.setText(Integer.toString(forzarNullPointerException));
                this.jTFSocioMod.setVisible(false);
            }else if(this.jTFSocioMod.getText().length() == 0){
                this.jLNumeroDeSocio.setText(placeholder);
                this.jTFSocioMod.setVisible(false);
            }else{
                this.jLABM.setText("Debe ser un número entero de 4 cifras");
            }
        }catch(NumberFormatException ex){
            JOptionPane.showMessageDialog(this, "Debe ingresar un número de cuatro cifras");
        }*/
    }   
    
    public void jTFSocioModMouseClicked(java.awt.event.MouseEvent evt) {                                  
        // TODO add your handling code here:
    }
    
    private void preEditarCamposSocio(JLabel jLabel){
        if(this.jLABM.getText().equals("CLICKEE SOBRE EL CAMPO PARA EDITAR EL VALOR DESEADO")){
            String criterio = jLabel.getText();
            editarCamposSocio(criterio);
        }
    }
    

    private void editarCamposSocio(String criterio){
        
        switch(criterio){
            case "Socio número:":
                modificar(this.jLNumeroDeSocio, this.jLNumeroDeSocio.getText(), 100, 38, 50, 24, Font.BOLD, 14);
                break;
            case "Imagen":
                break;
            case "Apellido:":
                modificar(this.jLApellido, this.jLApellido.getText(), 160, 61, 100, 24, Font.PLAIN, 12);
                break;
            case "Nombre:":
                modificar(this.jLNombre, this.jLNombre.getText(), 160, 84, 100, 24, Font.PLAIN, 12);
                break;
            case "Domicilio:":
                modificar(this.jLDomicilio, this.jLDomicilio.getText(), 160, 106, 100, 24, Font.PLAIN, 12);
                break;
            case "E-Mail:":
                modificar(this.jLEmail, this.jLEmail.getText(), 160, 128, 220, 24, Font.PLAIN, 12);
                break;
            case "Fecha de Alta:":
                modificar(this.jLFechaDeAlta, this.jLFechaDeAlta.getText(), 100, 151, 86, 24, Font.BOLD, 12);
                break;
            case "Fecha de Baja:":
                modificar(this.jLFechaDeBaja, this.jLFechaDeBaja.getText(), 100, 173, 86, 24, Font.BOLD, 12);
                break;
            case "Estado:":
                modificar(this.jLEst, this.jLEstado.getText(), 100, 195, 150, 24, Font.PLAIN, 12);
                break;
        }
    }
    public void modificar(JLabel jLabel, String placeh, int x, int y, int width, int height, int grosorFuente, int tamFuente){
        
        if(jLabel.getText().equals("Estado:")){
            this.jCBEstado.setBounds(x, y, width, height);
            this.jCBEstado.setVisible(true);
            this.jCBEstado.setFont(new Font("Segoe UI", grosorFuente, tamFuente));
      
            this.add(jCBEstado);
            this.jCBEstado.requestFocus(true);
            jLabel.setForeground(Color.green);
            placeh = jLabel.getText();

            this.repaint();
        }else{
            this.jTFSocioMod.setBounds(x, y, width, height);
            this.jTFSocioMod.setVisible(true);
            this.jTFSocioMod.setFont(new Font("Segoe UI", grosorFuente, tamFuente));
            this.add(jTFSocioMod);
            this.jTFSocioMod.requestFocus(true);
            jLabel.setForeground(Color.green);
            placeh = jLabel.getText();

            this.repaint();
        }
        
    }
    
    boolean controlarENTER = true;
    //EN CONSTRUCCIÓN !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
    public void modificarTextField(KeyEvent e, JLabel campoMod, JLabel valorMod){
        //Por comodidad y legibilidad se guarda en una variable al JTextFiel que sirve para MODIFICAR las TARJETAS
        JTextField valoresModificados = jTFSocioMod;
        JLabel labelInformativo = this.jLABM;
        //Se guardan en dos variables tanto los valores que se van ingresando cada vez que se ejecuta este método como la cantidad de caracteres que tiene
        String caracteresIngresados = this.jTFSocioMod.getText();
        int cantidadDeCaracteres = this.jTFSocioMod.getText().length();
        //Se guardan en dos variables tanto el texto del campo (Por ejemplo "Apellido:") como el texto de los valores (Por ejemplo "Domínguez")
        String campo = campoMod.getText();
        String valorDelCampo = valorMod.getText();
        //Se guarda el código de la tecla presionada y se asigna una constante para el código del ENTER
        int tecla = e.getKeyCode();
        final int ENTER = 10;
        
        //JOptionPane.showMessageDialog(null, "campoMod: " + campoMod.getText() + "\n" + "valorMod: " + valorMod.getText() + "\n" + "jLEfecto:" + this.jLEfecto.getText());
        valoresModificados.setVisible(true);
        //Si se presionó la tecla ENTER en el JTextField que sirve para MODIFICAR
        if(tecla == ENTER && controlarENTER){
            controlarENTER = true;
            //Si el campo que se está afectando es "Socio número:" (A esto hay que manejarlo de manera más elegante. Quizá haciendo referencia al arreglo del ComboBox
            switch (campo) {
                case "Socio número:":
                    //Se pone dentro de un try para manejar la excepción de que pongan letras en lugar de números y para ello creamos una variable entera (Puede mejorarse el nombre)
                    int forzarNullPointerException;
                    valorDelCampo = caracteresIngresados;
                    labelInformativo.setText("El Número de socio ha sido modificado correctamente");
                    try{
                //Si la cantidad de caracteres es igual a 4 (ESTO ES SÓLO PARA EL NÚMEO DE SOCIO)
                switch (cantidadDeCaracteres) {
                    case 4:
                        //Se fuerza la excepción pasando a entero el número ingresado como cadena
                        forzarNullPointerException = Integer.parseInt(valorDelCampo);
                        //Si no hay NumberFormatException entonces se establece en el JLabel a MODIFICAR el valor String del número de socio y luego se quita de pantalla el JTextField
                        valorMod.setText(Integer.toString(forzarNullPointerException));
                        valoresModificados.setVisible(false);
                        //Si se ha apretado ENTER y dentro del JTextField no hay nada, entonces se establece el valor previo y luego se quita de pantalla el JTextField
                        break;
                    case 0:
                        valorMod.setText(placeholder);
                        valoresModificados.setVisible(false);
                        break;
                    default:
                        //Si se presiona ENTER y no es ni 0 ni 4 la cantidad de caracteres en el JTextField, entonces se informa en un JLabel la situación
                        labelInformativo.setText("Debe ser un número entero de 4 cifras");
                        break;
                }
                    }catch(NumberFormatException ex){
                        //Se maneja la excepción utilizando un JLabel
                        labelInformativo.setText("Se han ingresado caracteres no válidos");
                    }   break;
            //Si la tecla presionada NO es ENTER
                case "Apellido:":
                    if(caracteresIngresados.matches(".*\\d.*")){
                        labelInformativo.setText("El Apellido no puede incluír números");
                    }else{
                        valorMod.setText(caracteresIngresados);
                        valoresModificados.setVisible(false);
                        valorMod.setVisible(true);
                        labelInformativo.setText("El Apellido ha sido modificado correctamente");
                        metodoDeSocio.eliminarSocio("M", valorDelCampo, campo.replaceAll(":", ""), valorMod.getText());
                    }
                    break;
                case "Nombre:":
                    if(caracteresIngresados.matches(".*\\d.*")){
                        labelInformativo.setText("El Nombre no puede incluír números");
                    }else{
                        valorMod.setText(caracteresIngresados);
                        valoresModificados.setVisible(false);
                        valorMod.setVisible(true);
                        labelInformativo.setText("El Nombre ha sido modificado correctamente");
                        metodoDeSocio.eliminarSocio("M", valorDelCampo, campo.replaceAll(":", ""), valorMod.getText());
                    }
                    break;
                case "Domicilio:":
                    if(!caracteresIngresados.matches(".*\\s\\D*\\d+\\s*$")){
                        labelInformativo.setText("El Domicilio debe incluír un número");
                    }else{
                        valorMod.setText(caracteresIngresados);
                        valoresModificados.setVisible(false);
                        valorMod.setVisible(true);
                        labelInformativo.setText("El Domicilio ha sido modificado correctamente");
                        metodoDeSocio.eliminarSocio("M", valorDelCampo, campo.replaceAll(":", ""), valorMod.getText());
                    }
                    break;
                case "E-Mail:":
                    if(!caracteresIngresados.matches("^[\\w\\.-]+@[\\w\\.-]+\\.\\w+$")){
                        labelInformativo.setText("El E-Mail está mal especificada");
                    }else{
                        valorMod.setText(caracteresIngresados);
                        valoresModificados.setVisible(false);
                        valorMod.setVisible(true);
                        labelInformativo.setText("El E-Mail ha sido modificado correctamente");
                        metodoDeSocio.eliminarSocio("M", valorDelCampo, campo.replaceAll("[:-]", "").substring(1), valorMod.getText());
                    }
                    break;
                case "Fecha de Alta:":
                    {
                        placeholder = valorMod.getText();
                        String diaBaja = this.jLFechaDeBaja.getText().replaceAll(" \\| ", "").substring(0, 2);
                        String mesBaja = this.jLFechaDeBaja.getText().replaceAll(" \\| ", "").substring(2, 4);
                        String anyoBaja = this.jLFechaDeBaja.getText().replaceAll(" \\| ", "").substring(4, 8);
                        
                        String fechaBaja = anyoBaja + mesBaja + diaBaja;
                        int fechaDeBAJA = Integer.parseInt(fechaBaja);
                        
                        LocalDate fechaActualLD = LocalDate.now();
                        DateTimeFormatter formato = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                        String fechaActualString = fechaActualLD.format(formato);
                        int fechaActual = Integer.parseInt(fechaActualString.replaceAll("-", ""));

                        String fechaAdecuada = "^(0[1-9]|[12]\\d|3[01])[-/](0[1-9]|1[012])[-/](19|20)\\d{2}$";
                        if(!caracteresIngresados.matches(fechaAdecuada)){
                            if(cantidadDeCaracteres == 0){
                                valorMod.setText(placeholder);
                                valorMod.setVisible(true);
                                valoresModificados.setVisible(false);
                            }else{
                                labelInformativo.setText("La Fecha de Alta está mal especificada");
                            }
                        }else{
                            
                            String diaAltaSM = valorDelCampo.replaceAll(" \\| ", "").substring(0, 2);
                            String mesAltaSM = valorDelCampo.replaceAll(" \\| ", "").substring(2, 4);
                            String anyoAltaSM = valorDelCampo.replaceAll(" \\| ", "").substring(4, 8);
                            String soloMod = anyoAltaSM + "-" + mesAltaSM + "-" + diaAltaSM;
                           
                            String diaAlta = caracteresIngresados.replaceAll("[-/]", "").substring(0, 2);
                            String mesAlta = caracteresIngresados.replaceAll("[-/]", "").substring(2, 4);
                            String anyoAlta = caracteresIngresados.replaceAll("[-/]", "").substring(4, 8);
                            String fechaAlta = anyoAlta + mesAlta + diaAlta;
                            int fechaDeALTA = Integer.parseInt(fechaAlta);
                            JOptionPane.showMessageDialog(null, "fechaDeALTA: " + fechaDeALTA);
                            if(fechaActual >= fechaDeALTA){
                                String fechaDB = anyoAlta + "-" + mesAlta + "-" + diaAlta;
                                JOptionPane.showMessageDialog(null, fechaActual > fechaDeALTA);
                                boolean febrero = Integer.parseInt(caracteresIngresados.substring(0, 2)) == 2 ? true : false;
                                int anyoIngresado = Integer.parseInt(caracteresIngresados.substring(6, 10));
                            
                                if(febrero){
                                    int diaFebrero = Integer.parseInt(caracteresIngresados.substring(3, 5));

                                    if(diaFebrero < 29){
                                        //Si la baja es menor a la fecha de alta entonces se toma como reinscripción
                                        if(fechaDeBAJA < fechaDeALTA){
                                            int respuesta = JOptionPane.showConfirmDialog(this, "Se tomará como reinscripción. De acuerdo?");
                                            if(respuesta == 0){
                                                metodoDeSocio.eliminarSocio("M", soloMod, "fechaDeAlta", fechaDB);
                                                caracteresIngresados =  caracteresIngresados.replaceAll("[-/]", " | ");
                                                this.jLFechaDeBaja.setText(caracteresIngresados.substring(0, 10) + (anyoIngresado + 5));
                                                
                                                valorMod.setText(caracteresIngresados);
                                                valoresModificados.setVisible(false);
                                                valorMod.setVisible(true);
                                                labelInformativo.setText("La Fecha de Alta ha sido modificado correctamente");
                                                
                                            }else{
                                                labelInformativo.setText("La Fecha de Alta debe ser menor a la Fecha de Baja");
                                            }
                                        }   
                                    }else{
                                        if((anyoIngresado % 4 == 0 && anyoIngresado % 100 != 0) || (anyoIngresado % 400 == 0)){
                                            if(fechaDeBAJA < fechaDeALTA){
                                                int respuesta = JOptionPane.showConfirmDialog(this, "Se tomará como reinscripción. De acuerdo?");
                                                if(respuesta == 0){
                                                    metodoDeSocio.eliminarSocio("M", soloMod, "fechaDeAlta", fechaDB);
                                                    caracteresIngresados =  caracteresIngresados.replaceAll("[-/]", " | ");
                                                    this.jLFechaDeBaja.setText(caracteresIngresados.substring(0, 10) + (anyoIngresado + 5));

                                                    valorMod.setText(caracteresIngresados);
                                                    valoresModificados.setVisible(false);
                                                    valorMod.setVisible(true);
                                                    labelInformativo.setText("La Fecha de Alta ha sido modificado correctamente");
                                                }else{
                                                    labelInformativo.setText("La Fecha de Alta debe ser menor a la Fecha de Baja");
                                                }
                                            }else{
                                                valorMod.setText(caracteresIngresados);
                                                valorMod.setVisible(true);
                                            }
                                        }
                                    }
                                }else{
                                    if(fechaDeBAJA < fechaDeALTA){
                                        int respuesta = JOptionPane.showConfirmDialog(this, "Se tomará como reinscripción. De acuerdo?");
                                        if(respuesta == 0){
                                            metodoDeSocio.eliminarSocio("M", soloMod, "fechaDeAlta", fechaDB);
                                            caracteresIngresados =  caracteresIngresados.replaceAll("[-/]", " | ");
                                            this.jLFechaDeBaja.setText(caracteresIngresados.substring(0, 10) + (anyoIngresado + 5));
 
                                            valorMod.setText(caracteresIngresados);
                                            valoresModificados.setVisible(false);
                                            valorMod.setVisible(true);
                                            labelInformativo.setText("La Fecha de Alta ha sido modificado correctamente");
                                        }else{
                                            labelInformativo.setText("La Fecha de Alta debe ser menor a la Fecha de Baja");
                                        }
                                    }else{
                                        metodoDeSocio.eliminarSocio("M", soloMod, "fechaDeAlta", fechaDB);
                                        caracteresIngresados = caracteresIngresados.replaceAll("[-/]", " | ");
                                        valorMod.setText(caracteresIngresados);
                                        valoresModificados.setVisible(false);
                                        valorMod.setVisible(true);
                                        labelInformativo.setText("La Fecha de Alta ha sido modificado correctamente");
                                    }
                                }
                        }else{
                            labelInformativo.setText("La Fecha de Alta no puede ser mayor a la Fecha Actual");
                        }break;
                    }
                }
                case "Fecha de Baja:":
                    {
                        String diaAlta = this.jLFechaDeAlta.getText().replaceAll(" \\| ", "").substring(0, 2);
                        String mesAlta = this.jLFechaDeAlta.getText().replaceAll(" \\| ", "").substring(2, 4);
                        String anyoAlta = this.jLFechaDeAlta.getText().replaceAll(" \\| ", "").substring(4, 8);
                        String fechaAlta = anyoAlta + mesAlta + diaAlta;
                        int fechaDeALTA= Integer.parseInt(fechaAlta);
                        //LocalDate fechaActual = LocalDate.now();
                        String fechaAdecuada = "^(0[1-9]|[12]\\d|3[01])[-/](0[1-9]|1[012])[-/](19|20)\\d{2}$";
                        
                        if(!caracteresIngresados.matches(fechaAdecuada)){
                            
                            
                            if(cantidadDeCaracteres == 0){
                                valorMod.setText(valorDelCampo);
                                valorMod.setVisible(true);
                                valoresModificados.setVisible(false);
                            }else{
                                labelInformativo.setText("La Fecha de Baja está mal especificada");
                            }
                        }else{
                            String diaBaja = caracteresIngresados.replaceAll("[-/]", "").substring(0, 2);
                            String mesBaja = caracteresIngresados.replaceAll("[-/]", "").substring(2, 4);
                            String anyoBaja = caracteresIngresados.replaceAll("[-/]", "").substring(4, 8);
                            String fechaBaja= anyoBaja + mesBaja + diaBaja;
                            int fechaDeBAJA = Integer.parseInt(fechaBaja);
                            
                            LocalDate fechaActualLD = LocalDate.now();
                            DateTimeFormatter formato = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                            String fechaActualString = fechaActualLD.format(formato);
                            int fechaActual = Integer.parseInt(fechaActualString.replaceAll("-", ""));
                            
                            if(fechaActual >= fechaDeBAJA && fechaDeBAJA <= fechaDeALTA){
                            boolean febrero = Integer.parseInt(caracteresIngresados.substring(0, 2)) == 2 ? true : false;
                            int anyoDeAlta = Integer.parseInt(this.jLFechaDeAlta.getText().substring(10, 14));
                            int anyoIngresado = Integer.parseInt(caracteresIngresados.substring(6, 10));
                            
                            if(febrero){
                                int diaFebrero = Integer.parseInt(caracteresIngresados.substring(3, 5));
                                
                                if(diaFebrero < 29){
                                    //Si la baja es menor a la fecha de alta entonces se toma como reinscripción
                                    if(fechaDeBAJA < fechaDeALTA){
                                        int respuesta = JOptionPane.showConfirmDialog(this, "Se tomará como reinscripción. De acuerdo?");
                                        if(respuesta == 0){
                                            caracteresIngresados = caracteresIngresados.replaceAll("[-/]", " | ");
                                            valoresModificados.setVisible(false);
                                            valorMod.setText(caracteresIngresados.substring(0, 10) + (anyoDeAlta + 5));
                                            valorMod.setVisible(true);
                                            labelInformativo.setText("La Fecha de Baja ha sido modificado correctamente");
                                        }else{
                                            labelInformativo.setText("La Fecha de Alta debe ser menor a la Fecha de Baja");
                                        }
                                    }
                                    
                                }else{
                                    if((anyoIngresado % 4 == 0 && anyoIngresado % 100 != 0) || (anyoIngresado % 400 == 0)){
                                        if(fechaDeBAJA < fechaDeALTA){
                                            int respuesta = JOptionPane.showConfirmDialog(this, "Se tomará como reinscripción. De acuerdo?");
                                            if(respuesta == 0){
                                                caracteresIngresados = caracteresIngresados.replaceAll("[-/]", " | ");
                                                valoresModificados.setVisible(false);
                                                valorMod.setText(caracteresIngresados.substring(0, 10) + (anyoDeAlta + 5));
                                                valorMod.setVisible(true);
                                                labelInformativo.setText("La Fecha de Baja ha sido modificado correctamente");
                                            }else{
                                                labelInformativo.setText("La Fecha de Alta debe ser menor a la Fecha de Baja");
                                            }
                                        }else{
                                            valorMod.setText(caracteresIngresados);
                                            valorMod.setVisible(true);
                                        }
                                    }
                                }
                                
                            }else{
                                if(fechaDeBAJA < fechaDeALTA){
                                    int respuesta = JOptionPane.showConfirmDialog(this, "Se tomará como reinscripción. De acuerdo?");
                                    if(respuesta == 0){
                                        caracteresIngresados = caracteresIngresados.replaceAll("[-/]", " | ");
                                        valoresModificados.setVisible(false);
                                        valorMod.setText(caracteresIngresados.substring(0, 10) + (anyoDeAlta + 5));
                                        valorMod.setVisible(true);
                                        labelInformativo.setText("La Fecha de Baja ha sido modificado correctamente");
                                    }else{
                                        labelInformativo.setText("La Fecha de Alta debe ser menor a la Fecha de Baja");
                                    }
                                }else{
                                    caracteresIngresados = caracteresIngresados.replaceAll("[-/]", " | ");
                                    valorMod.setText(caracteresIngresados);
                                    valoresModificados.setVisible(false);
                                    valorMod.setVisible(true);
                                    labelInformativo.setText("La Fecha de Baja ha sido modificado correctamente");
                                }
                            }
                            
                            
                        }else{
                                caracteresIngresados = caracteresIngresados.replaceAll("[-/]", " | ");
                                    valorMod.setText(caracteresIngresados);
                                    valoresModificados.setVisible(false);
                                    valorMod.setForeground(Color.RED);
                                    valorMod.setVisible(true);
                                    labelInformativo.setText("La Fecha de Baja ha sido modificado correctamente");
                            }
                        break;
                    }
                    }
                case "Estado:":
                    
                    break;
                default:
                    break;
            }
        }else{
            controlarENTER = true;
            valoresModificados.setVisible(true);
            //Si el campo es "Socio número:"
            switch (campo) {
                case "Socio número:":
                    //Si la cantidad de caracteres llega a 4 (Esto aplica para "Socio número") un JLabel informa que se presione ENTER para pedir confirmación de cambios
                    if(cantidadDeCaracteres == 4){
                        //Sólo chequea e informa el texto de abajo. El manejador de eventos del JTextField va a ser el encargado de pedir confirmación de UPDATE
                        labelInformativo.setText("Presione ENTER para realizar la MODIFICACIÓN");
                    }else{
                        //Esto probablemente sea para manejar comportamientos
                        labelInformativo.setText("M");
                    }   //Este switch se encarga por medio de unas substring y espaciado, de hacer que el número de socio anterior se borre y complete a medida que manipulamos el JTextField para MODIFICAR
                    switch(cantidadDeCaracteres){
                        case 0:
                            valorMod.setText(placeholder.substring(0, 4));
                            this.repaint();
                            break;
                        case 1:
                            valorMod.setText("  " + placeholder.substring(1, 4));
                            this.repaint();
                            break;
                        case 2:
                            valorMod.setText("    " + placeholder.substring(2, 4));
                            this.repaint();
                            break;
                        case 3:
                            valorMod.setText("      " + placeholder.substring(3, 4));
                            this.repaint();
                            break;
                        case 4:
                            valorMod.setText(" " );
                            this.repaint();
                            break;
                            //En este case se cerciora que la cantidad de caracteres no sea mayor a 4 forzando un borrado del quinto caracter y enviando un molesto aviso de JOptionPane
                        case 5:
                            valoresModificados.setText(caracteresIngresados.substring(0, 4));
                            JOptionPane.showMessageDialog(this, "No se admite un número mayor a: CONSEGUIR NÚMERO DE SOCIO MAYOR + 1"); //Aquí hay que chequear con la BASE DE DATOS cuál es el último idSocio
                            controlarENTER = false;
                            this.repaint();
                            break;
                    }   break;
                case "Apellido:":
                    labelInformativo.setText("Modificando el Apellido");
                    valorMod.setVisible(false);
                    break;
                case "Nombre:":
                    labelInformativo.setText("Modificando el Nombre");
                    valorMod.setVisible(false);
                    break;
                case "Domicilio:":
                    labelInformativo.setText("Modificando el Domicilio");
                    valorMod.setVisible(false);
                    break;
                case "E-Mail:":
                    labelInformativo.setText("El E-Mail debe tener el formato ejemploDirección@dominio.extensión");
                    valorMod.setVisible(false);
                    break;
                case "Fecha de Alta:":
                    labelInformativo.setText("La Fecha debe tener el formato 01-01-1995");
                    valorMod.setVisible(false);
                    break;
                case "Fecha de Baja:":
                    labelInformativo.setText("La Fecha debe tener el formato 01-01-1995");
                    valorMod.setVisible(false);
                    break;
                case "Estado:":
                    
                    break;
                default:
                    break;
            }
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLABM;
    private javax.swing.JLabel jLApe;
    private javax.swing.JLabel jLApellido;
    private javax.swing.JLabel jLDom;
    private javax.swing.JLabel jLDomicilio;
    private javax.swing.JLabel jLEfecto;
    private javax.swing.JLabel jLEm;
    private javax.swing.JLabel jLEmail;
    private javax.swing.JLabel jLEst;
    private javax.swing.JLabel jLEstado;
    private javax.swing.JLabel jLFecAlta;
    private javax.swing.JLabel jLFecBaja;
    private javax.swing.JLabel jLFechaDeAlta;
    private javax.swing.JLabel jLFechaDeBaja;
    private javax.swing.JLabel jLFoto;
    private javax.swing.JLabel jLNom;
    private javax.swing.JLabel jLNombre;
    private javax.swing.JLabel jLNumSocio;
    private javax.swing.JLabel jLNumeroDeSocio;
    private javax.swing.JSeparator jSeparator1;
    // End of variables declaration//GEN-END:variables
}
