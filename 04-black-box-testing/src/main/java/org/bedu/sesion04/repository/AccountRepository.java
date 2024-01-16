package org.bedu.sesion04.repository;

import java.util.List;
import java.util.Optional;

import org.bedu.sesion04.model.Account;

import java.util.LinkedList;

public class AccountRepository {
    private List<Account> data;

    public AccountRepository() {
        data = new LinkedList<>();
    }

    public AccountRepository(List<Account> data) {
        this.data = data;
    }

    public Optional<Account> findById(long id) {
        for (Account account : data) {
            if (account.getId() == id) {
                return Optional.of(account);
            }
        }

        return Optional.empty();
    }

    /*
     * public Optional<Account> findById(long id) {
     * return data.stream().filter(x -> x.getId() == id).findFirst();
     * }
     */
}
