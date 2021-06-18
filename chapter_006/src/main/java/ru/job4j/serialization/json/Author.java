package ru.job4j.serialization.json;

public class Author {

    private final String name;
    private final String surname;


    public Author(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    @Override
    public String toString() {
        return "Author{"
                + "name='" + name + '\''
                + ", surname='" + surname + '\''
                + '}';
    }
}
