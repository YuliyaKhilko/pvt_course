package core;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.BeforeClass;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

public class MassiveTests {
	Massive massive;
	private int[] array;

	@BeforeMethod
	public void beforeMethod() {
		array = new int[] { 1, 2, 3, 4, 5 };
	}

	@AfterMethod
	public void afterMethod() {
		array = null;
	}

	@DataProvider(name = "testTestDataForIsEvenTest")
	public Object[][] dp() {
		return new Object[][] { { new int[] { 1, 2, 3, 4, 5 }, false }, { new int[] { 1, 2, 6, 4, 5 }, true },
				{ new int[] { -1, -2, 0, -4, -5 }, true }, { new int[] { -8, -2, -7, -4, -5 }, true }, };
	}

	@BeforeClass
	public void beforeClass() {
		massive = new Massive();
	}

	@AfterClass
	public void afterClass() {
		massive = null;
	}

	@BeforeTest
	public void beforeTest() {
	}

	@AfterTest
	public void afterTest() {
	}

	@BeforeSuite
	public void beforeSuite() {
	}

	@AfterSuite
	public void afterSuite() {
	}

	@Test
	public void testMax() {
		assertEquals(massive.max(array), 5);
	}

	@Test
	public void testMin() {
		assertEquals(massive.min(array), 1);
	}

	@Test
	public void testSum() {
		assertEquals(15, massive.sum(array));
	}

	@Test
	public void testMultiplication() {
		assertEquals(120, massive.multiplication(array));
	}

	@Test(expectedExceptions = ArithmeticException.class)
	public void testDivisionByZero() {
		int divisor = 0;
		massive.elementDivided(array, divisor);
	}

	@Test
	public void testDivisionWithoutRounding() {
		int divisor = 2;
		int[] arrayInitial = new int[] { 2, 4, 6 };
		int[] result = new int[] { 1, 2, 3 };
		assertEquals(result, massive.elementDivided(arrayInitial, divisor));
	}

	@Test
	public void testDividedWithRounding() {
		int[] arrayInitial = new int[] { 3, 5, 7 };
		int[] result = new int[] { 2, 3, 4 };
		int divisor = 2;
		assertEquals(result, massive.elementDivided(arrayInitial, divisor));
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

	@Test(expectedExceptions = NoZeroElementsException.class)
	public void testCountZerosWithoutZeroElements() throws NoZeroElementsException {
		massive.countZeroElements(array);
	}

	@Test
	public void testCountZeros() throws NoZeroElementsException {
		int[] arrayInitial = new int[] { 2, 0, 6, 0, 0 };
		assertEquals(3, massive.countZeroElements(arrayInitial));
	}

	@Test
	public void testElementsMultiplied() {
		int multiplier = 5;
		int[] result = new int[] { 5, 10, 15, 20, 25 };
		assertEquals(result, massive.elementsMultiplied(array, multiplier));
	}

	@Test(enabled = false)
	public void testElementsMultipliedByZero() {
		int multiplier = 0;
		int[] result = new int[] { 0, 0, 0, 0, 0 };
		assertEquals(result, massive.elementsMultiplied(array, multiplier));
	}

	@Test
	public void testElementsIncreasedByPositiveNumber() {
		int incrementer = 10;
		int[] result = new int[] { 11, 12, 13, 14, 15 };
		assertEquals(result, massive.elementsIncreased(array, incrementer));
	}

	@Test
	public void testElementsIcreasedByNegativeNumber() {
		int incrementer = -1;
		int[] result = new int[] { 0, 1, 2, 3, 4 };
		assertEquals(result, massive.elementsIncreased(array, incrementer));
	}

	@Test
	public void testElementsIcreasedByZero() {
		int incrementer = 0;
		assertEquals(array, massive.elementsIncreased(array, incrementer));
	}

	@Test
	public void testElementsDecreasedByPositiveNumber() {
		int decrementer = 10;
		int[] result = new int[] { -9, -8, -7, -6, -5 };
		assertEquals(result, massive.elementsDecreased(array, decrementer));
	}

	@Test
	public void testElementsDecreasedByNegativeNumber() {
		int decrementer = -2;
		int[] result = new int[] { 3, 4, 5, 6, 7 };
		assertEquals(result, massive.elementsDecreased(array, decrementer));
	}

	@Test
	public void testElementsDecreasedByZero() {
		int decrementer = 0;
		assertEquals(array, massive.elementsIncreased(array, decrementer));
	}

	@Test(dataProvider = "testTestDataForIsEvenTest")
	public void testIsEvenMaxElement(int[] array, boolean result) {
		assertEquals(massive.isEvenMaxElement(array), result);
	}

	@Test
	public void testIsEvenMaxElement_False() {
		int[] arrayWithNegativeElements = new int[] { -1, -2, -3, -4, -5 };
		assertFalse(massive.isEvenMaxElement(arrayWithNegativeElements));
	}

	@Test
	public void testIsEvenMaxElement_True() {
		int[] testArray = new int[] { 20, 30, 55, 110 };
		assertTrue(massive.isEvenMaxElement(testArray));
	}

	@Test
	public void testMultiplicationWithZeroElements() {
		int[] testArray = new int[] { 0, 30, 55, 110 };
		assertEquals(0, massive.multiplication(testArray));
	}

}
