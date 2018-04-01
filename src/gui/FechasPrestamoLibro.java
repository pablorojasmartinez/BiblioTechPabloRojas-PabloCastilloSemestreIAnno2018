/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import data.ArchivoPrestamos;
import domain.Audiovisual;
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
 * @author Pablo Rojas Martínez
 */
public class FechasPrestamoLibro extends javax.swing.JInternalFrame {

    /**
     * Creates new form calendario
     */
    String carnet;
    Audiovisual audioVisual;
    public FechasPrestamoLibro(JFrame frame,String carnet,Audiovisual audio) {
        audioVisual=audio;
        
        this.carnet=carnet;
        JOptionPane.showMessageDialog(null, audio+" carnet"+carnet);
        initComponents();
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton3 = new javax.swing.JButton();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        jDateChooser2 = new com.toedter.calendar.JDateChooser();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);

        jButton3.setText("Aceptar");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 59, Short.MAX_VALUE)
                .addComponent(jDateChooser2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(84, 84, 84)
                .addComponent(jButton3)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jDateChooser2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jButton3)
                .addContainerGap(36, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents



    
    //Este metodo revisa si las fechas son antes y después
        public boolean metodo(){
           Date date1 ,date2 = new Date();
           SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
           
           date1=jDateChooser1.getDate();
        date2=jDateChooser2.getDate();
        
            if(date1.before(date2)){
           // JOptionPane.showMessageDialog(null, dateFormat.format(date1)+"Es antes"+dateFormat.format(date2));
           return true;
        }
        else{
            //JOptionPane.showMessageDialog(null, dateFormat.format(date1)+"es después"+dateFormat.format(date2));
            return false;
        }
    }
    
        
 
    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        try {
           
    Date date1, date2 = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        date1 = jDateChooser1.getDate();
        date2 = jDateChooser2.getDate();
   String fecha1, fecha2;
        fecha1 = dateFormat.format(date1);
        fecha2 = dateFormat.format(date2);  
            
          if(date1.before(date2)){
              
          
            ArchivoPrestamos archivo=new ArchivoPrestamos();
            Loan prestamo=new Loan(date1, date2, carnet, audioVisual, null);
            archivo.guardarLibro(prestamo);
            
            
          
                List<Loan> personaList = new ArrayList<Loan>();
                personaList=archivo.arrays();
                
                
//                for(int i=0;i<personaList.size();i++){
//                JOptionPane.showMessageDialog(null,personaList.get(i) );
//                
//                }
            
          }
          else{
              JOptionPane.showMessageDialog(null,"Error con las fechas");
          }
          this.dispose();
        } catch (IOException ex) {
            Logger.getLogger(FechasPrestamoLibro.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(FechasPrestamoLibro.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton3ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton3;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private com.toedter.calendar.JDateChooser jDateChooser2;
    // End of variables declaration//GEN-END:variables
}
