import java.util.EventObject;

public class FormEvent extends EventObject {
	
	private String name;
	private String occupation;
	private int idCategory;
	private String empCat;
	private String taxID;
	private boolean vnCitizen;
	private String gender;
	
	public FormEvent(Object source) {
		super(source);
	}

	public FormEvent(Object source, String name, String occupation, int idCategory, String empCat, String taxID,
			boolean vnCitizen, String gender) {
		super(source);
		this.name = name;
		this.occupation = occupation;
		this.idCategory = idCategory;
		this.empCat = empCat;
		this.taxID = taxID;
		this.vnCitizen = vnCitizen;
		this.gender = gender;
	}


	public String getGender() {
		return gender;
	}

	public String getTaxID() {
		return taxID;
	}

	public boolean isVnCitizen() {
		return vnCitizen;
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
	
	public int getidCategory() {
		return idCategory;
	}
	
	public String getEmploymentCategory() {
		return empCat;
	}

	@Override
	public String toString() {
		return "FormEvent [name=" + name + ", occupation=" + occupation + ", idCategory=" + idCategory + ", empCat="
				+ empCat + ", taxID=" + taxID + ", vnCitizen=" + vnCitizen + "]\n";
	}
	
	
}
