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

    //Attributes
    JTable jTable;
    DefaultTableModel dtmModeloPrueba;

    public ShowBooks() throws IOException, ClassNotFoundException {
        super();
        this.setSize(800, 800);
        this.setTitle("List of Books");
        init();
        this.setVisible(true);
        this.setClosable(true);
    } // constructor

    private void init() throws IOException, ClassNotFoundException {
        BookFile bookFile = new BookFile();
        this.dtmModeloPrueba = new DefaultTableModel();
        this.dtmModeloPrueba.addColumn("Type");
        this.dtmModeloPrueba.addColumn("Name");
        this.dtmModeloPrueba.addColumn("Code");
        this.dtmModeloPrueba.addColumn("Area");
        this.dtmModeloPrueba.addColumn("Total Amount");
        this.dtmModeloPrueba.addColumn("Availables");

        BookFile bookFile1 = new BookFile();
        List<Book> bookList = bookFile1.returnBookArray();
        for (int i = 0; i < bookList.size(); i++) {
            this.dtmModeloPrueba.addRow(new Object[]{bookList.get(i).getType(), bookList.get(i).getName(), bookList.get(i).getCode(), bookList.get(i).getArea(),
                bookList.get(i).getAmount(), bookList.get(i).getAvailable()});
        }
        this.jTable = new JTable(this.dtmModeloPrueba);
        JScrollPane scrollPane = new JScrollPane(this.jTable);
        this.getContentPane().add(scrollPane);
    } // init

}
