package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage extends Page {

	private WebDriver driver;
	private static final int TIMEOUT = 10;

	@FindBy(xpath = ".//input[@id=\"mailbox:login\"]")
	private WebElement loginField;

	@FindBy(xpath = ".//input[@id=\"mailbox:password\"]")
	private WebElement passwordField;

	@FindBy(xpath = ".//input[@class=\"o-control\"]")
	private WebElement loginButton;

	@FindBy(xpath = ".//a[@id=\"PH_logoutLink\"]")
	private WebElement logOutLink;

	public LoginPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void login(String login, String password) {
		enterText(loginField, login);
		enterText(passwordField, password);
		loginButton.click();
		new WebDriverWait(driver, TIMEOUT)
				.until(ExpectedConditions.refreshed(ExpectedConditions.visibilityOf(logOutLink)));
	}

	public void logout() {
		logOutLink.click();
	}

}
