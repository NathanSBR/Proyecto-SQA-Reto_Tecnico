package co.sqa.setup;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
// OJO: usamos el Managed "nuevo" de serenitybdd:
import net.serenitybdd.annotations.Managed;
import org.openqa.selenium.WebDriver;
import io.cucumber.java.Before;

public class Hooks {

    @Managed(driver = "chrome")
    protected WebDriver hisBrowser;

    public static final String ACTOR_KEY = "actor";

    @Before
    public void setUp() {
        Actor jonathan = Actor.named("Jonathan");
        jonathan.can(BrowseTheWeb.with(hisBrowser));
        Serenity.setSessionVariable(ACTOR_KEY).to(jonathan);
    }
}
