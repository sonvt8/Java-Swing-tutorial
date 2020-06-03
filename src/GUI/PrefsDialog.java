package GUI;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.print.attribute.standard.PresentationDirection;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;

public class PrefsDialog extends JDialog {
	private JButton okBtn;
	private JButton cancelBtn;
	private JSpinner portSpinner;
	private SpinnerNumberModel spinnerModel;
	private JTextField userField;
	private JPasswordField passField;
	private PrefsListener prefsListener;
	
	public PrefsDialog(JFrame frame) {
		super(frame, "Preferences", false);
		
		okBtn = new JButton("OK");
		cancelBtn = new JButton("Cancel");
		
		spinnerModel = new SpinnerNumberModel(3306,0,9999,1);
		portSpinner = new JSpinner(spinnerModel);
		
		userField = new JTextField(20);
		passField = new JPasswordField(20);
		
		passField.setEchoChar('*');
		
		setLayout(new GridBagLayout());
		
		GridBagConstraints gc = new GridBagConstraints();
		
		////////////FIRST ROW /////////////////
		gc.gridy = 0;
		gc.weighty = 0.5;
		gc.fill = GridBagConstraints.NONE;
		
		gc.gridx = 0;
		gc.anchor = GridBagConstraints.LAST_LINE_END;
		gc.insets = new Insets(0, 0, 15, 15);
		add(new JLabel("User: "), gc);
		
		
		gc.gridx++;
		gc.anchor = GridBagConstraints.LAST_LINE_START;
		add(userField, gc);
		
		////////////NEXT ROW /////////////////
		gc.gridy++;
		gc.gridx = 0;
		gc.anchor = GridBagConstraints.LINE_END;
		add(new JLabel("Password: "), gc);
		
		gc.gridx++;
		gc.anchor = GridBagConstraints.LINE_START;
		add(passField, gc);
		
		////////////NEXT ROW /////////////////
		gc.gridy++;
		gc.gridx = 0;
		gc.anchor = GridBagConstraints.FIRST_LINE_END;
		add(new JLabel("Port: "), gc);
		
		gc.gridx++;
		gc.anchor = GridBagConstraints.FIRST_LINE_START;
		add(portSpinner, gc);
		
		
		//////////// NEXT ROW /////////////////
		gc.weighty = 2;
		gc.gridy++;
		gc.gridx = 0;
		gc.anchor = GridBagConstraints.FIRST_LINE_END;
		add(okBtn,gc);
		
		gc.gridx++;
		gc.anchor = GridBagConstraints.FIRST_LINE_START;
		add(cancelBtn, gc);
		
		okBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Integer port = (Integer) portSpinner.getValue();
				String user = userField.getText();
				char[] pass = passField.getPassword();
				
				if(prefsListener != null) {
					prefsListener.preferencesSet(user, new String(pass), port);
				}
				
				setVisible(false);
			}
		});
		
		cancelBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		
		setSize(350, 250);
		setLocationRelativeTo(frame);
	}
	
	public void setDefaults (String user, String pass, int port) {
		userField.setText(user);
		passField.setText(pass);
		portSpinner.setValue(port);
	}
	
	public void setPrefsListener(PrefsListener prefsListener) {
		this.prefsListener = prefsListener;
	}
}
