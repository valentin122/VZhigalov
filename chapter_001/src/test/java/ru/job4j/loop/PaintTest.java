package ru.job4j.loop;

import org.junit.Test;
import java.util.StringJoiner;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

/**
 *PaintTest
 *
 *@author Valentin Zhigalov (VAL1915@ya.ru)
 *@since 08.10.18
 *@version 0.1
 */

public class PaintTest {
    @Test
    public void whenPyramid4Height() {
        Paint paint = new Paint();
        String rst = paint.pyramid(4);
        System.out.println(rst);
        assertThat(rst,
                is(
                        new StringJoiner(System.lineSeparator(), "", System.lineSeparator())
                                .add("   ^   ")
                                .add("  ^^^  ")
                                .add(" ^^^^^ ")
                                .add("^^^^^^^")
                                .toString()
                )
        );
    }

    @Test
    public void whenPyramid6Height() {
        Paint paint = new Paint();
        String rst = paint.pyramid(6);
        System.out.println(rst);
        assertThat(rst,
                is(
                        new StringJoiner(System.lineSeparator(), "", System.lineSeparator())
                                .add("     ^     ")
                                .add("    ^^^    ")
                                .add("   ^^^^^   ")
                                .add("  ^^^^^^^  ")
                                .add(" ^^^^^^^^^ ")
                                .add("^^^^^^^^^^^")
                                .toString()
                )
        );
    }
}