package vistas;

import entidades.Libro;
import datos.LibroData;
import java.awt.Dimension;
import java.util.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class LibroBuscarView extends javax.swing.JInternalFrame {
    private DefaultTableModel modelo = new DefaultTableModel();
    LibroData lData = new LibroData();
    Principal p;
    
    String Condicion = "ISBN";
    public LibroBuscarView(Principal principal) {
        this.p = principal;
        setTitle("Buscar Libros");
        initComponents();
        cargarTabla();
        jtListaLibro.getColumnModel().getColumn(0).setPreferredWidth(60);
        jtListaLibro.getColumnModel().getColumn(1).setPreferredWidth(150);
        jtListaLibro.getColumnModel().getColumn(3).setPreferredWidth(10);
        jtListaLibro.getColumnModel().getColumn(4).setPreferredWidth(20);
       
        cargarCombo();
        cargarCombo2();
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jcbDato = new javax.swing.JComboBox<>();
        jtfBusqueda = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtListaLibro = new javax.swing.JTable();
        jbtnBuscar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jbtnModificar = new javax.swing.JButton();
        jbtnEliminar = new javax.swing.JButton();
        jbtnConfirmar = new javax.swing.JButton();
        jbtnCancelar = new javax.swing.JButton();
        jbtnNuevo = new javax.swing.JButton();
        jcbElejirEstado = new javax.swing.JComboBox<>();

        jcbDato.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbDatoActionPerformed(evt);
            }
        });

        jtfBusqueda.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N

        jtListaLibro.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jtListaLibro.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtListaLibroMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jtListaLibro);

        jbtnBuscar.setText("Buscar");
        jbtnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnBuscarActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(100, 100, 250));
        jLabel1.setText("Buscar por:");

        jbtnModificar.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jbtnModificar.setText("Modificar");
        jbtnModificar.setVisible(false);
        jbtnModificar.setEnabled(false);
        jbtnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnModificarActionPerformed(evt);
            }
        });

        jbtnEliminar.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jbtnEliminar.setForeground(new java.awt.Color(255, 0, 0));
        jbtnEliminar.setText("Deshabilitar");
        jbtnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnEliminarActionPerformed(evt);
            }
        });

        jbtnConfirmar.setFont(new java.awt.Font("Dialog", 3, 14)); // NOI18N
        jbtnConfirmar.setForeground(new java.awt.Color(204, 0, 0));
        jbtnConfirmar.setText("Confirmar");
        jbtnConfirmar.setEnabled(false);
        jbtnConfirmar.setVisible(false);
        jbtnConfirmar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnConfirmarActionPerformed(evt);
            }
        });

        jbtnCancelar.setFont(new java.awt.Font("Dialog", 3, 14)); // NOI18N
        jbtnCancelar.setText("Cancelar");
        jbtnCancelar.setEnabled(false);
        jbtnCancelar.setVisible(false);
        jbtnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnCancelarActionPerformed(evt);
            }
        });

        jbtnNuevo.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jbtnNuevo.setText("Nuevo Libro");
        jbtnNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnNuevoActionPerformed(evt);
            }
        });

        jcbElejirEstado.setVisible(false);
        jcbElejirEstado.setEnabled(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jcbDato, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(36, 36, 36)
                        .addComponent(jcbElejirEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jtfBusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jbtnBuscar)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jbtnNuevo)
                        .addGap(18, 18, 18)
                        .addComponent(jbtnModificar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jbtnEliminar)
                        .addGap(18, 18, 18)
                        .addComponent(jbtnConfirmar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jbtnCancelar))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtfBusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jcbDato, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbtnBuscar)
                    .addComponent(jLabel1)
                    .addComponent(jcbElejirEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbtnEliminar)
                    .addComponent(jbtnConfirmar)
                    .addComponent(jbtnCancelar)
                    .addComponent(jbtnModificar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jbtnNuevo))
                .addContainerGap(44, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jcbDatoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbDatoActionPerformed
        jtfBusqueda.setText("");//Limpia el text field cuando se cambia el filtro del combobox
        Condicion = (String)jcbDato.getSelectedItem();
        System.out.println(Condicion);
        if(Condicion.equalsIgnoreCase("Disponible")){
            jtfBusqueda.setVisible(false); jtfBusqueda.setEnabled(false);
            jcbElejirEstado.setVisible(true); jcbElejirEstado.setEnabled(true);
        }else{
            
            jcbElejirEstado.setVisible(false); jcbElejirEstado.setEnabled(false);
            jtfBusqueda.setVisible(true); jtfBusqueda.setEnabled(true);
                        
        }
    }//GEN-LAST:event_jcbDatoActionPerformed

    private void jbtnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnBuscarActionPerformed
        List<Libro> libros = new ArrayList<>();
        limpiarTabla(jtListaLibro);
        
        try{
            switch(Condicion){//Usa un metodo de busqueda de LibroData dependiendo del filtro
            case("ISBN"):
                libros = lData.buscarLibroPorISBN(Long.parseLong(jtfBusqueda.getText()));
                break;
            case("Autor"):
                libros = lData.buscarLibroPorAutor(jtfBusqueda.getText());
                break;
            case("Disponible"):
                String estado = jcbElejirEstado.getSelectedItem().toString();
                if(estado.equals("Disponible")){
                    libros = lData.listarLibroPorEstado(true, 1);
                }else{
                    libros = lData.listarLibroPorEstado(false, 1);
                }
                break;
            default://El filtro puede ser Isbn, Autor, TITULO y GENERO. Si no se usa los primeros dos, usa este metodo
                libros = lData.buscarLibroGeneral(Condicion, jtfBusqueda.getText());
                break;
            }
        
        jbtnModificar.setVisible(true); jbtnModificar.setEnabled(true);
            
        }catch(NumberFormatException ex){
            if(jtfBusqueda.getText().equalsIgnoreCase("")){
                JOptionPane.showMessageDialog(null, "Campo de busqueda para ISBN no puede estar vacio");
            }else{
                JOptionPane.showMessageDialog(null, "Ingrese un dato valido");
            }
            
        }
        
        
        Iterator<Libro> iterador = libros.iterator();//Crea un iterador con los libros encontrados
        if(iterador.hasNext()){
            while(iterador.hasNext()){//Llena la tabla con la lista de libros encontrados en la base de datos
                
                Libro libro = new Libro(); libro = iterador.next();
                
                modelo.addRow(new Object[] {libro.getIsbn(), libro.getTitulo(), libro.getAutor(), libro.getAnio(),
                                            libro.getGenero(), libro.getCantEjemplares()});
                
            }
        }
        if(jtListaLibro.getRowCount() == 0){
            jbtnModificar.setVisible(false); jbtnModificar.setEnabled(false);
        }
         
    }//GEN-LAST:event_jbtnBuscarActionPerformed

    private void jbtnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnModificarActionPerformed
        Libro libro = new Libro();
        
        libro = libroSeleccionado(libro);
        
        if(libro != null){
            Dimension d = new Dimension(415, 420);
            p.cargarModLibro(libro, 400, 415);
        }
        
    }//GEN-LAST:event_jbtnModificarActionPerformed

    private void jbtnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnEliminarActionPerformed
        //Inhabilitar los demas botones, para que se enfoque en la confirmacion de la eliminacion
        
        ////////////////////////////////////////////////////////////////////////
        //Botones
        jbtnBuscar.setEnabled(false);
        jbtnNuevo.setEnabled(false);
        jbtnModificar.setEnabled(false); 
        jbtnModificar.setEnabled(false);
        
        //ComboBox
        jcbDato.setEnabled(false);
        
        //TextField 
        jtfBusqueda.setEnabled(false);
        
        //Lista
        jtListaLibro.setEnabled(false);
        
        //Habilitar y hacer visibles los botones Confirmar y Cancelar
        
        jbtnConfirmar.setEnabled(true); jbtnConfirmar.setVisible(true);
        jbtnCancelar.setEnabled(true); jbtnCancelar.setVisible(true);
        ////////////////////////////////////////////////////////////////////////
        
        
    }//GEN-LAST:event_jbtnEliminarActionPerformed

    private void jbtnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnNuevoActionPerformed
        p.cargarNuevoLibro();
    }//GEN-LAST:event_jbtnNuevoActionPerformed

    private void jbtnConfirmarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnConfirmarActionPerformed
        //Habilita nuevamente los demas botones, deshabilita Confirmar y Cancelar, y procede a eliminar el libro de la base de datos
        try{
            int fila = jtListaLibro.getSelectedRow();
            
            lData.eliminarLibro(Long.parseLong(jtListaLibro.getValueAt(fila, 0).toString()));
        }catch(NumberFormatException e){
            System.out.println("eeeeeeeeee");
        }catch(ArrayIndexOutOfBoundsException ee){
            JOptionPane.showMessageDialog(null, "Seleccione un libro");
        }
        habilitacionE();
        
        
    }//GEN-LAST:event_jbtnConfirmarActionPerformed

    private void jbtnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnCancelarActionPerformed
        habilitacionE();
    }//GEN-LAST:event_jbtnCancelarActionPerformed

    private void jtListaLibroMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtListaLibroMouseClicked
        if(evt.getClickCount() >= 1 && jtListaLibro.getRowCount() > -1){
            jbtnModificar.setVisible(true); jbtnModificar.setEnabled(true);   
        }else{
            jbtnModificar.setVisible(false); jbtnModificar.setEnabled(false);
        }
        int fila = jtListaLibro.getSelectedRow();
        System.out.println(jtListaLibro.getValueAt(fila, 0));
        System.out.println(jtListaLibro.getValueAt(fila, 1));

        
    }//GEN-LAST:event_jtListaLibroMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jbtnBuscar;
    private javax.swing.JButton jbtnCancelar;
    private javax.swing.JButton jbtnConfirmar;
    private javax.swing.JButton jbtnEliminar;
    private javax.swing.JButton jbtnModificar;
    private javax.swing.JButton jbtnNuevo;
    private javax.swing.JComboBox<String> jcbDato;
    private javax.swing.JComboBox<String> jcbElejirEstado;
    private javax.swing.JTable jtListaLibro;
    private javax.swing.JTextField jtfBusqueda;
    // End of variables declaration//GEN-END:variables

    
    //Metodos para el armado de la tabla y el combo
    private void cargarTabla(){
    modelo.addColumn("ISBN");
    modelo.addColumn("Titulo");
    modelo.addColumn("Autor");
    modelo.addColumn("Año");
    modelo.addColumn("Genero");
    jtListaLibro.setModel(modelo);
    }
    private void cargarCombo(){
        jcbDato.addItem("ISBN");
        jcbDato.addItem("Titulo");
        jcbDato.addItem("Autor");
        jcbDato.addItem("Genero");
        jcbDato.addItem("Disponible");
    }
    private void cargarCombo2(){
        jcbElejirEstado.addItem("Disponible");
        jcbElejirEstado.addItem("No disponible");
    }
    private void limpiarTabla(JTable t){
        DefaultTableModel m = (DefaultTableModel)t.getModel();
        int filas = m.getRowCount();
        for (int i = filas - 1; i >= 0; i--){
            m.removeRow(i);
        }
    }

    private void habilitacionE(){
        //Habilitar los demas botones, volviendo al enfoque de buscar libros
        
        //Buscar
        jbtnBuscar.setEnabled(true);
        jbtnNuevo.setEnabled(true);
        jbtnModificar.setEnabled(true); 
        jbtnModificar.setEnabled(true);
        
        //ComboBox
        jcbDato.setEnabled(true);
        
        //TextField
        jtfBusqueda.setEnabled(true);
        
        //Lista
        jtListaLibro.setEnabled(true);
        
        //Deshabilitar y hacer invisibles los botones Confirmar y Cancelar
        
        jbtnConfirmar.setEnabled(false); jbtnConfirmar.setVisible(false);
        jbtnCancelar.setEnabled(false); jbtnConfirmar.setVisible(false);
    }
    
    private Libro libroSeleccionado(Libro libro){
        try{
            int fila = jtListaLibro.getSelectedRow();
            libro = lData.getLibroEspecifico(Long.parseLong(jtListaLibro.getValueAt(fila, 0).toString()));
        }catch(ArrayIndexOutOfBoundsException e){
            JOptionPane.showMessageDialog(null, "Seleccione un libro");
            libro = null;
        }
        return libro;
    
    }
    
}
