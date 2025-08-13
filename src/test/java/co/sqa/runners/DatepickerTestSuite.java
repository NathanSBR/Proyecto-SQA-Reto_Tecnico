// src/test/java/co/sqa/runners/DatepickerTestSuite.java
package co.sqa.runners;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        plugin = {"pretty"},
        features = "src/test/resources/features/datepicker",
        glue = {"co.sqa.stepdefinitions", "co.sqa.setup"},
        snippets = CucumberOptions.SnippetType.CAMELCASE,
        tags = "not @manual-edit-blocked"
)
public class DatepickerTestSuite { }
