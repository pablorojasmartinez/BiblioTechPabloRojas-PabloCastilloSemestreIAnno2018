/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import data.StudentFile;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyVetoException;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author Pablo Castillo
 */
public class VerificaEstudiante extends JInternalFrame implements ActionListener{
    JTextField campoTexto;
    JLabel etiquetaNombre;
    JButton btnaceptar;

     JDesktopPane j;
      private JFrame ventanaPrincipal;
    public VerificaEstudiante(JFrame v){
         
        //j=desto;
        ventanaPrincipal=v;
     this.setVisible(true);
        this.setSize(600,400);
        this.setClosable(true);

    iniciarComponentes();
    }
    public void iniciarComponentes(){
         j=new JDesktopPane();
         j.setLayout(new FlowLayout());
          this.add(j);
      
     this.etiquetaNombre=new JLabel("ingrese carnet");
     this.j.add(etiquetaNombre);
     
     this.campoTexto=new JTextField(10);
        this.j.add(this.campoTexto);
        
        this.btnaceptar=new JButton("aceptar");
        this.j.add(this.btnaceptar);
        this.btnaceptar.addActionListener(this);
    }
    
    
    
    
    
    @Override
    public void actionPerformed(ActionEvent ae) {
      if(ae.getSource()==btnaceptar){
          
       
          try {
              StudentFile archi=new StudentFile();
              
              boolean result= archi.buscarCarnet(this.campoTexto.getText());
              if(result==true){
                  //JOptionPane.showMessageDialog(null,"entro");
                  TipoPtrestamo pedir=new TipoPtrestamo(this.ventanaPrincipal,campoTexto.getText());
                  this.ventanaPrincipal.add(pedir);
                  pedir.setVisible(true);
                  this.dispose();
                  
              }else{
                  JOptionPane.showMessageDialog(null,"no existe el usuario");
              }
          } catch (IOException ex) {
              Logger.getLogger(VerificaEstudiante.class.getName()).log(Level.SEVERE, null, ex);
          } catch (PropertyVetoException ex) {
              Logger.getLogger(VerificaEstudiante.class.getName()).log(Level.SEVERE, null, ex);
          }
            
      
       
          
      }
    }
    
}
