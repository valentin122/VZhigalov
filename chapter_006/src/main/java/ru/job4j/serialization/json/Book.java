package ru.job4j.serialization.json;

import javax.xml.bind.annotation.*;
import java.util.Arrays;

@XmlRootElement(name = "book")
@XmlAccessorType(XmlAccessType.FIELD)
public class Book {
    @XmlAttribute
    private boolean isElectronic;
    @XmlAttribute
    private int volume;
    @XmlAttribute
    private String label;
    private Author author;
    @XmlElementWrapper(name = "editorials")
    @XmlElement(name = "editorial")
    private String[] editorial;

    public Book() {
    }

    public Book(boolean isElectronic, int volume, String label, Author author, String[] editorial) {
        this.isElectronic = isElectronic;
        this.volume = volume;
        this.label = label;
        this.author = author;
        this.editorial = editorial;
    }


    @Override
    public String toString() {
        return "Book{"
                + "isElectronic=" + isElectronic
                + ", volume=" + volume
                + ", label='" + label + '\''
                + ", author=" + author
                + ", editorial=" + Arrays.toString(editorial)
                + '}';
    }
}
