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
public enum Events {
    NEW_READER ("Wizyta nowego czytelnika"),
    BOOK_TAKEN ("Wypożyczenie książki przez czytelnika"),
    PLACE_TAKEN("Zajęcie miejsca przez czytelnika"),
    PLACE_VACATED("Zwolnienie miejsca przez czytelnika"),
    BOOK_VACATED("Zwrócenie książki przez czytelnika"),
    LIBRARY_STATUS("STATUS BIBLIOTEKI");
    
    String description;

    Events(String desc) {
 	description = desc;
    }    
    
    public String description() {return description;}
}
