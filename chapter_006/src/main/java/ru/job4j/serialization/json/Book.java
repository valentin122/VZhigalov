package ru.job4j.serialization.json;

import java.util.Arrays;

public class Book {
    private final boolean isElectronic;
    private final int volume;
    private final String label;
    private final Author author;
    private final String[] editorial;

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
