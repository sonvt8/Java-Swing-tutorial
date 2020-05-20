import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;

public class MainFrame extends JFrame{
	
	private TextPanel txtPanel;
	private JButton btn;
	
	public MainFrame() {
		super("Hello World");
		
		setLayout(new BorderLayout());
		
		txtPanel = new TextPanel();
		btn = new JButton("Click Me!");
		
		btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtPanel.appendText("Hello\n");
			}
		});
		
		add(txtPanel, BorderLayout.CENTER);
		add(btn, BorderLayout.SOUTH);
		
		setSize(600, 500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
}
