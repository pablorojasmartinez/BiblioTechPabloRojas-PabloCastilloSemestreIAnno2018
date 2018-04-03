/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

/**
 *
 * @author Pablo Rojas Martínez
 */
public class Student extends Person{

    //attributes
    private Identification id;

    public Student() {
        this.id = null;
    }//Constructor

    public Student(String name, String lastName, Identification id) {
        super(name,lastName);
        this.id = id;
    }//Overload constructor

    //Set && Get

    public Identification getId() {
        return id;
    }

    public void setId(Identification id) {
        this.id = id;
    }

    //Este método retorna el tamaño en bytes de las variables 
    public int size() {
        return super.getName().length() * 2 + super.getLastName().length() * 2 + 40;
    } // size 

//toString
    @Override
    public String toString() {
        return "Student:" + super.toString()+ " Identification=" + id + '}';
    }
}
