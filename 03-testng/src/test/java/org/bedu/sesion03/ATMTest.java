package org.bedu.sesion03;

import java.util.LinkedList;
import java.util.List;

import org.bedu.sesion03.exception.InsufficientBalanceException;
import org.bedu.sesion03.exception.UnexistingAccountException;
import org.bedu.sesion03.model.Account;
import org.bedu.sesion03.model.Card;
import org.bedu.sesion03.repository.AccountRepository;
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

    @Test(description = "ATM should throw an error if the balance is insufficient")
    public void insufficientBalance() throws UnexistingAccountException {
        // Precondición:
        Card card = new Card("0000", 676784);
        Account account = new Account(676784, 500);

        List<Account> data = new LinkedList<>();
        data.add(account);
        AccountRepository customRepository = new AccountRepository(data);

        atm = new ATM(customRepository);
        atm.insertCard(card);
        atm.loadAccount();

        // El código a probar
        Assert.assertThrows(InsufficientBalanceException.class, () -> atm.withdraw(600));
    }
}
