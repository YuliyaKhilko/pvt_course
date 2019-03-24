package core;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

public class TestDataDAO {
	Connection connection = null;

	public Connection getConnection() {
		String url = "jdbc:mysql://localhost:3306/sys?useSSL=false";
		String user = "root";
		String password = "qwerty123";
		try {
			// Class.forName("com.mysql.jdbc.Driver");
			if (connection == null)
				connection = DriverManager.getConnection(url, user, password);

		} catch (SQLException e) {

			e.printStackTrace();

		}
		return connection;
	}

	public List<TestData> select() {

		List<TestData> data = new LinkedList<TestData>();
		try {
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery("SELECT * FROM test_automation.test_data");

			TestData testData = null;
			while (resultSet.next()) {
				testData = new TestData();
				testData.setLogin(resultSet.getString("login"));
				testData.setPassword(resultSet.getString("password"));
				testData.setEmail(resultSet.getString("email"));
				testData.setEmailSubject(resultSet.getString("email_subject"));
				testData.setEmailBody(resultSet.getString("email_body"));
				testData.setGroupName(resultSet.getString("group_name"));
				testData.setName(resultSet.getString("name"));
				data.add(testData);
			}
			resultSet.close();
			statement.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return data;
	}
}
