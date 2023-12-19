package org.bedu.sesion01;

import org.bedu.sesion01.util.GameResult;
import static org.bedu.sesion01.util.GameResult.*;
import org.bedu.sesion01.util.PlayerInput;
import static org.bedu.sesion01.util.PlayerInput.*;

public class RockPaperScissors {

  public static GameResult play(PlayerInput player1, PlayerInput player2) {

    if (player1 == player2) {
      return TIE;
    }

    switch (player1) {
      case ROCK:
        return player2 == SCISSORS ? PLAYER_ONE_WINS : PLAYER_TWO_WINS;

      case PAPER:
        return player2 == ROCK ? PLAYER_ONE_WINS : PLAYER_TWO_WINS;

      default:
        return player2 == PAPER ? PLAYER_ONE_WINS : PLAYER_TWO_WINS;
    }
  }
}