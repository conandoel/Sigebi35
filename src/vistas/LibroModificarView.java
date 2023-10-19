
package vistas;
import entidades.Libro;
import java.awt.Color;
public class LibroModificarView extends javax.swing.JInternalFrame {
    Principal principal; LibroBuscarView lBuscar;
    
    public LibroModificarView(Principal p) {
        this.principal = p;
        setTitle("Modificar Libros");
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jlbISBN = new javax.swing.JLabel();
        jlbTitulo = new javax.swing.JLabel();
        jlbAutor = new javax.swing.JLabel();
        jlbAnio = new javax.swing.JLabel();
        jlbGenero = new javax.swing.JLabel();
        jlbEditorial = new javax.swing.JLabel();
        jlbEjemplares = new javax.swing.JLabel();
        jlbEstado = new javax.swing.JLabel();
        jtfISBN = new javax.swing.JTextField();
        jtfISBNmod = new javax.swing.JTextField();
        jtfTitulo = new javax.swing.JTextField();
        jtfTitulomod = new javax.swing.JTextField();
        jtfAutor = new javax.swing.JTextField();
        jtfAutormod = new javax.swing.JTextField();
        jtfAnio = new javax.swing.JTextField();
        jtfAniomod = new javax.swing.JTextField();
        jtfGenero = new javax.swing.JTextField();
        jtfGeneromod = new javax.swing.JTextField();
        jtfEditorial = new javax.swing.JTextField();
        jtfEditorialmod = new javax.swing.JTextField();
        jtfEjemplares = new javax.swing.JTextField();
        jtfEjemplaresmod = new javax.swing.JTextField();
        jlbDatoActual = new javax.swing.JLabel();
        jlbDatoMod = new javax.swing.JLabel();
        jrbEstado = new javax.swing.JRadioButton();
        jrbEstadomod = new javax.swing.JRadioButton();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setPreferredSize(new java.awt.Dimension(340, 397));

        jlbISBN.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jlbISBN.setText("ISBN:");

        jlbTitulo.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jlbTitulo.setText("Titulo:");

        jlbAutor.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jlbAutor.setText("Autor:");

        jlbAnio.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jlbAnio.setText("Año:");

        jlbGenero.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jlbGenero.setText("Genero:");

        jlbEditorial.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jlbEditorial.setText("Editorial:");

        jlbEjemplares.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jlbEjemplares.setText("Ejemplares:");

        jlbEstado.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jlbEstado.setText("Disponible:");

        jtfISBN.setEnabled(false);
        jtfISBN.setDisabledTextColor(Color.black);

        jtfTitulo.setDisabledTextColor(Color.black);
        jtfTitulo.setEnabled(false);

        jtfAutor.setEnabled(false);
        jtfAutor.setDisabledTextColor(Color.black);

        jtfAnio.setEnabled(false);
        jtfAnio.setDisabledTextColor(Color.black);

        jtfGenero.setEnabled(false);
        jtfGenero.setDisabledTextColor(Color.black);

        jtfEditorial.setEnabled(false);
        jtfEditorial.setDisabledTextColor(Color.black);

        jtfEjemplares.setEnabled(false);
        jtfEjemplares.setDisabledTextColor(Color.black);

        jlbDatoActual.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jlbDatoActual.setText("Actual:");

        jlbDatoMod.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jlbDatoMod.setText("Modificacion:");

        jButton1.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jButton1.setText("Modificar");

        jButton2.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jButton2.setText("Cancelar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jlbEstado, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jlbEditorial, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jlbEjemplares, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jlbGenero, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jlbAnio, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jlbAutor, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jlbTitulo, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jlbISBN, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton1)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jtfGenero, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jtfGeneromod, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jtfTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jtfTitulomod, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jtfAutor, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jtfAutormod, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jtfAnio, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jtfAniomod, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jtfEditorial, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jtfEditorialmod, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jtfISBN, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jlbDatoActual, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jtfISBNmod, javax.swing.GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
                                .addComponent(jlbDatoMod, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jtfEjemplares, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jrbEstado))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jrbEstadomod)
                                .addComponent(jtfEjemplaresmod, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jButton2)))))
                .addContainerGap(12, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlbDatoActual)
                    .addComponent(jlbDatoMod))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlbISBN)
                    .addComponent(jtfISBN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtfISBNmod, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlbTitulo)
                    .addComponent(jtfTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtfTitulomod, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlbAutor)
                    .addComponent(jtfAutor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtfAutormod, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlbAnio)
                    .addComponent(jtfAnio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtfAniomod, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlbGenero)
                    .addComponent(jtfGenero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtfGeneromod, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlbEditorial)
                    .addComponent(jtfEditorial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtfEditorialmod, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlbEjemplares)
                    .addComponent(jtfEjemplares, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtfEjemplaresmod, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jlbEstado)
                        .addComponent(jrbEstado))
                    .addComponent(jrbEstadomod))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addContainerGap(16, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        this.dispose();
    }//GEN-LAST:event_jButton2ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jlbAnio;
    private javax.swing.JLabel jlbAutor;
    private javax.swing.JLabel jlbDatoActual;
    private javax.swing.JLabel jlbDatoMod;
    private javax.swing.JLabel jlbEditorial;
    private javax.swing.JLabel jlbEjemplares;
    private javax.swing.JLabel jlbEstado;
    private javax.swing.JLabel jlbGenero;
    private javax.swing.JLabel jlbISBN;
    private javax.swing.JLabel jlbTitulo;
    private javax.swing.JRadioButton jrbEstado;
    private javax.swing.JRadioButton jrbEstadomod;
    private javax.swing.JTextField jtfAnio;
    private javax.swing.JTextField jtfAniomod;
    private javax.swing.JTextField jtfAutor;
    private javax.swing.JTextField jtfAutormod;
    private javax.swing.JTextField jtfEditorial;
    private javax.swing.JTextField jtfEditorialmod;
    private javax.swing.JTextField jtfEjemplares;
    private javax.swing.JTextField jtfEjemplaresmod;
    private javax.swing.JTextField jtfGenero;
    private javax.swing.JTextField jtfGeneromod;
    private javax.swing.JTextField jtfISBN;
    private javax.swing.JTextField jtfISBNmod;
    private javax.swing.JTextField jtfTitulo;
    private javax.swing.JTextField jtfTitulomod;
    // End of variables declaration//GEN-END:variables

    public void cargarDatosActuales(Libro libro){
        jtfISBN.setText(Long.toString(libro.getIsbn()));
        jtfTitulo.setText(libro.getTitulo());
        jtfAutor.setText(libro.getAutor());
        jtfAnio.setText(Integer.toString(libro.getAnio()));
        jtfEditorial.setText(libro.getEditorial());
        jtfEjemplares.setText(Integer.toString(libro.getCantEjemplares()));
        jtfGenero.setText(libro.getGenero());
        jrbEstado.setSelected(libro.isEstado());
    }



}
