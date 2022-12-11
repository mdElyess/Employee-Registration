package tn.mohamedilyess.registration.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import tn.mohamedilyess.registration.model.Employee;

public class EmployeeDao {
	public int registerEmployee(Employee employee) throws ClassNotFoundException {
		String INSER_USERS_SQL = "INSERT INTO employee"
				+ "(id, first_name, last_name, username, password, address, contact) VALUES " + "(?, ?, ?, ?, ?, ?, ?)";
		int result = 0;

		Class.forName("com.mysql.jdbc.Driver");
		try (Connection connection = DriverManager
				.getConnection("jdbc:mysql://localhost:8181/employees?useSSL=false", "root", "toor");

				// Create a Statement Using Connection Object
				PreparedStatement preparedStatement = connection.prepareStatement(INSER_USERS_SQL)) {
			preparedStatement.setInt(1, 1);
			preparedStatement.setString(2, employee.getFirstName());
			preparedStatement.setString(3, employee.getLastName());
			preparedStatement.setString(4, employee.getUsername());
			preparedStatement.setString(5, employee.getPassword());
			preparedStatement.setString(6, employee.getAddress());
			preparedStatement.setString(7, employee.getContact());
			System.out.println(preparedStatement);

			// Execute the query or update query
			result = preparedStatement.executeUpdate();
		} catch (SQLException e) {
			// process SQL exception
			e.printStackTrace();
		}
		return result;
	}
}
