package model;

import java.io.Serializable;
import java.util.Random;

public class Meteo implements Serializable {
    private static final long serialVersionUID = 1L;
    private String[] conditions = {"Ensoleillé", "Pluvieux", "Nuageux"};
    private String conditionActuelle;

    public Meteo() {
        changerCondition();
    }

    public void changerCondition() {
        Random random = new Random();
        conditionActuelle = conditions[random.nextInt(conditions.length)];
    }

    public String getConditionActuelle() {
        return conditionActuelle;
    }
}