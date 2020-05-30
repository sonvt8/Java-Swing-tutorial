package GUI;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import Model.Person;

public class PersonTableModel extends AbstractTableModel {
	
	private List<Person> db;
	private String[] colNames = {"Id", "Name", "Occupation", "Age Category", "Employment Category", "VN Citizens", "TaxId"};
	
	public PersonTableModel() {}
	
	public void setData(List<Person> db) {
		this.db = db;
	}
	
	

	@Override
	public String getColumnName(int column) {
		// TODO Auto-generated method stub
		return colNames[column];
	}

	@Override
	public int getRowCount() {
		return db.size();
	}

	@Override
	public int getColumnCount() {
		return 7;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		Person person = db.get(rowIndex);
		
		switch (columnIndex) {
		case 0: {
			return person.getId();
		}
		case 1: {
			return person.getName();
		}
		case 2: {
			return person.getOccupation();
		}
		case 3: {
			return person.getAgeCategory();
		}
		case 4: {
			return person.getEmpCat();
		}
		case 5: {
			return person.isVnCitizen();
		}
		case 6: {
			return person.getTaxID();
		}
		default:
			throw new IllegalArgumentException("Unexpected value: " + columnIndex);
		}
	}

}
