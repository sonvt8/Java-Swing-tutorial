package Model;

import java.io.Serializable;

public class Person implements Serializable{

	private static final long serialVersionUID = -1250931765243357219L;

	private static int count = 1;
	
	private int id;
	private String name;
	private String occupation;
	private AgeCategory ageCategory;
	private EmploymentCategory empCat;
	private String taxID;
	private boolean vnCitizen;
	private Gender gender;
	
	public Person(String name, String occupation, AgeCategory ageCategory, EmploymentCategory empCat,
			String taxID, boolean vnCitizen, Gender gender) {
		this.id = count;
		this.name = name;
		this.occupation = occupation;
		this.ageCategory = ageCategory;
		this.empCat = empCat;
		this.taxID = taxID;
		this.vnCitizen = vnCitizen;
		this.gender = gender;
		count++;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getOccupation() {
		return occupation;
	}
	public void setOccupation(String occupation) {
		this.occupation = occupation;
	}
	public AgeCategory getAgeCategory() {
		return ageCategory;
	}
	public void setAgeCategory(AgeCategory ageCategory) {
		this.ageCategory = ageCategory;
	}
	public EmploymentCategory getEmpCat() {
		return empCat;
	}
	public void setEmpCat(EmploymentCategory empCat) {
		this.empCat = empCat;
	}
	public String getTaxID() {
		return taxID;
	}
	public void setTaxID(String taxID) {
		this.taxID = taxID;
	}
	public boolean isVnCitizen() {
		return vnCitizen;
	}
	public void setVnCitizen(boolean vnCitizen) {
		this.vnCitizen = vnCitizen;
	}
	public Gender getGender() {
		return gender;
	}
	public void setGender(Gender gender) {
		this.gender = gender;
	}

	@Override
	public String toString() {
		return "Person [id=" + id + ", name=" + name + ", occupation=" + occupation + ", ageCategory=" + ageCategory
				+ ", empCat=" + empCat + ", taxID=" + taxID + ", vnCitizen=" + vnCitizen + ", gender=" + gender + "]";
	}
}
