package core;

import java.sql.ResultSet;
import java.sql.SQLException;

public class TestDataAdapter implements TestData {
	private String login;
	private String password;
	private String email;
	private String emailSubject;
	private String emailBody;
	private String groupName;
	private String name;

	public TestDataAdapter(ResultSet resultSet) {
		try {
			this.login = resultSet.getString("login");
		} catch (SQLException e) {
			this.login = null;
		}
		try {
			this.password = resultSet.getString("password");
		} catch (SQLException e) {
			this.password = null;
		}
		try {
			this.email = resultSet.getString("email");
		} catch (SQLException e) {
			this.email = null;
		}
		try {
			this.emailSubject = resultSet.getString("email_subject");
		} catch (SQLException e) {
			this.emailSubject = null;
		}
		try {
			this.emailBody = resultSet.getString("email_body");
		} catch (SQLException e) {
			this.emailBody = null;
		}
		try {
			this.groupName = resultSet.getString("group_name");
		} catch (SQLException e) {
			this.groupName = null;
		}
		try {
			this.name = resultSet.getString("name");
		} catch (SQLException e) {
			this.name = null;
		}

	}

	@Override
	public String getLogin() {
		return login;
	}

	@Override
	public String getPassword() {
		return password;
	}

	@Override
	public String getEmail() {
		return email;
	}

	@Override
	public String getEmailSubject() {
		return emailSubject;
	}

	@Override
	public String getEmailBody() {
		return emailBody;
	}

	@Override
	public String getGroupName() {
		return groupName;
	}

	@Override
	public String getName() {
		return name;
	}

}
