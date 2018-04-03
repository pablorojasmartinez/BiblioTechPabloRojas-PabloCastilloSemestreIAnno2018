/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import domain.Audiovisual;
import domain.Book;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Pablo Rojas Martínez
 */
public class AudiovisualFile {

    private String path;

    public AudiovisualFile() {
        this.path = "ArchivoAudioVisuales";
    }//const

    public void guardarAudioVisual(Audiovisual actor) throws IOException, ClassNotFoundException {
        File myFile = new File(this.path);
        List<Audiovisual> personaList = new ArrayList<Audiovisual>();

        if (myFile.exists()) {
            ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(myFile));
            Object aux = objectInputStream.readObject();
            personaList = (List<Audiovisual>) aux;
            objectInputStream.close();
        }//if(myFile.exists())

        personaList.add(actor);
        ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream(myFile));
        output.writeUnshared(personaList);
        output.close();
    }//guardarPersona
    
    
    public boolean validarCodigoUnico(int cedula) throws IOException, ClassNotFoundException {
        File myFile = new File(this.path);

        List<Audiovisual> personaList = new ArrayList<Audiovisual>();
        if (myFile.exists()) {
            ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(myFile));
            Object aux = objectInputStream.readObject();
            personaList = (List<Audiovisual>) aux;
            objectInputStream.close();
        }//if(myFile.exists())

        Audiovisual persona = null;
        for (int i = 0; i < personaList.size(); i++) {
            if (personaList.get(i).getCode()==cedula) {
                persona = personaList.get(i);
                return true;//rompe el for, aquí se pone porque sino retornaría null, porq asi fue inicializado antes
            }//if(personaList.get(i).getCedula().equals(cedula))
        }//for i

        return false;
    }//obtenerPersona
    

    public Audiovisual obtenerActorNombre(String nombre) throws IOException, ClassNotFoundException {
        File myFile = new File(this.path);

        List<Audiovisual> personaList = new ArrayList<Audiovisual>();
        if (myFile.exists()) {
            ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(myFile));
            Object aux = objectInputStream.readObject();
            personaList = (List<Audiovisual>) aux;
            objectInputStream.close();
        }//if(myFile.exists())

        Audiovisual persona = null;
        for (int i = 0; i < personaList.size(); i++) {
            if (personaList.get(i).getBrand().equals(nombre)) {
                persona = personaList.get(i);
                break;//rompe el for, aquí se pone porque sino retornaría null, porq asi fue inicializado antes
            }//if(personaList.get(i).getCedula().equals(codigo))
        }//for i

        return persona;
    }//obtenerPersona
//    
    public boolean obtenerActorNombreBoolean(Audiovisual codigo) throws IOException, ClassNotFoundException {
        File myFile = new File(this.path);

        List<Audiovisual> personaList = new ArrayList<Audiovisual>();
        if (myFile.exists()) {
            ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(myFile));
            Object aux = objectInputStream.readObject();
            personaList = (List<Audiovisual>) aux;
            objectInputStream.close();
        }//if(myFile.exists())
        boolean prueba = true;
        Audiovisual persona = null;
        for (int i = 0; i < personaList.size(); i++) {
//            JOptionPane.showMessageDialog(null,personaList.get(i).getCode());
//            if(personaList.size()==0){
//                    prueba=false;
//                guardarAudioVisual(codigo);
//            }
            if (personaList.get(i).getCode() == (codigo.getCode())) {
                // persona = personaList.get(i);
                prueba = true;
                //return true;//rompe el for, aquí se pone porque sino retornaría null, porq asi fue inicializado antes
            } else {
                prueba = false;
                //return false;
            }//if(personaList.get(i).getCedula().equals(codigo))
        }//for i
        return prueba;

    }//obtenerPersona

    public boolean obtenerActorNombreBoolean2(int codigo) throws IOException, ClassNotFoundException {
        File myFile = new File(this.path);

        List<Audiovisual> personaList = new ArrayList<Audiovisual>();
        if (myFile.exists()) {
            ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(myFile));
            Object aux = objectInputStream.readObject();
            personaList = (List<Audiovisual>) aux;
            objectInputStream.close();
        }//if(myFile.exists())
        boolean prueba = true;
        Audiovisual persona = null;
        for (int i = 0; i < personaList.size(); i++) {

            if (personaList.get(i).getCode() == codigo) {
                // persona = personaList.get(i);
                prueba = true;
                //return true;//rompe el for, aquí se pone porque sino retornaría null, porq asi fue inicializado antes
            } else {
                prueba = false;
                //return false;
            }//if(personaList.get(i).getCedula().equals(codigo))
        }//for i
        return prueba;

    }//obtenerPersona

