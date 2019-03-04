package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HotelDetailsPage {
	private WebDriver driver;

	@FindBy(xpath = "(.//select[@class=\"hprt-nos-select\"])[1]")
	private WebElement roomsDropdwn;

	@FindBy(xpath = ".//button[@data-tooltip-class=\"submit_holder_button_tooltip\"]")
	private WebElement reserveButton;

	@FindBy(xpath = ".//h2[@class = \"hp__hotel-name\"]")
	private WebElement hotelName;

	@FindBy(xpath = "(.//button[@id=\"hp_book_now_button\"])[2]")
	private WebElement reserveNowButton;

	@FindBy(xpath = ".//div[@id=\"available_rooms\"]")
	private WebElement availableRooms;

	public HotelDetailsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void reserveHotel() throws InterruptedException {
		new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOf(hotelName));
		reserveNowButton.click();
		Thread.sleep(5000);
		Select roomsDropdown = new Select(roomsDropdwn);
		roomsDropdown.getOptions().get(1).click();
		reserveButton.click();
	}

}
