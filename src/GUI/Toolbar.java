package GUI;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;

public class Toolbar extends JPanel implements ActionListener{
	private JButton saveButton;
	private JButton refreshButton;
	private ToolbarListener txtListener;
	
	public Toolbar() {
		setBorder(BorderFactory.createEtchedBorder());
		
		saveButton 	= new JButton("Save");
		refreshButton 	= new JButton("Refresh");
		
		saveButton.addActionListener(this);
		
		refreshButton.addActionListener(this);
		
		setLayout(new FlowLayout(FlowLayout.LEFT));
		
		add(saveButton);
		add(refreshButton);
	}
	
	public void setToolbarListener (ToolbarListener txtListener){
		this.txtListener = txtListener;
	}
	
	public void actionPerformed(ActionEvent e) {
		var clicked = e.getSource();
		
		if(clicked == saveButton) {
			if(txtListener != null) {
				txtListener.saveEventOccured();
			}
		}else if (clicked == refreshButton){
			if(txtListener != null) {
				txtListener.refreshEventOccured();
			}
		}
	}
}
