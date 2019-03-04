package pages;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

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

	@FindBy(xpath = ".//div[@class=\"xp__dates xp__group\"]")
	private WebElement datePicker;

	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void setCity(String city) {
		enterText(searchField, city);
	}

	private void enterText(WebElement element, String text) {
		element.clear();
		element.sendKeys(text);
	}

	public void setDatesRange() {
		datePicker.click();
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.DATE, 3);
		Date startDate = calendar.getTime();
		calendar.add(Calendar.DATE, 7);
		Date endDate = calendar.getTime();
		findDateElement(formatDate(startDate)).click();
		findDateElement(formatDate(endDate)).click();
	}

	public String formatDate(Date date) {
		return new SimpleDateFormat("yyyy-MM-dd").format(date);
	}

	private WebElement findDateElement(String date) {
		return driver.findElement(By.xpath(".//td[@data-date=\"" + date + "\"]"));
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

	public void performSearch(String city) {
		searchButton.click();
		new WebDriverWait(driver, 5).until(ExpectedConditions.titleContains(city));

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
}
