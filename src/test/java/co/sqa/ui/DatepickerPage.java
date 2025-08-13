package co.sqa.ui;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class DatepickerPage {
    public static final String URL = "https://jqueryui.com/datepicker/";

    public static final Target DEMO_IFRAME = Target.the("iframe del demo")
            .located(By.cssSelector(".demo-frame"));

    public static final Target DATE_INPUT = Target.the("campo de fecha")
            .located(By.id("datepicker"));

    public static final Target NEXT_BUTTON = Target.the("botón siguiente")
            .located(By.cssSelector(".ui-datepicker-next"));

    public static Target DAY(String day) {
        // Los días del mes actual aparecen como enlaces <a> con el número
        return Target.the("día " + day)
                .located(By.xpath("//table[contains(@class,'ui-datepicker-calendar')]//a[text()='" + day + "']"));
    }
}
