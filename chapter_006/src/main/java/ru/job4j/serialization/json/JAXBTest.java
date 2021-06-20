package ru.job4j.serialization.json;

        import javax.xml.bind.JAXBContext;
        import javax.xml.bind.JAXBException;
        import javax.xml.bind.Marshaller;
        import javax.xml.bind.Unmarshaller;
        import java.io.StringReader;
        import java.io.StringWriter;

public class JAXBTest {
    public static void main(String[] args) throws JAXBException {
        final Book book = new Book(false, 464, "Clean code", new Author("Роберт", "Мартин"), new String[]{"rev1", "rev2"});

        JAXBContext context = JAXBContext.newInstance(Book.class);
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

        String result = "";
        try (StringWriter writer = new StringWriter()) {
            marshaller.marshal(book, writer);
            result = writer.getBuffer().toString();
            System.out.println(result);
        } catch (Exception e) {
            e.printStackTrace();
        }

        Unmarshaller unmarshaller = context.createUnmarshaller();
        try (StringReader reader = new StringReader(result)) {
            Book resultBook = (Book) unmarshaller.unmarshal(reader);
            System.out.println(resultBook);
        }

    }
}