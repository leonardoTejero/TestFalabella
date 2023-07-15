package co.falabella.com.interactions;

import co.falabella.com.utils.CustomException;
import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Performable;

import java.util.List;
import java.util.Random;

import static co.falabella.com.ui.ListaResultadosUI.LST_PRODUCTOS1;
import static co.falabella.com.ui.ListaResultadosUI.LST_PRODUCTOS2;
import static net.serenitybdd.screenplay.Tasks.instrumented;

public class ClickProductoAleatorio implements Interaction {
    private static String nombreProducto;
    @Override
    public <T extends Actor> void performAs(T actor) {

        List<WebElementFacade> listProducts = (LST_PRODUCTOS1.resolveAllFor(actor).isEmpty()) ? LST_PRODUCTOS2.resolveAllFor(actor) : LST_PRODUCTOS1.resolveAllFor(actor);
        try {
            Random random = new Random();
            int indexRandom = random.nextInt(listProducts.size());

            nombreProducto = listProducts.get(indexRandom).getText();
            listProducts.get(indexRandom).click();

        }catch (Exception e){
            throw new CustomException("No se encontraron resultados de la búsqueda");
        }
    }

    public static Performable listaProductos(){
        return  instrumented(ClickProductoAleatorio.class);
    }
    public static String obtenerNombreProd() {
        return nombreProducto;
    }
}
