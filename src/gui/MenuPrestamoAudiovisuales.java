
package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

/**
 *
 * @author Pablo Castillo
 */
public class MenuPrestamoAudiovisuales extends JInternalFrame implements ActionListener{
    JMenuBar barra;
    JMenu menu;
    JMenuItem item1,itemBuscarNombre;
    JDesktopPane des;
    JFrame ventana;
    String carnet;
    
  public MenuPrestamoAudiovisuales(JFrame fr,String carnet){
      this.carnet=carnet;
      ventana =fr;
   //this.setVisible(true);
  this.setSize(600, 600);
  this.setClosable(true);
  this.setFocusable(true);
  iniciarComponentes();
  
  }  
    
    
  public void iniciarComponentes(){
   this.barra=new JMenuBar();
   this.add(barra);
   
   this.menu=new JMenu("MENU");
   this.barra.add(menu);
   
   this.item1=new JMenuItem("buscar por codigo");
   this.menu.add(item1);
   
   this.itemBuscarNombre=new JMenuItem("buscar por nombre");
   this.menu.add(itemBuscarNombre);
   this.itemBuscarNombre.addActionListener(this);
      this.setJMenuBar(barra);
      item1.addActionListener(this);
   
  }

    @Override
    public void actionPerformed(ActionEvent ae) {
      if(ae.getSource()==item1){
      SearchAudioVisualByCode busqueda=new SearchAudioVisualByCode(this.ventana,carnet);
     this.ventana.add(busqueda);

      busqueda.setVisible(true);
      //his.di
      
                  this.dispose();
   
      }else if(ae.getSource()==itemBuscarNombre){
      
          SearchByNameAudiovisual busca=new SearchByNameAudiovisual(this.ventana,carnet);
      
      this.ventana.add(busca);
      busca.setVisible(true);
      this.dispose();
      
      }
      
    }
    
}
