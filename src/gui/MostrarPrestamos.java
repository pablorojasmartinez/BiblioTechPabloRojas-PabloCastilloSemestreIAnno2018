/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import data.ArchivoAudioVisuales;
import data.ArchivoEstudiante;
import data.ArchivoPrestamos;
import domain.Audiovisual;
import domain.Loan;
import java.io.IOException;
import java.util.List;
import javax.swing.JInternalFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Pablo Castillo
 */

public class MostrarPrestamos extends JInternalFrame {
    JTable jtbPrueba;
    DefaultTableModel dtmModeloPrueba;
     public MostrarPrestamos() throws IOException, ClassNotFoundException {
        super();
        // this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(800, 800);
        init();
        this.setVisible(true);
        this.setClosable(true);
    } // constructro

    private void init() throws IOException, ClassNotFoundException {
        ArchivoEstudiante archivo = new ArchivoEstudiante();

        this.dtmModeloPrueba = new DefaultTableModel();
        this.dtmModeloPrueba.addColumn("Libro");
        this.dtmModeloPrueba.addColumn("Carnet");
        this.dtmModeloPrueba.addColumn("libro");
        this.dtmModeloPrueba.addColumn("audivisuales ");
        this.dtmModeloPrueba.addColumn("Fecha final");
        this.dtmModeloPrueba.addColumn("Fecha inicio");

        ArchivoPrestamos archi = new ArchivoPrestamos();
        List<Loan> productoList = archi.arrays();
        for (int i = 0; i < productoList.size(); i++) {
            this.dtmModeloPrueba.addRow(new Object[]{productoList.get(i).getBook(), productoList.get(i).getId(), productoList.get(i).getBook(),
                productoList.get(i).getAudio(),productoList.get(i).getEndDate(),productoList.get(i).getStartDate()});
        }

        this.jtbPrueba = new JTable(this.dtmModeloPrueba);

        JScrollPane scrollPane = new JScrollPane(this.jtbPrueba);
        this.getContentPane().add(scrollPane);
        System.out.println("tablajava.Ventana.init()");
    } // init
    
}
