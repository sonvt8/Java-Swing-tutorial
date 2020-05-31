package GUI;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import Model.Person;

public class TablePanel extends JPanel {
	
	private JTable table;
	private PersonTableModel tableModel;
	private JPopupMenu popup;
	private PersonTableListener personTableListen;
	
	public TablePanel() {
		tableModel = new PersonTableModel();
		table = new JTable(tableModel);
		popup = new JPopupMenu();
		
		JMenuItem removeItem = new JMenuItem("Delete Row");
		popup.add(removeItem);
		
		table.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				int row = table.rowAtPoint(e.getPoint());
				table.getSelectionModel().setSelectionInterval(row, row);
				
				if(e.getButton() == MouseEvent.BUTTON3) {
					//When right click on the row of table, the pop up will be showed up
					popup.show(table, e.getX(), e.getY());
				}
			}
			
		});
		
		removeItem.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				int row = table.getSelectedRow(); //Start from 0
				if(personTableListen != null) {
					personTableListen.rowDeleted(row);
					tableModel.fireTableRowsDeleted(row, row);
				}
				
			}
		});
		
		setLayout(new BorderLayout());
		
		add(new JScrollPane(table),BorderLayout.CENTER);
	}
	
	public void setData(List<Person> db) {
		tableModel.setData(db);
	}
	
	public void refresh() {
		tableModel.fireTableDataChanged();
	}
	
	public void setPersonTableListener(PersonTableListener listener) {
		this.personTableListen = listener;
	}
}
