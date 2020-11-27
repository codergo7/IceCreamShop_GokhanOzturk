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
        return prepareCone(balls);
    }

    @Override
    public IceRocket orderIceRocket() {
        return prepareRocket();
    }

    @Override
    public Magnum orderMagnum(Magnum.MagnumType magnumType) {
        return prepareMagnum(magnumType);
    }

    private Cone prepareCone(Cone.Flavor[] balls) {
        if (stock.getCones() > 0 && stock.getBalls() > balls.length) {
            profit += balls.length * priceList.getBallPrice();
            stock.setCones(stock.getCones() - 1);
            stock.setBalls(stock.getBalls() - balls.length);
            return new Cone(balls);
        } else {
            System.out.println("No more Cone or balls in the stock");
            return null;
        }
    }

    private IceRocket prepareRocket() {
        if (stock.getIceRockets() > 0) {
            profit += priceList.getRocketPrice();
            stock.setIceRockets(stock.getIceRockets() - 1);
            return new IceRocket();
        } else {
            System.out.println("No more Ice Rocket in the stock.");
            return null;
        }
    }

    private Magnum prepareMagnum(Magnum.MagnumType magnumType) {
        if (stock.getMagni() > 0) {
            profit += priceList.getMagnumPrice(magnumType);
            stock.setMagni(stock.getMagni() - 1);
            return new Magnum(magnumType);
        } else {
            System.out.println("No more Magnum in the stock");
            return null;
        }
    }

    @Override
    public double getProfit() {
        return this.profit;
    }

    public Stock getStock() {
        return stock;
    }
}
