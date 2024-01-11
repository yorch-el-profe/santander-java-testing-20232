package org.bedu.sesion03.repository;

import java.util.List;
import java.util.Optional;
import java.util.LinkedList;
import org.bedu.sesion03.model.Account;

public class AccountRepository {
    private List<Account> data;

    public AccountRepository() {
        data = new LinkedList<>();
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
