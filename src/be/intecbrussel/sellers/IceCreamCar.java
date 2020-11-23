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
    public Cone orderCone(Cone.Flavor... balls) {
        if(balls!=null && priceList!=null){
            profit += balls.length * priceList.getBallPrice();
        }
        return prepareCone(balls);
    }

    @Override
    public IceRocket orderIceRocket() {
        profit += priceList.getRocketPrice();
        return prepareRocket();
    }

    @Override
    public Magnum orderMagnum(Magnum.MagnumType magnumType) {
        profit += priceList.getMagnumPrice(magnumType);
        return prepareMagnum(magnumType);
    }

    @Override
    public double getProfit() {
        return this.profit;
    }

    private IceRocket prepareRocket(){
        stock.setIceRockets(stock.getIceRockets()-1);
        return new IceRocket();
    }

    private Magnum prepareMagnum(Magnum.MagnumType magnumType){
        stock.setMagni(stock.getMagni()-1);
        return new Magnum(magnumType);
    }

    private Cone prepareCone(Cone.Flavor[] balls){
        stock.setCones(stock.getCones()-1);
        stock.setBalls(stock.getBalls()-balls.length);
        return new Cone(balls);
    }
}
