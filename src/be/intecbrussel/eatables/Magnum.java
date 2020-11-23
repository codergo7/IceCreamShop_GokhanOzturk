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

        MILKCHOCOLATE(1.1), WHITECHOCOLATE(1.2),
        BLACKCHOCOLATE(1.15), ALPINENUTS(0.9),
        ROMANTICSRAWBERRIES(1.05);

        private double priceMultiplierByMagnumStandardPrice;

        MagnumType(double priceMultiplierByStandard) {
            this.priceMultiplierByMagnumStandardPrice = priceMultiplierByStandard;
        }

        public double getPriceMultiplierByMagnumStandardPrice() {
            return priceMultiplierByMagnumStandardPrice;
        }
    }
}
