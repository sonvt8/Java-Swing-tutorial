import java.sql.SQLException;

import Model.AgeCategory;
import Model.Database;
import Model.EmploymentCategory;
import Model.Gender;
import Model.Person;

public class TestDB {

	public static void main(String[] args) {
		Database db = new Database();
		db.connect();
		
		db.addPerson(new Person("Tommy", "dev", AgeCategory.adult, EmploymentCategory.employed, "123456", true, Gender.male));
		db.addPerson(new Person("Linda", "promotion", AgeCategory.senior, EmploymentCategory.selfEmployed, "789012", false, Gender.female));
		
		try {
			db.save();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		db.disconnect();
	}

}
