package co.falabella.com.interactions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Performable;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import static co.falabella.com.ui.ProductoUI.BTN_AGREGAR_CARRITO;
import static net.serenitybdd.core.Serenity.getDriver;
import static net.serenitybdd.screenplay.Tasks.instrumented;

public class MoverElemento implements Interaction {

    @Override
    public <T extends Actor> void performAs(T actor) {

        WebElement btnAgregarCarrito = BTN_AGREGAR_CARRITO.resolveFor(actor);

        JavascriptExecutor jsExecutor = (JavascriptExecutor) getDriver();
        String script = "arguments[0].scrollIntoView({behavior: 'auto', block: 'center'});";
        jsExecutor.executeScript(script, btnAgregarCarrito);
    }
    public static Performable clickleable(){
        return  instrumented(MoverElemento.class);
    }

}
