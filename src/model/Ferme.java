package model;

import java.util.ArrayList;
import java.util.List;

public class Ferme {
    private List<Culture> cultures;
    private List<Animal> animaux;
    private int argent;
    private int nourritureAnimale;

    public Ferme() {
        this.cultures = new ArrayList<>();
        this.animaux = new ArrayList<>();
        this.argent = 100;
        this.nourritureAnimale = 5;
    }

    public void planterCulture(Culture culture) {
        cultures.add(culture);
    }

    public void ajouterAnimal(Animal animal) {
        animaux.add(animal);
    }

    public void nourrirAnimaux() {
        if (nourritureAnimale > 0) {
            for (Animal animal : animaux) {
                if (animal.estVivant()) {
                    animal.nourrir();
                }
            }
            nourritureAnimale--;
        }
    }

    public void passerUnJour() {
        for (Culture culture : cultures) {
            culture.passerUnJour();
        }
        for (Animal animal : animaux) {
            animal.passerUnJour();
        }
    }

    public void recolter() {
        cultures.removeIf(Culture::estMature);
        argent += 20;
        for (Animal animal : animaux) {
            if (animal.estVivant()) {
                argent += 10;
            }
        }
    }

    public int getArgent() {
        return argent;
    }

    public int getNourritureAnimale() {
        return nourritureAnimale;
    }

    public List<Culture> getCultures() {
        return cultures;
    }

    public List<Animal> getAnimaux() {
        return animaux;
    }
}
