/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import data.AudiovisualFile;
import data.BookFile;
import data.LoanFile;
import domain.Loan;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author Pablo Castillo
 */
public class FechaDevolucion extends javax.swing.JInternalFrame {

    /**
     * Creates new form FechaDevolucion
     */
    JFrame ventana;
    String carnet,tipo;
    public FechaDevolucion(JFrame fra,String carnet,String tipo) {
        this.ventana=fra;
        this.carnet=carnet;
        this.tipo=tipo;
        initComponents();
    }
 public void multasLibros(String nombre){
        
        Date date = new Date();
         SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
         date = jDateChooser1.getDate();
         String fecha=dateFormat.format(date);
         
         
         
        try {
            LoanFile archivo=new LoanFile();
            
            List<Loan> personaList = new ArrayList<Loan>();
            personaList=archivo.arrays();
            for(int i=0; i<personaList.size();i++){
                if(personaList.get(i).getBook().getName().equals(nombre)){
                    if(date.after(personaList.get(i).getEndDate())){
                        JOptionPane.showMessageDialog(null, "Usted tiene una multa de $20 por devolver el libro después de la fecha indicada");
                    }
                    else{
                        JOptionPane.showMessageDialog(null, "Ha devuelto el libro a tiempo");
                    }
                   
                   
                }
            }
        } catch (IOException ex) {
            Logger.getLogger(FechaDevolucion.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(FechaDevolucion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
 
 
 public void multasAudio(String nombre){
        
        Date date = new Date();
         SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
         date = jDateChooser1.getDate();
         String fecha=dateFormat.format(date);
         
         
         
        try {
            LoanFile archivo=new LoanFile();
            
            List<Loan> personaList = new ArrayList<Loan>();
            personaList=archivo.arrays();
            for(int i=0; i<personaList.size();i++){
                if(personaList.get(i).getAudio().getBrand().equals(nombre)){
                    if(date.after(personaList.get(i).getEndDate())){
                        JOptionPane.showMessageDialog(null, "Usted tiene una multa de $20 por devolver el libro después de la fecha indicada");
                    }
                    else{
                        JOptionPane.showMessageDialog(null, "Ha devuelto el libro a tiempo");
                    }
                   
                   
                }
            }
        } catch (IOException ex) {
            Logger.getLogger(FechaDevolucion.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(FechaDevolucion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jtfNombre = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();

        setClosable(true);

        jLabel1.setText("Fecha entrega");

        jButton1.setText("aceptar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel2.setText("Ingresar Nombre");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(jtfNombre, javax.swing.GroupLayout.DEFAULT_SIZE, 71, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(jButton1)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButton1)
                    .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel2)
                        .addComponent(jtfNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(203, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
//        String 
//        if(tipo.equals("libro")){
//            try {
//                LoanFile archivo=new LoanFile();
//                BookFile libros=new BookFile();
//                Loan prestamo=archivo.getBook(jTextField1.getText(),this.carnet,this.tipo);
//                JOptionPane.showMessageDialog(null,prestamo);
//                
//                if(prestamo!=null){
//                libros.updateQuantityIncreasing(prestamo.getBook().getCode());
//                
//                    archivo.borrarLibro(prestamo.getBook().getCode());
//                }else{
//                JOptionPane.showMessageDialog(null,"el prestamo no existe");
//                }
//            } catch (IOException ex) {
//                Logger.getLogger(FechaDevolucion.class.getName()).log(Level.SEVERE, null, ex);
//            } catch (ClassNotFoundException ex) {
//                Logger.getLogger(FechaDevolucion.class.getName()).log(Level.SEVERE, null, ex);
//            }
//        
//        }else if(tipo.equals("audio")){
//            try {
//                LoanFile archivo=new LoanFile();
//                AudiovisualFile audio=new AudiovisualFile();
//                Loan prestamo=archivo.getBook(jTextField1.getText(),this.carnet,this.tipo);
//                JOptionPane.showMessageDialog(null,prestamo);
//                audio.updateQuantityIncreasing((prestamo.getAudio().getBrand()));
//                
//                archivo.borrarAudio(prestamo.getAudio().getBrand());
//            } catch (IOException ex) {
//                Logger.getLogger(FechaDevolucion.class.getName()).log(Level.SEVERE, null, ex);
//            } catch (ClassNotFoundException ex) {
//                Logger.getLogger(FechaDevolucion.class.getName()).log(Level.SEVERE, null, ex);
//            }
//                
//        }
        
        
        
          if(tipo.equals("libro")){
            try {
                LoanFile archivo=new LoanFile();
              
                
                BookFile libros=new BookFile();
                Loan prestamo=archivo.obtenerLibro(jtfNombre.getText(),this.carnet,this.tipo);
                JOptionPane.showMessageDialog(null,prestamo);
                
                if(prestamo!=null){
                    multasLibros(jtfNombre.getText());
                libros.updateQuantityIncreasing(prestamo.getBook().getCode());
                
                    archivo.borrarLibro(prestamo.getBook().getCode());
                }else{
                JOptionPane.showMessageDialog(null,"el prestamo no existe");
                }
            } catch (IOException ex) {
                Logger.getLogger(FechaDevolucion.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(FechaDevolucion.class.getName()).log(Level.SEVERE, null, ex);
            }
        
        }else if(tipo.equals("audio")){
            try {
                LoanFile archivo=new LoanFile();
                AudiovisualFile audio=new AudiovisualFile();
                Loan prestamo=archivo.obtenerLibro(jtfNombre.getText(),this.carnet,this.tipo);
                JOptionPane.showMessageDialog(null,prestamo);
                multasAudio(jtfNombre.getText());
                audio.actualizarCantidadAumentando((prestamo.getAudio().getBrand()));
                
                archivo.borrarAudio(prestamo.getAudio().getBrand());
            } catch (IOException ex) {
                Logger.getLogger(FechaDevolucion.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(FechaDevolucion.class.getName()).log(Level.SEVERE, null, ex);
            }
                
        }
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JTextField jtfNombre;
    // End of variables declaration//GEN-END:variables
}
