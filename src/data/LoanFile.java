/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import domain.Audiovisual;
import domain.Student;
import domain.Book;
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

    private String path;

    public LoanFile() {
        this.path = "ArchivoPrestamos";
    }

    public void guardarLibro(Loan libro) throws IOException, ClassNotFoundException {
        File myFile = new File(this.path);
        List<Loan> listaLibros = new ArrayList<Loan>();

        if (myFile.exists()) {
            ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(myFile));
            Object aux = objectInputStream.readObject();
            listaLibros = (List<Loan>) aux;
            objectInputStream.close();
        }//if(myFile.exists())

        listaLibros.add(libro);
        ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream(myFile));
        output.writeUnshared(listaLibros);
        output.close();
    }//guardarPersona

    public List<Loan> arrays() throws IOException, ClassNotFoundException {
        File myFile = new File(this.path);

        List<Loan> personaList = new ArrayList<Loan>();
        if (myFile.exists()) {
            ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(myFile));
            Object aux = objectInputStream.readObject();
            personaList = (List<Loan>) aux;
            objectInputStream.close();
        }//if(myFile.exists())

        return personaList;
    }//obtenerPersona

    public boolean buscarCarnet(String carnet) throws IOException, ClassNotFoundException {
        boolean result = false;
        List<Loan> personaList = new ArrayList<Loan>();
        personaList = arrays();
        for (int i = 0; i < personaList.size(); i++) {
            Loan productoActual = personaList.get(i);
            if (productoActual != null) {
                if (productoActual.getId().equals(carnet)) {
                    result = true;
                    break;
                } else {
                    result = false;
                }

                //} // if nombre.equals.
            }//if prodctoActual != null
        }//for
        return result;

    }
    
    
    public Loan borrarLibro(String cedula) throws FileNotFoundException, IOException, ClassNotFoundException{
        File  myFile = new File(this.path);
        List<Loan> personaList = new ArrayList<Loan>();
        if(myFile.exists()){
            ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(myFile));
            
            Object aux= objectInputStream.readObject();
            personaList=(List<Loan>)aux;
        }//exists
        
        Loan persona =null;
        
        for (int i = 0; i < personaList.size(); i++) {
            if(personaList.get(i).getBook().getCode().equals(cedula)){
                persona=personaList.remove(i);
                
                break;
            }//if
        }// for i
         ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream(myFile));
        output.writeUnshared(personaList);
        output.close();
        
        return persona;
    }//borrarPersona
    
    public Loan borrarAudio(String cedula) throws FileNotFoundException, IOException, ClassNotFoundException{
        File  myFile = new File(this.path);
        List<Loan> personaList = new ArrayList<Loan>();
        if(myFile.exists()){
            ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(myFile));
            
            Object aux= objectInputStream.readObject();
            personaList=(List<Loan>)aux;
        }//exists
        
        Loan persona =null;
        
        for (int i = 0; i < personaList.size(); i++) {
            if(personaList.get(i).getAudio().getBrand().equals(cedula)){
                persona=personaList.remove(i);
                
                break;
            }//if
        }// for i
         ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream(myFile));
        output.writeUnshared(personaList);
        output.close();
        
        return persona;
    }//borrarPersona

    public Loan obtenerActorNombre2(String codigo, String carnet) throws IOException, ClassNotFoundException {
        File myFile = new File(this.path);

        List<Loan> personaList = new ArrayList<Loan>();
        if (myFile.exists()) {
            ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(myFile));
            Object aux = objectInputStream.readObject();
            personaList = (List<Loan>) aux;
            objectInputStream.close();
        }//if(myFile.exists())

        Loan persona = null;
        for (int i = 0; i < personaList.size(); i++) {
            if (personaList.get(i).getId() == ((carnet))) {
                if (personaList.get(i).getBook().getCode() == codigo) {
                    persona = personaList.get(i);
                    break;//rompe el for, aquí se pone porque sino retornaría null, porq asi fue inicializado antes
                }
            }//if(personaList.get(i).getCedula().equals(codigo))
        }//for i

        return persona;
    }//obtenerPersona  

    public Loan obtenerLibro(String nombre, String carnet, String tipo) throws IOException, ClassNotFoundException {
        File myFile = new File(this.path);

        List<Loan> personaList = new ArrayList<Loan>();
        if (myFile.exists()) {
            ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(myFile));
            Object aux = objectInputStream.readObject();
            personaList = (List<Loan>) aux;
            objectInputStream.close();
        }//if(myFile.exists())

        Loan persona = null;
        for (int i = 0; i < personaList.size(); i++) {
            if (personaList.get(i).getId().equals(carnet)) {
//                JOptionPane.showMessageDialog(null, personaList.get(i));
//                JOptionPane.showMessageDialog(null, tipo);

                if (personaList.get(i).getBook() != null) {
                    if (personaList.get(i).getBook().getName().equals(nombre)) {
                        persona = personaList.get(i);
                        break;//rompe el for, aquí se pone porque sino retornaría null, porq asi fue inicializado antes
                    }
                    
                    

                } else {
                       if (personaList.get(i).getAudio().getBrand().equals(nombre)) {
                    persona = personaList.get(i);
                    break;//rompe el for, aquí se pone porque sino retornaría null, porq asi fue inicializado antes
                       }
                }

            }//if(personaList.get(i).getCedula().equals(codigo))
        }//for i

        return persona;
    }//obtenerPersona

}
