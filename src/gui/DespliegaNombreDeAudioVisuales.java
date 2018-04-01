package gui;

import data.ArchivoAudioVisuales;
import domain.Audiovisual;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Action;
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
public class DespliegaNombreDeAudioVisuales extends JInternalFrame implements ActionListener {
    
    JLabel etiqueta;
    JButton boton;
    JComboBox combo;
    JFrame ventana;
    List<String> personaList = new ArrayList<String>();
    String carnet;
      Audiovisual audiovisual;
    public DespliegaNombreDeAudioVisuales(JFrame fra, List<String> personaList2,String carnet) {
        this.ventana = fra;
        this.carnet=carnet;
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
                ArchivoAudioVisuales archivo = new ArchivoAudioVisuales();
                archivo.actualizarCantidad((String) this.combo.getSelectedItem());
              
                audiovisual=archivo.obtenerActorNombre((String) this.combo.getSelectedItem());
                
                
               // JOptionPane.showMessageDialog(null, this.combo.getSelectedItem());
            } catch (IOException ex) {
                Logger.getLogger(DespliegaNombreDeAudioVisuales.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(DespliegaNombreDeAudioVisuales.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        
        
    FechasPrestamoLibro calendario=new FechasPrestamoLibro(this.ventana,this.carnet,audiovisual);
     this.ventana.add(calendario);
      calendario.setVisible(true);
      this.dispose();
        
        }
    
    
    
    
    }
    
}
