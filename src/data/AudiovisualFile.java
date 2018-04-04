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

/**
 *
 * @author Pablo Rojas Martínez
 */
public class AudiovisualFile {

    //Attribute
    private String path;

    public AudiovisualFile() {
        this.path = "./AudiovisualFile.dat";
    }//constuctor

    //Este método sirve para crear el archivo donde se guardará el objeto Audiovisual.
    public void createAudiovisualFile(Audiovisual audiovisual) throws IOException, ClassNotFoundException {
        File myFile = new File(this.path);
        List<Audiovisual> audiovisualList = new ArrayList<Audiovisual>();
        if (myFile.exists()) {
            ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(myFile));
            Object aux = objectInputStream.readObject();
            audiovisualList = (List<Audiovisual>) aux;
            objectInputStream.close();
        }//if
        audiovisualList.add(audiovisual);
        ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream(myFile));
        output.writeUnshared(audiovisualList);
        output.close();
    }//createAudiovisualFile

    //Este método sirve para validar que el código sea único en el archivo
    public boolean validateUniqueCode(int code) throws IOException, ClassNotFoundException {
        File myFile = new File(this.path);
        List<Audiovisual> audiovisualList = new ArrayList<Audiovisual>();
        if (myFile.exists()) {
            ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(myFile));
            Object aux = objectInputStream.readObject();
            audiovisualList = (List<Audiovisual>) aux;
            objectInputStream.close();
        }//if
        Audiovisual audiovisual = null;
        for (int i = 0; i < audiovisualList.size(); i++) {
            if (audiovisualList.get(i).getCode() == code) {
                audiovisual = audiovisualList.get(i);
                return true;
            }//if
        }//for
        return false;
    }//validateUniqueCode

    //Este método sirve para  devolver un arraylist con el objeto Audiovisual 
    public List<Audiovisual> returnAudioVisualArray() throws IOException, ClassNotFoundException {
        File myFile = new File(this.path);
        List<Audiovisual> audiovisualList = new ArrayList<Audiovisual>();
        if (myFile.exists()) {
            ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(myFile));
            Object aux = objectInputStream.readObject();
            audiovisualList = (List<Audiovisual>) aux;
            objectInputStream.close();
        }//
        return audiovisualList;
    }//returnArray

    //Este método sirve para hacer el préstamo del material audiovisual, si la variable código que recibe por parámetros
    // es igual a la variable código que trae el arrayList se restará una unidad a la variable disponible, lo cual significa
    //que el préstamo fue realizado.
    public boolean lendAudiovisual(int code) throws IOException, ClassNotFoundException {
        File myFile = new File(this.path);
        List<Audiovisual> audiovisualList = new ArrayList<Audiovisual>();
        if (myFile.exists()) {
            ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(myFile));
            Object aux = objectInputStream.readObject();
            audiovisualList = (List<Audiovisual>) aux;
            objectInputStream.close();
        }
        Audiovisual audiovisual = null;
        for (int i = 0; i < audiovisualList.size(); i++) {
            if (audiovisualList.get(i).getCode() == (code)) {
                if (audiovisualList.get(i).getAvailable() == 0) {
                 JOptionPane.showMessageDialog(null, "At this time the requested material is not available");
                } else {
                    JOptionPane.showMessageDialog(null, "Material successfully requested");
                    audiovisual = audiovisualList.get(i);
                    int amount = audiovisual.getAvailable() - 1;
                    audiovisual.setAvailable(amount);
                    audiovisualList.set(i, audiovisual);
                }
            } else {
                //JOptionPane.showMessageDialog(null, "The code does not correspond to any registered audiovisual");
            }
        }//for 
        ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream(myFile));
        output.writeUnshared(audiovisualList);
        output.close();
        return true;
    }//lendAudiovisual

    // Este método sirve para devolver el audiovisual que fue prestado, si la variable marca que recibe por parámetros
    // es igual a la variable marca que trae el arraylist entonces se suma una unidad a la variable disponible
    public boolean returnAudiovisual(String brand) throws IOException, ClassNotFoundException {
        File myFile = new File(this.path);
        List<Audiovisual> audiovisualList = new ArrayList<Audiovisual>();
        if (myFile.exists()) {
            ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(myFile));
            Object aux = objectInputStream.readObject();
            audiovisualList = (List<Audiovisual>) aux;
            objectInputStream.close();
        }//if
        Audiovisual audiovisual = null;
        for (int i = 0; i < audiovisualList.size(); i++) {
            if (audiovisualList.get(i).getBrand().equals(brand)) {
                if (audiovisualList.get(i).getAvailable() == 0) {
                } else {
                    audiovisual = audiovisualList.get(i);
                    int amount = audiovisual.getAvailable() + 1;
                    audiovisual.setAvailable(amount);
                    audiovisualList.set(i, audiovisual);
                }
            }
        }//for 
        ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream(myFile));
        output.writeUnshared(audiovisualList);
        output.close();
        return true;
    }//returnAudiovisual  
}
