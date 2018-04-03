/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

/**
 *
 * @author Pablo Castillo
 */
public class Person {
    
    private String name;
    private String lastname;

    public Person(String name, String lastname) {
        this.name = name;
        this.lastname = lastname;
    }

    public Person() {
        this.name = "";
        this.lastname = "";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastname;
    }

    public void setLastName(String lastname) {
        this.lastname = lastname;
    }
    
    public int size(){
        return name.length()*2 + lastname.length()*2 +40;
    }

    @Override
    public String toString() {
        return "Person{" + "name=" + name + ", lastname=" + lastname + '}';
    }
    
    

    
    
    
}
