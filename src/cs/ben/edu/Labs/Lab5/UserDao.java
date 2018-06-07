package cs.ben.edu.Labs.Lab5;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Lab 5 Class
 * 
 * @author Saran
 * @version 1.0
 */
public class UserDao extends DBConnector {

	/**
	 * Method that returns user from database
	 * 
	 * @param IDNumber
	 *            -String value of the id you want to search
	 * @return -User of the user returned
	 * @throws SQLException
	 *             -SQL exception
	 */
	public User getUser(String IDNumber) throws SQLException {
		Connection con = getConnection();
		String sql = "select * from Lab5.user where id_num = '" + IDNumber + "'";
		PreparedStatement query = con.prepareStatement(sql);

		ResultSet rs = query.executeQuery();

		if (rs.next()) {
			String Name = rs.getString("name");
			String Phone = rs.getString("phone");
			String email = rs.getString("email");
			String ID = rs.getString("id_num");
			String Street = rs.getString("street");
			String City = rs.getString("city");
			String Zip = rs.getString("zip");
			String Region = rs.getString("region");
			String Lat_long = rs.getString("lat_long");
			int GPA = rs.getInt("gpa");
			String Major = rs.getString("major");
			String Title = rs.getString("title");

			return new User(Name, Phone, email, ID, Street, City, Zip, Region, Lat_long, GPA, Major, Title);
		}
		return null;
	}

	/**
	 * Method that inserts user into the database
	 * 
	 * @param user
	 *            -User user you want to enter
	 * @throws SQLException
	 *             -SQL exception
	 */
	public void insertUser(User user) throws SQLException {

		Connection con = getConnection();
		String sql = "INSERT INTO lab5.user (name,phone,email,id_num,street,city,zip,region,lat_long,gpa,major,title) VALUES (?,?,?,?,?,?,?,?,?,?,?,?)";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, user.getName());
		ps.setString(2, user.getPhone());
		ps.setString(3, user.getEmail());
		ps.setString(4, user.getID());
		ps.setString(5, user.getStreet());
		ps.setString(6, user.getCity());
		ps.setString(7, user.getZip());
		ps.setString(8, user.getRegion());
		ps.setString(9, user.getLat_long());
		ps.setInt(10, user.getGPA());
		ps.setString(11, user.getMajor());
		ps.setString(12, user.getTitle());

		ps.executeUpdate();
	}
}
