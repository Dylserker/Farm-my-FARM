package model;

public class Seed {
    private String type;
    private int price;
    private int growthTime; // en millisecondes

    public Seed(String type, int price, int growthTime) {
        this.type = type;
        this.price = price;
        this.growthTime = growthTime;
    }

    public int getPrice() {
        return price;
    }

    public int getGrowthTime() {
        return growthTime;
    }
}
