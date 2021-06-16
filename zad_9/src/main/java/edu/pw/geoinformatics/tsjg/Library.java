/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.pw.geoinformatics.tsjg;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author tsjg
 */
public class Library {
    
    private List<Boolean> books = new ArrayList<>(); //TRUE mean its accessible
    private List<Boolean> places = new ArrayList<>(); //TRUE mean its accessible
    private LinkedList<Reader> readers = new LinkedList<>(); 
    private final long interval; // interval between readers
    private final long timeOfReading; 
    private final Runnable creator;
    private final Runnable stats;
    private final Runnable observer;
    private final Logger log = new Logger();
    private Thread creatorThread;
    private Thread statsThread;
    private Thread observerThread;

    public Library(int booksCnt, 
                   int placesCnt,
                   long readersInterval,
                   long timeOfReading) {
        for (int i = 0; i < booksCnt; i++)
            books.add(Boolean.TRUE);
        for (int i = 0; i < placesCnt; i++)
            places.add(Boolean.TRUE);
        interval = readersInterval;
        this.timeOfReading = timeOfReading;
        creator = new CreatorOfReaders(interval, this, log);
        creatorThread = new Thread(creator);
        creatorThread.start();
        stats = new Statistic(this, log);
        statsThread = new Thread(stats);
        statsThread.start();
        observer = new Observer(this, log);
        observerThread = new Thread(observer);
        observerThread.start();        
    }
    
    public synchronized void showStats()
    {
        StringBuilder sb = new StringBuilder();
        sb.append("Dostepne ksiazki: [");
        for (int i = 0; i < books.size(); i++)
            if (books.get(i)) {
                sb.append(Integer.toString(i));
                sb.append(" ");
            }
        sb.append("] Oczekujący: [");
        for (Reader r : readers)
        if (r.getStartReading() == 0) 
        {
            sb.append(r.getName());
            sb.append(" ");
        }
        sb.append("] Czytający: [");
            
        for (Reader r : readers)
        if (r.getStartReading() != 0) 
        {
            sb.append(r.getName());
            sb.append(" ");
        }
        sb.append("] Wolne miejsca: [");
        
        for (int i = 0; i < places.size(); i++)
            if (places.get(i)) {
                sb.append(Integer.toString(i));
                sb.append(" ");
            }
        sb.append("]");
        
        log.log(Events.LIBRARY_STATUS, sb.toString());
    }
    
    public synchronized void makeStep()
    {
        long now = System.currentTimeMillis();
        
        for (Reader r : readers)
        {
            StringBuilder sb = new StringBuilder();
            sb.append("Czytelnik: ");
            sb.append(r.getName());
            if (r.getStartReading() != 0 && (now - r.getStartReading()) > timeOfReading) 
            {
                places.set(r.getPlace(),true);
                log.log(Events.PLACE_VACATED, sb.toString());
                books.set(r.getBook(), true);
                log.log(Events.BOOK_VACATED, sb.toString());
                readers.remove(r);
            }
        }
        
        for (Reader r : readers)
        {
            StringBuilder sb = new StringBuilder();
            sb.append("Czytelnik: ");
            sb.append(r.getName());
            if (r.getStartReading() == 0) 
            {
                int firstFree = -1;
                for (int i = 0; i < places.size(); i++)
                {
                    if (places.get(i)) 
                    {
                        firstFree = i;
                    }
                }
                if (firstFree >= 0 && books.get(r.getBook()))
                {
                    books.set(r.getBook(), Boolean.FALSE);
                    log.log(Events.BOOK_TAKEN, sb.toString());
                    places.set(firstFree, Boolean.FALSE);
                    log.log(Events.PLACE_TAKEN, sb.toString());
                    r.setPlace(firstFree);
                    r.setStartReading(now);
                }
            }
        }
    }

    public List<Boolean> getBooks() {
        return books;
    }

    public void setBooks(List<Boolean> books) {
        this.books = books;
    }

    public List<Boolean> getPlaces() {
        return places;
    }

    public void setPlaces(List<Boolean> places) {
        this.places = places;
    }

    public LinkedList<Reader> getReaders() {
        return readers;
    }

    public void setReaders(LinkedList<Reader> readers) {
        this.readers = readers;
    }

    public long getInterval() {
        return interval;
    }

    public long getTimeOfReading() {
        return timeOfReading;
    }
}
