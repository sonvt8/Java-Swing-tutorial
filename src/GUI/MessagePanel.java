package GUI;

import java.awt.BorderLayout;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTree;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeCellRenderer;
import javax.swing.tree.TreeSelectionModel;

class ServerInfo {
	private String name;
	private int id;
	
	public ServerInfo(String name, int id) {
		this.name = name;
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return name;
	}
	
}

public class MessagePanel extends JPanel {
	private JTree serverTree;
	private DefaultTreeCellRenderer treeCellRenderer;
	
	public MessagePanel() {
		treeCellRenderer = new DefaultTreeCellRenderer();
		
		treeCellRenderer.setLeafIcon(createIcon("/images/server.png"));
		treeCellRenderer.setOpenIcon(createIcon("/images/global.png"));
		treeCellRenderer.setClosedIcon(createIcon("/images/earth.png"));
		
		serverTree = new JTree(creatTree());
		serverTree.setCellRenderer(treeCellRenderer);
		
		serverTree.getSelectionModel().setSelectionMode(TreeSelectionModel.SINGLE_TREE_SELECTION);
		
		serverTree.addTreeSelectionListener(new TreeSelectionListener() {
			public void valueChanged(TreeSelectionEvent e) {
				DefaultMutableTreeNode node = (DefaultMutableTreeNode) serverTree.getLastSelectedPathComponent();
				
				Object userObject = node.getUserObject();
						
				System.out.println(userObject);
			}
		});
		
		setLayout(new BorderLayout());
		
		add(new JScrollPane(serverTree), BorderLayout.CENTER);
	}
	
	private DefaultMutableTreeNode creatTree() {
		DefaultMutableTreeNode top = new DefaultMutableTreeNode("Servers");
		
		DefaultMutableTreeNode branch1 = new DefaultMutableTreeNode("Dosmetic");
		DefaultMutableTreeNode server1 = new DefaultMutableTreeNode(new ServerInfo("Ho Chi Minh",0));
		DefaultMutableTreeNode server2 = new DefaultMutableTreeNode(new ServerInfo("Ha Noi",1));
		branch1.add(server1);
		branch1.add(server2);
		
		DefaultMutableTreeNode branch2 = new DefaultMutableTreeNode("International");
		DefaultMutableTreeNode server3 = new DefaultMutableTreeNode(new ServerInfo("USA",2));
		DefaultMutableTreeNode server4 = new DefaultMutableTreeNode(new ServerInfo("UK",3));
		branch2.add(server3);
		branch2.add(server4);
		
		top.add(branch1);
		top.add(branch2);
		
		return top;
	}
	
	private ImageIcon createIcon(String path) {
		URL url = getClass().getResource(path);
		
		if(url == null) {
			System.err.println("Unable to load image: " + path);
		}
		ImageIcon icon = new ImageIcon(url);
		return icon;
	}
}
