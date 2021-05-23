package com.pag.zad3;

public class Basket {
    ProductInBasket[] products;
    int first;

    public Basket(int MaxSize) {
        products = new ProductInBasket[MaxSize];
        first = 0;
    }

    int getMaximumBasketSize(){
        return products.length;
    }

    boolean isEmpty() {
        return first == 0;
    }

    int getSize() {
        return first;
    }

    void push(Product product) throws ArrayIndexOutOfBoundsException {

    }
}
