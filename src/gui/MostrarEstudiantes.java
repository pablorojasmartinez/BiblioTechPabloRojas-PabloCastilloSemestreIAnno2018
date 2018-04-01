/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package gui;

import data.ArchivoEstudiante;
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
public class MostrarEstudiantes extends JInternalFrame{
JTable jtbPrueba;
    DefaultTableModel dtmModeloPrueba;

    public MostrarEstudiantes() throws IOException {
        super();
        // this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(800, 800);
        init();
        this.setVisible(true);
        this.setClosable(true);
        
    } // constructro

    private void init() throws IOException {
        ArchivoEstudiante archivo = new ArchivoEstudiante();

        this.dtmModeloPrueba = new DefaultTableModel();
        this.dtmModeloPrueba.addColumn("Nombre");
        this.dtmModeloPrueba.addColumn("Apellido");
        this.dtmModeloPrueba.addColumn("Carnet");

        ArchivoEstudiante archi = new ArchivoEstudiante();
        List<Student> productoList = archi.buscarPorNombreTodos();
        for (int i = 0; i < productoList.size(); i++) {
            this.dtmModeloPrueba.addRow(new Object[]{productoList.get(i).getLastName(), productoList.get(i).getName(), productoList.get(i).getId().getChain()});
        }

        this.jtbPrueba = new JTable(this.dtmModeloPrueba);

        JScrollPane scrollPane = new JScrollPane(this.jtbPrueba);
        this.getContentPane().add(scrollPane);
        System.out.println("tablajava.Ventana.init()");
    } // init
}
