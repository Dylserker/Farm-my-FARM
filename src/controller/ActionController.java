package controller;

import model.Field;
import model.Seed;
import model.Animal;
import model.Farm;

public class ActionController {
    private FarmController farmController;

    public ActionController(FarmController farmController) {
        this.farmController = farmController;
    }

    public void buySeed(Field field, Seed seed) {
        farmController.plantSeed(field, seed);
    }

    public void buyAnimal(Animal animal) {
        farmController.buyAnimal(animal);
    }

    public void harvestProducts() {
        farmController.collectProducts();
    }
}
