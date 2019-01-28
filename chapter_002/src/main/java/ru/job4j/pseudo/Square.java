package ru.job4j.pseudo;

/**
 * Square
 *
 * @author Valentin Zhigalov (VAL1915@ya.ru)
 * @version 0.1
 * @since 27.01.19
 */

public class Square implements Shape {
    @Override
    public String draw() {
        StringBuilder pic = new StringBuilder();
        pic.append("++++");
        pic.append("+  +");
        pic.append("+  +");
        pic.append("++++");
        return pic.toString();
    }
}
