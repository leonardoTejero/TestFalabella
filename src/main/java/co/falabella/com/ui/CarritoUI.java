package co.falabella.com.ui;

import net.serenitybdd.screenplay.targets.Target;

public class CarritoUI {
    public static final Target LBL_PROD_CAR = Target.the("Nombre del producto en carrito")
            .locatedBy("//p[@class=\"chakra-text css-1h76ti1\"]");
    public static final Target INPUT_CANTIDAD_CAR = Target.the("cantidad de productos")
            .locatedBy("//input[@class=\"chakra-input css-1hzo6s2\"]");
}
