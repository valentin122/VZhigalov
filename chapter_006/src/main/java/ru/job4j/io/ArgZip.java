package ru.job4j.io;

public class ArgZip {
    private final String[] args;
    private String directory;
    private String exclude;
    private String output;

    public ArgZip(String[] args) {
        this.args = args;
        for (int i = 0; i < args.length; i++) {
            if (args[i].equals("-d")) {
                directory = args[i + 1];
            } else if (args[i].equals("-e")) {
                exclude = args[i + 1];
            } else if (args[i].equals("-o")) {
                output = args[i + 1];
            }
        }
    }

    public boolean valid() {
        return (directory != null
                && exclude.length() > 0
                && output != null);
    }

    public String directory() { //Директория которую хочу архивировать
        return directory;
    }

    public String exclude() { //исключить файлы *.xml
        return exclude;
    }

    public String output() { //имя архива
        return output;
    }

}
