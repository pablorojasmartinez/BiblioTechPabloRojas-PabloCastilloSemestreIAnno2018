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
public class ArchivoLibros {
    
    private String path;
    
    public ArchivoLibros() {
        this.path = "ArchivoLibros";
    }

    public void guardarLibro(Book libro) throws IOException, ClassNotFoundException {
        File myFile = new File(this.path);
        List<Book> listaLibros = new ArrayList<Book>();
        
        if (myFile.exists()) {
            ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(myFile));
            Object aux = objectInputStream.readObject();
            listaLibros = (List<Book>) aux;
            objectInputStream.close();
        }//if(myFile.exists())

        listaLibros.add(libro);
        ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream(myFile));
        output.writeUnshared(listaLibros);
        output.close();
    }//guardarPersona
    
    public Book obtenerActorNombre(String nombre) throws IOException, ClassNotFoundException {
        File myFile = new File(this.path);
        
        List<Book> personaList = new ArrayList<Book>();
        if (myFile.exists()) {
            ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(myFile));
            Object aux = objectInputStream.readObject();
            personaList = (List<Book>) aux;
            objectInputStream.close();
        }//if(myFile.exists())

        Book persona = null;
        for (int i = 0; i < personaList.size(); i++) {
            if (personaList.get(i).getName().equals(nombre)) {
                persona = personaList.get(i);
                break;//rompe el for, aquí se pone porque sino retornaría null, porq asi fue inicializado antes
            }//if(personaList.get(i).getCedula().equals(cedula))
        }//for i

        return persona;
    }//obtenerPersona
    
    public boolean validarNombreUnico(String nombre) throws IOException, ClassNotFoundException {
        File myFile = new File(this.path);
        
        List<Book> personaList = new ArrayList<Book>();
        if (myFile.exists()) {
            ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(myFile));
            Object aux = objectInputStream.readObject();
            personaList = (List<Book>) aux;
            objectInputStream.close();
        }//if(myFile.exists())

        Book persona = null;
        for (int i = 0; i < personaList.size(); i++) {
            if (personaList.get(i).getName().equals(nombre)) {
                persona = personaList.get(i);
                return true;//rompe el for, aquí se pone porque sino retornaría null, porq asi fue inicializado antes
            }//if(personaList.get(i).getCedula().equals(cedula))
        }//for i

        return false;
    }//obtenerPersona

