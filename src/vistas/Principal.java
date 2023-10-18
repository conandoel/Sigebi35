package vistas;

import datos.SocioData;
import java.io.File;
import javax.swing.JTextField;

public class Principal extends javax.swing.JFrame {
    //Constantes para manejar la creación de TARJETAS
    private static final String MODIFICAR = "MODIFICAR";
    private static final String ELIMINAR = "ELIMINAR";
    private static final String NADA = "NADA";
    private static Principal pr;
    public boolean primeraVez = true;
    /**
     * Creates new form Principal
     */
    public Principal() {
        initComponents();
        //Se guarda en pr la instancia del PROGRAMA para utilizar el PATRÓN DE DISEÑO Singleton
        pr = this;
        //Se crea un manejador de la lógica. No recuerdo ni sé por qué lo creo aquí
        SocioData sd = new SocioData();
        //sd.insertarImagenesSocio();   NO UTILIZAR ! ! ! ! ! ! ! ! ! (ESTO SE USA UNA SOLA VEZ PARA CARGAR LAS IMÁGENES EN LA BASE DE DATOS. DESPUÉS ES REDUNDANTE. POSIBLEMENTE USARÉ PARA CREAR NUEVO SOCIO
        //Se DESHABILITA tanto la posibilidad de MODIFICAR como ELIMINAR socios ya que aún no hay búsqueda. Podría ser algo más elegante que esto
        habilitarModificaciones(false, false, true);
        //Se llama al método encargado de chequear si las imágenes ya están en la PC o si hay que crearlas
        chequearSiYaHayImagenes(sd);
    }
    
    //Se crea el método getInstance
    public static Principal getInstance() {
        // Si el atributo sbr es nulo, lo creamos con el constructor
        if (pr == null) {
            pr = new Principal();
        }
        // Devolvemos el atributo sbr
        return pr;
    }
    //Método para chequear si existen las fotos de perfil en la PC
    private void chequearSiYaHayImagenes(SocioData check){
        File imagen = new File("./src/vistas/imagenes/foto_5556.jpg");
        //Se usa el método exists para verificar si el ARCHIVO NO existe
        if (!imagen.exists()) {
            //Si NO EXISTE, se cargan las imágenes en la PC
            check.obtenerImagenesSocio();
        }
    }

  
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenu1 = new javax.swing.JMenu();
        jDPEscritorio = new javax.swing.JDesktopPane();
        panel = new javax.swing.JPanel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMArchivo = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMSalir = new javax.swing.JMenuItem();
        jMBuscar = new javax.swing.JMenu();
        jMBuscarLibros = new javax.swing.JMenuItem();
        jMBuscarSocios = new javax.swing.JMenuItem();
        jMBuscarPréstamos = new javax.swing.JMenuItem();
        jMModificar = new javax.swing.JMenu();
        jMModLibros = new javax.swing.JMenuItem();
        jMenuItem6 = new javax.swing.JMenuItem();
        jMModificarSocios = new javax.swing.JMenuItem();
        jMModPrestamos = new javax.swing.JMenuItem();
        jMEliminar = new javax.swing.JMenu();
        jMElimLibros = new javax.swing.JMenuItem();
        jMenuItem7 = new javax.swing.JMenuItem();
        jMElimSocios = new javax.swing.JMenuItem();
        jMElimPrestamos = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMAgregarSocio = new javax.swing.JMenuItem();
        jMenuItem5 = new javax.swing.JMenuItem();

