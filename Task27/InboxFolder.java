package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class InboxFolder extends Page {

	private static final int TIMEOUT = 10;

	@FindBy(xpath = "(.//a[@href=\"/messages/inbox/\"])[1]")
	WebElement linkToInboxFolder;

	@FindBy(xpath = "(.//div[@class=\"js-item-checkbox b-datalist__item__cbx\"]/div/div[@class=\"b-checkbox__box\"])[1]")
	WebElement firstEmailCheckbox;

	@FindBy(xpath = "(.//div[@data-name=\"spam\"])[1]")
	WebElement moveToSpamButton;

	@FindBy(xpath = ".//button[@class=\"btn b-spam-confirm__btn\"]")
	WebElement confirmMoveToSpam;

	@FindBy(xpath = "(.//div[@data-group=\"letters-more\"])[1]")
	WebElement moreDropdown;

	@FindBy(xpath = ".//a[@data-name=\"flag_no\"]")
	WebElement unflagAll;

	@FindBy(xpath = "(.//div[@data-name=\"remove\"])[1]")
	WebElement deleteAllButton;

	@FindBy(xpath = "(.//span[@class=\"b-datalist__empty__text\"])[1]")
	WebElement emptyInboxLabel;

	public InboxFolder(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	public void openInboxFolder() {
		this.safe(driver -> {
			this.linkToInboxFolder.click();
			return true;
		});

		new WebDriverWait(driver, TIMEOUT).until(ExpectedConditions.urlContains("inbox"));
	}

	public void moveFirstEmailToSpam() {
		this.safe(driver -> {
			firstEmailCheckbox.click();
			return true;
		});
		moveToSpamButton.click();
		confirmMoveToSpam.click();
	}

	public void markEmailWithFlag(int numberofEmailsToBeMarked) {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver);

		wait.until(driver -> {
			List<WebElement> notMarkedWithFlags = driver
					.findElements(By.xpath(".//div[@data-act=\"flag\" and not(contains(@class, \"b-flag_yes\"))]"));
			return notMarkedWithFlags.size() > 0;
		});

		List<WebElement> notMarkedWithFlags = driver
				.findElements(By.xpath(".//div[@data-act=\"flag\" and not(contains(@class, \"b-flag_yes\"))]"));

		for (int i = 0; i <= numberofEmailsToBeMarked - 1; i++) {
			notMarkedWithFlags.get(i).click();
		}
	}

	public int getNumberOfMarkedWithFlagEmails() {
		return driver.findElements(By.xpath(".//div[@data-act=\"flag\" and contains(@class, \"b-flag_yes\")]")).size();
	}

	public void unflagAllInboxEmails() {
		selectAllInboxEmails();
		moreDropdown.click();
		unflagAll.click();
	}

	public void emptyInboxFolder() {
		openInboxFolder();
		selectAllInboxEmails();
		deleteAllButton.click();
	}

}
