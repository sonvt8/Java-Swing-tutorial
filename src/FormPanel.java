import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;

public class FormPanel extends JPanel{
	
	private JLabel nameLabel;
	private JLabel occupationLabel;
	private JTextField nameField;
	private JTextField occupationField;
	private JButton okBtn;
	private FormListener formListener;
	
	public FormPanel() {
		Dimension dim = getPreferredSize();
		dim.width = 250;
		setPreferredSize(dim);
		
		nameLabel = new JLabel("Name: ");
		occupationLabel = new JLabel("Occupation: ");
		nameField = new JTextField(10);
		occupationField = new JTextField(10);
		okBtn = new JButton("Submit");
		
		okBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name = nameField.getText();
				String occupation = occupationField.getText();
				
				var ev = new FormEvent(this, name, occupation);
				
				if(formListener != null) {
					formListener.formEventOccured(ev);
				}
			}
		});
		
		Border innerBorder = BorderFactory.createTitledBorder("Add Person");
		Border outerBorder = BorderFactory.createEmptyBorder(5,5,5,5);
		setBorder(BorderFactory.createCompoundBorder(outerBorder,innerBorder));
		
		setLayout(new GridBagLayout());
		
		GridBagConstraints gc = new GridBagConstraints();
		
//		This form just have one column, therefore we just use weighty to allocate the space between each components
		
		/////////////// FIRST ROW ///////////////////
		gc.weighty = 0.1; // assign at least small additional space between each component on Vertical
		
		gc.gridx = 0;
		gc.gridy = 0;
		gc.anchor = GridBagConstraints.LINE_END;
		gc.insets = new Insets(0, 0, 0, 5);
		add(nameLabel,gc);
		
		gc.gridx = 1;
		gc.gridy = 0;
		gc.anchor = GridBagConstraints.LINE_START;
		add(nameField, gc);
		
		/////////////// SECOND ROW ///////////////////
		gc.gridy = 1;
		gc.gridx = 0;
		gc.anchor = GridBagConstraints.LINE_END;
		gc.insets = new Insets(0, 0, 0, 5);
		add(occupationLabel,gc);
		
		gc.gridy = 1;
		gc.gridx = 1;
		gc.anchor = GridBagConstraints.LINE_START;
		add(occupationField,gc);
		
		/////////////// THIRD ROW ///////////////////
		gc.weighty = 2; //all additional space below will be distributed to this component on Vertical
		
		gc.gridy = 2;
		gc.gridx = 1;
		gc.anchor = GridBagConstraints.FIRST_LINE_START;
		add(okBtn,gc);
		
//		End of Edit Form
	}
	
	public void setFormListener (FormListener listener) {
		this.formListener = listener;
	}
}
