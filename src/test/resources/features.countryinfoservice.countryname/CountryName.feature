Feature: Yo como usuario quiero ingresar al servicio
  web DataFlex para obtener información sobre el país.

  Scenario: Consulta exitosa
    Given El usuario ha definido como código ISO "AD"
    When El usuario ejecuta la solicitud
    Then El usuario debería obtener "Andorra".


