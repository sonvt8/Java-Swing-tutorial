package GUI;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JToolBar;

public class Toolbar extends JToolBar implements ActionListener{
	private JButton saveButton;
	private JButton refreshButton;
	private ToolbarListener txtListener;
	
	public Toolbar() {
		
//		Get rid of the border if you want the toolbar draggable
		setBorder(BorderFactory.createEtchedBorder());
		
		saveButton 	= new JButton();
		refreshButton 	= new JButton();
		
		saveButton.addActionListener(this);
		saveButton.setIcon(createIcon("/images/save.png"));
		saveButton.setToolTipText("Save");
		
		refreshButton.addActionListener(this);
		refreshButton.setIcon(createIcon("/images/refresh.png"));
		refreshButton.setToolTipText("Refresh");
		
		setLayout(new FlowLayout(FlowLayout.LEFT));
		
		add(saveButton);
//		addSeparator();
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
