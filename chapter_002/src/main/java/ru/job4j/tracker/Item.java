package ru.job4j.tracker;

public class Item {
    private String id;
    private String name;

    public Item(String name, String desc, long create) {
        this.name = name;
    }

    public Item(String name, String desc) {
    }


    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }

}
