package ru.job4j.serialization.json;

import org.json.JSONArray;
import org.json.JSONObject;

import javax.xml.bind.JAXBException;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) throws JAXBException {
        final Book book = new Book(false, 464, "Clean code", new Author("Роберт", "Мартин"), new String[]{"rev1", "rev2"});


        JSONObject jsonObject = new JSONObject();
        jsonObject.put("isElectronic", book.isElectronic());
        jsonObject.put("volume", book.getVolume());
        jsonObject.put("label", book.getLabel());
        //jsonObject.put("")
        JSONObject jsonObjectAuthor = new JSONObject();
        Author author = new Author("Роберт", "Мартин");
        jsonObjectAuthor.put("name", author.getName());
        jsonObjectAuthor.put("surname", author.getSurname());

        jsonObject.put("author", jsonObjectAuthor);

        List<String> list = Arrays.asList("rev1", "rev2");
        JSONArray jsonEditorials = new JSONArray(list);

        jsonObject.put("editorial", jsonEditorials);

        System.out.println(jsonObject.toString());

        System.out.println(new JSONObject(book).toString());

    }
}
