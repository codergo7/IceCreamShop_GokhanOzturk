package be.intecbrussel.application;

import be.intecbrussel.eatables.Cone;
import be.intecbrussel.eatables.Eatable;
import be.intecbrussel.eatables.IceRocket;
import be.intecbrussel.eatables.Magnum;
import be.intecbrussel.sellers.*;

public class IceCreamApp {

    public static void main(String[] args) {



        System.out.println("****************** SALON ******************");
        PriceList priceList = new PriceList(1.25, 1.5, 2);
        IceCreamSeller iceCreamSalon = new IceCreamSalon(priceList);
        Eatable[] orders =
                {iceCreamSalon.orderCone( new Cone.Flavor[]{Cone.Flavor.BANANA, Cone.Flavor.CHOCOLATE, Cone.Flavor.MOKKA}),
                iceCreamSalon.orderMagnum(Magnum.MagnumType.ALPINENUTS),
                iceCreamSalon.orderMagnum(Magnum.MagnumType.MILKCHOCOLATE), iceCreamSalon.orderIceRocket()};

        printEat(orders);
        System.out.println("Profit of the Salon: "+ iceCreamSalon.getProfit() + " euros");


        System.out.println("\n\n****************** CAR ******************\n");

        PriceList priceListCar = new PriceList(1, 1.3, 2);

        Stock stock = new Stock(20,20,20,20);


        IceCreamSeller iceCreamCar = new IceCreamCar(priceListCar,stock);

        Eatable[] orders2 =
                {iceCreamCar.orderCone( new Cone.Flavor[]{Cone.Flavor.BANANA, Cone.Flavor.CHOCOLATE, Cone.Flavor.MOKKA}),
                        iceCreamCar.orderMagnum(Magnum.MagnumType.ALPINENUTS),
                        iceCreamCar.orderMagnum(Magnum.MagnumType.ROMANTICSRAWBERRIES), iceCreamCar.orderIceRocket()};

        printEat(orders2);

        System.out.println("Profit of the Car: " +iceCreamCar.getProfit() + " euros");
        System.out.println("Amount of the balls in the stock: " + stock.getBalls());
        System.out.println("Amount of the cones in the stock: " +stock.getCones());
        System.out.println("Amount of the Ice rockets in the stock: " +stock.getIceRockets());
        System.out.println("Amount of the Magnums in the stock: " +stock.getMagni());
    }

    public static void printEat(Eatable[] orders){
        for (Eatable eatable : orders){
            eatable.eat();
        }

    }
}
