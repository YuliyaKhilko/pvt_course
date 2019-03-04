package core;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import pages.HomePage;
import pages.HotelDetailsPage;
import pages.PersonalDetailsForReservationPage;
import pages.SearchResultsPage;

public class bookingTests {

	private WebDriver driver;
	private HomePage homePage;
	private SearchResultsPage searchResultsPage;
	private HotelDetailsPage hotelDetailsPage;
	private PersonalDetailsForReservationPage personalDetailsForReservationPage;

	@Before
	public void setUp() {
		String exePath = "/Users/yulyakhilko/Documents/chromedriver";
		System.setProperty("webdriver.chrome.driver", exePath);
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		homePage = new HomePage(driver);
		searchResultsPage = new SearchResultsPage(driver);
		hotelDetailsPage = new HotelDetailsPage(driver);
		personalDetailsForReservationPage = new PersonalDetailsForReservationPage(driver);
		driver.get("https://www.booking.com/");
	}

	@After
	public void tearDown() {
		driver.quit();
	}

	@Test
	public void checkPriceForTopRatedHotelWithLowestPrice() {
		homePage.setCity("Paris");
		homePage.setDatesRange();
		homePage.setAdults(2);
		homePage.performSearch("Paris");
		Assert.assertNotEquals(0, searchResultsPage.filterHotelsWithLowestPrice().size());
		Assert.assertTrue(searchResultsPage.getPriceOfTopRatedHotel() < 120 * 7);
	}

	@Test
	public void checkPriceForHotelWithLowestPriceFromHotelsWithHighestPrice() {
		homePage.setCity("Paris");
		homePage.setDatesRange();
		homePage.setAdults(4);
		homePage.setRooms(2);
		homePage.performSearch("Paris");
		searchResultsPage.filterHotelsWithHighestPrice();
		Assert.assertTrue(searchResultsPage.getPriceOfHotelWithLowestPrice() >= 480 * 7);
	}

	@Test
	public void checkInvalidCardNumberError() throws InterruptedException {
		homePage.setCity("Paris");
		homePage.setDatesRange();
		homePage.setAdults(4);
		homePage.setRooms(2);
		homePage.performSearch("Paris");
		searchResultsPage.filterHotelsWithHighestPrice();
		searchResultsPage.openFirstHotel();
		hotelDetailsPage.reserveHotel();
		personalDetailsForReservationPage.eneterPersonalDetails("Khilko", "qqq@email.com");

		Assert.assertTrue(personalDetailsForReservationPage.isInvalidCardNumberDisplayed("4242 4242 4242 1111"));
	}
}
