package core;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

public class MassiveTest {
	Massive massive;
	static int[] array;

	@BeforeClass
	public static void setUpOnce() {
		array = new int[] { 1, 2, 3, 4, 5 };
	}

	@AfterClass
	public static void tearDownOnce() {
		array = null;
	}

	@Before
	public void setUp() {
		massive = new Massive();
	}

	@After
	public void tearDown() {
		massive = null;
	}

	@Test
	public void testMax() {
		assertEquals(5, massive.max(array));
	}

	@Test
	public void testMin() {
		assertEquals(1, massive.min(array));
	}

	@Test
	public void testSum() {
		assertEquals(15, massive.sum(array));
	}

	@Test
	public void testMultiplication() {
		assertEquals(120, massive.multiplication(array));
	}

	@Test(expected = ArithmeticException.class)
	public void testDivisionByZero() {
		int divisor = 0;
		massive.elementDivided(array, divisor);
	}

	@Test
	public void testDivision() {
		int divisor = 2;
		int[] arrayInitial = new int[] { 2, 4, 6 };
		int[] result = new int[] { 1, 2, 3 };
		Assert.assertArrayEquals(result, massive.elementDivided(arrayInitial, divisor));
	}

	@Test
	public void testMinWithNegativeNumbers() {
		int[] arrayWithNegativeElements = new int[] { -1, -2, -3, -4, -5 };
		int min = -5;
		assertTrue(min == massive.min(arrayWithNegativeElements));
	}

	@Test
	public void testMaxWithNegativeNumbers() {
		int[] arrayWithNegativeElements = new int[] { -1, -2, -3, -4, -5 };
		int max = -1;
		assertTrue(max == massive.max(arrayWithNegativeElements));
	}

	@Test(expected = NoZeroElementsException.class)
	public void testCountZerosWithoutZeroElements() throws NoZeroElementsException {
		massive.countZeroElements(array);
	}

	@Test
	public void testCountZeros() throws NoZeroElementsException {
		int[] arrayInitial = new int[] { 2, 0, 6, 0, 0 };
		assertEquals(3, massive.countZeroElements(arrayInitial));
	}

}
