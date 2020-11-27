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
        if(stock.getCones()>0 && stock.getBalls()>balls.length){
            profit += balls.length * priceList.getBallPrice();
            return prepareCone(balls);
        }
        else {
            System.out.println("One or both Cones and balls are not in stock");
            return null;
        }
    }

    @Override
    public IceRocket orderIceRocket() {
        if(stock.getIceRockets()>0){
            profit += priceList.getRocketPrice();
            return prepareRocket();
        }
        else {
            System.out.println("We don't have Ice Rocket in our stock.");
            return null;
        }

    }

    @Override
    public Magnum orderMagnum(Magnum.MagnumType magnumType) {
        if(stock.getMagni()>0){
            profit += priceList.getMagnumPrice(magnumType);
            return prepareMagnum(magnumType);
        }
        else {
            System.out.println("We don't have Magnum in our stock");
            return null;
        }
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
