package ru.job4j.tracker;

public class Item {
    private String id;
    private String name;
    private String desc;
    private long create;

    public Item(String name, String desc, long create) {
        this.name = name;
    }

    public Item(String name, String desc) {
        this.name = name;
        this.desc = desc;
    }


    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getDesc() {
        return desc;
    }

    public long getCreate() {
        return create;
    }

    @Override
    public String toString() {
        return "Item's id: " + getId() + "Item's name: " + getName() + "Item's description" + getDesc();
    }

}
