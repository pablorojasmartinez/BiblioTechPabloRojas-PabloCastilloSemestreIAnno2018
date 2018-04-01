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
public class Identification {

    //attributes
    private String career;
    private int year;
    private int number;
    private String chain;

    public Identification() {
        this.career = "";
        this.year = 0;
        this.number = 0;
        this.chain = "";
    }//constructor

    public Identification(String career, int year, int number, String chain) {
        this.career = career;
        this.year = year;
        this.number = number;
        this.chain = chain;
    }//overload constructor

    //Set && Get
    public String getCareer() {
        return career;
    }

    public void setCareer(String career) {
        this.career = career;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getChain() {
        return chain;
    }

    public void setChain(String chain) {
        this.chain = chain;
    }

    //toString
    @Override
    public String toString() {
        return "Carnet: " + " Career=" + career + " Year=" + year + " Number=" + number + " Chain=" + chain + '}';
    }
}
