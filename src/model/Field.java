package model;

public class Field {
    private Seed seed;
    private boolean isReadyForHarvest;

    public Field() {
        isReadyForHarvest = false;
    }

    public void plant(Seed seed) {
        this.seed = seed;
        // Simuler la croissance avec un Timer
        new java.util.Timer().schedule(new java.util.TimerTask() {
            @Override
            public void run() {
                isReadyForHarvest = true;
            }
        }, seed.getGrowthTime());
    }

    public boolean isReadyForHarvest() {
        return isReadyForHarvest;
    }

    public Seed getSeed() {
        return seed;
    }
}
