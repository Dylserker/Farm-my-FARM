package model;

public class Animal {
    private String type;
    private int productAmount;
    private int price;

    public Animal(String type, int price) {
        this.type = type;
        this.price = price;
        this.productAmount = 0;
    }

    public void produce() {
        productAmount++;
    }

    public int getPrice() {
        return price;
    }

    public int getProductAmount() {
        return productAmount;
    }
}
