package cs.ben.edu.Labs.Lab5.test;

import static org.junit.Assert.assertEquals;

import java.sql.SQLException;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException;

import cs.ben.edu.Labs.Lab5.Major;
import cs.ben.edu.Labs.Lab5.MajorDao;

/**
 * MajorDaoTest class
 * 
 * @author Saran
 * @version 1.0
 */
public class MajorDaoTest {
	// Instantiate MajorDao class
	private static MajorDao test = new MajorDao();
	// Create Exception rule
	@Rule
	public ExpectedException exception = ExpectedException.none();

	/**
	 * Insert major test
	 */
	@Test
	public void insertMajorTest() {
		// Test inserting a major
		Major temp = new Major("test1", "test1", "test1", "test1");
		try {
			test.insertMajor(temp);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		Major temp2 = null;
		try {
			temp2 = test.getMajor("test1", "test1", "test1", "test1");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertEquals("test1", temp2.getClassification());
		assertEquals("test1", temp2.getCollege());
		assertEquals("test1", temp2.getDegree());
		assertEquals("test1", temp2.getMajor());

		// Test exception if there is a duplicate ID being inserted
		try {
			test.insertMajor(temp);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		exception.equals(MySQLIntegrityConstraintViolationException.class);
	}

	/**
	 * Get Major test
	 */
	@Test
	public void getMajorTest() {
		// Test getting a major off the database
		Major temp = null;
		try {
			temp = test.getMajor("Physics", "Undergraduate", "B.S.", "College of Science");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertEquals("Undergraduate", temp.getClassification());
		assertEquals("College of Science", temp.getCollege());
		assertEquals("B.S.", temp.getDegree());
		assertEquals("Physics", temp.getMajor());

		// Test if a major is not in the database
		try {
			temp = test.getMajor("test2", "test2", "test2", "test2");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		assertEquals(null, temp);
	}

}
