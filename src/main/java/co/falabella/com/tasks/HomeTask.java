package co.falabella.com.tasks;

import co.falabella.com.utils.Excel;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import org.openqa.selenium.Keys;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;

import static co.falabella.com.ui.HomeUI.BTN_COOKIES;
import static co.falabella.com.ui.HomeUI.INPUT_BUSCAR;
import static net.serenitybdd.screenplay.Tasks.instrumented;

public class HomeTask implements Task {
    private ArrayList<Map<String, String>> data= new ArrayList<>();
    @Override
    public <T extends Actor> void performAs(T actor) {

        try {
            data = Excel.leerDatosDeHojaDeExcel("src/test/resources/Data/Datos.xlsx", "Buscar");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        actor.attemptsTo(
                Click.on(BTN_COOKIES),
                Enter.theValue(data.get(0).get("producto")).into(INPUT_BUSCAR).thenHit(Keys.ENTER)
        );
    }

    public static Performable fromHome(){
        return instrumented(HomeTask.class);
    }

}
