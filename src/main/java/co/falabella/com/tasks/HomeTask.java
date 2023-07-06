package co.falabella.com.tasks;

import co.falabella.com.utils.Excel;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Enter;
import org.openqa.selenium.Keys;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;

import static co.falabella.com.ui.HomeUI.INPUT_BUSCAR;

public class HomeTasks implements Task {
    private ArrayList<Map<String, String>> data= new ArrayList<>();
    @Override
    public <T extends Actor> void performAs(T actor) {

        try {
            data = Excel.leerDatosDeHojaDeExcel("src/test/resources/Data/Datos.xlsx", "Buscar");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        actor.attemptsTo(
                Enter.theValue(data.get(0).get("producto")).into(INPUT_BUSCAR).thenHit(Keys.ENTER)
        );

    }
}
