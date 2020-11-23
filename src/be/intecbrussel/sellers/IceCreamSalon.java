package be.intecbrussel.sellers;

import be.intecbrussel.eatables.Cone;
import be.intecbrussel.eatables.IceRocket;
import be.intecbrussel.eatables.Magnum;

public class IceCreamSalon implements IceCreamSeller {

    private PriceList priceList;
    private double totalProfit;

    @Override
    public Cone orderCone(Cone.Flavor[] balls) {
        return null;
    }

    @Override
    public IceRocket orderIceRocket() {
        return null;
    }

    @Override
    public Magnum orderMagnum(Magnum.MagnumType magnumType) {
        return null;
    }

    @Override
    public double getProfit() {
        return this.totalProfit;
    }
}
