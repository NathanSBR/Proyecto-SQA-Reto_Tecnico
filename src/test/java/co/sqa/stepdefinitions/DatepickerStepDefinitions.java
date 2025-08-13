package co.sqa.stepdefinitions;

import co.sqa.tasks.AbrirElDatepicker;
import co.sqa.tasks.SeleccionarDia10ProximoMes;
import co.sqa.tasks.SeleccionarDia15MesActual;
import co.sqa.ui.DatepickerPage;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.questions.Attribute;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Entonces;
import org.assertj.core.api.Assertions;

import java.time.LocalDate;

public class DatepickerStepDefinitions {

    private Actor actor() {
        return Serenity.sessionVariableCalled("actor");
    }

    @Dado("que Jonathan abre la página del Datepicker")
    public void queJonathanAbreLaPaginaDelDatepicker() {
        actor().attemptsTo(AbrirElDatepicker.pagina());
    }

    @Cuando("selecciona el día {int} del mes actual")
    public void seleccionaElDiaDelMesActual(Integer dia) {
        if (dia != 15) throw new IllegalArgumentException("Este paso espera el día 15");
        actor().attemptsTo(SeleccionarDia15MesActual.enCalendario());
    }

    @Entonces("el campo de fecha debe mostrar la fecha del día {int} del mes actual")
    public void elCampoMuestraFechaDiaMesActual(Integer dia) {
        LocalDate now = LocalDate.now();
        String mes = String.format("%02d", now.getMonthValue());
        String valor = Attribute.of(DatepickerPage.DATE_INPUT)
                .named("value").asString().answeredBy(actor());
        Assertions.assertThat(valor).matches("^" + mes + "/" + String.format("%02d", dia) + "/\\d{2,4}$");
    }

    @Cuando("selecciona el día {int} del próximo mes")
    public void seleccionaElDiaDelProximoMes(Integer dia) {
        if (dia != 10) throw new IllegalArgumentException("Este paso espera el día 10");
        actor().attemptsTo(SeleccionarDia10ProximoMes.enCalendario());
    }

    @Entonces("el campo de fecha debe mostrar la fecha del día {int} del próximo mes")
    public void elCampoMuestraFechaDiaProximoMes(Integer dia) {
        LocalDate next = LocalDate.now().plusMonths(1);
        String mes = String.format("%02d", next.getMonthValue());
        String valor = Attribute.of(DatepickerPage.DATE_INPUT)
                .named("value").asString().answeredBy(actor());
        Assertions.assertThat(valor).matches("^" + mes + "/" + String.format("%02d", dia) + "/\\d{2,4}$");
    }

    @Cuando("intenta escribir manualmente una fecha en el campo")
    public void intentaEscribirManual() {
        actor().attemptsTo(
                net.serenitybdd.screenplay.actions.Enter.theValue("01/01/2030")
                        .into(DatepickerPage.DATE_INPUT)
        );
    }

    @Entonces("no debería poder escribir manualmente la fecha (solo mediante calendario)")
    public void noDeberiaPoderEscribir() {
        String valor = Attribute.of(DatepickerPage.DATE_INPUT)
                .named("value").asString().answeredBy(actor());
        // En la demo jQueryUI este assert falla (el input es editable).
        Assertions.assertThat(valor).isEmpty();
    }
}
