package be.intecbrussel.application;

import be.intecbrussel.eatables.*;
import be.intecbrussel.sellers.*;

public class IceCreamApp {

    public static void main(String[] args) {

        // Testing for IceCreamSalon
        PriceList priceList = new PriceList(1.25, 1.5, 2);
        IceCreamSalon iceCreamSalon = new IceCreamSalon(priceList);
        testIceCreamSeller(iceCreamSalon);

        // Testing for IceCreamCar
        PriceList priceListCar = new PriceList(1, 1.3, 2);
        Stock stock = new Stock(10,3,10,10);
        IceCreamSeller iceCreamCar = new IceCreamCar(priceListCar,stock);
        testIceCreamSeller(iceCreamCar);

    }
    public static void testIceCreamSeller(IceCreamSeller iceCreamSeller){
        Eatable[] orders = new Eatable[]{};
        try {
            Eatable[] orders2 =
                    {iceCreamSeller.orderCone( new Cone.Flavor[]{Cone.Flavor.BANANA, Cone.Flavor.CHOCOLATE, Cone.Flavor.MOKKA}),
                            iceCreamSeller.orderMagnum(Magnum.MagnumType.ALPINENUTS),
                            iceCreamSeller.orderMagnum(Magnum.MagnumType.MILKCHOCOLATE), iceCreamSeller.orderIceRocket()};
            orders =orders2;
        }catch (Exception e){
            System.out.println(e.getMessage());
        }

        if(iceCreamSeller instanceof IceCreamCar){
            IceCreamCar iceCreamCar = (IceCreamCar) iceCreamSeller;
            System.out.println("\n\n****************** CAR ******************");
            printEatAndProfit(orders,iceCreamCar);
            statementOfIceCreamCar(iceCreamCar);
        } else {
            System.out.println("***************** SALON *****************");
            printEatAndProfit(orders,iceCreamSeller);
        }
    }

    public static void printEatAndProfit(Eatable[] orders, IceCreamSeller iceCreamSeller){
        for (Eatable eatable : orders){
            eatable.eat();
        }

        System.out.println("Profit : "+ iceCreamSeller.getProfit() + " euros");
    }

    public static void statementOfIceCreamCar(IceCreamCar iceCreamCar) {
        System.out.println("\n\n****** Current Statement of the Car ******");
        System.out.println("Profit of the Car: " + iceCreamCar.getProfit() + " euros");
        System.out.println("Amount of the balls in the stock: " + iceCreamCar.getStock().getBalls());
        System.out.println("Amount of the cones in the stock: " + iceCreamCar.getStock().getCones());
        System.out.println("Amount of the Ice rockets in the stock: " + iceCreamCar.getStock().getIceRockets());
        System.out.println("Amount of the Magnums in the stock: " + iceCreamCar.getStock().getMagni());
    }
}