//    public static void main(String args []) throws IOException, ClassNotFoundException{
//        Book libro = new Book("tipo2", "carlos","codigo2", 10, "area2", 10);
//        ArchivoLibros  al = new ArchivoLibros();
//        al.guardarLibro(libro);
//       System.out.println( libro.toString());
//        JOptionPane.showMessageDialog(null, al.obtenerActorNombre("carlos"));
//    }
    public List<Book> arrays() throws IOException, ClassNotFoundException {
        File myFile = new File(this.path);
        
        List<Book> personaList = new ArrayList<Book>();
        if (myFile.exists()) {
            ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(myFile));
            Object aux = objectInputStream.readObject();
            personaList = (List<Book>) aux;
            objectInputStream.close();
        }//if(myFile.exists())

        return personaList;
    }//obtenerPersona

    public boolean actualizarCantidadDeAudiovi(String codigo) throws IOException, ClassNotFoundException {
        File myFile = new File(this.path);
        
        List<Book> personaList = new ArrayList<Book>();
        if (myFile.exists()) {
            ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(myFile));
            Object aux = objectInputStream.readObject();
            personaList = (List<Book>) aux;
            objectInputStream.close();
        }//if(myFile.exists())

        Book persona = null;
        for (int i = 0; i < personaList.size(); i++) {
            if (personaList.get(i).getCode().equals(codigo)) {
                if (personaList.get(i).getAvailable() == 0) {
                    JOptionPane.showMessageDialog(null, "En este momento el material no esta disponible");
                    
                } else {
                    JOptionPane.showMessageDialog(null, "libro pedido exitosamente");
                    persona = personaList.get(i);
                    int canti = persona.getAvailable() - 1;
                    persona.setAvailable(canti);
                    personaList.set(i, persona);
                }
                //rompe el for, aquí se pone porque sino retornaría null, porq asi fue inicializado antes
            } else {
                //JOptionPane.showMessageDialog(null, "el codigo no corresponde a ningun audivisual registrado");

            }

//if(personaList.get(i).getCedula().equals(cedula))
        }//for i

        ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream(myFile));
        output.writeUnshared(personaList);
        output.close();
        
        return true;
    }//obtenerPersona

    public ArrayList<String> search(String text) throws IOException, ClassNotFoundException {
        boolean verificar = false;
        boolean verifica2 = false;
        List<Book> personaList = new ArrayList<Book>();
        List<String> personaList2 = new ArrayList<String>();
        String vect[];
        personaList = arrays();
        String letra1 = null, letra2 = null;
        for (int i = 0; i < personaList.size(); i++) {
            
            if (text.equalsIgnoreCase(personaList.get(i).getName())) {
                personaList2.add(personaList.get(i).getName());
            } else if (text.length() <= (personaList.get(i).getName()).length()) {
                for (int j = 0; j < text.length(); j++) {
                    letra1 += text.charAt(j);
                    letra2 += personaList.get(i).getName().charAt(j);
                    if (letra1.equalsIgnoreCase(letra2)) {
                        // JOptionPane.showMessageDialog(null, text.length());
                        verificar = true;
                        
                    } else {
                        verificar = false;
                        break;
                    }
                    
                }
                if (verificar == true) {
                    personaList2.add(personaList.get(i).getName());
                }
                //JOptionPane.showMessageDialog(null, "no existe el articulo");
            }
//         if(verificar=false){
//          personaList2.add(personaList.get(i).getMarca());   
//         }

        }
        
        return (ArrayList<String>) personaList2;
        
    }//fsearch

    public boolean actualizarCantidad(String nombre) throws IOException, ClassNotFoundException {
        File myFile = new File(this.path);
        
        List<Book> personaList = new ArrayList<Book>();
        if (myFile.exists()) {
            ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(myFile));
            Object aux = objectInputStream.readObject();
            personaList = (List<Book>) aux;
            objectInputStream.close();
        }//if(myFile.exists())

        Book persona = null;
        for (int i = 0; i < personaList.size(); i++) {
            if (personaList.get(i).getName().equals(nombre)) {
                if (personaList.get(i).getAvailable() == 0) {
                    JOptionPane.showMessageDialog(null, "En este momento el material no esta disponible");
                    
                } else {
                    JOptionPane.showMessageDialog(null, "libro pedido exitosamente");
                    persona = personaList.get(i);
                    int canti = persona.getAvailable() - 1;
                    persona.setAvailable(canti);
                    personaList.set(i, persona);
                }
                //rompe el for, aquí se pone porque sino retornaría null, porq asi fue inicializado antes
            } else {
                // JOptionPane.showMessageDialog(null, "el codigo no corresponde a ningun audivisual registrado");

            }

//if(personaList.get(i).getCedula().equals(cedula))
        }//for i

        ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream(myFile));
        output.writeUnshared(personaList);
        output.close();
        
        return true;
    }//obtenerPersona

    public Book obtenerLibro(String nombre) throws IOException, ClassNotFoundException {
        File myFile = new File(this.path);
        
        List<Book> personaList = new ArrayList<Book>();
        if (myFile.exists()) {
            ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(myFile));
            Object aux = objectInputStream.readObject();
            personaList = (List<Book>) aux;
            objectInputStream.close();
        }//if(myFile.exists())

        Book persona = null;
        for (int i = 0; i < personaList.size(); i++) {
            if (personaList.get(i).getName().equals(nombre)) {
                persona = personaList.get(i);
                break;//rompe el for, aquí se pone porque sino retornaría null, porq asi fue inicializado antes
            }//if(personaList.get(i).getCedula().equals(codigo))
        }//for i

        return persona;
    }//obtenerPersona
//    
    
    public Book obtenerActorNombre2(String codigo) throws IOException, ClassNotFoundException {
        File myFile = new File(this.path);
        
        List<Book> personaList = new ArrayList<Book>();
        if (myFile.exists()) {
            ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(myFile));
            Object aux = objectInputStream.readObject();
            personaList = (List<Book>) aux;
            objectInputStream.close();
        }//if(myFile.exists())

        Book persona = null;
        for (int i = 0; i < personaList.size(); i++) {
            if (personaList.get(i).getCode().equals((codigo))) {
                persona = personaList.get(i);
                break;//rompe el for, aquí se pone porque sino retornaría null, porq asi fue inicializado antes
            }//if(personaList.get(i).getCedula().equals(codigo))
        }//for i

        return persona;
    }//obtenerPersona
    
    public boolean actualizarCantidadAumentando(String nombre) throws IOException, ClassNotFoundException {
        File myFile = new File(this.path);
        
        List<Book> personaList = new ArrayList<Book>();
        if (myFile.exists()) {
            ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(myFile));
            Object aux = objectInputStream.readObject();
            personaList = (List<Book>) aux;
            objectInputStream.close();
        }//if(myFile.exists())

        Book persona = null;
        for (int i = 0; i < personaList.size(); i++) {
            if (personaList.get(i).getCode().equals(nombre)) {
                if (personaList.get(i).getAvailable() == 0) {
                    // JOptionPane.showMessageDialog(null, "En este momento el material no esta disponible");

                } else {
                    //JOptionPane.showMessageDialog(null, "libro pedido exitosamente");
                    persona = personaList.get(i);
                    int canti = persona.getAvailable() + 1;
                    persona.setAvailable(canti);
                    personaList.set(i, persona);
                }
                //rompe el for, aquí se pone porque sino retornaría null, porq asi fue inicializado antes
            } else {
                // JOptionPane.showMessageDialog(null, "el codigo no corresponde a ningun audivisual registrado");

            }

//if(personaList.get(i).getCedula().equals(cedula))
        }//for i

        ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream(myFile));
        output.writeUnshared(personaList);
        output.close();
        
        return true;
    }//obtenerPersona
    
}
