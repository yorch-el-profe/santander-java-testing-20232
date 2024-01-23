package org.bedu.sesion06;

import java.util.Stack;

public class BalancedParenthesis {

  public static boolean isBalanced(String sequence) {
    // Una secuencia vacía es válida
    if (sequence.isEmpty()) {
      return true;
    }

    Stack<Character> parenthesis = new Stack<>();

    for (int i = 0; i < sequence.length(); i++) {
      char current = sequence.charAt(i);

      if ((current != ')') && (current != '(')) {
        return false;
      }

      if (current == '(') {
        parenthesis.push(current);
      } else if (parenthesis.isEmpty()) {
        return false;
      } else {
        parenthesis.pop();
      }
    }

    return parenthesis.isEmpty();
  }
}