package com.pag.zad3;

import java.util.Arrays;

public class Basket {
    Product[] products;
    int first;

    public Basket(int MaxSize) {
        products = new Product[MaxSize];
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
            products[first] = product;
            first++;
        } else {
            throw new ArrayIndexOutOfBoundsException();
        }
    }

    Product pop() throws IndexOutOfBoundsException {
        if (first <= 0) {
            throw new IndexOutOfBoundsException();
        }
        Product temp = products[first - 1];
        first--;
        return temp;
    }

    public void displayProducts() throws IndexOutOfBoundsException {
        if (first == 0) {
            throw new IndexOutOfBoundsException();
        }

        int temp = first - 1;
        do {
            System.out.println(products[temp]);
            temp--;
        } while (temp > -1);
    }

    @Override
    public String toString() {
        return "Basket{" +
                "products=" + Arrays.toString(products) +
                '}';
    }
}
