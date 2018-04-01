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
public class Student {

    //attributes
    private String name, lastName;
    private Identification id;

    public Student() {
        this.name = "";
        this.lastName = "";
        this.id = null;
    }//Constructor

    public Student(String name, String lastName, Identification id) {
        this.name = name;
        this.lastName = lastName;
        this.id = id;
    }//Overload constructor

    //Set && Get
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Identification getId() {
        return id;
    }

    public void setId(Identification id) {
        this.id = id;
    }

    public int size() {
        return this.name.length() * 2 + this.lastName.length() * 2 + 40;

    } // size 

//toString
    @Override
    public String toString() {
        return "Student:" + " Name=" + name + " LastName=" + lastName + " Identification=" + id + '}';
    }
}
