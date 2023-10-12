package vistas;

import entidades.Libro;
import datos.LibroData;
import java.util.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class LibroBuscarView extends javax.swing.JInternalFrame {
    private DefaultTableModel modelo = new DefaultTableModel();
    LibroData lData;
    Libro libro;
    List<Libro> libros = new ArrayList<>();

    public LibroBuscarView() {

        initComponents();
        cargarTabla();
        cargarCombo();
        
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

        jcbDato.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
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
        jbtnEliminar.setText("Eliminar");
        jbtnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnEliminarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(21, 21, 21)
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jcbDato, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(36, 36, 36)
                                .addComponent(jtfBusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jbtnBuscar))
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jbtnModificar)
                                .addGap(18, 18, 18)
                                .addComponent(jbtnEliminar)))
                        .addGap(0, 0, Short.MAX_VALUE)))
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
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jbtnModificar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jbtnEliminar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(19, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jcbDatoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbDatoActionPerformed
        jtfBusqueda.setText("");//Limpia el text field cuando se cambia el filtro del combobox
    }//GEN-LAST:event_jcbDatoActionPerformed

    private void jbtnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnBuscarActionPerformed
        
        String condicion = (String)(jcbDato.getSelectedItem());//Lee el filtro en el combo box por el que se quiere listar los libros
        
        switch(condicion){
            case("ISBN"):
                libros = lData.buscarLibroPorISBN(Integer.parseInt(jtfBusqueda.getText()));
            case("Autor"):
                libros = lData.buscarLibroPorAutor(jtfBusqueda.getText());
            case("")://Si filtro esta vacio(si por alguna razon queda vacio), avisara que no puede estarlo
                JOptionPane.showMessageDialog(null, "Filtro de busqueda vacio");
            default:
                libros = lData.buscarLibroPorTituloGenero(condicion, jtfBusqueda.getText());
        }
        
        Iterator<Libro> iterador = libros.iterator();
        
        if(iterador.hasNext()){
            
            limpiarTabla();
            
            while(iterador.hasNext()){//Llena la tabla con la lista de libros encontrados en la base de datos
                
                libro = iterador.next();
                
                modelo.addRow(new Object[] {libro.getIsbn(), libro.getTitulo(), libro.getAutor().getNombre(), libro.getAnio(),
                                            libro.getGenero(), libro.getCantEjemplares()});
                
            }
        }
        
    }//GEN-LAST:event_jbtnBuscarActionPerformed

    private void jbtnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnModificarActionPerformed
        //Debe enviarte a otra vista para modificar el libro seleccionado. Me quede sin tiempo. Mañana
    }//GEN-LAST:event_jbtnModificarActionPerformed

    private void jbtnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnEliminarActionPerformed
        //Hacer algo para la confirmacion.qsy, mañana
    }//GEN-LAST:event_jbtnEliminarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jbtnBuscar;
    private javax.swing.JButton jbtnEliminar;
    private javax.swing.JButton jbtnModificar;
    private javax.swing.JComboBox<String> jcbDato;
    private javax.swing.JTable jtListaLibro;
    private javax.swing.JTextField jtfBusqueda;
    // End of variables declaration//GEN-END:variables

    private void cargarTabla(){
    modelo.addColumn("ISBN");
    modelo.addColumn("Titulo");
    modelo.addColumn("Autor");
    modelo.addColumn("Año de publicación");
    modelo.addColumn("Genero");
    modelo.addColumn("Cantidad de ejemplares");
    }
    private void cargarCombo(){
        jcbDato.addItem("ISBN");
        jcbDato.addItem("Titulo");
        jcbDato.addItem("Autor");
        jcbDato.addItem("Genero");
    }
    private void limpiarTabla(){
        for(int i = 0; i < jtListaLibro.getRowCount(); i++){
            modelo.removeRow(i);
            i-= 1;
        }
    }
}
