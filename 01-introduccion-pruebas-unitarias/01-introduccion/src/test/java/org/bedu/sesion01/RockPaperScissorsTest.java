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
    GameResult result2 = RockPaperScissors.play(PlayerInput.ROCK, PlayerInput.ROCK);
    GameResult result3 = RockPaperScissors.play(PlayerInput.SCISSORS, PlayerInput.SCISSORS);

    // Assert
    // Verificar que el resultado sea "TIE"
    assertEquals(result1, GameResult.TIE);
    assertEquals(result2, GameResult.TIE);
    assertEquals(result3, GameResult.TIE);
  }

  @Test
  public void playerOneCases() {
    // Act
    GameResult result1 = RockPaperScissors.play(PlayerInput.ROCK, PlayerInput.SCISSORS);
    GameResult result2 = RockPaperScissors.play(PlayerInput.PAPER, PlayerInput.ROCK);
    GameResult result3 = RockPaperScissors.play(PlayerInput.SCISSORS, PlayerInput.PAPER);

    // Assert
    // Verificar que el resultado sea "PLAYER_ONE_WINS"
    assertEquals(result1, GameResult.PLAYER_ONE_WINS);
    assertEquals(result2, GameResult.PLAYER_ONE_WINS);
    assertEquals(result3, GameResult.PLAYER_ONE_WINS);
  }

  @Test
  public void playerTwoCases() {
    // Act
    GameResult result1 = RockPaperScissors.play(PlayerInput.ROCK, PlayerInput.PAPER);
    GameResult result2 = RockPaperScissors.play(PlayerInput.PAPER, PlayerInput.SCISSORS);
    GameResult result3 = RockPaperScissors.play(PlayerInput.SCISSORS, PlayerInput.ROCK);

    // Assert
    assertEquals(result1, GameResult.PLAYER_TWO_WINS);
    assertEquals(result2, GameResult.PLAYER_TWO_WINS);
    assertEquals(result3, GameResult.PLAYER_TWO_WINS);
  }
}
