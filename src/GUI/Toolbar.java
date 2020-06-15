package GUI;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
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
		saveButton.setIcon(createIcon("/images/save.png"));
		
		refreshButton.addActionListener(this);
		refreshButton.setIcon(createIcon("/images/refresh.png"));
		
		setLayout(new FlowLayout(FlowLayout.LEFT));
		
		add(saveButton);
		add(refreshButton);
	}
	
	private ImageIcon createIcon(String path) {
		URL url = getClass().getResource(path);
		
		if(url == null) {
			System.err.println("Unable to load image: " + path);
		}
		ImageIcon icon = new ImageIcon(url);
		return icon;
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
	
	public void setToolbarListener (ToolbarListener txtListener){
		this.txtListener = txtListener;
	}
}
