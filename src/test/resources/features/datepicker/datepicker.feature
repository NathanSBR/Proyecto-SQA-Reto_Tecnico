Feature: Automatizar el Datepicker de jQueryUI

  Background:
    Given que Jonathan abre la página del Datepicker

  Scenario: Scenario 1 - Reserva de una cita seleccionando el día 15 del mes actual
    When selecciona el día 15 del mes actual
    Then el campo de fecha debe mostrar la fecha del día 15 del mes actual

  Scenario: Scenario 2 - Selección del día 10 del próximo mes
    When selecciona el día 10 del próximo mes
    Then el campo de fecha debe mostrar la fecha del día 10 del próximo mes

  @manual-edit-blocked
  Scenario: Scenario 3 - Validación de campo bloqueado para edición manual
    When intenta escribir manualmente una fecha en el campo
    Then no debería poder escribir manualmente la fecha (solo mediante calendario)

