package ru.job4j.comparator;

import java.util.Comparator;


public class ListCompare implements Comparator<String> {
    @Override
    public int compare(String left, String right) {
        int result = -1;
        //получение символа из строки
        //   String.charAt(int index)
        //сравнение чисел
        //   Integer.compare(int left, int right),

        //    Character.compare(char left, char right);
        String minWord = left.length() < right.length() ? left : right;
        for (int i = 0; i < minWord.length(); i++) {
            int characterCompare = Character.compare(left.charAt(i), right.charAt(i));
            if (characterCompare != 0) {
                if (characterCompare < 0) {
                    result = -1;
                    break;
                }
                result = 1;
                break;

            }
            if (characterCompare == 0) {
                if (left.length() == right.length()) {
                    result = 0;
                } else {
                    result = minWord == left ? -1 : 1;
                }
            }
        }
        return result;
    }
}