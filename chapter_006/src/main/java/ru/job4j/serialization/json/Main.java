package ru.job4j.serialization.json;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class Main {
    public static void main(String[] args) {
        final Book book = new Book(false, 464, "Clean code", new Author("Роберт", "Мартин"), new String[]{"rev1", "rev2"});
        final Gson gson = new GsonBuilder().create();
        String jsonString = gson.toJson(book);
        System.out.println(jsonString);

        final Book book1 = gson.fromJson(jsonString, Book.class);
        System.out.println(book1);
    }
}
