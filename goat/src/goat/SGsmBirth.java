package goat;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class SGsmBirth {
	
	ShowGoat SG;
	Control cc;
	String firstlactation;
	
	public SGsmBirth(ShowGoat SG, Control cc) {
		this.SG = SG;
		this.cc = cc;
	}

	
	public void birthDisplay() {
		
		//////////////////////////////
		//Setup the birth tab
		//////////////////////////////

		JPanel birthPanel = new JPanel();
		birthPanel.setLayout(null);
		birthPanel.setBackground(SG.customColor);
		SG.smjtp.addTab("Birth Information", birthPanel);


		JLabel birthLabel = new JLabel("Birthdate: ",SwingConstants.RIGHT);
		birthLabel.setBounds(10, 20, 100, 20);
		birthPanel.add(birthLabel);
		
		JTextField birthField = new JTextField();
		birthField.setBounds(115, 20, 100, 20);
		birthField.setColumns(10);
		birthField.setText(SG.SGdata.getBirthdate());
		birthField.setEditable(false);
		birthPanel.add(birthField);
		
		


		JLabel birthFormatLabel = new JLabel("mm/dd/yyyy",SwingConstants.RIGHT);
		birthFormatLabel.setBounds(185, 20, 100, 20);
		birthPanel.add(birthFormatLabel);
		
		JCheckBox firstlactationCB = new JCheckBox("Doe's first lactation");
		firstlactationCB.setBounds(320, 20, 150, 20);
		firstlactation = SG.SGdata.getFirstlactation();
		
		if (firstlactation.equals("yes")) {
			firstlactationCB.setSelected(true);
		}else {
			firstlactationCB.setSelected(false);
		}
		firstlactationCB.setEnabled(false);
		birthPanel.add(firstlactationCB);
		
		JLabel bWeightLabel = new JLabel("Birth Weight: ",SwingConstants.RIGHT);
		bWeightLabel.setBounds(470, 20, 100, 20);
		birthPanel.add(bWeightLabel);
		
		JTextField bWeightField = new JTextField();
		bWeightField.setBounds(570, 20, 50, 20);
		bWeightField.setColumns(4);
		bWeightField.setText(SG.SGdata.getBirthweight());
		bWeightField.setEditable(false);
		birthPanel.add(bWeightField);
		
		
		//Birth Rank
		JLabel bRankLabel = new JLabel("Birth Rank: ",SwingConstants.RIGHT);
		bRankLabel.setBounds(625, 20, 100, 20);
		birthPanel.add(bRankLabel);
			
		JTextField bRankField = new JTextField();
		bRankField.setBounds(725, 20, 200, 20);
		bRankField.setText(SG.SGdata.getBirthrank());
		birthPanel.add(bRankField);
		bRankField.setEditable(false);
		
		String[] bRankStrings = {"","Single", "Twin", "Triplet", "Quadruplet", "Quintuplet"};
		JComboBox<String> bRankBox = new JComboBox<String>(bRankStrings);;
		bRankBox.setBounds(725, 20, 200, 20);
		bRankBox.setSelectedItem(SG.SGdata.getBirthrank());
		bRankBox.setVisible(false);
		birthPanel.add(bRankBox);
		
		
		JLabel bnotesLabel = new JLabel("Birth Notes: ",SwingConstants.RIGHT);
		bnotesLabel.setBounds(0, 60, 100, 20);
		birthPanel.add(bnotesLabel);
			
		JTextArea bnotesField = new JTextArea();
		bnotesField.setLineWrap(true);
		bnotesField.setWrapStyleWord(true);
		bnotesField.setBounds(115, 60, 700, 50);
		bnotesField.setText(SG.SGdata.getBirthnotes());
		bnotesField.setEditable(false);
		birthPanel.add(bnotesField);
		
		//Add edit/save button to tab
		JButton btnEditSave = new JButton("edit");
		btnEditSave.setBounds(845, 60, 80, 20);
		birthPanel.add(btnEditSave);
		
		//Add cancel button to tab
		JButton btnCancel = new JButton("cancel");
		btnCancel.setBounds(845, 90, 80, 20);
		birthPanel.add(btnCancel);
		btnCancel.setVisible(false);

//TODO Code could be reduced here.  Not a high priority.		
		
		btnEditSave.addActionListener(new ActionListener() {
	          public void actionPerformed(ActionEvent e) {
	        	  if (btnEditSave.getText().equals("edit")) {
	        		  btnEditSave.setText("Save");
	        		  btnCancel.setVisible(true);
	        		  birthField.setEditable(true);
	        		  firstlactationCB.setEnabled(true);
	        		  bWeightField.setEditable(true);
	        		  bRankBox.setVisible(true);
	        		  bRankField.setVisible(false);
	        		  bnotesField.setEditable(true);
	        	  } else {
	        		  btnEditSave.setText("edit");
	        		  btnCancel.setVisible(false);
	        		  birthField.setEditable(false);
	        		  firstlactationCB.setEnabled(false);
	        		  bWeightField.setEditable(false);
	        		  bRankBox.setVisible(false);
	        		  bRankField.setVisible(true);
	        		  bnotesField.setEditable(false);
	        		  String myinsert;
	        		  if (firstlactationCB.isSelected()) {
	        			  firstlactation = "yes";
	        		  } else {
	        			  firstlactation = "no";
	        		  }
	        		  
//TODO Verify Birth date is correct format
	        		 

        		  
	        		  //Data Checking
	        		  bnotesField.setText(bnotesField.getText().replace("'", ""));
	        		  bnotesField.setText(bnotesField.getText().replace("\"", ""));
	        		  
	        		  
	        		  
	        		  myinsert = "UPDATE Goat.Herd SET ";
	        		  myinsert = myinsert +  "BIRTHDATE ='" + birthField.getText().trim() + "', ";
	        		  myinsert = myinsert +  "FIRSTLACTATION = '" + firstlactation + "', ";
	        		  myinsert = myinsert +  "BIRTHWEIGHT ='" + bWeightField.getText().trim() + "', ";
	        		  myinsert = myinsert +  "BIRTHRANK ='" + bRankBox.getSelectedItem() + "', ";
	        		  myinsert = myinsert +  "BIRTHNOTES ='" + bnotesField.getText().trim() + "'";		
	        		  myinsert = myinsert +  " WHERE ID= "  + SG.SGdata.getId();
	        					
	        		  SG.SGquery.updateGoat(myinsert);
//FIXME Edit does not update display after save.  Reverts back to original values.  Does update db though.	        		  
	        		  
	        	  }
	        	}
	       });
		
		btnCancel.addActionListener(new ActionListener() {
	          public void actionPerformed(ActionEvent e) {
	        	 	  btnEditSave.setText("edit");
	        		  btnCancel.setVisible(false);
	        		  birthField.setEditable(true);
	        		  firstlactationCB.setEnabled(false);
	        		  bWeightField.setEditable(true);
	        		  bRankBox.setVisible(false);
	        		  bRankField.setVisible(true);
	        		  bnotesField.setEditable(true);
	        		  birthField.setText(SG.SGdata.getBirthdate());
	        		  firstlactation = SG.SGdata.getFirstlactation();
	        		  if (firstlactation.equals("yes")) {
	        			  firstlactationCB.setSelected(true);
	        		  }else {
	        			  firstlactationCB.setSelected(false);
	        		  }
	        		  bWeightField.setText(SG.SGdata.getBirthweight());
	        		  bRankBox.setSelectedItem(SG.SGdata.getBirthrank());
	        		  bRankField.setText(SG.SGdata.getBirthrank());
	        		  bnotesField.setText(SG.SGdata.getBirthnotes());
	        		  
	        		  
	        		  
	        	  }
	       });
		
		
		
	}
	
	
	
	
	
}
