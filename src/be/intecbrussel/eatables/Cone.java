package be.intecbrussel.eatables;

public class Cone implements Eatable {

    private Flavor[] balls;

    public Cone() {
    }

    public Cone(Flavor[] balls) {
        this.balls = balls;
    }

    @Override
    public void eat() {

    }

    public enum Flavor{
        STRAWBERRY, BANANA, CHOCOLATE, VANILLA,
        LEMON, STRACIATELLA, MOKKA, PISTACHE;
    }
}
