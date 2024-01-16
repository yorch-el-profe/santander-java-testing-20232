Feature: Account withdrawal

  Scenario: The account has enough balance
    Given a debit card with PIN "0000" and associated to the account 78957645
    And a bank account with id 78957645 and balance 1000
    When the user inserts the card
    And the user enters the amount 800
    Then the ATM should deliver the money
