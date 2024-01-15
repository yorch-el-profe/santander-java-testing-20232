package org.bedu.sesion04.stepdefinitions;

import org.bedu.sesion04.ATM;
import org.bedu.sesion04.model.Card;
import org.testng.Assert;

import io.cucumber.java.BeforeAll;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ATMStepDefinitions {

    private static ATM atm;
    private Card card;
    private String userPin;

    @BeforeAll
    public static void setup() {
        atm = new ATM();
    }

    @Given("a debit card with PIN {string} and associated to the account {long}")
    public void createCard(String pin, long accountId) {
        card = new Card(pin, accountId);
    }

    @When("the user inserts the card")
    public void insertCard() {
        atm.insertCard(card);
    }

    @And("enters the PIN {string}")
    public void enterPin(String pin) {
        userPin = pin;
    }

    @Then("the ATM should access to user account")
    public void correctPin() {
        Assert.assertTrue(atm.validatePin(userPin));
    }
}
