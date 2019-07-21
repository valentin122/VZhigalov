package ru.job4j.bank;

public class User implements Comparable<User> {
    private String name;
    private String passport;

    public User(String name, String passport) {
        this.name = name;
        this.passport = passport;
    }

    public String getName() {
        return name;
    }

    public String getPassport() {
        return passport;
    }

    @Override
    public int compareTo(User o) {
        return this.name.compareTo(o.name);
    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        User user = (User) o;
        if (this.getPassport() != ((User) o).getPassport()) {
            return false;
        }
        return this.name.equals(user.name);
    }
    @Override
    public int hashCode() {
        int result = this.getName().hashCode();
        result += this.passport.hashCode();
        return result;
    }
}