//    
//    
//    public boolean actualizarActor(Actor actor) throws IOException, ClassNotFoundException {
//        File myFile = new File(this.path);
//
//        List<Actor> personaList = new ArrayList<Actor>();
//        if (myFile.exists()) {
//            ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(myFile));
//            Object aux = objectInputStream.readObject();
//            personaList = (List<Actor>) aux;
//            objectInputStream.close();
//        }//if(myFile.exists())
//
//        Actor persona = null;
//        for (int i = 0; i < personaList.size(); i++) {
//            if (personaList.get(i).getIdActor().equals(actor.getIdActor())) {
//                persona = personaList.get(i);
//                personaList.set(i, actor);
//                //rompe el for, aquí se pone porque sino retornaría null, porq asi fue inicializado antes
//            }//if(personaList.get(i).getCedula().equals(cedula))
//        }//for i
//
//        ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream(myFile));
//        output.writeUnshared(personaList);
//        output.close();
//        
//        return true;
//    }//obtenerPersona
//    
    public List<Audiovisual> arrays() throws IOException, ClassNotFoundException {
        File myFile = new File(this.path);

        List<Audiovisual> personaList = new ArrayList<Audiovisual>();
        if (myFile.exists()) {
            ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(myFile));
            Object aux = objectInputStream.readObject();
            personaList = (List<Audiovisual>) aux;
            objectInputStream.close();
        }//if(myFile.exists())

        return personaList;
    }//obtenerPersona

    public boolean actualizarCantidadDeAudiovirestar(int codigo) throws IOException, ClassNotFoundException {
        File myFile = new File(this.path);

        List<Audiovisual> personaList = new ArrayList<Audiovisual>();
        if (myFile.exists()) {
            ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(myFile));
            Object aux = objectInputStream.readObject();
            personaList = (List<Audiovisual>) aux;
            objectInputStream.close();
        }//if(myFile.exists())

        Audiovisual persona = null;
        for (int i = 0; i < personaList.size(); i++) {
            if (personaList.get(i).getCode() == (codigo)) {
                if (personaList.get(i).getAvailable() == 0) {
                    JOptionPane.showMessageDialog(null, "En este momento el material no esta disponible");

                } else {
                    JOptionPane.showMessageDialog(null, "audiovisual pedido exitosamente");
                    persona = personaList.get(i);
                    int canti = persona.getAvailable() - 1;
                    persona.setAvailable(canti);
                    personaList.set(i, persona);
                }
                //rompe el for, aquí se pone porque sino retornaría null, porq asi fue inicializado antes
            } else {
                JOptionPane.showMessageDialog(null, "el codigo no corresponde a ningun audivisual registrado");

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
        List<Audiovisual> personaList = new ArrayList<Audiovisual>();
        List<String> personaList2 = new ArrayList<String>();
        String vect[];
        personaList = arrays();
        String letra1 = null, letra2 = null;
        for (int i = 0; i < personaList.size(); i++) {
            
            if (text.equalsIgnoreCase(personaList.get(i).getBrand())) {
                personaList2.add(personaList.get(i).getBrand());
            } else if (text.length() <= (personaList.get(i).getBrand()).length()) {
                for (int j = 0; j < text.length(); j++) {
                    letra1 += text.charAt(j);
                    letra2 += personaList.get(i).getBrand().charAt(j);
                    if (letra1.equalsIgnoreCase(letra2)) {
                        // JOptionPane.showMessageDialog(null, text.length());
                        verificar = true;
                        
                    } else {
                        verificar = false;
                        break;
                    }
                    
                }
                if (verificar == true) {
                    personaList2.add(personaList.get(i).getBrand());
                }
                //JOptionPane.showMessageDialog(null, "no existe el articulo");
            }
//         if(verificar=false){
//          personaList2.add(personaList.get(i).getBrand());   
//         }

        }
        
        return (ArrayList<String>) personaList2;
        
    }//fsearch
    
    public boolean actualizarCantidad(String nombre) throws IOException, ClassNotFoundException {
        File myFile = new File(this.path);

        List<Audiovisual> personaList = new ArrayList<Audiovisual>();
        if (myFile.exists()) {
            ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(myFile));
            Object aux = objectInputStream.readObject();
            personaList = (List<Audiovisual>) aux;
            objectInputStream.close();
        }//if(myFile.exists())

        Audiovisual persona = null;
        for (int i = 0; i < personaList.size(); i++) {
            if (personaList.get(i).getBrand().equals(nombre)) {
                if (personaList.get(i).getAvailable() == 0) {
                  //  JOptionPane.showMessageDialog(null, "En este momento el material no esta disponible");

                } else {
                  //  JOptionPane.showMessageDialog(null, "audiovisual pedido exitosamente");
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

    
     public Audiovisual obtenerActorNombre2(String codigo) throws IOException, ClassNotFoundException {
        File myFile = new File(this.path);

        List<Audiovisual> personaList = new ArrayList<Audiovisual>();
        if (myFile.exists()) {
            ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(myFile));
            Object aux = objectInputStream.readObject();
            personaList = (List<Audiovisual>) aux;
            objectInputStream.close();
        }//if(myFile.exists())

        Audiovisual persona = null;
        for (int i = 0; i < personaList.size(); i++) {
            if (personaList.get(i).getCode()==(Integer.parseInt(codigo))) {
                persona = personaList.get(i);
                break;//rompe el for, aquí se pone porque sino retornaría null, porq asi fue inicializado antes
            }//if(personaList.get(i).getCedula().equals(codigo))
        }//for i

        return persona;
    }//obtenerPersona
//    
    
 public boolean actualizarCantidadAumentando(String marca) throws IOException, ClassNotFoundException {
        File myFile = new File(this.path);

        List<Audiovisual> personaList = new ArrayList<Audiovisual>();
        if (myFile.exists()) {
            ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(myFile));
            Object aux = objectInputStream.readObject();
            personaList = (List<Audiovisual>) aux;
            objectInputStream.close();
        }//if(myFile.exists())

        Audiovisual persona = null;
        for (int i = 0; i < personaList.size(); i++) {
            if (personaList.get(i).getBrand().equals(marca)) {
                if (personaList.get(i).getAvailable()== 0) {
                   // JOptionPane.showMessageDialog(null, "En este momento el material no esta disponible");

                } else {
                    //JOptionPane.showMessageDialog(null, "audio pedido exitosamente");
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
