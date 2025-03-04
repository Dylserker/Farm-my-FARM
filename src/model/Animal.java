package model;

public class Animal {
    private String nom;
    private int joursSansNourriture;
    private boolean vivant;
    private String produit;

    public Animal(String nom, String produit) {
        this.nom = nom;
        this.joursSansNourriture = 0;
        this.vivant = true;
        this.produit = produit;
    }

    public void nourrir() {
        joursSansNourriture = 0;
    }

    public void passerUnJour() {
        joursSansNourriture++;
        if (joursSansNourriture > 3) {
            vivant = false;
        }
    }

    public boolean estVivant() {
        return vivant;
    }

    public String getProduit() {
        return produit;
    }

    public String getNom() {
        return nom;
    }
}
