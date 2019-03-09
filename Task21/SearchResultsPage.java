package pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SearchResultsPage {
	private WebDriver driver;

	@FindBy(xpath = "//a[contains(text(), \"Stars\")]")
	private WebElement starsSorting;

	@FindBy(xpath = "(//a[@class=\"sort_suboption\"])[1]")
	private WebElement sortByRatingDesc;

	public SearchResultsPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}

	public void setSortingByStarsDesc() {
		starsSorting.click();
		sortByRatingDesc.click();
		new WebDriverWait(driver, 10).until(ExpectedConditions
				.invisibilityOfElementLocated(By.xpath(".//div[@class=\"sr-usp-overlay__loading\"]")));
	}

	public void openTopRatedHotel() {
		List<WebElement> searchResultsSortedByRating = driver
				.findElements(By.xpath(".//a[@class=\"hotel_name_link url\"]"));
		WebElement topRatedHotel = searchResultsSortedByRating.get(0);
		topRatedHotel.click();
		ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(tabs.get(1));
	}

}
