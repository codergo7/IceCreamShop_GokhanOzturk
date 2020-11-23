package be.intecbrussel.sellers;

import be.intecbrussel.eatables.Cone;
import be.intecbrussel.eatables.IceRocket;
import be.intecbrussel.eatables.Magnum;

public class IceCreamSalon implements IceCreamSeller {

    private PriceList priceList;
    private double totalProfit;

    public IceCreamSalon(PriceList priceList) {
        this.priceList = priceList;
    }

    @Override
    public Cone orderCone(Cone.Flavor... balls) {
        if(balls!=null && priceList!=null){
            totalProfit += balls.length * priceList.getBallPrice();
        }
        return new Cone(balls);
    }

    @Override
    public IceRocket orderIceRocket() {
        totalProfit += priceList.getRocketPrice();
        return new IceRocket();
    }

    @Override
    public Magnum orderMagnum(Magnum.MagnumType magnumType) {
        totalProfit += priceList.getMagnumPrice(magnumType);
        return new Magnum(magnumType);
    }

    @Override
    public double getProfit() {
        return this.totalProfit;
    }
}
