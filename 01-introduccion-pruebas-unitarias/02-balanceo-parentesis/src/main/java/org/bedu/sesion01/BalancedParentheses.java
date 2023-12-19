package org.bedu.sesion01;

import org.bedu.sesion01.exception.InvalidSequenceException;

public class BalancedParentheses {

    public static boolean isBalanced(String sequence) throws InvalidSequenceException {
        int counter = 0;

        for (int i = 0; i < sequence.length(); i++) {
            char current = sequence.charAt(i);

            if (current != ')' && current != '(') {
                throw new InvalidSequenceException();
            }

            if (current == '(') {
                counter++;
            } else {
                counter--;

                if (counter < 0) {
                    return false;
                }
            }
        }

        return counter == 0;
    }
}