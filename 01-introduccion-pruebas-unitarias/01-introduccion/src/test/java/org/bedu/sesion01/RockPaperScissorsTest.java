package org.bedu.sesion01;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.bedu.sesion01.util.GameResult;
import org.bedu.sesion01.util.PlayerInput;
import org.junit.jupiter.api.Test;

// AAA

// Arrange - Configuraciones previas / Precondiciones
// Act - Ejecución del código a probar
// Assert - Verificación / Evaluación del resultado esperado
public class RockPaperScissorsTest {

  @Test
  public void tieCases() {
    // Act
    // La ejecución del método "play" con parámetros iguales
    GameResult result1 = RockPaperScissors.play(PlayerInput.PAPER, PlayerInput.PAPER);

    // Assert
    // Verificar que el resultado sea "TIE"
    assertEquals(result1, GameResult.TIE);
  }
}
