package co.falabella.com.interactions;

//import com.amazon.utils.EscrituraExcel;
import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Performable;

import java.util.List;
import java.util.Random;

import static co.falabella.com.ui.ListaResultadosUI.LST_PRODUCTOS;
import static net.serenitybdd.screenplay.Tasks.instrumented;

public class ClickAleatorio implements Interaction {

    @Override
    public <T extends Actor> void performAs(T actor) {

        List<WebElementFacade> listProducts = LST_PRODUCTOS.resolveAllFor(actor);
        Random random= new Random();
        int indexRandom= random.nextInt(listProducts.size());

        String NombreProducto = listProducts.get(indexRandom).getText();
//        EscrituraExcel.escrituraExcel("src/test/resources/Data/Data.xlsx",productName,1,1);
        listProducts.get(indexRandom).click();

    }

    public static Performable listaProductos(){
        return  instrumented(ClickAleatorio.class);
    }
}
