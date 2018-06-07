package cs.ben.edu.Labs.Lab5;

/**
 * Major class
 * 
 * @author Saran
 * @version 1.0
 */
public class Major {
	// Class variables
	private String Major = "";
	private String Classification = "";
	private String Degree = "";
	private String College = "";

	/**
	 * Constructor
	 * 
	 * @param Major
	 *            -String major
	 * @param Classification
	 *            -String classification
	 * @param Degree
	 *            -String degree
	 * @param College
	 *            -String college
	 */
	public Major(String Major, String Classification, String Degree, String College) {
		this.Major = Major;
		this.Classification = Classification;
		this.Degree = Degree;
		this.College = College;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		} else {
			Major compare = (Major) obj;
			return (compare.getMajor().equals(Major) && compare.getClassification().equals(Classification)
					&& compare.getDegree().equals(Degree) && compare.getCollege().equals(College));
		}
	}

	public String getMajor() {
		return Major;
	}

	public String getClassification() {
		return Classification;
	}

	public String getDegree() {
		return Degree;
	}

	public String getCollege() {
		return College;
	}

	public void setMajor(String major) {
		Major = major;
	}

	public void setClassification(String classification) {
		Classification = classification;
	}

	public void setDegree(String degree) {
		Degree = degree;
	}

	public void setCollege(String college) {
		College = college;
	}

}
