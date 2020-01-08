package ru.job4j.io;

import java.io.File;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Search {

    public List<File> files(String parent, List<String> exts) {
        List<File> result = new ArrayList<>();
        File file = new File(parent);
        Queue<File> queue = new LinkedList<>();
        for (File f : file.listFiles()) {
            queue.add(f);
        }
        while (queue.size() > 0) {
            File fileTemp = queue.poll();
            if (fileTemp.isDirectory()) {
                for (File f : fileTemp.listFiles()) {
                    queue.add(f);
                }
            } else {
                for (String ext : exts) {
                    if (fileTemp.getName().endsWith(ext)) {
                        result.add(fileTemp);
                    }
                }
            }
        }
        return result;
    }
}
