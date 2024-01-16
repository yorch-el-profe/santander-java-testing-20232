Feature: Validate card PIN
# Formula Given When Then
# Given: Dar un contexto
# When: Acción que sucede
# Then: La evaluación del resultado esperado
# Dado un usuario en una llamada activa por Zoom
# Cuando presiona el botón de "MUTE"
# Entonces debería silenciar al usuario
# Dado un usuario en la página de Youtube
# Y el usuario no tiene sesión
# Cuando de click en la opción de "Iniciar Sesión"
# Entonces debería mostrar una ventana con un formulario para iniciar sesión
# Dado un usuario en la página de Youtube
# Y el usuario no tiene sesión
# Y se encuentra en la ventana del formulario para iniciar sesión
# Cuando ingrese su correo electrónico "paquito@gmail.com"
# Y su contraseña "123564123465"
# Y de click en el botón de Enviar
# Entonces debería iniciar sesión
# Y ser redirigido a la página principal

  Scenario: User enters a correct PIN
    Given a debit card with PIN "1234" and associated to the account 897987645
    When the user inserts the card
    And enters the PIN "1234"
    Then the ATM should give access to the user

  Scenario: User enters a wrong PIN
    Given a debit card with PIN "0000" and associated to the account 78957645
    When the user inserts the card
    And enters the PIN "6579"
    Then the ATM should deny the access to the user
