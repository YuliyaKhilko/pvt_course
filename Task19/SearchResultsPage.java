package pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SearchResultsPage {

	private WebDriver driver;

	@FindBy(xpath = ".//div[@id=\"filter_price\"]/div[2]/a[1]/input[@class=\"bui-checkbox__input js-bui-checkbox__input\"]")
	private WebElement filterLowestPriceCheckbox;

	@FindBy(xpath = ".//li[@class=\" sort_category   sort_review_score_and_price \"]")
	private WebElement sortingByScoreAndPrice;

	@FindBy(xpath = ".//div[@id=\"filter_price\"]/div[2]/a[5]/input[@class=\"bui-checkbox__input js-bui-checkbox__input\"]")
	private WebElement filterHighestPriceCheckbox;

	@FindBy(xpath = ".//li[@class=\" sort_category   sort_price \"]")
	private WebElement sortingByLowestPrice;

	@FindBy(xpath = "(.//td[@class=\"roomPrice  sr_discount \"])[1]/div/strong/b")
	private WebElement priceIfTwoAdultsSelected;

	@FindBy(xpath = "//*[@id=\"hotellist_inner\"]/div[1]/div[2]/div[2]/div/div[2]/div/strong/div/b")
	private WebElement priceIfMoreThatTwoAdultsSelected;

	public SearchResultsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public List<WebElement> filterHotelsWithLowestPrice() {
		scrollTableToFilters();
		Actions action = new Actions(driver);
		action.moveToElement(filterLowestPriceCheckbox).click().build().perform();
		List<WebElement> searchResults = driver.findElements(By.xpath(".//a[@class=\"hotel_name_link url\"]"));
		return searchResults;
	}

	public void scrollTableToFilters() {
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("document.getElementById('filter_price').scrollIntoView(true)");
	}

	public double getPriceOfTopRatedHotel() {
		sortingByScoreAndPrice.click();
		waitForLoading();
		String priceWithCurrency = priceIfTwoAdultsSelected.getText();
		return parsePrice(priceWithCurrency);
	}
	
	public void waitForLoading() {
		new WebDriverWait(driver, 10).until(ExpectedConditions
				.invisibilityOfElementLocated(By.xpath(".//div[@class=\"sr-usp-overlay__loading\"]")));
	}

	public void filterHotelsWithHighestPrice() {
		scrollTableToFilters();
		Actions action = new Actions(driver);
		action.moveToElement(filterHighestPriceCheckbox).click().build().perform();
		waitForLoading();
	}

	public double getPriceOfHotelWithLowestPrice() {
		sortingByLowestPrice.click();
		waitForLoading();
		String priceWithCurrency = priceIfMoreThatTwoAdultsSelected.getText();
		return parsePrice(priceWithCurrency);
	}

	public double parsePrice(String priceWithCurrency) {
		return Double.valueOf(priceWithCurrency.split(" ")[1].replace(",", ""));
	}
	
	public void openFirstHotel() {
		driver.findElement(By.xpath(".//a[@class=\"hotel_name_link url\"][1]")).click();
		ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
	    driver.switchTo().window(tabs.get(1));
	}

}
