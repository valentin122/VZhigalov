package ru.job4j.tracker;

import java.util.List;

interface Input {
     String ask(String question);
     int ask(String question, List<Integer> range);
     int ask(String question, int[] range);
}
