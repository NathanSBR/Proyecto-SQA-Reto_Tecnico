package co.sqa.tasks;

import co.sqa.ui.DatepickerPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;

public class SeleccionarDia10ProximoMes implements Task {

    public static SeleccionarDia10ProximoMes enCalendario() {
        return Tasks.instrumented(SeleccionarDia10ProximoMes.class);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(DatepickerPage.DATE_INPUT),
                Click.on(DatepickerPage.NEXT_BUTTON),
                Click.on(DatepickerPage.DAY("10"))
        );
    }
}
