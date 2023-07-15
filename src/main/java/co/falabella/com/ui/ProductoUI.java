package co.falabella.com.ui;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class ProductoUI {
    public static final Target INPUT_CANTIDAD_PROD = Target.the("seleccionar la cantidad de productos")
            .located(By.id("quantity-selector-increment-input"));
    public static final Target BTN_AGREGAR_CARRITO = Target.the("Boton para agregar el producto al carrito")
            .located(By.id("add-to-cart-button"));
    public static final Target BTN_ABRIR_CARRITO = Target.the("Boton ir al carrito")
            .located(By.id("linkButton"));
    public static final Target LBL_NOMBRE_PROD = Target.the("Nombre del producto")
            .locatedBy("//div[@class=\"jsx-1442607798 product-name fa--product-name false\"]");

    public static final Target MODAL_CARRITO = Target.the("Boton ir al carrito")
            .locatedBy("//div[@class=\"jsx-1941891310 popup small\"]");
}
