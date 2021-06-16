/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.pw.geoinformatics.tsjg;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author tsjg
 */
public class Logger {
    
    private String currentTime() {
        LocalTime lt = LocalTime.now();
        return lt.format(DateTimeFormatter.ofPattern("HH:mm:ss.SSS"));
    }
    
    public void log(Events ev, String msg) {
        if (msg != null && !msg.isBlank()) {
            StringBuilder sb = new StringBuilder();
            sb.append(currentTime());
            sb.append(" - ");
            sb.append(ev.description());
            sb.append(" - ");
            sb.append(msg);
            System.out.println(sb.toString());
        }   
    }
    
          
}
