package ru.job4j.comparator;

import java.util.Comparator;


public class ListCompare implements Comparator<String> {
    @Override
    public int compare(String left, String right) {
        int result = 0;
        String minWord = left.length() < right.length() ? left : right;
        for (int i = 0; i < minWord.length(); i++) {
            int characterCompare = Character.compare(left.charAt(i), right.charAt(i));
            if (characterCompare != 0) {
                result = characterCompare;
                break;
            }
        }
        return result == 0 ? Integer.compare(left.length(), right.length()) : result;
    }
}