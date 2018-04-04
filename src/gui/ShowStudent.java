/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import data.StudentFile;
import domain.Student;
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
public class ShowStudent extends JInternalFrame {

    //Attributes
    JTable jTable;
    DefaultTableModel dtmModeloPrueba;

    public ShowStudent() throws IOException {
        super();
        this.setSize(800, 800);
        this.setTitle("List of Students");
        init();
        this.setVisible(true);
        this.setClosable(true);
    } // constructor

    private void init() throws IOException {
        StudentFile studentFile = new StudentFile();
        this.dtmModeloPrueba = new DefaultTableModel();
        this.dtmModeloPrueba.addColumn("Name");
        this.dtmModeloPrueba.addColumn("Lastname");
        this.dtmModeloPrueba.addColumn("Identification");

        StudentFile studentFile1 = new StudentFile();
        List<Student> studentList = studentFile1.searchStudent();
        for (int i = 0; i < studentList.size(); i++) {
            this.dtmModeloPrueba.addRow(new Object[]{studentList.get(i).getLastName(), studentList.get(i).getName(), studentList.get(i).getId().getChain()});
        }
        this.jTable = new JTable(this.dtmModeloPrueba);
        JScrollPane scrollPane = new JScrollPane(this.jTable);
        this.getContentPane().add(scrollPane);
    } // init
}
