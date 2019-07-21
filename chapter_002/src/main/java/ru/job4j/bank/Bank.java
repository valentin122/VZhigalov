package ru.job4j.bank;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

public class Bank {

    private TreeMap<User, ArrayList<Account>> treemap = new TreeMap<>();

    public User getUser(String passport) {
        User result = null;
        for (User user : treemap.keySet()) {
            if (user.getPassport() == passport) {
                result = user;
            }
        }
        return result;
    }

    public void addUser(User user) {
        treemap.putIfAbsent(user, new ArrayList<Account>());
    }

    public void deleteUser(User user) {
        this.treemap.remove(user);
    }

    public void addAccountToUser(String passport, Account account) {
        treemap.get(getUser(passport)).add(account);
    }

    public void deleteAccountFromUser(String passport, Account account) {
        treemap.get(getUser(passport)).remove(account);
    }

    public List<Account> getUserAccounts(String passport) {
        ArrayList<Account> result = new ArrayList<>();
        for (User user : treemap.keySet()) {
            if (user.getPassport() == passport) {
                result = treemap.get(user);
                break;
            }
        }
        return result;
    }

    public Account getAccountOfRequisite(String passport, String requisite) {
        Account result = null;
        for (Account account : getUserAccounts(passport)){
            if (account.getReqs() == requisite) {
                result = account;
                break;
            }
        }
        return result;
    }

    public boolean transferMoney(String srcPassport, String srcRequisite, String destPassport, String destRequisite, double amount) {
        boolean transferSuccess = false;
        double srcValue = getAccountOfRequisite(srcPassport, srcRequisite).getValue();

        System.out.println(srcValue);

        double destValueBefore = getAccountOfRequisite(destPassport, destRequisite).getValue();
        if (amount > 0 && amount < srcValue) {
            double destValue = destValueBefore + amount;
            getAccountOfRequisite(destPassport, destRequisite).setValue(destValue);
            transferSuccess = true;
            System.out.println(destValue);
        }
       return transferSuccess;
    }

    public String toString() {
        return "Bank{" + "accounts=" + treemap + "}";
    }
}
