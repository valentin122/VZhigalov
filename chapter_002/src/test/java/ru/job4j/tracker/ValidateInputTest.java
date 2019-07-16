package ru.job4j.tracker;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

/**
 * StartUI
 *
 * @author Valentin Zhigalov (VAL1915@ya.ru)
 * @version 0.1
 * @since 24.02.19
 */
public class ValidateInputTest {
    private final ByteArrayOutputStream mem = new ByteArrayOutputStream();
    private final PrintStream out = System.out;


    @Before
    public void loadMem() {
        System.setOut(new PrintStream(this.mem));
    }

    @After
    public void loadSys() {
        System.setOut(this.out);
    }

    @Test
    public void whenValidInput() {
        ArrayList<String> invalid = new ArrayList<>();
        invalid.add("1");
        ValidateInput input = new ValidateInput(
                new StubInput(invalid)
        );
        input.ask("2", (new ArrayList(Arrays.asList(1))));
        assertThat(
                this.mem.toString(),
                is(
                        String.format("")
                )
        );
    }

    @Test
    public void whenNotAtMenuInput() {
        ArrayList<String> invalid = new ArrayList<>();
        invalid.add("1");
        invalid.add("11");
        ValidateInput input = new ValidateInput(

                new StubInput(invalid)
        );
        input.ask("1",  (new ArrayList(Arrays.asList(11))));
        assertThat(
                this.mem.toString(),
                is(
                        String.format("Please select key from menu.%n"))
        );
    }
    @Test
    public void whenInvalidInput() {
        ArrayList<String> invalid = new ArrayList<>();
        invalid.add("i1");
        invalid.add("1");
        ValidateInput input = new ValidateInput(
                new StubInput(invalid)
        );
        input.ask("1", (new ArrayList(Arrays.asList(1))));
        assertThat(
                this.mem.toString(),
                is(
                        String.format("Please enter validate data again.%n")
                )
        );
    }
}