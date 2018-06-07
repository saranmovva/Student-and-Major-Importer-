package cs.ben.edu.Labs.Lab5.test;

import static org.junit.Assert.assertEquals;

import java.sql.SQLException;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException;

import cs.ben.edu.Labs.Lab5.User;
import cs.ben.edu.Labs.Lab5.UserDao;

/**
 * UserDaoTest Class
 * 
 * @author Saran
 * @version 1.0
 */
public class UserDaoTest {
	// Instantiate UserDao class
	private static UserDao test = new UserDao();
	// Create exception rule
	@Rule
	public ExpectedException exception = ExpectedException.none();

	/**
	 * Test to see if user is inserted
	 */
	@Test
	public void insertUserTest() {
		// Test inserting a user
		User temp = new User("test1", "test1", "test1", "test1", "test1", "test1", "test1", "test1", "test1", 0,
				"test1", "test1");
		try {
			test.insertUser(temp);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		String expected = "test1";
		String actual = null;
		try {
			actual = test.getUser("test1").getID();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertEquals(expected, actual);

		// Test exception if there is a duplicate ID being inserted
		try {
			test.insertUser(temp);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		exception.equals(MySQLIntegrityConstraintViolationException.class);
	}

	/**
	 * Tests the get user method
	 */
	@Test
	public void getUserTest() {
		// Test getting a user off the database
		User temp = null;
		try {
			temp = test.getUser("AL26269262513387802900788711");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertEquals("Berk Mercer", temp.getName());
		assertEquals("1-291-858-0529", temp.getPhone());
		assertEquals("odio.Nam@velconvallis.net", temp.getEmail());
		assertEquals("8583 Non Street", temp.getStreet());
		assertEquals("Wagga Wagga", temp.getCity());
		assertEquals("3433", temp.getZip());
		assertEquals("New South Wales", temp.getRegion());
		assertEquals("-50.89189, 147.7944", temp.getLat_long());
		assertEquals(4, temp.getGPA());

		// Test if a user is not in the database
		try {
			temp = test.getUser("DoesntExist");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		assertEquals(null, temp);
	}
}
