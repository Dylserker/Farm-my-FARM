package model;

public class Culture {
    private String nom;
    private int tempsDeCroissance;
    private int joursRestants;
    private boolean mature;

    public Culture(String nom, int tempsDeCroissance) {
        this.nom = nom;
        this.tempsDeCroissance = tempsDeCroissance;
        this.joursRestants = tempsDeCroissance;
        this.mature = false;
    }

    public void passerUnJour() {
        if (joursRestants > 0) {
            joursRestants--;
            if (joursRestants == 0) {
                mature = true;
            }
        }
    }

    public boolean estMature() {
        return mature;
    }

    public String getNom() {
        return nom;
    }
}
