package ru.job4j.io;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ConsoleChat {
    private final String pathToHistoryFile;
    private final String botAnswers;
    private static final String OUT = "закончить";
    private static final String STOP = "стоп";
    private static final String CONTINUE = "продолжить";
    private static final String CONTINUEANSWER = "продолжаем...";
    private static final String BYE = "Программа завершена. До свидания.";
    private List<String> history = new ArrayList<String>();
    private List<String> answersList = new ArrayList<String>();

    public ConsoleChat(String pathToHistoryFile, String botAnswers) {
        this.pathToHistoryFile = pathToHistoryFile;
        this.botAnswers = botAnswers;
    }

    public void run() {
        Scanner in = new Scanner(System.in);
        boolean isStopping = false;

        while (in.hasNext()) {
            String input = in.nextLine();
            history.add("User: " + input);
            if (input.equals(OUT)) {
                history.add("Bot: " + BYE);
                System.out.println(BYE);
                writeHistory(history);
                break;
            } else if (input.equals(CONTINUE)) {
                isStopping = false;
                System.out.println(CONTINUEANSWER);
                history.add("Bot: " + CONTINUEANSWER);
            } else if (input.equals(STOP)) {
                isStopping = true;
            } else if (!isStopping) {
                String answer = getBotAnswers();
                System.out.println(answer);
                history.add("Bot: " + answer);
            }
        }
    }

    public static void main(String[] args) {
        ConsoleChat cc = new ConsoleChat("./chapter_006/src/data/history.txt", "./chapter_006/src/data/botAnswers.txt"); //chapter_006/src/data/botAnswers.txt
        cc.run();
    }

    private void writeHistory(List<String> history) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(pathToHistoryFile, true))) {
            for (String line : history) {
                writer.write(line);
                writer.newLine();
            }
            writer.flush();
        } catch (IOException e) {
            System.out.println(e);
        }
    }

    private String getBotAnswers() {
        if (answersList.size() < 1) {
            try (BufferedReader reader = new BufferedReader(new FileReader(botAnswers))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    answersList.add(line);
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return answersList.get((int) (Math.random() * answersList.size()));
    }
}