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

    public double setValue(double value) {
        return this.value = value;
    }

    public String getReqs() {
        return this.reqs;
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
