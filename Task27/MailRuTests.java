package core;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import WebDriver.WebDriverSingleton;
import pages.AddressBookPage;
import pages.InboxFolder;
import pages.LoginPage;
import pages.MoveToSpamFacade;
import pages.SendEmailPage;
import pages.SpamFolder;

public class MailRuTests {

	private WebDriver driver;
	private LoginPage loginPage;
	private SendEmailPage sendEmailPage;
	private InboxFolder inboxFolder;
	private SpamFolder spamFolder;
	private AddressBookPage addressBookPage;
	private static TestData testData;
	private MoveToSpamFacade moveToSpamFacade;

	@BeforeClass
	public static void setUpClass() {
		TestDataDAO testDataDAO = new TestDataDAO();
		testDataDAO.getConnection();
		testData = testDataDAO.select().get(0);
	}

	@Before
	public void setUp() {
		// singleton for webDriver
		driver = WebDriverSingleton.getDriver();
		driver.manage().window().maximize();
		loginPage = new LoginPage(driver);
		inboxFolder = new InboxFolder(driver);
		spamFolder = new SpamFolder(driver);
		sendEmailPage = new SendEmailPage(driver);
		addressBookPage = new AddressBookPage(driver);
		moveToSpamFacade = new MoveToSpamFacade(driver);
		driver.get("https://www.mail.ru/");
		loginPage.login(testData.getLogin(), testData.getPassword());
		inboxFolder.emptyInboxFolder();
		spamFolder.emptySpamFolder();
	}

	@After
	public void tearDown() {
		loginPage.logout();
		WebDriverSingleton.closeWebBrowser();
	}

	@Test
	public void testMoveEmailToSpam() {
		// use facade pattern
		moveToSpamFacade.SendEmailToSpam();
		Assert.assertTrue(spamFolder.getListOfEmails().size() == 1);
	}

	@Test
	public void testMoveFromSpamToInbox() {
		moveToSpamFacade.SendEmailToSpam();
		spamFolder.moveFromSpamToIndox();
		inboxFolder.openInboxFolder();
		inboxFolder.ensureHasEmailBySubject(moveToSpamFacade.getSubject());
		Assert.assertTrue((inboxFolder.getListOfEmails()).size() > 0);
	}

	@Test
	public void testSendEmailToGroupOfPeople() {
		String groupName = testData.getGroupName() + System.currentTimeMillis();
		addressBookPage.openAddressBook();
		addressBookPage.createContactsGroup(groupName);
		addressBookPage.addContactsToGroup(groupName, testData.getName(), testData.getEmail());
		Assert.assertTrue(sendEmailPage.sendNewEmail(groupName, testData.getEmailSubject(), testData.getEmailBody()));
	}

	@Test
	public void testMarkEmailWithFlag() {
		int numberOfEmailsToBeMarkedWithFlag = 3;
		for (int i = 0; i <= 4; i++) {
			sendEmailPage.sendNewEmail(testData.getEmail(), testData.getEmailSubject() + i, testData.getEmailBody());
		}
		inboxFolder.openInboxFolder();
		inboxFolder.markEmailWithFlag(numberOfEmailsToBeMarkedWithFlag);
		Assert.assertEquals(inboxFolder.getNumberOfMarkedWithFlagEmails(), numberOfEmailsToBeMarkedWithFlag);

	}

	@Test
	public void testUnflagAllEmails() {
		testMarkEmailWithFlag();
		inboxFolder.unflagAllInboxEmails();
		Assert.assertTrue(inboxFolder.getNumberOfMarkedWithFlagEmails() == 0);
	}

}
