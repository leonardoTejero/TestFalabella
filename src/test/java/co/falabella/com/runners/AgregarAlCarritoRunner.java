package co.falabella.com.runners;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)

@CucumberOptions(
        features = "src/test/resources/features/",
        tags = "@AgregarAlCarrito",
        glue = "co.falabella.com.stepDefinitions",
        snippets = CucumberOptions.SnippetType.CAMELCASE
)

public class AgregarAlCarritoRunner {
}
