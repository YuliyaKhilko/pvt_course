package core;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(value = Parameterized.class)
public class Test2 {
	Massive massive = new Massive();

	private int expectedResult;
	private int[] testArray;

	@Parameters
	public static Collection<Object[]> parameters() {
		return Arrays.asList(new Object[][] { { 0, new int[] { -3, 2, 1 } }, { -5, new int[] { -3, -1, -1 } },
				{ -2, new int[] { -8, 0, 6 } } });
	}

	public Test2(int expectedResult, int[] testArray) {
		this.expectedResult = expectedResult;
		this.testArray = testArray;
	}

	@Test
	public void testSumWithNegativeNumbers() {
		assertEquals(expectedResult, massive.sum(testArray));
	}

}
