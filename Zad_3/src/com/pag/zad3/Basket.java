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
        if (first < products.length) {
            products[first] = (ProductInBasket) product;
        } else {
            throw new ArrayIndexOutOfBoundsException();
        }
    }

    ProductInBasket pop() throws IndexOutOfBoundsException {
        if (first <= 0) {
            throw new IndexOutOfBoundsException();
        }
        ProductInBasket temp = products[first - 1];
        first--;
        return temp;
    }

//    void displayProducts() throws
}
