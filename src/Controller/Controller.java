package Controller;

import java.io.File;
import java.io.IOException;
import java.util.List;

import GUI.FormEvent;
import Model.AgeCategory;
import Model.Database;
import Model.EmploymentCategory;
import Model.Gender;
import Model.Person;

public class Controller {
	Database db = new Database();
	
	public List<Person> getPeople(){
		return db.getPeople();
	}
	
	public void addPerson(FormEvent ev) {
		String name = ev.getName();
		String occupation = ev.getOccupation();
		int ageCat = ev.getAgeCategory();
		String empCat = ev.getEmploymentCategory();
		boolean isVn = ev.isVnCitizen();
		String taxID = ev.getTaxID();
		String gender = ev.getGender();
		
		AgeCategory ageCategory = null;
		
		switch (ageCat) {
		case 0:
			ageCategory = AgeCategory.child;
			break;
		case 1:
			ageCategory = AgeCategory.adult;
			break;
		case 2:
			ageCategory = AgeCategory.senior;
			break;
		}
		
		EmploymentCategory empCategory;
		
		if(empCat.equals("employed")) {
			empCategory = EmploymentCategory.employed;
		}else if(empCat.equals("self-employed")) {
			empCategory = EmploymentCategory.selfemployed;
		}else if(empCat.equals("self-employed")) {
			empCategory = EmploymentCategory.unemployed;
		}else {
			empCategory = EmploymentCategory.other;
			System.err.println(empCat);
		}
		
		Gender genderCat;
		
		if(gender == "male") {
			genderCat = Gender.male;
		}else {
			genderCat = Gender.female;
		}
		
		Person person = new Person(name, occupation, ageCategory, empCategory, taxID, isVn, genderCat);
		db.addPerson(person);
	}
	
	public void saveToFile(File f) throws IOException {
		db.saveToFile(f);
	}
	
	public void loadFromFile(File f) throws IOException {
		db.loadFromFile(f);
	}
}
