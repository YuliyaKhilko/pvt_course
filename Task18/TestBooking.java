import java.util.List;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestBooking {
	private WebDriver driver;

	@Before
	public void setUp() {
		String exePath = "/Users/yulyakhilko/Documents/chromedriver";
		System.setProperty("webdriver.chrome.driver", exePath);
		driver = new ChromeDriver();
	}

	@After
	public void tearDown() {
		driver.quit();
	}

	@Test
	public void testSearchReturnsResults() {
		driver.get("https://www.booking.com/");
		typeCity("Moscow");
		setAdultsNumber(4);
		setRooms(2);
		List<WebElement> searchResults = search();

		Assert.assertNotEquals(0, searchResults.size());
	}

	@Test
	public void testHotelRating() throws InterruptedException {
		driver.get("https://www.booking.com/");
		typeCity("Moscow");
		setAdultsNumber(4);
		setRooms(2);
		search();
		setSortingByRatingDesc();
		openTopRatedHotel();
		double minRating = 8.0;
		Assert.assertTrue(getRating() >= minRating);
	}

	private double getRating() {
		WebElement rating = driver.findElement(By.xpath(
				".//div[@class=\"bui-review-score c-score bui-review-score--end\"]/div[@class=\"bui-review-score__badge\"]"));
		return Double.valueOf(rating.getText());
	}

	private void openTopRatedHotel() {
		List<WebElement> searchResultsSortedByRating = driver
				.findElements(By.xpath(".//a[@class=\"hotel_name_link url\"]"));
		WebElement topRatedHotel = searchResultsSortedByRating.get(0);
		topRatedHotel.click();
	}

	private void setSortingByRatingDesc() throws InterruptedException {
		WebElement stars = driver.findElement(By.xpath("//a[contains(text(), \"Stars\")]"));
		stars.click();
		WebElement ratingDescSorting = driver.findElement(By.xpath("(//a[@class=\"sort_suboption\"])[1]"));
		ratingDescSorting.click();
		Thread.sleep(5000);
	}

	private List<WebElement> search() {
		WebElement searchButton = driver.findElement(By.xpath(".//button[@class=\"sb-searchbox__button  \"]"));
		searchButton.click();

		List<WebElement> searchResults = driver.findElements(By.xpath(".//a[@class=\"hotel_name_link url\"]"));
		return searchResults;
	}

	private void setRooms(int numberOfRooms) {
		WebElement guests = driver.findElement(By.xpath(".//span[@class=\"xp__guests__count\"]"));
		guests.click();
		WebElement roomsCounter = driver.findElement(By.xpath("(.//span[@class=\"bui-stepper__display\"])[3]"));
		WebElement plusButtonForRooms = driver
				.findElement(By.xpath("(//button[@data-bui-ref=\"input-stepper-add-button\"])[3]"));
		while (Integer.parseInt(roomsCounter.getText()) < numberOfRooms) {
			plusButtonForRooms.click();
		}
		guests.click();
	}

	private void setAdultsNumber(int numberOfAdults) {
		WebElement guests = driver.findElement(By.xpath(".//span[@class=\"xp__guests__count\"]"));
		guests.click();

		WebElement adultsCounter = driver.findElement(By.xpath("(.//span[@class=\"bui-stepper__display\"])[1]"));
		WebElement plusButtonForAdults = driver
				.findElement(By.xpath("//button[@data-bui-ref=\"input-stepper-add-button\"][1]"));
		while (Integer.parseInt(adultsCounter.getText()) < numberOfAdults) {
			plusButtonForAdults.click();
		}
		guests.click();
	}

	private void typeCity(String city) {
		WebElement searchField = driver.findElement(By.xpath(".//input[@type=\"search\"]"));
		searchField.clear();
		searchField.sendKeys(city);
	}

}
