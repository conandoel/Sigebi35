package vistas;

import java.awt.FlowLayout;
import java.awt.LayoutManager;
import java.util.List;
import javax.swing.BoxLayout;

public class SocioBuscarView extends javax.swing.JInternalFrame {
    
    //Se crea un ArrayList de tipo String que contiene el criterio de búsqueda
    private final String[] criteriosDeBusqueda = 
    {"Número de Socio", "Nombre", "Domicilio", "Mail", "Estado"};
    private SocioBuscarResultado resultado;
    // Creamos un atributo privado y estático de tipo SocioBuscarView
    private static SocioBuscarView sbr;
    private List <SocioBuscarResultado> resultados;
    private String valor;
    private String indice;
    /**
     * Creates new form SocioBuscarView
     */
    private SocioBuscarView() {
        initComponents();
        jCBCargarSocioBuscarCriterios();
        sbr = this;
    }
    
    public String getValor(){
        return valor;
    }
    public String getIndice(){
        return indice;
    }
    
    // Creamos el método getInstance
    public static SocioBuscarView getInstance() {
        // Si el atributo sbr es nulo, lo creamos con el constructor
        if (sbr == null) {
            sbr = new SocioBuscarView();
        }
        // Devolvemos el atributo sbr
        return sbr;
    }
    public void afectarSocio(String EFECTO){
        
        resultados = resultado.listarSocio(indice, valor, EFECTO);
        
        cargarLasTarjetas();
    }

