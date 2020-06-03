package GUI;

import javax.swing.JDialog;
import javax.swing.JFrame;

public class PrefsDialog extends JDialog {
	public PrefsDialog(JFrame frame) {
		super(frame, "Preferences", false);
		setSize(400, 300);
	}
}
