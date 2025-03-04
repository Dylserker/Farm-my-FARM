package model;

import java.util.ArrayList;
import java.util.List;

public class Ferme {
    private List<Culture> cultures;
    private List<Vache> vaches; // Liste pour stocker les vaches
    private int argent;

    public Ferme() {
        this.cultures = new ArrayList<>();
        this.vaches = new ArrayList<>(); // Initialisation de la liste des vaches
        this.argent = 100; // Argent initial
    }

    public void planterCulture(Culture culture) {
        cultures.add(culture);
    }

    public void passerUnJour() {
        for (Culture culture : cultures) {
            culture.passerUnJour();
        }
    }

    public void recolter() {
        cultures.removeIf(Culture::estMature);
        argent += 20; // Gain fixe par récolte
    }

    public void acheterVache() {
        if (argent >= 50) { // Coût d'achat d'une vache
            argent -= 50; // Déduire le coût de l'achat
            vaches.add(new Vache()); // Ajouter une nouvelle vache
        } else {
            System.out.println("Pas assez d'argent pour acheter une vache.");
        }
    }

    public void nourrirAnimaux() {
        if (argent >= 10) { // Coût pour nourrir les animaux
            argent -= 10; // Déduire le coût de la nourriture
            System.out.println("Les animaux ont été nourris.");
        } else {
            System.out.println("Pas assez d'argent pour nourrir les animaux.");
        }
    }

    public int getArgent() {
        return argent;
    }

    public List<Culture> getCultures() {
        return cultures;
    }

    public List<Vache> getVaches() {
        return vaches; // Méthode pour obtenir la liste des vaches
    }
}