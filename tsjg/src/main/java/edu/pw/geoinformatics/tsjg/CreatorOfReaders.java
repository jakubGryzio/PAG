/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.pw.geoinformatics.tsjg;

import java.util.Random;

/**
 *
 * @author tsjg
 */
public class CreatorOfReaders implements Runnable {
      
    private final long sleep;
    private int readerNo = 0;
    private final Library library;
    private final Random rnd = new Random();
    private final Logger log;
  
    public CreatorOfReaders(long sleep, Library library, Logger log) {
        this.sleep = sleep;
        this.library = library;
        this.log = log;
    }
  
    @Override
    public void run() {
        while(true) {
          
            library.getReaders().addLast(new Reader(++readerNo, rnd.nextInt(library.getBooks().size())));
            log.log(Events.NEW_READER, Integer.toString(readerNo));
            try {
                    Thread.sleep(sleep);
  		} 
            catch (InterruptedException e) {
  		e.printStackTrace();
            }
  	}
    }
}

