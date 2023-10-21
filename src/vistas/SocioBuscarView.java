package vistas;

import com.toedter.calendar.JCalendar;
import com.toedter.calendar.JDateChooser;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.LayoutManager;
import java.awt.event.KeyEvent;
import java.util.List;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPopupMenu;
import javax.swing.JTextField;
import javax.swing.plaf.basic.BasicInternalFrameUI;

public class SocioBuscarView extends javax.swing.JInternalFrame {
    
    //Se crea un ArrayList de tipo String que contiene el criterio de búsqueda para rellenar JLabel sobre el campo de texto de la VISTA BUSCAR SOCIO
    private final String[] criteriosDeBusqueda = 
    {"Número de Socio", "Apellido", "Nombre", "Domicilio", "DNI", "Teléfono", "Mail", "Fecha de Alta", "Fecha de Baja", "Estado", "Fecha"};
    //Se declara un List para guardar las TARJETAS
    private List <SocioTarjeta> resultados;
    //Se declara una instancia de la TARJETA
    private SocioTarjeta resultado;
    //Se crea un atributo privado y estático de tipo SocioBuscarView para utilizar el PATRÓN DE DISEÑO Singleton
    private static SocioBuscarView sbr;
    //Variables para almacenar tanto criterio como valor, por ejemplo "idSocio" y "5560"
    private String valor;
    private String criterio;
    /**
     * Creates new form SocioBuscarView
     */
    private SocioBuscarView() {
        initComponents();
        jCBCargarSocioBuscarCriterios();
        
        Container pane = ((BasicInternalFrameUI) this.getUI ()).getNorthPane();
        // Eliminar el botón del menú
        pane.remove(0);
        
        sbr = this;
        //jBBuscar.addActionListener(action);
        //jBBuscar.getInputMap().put(KeyStroke.getKeyStroke("ENTER"), "doClick");
        //jBBuscar.getActionMap().put("doClick", action);
        
    }
    //Getter para revisar el valor dado en la búsqueda
    public String getValor(){
        return valor;
    }
    //Getter para revisar el criterio dado en la búsqueda
    public String getCriterio(){
        return criterio;
    }
    //Por alguna razón que no recuerdo, parece ser necesario acceder al cuadro de búsqueda desde otras clases
    public JTextField getCuadroDeBusqueda(){
        return this.jTFSocioBuscarIngreseValor;
    }
    
