package co.falabella.com.interactions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Performable;

import static co.falabella.com.ui.CarritoUI.INPUT_CANTIDAD_CAR;
import static co.falabella.com.ui.CarritoUI.LBL_PROD_CAR;
import static net.serenitybdd.screenplay.Tasks.instrumented;

public class ObtenerNomProd implements Interaction {
    private static String cantidadProdCarrito;
    private static String nomProdCarrito;

    @Override
    public <T extends Actor> void performAs(T actor) {

        cantidadProdCarrito = INPUT_CANTIDAD_CAR.resolveFor(actor).getValue();
        nomProdCarrito = LBL_PROD_CAR.resolveFor(actor).getText();

    }
    public static Performable nombre(){
        return  instrumented(ObtenerNomProd.class);
    }
    public static String carrito() {
        return nomProdCarrito;
    }
    public static String getCantidadProd() {
        return cantidadProdCarrito;
    }
}
