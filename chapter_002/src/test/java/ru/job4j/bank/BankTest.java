package ru.job4j.bank;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNull.nullValue;
import static org.junit.Assert.assertThat;

public class BankTest {
    Bank bank = new Bank();
    User user = new User("Vasya", "passport");

    @Before
    public void addUser() {
        System.out.println("execute before method");
        bank.addUser(user);
    }

    @Test
    public void whenAddUserThenUser() {
        String result = bank.getUser("passport").getName();
        String expect = user.getName();
        assertThat(expect, is(result));
    }

    @Test
    public void whenDeleteUserThenNull() {
        bank.deleteUser(bank.getUser("passport"));
        assertThat(bank.getUser("passport"), is(nullValue()));
    }

    @Test
    public void whenAddTwoAccountsToUserAndDelOne() {
        Account account1 = new Account(1.1, "11");
        Account account2 = new Account(2.2, "22");
        bank.addAccountToUser("passport", account1);
        bank.addAccountToUser("passport", account2);
        bank.deleteAccountFromUser("passport", account1);
        double expect = bank.getUserAccounts("passport").get(0).getValue();
        assertThat(expect, is(account2.getValue()));
    }
    @Test
    public void whenTransferSuccess() {
        Account account1 = new Account(1.1, "11");
        Account account2 = new Account(2.2, "22");
        bank.addAccountToUser("passport", account1);
        bank.addAccountToUser("passport", account2);
        boolean resultTransfer = bank.transferMoney("passport", "11", "passport", "22", 0.1);
        assertThat(resultTransfer, is(true));
    }
}
