/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.pw.geoinformatics.tsjg;

import java.util.Random;


/**
 *
 * @author ts & jg
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    
    public static void main(String[] args) {
        Logger l = new Logger();
        int minBooks = 3; //A
        int maxBooks = 10;
        int minPlaces = 3; //B
        int maxPlaces = 10;
        int minInterval = 5_000; //C
        int maxInterval = 20_000; //
        int minTimeOfReading = 10_000; //D
        int maxTimeOfReading = 50_000; 
        
        Random rand = new Random();
        l.log(Events.LIBRARY_STATUS, "Biblioteka jest pusta, zaczynamy");
        Library library = new Library(rand.nextInt(maxBooks) + minBooks, 
                                      rand.nextInt(maxPlaces) + minPlaces,
                                      rand.nextInt(maxInterval) + minInterval,
                                      rand.nextInt(maxTimeOfReading) + minTimeOfReading);
        
                
                
        
    }
    
}
