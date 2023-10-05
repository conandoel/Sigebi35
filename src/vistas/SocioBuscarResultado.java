package vistas;

import entidades.Socio;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import datos.SocioData;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.LinearGradientPaint;
import java.awt.MultipleGradientPaint.CycleMethod;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

public class SocioBuscarResultado extends javax.swing.JPanel {
    private List <Socio> socios;
    private List <String> columnas;
    private List <SocioBuscarResultado> tarjetas;
    private SocioData metodoDeSocio;
    private Socio socio;
    
    
    private Image modificar = new ImageIcon(getClass().getResource("/vistas/imagenes/modificar.png")).getImage();
    private Image eliminar = new ImageIcon(getClass().getResource("/vistas/imagenes/eliminar.png")).getImage();
    //private Image fotoPerfil;
    /**
     * Creates new form SocioBuscarResultado
     */
    public SocioBuscarResultado() {
        initComponents();

    }
    private static final Color CELESTITO = new Color(120, 200, 255);
    private static final Color VERDECITO = new Color(0,159,210);
    private static final Color AZULCITO = new Color(5,160,223);
    
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        // Crea un arreglo de colores con el naranja, el blanco y el azul
        Color[] colors = {CELESTITO, VERDECITO, AZULCITO};
        // Crea un arreglo de fracciones que indica cómo se distribuyen los colores
        // El naranja va desde el 0% al 50%, el blanco desde el 50% al 75%, y el azul desde el 75% al 100%
        float[] fractions = {0f, 0.8f, 1f};
        // Crea un degradado lineal desde la esquina superior izquierda hasta la inferior derecha
        // con los colores y las fracciones especificadas
        LinearGradientPaint gp = new LinearGradientPaint(0, 0, getHeight(), 0, fractions, colors, CycleMethod.NO_CYCLE);
        // Aplica el degradado al panel
        g2d.setPaint(gp);
        // Rellena el panel con el degradado
        g2d.fillRect(0, 0, getWidth(), getHeight());

    }
        
    public List <SocioBuscarResultado> listarSocio(String criterio, String valor, String EFECTO){
        
        SocioBuscarView.getInstance().actualizarSeccion(EFECTO);
        
        socios = new ArrayList<>();
        columnas = new ArrayList<>();
        tarjetas = new ArrayList<>();

        metodoDeSocio = new SocioData();
        
        columnas = metodoDeSocio.listarColumnas();
        
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd | MM | yyyy");
        //CANDIDATA A STATIC
        if(criterio.equals("Número de Socio")){
            criterio = "idSocio";
        }else{
            criterio = criterio.toLowerCase();
        }
 
        for(String columna : columnas){
            if(criterio.equals(columna)){
                socios = metodoDeSocio.buscarHistorialSocios(criterio, valor);
            }
        }
        
        for(Socio socio : socios){   
            // Declaramos la variable tarjeta dentro del bucle
            SocioBuscarResultado tarjeta = new SocioBuscarResultado();
            
            int NroX = socio.getIdSocio();
            
            tarjeta.jLNumeroDeSocio.setText(Integer.toString(socio.getIdSocio()));
            tarjeta.jLApellido.setText(socio.getApellido());
            tarjeta.jLNombre.setText(socio.getNombre());
            tarjeta.jLDomicilio.setText(socio.getDomicilio());
            tarjeta.jLEmail.setText(socio.getMail());
            tarjeta.jLFechaDeAlta.setText(socio.getFechaDeAlta().format(formato));
            tarjeta.jLFechaDeBaja.setText(socio.isEstado()? "PONER CUÁNDO TIENE LA BAJA" : socio.getFechaDeBaja().format(formato));
            
            try {
                // Leer una imagen desde un archivo
                File file = new File("./src/vistas/imagenes/foto_" + NroX + ".jpg");
                BufferedImage fotoPerfil = ImageIO.read(file);
                
                tarjeta.jLFoto.setText("");
                tarjeta.jLFoto.setVisible(true);
                tarjeta.jLFoto.setSize(71, 81);
                Image dFotoPerfil = fotoPerfil.getScaledInstance(tarjeta.jLFoto.getWidth(), tarjeta.jLFoto.getHeight(), Image.SCALE_SMOOTH);
                // Poner la imagen en el jLabel usando setIcon()
                tarjeta.jLFoto.setIcon(new ImageIcon(dFotoPerfil));
                
                NroX++;
            } catch (IOException e) {

            }
            
            tarjeta.jLEstado.setText(socio.isEstado()? "Socio Activo" : "Desasociado");
            switch (EFECTO) {
                case "MODIFICAR" -> {
                    tarjeta.jLEfecto.setText("");
                    tarjeta.jLEfecto.setVisible(true);
                    tarjeta.jLEfecto.setSize(20, 20);
                    Image dModificar = modificar.getScaledInstance(tarjeta.jLEfecto.getWidth(), tarjeta.jLEfecto.getHeight(), Image.SCALE_SMOOTH);
                    // Crea un icono con la imagen redimensionada
                    ImageIcon iconModificar = new ImageIcon(dModificar);
                    // Asigna el icono al label
                    tarjeta.jLEfecto.setIcon(iconModificar);
                }
                case "ELIMINAR" -> {
                    tarjeta.jLEfecto.setText("");
                    tarjeta.jLEfecto.setVisible(true);
                    tarjeta.jLEfecto.setSize(20, 20);
                    Image dEliminar = eliminar.getScaledInstance(tarjeta.jLEfecto.getWidth(), tarjeta.jLEfecto.getHeight(), Image.SCALE_SMOOTH);
                    // Crea un icono con la imagen redimensionada
                    ImageIcon iconEliminar = new ImageIcon(dEliminar);
                    // Asigna el icono al label
                    tarjeta.jLEfecto.setIcon(iconEliminar);
                }
                default -> {
                    tarjeta.jLEfecto.setText("");
                    tarjeta.jLEfecto.setVisible(false);
                }
            }
            

            tarjetas.add(tarjeta);
        }
        
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
        labelFondo = new javax.swing.JLabel();
        jLEfecto = new javax.swing.JLabel();

        jLNumSocio.setForeground(new java.awt.Color(102, 102, 102));
        jLNumSocio.setText("Socio número:");

        jLFoto.setText("Imagen");

        jLApe.setForeground(new java.awt.Color(102, 102, 102));
        jLApe.setText("Apellido:");

        jLNom.setForeground(new java.awt.Color(102, 102, 102));
        jLNom.setText("Nombre:");

        jLDom.setForeground(new java.awt.Color(102, 102, 102));
        jLDom.setText("Domicilio:");

        jLEst.setForeground(new java.awt.Color(102, 102, 102));
        jLEst.setText("Estado:");

        jLFecAlta.setForeground(new java.awt.Color(102, 102, 102));
        jLFecAlta.setText("Fecha de Alta:");

        jLFecBaja.setForeground(new java.awt.Color(102, 102, 102));
        jLFecBaja.setText("Fecha de Baja:");

        jLEm.setForeground(new java.awt.Color(102, 102, 102));
        jLEm.setText("E-Mail:");

        jLEmail.setText("anto.sa.villanueva@gmail.com");

        jLDomicilio.setText("Azucena 2155 Azucena 2155 Azu");

        jLNombre.setText("Iván Iván Iván Iván Iván Iván Iván");

        jLApellido.setText("Di Monte Di Monte Di Monte Di");

        jLFechaDeAlta.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLFechaDeAlta.setText("12 de Enero de 1982");

        jLFechaDeBaja.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLFechaDeBaja.setText("29 de Octubre de 2045");

        jLEstado.setText("Socio Activo");

        jLNumeroDeSocio.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLNumeroDeSocio.setText("12345678901");

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
                            .addComponent(labelFondo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(18, Short.MAX_VALUE)
                .addComponent(labelFondo)
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

    private void jLEfectoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLEfectoMouseClicked
        // TODO add your handling code here:
        String valor = SocioBuscarView.getInstance().getValor();
        String criterio = SocioBuscarView.getInstance().getIndice();
        metodoDeSocio = new SocioData();
        socio = metodoDeSocio.eliminarLector(criterio, valor);
        jLEstado.setText(socio.isEstado()? "Socio Activo" : "Desasociado");
    }//GEN-LAST:event_jLEfectoMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
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
    private javax.swing.JLabel labelFondo;
    // End of variables declaration//GEN-END:variables
}
