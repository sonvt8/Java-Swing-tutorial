package Model;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Database {
	private LinkedList<Person> people;
	
	private Connection cnn;
	
	public Database() {
		people = new LinkedList<Person>();
	}
	
	public void connect() {
		if(cnn != null) return;
		
		String strConn = "jdbc:sqlserver://DESKTOP-HEPHQND\\SQLEXPRESS:1433; databaseName=JavaSwingTutorial; user=sa; password=abc123@@@;";
		try 
		{
			cnn = DriverManager.getConnection(strConn);
			Statement stmt = cnn.createStatement();
			System.out.println("Connect to database successfully");
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	public void disconnect() {
		if(cnn != null) {
			try {
				cnn.close();
			} catch (SQLException e) {
				System.out.println("Can't close connection");
			}
		}
	}
	
	public void save() throws SQLException {
		String checkSql = "select count(*) as count from people where id=?";
		PreparedStatement checkStmt = cnn.prepareStatement(checkSql);
		
		String insertSQL = "insert into people(id,name,age,employment_status,tax_id,vn_citizen,gender,occupation) values (?,?,?,?,?,?,?,?)";
		PreparedStatement inserStm = cnn.prepareStatement(insertSQL);
		
		String updateSQL = "update people set name=?, age=?, employment_status=?, tax_id=?, vn_citizen=?, gender=?, occupation=? where id=?";
		PreparedStatement updateStm = cnn.prepareStatement(updateSQL);
		
		for(Person person: people) {
			int id  = person.getId();
			String name = person.getName();
			String job = person.getOccupation();
			AgeCategory age = person.getAgeCategory();
			EmploymentCategory emp = person.getEmpCat();
			String tax = person.getTaxID();
			boolean isVn = person.isVnCitizen();
			Gender gender = person.getGender();
			
			checkStmt.setInt(1, id);
			ResultSet rs = checkStmt.executeQuery();
			rs.next();
			
			int count = rs.getInt(1);
			
			if(count == 0) {
				System.out.println("Inserting person with ID " + id);
				
				int col = 1;
				inserStm.setInt(col++, id);
				inserStm.setString(col++, name);
				inserStm.setString(col++, age.name());
				inserStm.setString(col++, emp.name());
				inserStm.setString(col++, tax);
				inserStm.setBoolean(col++, isVn);
				inserStm.setString(col++, gender.name());
				inserStm.setString(col++, job);
				
				inserStm.executeUpdate();
			}else {
				System.out.println("Updating person with ID " + id);

				int col = 1;
				updateStm.setString(col++, name);
				updateStm.setString(col++, age.name());
				updateStm.setString(col++, emp.name());
				updateStm.setString(col++, tax);
				updateStm.setBoolean(col++, isVn);
				updateStm.setString(col++, gender.name());
				updateStm.setString(col++, job);
				updateStm.setInt(col++, id);
				
				updateStm.executeUpdate();
			}
		}
		
		checkStmt.close();
		inserStm.close();
		updateStm.close();
	}
	
	public void load() throws SQLException {
		people.clear();
		
		String sql = "select * from people order by name desc";
		Statement selectStm = cnn.createStatement();
		
		ResultSet rs = selectStm.executeQuery(sql);
		
		while (rs.next()) {
			int id = rs.getInt("id");
			String name = rs.getString("name");
			String age = rs.getString("age");
			String emp = rs.getString("employment_status");
			String tax = rs.getString("tax_id");
			Boolean isVn = rs.getBoolean("vn_citizen");
			String gender = rs.getString("gender");
			String job = rs.getString("occupation");
			
			people.add(new Person(id, name, job, AgeCategory.valueOf(age), EmploymentCategory.valueOf(emp), tax, isVn, Gender.valueOf(gender)));
		}
		
		selectStm.executeQuery(sql);
		
		selectStm.close();
	}
	
	public void addPerson(Person person) {
		people.add(person);
	}
	
	public List<Person> getPeople(){
		return Collections.unmodifiableList(people) ;
	}
	
	public void saveToFile(File file) throws IOException {
		FileOutputStream fos = new FileOutputStream(file);
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		
		Person[] persons = people.toArray(new Person[people.size()]);
		
		oos.writeObject(persons);
		
		oos.close();
	}
	
	public void loadFromFile (File file) throws IOException{
		FileInputStream fis = new FileInputStream(file);
		ObjectInputStream ois = new ObjectInputStream(fis);
		
		try {
			Person[] persons = (Person[]) ois.readObject();
			
			people.clear();
			people.addAll(Arrays.asList(persons));
		} catch (Exception e) {
			// TODO: handle exception
		}
		ois.close();
	}
	
	public void removePerson(int index) {
		people.remove(index);
	}
}
