package org.bedu.sesion06;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class BalancedParenthesisTest {
  
  @Test
  @DisplayName("Empty sequence should be valid")
  public void baseCase() {
    String sequence = "";

    boolean result = BalancedParenthesis.isBalanced(sequence);

    assertTrue(result);
  }

  @Test
  @DisplayName("One character sequence should be invalid")
  public void oneCharacterSequence() {
    String sequence = ")";

    boolean result = BalancedParenthesis.isBalanced(sequence);

    assertFalse(result);
  }

  @Test
  @DisplayName("Non-parenthesis sequences should be invalid")
  public void nonParenthesisSequences() {
    String sequence = "jkhad17632871623hkjdaskjh;._";
    String sequence2 = "(a())";

    boolean result = BalancedParenthesis.isBalanced(sequence);
    boolean result2 = BalancedParenthesis.isBalanced(sequence2);

    assertFalse(result);
    assertFalse(result2);
  }

  @Test
  @DisplayName("Very basic sequence () should be valid")
  public void veryBasicSequence() {
    String sequence = "()";

    boolean result = BalancedParenthesis.isBalanced(sequence);

    assertTrue(result);
  }

  @Test
  @DisplayName("Simple sequence ((())) should be valid")
  public void simpleSequence() {
    String sequence = "(((((((())))))))";

    boolean result = BalancedParenthesis.isBalanced(sequence);

    assertTrue(result);
  }

  @Test
  @DisplayName("Very basic sequence )( should be invalid")
  public void veryBasicSequenceInvalid() {
    String sequence = ")(";

    boolean result = BalancedParenthesis.isBalanced(sequence);

    assertFalse(result);
  }

  @Test
  @DisplayName("Complex sequence (()(())) should be valid")
  public void complexSequence() {
    String sequence = "(((())(()(((()))))()))";

    boolean result = BalancedParenthesis.isBalanced(sequence);

    assertTrue(result);
  }

  @ParameterizedTest
  @ValueSource(strings = {"))))", ")))))))", "(((("})
  @DisplayName("Weird sequence )))) should be invalid")
  public void weirdSequence(String sequence) {
    boolean result = BalancedParenthesis.isBalanced(sequence);
    assertFalse(result);
  }
}