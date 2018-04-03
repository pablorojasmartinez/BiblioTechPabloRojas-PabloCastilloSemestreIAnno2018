/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.io.IOException;
import java.util.List;
import javax.swing.JInternalFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import data.BookFile;
import domain.Book;


/**
 *
 * @author Pablo Castillo
 */
public class ShowBooks extends JInternalFrame {

    JTable jtbPrueba;
    DefaultTableModel dtmModeloPrueba;

    public ShowBooks() throws IOException, ClassNotFoundException {
        super();
        // this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(800, 800);
        init();
        this.setVisible(true);
        this.setClosable(true);
    } // constructro

    private void init() throws IOException, ClassNotFoundException {
        BookFile archivo = new BookFile();

        this.dtmModeloPrueba = new DefaultTableModel();
        this.dtmModeloPrueba.addColumn("Type");
        this.dtmModeloPrueba.addColumn("Name");
        this.dtmModeloPrueba.addColumn("Code");
        this.dtmModeloPrueba.addColumn("Area");
        this.dtmModeloPrueba.addColumn("Total Amount");
        
        this.dtmModeloPrueba.addColumn("Availables");

        BookFile archivoLibros = new BookFile();
        List<Book> listaLibros = archivoLibros.arrays();
        for (int i = 0; i < listaLibros.size(); i++) {
            this.dtmModeloPrueba.addRow(new Object[]{listaLibros.get(i).getType(), listaLibros.get(i).getName(),listaLibros.get(i).getCode(),listaLibros.get(i).getArea(),
            listaLibros.get(i).getAmount(),listaLibros.get(i).getAvailable()});
        }

        this.jtbPrueba = new JTable(this.dtmModeloPrueba);

        JScrollPane scrollPane = new JScrollPane(this.jtbPrueba);
        this.getContentPane().add(scrollPane);
        System.out.println("tablajava.Ventana.init()");
    } // init

}
