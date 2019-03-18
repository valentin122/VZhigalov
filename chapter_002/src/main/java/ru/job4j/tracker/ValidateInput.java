package ru.job4j.tracker;

public class ValidateInput implements Input {

    private final Input input;

    public ValidateInput(final Input input) {
        this.input = input;
    }

    @Override
    public String ask(String question) {
        return String.valueOf(this.input.ask(question));
    }

    @Override
    public int ask(String question, int[] range) {
        boolean valid = true;
        int value = -1;
        do {
            try {
                value = this.input.ask(question, range);
                valid = false;
            } catch (MenuOutException moe) {
                System.out.println("Please select key from menu.");
            } catch (NumberFormatException nfe) {
                System.out.println("Please enter validate data again.");
            }
        } while (valid);
        return value;
    }
}
