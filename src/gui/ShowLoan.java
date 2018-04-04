/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import data.StudentFile;
import data.LoanFile;
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
public class ShowLoan extends JInternalFrame {

    //Attributes
    JTable jTable;
    DefaultTableModel dtmModeloPrueba;

    public ShowLoan() throws IOException, ClassNotFoundException {
        super();
        // this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(800, 800);
        this.setTitle("List of Loans");
        init();
        this.setVisible(true);
        this.setClosable(true);
    } // constructor

    private void init() throws IOException, ClassNotFoundException {
        this.dtmModeloPrueba = new DefaultTableModel();
        this.dtmModeloPrueba.addColumn("Id ");
        this.dtmModeloPrueba.addColumn("Book");
        this.dtmModeloPrueba.addColumn("Audiovisual");
        // this.dtmModeloPrueba.addColumn("libro");
        this.dtmModeloPrueba.addColumn("Start Date");
        this.dtmModeloPrueba.addColumn("End Date");
        LoanFile loanFile = new LoanFile();
        List<Loan> loanList = loanFile.returnLoanArray();
        for (int i = 0; i < loanList.size(); i++) {
            this.dtmModeloPrueba.addRow(new Object[]{loanList.get(i).getId(), loanList.get(i).getBook(), loanList.get(i).getAudio(),
                loanList.get(i).getEndDate(), loanList.get(i).getStartDate()});
        }
        this.jTable = new JTable(this.dtmModeloPrueba);
        JScrollPane scrollPane = new JScrollPane(this.jTable);
        this.getContentPane().add(scrollPane);
    } // init

}
