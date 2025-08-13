# Reto SQA – Automatizar Datepicker de jQueryUI con Serenity BDD (Screenplay)

Automatización de un datepicker (jQueryUI) usando **Serenity BDD + Screenplay + Cucumber**.

## 🧰 Tech stack
- Java 17
- Maven 3.9+
- Serenity BDD (Screenplay)
- Selenium 4 + WebDriver Manager (Selenium Manager)
- Cucumber / Gherkin
- Chrome (última versión)

## 🚀 Cómo ejecutar

Desde la raíz del proyecto:

```bash
# Todos los escenarios (excepto los marcados @manual-edit-blocked)
mvn clean verify -Dcucumber.filter.tags="not @manual-edit-blocked"

# Ejecutar un escenario por nombre
mvn clean verify -Dcucumber.filter.name="Scenario 2 - Selección del día 10 del próximo mes"

# Modo headless (útil en CI)
mvn clean verify -Dheadless=true -Dcucumber.filter.tags="not @manual-edit-blocked"
