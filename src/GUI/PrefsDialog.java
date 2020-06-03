package GUI;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;

public class PrefsDialog extends JDialog {
	private JButton okBtn;
	private JButton cancelBtn;
	private JSpinner portSpinner;
	private SpinnerNumberModel spinnerModel;
	
	public PrefsDialog(JFrame frame) {
		super(frame, "Preferences", false);
		
		okBtn = new JButton("OK");
		cancelBtn = new JButton("Cancel");
		
		spinnerModel = new SpinnerNumberModel(3306,0,9999,1);
		portSpinner = new JSpinner(spinnerModel);
		
		setLayout(new GridBagLayout());
		
		GridBagConstraints gc = new GridBagConstraints();
		
		gc.gridy = 0;
//		gc.weightx = 1;
		gc.weighty = 0.5;
		gc.fill = GridBagConstraints.NONE;
		
		gc.gridx = 0;
		gc.anchor = GridBagConstraints.LAST_LINE_END;
		gc.insets = new Insets(0, 0, 15, 15);
		add(new JLabel("Port: "), gc);
		
		
		gc.gridx++;
		gc.anchor = GridBagConstraints.LAST_LINE_START;
		add(portSpinner, gc);
		
		
		//////////// NEXT ROW /////////////////
		gc.weighty = 0.5;
		gc.gridy++;
		gc.gridx = 0;
		gc.anchor = GridBagConstraints.FIRST_LINE_START;
		add(okBtn,gc);
		
		gc.gridx++;
		gc.anchor = GridBagConstraints.FIRST_LINE_START;
		add(cancelBtn, gc);
		
		okBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Integer value = (Integer) portSpinner.getValue();
				System.out.println(value);
				setVisible(false);
			}
		});
		
		cancelBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		
		setSize(250, 200);
		setLocationRelativeTo(frame);
	}
}
