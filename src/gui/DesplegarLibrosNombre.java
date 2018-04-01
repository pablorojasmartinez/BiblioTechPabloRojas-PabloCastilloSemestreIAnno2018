/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import data.ArchivoAudioVisuales;
import data.ArchivoLibros;
import domain.Book;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

/**
 *
 * @author Pablo Castillo
 */
public class DesplegarLibrosNombre extends JInternalFrame implements ActionListener{
    
     JLabel etiqueta;
    JButton boton;
    JComboBox combo;
    JFrame ventana;
    String carnet;
    List<String> personaList = new ArrayList<String>();
    
    public DesplegarLibrosNombre(JFrame fra, List<String> personaList2,String carne) {
        this.ventana = fra;
        this.carnet=carne;
        this.personaList = personaList2;
        this.setLayout(new FlowLayout());
        this.setVisible(true);
        this.setSize(600, 400);
        this.setClosable(true);
        iniciar();
    }
    
    public void iniciar() {
        this.etiqueta = new JLabel("nombres:");
        this.add(etiqueta);
        
        this.combo = new JComboBox();
        for (int i = 0; i < this.personaList.size(); i++) {
            this.combo.addItem(personaList.get(i));
        }
        this.add(combo);
        
        this.boton = new JButton("pedir");
        this.add(boton);
        this.boton.addActionListener(this);
    }
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == boton) {
            try {
                ArchivoLibros archivo = new ArchivoLibros();
                archivo.actualizarCantidad((String) this.combo.getSelectedItem());
                
                Book libro;
                libro=archivo.obtenerLibro((String) this.combo.getSelectedItem());
                
                
                  FechaPrestamoAudioVisual calendario2=new FechaPrestamoAudioVisual(this.ventana,this.carnet,libro);
     this.ventana.add(calendario2);
      calendario2.setVisible(true);
      this.dispose();
               // JOptionPane.showMessageDialog(null, this.combo.getSelectedItem());
            } catch (IOException ex) {
                Logger.getLogger(DespliegaNombreDeAudioVisuales.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(DespliegaNombreDeAudioVisuales.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
    }
    
}