    public void actualizarSeccion(String SECCION){
        SocioBuscarView.getInstance().jLBuscarSocios.setText("Modificar socios");
        switch(SECCION){
            case "MODIFICAR" -> this.jLBuscarSocios.setText("Modificar socios");
            case "ELIMINAR" -> this.jLBuscarSocios.setText("Eliminar socios");
            default -> this.jLBuscarSocios.setText("Buscar socios");
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

        jPSocioBuscar = new javax.swing.JPanel();
        jLBuscarSocios = new javax.swing.JLabel();
        jCBSocioBuscarCriterio = new javax.swing.JComboBox<>();
        jTFSocioBuscarIngreseValor = new javax.swing.JTextField();
        jLSocioBuscarCriterio = new javax.swing.JLabel();
        jLSocioBuscarIngreseValor = new javax.swing.JLabel();
        jSPResultados = new javax.swing.JScrollPane();
        jBBuscar = new javax.swing.JButton();

        jLBuscarSocios.setFont(new java.awt.Font("Segoe UI Historic", 1, 18)); // NOI18N
        jLBuscarSocios.setForeground(new java.awt.Color(0, 160, 210));
        jLBuscarSocios.setText("Búsqueda de socios");

        jCBSocioBuscarCriterio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCBSocioBuscarCriterioActionPerformed(evt);
            }
        });

        jTFSocioBuscarIngreseValor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTFSocioBuscarIngreseValorActionPerformed(evt);
            }
        });

        jLSocioBuscarCriterio.setText(" Ingrese criterio de búsqueda:");

        jLSocioBuscarIngreseValor.setText("Ingrese el X:");

        jSPResultados.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jSPResultados.setHorizontalScrollBar(null);
        jSPResultados.setRowHeaderView(null);

        jBBuscar.setText("Q");
        jBBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBBuscarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPSocioBuscarLayout = new javax.swing.GroupLayout(jPSocioBuscar);
        jPSocioBuscar.setLayout(jPSocioBuscarLayout);
        jPSocioBuscarLayout.setHorizontalGroup(
            jPSocioBuscarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPSocioBuscarLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPSocioBuscarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPSocioBuscarLayout.createSequentialGroup()
                        .addGroup(jPSocioBuscarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLBuscarSocios, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLSocioBuscarCriterio, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPSocioBuscarLayout.createSequentialGroup()
                                .addComponent(jLSocioBuscarIngreseValor, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addGap(41, 41, 41))
                    .addGroup(jPSocioBuscarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jCBSocioBuscarCriterio, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPSocioBuscarLayout.createSequentialGroup()
                            .addComponent(jTFSocioBuscarIngreseValor, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jBBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addComponent(jSPResultados, javax.swing.GroupLayout.DEFAULT_SIZE, 448, Short.MAX_VALUE)
                .addGap(30, 30, 30))
        );
        jPSocioBuscarLayout.setVerticalGroup(
            jPSocioBuscarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPSocioBuscarLayout.createSequentialGroup()
                .addGroup(jPSocioBuscarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPSocioBuscarLayout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addComponent(jLBuscarSocios, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLSocioBuscarCriterio)
                        .addGap(5, 5, 5)
                        .addComponent(jCBSocioBuscarCriterio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLSocioBuscarIngreseValor)
                        .addGap(7, 7, 7)
                        .addGroup(jPSocioBuscarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTFSocioBuscarIngreseValor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jBBuscar)))
                    .addGroup(jPSocioBuscarLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jSPResultados, javax.swing.GroupLayout.DEFAULT_SIZE, 385, Short.MAX_VALUE)))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPSocioBuscar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPSocioBuscar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTFSocioBuscarIngreseValorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTFSocioBuscarIngreseValorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTFSocioBuscarIngreseValorActionPerformed

    private void jCBSocioBuscarCriterioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCBSocioBuscarCriterioActionPerformed
        // TODO add your handling code here:
        
        String seleccion = jCBSocioBuscarCriterio.getSelectedItem().toString();
        
        jLSocioBuscarIngreseValor.setText("Ingrese el " + seleccion);
    }//GEN-LAST:event_jCBSocioBuscarCriterioActionPerformed

    private void jBBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBBuscarActionPerformed
        
        final String NADA = "NADA";

        valor = jTFSocioBuscarIngreseValor.getText();
        indice = jCBSocioBuscarCriterio.getSelectedItem().toString();
        
        resultado = new SocioBuscarResultado();
        resultados = resultado.listarSocio(indice, valor, NADA);
        
        cargarLasTarjetas();
 
    }//GEN-LAST:event_jBBuscarActionPerformed
    
    private void cargarLasTarjetas(){
        DropShadowPanel panelTarjetas = new DropShadowPanel(20);
        // Creamos una variable para almacenar el LayoutManager elegido
        LayoutManager layout;
        
        if(resultados.size()>1){
            // Usamos un BoxLayout vertical
            layout = new BoxLayout (panelTarjetas, BoxLayout.Y_AXIS);
        }else{
            // Usamos un FlowLayout con alineación a la izquierda
            layout = new FlowLayout (FlowLayout.LEFT);
        }
        
        // Asignamos el LayoutManager al panel de tarjetas una sola vez
        panelTarjetas.setLayout (layout);
        
        for(SocioBuscarResultado res : resultados){
            res.setVisible(true);
            // Agregamos cada tarjeta al panel
            panelTarjetas.add(res);
        }
        // Asignamos el panel como la vista del JScrollPane
        jSPResultados.setViewportView(panelTarjetas);
    }
    private void jCBCargarSocioBuscarCriterios(){
        for(String criterio : criteriosDeBusqueda){
            jCBSocioBuscarCriterio.addItem(criterio);
        }
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBBuscar;
    private javax.swing.JComboBox<String> jCBSocioBuscarCriterio;
    private javax.swing.JLabel jLBuscarSocios;
    private javax.swing.JLabel jLSocioBuscarCriterio;
    private javax.swing.JLabel jLSocioBuscarIngreseValor;
    private javax.swing.JPanel jPSocioBuscar;
    private javax.swing.JScrollPane jSPResultados;
    private javax.swing.JTextField jTFSocioBuscarIngreseValor;
    // End of variables declaration//GEN-END:variables
}
