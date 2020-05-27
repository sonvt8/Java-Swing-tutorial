import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;

public class MainFrame extends JFrame{
	
	private TextPanel txtPanel;
	private Toolbar toolbar;
	private FormPanel formPanel;
	
	public MainFrame() {
		super("Hello World");
		
		setLayout(new BorderLayout());
		
		toolbar = new Toolbar();
		formPanel = new FormPanel();
		txtPanel = new TextPanel();
		
		toolbar.setStringListener(new StringListener() {
			@Override
			public void textEmmited(String text) {
				txtPanel.appendText(text);
			}
		});
		
		formPanel.setFormListener(new FormListener() {
			public void formEventOccured(FormEvent e) {
				String name = e.getName();
				String occupation = e.getOccupation();
				int idCategory = e.getidCategory();
				String empCat = e.getEmploymentCategory();
				
				txtPanel.appendText(name + ": " + occupation + ": " + idCategory + ": " + empCat + "\n");
			}
		});
		
		add(txtPanel, BorderLayout.CENTER);
		add(toolbar, BorderLayout.NORTH);
		add(formPanel, BorderLayout.WEST);
		
		setSize(600, 500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
}
