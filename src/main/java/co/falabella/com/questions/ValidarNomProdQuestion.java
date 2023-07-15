package co.falabella.com.questions;

import co.falabella.com.interactions.ClickProductoAleatorio;
import co.falabella.com.interactions.ObtenerValorElemento;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

public class ValidarNomProdQuestion implements Question<Boolean> {

    @Override
    public Boolean answeredBy(Actor actor) {

        String nomProduct = ClickProductoAleatorio.obtenerNombreProd();
        String nomProductCarrito = ObtenerValorElemento.nombreProducto();

        if (nomProduct.endsWith("...")) {
            nomProduct = nomProduct.substring(0, nomProduct.length() - 3);
        }

        return nomProductCarrito.contains(nomProduct);
    }

    public static Question<Boolean> from(){
        return  new ValidarNomProdQuestion();
    }
}
