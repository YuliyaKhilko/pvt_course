package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SpamFolder extends Page {

	private static final int TIMEOUT = 15;

	@FindBy(xpath = "(.//div[@data-name=\"noSpam\"])[1]")
	WebElement notSpamButton;

	@FindBy(xpath = "(.//div[@class=\"js-item-checkbox b-datalist__item__cbx\"]/div/div[@class=\"b-checkbox__box\"])[1]")
	WebElement firstEmailCheckbox;

	@FindBy(xpath = "(//*[(@data-cache-key) and not(contains(@style,\"display: none\"))]//div[@data-name=\"remove\"])[1]")
	WebElement deleteAllButton;

	@FindBy(xpath = ".//div[@data-id]/a[@href=\"/messages/spam/\"]")
	WebElement linkToSpam;

	public SpamFolder(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	public void openSpamFolder() {
		this.safe(driver -> {
			this.linkToSpam.click();
			return true;
		});

		new WebDriverWait(driver, TIMEOUT).until(ExpectedConditions.urlContains("spam"));
	}

	public void moveFromSpamToIndox() {
		firstEmailCheckbox.click();
		notSpamButton.click();
	}

	public void emptySpamFolder() {
		openSpamFolder();
		selectAllInboxEmails();
		this.safe(driver -> {
			deleteAllButton.click();
			return true;
		});

	}
}
