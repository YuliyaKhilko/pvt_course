package core;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HotelDetailsPage {

	@FindBy(xpath = ".//div[@class=\"bui-review-score c-score bui-review-score--end\"]/div[@class=\"bui-review-score__badge\"]")
	private WebElement rating;

	public HotelDetailsPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public double getRating() {
		return Double.valueOf(rating.getText());
	}
}
