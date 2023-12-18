package org.bedu.sesion01;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.bedu.sesion01.util.GameResult;
import static org.bedu.sesion01.util.GameResult.*;
import static org.bedu.sesion01.util.PlayerInput.*;
import org.junit.jupiter.api.Test;

// Dividimos las pruebas en 3 partes:
// Casos donde el jugador 1 gana
// Casos donde el jugador 2 gana
// Empates

// Explicar al alumno sobre la AAA del testing.
// Arrange - Configuraciones previas (se verá en el ejemplo 03)
// Act - Ejecución del código a probar
// Assert - Verificar el resultado esperado
public class RockPaperScissorsTest {

  // Para que las pruebas puedan ser reconocidas
  // se debe usar la anotación @Test
  @Test
  public void playerOneVictoryCases() {
    GameResult result1 = RockPaperScissors.play(ROCK, SCISSORS);
    GameResult result2 = RockPaperScissors.play(PAPER, ROCK);
    GameResult result3 = RockPaperScissors.play(SCISSORS, PAPER);

    assertEquals(result1, PLAYER_ONE_WINS);
    assertEquals(result2, PLAYER_ONE_WINS);
    assertEquals(result3, PLAYER_ONE_WINS);
  }

  @Test
  public void playerTwoVictoryCases() {
    GameResult result1 = RockPaperScissors.play(ROCK, PAPER);
    GameResult result2 = RockPaperScissors.play(PAPER, SCISSORS);
    GameResult result3 = RockPaperScissors.play(SCISSORS, ROCK);

    assertEquals(result1, PLAYER_TWO_WINS);
    assertEquals(result2, PLAYER_TWO_WINS);
    assertEquals(result3, PLAYER_TWO_WINS);
  }

  @Test
  public void tieCases() {
    GameResult result1 = RockPaperScissors.play(ROCK, ROCK);
    GameResult result2 = RockPaperScissors.play(PAPER, PAPER);
    GameResult result3 = RockPaperScissors.play(SCISSORS, SCISSORS);

    assertEquals(result1, TIE);
    assertEquals(result2, TIE);
    assertEquals(result3, TIE);
  }
}
