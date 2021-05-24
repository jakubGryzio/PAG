package com.pag.zad3;

import java.util.Arrays;

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

    void push(ProductInBasket product) throws ArrayIndexOutOfBoundsException {
        if (first < products.length) {
            products[first] = product;
            first++;
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

    public float productsSum() {
        float sum = 0;
        for(int i = 0; i < products.length; i++) {
            sum += products[i].getProductPrice();
        }
        return sum;
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
                "products=" + Arrays.toString(products) + ", products sum= " + productsSum() + '}';
    }
}
