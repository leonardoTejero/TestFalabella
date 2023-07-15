package co.falabella.com.questions;

import co.falabella.com.interactions.ObtenerValorElemento;
import co.falabella.com.utils.Excel;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;

public class ValidarCantidadProd implements Question<Boolean> {
    private ArrayList<Map<String, String>> data= new ArrayList<>();
    @Override
    public Boolean answeredBy(Actor actor) {

        try {
            data = Excel.leerDatosDeHojaDeExcel("src/test/resources/Data/Datos.xlsx", "Buscar");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        String cantidad = data.get(0).get("cantidad");
        String cantidadSeleccionada = ObtenerValorElemento.cantidadProductCarrito();

        return cantidad.equals(cantidadSeleccionada);
    }

    public static Question<Boolean> from(){
        return  new ValidarCantidadProd();
    }
}
