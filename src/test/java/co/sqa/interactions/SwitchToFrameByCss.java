package co.sqa.interactions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SwitchToFrameByCss implements Interaction {

    private final String css;

    public SwitchToFrameByCss(String css) {
        this.css = css;
    }

    public static SwitchToFrameByCss using(String css) {
        return Tasks.instrumented(SwitchToFrameByCss.class, css);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        WebDriver driver = BrowseTheWeb.as(actor).getDriver();
        WebElement iframe = driver.findElement(By.cssSelector(css));
        driver.switchTo().frame(iframe);
    }
}
