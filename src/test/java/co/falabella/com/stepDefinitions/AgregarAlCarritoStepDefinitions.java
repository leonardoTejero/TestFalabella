package co.falabella.com.stepDefinitions;

import co.falabella.com.interactions.ObtenerValorElemento;
import co.falabella.com.questions.ValidarCantidadProd;
import co.falabella.com.questions.ValidarNomProdQuestion;
import co.falabella.com.tasks.HomeTask;
import co.falabella.com.tasks.ListaResultadosTask;
import co.falabella.com.tasks.ProductoTask;
import io.cucumber.java.Before;
import io.cucumber.java.es.*;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.actors.OnlineCast;
import org.hamcrest.Matchers;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.*;

public class AgregarAlCarritoStepDefinitions {

    @Before
    public void setStage(){
        setTheStage(new OnlineCast());
    }

    @Dado("que el usuario ingresa a la pagina de falabella")
    public void queElUsuarioIngresaALaPaginaDeFalabella() {
        theActorCalled("Usuario").wasAbleTo(
                Open.url("https://www.falabella.com.co/falabella-co")
        );
    }
    @Cuando("el usuario hace una busqueda de producto y lo selecciona")
    public void elUsuarioHaceUnaBusquedaDeProductoYLoSelecciona() {
        theActorInTheSpotlight().attemptsTo(
                HomeTask.fromHome(),
                ListaResultadosTask.listaResultados()
        );
    }
    @Cuando("modifica la cantidad del producto y lo agrega al carrito")
    public void modificaLaCantidadDelProductoYLoAgregaAlCarrito() {

        theActorInTheSpotlight().attemptsTo(
                ProductoTask.agregarProducto(),
                ObtenerValorElemento.nombre()
        );
    }
    @Entonces("el usuario ve el mismo nombre y cantidad del producto seleccionado en el carrito")
    public void elUsuarioVeElNombreDelProductoEnElExcel() {

        theActorInTheSpotlight().should(
                seeThat(ValidarNomProdQuestion.from(), Matchers.equalTo(true)),
                seeThat(ValidarCantidadProd.from(), Matchers.equalTo(true))
        );
    }

}
