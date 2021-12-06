package ru.job4j.io;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class SearchTest {
    String path = System.getProperty("java.io.tmpdir");
    Search search = new Search();
    File file;

    @Before
    public void setUp() throws Exception {
        file = new File(path + File.separator + "test789.txt");
        FileWriter fileWriter = new FileWriter(file);
        fileWriter.write(1);
    }

   @After
    public void tearDown() {
         file.delete();
    }

    @Ignore
    @Test
    public void files() {
        boolean actual = false;
        List<String> exts = new ArrayList<>();
        exts.add(".java");
        exts.add(".txt");
        Predicate<File> endWith = x -> {
            boolean result = false;
            for (String ext : exts) {
                if (x.getName().endsWith(ext)) {
                    result = true;
                }
            }
            return result;
        };
        List<File> result = search.files(path, endWith);
        for (File file : result) {
            if (file.getName().equals("test789.txt")) {
                actual = true;
            }
        }
        assertThat(actual, is(true));
    }
}