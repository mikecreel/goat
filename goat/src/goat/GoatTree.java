package goat;



import javax.swing.JScrollPane;
import javax.swing.JTree;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreeSelectionModel;

public class GoatTree {
	Control cc;
	DefaultMutableTreeNode root;
	DefaultTreeModel treeModel;
	JTree tree;
	JScrollPane jsp;
	
	public GoatTree(Control cc){
		this.cc = cc;
		
	}
	
	public void Start() {
		/**
	     * Create JTree with data
	     */
	    
        //create the root node
        root = new DefaultMutableTreeNode("Goats");
        treeModel = new DefaultTreeModel(root);
        
        //create the child nodes
       
        String[] bucks = cc.myQuery.getnames("SELECT * From GOAT.HERD WHERE HERDGROUP = 'Bucks' AND OWNED = 'yes' AND DEATH = 'no' AND SOLD = 'no'");
        DefaultMutableTreeNode buckNode = new DefaultMutableTreeNode("Bucks (" + Integer.toString(bucks.length-1) +")" );
        for (String element: bucks) {
        	if (!element.isEmpty()) {
        		buckNode.add(new DefaultMutableTreeNode(element));
        	}
         }
        
        String[] does = cc.myQuery.getnames("SELECT * From GOAT.HERD WHERE HERDGROUP = 'Does' AND OWNED = 'yes' AND DEATH = 'no' AND SOLD = 'no'");
        DefaultMutableTreeNode doeNode = new DefaultMutableTreeNode("Does (" + Integer.toString(does.length-1) +")" );
        for (String element: does) {
        	if (!element.isEmpty()) {
        		doeNode.add(new DefaultMutableTreeNode(element));
        	}
         }

        String[] doeling = cc.myQuery.getnames("SELECT * From GOAT.HERD WHERE HERDGROUP = 'Doeling' AND OWNED = 'yes' AND DEATH = 'no' AND SOLD = 'no'");
        DefaultMutableTreeNode doelingNode = new DefaultMutableTreeNode("Doeling (" + Integer.toString(doeling.length-1) +")" );
        for (String element: doeling) {
        	if (!element.isEmpty()) {
        		doelingNode.add(new DefaultMutableTreeNode(element));
        	}
         }
        
        String[] buckling = cc.myQuery.getnames("SELECT * From GOAT.HERD WHERE HERDGROUP = 'Buckling' AND OWNED = 'yes' AND DEATH = 'no' AND SOLD = 'no'");
        DefaultMutableTreeNode bucklingNode = new DefaultMutableTreeNode("Buckling (" + Integer.toString(buckling.length-1) +")" );
        for (String element: buckling) {
        	if (!element.isEmpty()) {
        		bucklingNode.add(new DefaultMutableTreeNode(element));
        	}
         }
        
        String[] sold = cc.myQuery.getnames("SELECT * From GOAT.HERD WHERE SOLD = 'yes'");
        DefaultMutableTreeNode soldNode = new DefaultMutableTreeNode("Sold (" + Integer.toString(sold.length-1) +")" );
        for (String element: sold) {
        	if (!element.isEmpty()) {
        		soldNode.add(new DefaultMutableTreeNode(element));
        	}
         }
        
        String[] deceased = cc.myQuery.getnames("SELECT * From GOAT.HERD WHERE DEATH = 'yes'");
        DefaultMutableTreeNode deceasedNode = new DefaultMutableTreeNode("Deceased (" + Integer.toString(deceased.length-1) +")" );
        for (String element: deceased) {
        	if (!element.isEmpty()) {
        		deceasedNode.add(new DefaultMutableTreeNode(element));
        	}
         }
         
        //add the child nodes to the root node
        root.add(buckNode);
        root.add(doeNode);
        root.add(doelingNode);
        root.add(bucklingNode);
        root.add(soldNode);
        root.add(deceasedNode);
        
        
         
        //create the tree by passing in the root node
        tree = new JTree(root);
        tree.getSelectionModel().setSelectionMode(TreeSelectionModel.SINGLE_TREE_SELECTION);
        tree.addTreeSelectionListener(new SelectionListener());
        jsp = new JScrollPane(tree);
        jsp.setBounds(0,0,400,700);
        cc.mydb.column1.add(jsp);
        tree.collapsePath(tree.getPathForRow(0));
        tree.expandRow(0);
	}
	

	class SelectionListener implements TreeSelectionListener {

		  public void valueChanged(TreeSelectionEvent se) {
		    JTree tree = (JTree) se.getSource();
		    DefaultMutableTreeNode selectedNode = (DefaultMutableTreeNode) tree
		        .getLastSelectedPathComponent();
//FIXME Getting an error here after first selection.  Program runs without issue though
		    String selectedNodeName = selectedNode.toString();
		    if (selectedNode.isLeaf()) {

		      ShowGoat thegoat = new ShowGoat(cc,selectedNodeName);
		      thegoat.Start();
//TODO Make the new tab has focus.  See How I did it in DSR like PastDSR		      

		    }
		  }
		}
	
	
	public void updateTree(String goat) {  //This is something from test on mainmenu looks like it was a work in progress
		cc.mydb.column1.remove(tree);
		cc.myTree.Start();
//		treeModel.insertNodeInto(new DefaultMutableTreeNode(goat), buckNode, buckNode.getChildCount());
//		treeModel.reload(root);
	}

}
