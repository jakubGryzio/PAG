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
public class Statistic implements Runnable {
      
    private final long sleep = 10_000;
    private final Library library;
    private final Logger log;
  
    public Statistic(Library library, Logger log) {
        this.library = library;
        this.log = log;
    }
  
    @Override
    public void run() {
        while(true) {
            library.showStats();
            try {
                    Thread.sleep(sleep);
  		} 
            catch (InterruptedException e) {
  		e.printStackTrace();
            }
  	}
    }
}