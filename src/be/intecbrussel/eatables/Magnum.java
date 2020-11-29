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
        System.out.println("You eat " + this.magnumType + " Magnum ice cream");
    }

    public MagnumType getType() {
        return magnumType;
    }

    public enum MagnumType{

        MILKCHOCOLATE(1.1),
        WHITECHOCOLATE(1.2),
        BLACKCHOCOLATE(1.15),
        ALPINENUTS(1.3),
        ROMANTICSRAWBERRIES(1.05);

        private double priceMultiplierByMagnumType;

        MagnumType(double priceMultiplierByStandard) {
            this.priceMultiplierByMagnumType = priceMultiplierByStandard;
        }

        public double getPriceMultiplierByMagnumType() {
            return priceMultiplierByMagnumType;
        }
    }
}
