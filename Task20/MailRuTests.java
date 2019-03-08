package core;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import pages.AddressBookPage;
import pages.InboxFolder;
import pages.LoginPage;
import pages.SendEmailPage;
import pages.SpamFolder;

public class MailRuTests {

	private static final String LOGIN = "ylkhilko";
	private static final String PASSWORD = "pa55word";
	private static final String EMAIL = "ylkhilko@mail.ru";
	private static final String SUBJECT = "test subject";
	private static final String BODY = "Test body";
	private WebDriver driver;
	private LoginPage loginPage;
	private SendEmailPage sendEmailPage;
	private InboxFolder inboxFolder;
	private SpamFolder spamFolder;
	private AddressBookPage addressBookPage;

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
		loginPage.login(LOGIN, PASSWORD);
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

		String subject = "testSubject" + System.currentTimeMillis();
		sendEmailPage.sendNewEmail(EMAIL, subject, BODY);
		inboxFolder.openInboxFolder();
		inboxFolder.moveFirstEmailToSpam();
		spamFolder.openSpamFolder();
		spamFolder.ensureHasEmailBySubject(subject);
		Assert.assertTrue(spamFolder.getListOfEmails().size() == 1);

	}

	@Test
	public void testMoveFromSpamToInbox() {

		String subject = "testSubject" + System.currentTimeMillis();
		sendEmailPage.sendNewEmail(EMAIL, subject, BODY);
		inboxFolder.openInboxFolder();
		inboxFolder.moveFirstEmailToSpam();
		spamFolder.openSpamFolder();
		spamFolder.ensureHasEmailBySubject(subject);
		spamFolder.moveFromSpamToIndox();
		inboxFolder.openInboxFolder();
		inboxFolder.ensureHasEmailBySubject(subject);
		// TODO check email by subject
		Assert.assertTrue((inboxFolder.getListOfEmails()).size() > 0);
	}

	@Test
	public void testSendEmailToGroupOfPeople() {
		String groupName = "testGroup" + System.currentTimeMillis();
		String name = "Yuliya";
		addressBookPage.openAddressBook();
		addressBookPage.createContactsGroup(groupName);
		addressBookPage.addContactsToGroup(groupName, name, EMAIL);

		Assert.assertTrue(sendEmailPage.sendNewEmail(groupName, SUBJECT, BODY));
	}

	@Test
	public void testMarkEmailWithFlag() {
		int numberOfEmailsToBeMarkedWithFlag = 3;
		for (int i = 0; i <= 4; i++) {
			sendEmailPage.sendNewEmail(EMAIL, SUBJECT + i, BODY);
		}
		inboxFolder.openInboxFolder();
		inboxFolder.markEmailWithFlag(numberOfEmailsToBeMarkedWithFlag);
		System.out.println(inboxFolder.getNumberOfMarkedWithFlagEmails());

		Assert.assertEquals(inboxFolder.getNumberOfMarkedWithFlagEmails(), numberOfEmailsToBeMarkedWithFlag);

	}

	@Test
	public void testUnflagAllEmails() {
		testMarkEmailWithFlag();
		inboxFolder.unflagAllInboxEmails();
		Assert.assertTrue(inboxFolder.getNumberOfMarkedWithFlagEmails() == 0);
	}

}
