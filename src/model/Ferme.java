package model;

import java.util.ArrayList;
import java.util.List;

public class Ferme {
    private List<Culture> cultures;
    private int argent;

    public Ferme() {
        this.cultures = new ArrayList<>();
        this.argent = 500;
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

    public int getArgent() {
        return argent;
    }

    public List<Culture> getCultures() {
        return cultures;
    }
}
