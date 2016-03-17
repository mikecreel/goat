package goat;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class SGdisplayHeader {
	
	ShowGoat SG;
	Control cc;
	
	
	public SGdisplayHeader(ShowGoat SG, Control cc) {
		this.SG = SG;
		this.cc = cc;
	}
	
	public void displayHeader() {

		//Add close button to tab
		JButton btnClose = new JButton("close");
	    btnClose.setBounds(910, 0, 80, 20);
		SG.jp1.add(btnClose);
		//Add edit/save button to tab
		JButton btnEditSave = new JButton("edit");
	    btnEditSave.setBounds(910, 20, 80, 20);
		SG.jp1.add(btnEditSave);
		//Add cancel button to tab
		JButton btnCancel = new JButton("cancel");
		btnCancel.setBounds(910, 40, 80, 20);
		SG.jp1.add(btnCancel);
		btnCancel.setVisible(false);
		
		btnClose.addActionListener(new ActionListener() {
	          public void actionPerformed(ActionEvent e) {
	        	  cc.mydb.jtp.remove(SG.jp1);          
	        	  }
	       });
		
		//Tag Number
	    JLabel tagLabel = new JLabel("Tag Number: ",SwingConstants.RIGHT);
		tagLabel.setBounds(10, 20, 100, 20);
		SG.jp1.add(tagLabel);
		
		JTextField tagField = new JTextField();
		tagField.setBounds(115, 20, 50, 20);
		tagField.setText(SG.SGdata.getTag());
		tagField.setColumns(20);
		tagField.setEditable(false);
		SG.jp1.add(tagField);
		
		//Name
		JLabel nameLabel = new JLabel("Name: ",SwingConstants.RIGHT);
		nameLabel.setBounds(145, 20, 100, 20);
		SG.jp1.add(nameLabel);
				
		JTextField nameField = new JTextField();
		nameField.setBounds(250, 20, 200, 20);
		nameField.setText(SG.SGdata.getName());
		SG.jp1.add(nameField);                        //TODO This needs to be moved to below the set editable on all fields
		nameField.setColumns(40);
		nameField.setEditable(false);
		
		//Gender
	    JLabel genderLabel = new JLabel("Gender: ",SwingConstants.RIGHT);
		genderLabel.setBounds(440, 20, 100, 20);
		SG.jp1.add(genderLabel);
		
		JTextField genderField = new JTextField();
		genderField.setBounds(545, 20, 50, 20);
		genderField.setText(SG.SGdata.getGender());
		SG.jp1.add(genderField);
		genderField.setColumns(20);
		genderField.setEditable(false);
		
		JRadioButton doeButton = new JRadioButton("Doe");
		doeButton.setBounds(545, 20, 50, 20);
		doeButton.setBackground(Color.LIGHT_GRAY);
		SG.jp1.add(doeButton);
		doeButton.setVisible(false);
		
		JRadioButton buckButton = new JRadioButton("Buck");
		buckButton.setBounds(590, 20, 60, 20);
		buckButton.setBackground(Color.LIGHT_GRAY);
		SG.jp1.add(buckButton);
		buckButton.setVisible(false);
		
		ButtonGroup genderGroup = new ButtonGroup();
		genderGroup.add(doeButton);
		genderGroup.add(buckButton);
		
		
		
		//Group
		
		JLabel groupLabel = new JLabel("Group: ",SwingConstants.RIGHT);
		groupLabel.setBounds(600, 20, 100, 20);
		SG.jp1.add(groupLabel);
				
		JTextField groupField = new JTextField();
		groupField.setBounds(705, 20, 200, 20);
		groupField.setText(SG.SGdata.getHerdgroup());
		SG.jp1.add(groupField);
		groupField.setEditable(false);
		
		String[] groupStrings = {"","Does", "Bucks", "Doeling", "Buckling", "Sold", "Deceased"};
		JComboBox<String> groupBox = new JComboBox<String>(groupStrings);
		groupBox.setSelectedItem(SG.SGdata.getHerdgroup());
		groupBox.setBounds(705, 20, 200, 20);
		SG.jp1.add(groupBox);
		groupBox.setVisible(false);
		
		//Birth date
		JLabel birthLabel = new JLabel("Birthdate: ",SwingConstants.RIGHT);
		birthLabel.setBounds(10, 50, 100, 20);
		SG.jp1.add(birthLabel);
				
		JTextField birthField = new JTextField();
		birthField.setBounds(115, 50, 100, 20);
		birthField.setText(SG.SGdata.getBirthdate());
		SG.jp1.add(birthField);
		birthField.setColumns(10);
		birthField.setEditable(false);
		
		//Percentage
		JLabel percentLabel = new JLabel("Percentage: ",SwingConstants.RIGHT);
		percentLabel.setBounds(215, 50, 100, 20);
		SG.jp1.add(percentLabel);
						
		JTextField percentField = new JTextField();
		percentField.setBounds(320, 50, 200, 20);
		percentField.setText(SG.SGdata.getPercentage());
		SG.jp1.add(percentField);
		percentField.setEditable(false);
		
		String[] percentStrings = {"","100% NZ", "FullBlood", "87.5% (7/8)", "75% (3/4)", "50% (1/2)","GeneMaster", "Premier GeneMaster", "Kiko GeneMaster"};
		JComboBox<String> percentBox = new JComboBox<String>(percentStrings);;
		percentBox.setBounds(320, 50, 200, 20);
		SG.jp1.add(percentBox);
		percentBox.setVisible(false);
		
		//File Number
		JLabel idLabel = new JLabel("File Number: ",SwingConstants.RIGHT);
		idLabel.setBounds(550, 50, 100, 20);
		SG.jp1.add(idLabel);
						
		JLabel idField = new JLabel("9999");
		idField.setBounds(650, 50, 40, 20);
		idField.setText(SG.SGdata.getId().toString());
		SG.jp1.add(idField);
		
		btnEditSave.addActionListener(new ActionListener() {
	          public void actionPerformed(ActionEvent e) {
	        	  if (btnEditSave.getText().equals("edit")) {
	        		  btnEditSave.setText("Save");
	        		  btnCancel.setVisible(true);
	        		  tagField.setEditable(true);
	        		  nameField.setEditable(true);
	        		  genderField.setVisible(false);
	        		  doeButton.setVisible(true);
	        		  buckButton.setVisible(true);
	        		  groupField.setVisible(false);
	        		  groupBox.setVisible(true);
	        		  groupBox.setSelectedItem(SG.SGdata.getHerdgroup());
	        		  birthField.setEditable(true);
	        		  percentField.setVisible(false);
	        		  percentBox.setVisible(true);
	        		  percentBox.setSelectedItem(SG.SGdata.getPercentage());
	        		  String gender = SG.SGdata.getGender().trim();
	        		  if (gender == "doe") {
	        			  doeButton.setSelected(true);
	        		  } else {
	        			  buckButton.setSelected(true);
	        		  }
	        		  
	        	  } else {
	        		  btnEditSave.setText("edit");
	        		  btnCancel.setVisible(false);
	        		  tagField.setEditable(false);
	        		  nameField.setEditable(false);
	        		  genderField.setVisible(true);
	        		  doeButton.setVisible(false);
	        		  buckButton.setVisible(false);
	        		  groupField.setVisible(true);
	        		  groupBox.setVisible(false);
	        		  birthField.setEditable(false);
	        		  percentField.setVisible(true);
	        		  percentBox.setVisible(false);
	        		  String myinsert;
	        		  String gender;
	        		  if (doeButton.isSelected()) {
	        			  gender = "doe";
	        		  } else {
	        			  gender = "buck";
	        		  }
	        		  myinsert = "UPDATE Goat.Herd SET ";
	        			myinsert = myinsert +  "TAG ='" + tagField.getText().trim() + "', ";
	        			myinsert = myinsert +  "NAME = '" + nameField.getText().trim() + "', ";
	        			myinsert = myinsert +  "GENDER ='" + gender + "', ";
	        			myinsert = myinsert +  "HERDGROUP ='" + String.valueOf(groupBox.getSelectedItem()).trim() + "', ";
	        			myinsert = myinsert +  "BIRTHDATE ='" + birthField.getText().trim() + "', ";
	        			myinsert = myinsert +  "PERCENTAGE ='" + String.valueOf(percentBox.getSelectedItem()).trim() + "'";		
	        			myinsert = myinsert +  " WHERE ID= "  + SG.SGdata.getId();
	        					
	        		  SG.SGquery.updateGoat(myinsert);
	        		  
	        		  //SG.SGData.get.....field update
	        		  
	        	  }
	        	  }
	       });
		
		btnCancel.addActionListener(new ActionListener() {
	          public void actionPerformed(ActionEvent e) {
	        	 	  btnEditSave.setText("edit");
	        		  btnCancel.setVisible(false);
	        		  tagField.setEditable(false);
	        		  nameField.setEditable(false);
	        		  genderField.setVisible(true);
	        		  doeButton.setVisible(false);
	        		  buckButton.setVisible(false);
	        		  groupField.setVisible(true);
	        		  groupBox.setVisible(false);
	        		  birthField.setEditable(false);
	        		  percentField.setVisible(true);
	        		  percentBox.setVisible(false);
	        		  tagField.setText(SG.SGdata.getTag());
	        		  nameField.setText(SG.SGdata.getName());
	        		  groupField.setText(SG.SGdata.getHerdgroup());
	        		  birthField.setText(SG.SGdata.getBirthdate());
	        		  percentField.setText(SG.SGdata.getPercentage());
	        	  }
	       });
		
		
	}
	

}
