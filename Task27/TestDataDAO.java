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

			while (resultSet.next()) {
				data.add(new TestDataAdapter(resultSet));
			}
			resultSet.close();
			statement.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return data;
	}
}
