package pages;

import org.openqa.selenium.WebDriver;

import core.TestDataDAO;
import core.TestData;

public class MoveToSpamFacade {
	private SendEmailPage sendEmailPage;
	private InboxFolder inboxFolder; 
	private SpamFolder spamFolder;
	private static TestData testdata;
	private String subject;
	
	public MoveToSpamFacade(WebDriver driver) {
		sendEmailPage = new SendEmailPage(driver);
		inboxFolder = new InboxFolder(driver);
		spamFolder = new SpamFolder(driver);
	}
	
	public void SendEmailToSpam() {
		TestDataDAO testDataDAO = new TestDataDAO();
		testDataDAO.getConnection();
		testdata = testDataDAO.select().get(0);
		subject = testdata.getEmailSubject() + System.currentTimeMillis();
		sendEmailPage.sendNewEmail(testdata.getEmail(), subject, testdata.getEmailBody());
		inboxFolder.openInboxFolder();
		inboxFolder.moveFirstEmailToSpam();
		spamFolder.openSpamFolder();
		spamFolder.ensureHasEmailBySubject(subject);
	}
	
	public String getSubject() {
		return this.subject;
	}

}
