package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AddressBookPage extends Page {

	private static final int TIMEOUT = 10;

	@FindBy(xpath = ".//span[@data-name=\"ph-addressbook\"]")
	private WebElement linkToConacts;

	@FindBy(xpath = ".//a[@class=\"menu__option__link js-add-label\"]")
	private WebElement createGroupLink;

	@FindBy(xpath = ".//div[@class=\"form__row__widget\"]/input[@class=\"form__field js-input\"]")
	private WebElement groupNamefield;

	@FindBy(xpath = ".//button[@class=\"btn btn_main confirm-ok\"]")
	private WebElement confirmCreateGroup;

	@FindBy(xpath = ".//div[@id=\"js-add-contact\"]")
	private WebElement addContactsButton;

	@FindBy(xpath = ".//input[@id=\"emails_0\"]")
	private WebElement emailField;

	@FindBy(xpath = ".//input[@id=\"firstname\"]")
	private WebElement firstNameField;

	@FindBy(xpath = ".//div[@data-name=\"submit\"]")
	private WebElement saveButton;

	private WebElement getGroupLink(String groupName) {
		return driver.findElement(
				By.xpath("//*[contains(@href, \"/addressbook/label/\")]//*[text()=\"" + groupName + "\"]"));
	}

	public AddressBookPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	public void openAddressBook() {
		linkToConacts.click();
		new WebDriverWait(driver, TIMEOUT).until(ExpectedConditions.urlContains("addressbook"));
	}

	public void createContactsGroup(String groupName) {
		createGroupLink.click();
		groupNamefield.sendKeys(groupName);
		confirmCreateGroup.click();
		this.safe(driver -> {
			getGroupLink(groupName).getText();
			return true;
		});
	}

	public void addContactsToGroup(String groupName, String firstName, String email) {
		this.getGroupLink(groupName).click();
		addContactsButton.click();
		enterText(firstNameField, firstName);
		enterText(emailField, email);
		saveButton.click();
	}

}
