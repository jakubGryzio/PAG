package com.pag.zad3;

public class Klient {
    private String id;
    private String name;
    public static Basket basket;

    public Klient(String id, String name, Basket basket) {
        this.id = id;
        this.name = name;
        this.basket = basket;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Klient{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' + basket +
                '}';
    }
}

