/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package vistas;
//import javax.swing.*;

import datos.EjemplarData;
import datos.LibroData;
import datos.SocioData;
import entidades.Ejemplar;
import entidades.Libro;
import entidades.Socio;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.DefaultTableModel;


/**
 *
 * @author conandoel
 */
public class PrestamosView extends javax.swing.JInternalFrame {

    /**
     * Creates new form PrestamosView
     */
    List<Socio> socios=new ArrayList<>();
    List<Libro> libros=new ArrayList<>();
    List<Ejemplar> ejemplares=new ArrayList<>();
    private DefaultTableModel modelo=new DefaultTableModel();
    
    public PrestamosView() {
        initComponents();
        cargarLista();
        cargarLibros();
        cargarTabla();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel4 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jtfIdSocio = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jlNombre = new javax.swing.JLabel();
        jlApellido = new javax.swing.JLabel();
        jlDireccion = new javax.swing.JLabel();
        jlMail = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jtfLibroNombre = new javax.swing.JTextField();
        jlIsbn = new javax.swing.JLabel();
        jlAutor = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jtEjemplares = new javax.swing.JTable();

        jLabel4.setText("jLabel4");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(jTable1);

        jtfIdSocio.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jtfIdSocioKeyReleased(evt);
            }
        });

        jLabel1.setText("Lector:");

        jlNombre.setText("Nombre:");

        jlApellido.setText("Apellido:");

        jlDireccion.setText("Direccion:");

        jlMail.setText("E-Mail:");

        jLabel2.setText("Prestamos");

        jLabel3.setText("Libro:");

        jtfLibroNombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jtfLibroNombreKeyReleased(evt);
            }
        });

        jlIsbn.setText("ISBN: ");

        jlAutor.setText("Autor: ");

        jtEjemplares.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane2.setViewportView(jtEjemplares);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jSeparator1))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(39, 39, 39)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jlDireccion)
                                        .addGap(149, 149, 149)
                                        .addComponent(jlMail))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel1)
                                        .addGap(18, 18, 18)
                                        .addComponent(jtfIdSocio, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jlNombre)
                                        .addGap(124, 124, 124)
                                        .addComponent(jlApellido))))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(281, 281, 281)
                                .addComponent(jLabel2))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(39, 39, 39)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jlIsbn)
                                        .addGap(201, 201, 201)
                                        .addComponent(jlAutor))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel3)
                                        .addGap(18, 18, 18)
                                        .addComponent(jtfLibroNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 255, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 477, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(0, 104, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel2)
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtfIdSocio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(jlNombre)
                    .addComponent(jlApellido))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlDireccion)
                    .addComponent(jlMail))
                .addGap(18, 18, 18)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jtfLibroNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlIsbn)
                    .addComponent(jlAutor))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(58, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jtfIdSocioKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfIdSocioKeyReleased
        // TODO add your handling code here:
        limpiarLabels();
        if(jtfIdSocio.getText().equals("")){limpiarLabels();
        }else{
        for(Socio socio:socios){
            if(String.valueOf(socio.getIdSocio()).equals(jtfIdSocio.getText())){
                jlApellido.setText("Apellido: "+socio.getApellido());
                jlNombre.setText("Nombre: "+socio.getNombre());
                jlDireccion.setText("Direccion: "+socio.getDomicilio());
                jlMail.setText("E-Mail: "+socio.getMail());
            }
        }
        }
    }//GEN-LAST:event_jtfIdSocioKeyReleased

    private void jtfLibroNombreKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfLibroNombreKeyReleased
        // TODO add your handling code here:
        limpiarlabelslibros();
        limpiarTabla();
        if(jtfLibroNombre.getText().equals("")){
            limpiarlabelslibros();
            limpiarTabla();
        }else{
            for(Libro libro:libros){
                if(libro.getTitulo().equalsIgnoreCase(jtfLibroNombre.getText())){
                    //jlAutor.setText("Autor: "+libro.getAutor().getNombre()+" "+libro.getAutor().getApellido()); DAMIAN
                    jlAutor.setText("Autor: "+libro.getAutor());
                    jlIsbn.setText("ISBN: "+libro.getIsbn());
                    cargarEjemplares(libro);
                    
                }
            }
        }
    }//GEN-LAST:event_jtfLibroNombreKeyReleased
    private void cargarTabla(){
        modelo.addColumn("Codigo");
        modelo.addColumn("Estado");
        jtEjemplares.setModel(modelo);
    }
    private void cargarLista(){
        SocioData sd= new SocioData();
        socios=sd.buscarHistorialSocios("Estado", "1");
    }
    private void cargarLibros(){
        LibroData ld=new LibroData();
        libros=ld.listarLibroSinAutor();
    }
    private void cargarEjemplares(Libro libro){
        EjemplarData ed=new EjemplarData();
        ejemplares=null;
        System.out.println("pasa por carga de ejemplares");
        ejemplares=ed.listarEjemplares(libro);
        cargarTablaEjemplares();
    }
    
    private void cargarTablaEjemplares(){
        for(Ejemplar ejemplar:ejemplares){
        modelo.addRow(new Object[]{ejemplar.getCodigo(), ejemplar.getEstado()});
            System.out.println("Ejemplares"+ejemplar.getCodigo());
        
        }
    }
    
    private void limpiarLabels(){
        jlApellido.setText("Apellido: ");
                jlNombre.setText("Nombre: ");
                jlDireccion.setText("Direccion: ");
                jlMail.setText("E-Mail: ");
    }
    private void limpiarlabelslibros(){
        jlAutor.setText("Autor: ");
        jlIsbn.setText("ISBN: ");
    }
    
    private void limpiarTabla(){
        int f=modelo.getRowCount()-1;
        for(;f>=0;f--){
            modelo.removeRow(f);
        }
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel jlApellido;
    private javax.swing.JLabel jlAutor;
    private javax.swing.JLabel jlDireccion;
    private javax.swing.JLabel jlIsbn;
    private javax.swing.JLabel jlMail;
    private javax.swing.JLabel jlNombre;
    private javax.swing.JTable jtEjemplares;
    private javax.swing.JTextField jtfIdSocio;
    private javax.swing.JTextField jtfLibroNombre;
    // End of variables declaration//GEN-END:variables
}