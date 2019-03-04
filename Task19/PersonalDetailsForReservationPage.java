package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PersonalDetailsForReservationPage {

	private WebDriver driver;

	@FindBy(xpath = ".//input[@id=\"lastname\"]")
	private WebElement lastNameField;

	@FindBy(xpath = ".//input[@id=\"email\"]")
	private WebElement emailField;

	@FindBy(xpath = ".//input[@id=\"email_confirm\"]")
	private WebElement emailConfirmationField;

	@FindBy(xpath = ".//button[@name=\"book\"]")
	private WebElement nextStep;

	@FindBy(xpath = ".//input[@id=\"cc_number\"]")
	private WebElement cardNumberField;

	@FindBy(xpath = ".//input[@id=\"cc_cvc\"]")
	private WebElement cvcCodeField;

	@FindBy(xpath = ".//p[@id=\"bp_form_cc_number_msg\"]")
	private WebElement InvalidCardMunberMessage;

	public PersonalDetailsForReservationPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void eneterPersonalDetails(String lastName, String email) {
		new WebDriverWait(driver, 10).until(ExpectedConditions.titleContains("Your Details"));
		((JavascriptExecutor) driver).executeScript("document.getElementById('lastname').scrollIntoView(true)");
		lastNameField.sendKeys(lastName);
		emailField.sendKeys(email);
		emailConfirmationField.sendKeys(email);
		((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight)");
		nextStep.click();
		new WebDriverWait(driver, 10).until(ExpectedConditions.titleContains("Final Details"));
	}

	public boolean isInvalidCardNumberDisplayed(String cardNumber) {
		((JavascriptExecutor) driver).executeScript("document.getElementById('cc_number').scrollIntoView(true)");
		cardNumberField.sendKeys(cardNumber);
		cvcCodeField.click();
		return driver.findElements(By.id("bp_form_cc_number_msg")).size() != 0;
	}
}
