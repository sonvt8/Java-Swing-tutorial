import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

public class Toolbar extends JPanel implements ActionListener{
	private JButton helloButton;
	private JButton goodbyeButton;
	private TextPanel txtPanel;
	
	public Toolbar() {
		helloButton 	= new JButton("Hello");
		goodbyeButton 	= new JButton("Goodbye");
		
		helloButton.addActionListener(this);
		
		goodbyeButton.addActionListener(this);
		
		setLayout(new FlowLayout(FlowLayout.LEFT));
		
		add(helloButton);
		add(goodbyeButton);
	}
	
	public void setTextPanel(TextPanel txtPanel) {
		this.txtPanel = txtPanel;
	}

	public void actionPerformed(ActionEvent e) {
		var clicked = e.getSource();
		
		if(clicked == helloButton) {
			txtPanel.appendText("Hello\n");
		}else {
			txtPanel.appendText("Goodbye\n");
		}
	}
}
