Feature: Validate card PIN

  Scenario: Correct PIN
    Given a debit card with PIN "1234" and associated to the account 78189273
    When the user inserts the card
    And enters the PIN "1234"
    Then the ATM should access to user account
