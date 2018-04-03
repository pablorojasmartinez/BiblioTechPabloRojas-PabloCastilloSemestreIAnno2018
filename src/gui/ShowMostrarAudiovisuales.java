/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package gui;

import data.AudiovisualFile;
import data.StudentFile;
import domain.Audiovisual;
import java.io.IOException;
import java.util.List;
import javax.swing.JInternalFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 * 
 * @author Pablo Rojas Martínez
 */
public class ShowMostrarAudiovisuales extends JInternalFrame {
JTable jtbPrueba;
    DefaultTableModel dtmModeloPrueba;

    public ShowMostrarAudiovisuales() throws IOException, ClassNotFoundException {
        super();
        // this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(800, 800);
        init();
        this.setVisible(true);
        this.setClosable(true);
    } // constructro

    private void init() throws IOException, ClassNotFoundException {
        StudentFile archivo = new StudentFile();

        this.dtmModeloPrueba = new DefaultTableModel();
        this.dtmModeloPrueba.addColumn("Type");
        this.dtmModeloPrueba.addColumn("Code");
        this.dtmModeloPrueba.addColumn("Brand");
        
        this.dtmModeloPrueba.addColumn("Made Year");
        this.dtmModeloPrueba.addColumn("Total Amount");
        this.dtmModeloPrueba.addColumn("Availables");

        AudiovisualFile archi = new AudiovisualFile();
        List<Audiovisual> productoList = archi.arrays();
        for (int i = 0; i < productoList.size(); i++) {
            this.dtmModeloPrueba.addRow(new Object[]{productoList.get(i).getType(), productoList.get(i).getCode(), productoList.get(i).getBrand(),productoList.get(i).getMadeYear(),
                productoList.get(i).amount(),productoList.get(i).getAvailable()});
        }

        this.jtbPrueba = new JTable(this.dtmModeloPrueba);

        JScrollPane scrollPane = new JScrollPane(this.jtbPrueba);
        this.getContentPane().add(scrollPane);
        System.out.println("tablajava.Ventana.init()");
    } // init
}
