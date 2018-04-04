/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import domain.Loan;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
//import javax.swing.JOptionPane;

/**
 *
 * @author Pablo Castillo
 */
public class LoanFile {

    //Attribute
    private String path;

    public LoanFile() {
        this.path = "./LoanFile.dat";
    }//constructor

    //Este método sirve para crear el archivo donde se guardará el objeto Loan.
    public void createLoanFile(Loan loan) throws IOException, ClassNotFoundException {
        File myFile = new File(this.path);
        List<Loan> loanList = new ArrayList<Loan>();
        if (myFile.exists()) {
            ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(myFile));
            Object aux = objectInputStream.readObject();
            loanList = (List<Loan>) aux;
            objectInputStream.close();
        }//if
        loanList.add(loan);
        ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream(myFile));
        output.writeUnshared(loanList);
        output.close();
    }//createLoanFile

    //Este método sirve para  devolver un arraylist con el objeto Book 
    public List<Loan> returnLoanArray() throws IOException, ClassNotFoundException {
        File myFile = new File(this.path);
        List<Loan> loanList = new ArrayList<Loan>();
        if (myFile.exists()) {
            ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(myFile));
            Object aux = objectInputStream.readObject();
            loanList = (List<Loan>) aux;
            objectInputStream.close();
        }//if
        return loanList;
    }//returnLoanArray

    //Este método sirve para borrar el  objeto libro en el  archivo  de préstamo una vez que la devolución fue exitosa.
    public Loan deleteBook(String code) throws FileNotFoundException, IOException, ClassNotFoundException {
        File myFile = new File(this.path);
        List<Loan> loanList = new ArrayList<Loan>();
        if (myFile.exists()) {
            ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(myFile));
            Object aux = objectInputStream.readObject();
            loanList = (List<Loan>) aux;
        }//exists
        Loan loan = null;
        for (int i = 0; i < loanList.size(); i++) {
            if (loanList.get(i).getBook() != null) {
                if (loanList.get(i).getBook().getCode().equals(code)) {
                    loan = loanList.remove(i);
                    break;
                }//if
            }
        }// for i
        ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream(myFile));
        output.writeUnshared(loanList);
        output.close();
        return loan;
    }//deleleLoan

    //Este método sirve para borrar el  objeto audiovisual en el  archivo  de préstamo una vez que la devolución fue exitosa.
    public Loan deleteAudiovisual(String code) throws FileNotFoundException, IOException, ClassNotFoundException {
        File myFile = new File(this.path);
        List<Loan> loanList = new ArrayList<Loan>();
        if (myFile.exists()) {
            ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(myFile));
            Object aux = objectInputStream.readObject();
            loanList = (List<Loan>) aux;
        }
        Loan loan = null;
        for (int i = 0; i < loanList.size(); i++) {
            if (loanList.get(i).getAudio() != null) {
                if (loanList.get(i).getAudio().getBrand().equals(code)) {
                    loan = loanList.remove(i);
                    break;
                }//if
            }
        }// for i
        ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream(myFile));
        output.writeUnshared(loanList);
        output.close();
        return loan;
    }//deleteAudiovisual
}
