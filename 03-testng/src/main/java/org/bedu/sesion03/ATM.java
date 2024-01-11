package org.bedu.sesion03;

import java.util.Optional;

import org.bedu.sesion03.exception.InsufficientBalanceException;
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

    // Se inserta una tarjeta al cajero
    public void insertCard(Card card) {
        this.card = card;
    }

    // Se valida si el PIN es correcto
    public boolean validatePin(String pin) {
        return card.getPin().equals(pin);
    }

    // Se carga la información de la cuenta
    public void loadAccount() throws UnexistingAccountException {
        long id = card.getAccountId();

        Optional<Account> result = repository.findById(id);

        if (!result.isPresent()) {
            throw new UnexistingAccountException();
        }

        account = result.get();
    }

    // Permitir retirar dinero de la cuenta
    public void withdraw(long amount) throws InsufficientBalanceException {
        if (amount > account.getAmount()) {
            throw new InsufficientBalanceException();
        }

        account.setAmount(account.getAmount() - amount);
    }

    // Salir de la cuenta
    public void exit() {
        card = null;
        account = null;
    }
}
