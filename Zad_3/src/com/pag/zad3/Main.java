package com.pag.zad3;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        Product p = new Product("samochód", 20000);
        Product p1 = new Product("lodówka", 1500.15f);
        Product p2 = new Product("lodówka", 1800.15f);
        Product p3 = new Product("lodówka", 1600.15f);
        Product p4 = new Product("lodówka", 1700.15f);

        List<Product> shop = new ArrayList<>();
        shop.add(p);
        shop.add(p1);
        shop.add(p2);
        shop.add(p3);
        shop.add(p4);

        Basket basket1 = new Basket(3);
        basket1.push(p1);
        basket1.push(p2);
        basket1.push(p3);

        Klient klient1 = new Klient("100", "Kowalski", basket1);
        Klient klient2 = new Klient("101", "Kowalski", basket1);
        Klient klient3 = new Klient("102", "Kowalski", basket1);
        List<Klient> clients = new ArrayList<>();
        clients.add(klient1);
        clients.add(klient2);
        clients.add(klient3);
        System.out.println(clients);
    }
}
