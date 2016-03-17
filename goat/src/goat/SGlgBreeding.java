package goat;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

public class SGlgBreeding {
	
	ShowGoat SG;
	Control cc;

	public SGlgBreeding(ShowGoat SG, Control cc) {
		this.SG = SG;
		this.cc = cc;
	}

	public void displayBreeding() {
		
		//Breeding Panel
		
		JPanel breedingPanel = new JPanel();
		breedingPanel.setLayout(null);
		breedingPanel.setBackground(SG.customColor);
		SG.lgjtp.addTab("Breeding", breedingPanel);
		
		
		//Breeding Date//

		JTextField breedingdateField = new JTextField();
		breedingdateField.setBounds(10, 20, 100, 20);
		breedingdateField.setColumns(10);
		breedingPanel.add(breedingdateField);
		
		JLabel breedingdateFormatLabel = new JLabel("mm/dd/yyyy",SwingConstants.RIGHT);
		breedingdateFormatLabel.setBounds(10, 40, 80, 20);
		breedingPanel.add(breedingdateFormatLabel);
		
		//Buck
		
		JLabel buckLabel = new JLabel("Buck: ",SwingConstants.RIGHT);
		buckLabel.setBounds(125, 20, 75, 20);
		breedingPanel.add(buckLabel);
		
		String[] buckStrings = cc.myQuery.getnames("SELECT name From GOAT.HERD WHERE HERDGROUP = 'Bucks'");
		JComboBox<String> buckBox = new JComboBox<String>(buckStrings);;
		buckBox.setBounds(205, 20, 300, 20);
		breedingPanel.add(buckBox);
		
		//Note
		
		JLabel breedingnoteLabel = new JLabel("Note: ",SwingConstants.RIGHT);
		breedingnoteLabel.setBounds(500, 20, 75, 20);
		breedingPanel.add(breedingnoteLabel);
		
		JTextField breedingnoteField = new JTextField();
		breedingnoteField.setBounds(575, 20, 300, 20);
		breedingPanel.add(breedingnoteField);
		
		JButton saveButton = new JButton("Save");
		saveButton.setBounds(890, 20, 70, 20);
		breedingPanel.add(saveButton);
		

		//Action Listers for SAVE Note Buttons
		saveButton.addActionListener(new ActionListener() {
	    	  public void actionPerformed(ActionEvent e) {
	    		  
	    		  //Kidding Date Calculation
	    		  String estkiddingdate = null;
	    		  
	    		  // Format dates
	    		  DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyy", Locale.ENGLISH);
	    		  
	    		  //Parse variables
	    		  try {
	    			  estkiddingdate = LocalDate.parse(breedingdateField.getText(), formatter).plusDays(155).toString();
	    		  } catch (Exception e1) {
	    			  estkiddingdate = "";
	    		  }
	    		  
	    		  //Data Checking
	    		  
	    		  breedingnoteField.setText(breedingnoteField.getText().replace("'", ""));
	    		  breedingnoteField.setText(breedingnoteField.getText().replace("\"", ""));
	    		  
	    		  String myinsert = new String();
	    		  myinsert = "INSERT INTO GOAT.BREEDING (ID, BDATE, BUCKNAME, ESTKIDDATE, NOTE)";
	    		  myinsert = myinsert + "VALUES (";
	    		  myinsert = myinsert + SG.SGdata.getId() + ", '";
	    		  myinsert = myinsert + breedingdateField.getText().trim() + "', '";
	    		  myinsert = myinsert + buckBox.getSelectedItem() + "', '";
	    		  myinsert = myinsert + estkiddingdate + "', '";
	    		  myinsert = myinsert + breedingnoteField.getText().trim() + "')";
	
	    		  SG.SGquery.updateGoat(myinsert);
	    		  
	    		  //Add latest breeding to table.
	    		  
	    		  for (int x = 0; x < 100; x=x+1){
	    			  if (SG.breedingtable.getValueAt(x, 0) == null) {
	    				  SG.breedingtable.setValueAt(breedingdateField.getText().trim(),x,0);
	    				  SG.breedingtable.setValueAt(buckBox.getSelectedItem(),x,1);
	    				  SG.breedingtable.setValueAt(breedingnoteField.getText(),x,2);
	    				  SG.breedingtable.setValueAt(estkiddingdate,x,3);
	    				  x=100;
	    			  }
	    		  }
	    		  breedingdateField.setText("");
	    		  buckBox.setSelectedIndex(0);
	     		  breedingnoteField.setText("");
	    	  }
	      });
		
		String[] col = {"Date", "Stud", "Note", "Est Kidding Date"};
		
		DefaultTableModel model;
		model = new DefaultTableModel(col,100);
		
		SG.breedingtable=new JTable(model){ 
			private static final long serialVersionUID = 1L; 
			@Override public boolean isCellEditable(int arg0, int arg1) { return false; }};
	    
		TableColumnModel columnModel = SG.breedingtable.getColumnModel();
	    columnModel.getColumn(0).setPreferredWidth(80);
	    columnModel.getColumn(1).setPreferredWidth(250);
	    columnModel.getColumn(2).setPreferredWidth(500);
	    columnModel.getColumn(3).setPreferredWidth(80);
	    
	    String [][] breedingarray = SG.SGquery.getbreeding("SELECT bdate, id, buckname, estkiddate, note From GOAT.BREEDING WHERE ID = " + SG.SGdata.getId(), true);
		for (int x = 0; x < 100; x=x+1){
			SG.breedingtable.setValueAt(breedingarray[x][0],x,0);
			SG.breedingtable.setValueAt(breedingarray[x][1],x,1);
			SG.breedingtable.setValueAt(breedingarray[x][2],x,2);
			SG.breedingtable.setValueAt(breedingarray[x][3],x,3);
		}
		
		JScrollPane scrollpane = new JScrollPane(SG.breedingtable);
	    scrollpane.setBounds(10, 80, 960, 300);
	    breedingPanel.add(scrollpane);
		
	}

}
