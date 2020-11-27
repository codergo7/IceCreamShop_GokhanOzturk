package be.intecbrussel.sellers;

import be.intecbrussel.eatables.Cone;
import be.intecbrussel.eatables.IceRocket;
import be.intecbrussel.eatables.Magnum;

public class IceCreamCarV2 implements IceCreamSeller {

    private PriceList priceList;
    private Stock stock;
    private double profit;

    public IceCreamCarV2() {
    }

    public IceCreamCarV2(PriceList priceList) {
        this.priceList = priceList;
    }

    public IceCreamCarV2(PriceList priceList, Stock stock) {
        this.priceList = priceList;
        this.stock = stock;
    }

    @Override
    public Cone orderCone(Cone.Flavor... balls) throws NoMoreIceCreamException {
        return prepareCone(balls);
    }

    @Override
    public IceRocket orderIceRocket() throws NoMoreIceCreamException {
        return prepareRocket();
    }

    @Override
    public Magnum orderMagnum(Magnum.MagnumType magnumType) throws NoMoreIceCreamException {
        return prepareMagnum(magnumType);
    }

    @Override
    public double getProfit() {
        return this.profit;
    }

    private IceRocket prepareRocket() throws NoMoreIceCreamException {
        if(stock.getIceRockets()>0){
            profit += priceList.getRocketPrice();
            stock.setIceRockets(stock.getIceRockets()-1);
            return new IceRocket();
        }
        else {
            throw new NoMoreIceCreamException("No more Ice Rocket in the stock.");
        }
    }

    private Magnum prepareMagnum(Magnum.MagnumType magnumType) throws NoMoreIceCreamException {
        if(stock.getMagni()>0){
            profit += priceList.getMagnumPrice(magnumType);
            stock.setMagni(stock.getMagni()-1);
            return new Magnum(magnumType);
        }
        else {
          throw new NoMoreIceCreamException("No more Magnum in the stock");
        }

    }

    private Cone prepareCone(Cone.Flavor[] balls) throws NoMoreIceCreamException {
        if(stock.getCones()>0 && stock.getBalls()>0){
            if(stock.getBalls()>balls.length){
                profit += balls.length * priceList.getBallPrice();
                stock.setBalls(stock.getBalls()-balls.length);
            }
            // if the balls ordered are greater than in stock
            else {
                profit += stock.getBalls() * priceList.getBallPrice();
                stock.setBalls(0);
            }
            stock.setCones(stock.getCones()-1);
            return new Cone(balls);
        }
        else {
            throw  new NoMoreIceCreamException("No more Cone or balls in the stock");
        }
    }
}
