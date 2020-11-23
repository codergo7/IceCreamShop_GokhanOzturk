package be.intecbrussel.sellers;

import be.intecbrussel.eatables.Cone;
import be.intecbrussel.eatables.IceRocket;
import be.intecbrussel.eatables.Magnum;

public class IceCreamCar implements IceCreamSeller {

    private PriceList priceList;
    private Stock stock;
    private double profit;

    public IceCreamCar() {
    }

    public IceCreamCar(PriceList priceList) {
        this.priceList = priceList;
    }

    public IceCreamCar(PriceList priceList, Stock stock) {
        this.priceList = priceList;
        this.stock = stock;
    }

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
        return this.profit;
    }

    private IceRocket prepareRocket(){

        return null;
    }

    private Magnum prepareMagnum(Magnum.MagnumType magnumType){

        return new Magnum(magnumType);
    }

    private Cone prepareCone(Cone.Flavor[] balls){

        return new Cone(balls);
    }
}
