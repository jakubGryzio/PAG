/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.pw.geoinformatics.tsjg;

/**
 *
 * @author tsjg
 */
public class Reader {
      
    private final int name; // name / number of reader
    private final int book; // book
    private int place; // place
    private long startReading; // start of reading
  
    public Reader(int name, int book) {
        this.name = name;
        this.book = book;
        this.place = -1;
    }  

    public int getName() {
        return name;
    }

    public int getBook() {
        return book;
    }

    public long getStartReading() {
        return startReading;
    }

    public void setStartReading(long startReading) {
        this.startReading = startReading;
    }

    public int getPlace() {
        return place;
    }

    public void setPlace(int place) {
        this.place = place;
    }
}    

