package cs.ben.edu.Labs.Lab5;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MajorDao extends DBConnector {
	/**
	 * Method that inserts major into database
	 * 
	 * @param major
	 *            -Major major that you want to insert
	 * @throws SQLException
	 *             -SQL exception
	 */
	public void insertMajor(Major major) throws SQLException {
		Connection con = getConnection();
		String sql = "INSERT INTO lab5.majors (Major,Classification,Degree,College) VALUES (?,?,?,?)";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, major.getMajor());
		ps.setString(2, major.getClassification());
		ps.setString(3, major.getDegree());
		ps.setString(4, major.getCollege());

		ps.executeUpdate();
	}
	
	/**
	 * Method that returns the major from the database if exists
	 * 
	 * @param Major
	 *            -String major
	 * @param Classification
	 *            -String classification
	 * @param Degree
	 *            -String degree
	 * @param College
	 *            -String college
	 * @return -Major of the major returned
	 * @throws SQLException
	 *             -SQL exception
	 */
	public Major getMajor(String Major, String Classification, String Degree, String College) throws SQLException {
		Connection con = getConnection();
		String sql = "select * from Lab5.majors where Major = '" + Major + "' and Classification = '" + Classification
				+ "' and Degree = '" + Degree + "' and College = '" + College + "'";
		PreparedStatement query = con.prepareStatement(sql);

		ResultSet rs = query.executeQuery();

		if (rs.next()) {
			String MajorTemp = rs.getString("Major");
			String ClassificationTemp = rs.getString("Classification");
			String DegreeTemp = rs.getString("Degree");
			String CollegeTemp = rs.getString("College");

			return new Major(MajorTemp, ClassificationTemp, DegreeTemp, CollegeTemp);
		}
		return null;
	}
}
