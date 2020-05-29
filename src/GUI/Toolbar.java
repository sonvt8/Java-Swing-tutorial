package GUI;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;

public class Toolbar extends JPanel implements ActionListener{
	private JButton helloButton;
	private JButton goodbyeButton;
	private StringListener txtListener;
	
	public Toolbar() {
		setBorder(BorderFactory.createEtchedBorder());
		
		helloButton 	= new JButton("Hello");
		goodbyeButton 	= new JButton("Goodbye");
		
		helloButton.addActionListener(this);
		
		goodbyeButton.addActionListener(this);
		
		setLayout(new FlowLayout(FlowLayout.LEFT));
		
		add(helloButton);
		add(goodbyeButton);
	}
	
	public void setStringListener (StringListener txtListener){
		this.txtListener = txtListener;
	}
	
	public void actionPerformed(ActionEvent e) {
		var clicked = e.getSource();
		
		if(clicked == helloButton) {
			if(txtListener != null) {
				txtListener.textEmmited("Hello\n");
			}
		}else {
			if(txtListener != null) {
				txtListener.textEmmited("Goodbye\n");
			}
		}
	}
}
