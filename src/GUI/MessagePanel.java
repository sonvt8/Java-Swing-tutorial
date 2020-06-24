package GUI;

import java.awt.BorderLayout;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;

public class MessagePanel extends JPanel {
	private JTree serverTree;
	
	public MessagePanel() {
		serverTree = new JTree(creatTree());
		
		setLayout(new BorderLayout());
		
		add(new JScrollPane(serverTree), BorderLayout.CENTER);
	}
	
	private DefaultMutableTreeNode creatTree() {
		DefaultMutableTreeNode top = new DefaultMutableTreeNode("Servers");
		
		DefaultMutableTreeNode branch1 = new DefaultMutableTreeNode("Dosmetic");
		DefaultMutableTreeNode server1 = new DefaultMutableTreeNode("Ho Chi Minh");
		DefaultMutableTreeNode server2 = new DefaultMutableTreeNode("Ha Noi");
		branch1.add(server1);
		branch1.add(server2);
		
		DefaultMutableTreeNode branch2 = new DefaultMutableTreeNode("International");
		DefaultMutableTreeNode server3 = new DefaultMutableTreeNode("USA");
		DefaultMutableTreeNode server4 = new DefaultMutableTreeNode("UK");
		branch2.add(server3);
		branch2.add(server4);
		
		top.add(branch1);
		top.add(branch2);
		
		return top;
	}
}
