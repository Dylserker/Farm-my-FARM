package model;

import java.io.Serializable;

public class Vache implements Serializable {
    private static final long serialVersionUID = 1L;
    private boolean aProduitLait;

    public Vache() {
        this.aProduitLait = false;
    }

    public void produireLait() {
        this.aProduitLait = true;
    }

    public boolean peutVendreLait() {
        return aProduitLait;
    }

    public void resetProduction() {
        this.aProduitLait = false;
    }

    public String getNom() {
        return "Vache";
    }
}