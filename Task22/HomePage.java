package core;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {

	private WebDriver driver;

	@FindBy(xpath = ".//input[@type=\"search\"]")
	private WebElement searchField;

	@FindBy(xpath = ".//span[@class=\"xp__guests__count\"]")
	private WebElement guests;

	@FindBy(xpath = ".//div[@class=\"sb-group__field sb-group__field-adults\"]/div/div[2]/span[@class=\"bui-stepper__display\"]")
	private WebElement adultsCounter;

	@FindBy(xpath = ".//div[@class=\"sb-group__field sb-group__field-adults\"]/div/div[2]/button[@data-bui-ref=\"input-stepper-add-button\"]")
	private WebElement plusButtonForAdults;

	@FindBy(xpath = ".//div[@class=\"sb-group__field sb-group__field-adults\"]/div/div[2]/button[@data-bui-ref=\"input-stepper-subtract-button\"]")
	private WebElement minusButtonForAdults;

	@FindBy(xpath = ".//div[@class=\"sb-group__field sb-group__field-rooms\"]/div/div[2]/span[@class=\"bui-stepper__display\"]")
	private WebElement roomsCounter;

	@FindBy(xpath = ".//div[@class=\"sb-group__field sb-group__field-rooms\"]/div/div[2]/button[@data-bui-ref=\"input-stepper-add-button\"]")
	private WebElement plusButtonForRooms;

	@FindBy(xpath = ".//div[@class=\"sb-group__field sb-group__field-rooms\"]/div/div[2]/button[@data-bui-ref=\"input-stepper-subtract-button\\")
	private WebElement minusButtonForRooms;

	@FindBy(xpath = ".//button[@class=\"sb-searchbox__button  \"]")
	private WebElement searchButton;

	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}

	public void typeCity(String city) {
		searchField.clear();
		searchField.sendKeys(city);
	}

	public void setAdults(int numberOfAdults) {
		guests.click();
		int defaultNumberOfAdults = Integer.parseInt(adultsCounter.getText());
		int adultsDelta = defaultNumberOfAdults - numberOfAdults;
		if (adultsDelta < 0) {
			while (Integer.parseInt(adultsCounter.getText()) < numberOfAdults) {
				plusButtonForAdults.click();
			}

		} else if (adultsDelta > 0) {
			while (Integer.parseInt(adultsCounter.getText()) > numberOfAdults) {
				minusButtonForAdults.click();
			}
		}
	}

	public void setRooms(int numberOfRooms) {
		int defaultNumberOfRooms = Integer.parseInt(roomsCounter.getText());
		int roomsDelta = defaultNumberOfRooms - numberOfRooms;
		if (roomsDelta < 0) {
			while (Integer.parseInt(roomsCounter.getText()) < numberOfRooms) {
				plusButtonForRooms.click();
			}
		} else if (roomsDelta > 0) {
			while (Integer.parseInt(roomsCounter.getText()) > numberOfRooms) {
				minusButtonForRooms.click();
			}
		}
	}

	public void performSearch() {
		searchButton.click();
		new WebDriverWait(driver, 5).until(ExpectedConditions.urlContains("searchresults"));
	}

//	public List<WebElement> performSearch() {
//		searchButton.click();
//		new WebDriverWait(driver, 5).until(ExpectedConditions.urlContains("searchresults"));
//		List<WebElement> searchResults = driver.findElements(By.xpath(".//a[@class=\"hotel_name_link url\"]"));
//		return searchResults;

}