        jMenu1.setText("jMenu1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        javax.swing.GroupLayout panelLayout = new javax.swing.GroupLayout(panel);
        panel.setLayout(panelLayout);
        panelLayout.setHorizontalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 680, Short.MAX_VALUE)
        );
        panelLayout.setVerticalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 397, Short.MAX_VALUE)
        );

        jDPEscritorio.setLayer(panel, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jDPEscritorioLayout = new javax.swing.GroupLayout(jDPEscritorio);
        jDPEscritorio.setLayout(jDPEscritorioLayout);
        jDPEscritorioLayout.setHorizontalGroup(
            jDPEscritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jDPEscritorioLayout.setVerticalGroup(
            jDPEscritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jMArchivo.setText("Archivo");

        jMenuItem1.setText("Prestar Libro");
        jMArchivo.add(jMenuItem1);

        jMenuItem2.setText("Devolver Libro");
        jMArchivo.add(jMenuItem2);

        jMSalir.setText("Salir");
        jMSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMSalirActionPerformed(evt);
            }
        });
        jMArchivo.add(jMSalir);

        jMenuBar1.add(jMArchivo);

        jMBuscar.setText("Buscar");

        jMBuscarLibros.setText("...libros");
        jMBuscar.add(jMBuscarLibros);

        jMBuscarSocios.setText("...socios");
        jMBuscarSocios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMBuscarSociosActionPerformed(evt);
            }
        });
        jMBuscar.add(jMBuscarSocios);

        jMBuscarPréstamos.setText("...préstamos");
        jMBuscarPréstamos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMBuscarPréstamosActionPerformed(evt);
            }
        });
        jMBuscar.add(jMBuscarPréstamos);

        jMenuBar1.add(jMBuscar);

        jMModificar.setText("Modificar");

        jMModLibros.setText("...libros");
        jMModificar.add(jMModLibros);

        jMenuItem6.setText("...ejemplar");
        jMenuItem6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem6ActionPerformed(evt);
            }
        });
        jMModificar.add(jMenuItem6);

        jMModificarSocios.setText("...socios");
        jMModificarSocios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMModificarSociosActionPerformed(evt);
            }
        });
        jMModificar.add(jMModificarSocios);

        jMModPrestamos.setText("...préstamos");
        jMModificar.add(jMModPrestamos);

        jMenuBar1.add(jMModificar);

        jMEliminar.setText("Eliminar");

        jMElimLibros.setText("...libros");
        jMEliminar.add(jMElimLibros);

        jMenuItem7.setText("...ejemplar");
        jMEliminar.add(jMenuItem7);

        jMElimSocios.setText("...socios");
        jMElimSocios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMElimSociosActionPerformed(evt);
            }
        });
        jMEliminar.add(jMElimSocios);

        jMElimPrestamos.setText("...préstamos");
        jMElimPrestamos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMElimPrestamosActionPerformed(evt);
            }
        });
        jMEliminar.add(jMElimPrestamos);

        jMenuBar1.add(jMEliminar);

        jMenu2.setText("Agregar");

        jMenuItem3.setText("...Libro");
        jMenu2.add(jMenuItem3);

        jMAgregarSocio.setText("...Socio");
        jMAgregarSocio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMAgregarSocioActionPerformed(evt);
            }
        });
        jMenu2.add(jMAgregarSocio);

        jMenuItem5.setText("...Ejemplar");
        jMenu2.add(jMenuItem5);

        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jDPEscritorio)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jDPEscritorio)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    //Método encargado de deshabilitar y habilitar la MODIFICACIÓN y ELIMINACIÓN desde el menú
    public void habilitarModificaciones(boolean habilitarMod, boolean habilitarElim, boolean habilitarAgr){
        this.jMAgregarSocio.setEnabled(habilitarAgr);
        this.jMModificarSocios.setEnabled(habilitarMod);
        this.jMElimSocios.setEnabled(habilitarElim);
    }
    
    public void cargarAgregarSocio(){
        jDPEscritorio.removeAll();
        jDPEscritorio.repaint();
        
        SocioAgregarView agregarSocio = new SocioAgregarView();
        agregarSocio.setVisible(true);
        //Se agrega la VISTA al CONTENEDOR y luego se pone al frente
        jDPEscritorio.add(agregarSocio);
        jDPEscritorio.moveToFront(agregarSocio);
    }


