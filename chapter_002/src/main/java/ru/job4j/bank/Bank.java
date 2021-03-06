package ru.job4j.bank;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

public class Bank {

    private TreeMap<User, ArrayList<Account>> treemap = new TreeMap<>();

    public User getUser(String passport) {
        User result = treemap.keySet()
                .stream()
                .filter(e -> e.getPassport()
                        .equalsIgnoreCase(passport))
                .findFirst()
                .orElse(null);
        return result;
    }

    public void addUser(User user) {
        treemap.putIfAbsent(user, new ArrayList<>());
    }

    public void deleteUser(User user) {
        this.treemap.remove(user);
    }

    public void addAccountToUser(String passport, Account account) {
        User user = getUser(passport);
        if (user != null) {
            treemap.get(user).add(account);
        }
    }

    public void deleteAccountFromUser(String passport, Account account) {
        User user = getUser(passport);
        if (user != null) {
            treemap.get(user).remove(account);
        }
    }

    public List<Account> getUserAccounts(String passport) {
        ArrayList<Account> result = new ArrayList<>();
        User user = getUser(passport);
        if (user != null) {
            result = treemap.get(user);
        }
        return result;
    }

    public Account getAccountOfRequisite(String passport, String requisite) {
        Account result = getUserAccounts(passport)
                .stream()
                .filter(x -> x.getReqs()
                        .equalsIgnoreCase(requisite))
                .findFirst()
                .orElse(null);
        return result;
    }

    public boolean transferMoney(String srcPassport, String srcRequisite, String destPassport, String destRequisite, double amount) {
        boolean transferSuccess = false;
        Account accSrc = getAccountOfRequisite(srcPassport, srcRequisite);
        Account accDest = getAccountOfRequisite(destPassport, destRequisite);
        if (!accDest.equals(null) && !accSrc.equals(null)) {
            transferSuccess = accSrc.transfer(accDest, amount);
        }
        return transferSuccess;
    }

    public String toString() {
        return "Bank{" + "accounts=" + treemap + "}";
    }
}
