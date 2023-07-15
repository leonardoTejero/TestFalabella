package co.falabella.com.tasks;

import co.falabella.com.interactions.MoverElemento;
import co.falabella.com.utils.Excel;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Clear;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.waits.WaitUntil;

import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Map;

import static co.falabella.com.ui.ProductoUI.*;
import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class ProductoTask implements Task {
private ArrayList<Map<String, String>> data= new ArrayList<>();
    @Override
    public <T extends Actor> void performAs(T actor) {

        try {
            data = Excel.leerDatosDeHojaDeExcel("src/test/resources/Data/Datos.xlsx", "Buscar");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        actor.attemptsTo(
                Click.on(INPUT_CANTIDAD_PROD),
                Clear.field(INPUT_CANTIDAD_PROD),
                Enter.theValue(data.get(0).get("cantidad")).into(INPUT_CANTIDAD_PROD),
                MoverElemento.clickleable(),
                Click.on(BTN_AGREGAR_CARRITO),
                WaitUntil.the(BTN_ABRIR_CARRITO, isVisible()).forNoMoreThan(Duration.ofSeconds(30)),
                Click.on(BTN_ABRIR_CARRITO)
        );

    }

    public static Performable agregarProducto(){ return instrumented(ProductoTask.class); }
}
