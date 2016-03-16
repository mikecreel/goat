package goat;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class MainMenu {
	
Control cc;
	
	public MainMenu(Control cc){
		this.cc = cc;
	}
	
	public void Start() {
		
		/**
	     *  Create Menu
	     */
	      
	    // Create Menu Bar
	    JMenuBar menuBar = new JMenuBar();
	      
	    //Create 1st Menu
	    JMenu menuFile = new JMenu("File");
	    
	      
	    //Create Items on 1st Menu
	    JMenuItem menuItemExit = new JMenuItem("Exit");
	    JMenuItem menuItemTest = new JMenuItem("Test");
	    //Create Action Listener for Menu Item Test
	    menuItemTest.addActionListener(new ActionListener(){

	        @Override
	        public void actionPerformed(ActionEvent ae) {
	      	  cc.myTree.updateTree("MIKE Creel");
	        }
	    });
	    
	    
	    
	    //Create Action Listener for Menu Item Exit
	    menuItemExit.addActionListener(new ActionListener(){

	        @Override
	        public void actionPerformed(ActionEvent ae) {
	      	  System.exit(0);
	        }
	    });
	      
	    menuFile.add(menuItemExit);
	    menuFile.add(menuItemTest);
	    menuBar.add(menuFile);
	    cc.mydb.mainFrame.setJMenuBar(menuBar);
		
	}

}
