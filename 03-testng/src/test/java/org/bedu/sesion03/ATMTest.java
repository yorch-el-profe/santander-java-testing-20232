package org.bedu.sesion03;

import org.bedu.sesion03.exception.UnexistingAccountException;
import org.bedu.sesion03.model.Card;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ATMTest {
    
    private ATM atm;

    @BeforeClass
    public void setup() {
        atm = new ATM();
    }

    @AfterClass
    public void exit() {
        atm.exit();
    }

    @BeforeMethod
    public void insertCard() {
        Card card = new Card("1234", 8972384);
        atm.insertCard(card);
    }

    @Test(description = "ATM should allow access if card PIN is correct")
    public void correctCardPinCase() {
        boolean access = atm.validatePin("1234");

        Assert.assertTrue(access);
    }

    @Test(description = "ATM should deny access if card PIN is incorrect")
    public void incorrectCardPinCase() {
        boolean access = atm.validatePin("0000");

        Assert.assertFalse(access);
    }

    @Test(description = "ATM should throw an error if cannot load the account")
    public void cantLoadAccountCase() {
        Assert.assertThrows(UnexistingAccountException.class, () -> atm.loadAccount());
    }
}
