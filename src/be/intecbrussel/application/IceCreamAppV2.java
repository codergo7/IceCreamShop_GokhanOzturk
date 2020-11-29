package be.intecbrussel.application;

import be.intecbrussel.eatables.Cone;
import be.intecbrussel.eatables.Eatable;
import be.intecbrussel.eatables.Magnum;
import be.intecbrussel.sellers.*;

public class IceCreamAppV2 {

    public static void main(String[] args) {

        PriceList priceListCar = new PriceList(1, 1.3, 2);
        Stock stock = new Stock(3, 3, 10, 3);
        IceCreamSeller iceCreamSeller = new IceCreamCar(priceListCar, stock);
        Eatable[] orders = new Eatable[20];

        System.out.println("\n****************** CAR ******************");
        testingCano(orders, iceCreamSeller);
        testingIceRocket(orders, iceCreamSeller);
        testingMagnum(orders, iceCreamSeller);

        //After selling
        statementOfIceCreamCar((IceCreamCar) iceCreamSeller);
    }

    // Cano test: There is 3 cones and 10 balls in the stock, but it is ordered 5 cones and 15 balls
    public static void testingCano(Eatable[] orders, IceCreamSeller iceCreamSeller) {
        try {
            addAnEatableToArray(orders, iceCreamSeller.orderCone(new Cone.Flavor[]{Cone.Flavor.BANANA, Cone.Flavor.CHOCOLATE, Cone.Flavor.MOKKA}));
            addAnEatableToArray(orders, iceCreamSeller.orderCone(new Cone.Flavor[]{Cone.Flavor.BANANA, Cone.Flavor.CHOCOLATE, Cone.Flavor.MOKKA}));
            addAnEatableToArray(orders, iceCreamSeller.orderCone(new Cone.Flavor[]{Cone.Flavor.BANANA, Cone.Flavor.CHOCOLATE, Cone.Flavor.MOKKA}));
            addAnEatableToArray(orders, iceCreamSeller.orderCone(new Cone.Flavor[]{Cone.Flavor.BANANA, Cone.Flavor.CHOCOLATE, Cone.Flavor.MOKKA}));
            addAnEatableToArray(orders, iceCreamSeller.orderCone(new Cone.Flavor[]{Cone.Flavor.BANANA, Cone.Flavor.CHOCOLATE, Cone.Flavor.MOKKA}));
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }

    // IceRocket test: There is 3 Ice Rockets in the stock, but it is ordered 4
    public static void testingIceRocket(Eatable[] orders, IceCreamSeller iceCreamSeller) {
        try {
            addAnEatableToArray(orders, iceCreamSeller.orderIceRocket());
            addAnEatableToArray(orders, iceCreamSeller.orderIceRocket());
            addAnEatableToArray(orders, iceCreamSeller.orderIceRocket());
            addAnEatableToArray(orders, iceCreamSeller.orderIceRocket());
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }

    // Magnum test: There is 3 Magnum in the stock, but it is ordered 4
    public static void testingMagnum(Eatable[] orders, IceCreamSeller iceCreamSeller) {
        try {
            addAnEatableToArray(orders, iceCreamSeller.orderMagnum(Magnum.MagnumType.MILKCHOCOLATE));
            addAnEatableToArray(orders, iceCreamSeller.orderMagnum(Magnum.MagnumType.ALPINENUTS));
            addAnEatableToArray(orders, iceCreamSeller.orderMagnum(Magnum.MagnumType.WHITECHOCOLATE));
            addAnEatableToArray(orders, iceCreamSeller.orderMagnum(Magnum.MagnumType.BLACKCHOCOLATE));
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }

    public static void printEat(Eatable[] orders) {
        for (Eatable eatable : orders) {
            eatable.eat();
        }
    }

    public static void addAnEatableToArray(Eatable[] eatables, Eatable eatable) {
        for (int i = 0; i < eatables.length; i++) {
            if (eatables[i] == null) {
                eatables[i] = eatable;
                return;
            }
        }
    }

    public static void statementOfIceCreamCar(IceCreamCar iceCreamCar) {
        System.out.println("\n****** Current Statement of the Car ******");
        System.out.println("Profit of the Car: " + iceCreamCar.getProfit() + " euros");
        System.out.println("Amount of the balls in the stock: " + iceCreamCar.getStock().getBalls());
        System.out.println("Amount of the cones in the stock: " + iceCreamCar.getStock().getCones());
        System.out.println("Amount of the Ice rockets in the stock: " + iceCreamCar.getStock().getIceRockets());
        System.out.println("Amount of the Magnums in the stock: " + iceCreamCar.getStock().getMagni());
    }

}
