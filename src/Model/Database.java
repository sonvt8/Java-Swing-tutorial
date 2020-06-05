package Model;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import javax.imageio.stream.FileImageInputStream;

public class Database {
	private LinkedList<Person> people;
	
	private Connection con;
	
	public Database() {
		people = new LinkedList<Person>();
	}
	
	public void connect() {
		String strConn = "jdbc:sqlserver://DESKTOP-HEPHQND\\SQLEXPRESS:1433; databaseName=C1903LBUOI7; user=sa; password=abc123@@@;";
		

		try (
				Connection cnn = DriverManager.getConnection(strConn);
				Statement stmt = cnn.createStatement();
			)
		{
			System.out.println("Success");
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
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
