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
public class ShowAudiovisuales extends JInternalFrame {
    //Attributes

    JTable jTable;
    DefaultTableModel dtmModeloPrueba;

    public ShowAudiovisuales() throws IOException, ClassNotFoundException {
        super();
        // this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(800, 800);
        this.setTitle("List of Audiovisuals");
        init();
        this.setVisible(true);
        this.setClosable(true);
    } // constructor

    private void init() throws IOException, ClassNotFoundException {
        StudentFile studentFile = new StudentFile();
        this.dtmModeloPrueba = new DefaultTableModel();
        this.dtmModeloPrueba.addColumn("Type");
        this.dtmModeloPrueba.addColumn("Code");
        this.dtmModeloPrueba.addColumn("Brand");
        this.dtmModeloPrueba.addColumn("Made Year");
        this.dtmModeloPrueba.addColumn("Total Amount");
        this.dtmModeloPrueba.addColumn("Availables");
        AudiovisualFile audiovisualFile = new AudiovisualFile();
        List<Audiovisual> audiovisualList = audiovisualFile.returnAudioVisualArray();
        for (int i = 0; i < audiovisualList.size(); i++) {
            this.dtmModeloPrueba.addRow(new Object[]{audiovisualList.get(i).getType(), audiovisualList.get(i).getCode(), audiovisualList.get(i).getBrand(), audiovisualList.get(i).getMadeYear(),
                audiovisualList.get(i).amount(), audiovisualList.get(i).getAvailable()});
        }
        this.jTable = new JTable(this.dtmModeloPrueba);
        JScrollPane scrollPane = new JScrollPane(this.jTable);
        this.getContentPane().add(scrollPane);
    } // init
}