    //Se crea el método getInstance para el PATRÓN DE DISEÑO Singleton
    public static SocioBuscarView getInstance() {
        //Si el atributo sbr es nulo, lo creamos con el constructor
        if (sbr == null) {
            sbr = new SocioBuscarView();
        }
        //Se devuelve el atributo sbr
        return sbr;
    }
    private int activarEliminar=0;
    //Método que comunica criterio y valor elegido en la VISTA para ser utilizado por el método listarSocio para crear las TARJETAS.
    public void afectarSocio(String EFECTO){
        if(EFECTO.equals("AGREGAR")){
            criterio = "NINGUNO";
            valor = "";
        }
        //Se envía el pedido de rediseño de TARJETAS para ver si estarán en módo "BUSCAR", "ELIMINAR", o "MODIFICAR"
        resultados = SocioTarjeta.getInstance().listarSocio(criterio, valor, EFECTO);
        //Si el valor de EFECTO es "LIMPIAR" entonces la visibilidad de las TARJETAS es false
        if(EFECTO.equals("LIMPIAR")){
            activarEliminar--;
            for(SocioTarjeta resultado : resultados){
                resultado.setVisible(false);
            }
        }else if(EFECTO.equals("ELIMINAR")){
            activarEliminar++;
            if(activarEliminar==2){
                for(SocioTarjeta resultado : resultados){
                    resultado.getInstance().getEfecto().setVisible(false);
                    activarEliminar=0;
                }

            }else{JOptionPane.showMessageDialog(null, "Eliminar else == " + activarEliminar);
                activarEliminar--;
            }
        }else if(EFECTO.equals("AGREGAR")){
            JOptionPane.showMessageDialog(null, "Limpiar == " + activarEliminar);
        }else{
            //AQUÍ LÓGICA DE MODIFICACIÓN

        }
        
        //Se recargan las TARJETAS
        cargarLasTarjetas();
        resultados.clear();
    }
    //Método para modificar la VISTA SocioBuscarView para que se adapte al modo "BUSCAR", "ELIMINAR", o "MODIFICAR"
    public void actualizarSeccion(String SECCION){
        //Con el PATRÓN DE DISEÑO Singleton se actualiza el JLabel de la VISTA BUSCAR SOCIO (No creo que sea necesario Singleton aquí. Ver por qué lo hice. Quizá pensando en futuras vistas)
        SocioBuscarView.getInstance().jLBuscarSocios.setText("Modificar socios");
        //Según la SECCION que va a tomar en realidad el valor de "EFECTO" que puede ser "MODIFICAR", "ELIMINAR", "LIMPIAR" (Aún no hace nada eso), y "NADA"
        switch(SECCION){
            case "MODIFICAR" -> this.jLBuscarSocios.setText("Modificar socios");
            case "ELIMINAR" -> this.jLBuscarSocios.setText("Eliminar socios");
            default -> this.jLBuscarSocios.setText("Buscar socios");
        }
        //Cada case es para modificar el JLabel por tanto según sea el caso, la VISTA BUSCAR SOCIO será "Buscar socios" o "Eliminar Socios", etc
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
        jLInfo = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();

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
        jTFSocioBuscarIngreseValor.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTFSocioBuscarIngreseValorKeyReleased(evt);
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
        jBBuscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jBBuscarKeyReleased(evt);
            }
        });

        jLInfo.setForeground(new java.awt.Color(255, 0, 51));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 196, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 90, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 90, Short.MAX_VALUE)
        );

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
                    .addGroup(jPSocioBuscarLayout.createSequentialGroup()
                        .addGroup(jPSocioBuscarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPSocioBuscarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jCBSocioBuscarCriterio, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPSocioBuscarLayout.createSequentialGroup()
                                    .addComponent(jTFSocioBuscarIngreseValor, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jBBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jLInfo, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPSocioBuscarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addComponent(jSPResultados, javax.swing.GroupLayout.DEFAULT_SIZE, 446, Short.MAX_VALUE)
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
                            .addComponent(jBBuscar))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLInfo)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 20, Short.MAX_VALUE)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPSocioBuscarLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jSPResultados)))
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
    //Maneja el evento ENTER dentro del JTextField que tiene el valor de búsqueda
    private void jTFSocioBuscarIngreseValorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTFSocioBuscarIngreseValorActionPerformed
        //Cuando se presiona ENTER en el campo de texto, el JButton que se encarga de confirmar la búsqueda gana el FOCO
        this.jBBuscar.requestFocus();
    }//GEN-LAST:event_jTFSocioBuscarIngreseValorActionPerformed
    //Manejador que escucha la elección de un elemento dentro del JComboBox de la VISTA BUSCAR SOCIO
    private void jCBSocioBuscarCriterioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCBSocioBuscarCriterioActionPerformed
        //Se guarda en una variable el valor String del item seleccionado en el JComboBox, por ejemplo "Número de Socio"
        String seleccion = jCBSocioBuscarCriterio.getSelectedItem().toString();
        if(seleccion.equals("Fecha")){
            JDateChooser fechaDesde = new JDateChooser();
            fechaDesde.setBounds(100, 200, 100, 40);
            
            Dimension dimDia = new Dimension(150, 150);
            Dimension dimMes = new Dimension(125, 30);
            Dimension dimAnyo = new Dimension(100, 30);
            
            fechaDesde.getJCalendar().getDayChooser().setPreferredSize(dimDia);
            fechaDesde.getJCalendar().getMonthChooser().setPreferredSize(dimMes);
            fechaDesde.getJCalendar().getYearChooser().setPreferredSize(dimAnyo);

            
            
            this.jPSocioBuscar.add(fechaDesde);
            this.jPSocioBuscar.repaint();
        }
        //Se adapta el JLabel que apunta qué debe hacer el usuario. Por ejemplo "Ingrese el " + "Número de Socio":
        jLSocioBuscarIngreseValor.setText("Ingrese el " + seleccion);
    }//GEN-LAST:event_jCBSocioBuscarCriterioActionPerformed
    //Método manejador del BOTÓN que realiza la confirmación de las búsquedas
    private void jBBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBBuscarActionPerformed
        //Si el campo de texto en donde se ingresa el valor está vacío, el campo de texto vuelve a tomar el foco, y el JLabel que informa, hace el informe correspondiente
        realizarBusqueda();
        
 
    }//GEN-LAST:event_jBBuscarActionPerformed
    
    private void realizarBusqueda(){
        //CREO QUE HAY QUE MANEJAR OTRAS POSIBILIDADES - VER POR QUÉ OTROS INFORMES ESTÁN EN OTROS MÉTODOS
        if(this.jTFSocioBuscarIngreseValor.getText().equals("")){
            this.jTFSocioBuscarIngreseValor.requestFocus();
            this.jLInfo.setText("El campo no debe estar vacío");
        }else{
            //Si hay algo escrito aparentemente se realiza la búsqueda. Se crea una CONSTANTE con valor String "NADA"
            final String NADA = "NADA";
            //Se toman el valor y criterio de búsqueda de la VISTA BUSCAR SOCIO
            valor = jTFSocioBuscarIngreseValor.getText();
            criterio = jCBSocioBuscarCriterio.getSelectedItem().toString();
            //Se instancia una TARJETA (su molde)
            resultado = new SocioTarjeta();
            //Se guardan en el LIST las TARJETAS devueltas con la BÚSQUEDA ya que NADA es para BÚSQUEDA
            resultados = SocioTarjeta.getInstance().listarSocio(criterio, valor, NADA);
            //Se cargan las TARJETAS en el contenedor para que las vea el usuario
            cargarLasTarjetas();
            //Se maneja chequeando si el JLabel que tiene el valor del estado dice "Desasociado" para condicionar el acceso a la eliminación desde el MENÚ
            if(SocioTarjeta.getInstance().getEstado().equals("Desasociado")){
                Principal.getInstance().habilitarModificaciones(true, false, true);
            }
            //Aquí "primeraVez" pasa a tener valor "false" para que a la segunda vez en adelante se limpie el contenedor de TARJETAS
            Principal.getInstance().primeraVez = false;
        }
    }
    
    private void jBBuscarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jBBuscarKeyReleased
        // TODO add your handling code here:
        if(evt.getKeyCode()==10){
            realizarBusqueda();
        }
    }//GEN-LAST:event_jBBuscarKeyReleased

    private void jTFSocioBuscarIngreseValorKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTFSocioBuscarIngreseValorKeyReleased
        // TODO add your handling code here:
        /*if(jCBSocioBuscarCriterio.getSelectedItem().equals("Fecha de Alta")){
            
        }*/
        
        String criterio = this.jCBSocioBuscarCriterio.getSelectedItem().toString();
        direccionarCriterio(criterio, evt);
    }//GEN-LAST:event_jTFSocioBuscarIngreseValorKeyReleased
    
    private void direccionarCriterio(String criterio, KeyEvent evt){
        JLabel valorMod = new JLabel();
        if(criterio.equals("DNI")){
            valorMod.setText("DNI");
            SocioTarjeta.getInstance().noEnterDNI(this.jLInfo, valorMod, evt);
        }
    }
    
    //Este método le da a las TARJETAS la disposición con las que se mostrarán según la cantidad
    private void cargarLasTarjetas(){
        //Se crea una instancia de DropShadowPanel y se le pasa el grosor de la sombra con valor 20px
        DropShadowPanel panelTarjetas = new DropShadowPanel(20);
        //Se crea una variable para almacenar el LayoutManager elegido
        LayoutManager layout;
        //Si la cantidad de TARJETAS que arroje la búsqueda es mayor a 1
        if(resultados.size() > 1){
            //Se aplica un BoxLayout vertical
            layout = new BoxLayout (panelTarjetas, BoxLayout.Y_AXIS);
        //Si el resultado de la búsqueda arroja sólo una TARJETA    
        }else if(resultados.size()==1){
            //Se utiliza un FlowLayout con alineación a la izquierda (Porque sino se pone en el centro la TARJETA en lugar de arriba)
            layout = new FlowLayout (FlowLayout.LEFT);
        //Si no regresaron TARJETAS entonces se informa mediante un JLabel ubicado debajo del JTextField para búsqueda, y el layout queda en null
        }else{
            this.jLInfo.setText("La búsqueda no arrojó resultados");
            layout = null;
        }
        //Si el layout es diferente de null, o sea que se han devuelto TARJETAS
        if(layout!=null){
            //Se aplica el LayoutManager al panel de TARJETAS una sola vez
            panelTarjetas.setLayout (layout);
            //Se itera por las TARJETAS y se les da visibilidad ---PROBABLE SOLUCIÓN AL PROBLEMA DE BORRADO DE MÚLTIPLES TARJETAS
            for(SocioTarjeta res : resultados){
                //Se agrega cada TARJETA al panel
                panelTarjetas.add(res);
            }
            //Se asigna el panel como la vista del JScrollPane
            jSPResultados.setViewportView(panelTarjetas);
            //Chequea si las TARJETAS están buscadas por estado con valor 0 (DEBERÍA MANEJARSE CON LOS ATRIBUTOS "criterio" y "valor". ADAPTAR)
            if(criterio.equalsIgnoreCase("estado") && valor.equals("0")){
                //Utilizando el PATRÓN DE DISEÑO Singleton se permite MODIFICAR desde el menú PRINCIPAL pero no ELIMINAR
                Principal.getInstance().habilitarModificaciones(true, false, true);
            }else{
                //Se permiten tanto MODIFICAR como ELIMINAR ya que es un socio activo
                Principal.getInstance().habilitarModificaciones(true, true, true);
            }
            //El JLabel que está debajo del cuadro de búsqueda que sirve para informar si las búsquedas están bien ejecutadas se vacía
            jLInfo.setText("");
        }
    }
    //Método que carga el JComboBox de la VISTA BUSCAR SOCIO utilizando el arreglo de String criteriosDeBusqueda (DEBERÍA HACERSE PIDIENDO A BASE DE DATOS y MODIFICANDO EL idSocio)
    private void jCBCargarSocioBuscarCriterios(){
        for(String criterioLocal : criteriosDeBusqueda){
            jCBSocioBuscarCriterio.addItem(criterioLocal);
        }
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBBuscar;
    private javax.swing.JComboBox<String> jCBSocioBuscarCriterio;
    private javax.swing.JLabel jLBuscarSocios;
    private javax.swing.JLabel jLInfo;
    private javax.swing.JLabel jLSocioBuscarCriterio;
    private javax.swing.JLabel jLSocioBuscarIngreseValor;
    private javax.swing.JPanel jPSocioBuscar;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jSPResultados;
    private javax.swing.JTextField jTFSocioBuscarIngreseValor;
    // End of variables declaration//GEN-END:variables
}
