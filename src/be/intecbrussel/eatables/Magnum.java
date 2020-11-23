package be.intecbrussel.eatables;

public class Magnum implements Eatable {

    private MagnumType magnumType;

    public Magnum() {
    }

    public Magnum(MagnumType magnumType) {
        this.magnumType =magnumType;
    }


    @Override
    public void eat() {

    }

    public MagnumType getMagnumType() {
        return magnumType;
    }

    public enum MagnumType{

        MILKCHOCOLATE, WHITECHOCOLATE, BLACKCHOCOLATE,
        ALPINENUTS, ROMANTICSRAWBERRIES;

    }
}
