package ru.job4j.io;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.*;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class AnalyzerTest {

    @Before
    public void setUp() {
        try (PrintWriter out = new PrintWriter(new FileOutputStream("unavailable.csv"))) {
            out.println("200 10:56:01");
            out.println("500 10:57:01");
            out.println("400 10:58:01");
            out.println("200 10:59:01");
            out.println("500 11:01:02");
            out.println("200 11:02:02");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @After
    public void tearDown() {
        File fileSource = new File("unavailable.csv");
        File fileTarget = new File("target.csv");
        if (fileSource.delete()) {
            System.out.println("unavailable.csv файл удален");
        } else {
            System.out.println("Файл unavailable.csv не обнаружен или защищен от удаления "
                    + "(например используется другой программой)");
        }
        if (fileTarget.delete()) {
            System.out.println("target.csv файл удален");
        } else {
            System.out.println("Файл target.csv не обнаружен или защищен от удаления "
                    + "(например используется другой программой)");
        }
    }

    @Test
    public void unavailable() {
        Analyzer analyzer = new Analyzer();
        analyzer.unavailable("unavailable.csv", "target.csv");
        String expected = "10:57:01;10:59:01;" + System.lineSeparator()
                + "11:01:02;11:02:02;";
        String actual = null;
        try (BufferedReader in = new BufferedReader(new FileReader("target.csv"))) {
            actual = in.readLine() + System.lineSeparator()
                    + in.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        assertThat(expected.equals(actual), is(true));
    }
}