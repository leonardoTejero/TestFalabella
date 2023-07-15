package co.falabella.com.tasks;

import co.falabella.com.interactions.ClickProductoAleatorio;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class ListaResultadosTask implements Task {
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                ClickProductoAleatorio.listaProductos()
        );
    }

    public static Performable listaResultados(){
        return  instrumented(ListaResultadosTask.class);
    }
}
