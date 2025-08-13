package co.sqa.tasks;

import co.sqa.interactions.SwitchToFrameByCss;
import co.sqa.ui.DatepickerPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Open;

public class AbrirElDatepicker implements Task {

    public static AbrirElDatepicker pagina() {
        return Tasks.instrumented(AbrirElDatepicker.class);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Open.url(DatepickerPage.URL),
                SwitchToFrameByCss.using(".demo-frame")
        );
    }
}
