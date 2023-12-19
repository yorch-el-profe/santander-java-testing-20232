package org.bedu.sesion01;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.bedu.sesion01.exception.InvalidSequenceException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class BalancedParenthesesTest {
    
    @Test
    @DisplayName("Empty sequence should be valid")
    public void emptyCase() throws InvalidSequenceException {
        boolean result = BalancedParentheses.isBalanced("");

        assertEquals(true, result);
    }

    @Test
    @DisplayName("Non-parentheses sequence should be invalid")
    public void nonParenthesesCase() {
        assertThrows(InvalidSequenceException.class, () -> BalancedParentheses.isBalanced("abc"));
    }
}
