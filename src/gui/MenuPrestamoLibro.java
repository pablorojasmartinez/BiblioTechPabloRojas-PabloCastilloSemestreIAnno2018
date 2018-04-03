/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
public class MenuPrestamoLibro extends JInternalFrame implements ActionListener{
     JMenuBar barra;
    JMenu menu;
    JMenuItem item1,itemBuscarNombre;
    JDesktopPane des;
    JFrame ventana;
    String carnet;
    
  public MenuPrestamoLibro(JFrame fr,String carnet){
      this.carnet=carnet;
      ventana =fr;
   //this.setVisible(true);
  this.setSize(600, 600);
  this.setClosable(true);
  this.setFocusable(true);
  this.setTitle("libros");
  
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
          SearchBookCode codigo=new SearchBookCode(this.ventana,carnet);
          this.ventana.add(codigo);
          codigo.setVisible(true);
          this.dispose();
//      BusquedaporCodigo busqueda=new BusquedaporCodigo(this.ventana,carnet);
//     this.ventana.add(busqueda);
//
//      busqueda.setVisible(true);
//      //his.di
//      
//                  this.dispose();
   
      }else if(ae.getSource()==itemBuscarNombre){
      SearchBookByName busqueda=new SearchBookByName(this.ventana, carnet);
      this.ventana.add(busqueda);
      busqueda.setVisible(true);
      this.dispose();
//          BuscaPorNombre busca=new BuscaPorNombre(this.ventana);
//      
//      this.ventana.add(busca);
//      busca.setVisible(true);
//      this.dispose();
      
      }
      
    }
}
