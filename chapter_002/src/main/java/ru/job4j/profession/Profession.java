package ru.job4j.profession;

/**
 * Profession
 *
 * @author Valentin Zhigalov (VAL1915@ya.ru)
 * @version 0.1
 * @since 25.12.18
 */

public class Profession {
    public String name;
    private String profession;

    public Profession(String name){
        this.name = name;
    }

    public String getName(){
        return this.name;
    }
}
