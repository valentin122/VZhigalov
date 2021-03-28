package ru.job4j.io;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;

import java.io.IOException;

import static org.junit.Assert.*;

public class ArgZipTest {
    @Rule
    public TemporaryFolder folder = new TemporaryFolder();

    @Test
    public void whenValid() throws IOException {
        folder.newFile("test1.txt");
        String[] strings = new String[6];
        strings[0] = "-d";
        strings[1] = folder.getRoot().toString();
        strings[2] = "-e";
        strings[3] = "*.java";
        strings[4] = "-o";
        strings[5] = folder.newFile("temp.zip").getAbsolutePath();
        assertTrue(new ArgZip(strings).valid());
    }

    @Test
    public void whenNotValidKey() throws IOException {
        ArgZip argZip;
        folder.newFile("temp.txt");
        String[] strings = new String[6];
        strings[0] = "-f";
        strings[1] = folder.getRoot().toString();
        strings[2] = "-e";
        strings[3] = "*.java";
        strings[4] = "-o";
        strings[5] = folder.newFile("temp.zip").getAbsolutePath();
        argZip = new ArgZip(strings);
        assertFalse(argZip.valid());
    }

    @Test
    public void whenNotRightExclude() {
        String[] strings = new String[2];
        strings[0] = "-e";
        strings[1] = ".java";
        assertFalse(new ArgZip(strings).exclude().equals(".txt"));
    }

    @Test
    public void whenRightExclude() {
        String[] strings = new String[2];
        strings[0] = "-e";
        strings[1] = ".java";
        assertTrue(new ArgZip(strings).exclude().equals(".java"));
    }

    @Test
    public void whenRightDirectory() {
        String[] strings = new String[2];
        strings[0] = "-d";
        strings[1] = folder.getRoot().toString();
        assertTrue(new ArgZip(strings).directory().equals(folder.getRoot().toString()));
    }

    @Test
    public void whenNotRightDirectory() throws IOException {
        folder.newFile("test1.txt");
        String[] strings = new String[2];
        strings[0] = "-d";
        strings[1] = folder.getRoot().getName();
        assertFalse(new ArgZip(strings).directory().equals(folder.toString()));
    }

    @Test
    public void whenRightOutput() {
        String[] strings = new String[2];
        strings[0] = "-o";
        strings[1] = folder.getRoot().toString();
        assertTrue(new ArgZip(strings).output().equals(folder.getRoot().toString()));
    }

    @Test
    public void whenNotRightOutput() throws IOException {
        folder.newFile("test1.txt");
        String[] strings = new String[2];
        strings[0] = "-o";
        strings[1] = folder.getRoot().getName();
        assertFalse(new ArgZip(strings).output().equals(folder.toString()));
    }
}
