package org.bedu.sesion03;
import java.util.Optional;

import org.bedu.sesion03.exception.InvalidWithdrawException;
import org.bedu.sesion03.exception.UnexistingAccountException;
import org.bedu.sesion03.model.Account;
import org.bedu.sesion03.model.Card;
import org.bedu.sesion03.repository.AccountRepository;

public class ATM {

  private Card card;
  private Account account;
  private AccountRepository repository;

  public ATM() {
    repository = new AccountRepository();
  }

  public void insertCard(Card card) {
    this.card = card;
  }

  public boolean validatePin(String pin) {
    return card.getPin().equals(pin);
  }

  public void loadAccount() throws UnexistingAccountException {
    Optional<Account> result = repository.findById(card.getAccountId());

    if (!result.isPresent()) {
        throw new UnexistingAccountException();
    }

    account = result.get();
  }

  public void withdraw(long amount) throws InvalidWithdrawException {
    if (amount > account.getAmount()) {
      throw new InvalidWithdrawException();
    }

    account.setAmount(account.getAmount() - amount);
  }

  public void exit() {
    card = null;
    account = null;
  }
}