package ru.job4j.bank;

public class Account {
    private double value;
    private String reqs;


    public Account(double value, String requisites) {
        this.value = value;
        this.reqs = requisites;
    }

    public double getValue() {
        return this.value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public String getReqs() {
        return this.reqs;
    }

    boolean transfer(Account destination, double amount) {
        boolean success = false;
        if (amount > 0 && amount < this.value) {
            this.value -= amount;
            destination.value += amount;
            success = true;
        }
        return success;
    }

    public String toString() {
        String otvet;
        otvet = "Account{" + "values=" + value + ", reqs='" + reqs + "\\" + "}";
        return otvet;
    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Account account = (Account) o;

        return this.reqs.equals(account.reqs);
    }

    public int hashCode() {
        return this.reqs.hashCode();
    }
}
