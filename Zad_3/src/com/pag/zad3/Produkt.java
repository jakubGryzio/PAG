package com.pag.zad3;

import java.util.Objects;

public class Produkt {
    private String name;
    private float price;

    public Produkt(String name, float price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Produkt produkt = (Produkt) o;
        return Float.compare(produkt.price, price) == 0 && name.equals(produkt.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, price);
    }

    @Override
    public String toString() {
        return "com.pag.zad3.Produkt{" + "name='" + name + '\'' + ", price=" + price + '}';
    }
}

