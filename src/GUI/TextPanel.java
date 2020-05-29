package GUI;
import java.awt.BorderLayout;

import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class TextPanel extends JPanel {
	private JTextArea txtArea;
	
	public TextPanel() {
		txtArea = new JTextArea();
		
		setLayout(new BorderLayout());
		
//		Add TextArea with Scrollbar
		add(new JScrollPane(txtArea), BorderLayout.CENTER);
	}
	
	public void appendText(String txt) {
		txtArea.append(txt);
	}
}
