/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author Pablo Castillo
 */
public class Loan implements Serializable {

    //attributes
    private Date startDate, endDate;
    private String id;
    private Audiovisual audiovisual;
    private Book book;

    public Loan() {
        this.startDate = null;
        this.endDate = null;
        this.id = "";
        this.audiovisual = null;
        this.book = null;
    }//constructor

    public Loan(Date startDate, Date endDate, String id, Audiovisual audio, Book book) {
        this.startDate = startDate;
        this.endDate = endDate;
        this.id = id;
        this.audiovisual = audio;
        this.book = book;
    }//overload constructor

    //Set && Get
    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Audiovisual getAudio() {
        return audiovisual;
    }

    public void setAudio(Audiovisual audio) {
        this.audiovisual = audio;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    //toString
    @Override
    public String toString() {
        return "Loan" + " Start Date=" + startDate + " End Date=" + endDate + " Id=" + id + " Audiovisual=" + audiovisual + " Book=" + book;
    }

}
