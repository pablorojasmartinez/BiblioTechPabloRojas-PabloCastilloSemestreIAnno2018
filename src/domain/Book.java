/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import java.io.Serializable;

/**
 *
 * @author Pablo Rojas Martínez
 */
public class Book implements Serializable {

    //attributes
    private String type;
    private String name;
    private String code;
    private int amount;
    private String area;
    private int available;

    public Book(String type, String nameombre, String code, int amount, String area, int available) {
        this.type = type;
        this.name = nameombre;
        this.code = code;
        this.amount = amount;
        this.area = area;
        this.available = available;
    }//overload constructor

    public Book() {
        this.type = "";
        this.name = "";
        this.code = "";
        this.amount = 0;
        this.area = "";
        this.available = 0;
    }//constructor

    //Get && Set
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public int getAvailable() {
        return available;
    }

    public void setAvailable(int available) {
        this.available = available;
    }

    //toString
    @Override
    public String toString() {
        return "Libro" + " Type=" + type + " Name=" + name + " Code=" + code + " Amount=" + amount + " Area=" + area + " Available=" + available;
    }

}
