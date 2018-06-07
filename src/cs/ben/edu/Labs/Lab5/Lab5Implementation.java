package cs.ben.edu.Labs.Lab5;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.Scanner;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 * Lab 5 Implementation
 * 
 * @author Saran
 * @verion 1.0
 */
public class Lab5Implementation {
	// Class variables
	private static UserDao userDao = new UserDao();
	private static MajorDao majorDao = new MajorDao();
	/**
	 * Main method
	 * 
	 * @param args
	 *            String array
	 * @throws IOException
	 *             IO exception
	 * @throws SQLException
	 *             SQL exception
	 */
	public static void main(String[] args) throws IOException, SQLException {
		// Instantiate Scanner
		Scanner input = new Scanner(System.in);
		boolean bool = true;
		// While loop to get input and process request
		while (bool) {
			System.out.print("Enter file name(0 to quit): ");
			String fileName = input.next();
			if (fileName.equals("0")) {
				bool = false;
				break;
			} else {
				userDao.initalizeDatabase();
				dataImport(fileName);
			}
		}
		input.close();
		userDao.closeConnection();

	}

	/**
	 * Method that imports data from excel file and adds values to database
	 * 
	 * @param fileName
	 *            String name of file
	 * @throws IOException
	 *             IO exception
	 * @throws SQLException
	 *             SQL exception
	 */
	public static void dataImport(String fileName) throws IOException, SQLException {
		// File instantiation
		File f = new File(fileName);
		FileInputStream fi = new FileInputStream(f);
		// Instantiating excel IO library
		XSSFWorkbook wb = new XSSFWorkbook(fi);

		XSSFSheet userSheet = wb.getSheetAt(0);

		XSSFSheet majorSheet = wb.getSheetAt(1);
		// Iterator of rows in a sheet
		Iterator<Row> rowIterator = userSheet.iterator();
		// Removes first row
		Row row = rowIterator.next();
		// While loop that goes thought the sheet and adds to databse
		while (rowIterator.hasNext()) {
			row = rowIterator.next();
			String name = new DataFormatter().formatCellValue(row.getCell(0));
			String phone = new DataFormatter().formatCellValue(row.getCell(1));
			String email = new DataFormatter().formatCellValue(row.getCell(2));
			String id = new DataFormatter().formatCellValue(row.getCell(3));
			String street = new DataFormatter().formatCellValue(row.getCell(4));
			String city = new DataFormatter().formatCellValue(row.getCell(5));
			String zip = new DataFormatter().formatCellValue(row.getCell(6));
			String region = new DataFormatter().formatCellValue(row.getCell(7));
			String lat_long = new DataFormatter().formatCellValue(row.getCell(8));
			int gpa = (int) row.getCell(9).getNumericCellValue();
			String major = row.getCell(10).getStringCellValue();
			String title;
			if (row.getCell(11) == null) {
				title = "";
			} else {
				title = new DataFormatter().formatCellValue(row.getCell(11));
			}
			// If the user does not exist add it
			if (userDao.getUser(id) == null) {
				userDao.insertUser(
						new User(name, phone, email, id, street, city, zip, region, lat_long, gpa, major, title));
			}
		}
		// Go through the next sheet
		rowIterator = majorSheet.iterator();
		row = rowIterator.next();
		// While loop to go though the sheet
		while (rowIterator.hasNext()) {
			row = rowIterator.next();

			String major = row.getCell(0).getStringCellValue();
			String classification = row.getCell(1).getStringCellValue();
			String degree = row.getCell(2).getStringCellValue();
			String college = row.getCell(3).getStringCellValue();
			// If the major does'nt not exist in database add it
			if (majorDao.getMajor(major, classification, degree, college) == null) {
				majorDao.insertMajor(new Major(major, classification, degree, college));
			}
		}

		wb.close();

	}

}
