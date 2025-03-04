package model;

import java.util.ArrayList;
import java.util.List;

public class Farm {
    private List<Field> fields;
    private List<Animal> animals;
    private int money;

    public Farm() {
        fields = new ArrayList<>();
        animals = new ArrayList<>();
        money = 100; // argent de départ
    }

    public void addField(Field field) {
        fields.add(field);
    }

    public void addAnimal(Animal animal) {
        animals.add(animal);
    }

    public void plantSeed(Field field, Seed seed) {
        if (money >= seed.getPrice()) {
            field.plant(seed);
            money -= seed.getPrice();
        }
    }

    public void buyAnimal(Animal animal) {
        if (money >= animal.getPrice()) {
            animals.add(animal);
            money -= animal.getPrice();
        }
    }

    public int getMoney() {
        return money;
    }

    public List<Field> getFields() {
        return fields;
    }

    public List<Animal> getAnimals() {
        return animals;
    }
}
