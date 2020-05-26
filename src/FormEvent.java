import java.util.EventObject;

public class FormEvent extends EventObject {
	
	private String name;
	private String occupation;
	private int idCategory;
	
	public FormEvent(Object source) {
		super(source);
	}

	public FormEvent(Object source, String name, String occupation, int id) {
		super(source);
		this.name = name;
		this.occupation = occupation;
		this.idCategory = id;
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
}
