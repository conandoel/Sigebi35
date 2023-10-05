package vistas;

public class Principal extends javax.swing.JFrame {
    
    SocioBuscarView socioBuscarView=new SocioBuscarView();
    private final String MODIFICAR = "MODIFICAR";
    private final String ELIMINAR = "ELIMINAR";
    private final String NADA = "";
    private boolean primeraVez = true;
    /**
     * Creates new form Principal
     */
    public Principal() {
        initComponents();
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
        jMenuItem4 = new javax.swing.JMenuItem();
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

        jMenuItem4.setText("...Socio");
        jMenu2.add(jMenuItem4);

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
    private void cargarBusquedaSocio(){
        jDPEscritorio.removeAll();
        jDPEscritorio.repaint();
        
        socioBuscarView.setVisible(true);

        jDPEscritorio.add(socioBuscarView);
        jDPEscritorio.moveToFront(socioBuscarView);
    }
    private void jMBuscarSociosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMBuscarSociosActionPerformed
        // TODO add your handling code here:
        if(primeraVez){
            primeraVez = false;
            cargarBusquedaSocio();
        }else{
            socioBuscarView.afectarSocio(NADA);
            cargarBusquedaSocio();
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

    private void jMModificarSociosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMModificarSociosActionPerformed
        // TODO add your handling code here:
        socioBuscarView.afectarSocio(MODIFICAR);
    }//GEN-LAST:event_jMModificarSociosActionPerformed

    private void jMElimSociosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMElimSociosActionPerformed
        // TODO add your handling code here:
        socioBuscarView.afectarSocio(ELIMINAR);
    }//GEN-LAST:event_jMElimSociosActionPerformed

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
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JMenuItem jMenuItem7;
    private javax.swing.JPanel panel;
    // End of variables declaration//GEN-END:variables
}
