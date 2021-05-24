package com.pag.zad3;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        Product car = new Product("samochód", 20000.0f);
        Product fridge = new Product("lodówka", 1500.15f);
        Product laptop = new Product("laptop", 1800.15f);
        Product cooker = new Product("kuchenka", 1600.15f);
        Product vacuum = new Product("odkurzacz", 700.15f);
        Product blender = new Product("blender", 400.15f);
        Product bread = new Product("chleb", 3.15f);
        Product butter = new Product("masło", 2.99f);
        Product apple = new Product("jabłko", 1.99f);
        Product chocolate = new Product("czekolada", 3.99f);

        List<Product> shop = new ArrayList<>();
        shop.add(car);
        shop.add(fridge);
        shop.add(laptop);
        shop.add(cooker);
        shop.add(vacuum);
        shop.add(blender);
        shop.add(bread);
        shop.add(butter);
        shop.add(apple);
        shop.add(chocolate);

        Basket basket1 = new Basket(4);
        ProductInBasket appleIB = new ProductInBasket(apple, 5);
        ProductInBasket chocolateIB = new ProductInBasket(chocolate, 2);
        ProductInBasket breadIB = new ProductInBasket(bread, 2);
        ProductInBasket blenderIB = new ProductInBasket(blender, 1);
        basket1.push(appleIB);
        basket1.push(chocolateIB);
        basket1.push(breadIB);
        basket1.push(blenderIB);

        Klient klient1 = new Klient("100", "Kowalski", basket1);
        Klient klient2 = new Klient("101", "Nowak", basket1);
        Klient klient3 = new Klient("102", "Stępień", basket1);
        Klient klient4 = new Klient("103", "Gryzio", basket1);

        List<Klient> clients = new ArrayList<>();
        clients.add(klient1);
        clients.add(klient2);
        clients.add(klient3);
        clients.add(klient4);

        Queue<Klient> clientsQueue = new LinkedList<>();
        clientsQueue.add(clients.get(0));
        clientsQueue.add(clients.get(2));
        clientsQueue.add(clients.get(1));
        clientsQueue.add(clients.get(3));

        int clientsQueueSize = clientsQueue.size();

        for(int i = 0; i < clientsQueueSize; i++) {
            System.out.println(clientsQueue.peek());
            clientsQueue.remove();
        }

    }
}
