package ru.job4j.serialization.json;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "author")
public class Author {

    @XmlAttribute
    private String name;
    @XmlAttribute
    private String surname;

    public Author() {
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

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
