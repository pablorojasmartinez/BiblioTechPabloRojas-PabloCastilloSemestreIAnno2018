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
public class Audiovisual implements Serializable{
    
    //attributes
private String type,brand;
    private int amount,available,code,madeYear;
    
    public Audiovisual(){
     this.type="";
     this.brand="";
     this.amount=0;
     this.available=0;
     this.code=0;
     this.madeYear=0;
    }//Constructor

    public Audiovisual(String type, String brand, int amount, int available, int code,int madeYear) {
        this.type = type;
        this.brand = brand;
        this.amount = amount;
        this.available = available;
        this.code = code;
        this.madeYear=madeYear;
    }//overload constructor
    
    //Set && Get

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public int amount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public int getAvailable() {
        return available;
    }

    public void setAvailable(int available) {
        this.available = available;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public int getMadeYear() {
        return madeYear;
    }

    public void setMadeYear(int madeYear) {
        this.madeYear = madeYear;
    }

    //toString
    @Override
    public String toString() {
        return "Audiovisual:" + "Type=" + type + " Brand=" + brand + "  Amount=" + amount + " Available=" + available + " Code=" + code + " YearMade=" + madeYear ;
    }
}
