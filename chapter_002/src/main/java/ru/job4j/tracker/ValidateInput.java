package ru.job4j.tracker;

import java.util.ArrayList;

public class ValidateInput implements Input {

    private final Input input;

    public ValidateInput(final Input input) {
        this.input = input;
    }

    @Override
    public String ask(String question) {
        return this.input.ask(question);
    }

    @Override
    public int ask(String question, ArrayList<Integer> range) {
        boolean valid = false;
        int value = -1;
        int i = 1;
        do {
            try {
                value = this.input.ask(question, range);
                valid = true;
            } catch (MenuOutException moe) {
                System.out.println("Please select key from menu.");
            } catch (NumberFormatException nfe) {
                System.out.println("Please enter validate data again.");
            }
        } while (!valid || i == 5);
        return value;
    }
}
