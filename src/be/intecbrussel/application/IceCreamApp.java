package be.intecbrussel.application;

import be.intecbrussel.eatables.Cone;
import be.intecbrussel.eatables.Eatable;
import be.intecbrussel.eatables.IceRocket;
import be.intecbrussel.eatables.Magnum;
import be.intecbrussel.sellers.IceCreamSalon;
import be.intecbrussel.sellers.PriceList;

public class IceCreamApp {

    public static void main(String[] args) {

        PriceList priceList = new PriceList(1,1.5,2);

        IceCreamSalon iceCreamSalon = new IceCreamSalon(priceList);

        Eatable[] orders =
                {iceCreamSalon.orderCone(Cone.Flavor.BANANA, Cone.Flavor.CHOCOLATE, Cone.Flavor.MOKKA),
                iceCreamSalon.orderMagnum(Magnum.MagnumType.ALPINENUTS),
                iceCreamSalon.orderMagnum(Magnum.MagnumType.MILKCHOCOLATE), iceCreamSalon.orderIceRocket()};

        for (Eatable eatable : orders){
            eatable.eat();
        }

        System.out.println(iceCreamSalon.getProfit());
    }
}