//Método que sólo debería cargar la VISTA de BUSCAR SOCIOS, pero está tratando de borrar el muestreo de TARJETAS al recargar una nueva búsqueda de socios
    public void cargarBusquedaSocio(){
        //Con el PATRON DE DISEÑO Singleton se ELIMINA la instancia de las TARJETAS (SOLO UNA TARJETA. PARA MÚLTIPLES TARJETAS AÚN NO DOY EN EL CLAVO
        SocioTarjeta.getInstance().removeAll();
        SocioTarjeta.getInstance().revalidate();
        SocioTarjeta.getInstance().repaint();
        SocioTarjeta.getInstance().setVisible(false);
        //Se limpia el DesktopPane (QUIZÁ LA UBICACIÓN o el JPANEL panel tengan que ver CON EL PROBLEMA DE LIMPIADO DE MÚLTIPLES TARJETAS
        jDPEscritorio.removeAll();
        jDPEscritorio.repaint();
        //Se le da visibiilidad a la instancia de la VISTA de BUSCAR SOCIOS (Chequear si es necesario)
        SocioBuscarView.getInstance().setVisible(true);
        //Se agrega la VISTA al CONTENEDOR y luego se pone al frente
        jDPEscritorio.add(SocioBuscarView.getInstance());
        jDPEscritorio.moveToFront(SocioBuscarView.getInstance());
    }
    //Manejador de eventos del menú al elegir "Buscar -> Socios"
    private void jMBuscarSociosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMBuscarSociosActionPerformed
        //Si es la primera vez "primeraVez" tiene valor "true"
        if(primeraVez){
            Principal.getInstance().habilitarModificaciones(false, false, true);
            //Se guarda el CUADRO DE BÚSQUEDA utilizando el PATRÓN DE DISEÑO Singleton
            JTextField cuadroDeBusqueda = SocioBuscarView.getInstance().getCuadroDeBusqueda();
            
            //Aquí se llama al método que carga la VISTA de BUSCAR SOCIOS (PARECE SER QUE ESTOY INTENTANDO LIMPIAR EN ESE MÉTODO LAS TARJETAS)
            cargarBusquedaSocio();
            //Se le da el FOCO al CUADRO DE TEXTO en donde se ingresa el valor de la búsqueda
            cuadroDeBusqueda.requestFocus();
        }else{
            //Aqui le paso al método que prepara todo para crear TARJETAS el valor LIMPIAR QUE AÚN NO ADECUÉ PERO PARECE SER QUE ERA LA IDEA PRIMARIA PARA LIMPIAR LOS RESULTADOS
            String LIMPIAR = "LIMPIAR";
            SocioBuscarView.getInstance().afectarSocio(LIMPIAR);
            //SocioBuscarView.getInstance().afectarSocio(NADA); //NADA o LIMPIAR o CHORIPAN da lo mismo por ahora
            //Se llama al método que carga la VISTA de BUSCAR SOCIOS
            cargarBusquedaSocio();
            //Se deshabilita la posibilidad de acceder desde el menú a las MODIFICACIONES y ELIMINACIONES
            Principal.getInstance().habilitarModificaciones(false, false, true);
        }
    }//GEN-LAST:event_jMBuscarSociosActionPerformed

    private void jMBuscarPréstamosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMBuscarPréstamosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMBuscarPréstamosActionPerformed

    private void jMElimPrestamosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMElimPrestamosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMElimPrestamosActionPerformed

    private void jMSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMSalirActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMSalirActionPerformed

    private void jMenuItem6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem6ActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_jMenuItem6ActionPerformed
    
    //Manejador del evento al seleccionar MODIFICAR -> SOCIOS
    private void jMModificarSociosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMModificarSociosActionPerformed
        //Utilizando el PATRÓN DE DISEÑO Singleton se envía que se REIMPRIMAN las TARJETAS con ÍCONO y OTROS de MODIFICAR
        SocioBuscarView.getInstance().afectarSocio(MODIFICAR);
        //Con el PATRÓN DE DISEÑO Singleton se chequea si el CRITERIO NO es "estado" Y "valor" es 0 (AMBOS) Y que el rótulo del label específico no sea "Desasociado"
        if(!(SocioBuscarView.getInstance().getCriterio().equalsIgnoreCase("estado") &&
                SocioBuscarView.getInstance().getValor().equalsIgnoreCase("0")) && !SocioTarjeta.getInstance().getEstado().equals("Desasociado")){
                //...entonces se DESHABILITA el menú item para MODIFICAR (Pues ya está en "MODIFICAR" y se habilita la posibilidad de "ELIMINAR" pues son SOCIOS ACTIVOS
                this.habilitarModificaciones(false, true, true);
        }else{
            //Si son DESASOCIADOS entonces se DESHABILITA tanto MODIFICAR (pues ya está en "MODIFICAR" y "ELIMINAR" pues ya están DESASOCIADOS
            if(SocioTarjeta.getInstance().getEstado().equals("Desasociado")){
                this.habilitarModificaciones(false, false, true);
            //Si ninguna de estas dos cosas se da, es porque aún no hubo búsqueda alguna, por tanto se DESHABILITAN AMBAS
            }else{
                this.habilitarModificaciones(false, false, true);
            }
        }
    }//GEN-LAST:event_jMModificarSociosActionPerformed
    //Manejador del evento al seleccionar ELIMINAR -> SOCIOS
    private void jMElimSociosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMElimSociosActionPerformed
        //Utilizando el PATRÓN DE DISEÑO Singleton se envía que se REIMPRIMAN las TARJETAS con ÍCONO y OTROS de ELIMINAR
        SocioBuscarView.getInstance().afectarSocio(ELIMINAR);
        //Si el criterio NO es estado Y al mismo tiempo el valor NO es 0 se habilita la MODIFICACIÓN y se deshabilita la ELIMINACIÓN pues ya está en modo ELIMINAR
        if(!(SocioBuscarView.getInstance().getCriterio().equalsIgnoreCase("estado") &&
                SocioBuscarView.getInstance().getValor().equalsIgnoreCase("0"))){
            this.habilitarModificaciones(true, false, true);
        }
    }//GEN-LAST:event_jMElimSociosActionPerformed

    private void jMAgregarSocioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMAgregarSocioActionPerformed
        this.jMAgregarSocio.setEnabled(false);
        cargarAgregarSocio();
 
    }//GEN-LAST:event_jMAgregarSocioActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Principal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDesktopPane jDPEscritorio;
    private javax.swing.JMenuItem jMAgregarSocio;
    private javax.swing.JMenu jMArchivo;
    private javax.swing.JMenu jMBuscar;
    private javax.swing.JMenuItem jMBuscarLibros;
    private javax.swing.JMenuItem jMBuscarPréstamos;
    private javax.swing.JMenuItem jMBuscarSocios;
    private javax.swing.JMenuItem jMElimLibros;
    private javax.swing.JMenuItem jMElimPrestamos;
    private javax.swing.JMenuItem jMElimSocios;
    private javax.swing.JMenu jMEliminar;
    private javax.swing.JMenuItem jMModLibros;
    private javax.swing.JMenuItem jMModPrestamos;
    private javax.swing.JMenu jMModificar;
    private javax.swing.JMenuItem jMModificarSocios;
    private javax.swing.JMenuItem jMSalir;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JMenuItem jMenuItem7;
    private javax.swing.JPanel panel;
    // End of variables declaration//GEN-END:variables
}
