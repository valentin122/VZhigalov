package ru.job4j.comparator;

import java.util.Comparator;


public class ListCompare implements Comparator<String> {
    @Override
    public int compare(String left, String right) {
        int result = 2;
        String minWord = left.length() < right.length() ? left : right;
        for (int i = 0; i < minWord.length(); i++) {
            result = Character.compare(left.charAt(i), right.charAt(i));
            if (result != 0) {
                break;
            }
            if (i == (minWord.length() - 1) && left.length() == right.length()) {
                result = 0;
                break;
            }
            if (i == (minWord.length() - 1)) {
                result = minWord == left ? -1 : 1;
            }
        }
        return result;
    }
}