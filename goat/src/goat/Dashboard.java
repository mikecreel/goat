package goat;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;



public class Dashboard {
	//GoatTree myTree;
	JFrame mainFrame;
	JPanel column1;
	JPanel column2;
	JTabbedPane jtp;
	
	public Dashboard (Control cc) {
		mainFrame = new JFrame("Goat Herd Management");
	    mainFrame.setSize(1400,800);
	    mainFrame.getContentPane().setLayout(null);
	    mainFrame.addWindowListener(new WindowAdapter() {
	    	public void windowClosing(WindowEvent windowEvent){
	            System.exit(0);
	        }        
	      }); 
	    
	    /**
	     *  Dashboard divided into 2 main panels column1 & column2
	     *  D
	     */
	   
	    column1=new JPanel();
	    column1.setLayout(null);
	    column1.setBounds(0, 0, 400, 700);
	    column1.setBackground(Color.WHITE);
	    
	    column2=new JPanel();
	    column2.setBounds(400, 0, 1000, 700);
	    column2.setLayout(new GridLayout(1,1));
	    
	    // Fill Main Screen 
	    mainFrame.getContentPane().add(column1);
	  	mainFrame.getContentPane().add(column2);
		
		// Create tabbed pane in column2
	  	jtp = new JTabbedPane();
	  	column2.add(jtp);
         
	   //  Set Dashboard as visible
	    
	    mainFrame.setVisible(true);
	}
	
	
	
}
