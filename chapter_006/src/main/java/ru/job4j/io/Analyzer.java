package ru.job4j.io;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Analyzer {

    private boolean serverDown(String[] strings) {
        return strings[0].equals("400") || strings[0].equals("500");
    }

    private void writeFile(String target, List<String> data) {
        try (PrintWriter out = new PrintWriter(new FileOutputStream(target))) {
            for (int i = 0; i < data.size(); i++) {
                out.println(data.get(i) + ";" + data.get(i + 1) + ";");
                i++;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void unavailable(String source, String target) {
        List<String> targetToFile = new ArrayList<String>();
        try (BufferedReader in = new BufferedReader(new FileReader(source))) {
                boolean serverDownNow = false;
                String line = in.readLine();
                while (line != null) {
                    String[] strings = line.split(" ", 2);
                    if (strings.length > 1) {
                        if (serverDownNow) {
                            if (!serverDown(strings)) {
                                targetToFile.add(strings[1]);
                                serverDownNow = false;
                            }
                        } else {
                            if (serverDown(strings)) {
                                targetToFile.add(strings[1]);
                                serverDownNow = true;
                            }
                        }
                    }
                    line = in.readLine();
                }
        } catch (Exception e) {
            e.printStackTrace();
        }
        writeFile(target, targetToFile);
    }

}
