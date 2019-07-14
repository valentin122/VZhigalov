package ru.job4j.list;

public class User implements Comparable<User> {
    public int id;
    public String name;
    public String city;
    public int age;

    User(int id, String name, int age, String city) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.city = city;

    }

    @Override
    public int compareTo(User o) {
        return Integer.compare(this.age, o.age);
    }
}
