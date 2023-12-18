package org.bedu.sesion01;

import org.bedu.sesion01.util.PlayerInput;
import static org.bedu.sesion01.util.PlayerInput.*;
import org.bedu.sesion01.util.GameResult;
import static org.bedu.sesion01.util.GameResult.*;

// Este ejemplo se usará para introducir al alumno a las pruebas unitarias.
// Es importante resaltar al alumno que es posible escribir código
// y verificar su correcto funcionamiento a partir de pruebas unitarias, sin 
// la necesidad de escribir una aplicación Java (clase con método main por ejemplo)

// A pesar de que existen soluciones más cortas, ésta podría ser más fácil de entender
// para el alumno.

public class RockPaperScissors {

  // Se utiliza un método estático porque no tiene sentido crear una
  // instancia de la clase
  public static GameResult play(PlayerInput player1, PlayerInput player2) {
    if (player1 == player2) {
      return TIE;
    }

    // El resultado es con base en la jugada del jugador 1
    switch (player1) {

      // Si el jugador 1 elegió "piedra", entonces la única manera de que gane es
      // si el otro jugador elegió "tijeras"
      case ROCK:
        return player2 == SCISSORS ? PLAYER_ONE_WINS : PLAYER_TWO_WINS;

      // Si el jugador 1 elegió "papel", entonces la única manera de que gane es
      // si el otro jugador elegió "piedra"
      case PAPER:
        return player2 == ROCK ? PLAYER_ONE_WINS : PLAYER_TWO_WINS;

      // Si el jugador 1 elegió "tijeras" (caso default), entonces la única manera de
      // que gane es
      // si el otro jugador elegió "papel"
      default:
        return player2 == PAPER ? PLAYER_ONE_WINS : PLAYER_TWO_WINS;
    }
  }
}
