package core;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import pages.HomePage;
import pages.HotelDetailsPage;
import pages.SearchResultsPage;

public class TestBooking {
	private WebDriver driver;
	private HomePage homePage;
	private HotelDetailsPage hotelDetailsPage;
	private SearchResultsPage searchResultsPage;
	public static final String CITY = "Moscow";
	public static final String URL = "https://www.booking.com/";
	public static final int ADULTSNUMBER = 3;
	private static final int ROOMSNUMBER = 1;

	@Before
	public void setUp() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		homePage = new HomePage(driver);
		hotelDetailsPage = new HotelDetailsPage(driver);
		searchResultsPage = new SearchResultsPage(driver);
		driver.get(URL);
	}

	@After
	public void tearDown() {
		driver.quit();
	}

	@Test
	public void checkThatSearchReturnsResults() {
		homePage.typeCity(CITY);
		homePage.setAdults(ADULTSNUMBER);
		homePage.setRooms(ROOMSNUMBER);
		Assert.assertNotEquals(0, homePage.performSearch(CITY).size());
	}

	@Test
	public void testHotelRating() {
		double minRating = 8.0;
		checkThatSearchReturnsResults();
		searchResultsPage.setSortingByStarsDesc();
		searchResultsPage.openTopRatedHotel();
		Assert.assertTrue(hotelDetailsPage.getRating() >= minRating);
	}
}
