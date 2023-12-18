package org.bedu.sesion01;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.bedu.sesion01.exception.InvalidSequenceException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class BalancedParenthesesTest {

  // Agregamos @DisplayName para cambiar el nombre de la prueba
  // en el reporte y sea más fácil interpretarlo.

  // Incentivar al alumno a escribir el nombre de sus pruebas en inglés
  // como buena práctica
  @Test
  @DisplayName("Empty sequence should be valid")
  public void emptySequenceCase() throws InvalidSequenceException {
    boolean result = BalancedParentheses.isBalanced("");
    assertTrue(result);
  }

  // Dejar que los alumnos den sus casos de prueba
  @Test
  @DisplayName("Balanced sequences should be valid")
  public void balancedSequencesCase() throws InvalidSequenceException {
    boolean result1 = BalancedParentheses.isBalanced("()");
    boolean result2 = BalancedParentheses.isBalanced("(())");
    boolean result3 = BalancedParentheses.isBalanced("()()(((())()))");

    assertTrue(result1);
    assertTrue(result2);
    assertTrue(result3);
  }

  // Igual aquí xd
  @Test
  @DisplayName("Unbalanced sequences should be invalid")
  public void unbalancedSequencesCase() throws InvalidSequenceException {
    boolean result1 = BalancedParentheses.isBalanced(")");
    boolean result2 = BalancedParentheses.isBalanced("(");
    boolean result3 = BalancedParentheses.isBalanced(")(");
    boolean result4 = BalancedParentheses.isBalanced(")()");
    boolean result5 = BalancedParentheses.isBalanced("()()())");

    assertFalse(result1);
    assertFalse(result2);
    assertFalse(result3);
    assertFalse(result4);
    assertFalse(result5);
  }

  // Ejemplos donde explicaremos al alumno qué pasa con los casos
  // cuando el código arroja excepciones
  @Test
  @DisplayName("Null sequence should throw an exception")
  public void nullSequenceCase() {
    assertThrows(InvalidSequenceException.class, () -> BalancedParentheses.isBalanced(null));
  }

  @Test
  @DisplayName("Non-parentheses sequence should throw an exception")
  public void nonParenthesesSequenceCase() {
    assertThrows(InvalidSequenceException.class, () -> BalancedParentheses.isBalanced("abc"));
  }
}
