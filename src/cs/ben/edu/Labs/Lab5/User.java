package cs.ben.edu.Labs.Lab5;

/**
 * User class
 * 
 * @author Saran
 * @version 1.0
 */
public class User {
	// Class variables
	private String Name = "";
	private String Phone;
	private String email = "";
	private String ID;
	private String Street = "";
	private String City = "";
	private String Zip;
	private String Region = "";
	private String Lat_long = "";
	private int GPA;
	private String Major = "";
	private String Title = "";

	/**
	 * Constructor
	 * 
	 * @param Name
	 *            -String name
	 * @param Phone
	 *            -String phone
	 * @param email
	 *            -String email
	 * @param ID
	 *            -String id
	 * @param Street
	 *            -String street
	 * @param City
	 *            -String city
	 * @param Zip
	 *            -String zip
	 * @param Region
	 *            -String region
	 * @param Lat_long
	 *            -String lat_long
	 * @param GPA
	 *            -int gpa
	 * @param Major
	 *            -String major
	 * @param Title
	 *            -String title
	 */
	public User(String Name, String Phone, String email, String ID, String Street, String City, String Zip,
			String Region, String Lat_long, int GPA, String Major, String Title) {
		this.Name = Name;
		this.Phone = Phone;
		this.email = email;
		this.ID = ID;
		this.Street = Street;
		this.City = City;
		this.Zip = Zip;
		this.Region = Region;
		this.Lat_long = Lat_long;
		this.GPA = GPA;
		this.Major = Major;
		this.Title = Title;

	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		} else {
			User compare = (User) obj;
			return compare.getID().equals(ID);
		}
	}

	public String getName() {
		return Name;
	}

	public String getPhone() {
		return Phone;
	}

	public String getEmail() {
		return email;
	}

	public String getID() {
		return ID;
	}

	public String getStreet() {
		return Street;
	}

	public String getCity() {
		return City;
	}

	public String getZip() {
		return Zip;
	}

	public String getRegion() {
		return Region;
	}

	public String getLat_long() {
		return Lat_long;
	}

	public int getGPA() {
		return GPA;
	}

	public String getMajor() {
		return Major;
	}

	public String getTitle() {
		return Title;
	}

	public void setName(String name) {
		Name = name;
	}

	public void setPhone(String phone) {
		Phone = phone;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setID(String iD) {
		ID = iD;
	}

	public void setStreet(String street) {
		Street = street;
	}

	public void setCity(String city) {
		City = city;
	}

	public void setZip(String zip) {
		Zip = zip;
	}

	public void setRegion(String region) {
		Region = region;
	}

	public void setLat_long(String lat_long) {
		Lat_long = lat_long;
	}

	public void setGPA(int gPA) {
		GPA = gPA;
	}

	public void setMajor(String major) {
		Major = major;
	}

	public void setTitle(String title) {
		Title = title;
	}

}
