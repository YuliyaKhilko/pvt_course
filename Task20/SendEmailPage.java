package pages;

import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SendEmailPage extends Page {
	
	private static final int TIMEOUT = 10;

	@FindBy(xpath = "(.//span[text() = \"Написать письмо\"])[1]")
	private WebElement newEmailButton;

	@FindBy(xpath = " .//textarea[@data-original-name = \"To\"]")
	private WebElement recepientField;

	@FindBy(xpath = ".//input[@name = \"Subject\"]")
	private WebElement subjectField;

	@FindBy(xpath = ".//textarea[@name=\"Body\"]")
	private WebElement bodyField;

	@FindBy(xpath = "(.//div[@data-name=\"send\"])[1]")
	private WebElement sendButton;

	@FindBy(xpath = ".//div[@class=\"message-sent__title\"]")
	private WebElement emailIsSentMessage;

	public SendEmailPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	public Boolean sendNewEmail(String recipient, String subject, String body) {
		new WebDriverWait(driver, TIMEOUT).ignoring(ElementNotVisibleException.class).until(ExpectedConditions.visibilityOf(newEmailButton));
		newEmailButton.click();
		enterText(recepientField, recipient);
		enterText(subjectField, subject);
		enterTinyMCEText(body);
		sendButton.click();
		new WebDriverWait(driver, TIMEOUT).until(ExpectedConditions.urlContains("sendmsgok"));
		return emailIsSentMessage.isDisplayed();
	}
}
