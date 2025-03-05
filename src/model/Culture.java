package model;

import java.io.Serializable;

public class Culture implements Serializable {
    private static final long serialVersionUID = 1L;
    private String nom;
    private int joursRestants;

    public Culture(String nom, int joursRestants) {
        this.nom = nom;
        this.joursRestants = joursRestants;
    }

    public void passerUnJour() {
        if (joursRestants > 0) {
            joursRestants--;
        }
    }

    public boolean estMature() {
        return joursRestants == 0;
    }

    public String getNom() {
        return nom;
    }
}