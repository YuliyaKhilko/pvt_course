package core;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import pages.AddressBookPage;
import pages.InboxFolder;
import pages.LoginPage;
import pages.SendEmailPage;
import pages.SpamFolder;

public class MailRuTests {

	private WebDriver driver;
	private LoginPage loginPage;
	private SendEmailPage sendEmailPage;
	private InboxFolder inboxFolder;
	private SpamFolder spamFolder;
	private AddressBookPage addressBookPage;
	private static TestData testdata;

	@BeforeClass
	public static void setUpClass() {
		TestDataDAO testDataDAO = new TestDataDAO();
		testDataDAO.getConnection();
		testdata = testDataDAO.select().get(0);
	}

	@Before
	public void setUp() {
		String exePath = "/Users/yulyakhilko/Documents/chromedriver";
		System.setProperty("webdriver.chrome.driver", exePath);
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		loginPage = new LoginPage(driver);
		inboxFolder = new InboxFolder(driver);
		spamFolder = new SpamFolder(driver);
		sendEmailPage = new SendEmailPage(driver);
		addressBookPage = new AddressBookPage(driver);
		driver.get("https://www.mail.ru/");
		loginPage.login(testdata.getLogin(), testdata.getPassword());
		inboxFolder.emptyInboxFolder();
		spamFolder.emptySpamFolder();
	}

	@After
	public void tearDown() {
		loginPage.logout();
		driver.quit();
	}

	@Test
	public void testMoveEmailToSpam() {

		String subject = testdata.getEmailSubject() + System.currentTimeMillis();
		sendEmailPage.sendNewEmail(testdata.getEmail(), subject, testdata.getEmailBody());
		inboxFolder.openInboxFolder();
		inboxFolder.moveFirstEmailToSpam();
		spamFolder.openSpamFolder();
		spamFolder.ensureHasEmailBySubject(subject);
		Assert.assertTrue(spamFolder.getListOfEmails().size() == 1);
	}

	@Test
	public void testMoveFromSpamToInbox() {

		String subject = testdata.getEmailSubject() + System.currentTimeMillis();
		sendEmailPage.sendNewEmail(testdata.getEmail(), subject, testdata.getEmailBody());
		inboxFolder.openInboxFolder();
		inboxFolder.moveFirstEmailToSpam();
		spamFolder.openSpamFolder();
		spamFolder.ensureHasEmailBySubject(subject);
		spamFolder.moveFromSpamToIndox();
		inboxFolder.openInboxFolder();
		inboxFolder.ensureHasEmailBySubject(subject);
		Assert.assertTrue((inboxFolder.getListOfEmails()).size() > 0);
	}

	@Test
	public void testSendEmailToGroupOfPeople() {
		String groupName = testdata.getGroupName() + System.currentTimeMillis();
		addressBookPage.openAddressBook();
		addressBookPage.createContactsGroup(groupName);
		addressBookPage.addContactsToGroup(groupName, testdata.getName(), testdata.getEmail());
		Assert.assertTrue(sendEmailPage.sendNewEmail(groupName, testdata.getEmailSubject(), testdata.getEmailBody()));
	}

	@Test
	public void testMarkEmailWithFlag() {
		int numberOfEmailsToBeMarkedWithFlag = 3;
		for (int i = 0; i <= 4; i++) {
			sendEmailPage.sendNewEmail(testdata.getEmail(), testdata.getEmailSubject() + i, testdata.getEmailBody());
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
