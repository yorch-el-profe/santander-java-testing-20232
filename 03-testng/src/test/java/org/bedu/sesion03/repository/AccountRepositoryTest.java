package org.bedu.sesion03.repository;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.bedu.sesion03.model.Account;
import java.util.Optional;

public class AccountRepositoryTest {

    private AccountRepository repository;

    // JUnit: @BeforeAll
    // TestNG
    @BeforeClass
    public void setup() {
        repository = new AccountRepository();
    }

    @Test(description = "Repository should be empty")
    public void test() {
        long id = 786324786;

        Optional<Account> result = repository.findById(id);

        Assert.assertFalse(result.isPresent());
    }
}
