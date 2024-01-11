package org.bedu.sesion03;

import org.bedu.sesion03.model.Card;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ATMTest {

    private ATM atm;

    @BeforeClass
    public void setup() {
        atm = new ATM();
    }

    @Test(description = "ATM should accept a card")
    public void insertCard() {
        Card card = new Card("1234", 876786);

        atm.insertCard(card);

        Card insertedCard = atm.getCard();
        Assert.assertEquals(insertedCard.getPin(), card.getPin());
        Assert.assertEquals(insertedCard.getAccountId(), card.getAccountId());
    }

    @Test(description = "ATM should validate a correct PIN")
    public void correctPin() {
        Card card = new Card("0000", 897982);
        atm.insertCard(card);

        boolean isValid = atm.validatePin("0000");

        Assert.assertTrue(isValid);
    }

    @Test(description = "ATM should validate an incorrect PIN")
    public void incorrectPin() {
        Card card = new Card("0000", 897982);
        atm.insertCard(card);

        boolean isValid = atm.validatePin("12345");

        Assert.assertFalse(isValid);
    }
}
