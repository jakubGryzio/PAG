package com.pag.zad3;

public class ProductInBasket extends Product{
    private float amount;

    public ProductInBasket(String name, float price) {
        super(name, price);
    }

    public ProductInBasket(float amount){
        this.amount = amount;
    }

    public float getAmount() {
        return amount;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }

}
