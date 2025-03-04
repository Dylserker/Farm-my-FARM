package controller;

import model.Farm;
import model.Field;
import model.Animal;
import model.Seed;

public class FarmController {
    private Farm farm;

    public FarmController(Farm farm) {
        this.farm = farm;
    }

    public void plantSeed(Field field, Seed seed) {
        farm.plantSeed(field, seed);
    }

    public void buyAnimal(Animal animal) {
        farm.buyAnimal(animal);
    }

    public void collectProducts() {
        for (Animal animal : farm.getAnimals()) {
            animal.produce();
        }
    }

    public int getMoney() {
        return farm.getMoney();
    }
}
