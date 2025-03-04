package model;

public class Product {
    private String name; // Le nom du produit, par exemple "Lait", "Œuf"
    private int quantity; // La quantité du produit
    private int price; // Le prix du produit

    // Constructeur
    public Product(String name, int quantity, int price) {
        this.name = name;
        this.quantity = quantity;
        this.price = price;
    }

    // Getter et Setter
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    // Méthode pour ajouter un produit récolté (ex: augmenter la quantité de lait)
    public void addQuantity(int amount) {
        this.quantity += amount;
    }

    @Override
    public String toString() {
        return "Produit: " + name + ", Quantité: " + quantity + ", Prix: " + price + " crédits";
    }
}
