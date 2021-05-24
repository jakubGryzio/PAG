package com.pag.zad3;

public class ProductInBasket extends Product{
    private float amount;

    public ProductInBasket(Product product, float amount) {
        super(product.name, product.price);
        this.amount = amount;
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

    public float getProductPrice() {
        return super.price * this.amount;
    }

    @Override
    public String toString() {
        return "{"+ "name='" + name + '\'' +
                ", price=" + price +
                ", amount=" + amount +
                '}';
    }
}
