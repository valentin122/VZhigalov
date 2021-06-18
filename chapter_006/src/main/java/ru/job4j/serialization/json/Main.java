package ru.job4j.serialization.json;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.StringWriter;

public class Main {
    public static void main(String[] args) throws JAXBException {
        final Book book = new Book(false, 464, "Clean code", new Author("Роберт", "Мартин"), new String[]{"rev1", "rev2"});
     /*   final Gson gson = new GsonBuilder().create();
        String jsonString = gson.toJson(book);
    //    System.out.println(jsonString);

        final Book book1 = gson.fromJson(jsonString, Book.class);
    //    System.out.println(book1);
*/
        JAXBContext context = JAXBContext.newInstance(Book.class);
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

        try (StringWriter writer = new StringWriter()) {
            marshaller.marshal(book, writer);
            String result = writer.getBuffer().toString();
            System.out.println(result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
