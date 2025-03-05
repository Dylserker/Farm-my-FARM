package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Ferme implements Serializable {
    private static final long serialVersionUID = 1L;
    private List<Culture> cultures;
    private List<Vache> vaches;
    private int argent;
    private Meteo meteo;

    public Ferme() {
        this.cultures = new ArrayList<>();
        this.vaches = new ArrayList<>();
        this.argent = 100;
        this.meteo = new Meteo();
    }

    public void planterCulture(Culture culture) {
        cultures.add(culture);
    }

    public void passerUnJour() {
        for (Culture culture : cultures) {
            culture.passerUnJour();
        }
        meteo.changerCondition();
    }

    public void recolter() {
        cultures.removeIf(Culture::estMature);
        argent += 20;
    }

    public void acheterVache() {
        if (argent >= 50) {
            argent -= 50;
            vaches.add(new Vache());
        } else {
            System.out.println("Pas assez d'argent pour acheter une vache.");
        }
    }

    public void nourrirAnimaux() {
        if (argent >= 10) {
            argent -= 10;
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
        return vaches;
    }

    public Meteo getMeteo() {
        return meteo;
    }
}