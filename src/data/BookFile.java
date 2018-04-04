/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import domain.Book;

/**
 *
 * @author Pablo Rojas Martínez
 */
public class BookFile {

    //Attribute
    private String path;

    public BookFile() {
        this.path = "./FileBook.dat";
    }//constructor

    //Este método sirve para crear el archivo donde se guardará el objeto Book.
    public void createBookFile(Book book) throws IOException, ClassNotFoundException {
        File myFile = new File(this.path);
        List<Book> bookList = new ArrayList<Book>();
        if (myFile.exists()) {
            ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(myFile));
            Object aux = objectInputStream.readObject();
            bookList = (List<Book>) aux;
            objectInputStream.close();
        }
        bookList.add(book);
        ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream(myFile));
        output.writeUnshared(bookList);
        output.close();
    }//createBookFile

    //Este método sirve para validar que el nombre sea único en el archivo
    public boolean validateUniqueName(String name) throws IOException, ClassNotFoundException {
        File myFile = new File(this.path);
        List<Book> bookList = new ArrayList<Book>();
        if (myFile.exists()) {
            ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(myFile));
            Object aux = objectInputStream.readObject();
            bookList = (List<Book>) aux;
            objectInputStream.close();
        }
        Book book = null;
        for (int i = 0; i < bookList.size(); i++) {
            if (bookList.get(i).getName().equals(name)) {
                book = bookList.get(i);
                return true;
            }
        }
        return false;
    }//validateUniqueName

    //Este método sirve para  devolver un arraylist con el objeto Book 
    public List<Book> returnBookArray() throws IOException, ClassNotFoundException {
        File myFile = new File(this.path);
        List<Book> bookList = new ArrayList<Book>();
        if (myFile.exists()) {
            ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(myFile));
            Object aux = objectInputStream.readObject();
            bookList = (List<Book>) aux;
            objectInputStream.close();
        }
        return bookList;
    }//returnBookArray

    //Este método sirve para hacer el préstamo del material libro, si la variable nombre que recibe por parámetros
    // es igual a la variable nombre que trae el arrayList se restará una unidad a la variable disponible, lo cual significa
    //que el préstamo fue realizado.
    public boolean lendBook(String name) throws IOException, ClassNotFoundException {
        File myFile = new File(this.path);
        List<Book> bookList = new ArrayList<Book>();
        if (myFile.exists()) {
            ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(myFile));
            Object aux = objectInputStream.readObject();
            bookList = (List<Book>) aux;
            objectInputStream.close();
        }
        Book book = null;
        for (int i = 0; i < bookList.size(); i++) {
            if (bookList.get(i).getName().equals(name)) {
                if (bookList.get(i).getAvailable() == 0) {
                    JOptionPane.showMessageDialog(null, "At this time the book is not available");
                } else {
                    JOptionPane.showMessageDialog(null, "Book successfully requested");
                    book = bookList.get(i);
                    int amount = book.getAvailable() - 1;
                    book.setAvailable(amount);
                    bookList.set(i, book);
                }
            }
        }//for
        ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream(myFile));
        output.writeUnshared(bookList);
        output.close();
        return true;
    }//lendBook

//     // Este método sirve para devolver el libro que fue prestado, si la variable nombre que recibe por parámetros
    // es igual a la variable nombre que trae el arraylist entonces se suma una unidad a la variable disponible
    public boolean returnBook(String name) throws IOException, ClassNotFoundException {
        File myFile = new File(this.path);
        List<Book> bookList = new ArrayList<Book>();
        if (myFile.exists()) {
            ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(myFile));
            Object aux = objectInputStream.readObject();
            bookList = (List<Book>) aux;
            objectInputStream.close();
        }
        Book book = null;
        for (int i = 0; i < bookList.size(); i++) {
            if (bookList.get(i).getCode().equals(name)) {
                if (bookList.get(i).getAvailable() == 0) {
                } else {
                    book = bookList.get(i);
                    int canti = book.getAvailable() + 1;
                    book.setAvailable(canti);
                    bookList.set(i, book);
                }
            }
        }//for i
        ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream(myFile));
        output.writeUnshared(bookList);
        output.close();
        return true;
    }//returnBook

}
