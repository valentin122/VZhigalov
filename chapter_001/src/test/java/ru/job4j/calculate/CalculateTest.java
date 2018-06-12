/**
 *CalculateTest
 *
 *@author Valentin Zhigalov (VAL1915@ya.ru)
 *@since 03.06.18
 *@version 0.2
 */

package ru.job4j.calculate;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Test.
 */

public class CalculateTest {
	/**
	 *Test echo
	 *@Test
	 */

	@Test

	public void whenTakeNameThenTreeEchoPlusName() {
		String input = "Valentin Zhigalov";
		String expect = "Echo, echo, echo : Valentin Zhigalov";
		Calculate calc = new Calculate();
		String result = calc.echo(input);
		assertThat(result, is(expect));
	}

}
	
	