package co.falabella.com.ui;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class HomeUI {
    public static final Target INPUT_BUSCAR = Target.the("Input barra de búsqueda")
            .located(By.id("testId-SearchBar-Input"));
    public static final Target BTN_COOKIES = Target.the("Input barra de búsqueda")
            .located(By.id("testId-accept-cookies-btn"));
}
