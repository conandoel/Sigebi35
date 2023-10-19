
package vistas;

import entidades.Libro;
import entidades.Autor;
import datos.LibroData;
import javax.swing.JOptionPane;

public class LibroNuevoView extends javax.swing.JInternalFrame {
    LibroData lData = new LibroData();
    
    public LibroNuevoView() {
        setTitle("Cargar Libro Nuevo");
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jlbISBN = new javax.swing.JLabel();
        jlbTitulo = new javax.swing.JLabel();
        jlbAutor = new javax.swing.JLabel();
        jlbGenero = new javax.swing.JLabel();
        jlbAnio = new javax.swing.JLabel();
        jlbEstado = new javax.swing.JLabel();
        jlbEjemplares = new javax.swing.JLabel();
        jtfAutor = new javax.swing.JTextField();
        jtfAnio = new javax.swing.JTextField();
        jtfGenero = new javax.swing.JTextField();
        jtfEjemplares = new javax.swing.JTextField();
        jtfISBN = new javax.swing.JTextField();
        jbtnAñadir = new javax.swing.JButton();
        jbtnCancelar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jtfEditorial = new javax.swing.JTextField();
        jrbEstado = new javax.swing.JRadioButton();
        jtfTitulo = new javax.swing.JTextField();

        setPreferredSize(new java.awt.Dimension(335, 400));

        jlbISBN.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jlbISBN.setText("ISBN:");

        jlbTitulo.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jlbTitulo.setText("Titulo:");

        jlbAutor.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jlbAutor.setText("Autor:");

        jlbGenero.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jlbGenero.setText("Genero:");

        jlbAnio.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jlbAnio.setText("Año:");

        jlbEstado.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jlbEstado.setText("Disponible:");

        jlbEjemplares.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jlbEjemplares.setText("Ejemplares:");

        jtfAutor.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N

        jtfAnio.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N

        jtfGenero.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N

        jtfEjemplares.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N

        jtfISBN.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N

        jbtnAñadir.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jbtnAñadir.setText("Añadir Libro");
        jbtnAñadir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnAñadirActionPerformed(evt);
            }
        });

        jbtnCancelar.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jbtnCancelar.setText("Cancelar");
        jbtnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnCancelarActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel1.setText("Editorial:");

        jtfTitulo.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(34, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jlbISBN, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jlbTitulo, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jlbAutor, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jlbAnio, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jlbGenero, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jlbEstado, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jlbEjemplares, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jbtnAñadir, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jtfAutor)
                    .addComponent(jtfAnio)
                    .addComponent(jtfGenero)
                    .addComponent(jtfEjemplares)
                    .addComponent(jtfISBN)
                    .addComponent(jbtnCancelar, javax.swing.GroupLayout.DEFAULT_SIZE, 132, Short.MAX_VALUE)
                    .addComponent(jtfEditorial)
                    .addComponent(jrbEstado)
                    .addComponent(jtfTitulo))
                .addGap(34, 34, 34))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlbISBN)
                    .addComponent(jtfISBN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlbTitulo)
                    .addComponent(jtfTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlbAutor)
                    .addComponent(jtfAutor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlbAnio)
                    .addComponent(jtfAnio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlbGenero)
                    .addComponent(jtfGenero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(11, 11, 11)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlbEstado)
                    .addComponent(jrbEstado))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlbEjemplares)
                    .addComponent(jtfEjemplares, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jtfEditorial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbtnCancelar)
                    .addComponent(jbtnAñadir))
                .addGap(20, 20, 20))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbtnAñadirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnAñadirActionPerformed
        
            Libro libro = new Libro();
            libro.setIsbn(Long.parseLong(jtfISBN.getText()));
            libro.setTitulo(jtfTitulo.getText());
            libro.setAutor(jtfAutor.getText());
            libro.setAnio(Integer.parseInt(jtfAnio.getText()));
            libro.setGenero(jtfGenero.getText());
            libro.setEditorial(jtfEditorial.getText());
            libro.setCantEjemplares(Integer.parseInt(jtfEjemplares.getText()));
            libro.setEstado(jrbEstado.isSelected());
            
            lData.guardarLibro(libro);
            
            
            
        
    }//GEN-LAST:event_jbtnAñadirActionPerformed

    private void jbtnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnCancelarActionPerformed
        this.dispose();
    }//GEN-LAST:event_jbtnCancelarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JButton jbtnAñadir;
    private javax.swing.JButton jbtnCancelar;
    private javax.swing.JLabel jlbAnio;
    private javax.swing.JLabel jlbAutor;
    private javax.swing.JLabel jlbEjemplares;
    private javax.swing.JLabel jlbEstado;
    private javax.swing.JLabel jlbGenero;
    private javax.swing.JLabel jlbISBN;
    private javax.swing.JLabel jlbTitulo;
    private javax.swing.JRadioButton jrbEstado;
    private javax.swing.JTextField jtfAnio;
    private javax.swing.JTextField jtfAutor;
    private javax.swing.JTextField jtfEditorial;
    private javax.swing.JTextField jtfEjemplares;
    private javax.swing.JTextField jtfGenero;
    private javax.swing.JTextField jtfISBN;
    private javax.swing.JTextField jtfTitulo;
    // End of variables declaration//GEN-END:variables
}
