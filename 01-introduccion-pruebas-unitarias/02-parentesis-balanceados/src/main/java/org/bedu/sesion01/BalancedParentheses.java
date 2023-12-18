package org.bedu.sesion01;

import java.util.Stack;

import org.bedu.sesion01.exception.InvalidSequenceException;

// Problema: Crear un programa que dada una secuencia de paréntesis ()
// indique si está balanceada o no.

public class BalancedParentheses {

  // Se utiliza un método estático porque no tiene sentido crear una
  // instancia de la clase
  public static boolean isBalanced(String sequence) throws InvalidSequenceException {

    // Se utiliza una pila para facilitar la implementación del algoritmo
    // pero podrían usarse contadores por ejemplo
    Stack<Character> parentheses = new Stack<>();

    // Podría usarse como ejemplo para fomentar al alumno a pensar
    // en nuevos casos al momento de escribir las pruebas
    if (sequence == null) {
      throw new InvalidSequenceException();
    }

    // La idea es simple, recorrer la secuencia caracter por caracter:
    // 1. Si encontramos un paréntesis que abre, lo agregamos a la pila
    // 2. Si encontramos un paréntesis que cierra (caso else):
    // 2.1. Si la pila está vacía quiere decir que no hay paréntesis que abren
    // que coincidan con el que cierra, por lo tanto la secuencia es incorrecta.
    // 2.2 En otro caso, quitamos un paréntesis que abre de la pila.
    for (int i = 0; i < sequence.length(); i++) {
      char current = sequence.charAt(i);

      if (current != '(' && current != ')') {
        throw new InvalidSequenceException();
      }

      if (current == '(') {
        parentheses.push(current);
      } else if (parentheses.isEmpty()) {
        return false;
      } else {
        parentheses.pop();
      }
    }

    return parentheses.isEmpty();
  }
}
