package cs.ben.edu.Labs.Lab5;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Databse connector
 * 
 * @author Saran
 * @version 1.0
 */
public class DBConnector {
	// Class variables
	static Connection con;

	/**
	 * Default Constructor
	 */
	public DBConnector() {
		// Instantiate connection and throw exception if fails
		try {
			try {
				Class.forName("com.mysql.jdbc.Driver");
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306?user=root&password=root");
		} catch (SQLException ex) {
			// handle Error
			System.out.println("SQL Exception: " + ex.getMessage());
			System.out.println("SQL State: " + ex.getSQLState());
			System.out.println("Vendor Error: " + ex.getErrorCode());
		}
	}

	/**
	 * Get connection
	 * 
	 * @return Connection
	 */
	public static Connection getConnection() {
		return con;
	}

	/**
	 * Closes the connection
	 */
	public void closeConnection() {
		try {
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Method that creates the database if it does not exist
	 * 
	 * @throws SQLException
	 *             -SQL Exception
	 */
	public void initalizeDatabase() throws SQLException {
		Connection con = getConnection();
		PreparedStatement ps = con.prepareStatement("CREATE DATABASE IF NOT EXISTS Lab5");
		ps.executeUpdate();

		ps = con.prepareStatement(
				"CREATE TABLE IF NOT EXISTS Lab5.user (name VARCHAR(100) NOT NULL, phone VARCHAR(100) NOT NULL, email VARCHAR(100) NOT NULL, id_num VARCHAR(100) PRIMARY KEY,"
						+ "street VARCHAR(100) NOT NULL, city VARCHAR(100) NOT NULL, zip VARCHAR(100) NOT NULL, region VARCHAR(100) NOT NULL, lat_long VARCHAR(100) NOT NULL,"
						+ "gpa INT(10) NOT NULL, major VARCHAR(100) NOT NULL, title VARCHAR(100) NULL)");
		ps.executeUpdate();

		ps = con.prepareStatement(
				"CREATE TABLE IF NOT EXISTS Lab5.majors (Major VARCHAR(100) NOT NULL, Classification VARCHAR(100) NOT NULL, Degree VARCHAR(100) NOT NULL, College VARCHAR(100) NOT NULL)");
		ps.executeUpdate();
	}
}
