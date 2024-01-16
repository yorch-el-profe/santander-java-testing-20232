package org.bedu.sesion04.stepdefinitions;

import org.bedu.sesion04.ATM;
import org.bedu.sesion04.model.Card;
import org.testng.Assert;

import io.cucumber.java.BeforeAll;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ValidatePinStepDefinition {

    private Card card;
    private static ATM atm;
    private String pin;

    @BeforeAll
    public static void setup() {
        atm = new ATM();
    }

    @Given("a debit card with PIN {string} and associated to the account {long}")
    public void given_debit_card(String pin, long accountId) {
        card = new Card(pin, accountId);
    }

    @When("the user inserts the card")
    public void when_inserts_card() {
        atm.insertCard(card);
    }

    @And("enters the PIN {string}")
    public void enters_pin(String pin) {
        this.pin = pin;
    }

    @Then("the ATM should give access to the user")
    public void give_access_to_user() {
        Assert.assertTrue(atm.validatePin(pin));
    }

    @Then("the ATM should deny the access to the user")
    public void deny_access_to_user() {
        Assert.assertFalse(atm.validatePin(pin));
    }
}
