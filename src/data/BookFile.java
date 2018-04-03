/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import domain.Audiovisual;
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
    
    private String path;
    
    public BookFile() {
        this.path = "FileBook";
    }

    public void saveBook(Book book) throws IOException, ClassNotFoundException {
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
    }//saveBook
    
//    public Book obtenerActorNombre(String nombre) throws IOException, ClassNotFoundException {
//        File myFile = new File(this.path);
//        
//        List<Book> personaList = new ArrayList<Book>();
//        if (myFile.exists()) {
//            ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(myFile));
//            Object aux = objectInputStream.readObject();
//            personaList = (List<Book>) aux;
//            objectInputStream.close();
//        }//if(myFile.exists())
//
//        Book persona = null;
//        for (int i = 0; i < personaList.size(); i++) {
//            if (personaList.get(i).getName().equals(nombre)) {
//                persona = personaList.get(i);
//                break;//rompe el for, aquí se pone porque sino retornaría null, porq asi fue inicializado antes
//            }//if(personaList.get(i).getCedula().equals(cedula))
//        }//for i
//
//        return persona;
//    }//obtenerPersona
    
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


    public List<Book> arrays() throws IOException, ClassNotFoundException {
        File myFile = new File(this.path);
        
        List<Book> bookList = new ArrayList<Book>();
        if (myFile.exists()) {
            ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(myFile));
            Object aux = objectInputStream.readObject();
            bookList = (List<Book>) aux;
            objectInputStream.close();
        }

        return bookList;
    }

    public boolean updateAmountOfBooks(String name) throws IOException, ClassNotFoundException {
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
            } else {
                //JOptionPane.showMessageDialog(null, "el codigo no corresponde a ningun audivisual registrado");

            }

        }

        ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream(myFile));
        output.writeUnshared(bookList);
        output.close();
        
        return true;
    }
 

    
    public ArrayList<String> search(String text) throws IOException, ClassNotFoundException {
        boolean check = false;
     //   boolean verifica2 = false;
        List<Book> bookList = new ArrayList<Book>();
        List<String> bookList2 = new ArrayList<String>();
       // String vect[];
        bookList = arrays();
        String letter1 = null, letter2 = null;
        for (int i = 0; i < bookList.size(); i++) {
            
            if (text.equalsIgnoreCase(bookList.get(i).getName())) {
                bookList2.add(bookList.get(i).getName());
            } else if (text.length() <= (bookList.get(i).getName()).length()) {
                for (int j = 0; j < text.length(); j++) {
                    letter1 += text.charAt(j);
                    letter2 += bookList.get(i).getName().charAt(j);
                    if (letter1.equalsIgnoreCase(letter2)) {
                        // JOptionPane.showMessageDialog(null, text.length());
                        check = true;
                        
                    } else {
                        check = false;
                        break;
                    }
                    
                }
                if (check == true) {
                    bookList2.add(bookList.get(i).getName());
                }
                //JOptionPane.showMessageDialog(null, "no existe el articulo");
            }
//         if(verificar=false){
//          personaList2.add(personaList.get(i).getMarca());   
//         }

        }
        
        return (ArrayList<String>) bookList2;
        
    }//fsearch

//    public boolean updateAmount(String nombre) throws IOException, ClassNotFoundException {
//        File myFile = new File(this.path);
//        
//        List<Book> personaList = new ArrayList<Book>();
//        if (myFile.exists()) {
//            ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(myFile));
//            Object aux = objectInputStream.readObject();
//            personaList = (List<Book>) aux;
//            objectInputStream.close();
//        }//if(myFile.exists())
//
//        Book persona = null;
//        for (int i = 0; i < personaList.size(); i++) {
//            if (personaList.get(i).getName().equals(nombre)) {
//                if (personaList.get(i).getAvailable() == 0) {
//                    JOptionPane.showMessageDialog(null, "At this time the book is not available");
//                    
//                } else {
//                    JOptionPane.showMessageDialog(null, "libro pedido exitosamente");
//                    persona = personaList.get(i);
//                    int canti = persona.getAvailable() - 1;
//                    persona.setAvailable(canti);
//                    personaList.set(i, persona);
//                }
//                //rompe el for, aquí se pone porque sino retornaría null, porq asi fue inicializado antes
//            } else {
//                // JOptionPane.showMessageDialog(null, "el codigo no corresponde a ningun audivisual registrado");
//
//            }
//
////if(personaList.get(i).getCedula().equals(cedula))
//        }//for i
//
//        ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream(myFile));
//        output.writeUnshared(personaList);
//        output.close();
//        
//        return true;
//    }//obtenerPersona

    public Book getBook(String name) throws IOException, ClassNotFoundException {
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
                break;//rompe el for, aquí se pone porque sino retornaría null, porq asi fue inicializado antes
            }//if(personaList.get(i).getCedula().equals(codigo))
        }//for i

        return book;
    }//obtenerPersona
//    
    
    public Book searchByCode(String code) throws IOException, ClassNotFoundException {
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
            if (bookList.get(i).getCode().equals((code))) {
                book = bookList.get(i);
                break;
            }
        }

        return book;
    }
    
    public boolean updateQuantityIncreasing(String name) throws IOException, ClassNotFoundException {
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
                    // JOptionPane.showMessageDialog(null, "En este momento el material no esta disponible");

                } else {
                    //JOptionPane.showMessageDialog(null, "libro pedido exitosamente");
                    book = bookList.get(i);
                    int canti = book.getAvailable() + 1;
                    book.setAvailable(canti);
                    bookList.set(i, book);
                }
                //rompe el for, aquí se pone porque sino retornaría null, porq asi fue inicializado antes
            } else {
                // JOptionPane.showMessageDialog(null, "el codigo no corresponde a ningun audivisual registrado");

            }

//if(personaList.get(i).getCedula().equals(cedula))
        }//for i

        ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream(myFile));
        output.writeUnshared(bookList);
        output.close();
        
        return true;
    }
    
}
