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
        ProductInBasket appleIB1 = new ProductInBasket(apple, 5);
        ProductInBasket chocolateIB1 = new ProductInBasket(chocolate, 2);
        ProductInBasket breadIB1 = new ProductInBasket(bread, 2);
        ProductInBasket blenderIB1 = new ProductInBasket(blender, 1);
        basket1.push(appleIB1);
        basket1.push(chocolateIB1);
        basket1.push(breadIB1);
        basket1.push(blenderIB1);

        Basket basket2 = new Basket(3);
        ProductInBasket carIB2 = new ProductInBasket(car, 1);
        ProductInBasket vacuumIB2 = new ProductInBasket(chocolate, 1);
        ProductInBasket breadIB2 = new ProductInBasket(bread, 3);
        basket2.push(carIB2);
        basket2.push(vacuumIB2);
        basket2.push(breadIB2);

        Basket basket3 = new Basket(3);
        ProductInBasket blenderIB3 = new ProductInBasket(blender, 1);
        ProductInBasket butterIB3 = new ProductInBasket(butter, 4);
        ProductInBasket chocolateIB3 = new ProductInBasket(chocolate, 5);
        basket3.push(blenderIB3);
        basket3.push(butterIB3);
        basket3.push(chocolateIB3);

        Basket basket4 = new Basket(4);
        ProductInBasket fridgeIB4 = new ProductInBasket(fridge, 1);
        ProductInBasket laptopIB4 = new ProductInBasket(butter, 1);
        ProductInBasket cookerIB4 = new ProductInBasket(cooker, 1);
        ProductInBasket vacuumIB4 = new ProductInBasket(vacuum, 2);
        basket4.push(fridgeIB4);
        basket4.push(laptopIB4);
        basket4.push(cookerIB4);
        basket4.push(vacuumIB4);



        Klient klient1 = new Klient("100", "Kowalski", basket1);
        Klient klient2 = new Klient("101", "Nowak", basket2);
        Klient klient3 = new Klient("102", "Stępień", basket3);
        Klient klient4 = new Klient("103", "Gryzio", basket4);

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
