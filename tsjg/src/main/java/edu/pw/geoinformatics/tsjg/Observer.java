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
public class Observer implements Runnable {
      
    private final long sleep = 10;
    private final Library library;
    private final Logger log;
  
    public Observer(Library library, Logger log) {
        this.library = library;
        this.log = log;
    }
  
    @Override
    public void run() {
        while(true) {
            library.makeStep();
            try {
                    Thread.sleep(sleep);
  		} 
            catch (InterruptedException e) {
  		e.printStackTrace();
            }
  	}
    }
}