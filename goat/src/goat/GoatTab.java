package goat;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import util.Checkdate;

public class GoatTab {
	
	Control cc;
	private JTextField tagField;
	private JTextField scrapieField;
	private JTextField nameField;
	private JTextField nkaField;
	private JTextField akgaField;
	private JTextField ikgaField;
	private JTextField tattooLeftField;
	private JTextField tattooRightField;
	private JTextField microField;
	private JTextField colorField;
	private JRadioButton doeButton;
	private JRadioButton buckButton;
	private ButtonGroup genderGroup;
	private JComboBox<String> groupBox;
	private JTextField birthField;
	private JTextArea notesField;
	private JComboBox<String> damBox;
	private JCheckBox firstlactationCB;
	private JComboBox<String> sireBox;
	private JTextField bWeightField;
	private JComboBox<String> bRankBox;
	private JTextArea bnotesField;
	private JComboBox<String> bDamBox;
	private JComboBox<String> bSireBox;
	private JComboBox<String> percentBox;
	private JTextField pDateField;
	private JTextField priceField;
	private JTextField sellerField;
	private JTextArea sellernotesField;
	Checkdate gooddate = new Checkdate();
	Boolean OKdate;
	
	
	
	
	public GoatTab(Control cc){
		
		this.cc = cc; 
		
	}
	
	public void Start() {
		
		/**
         * Create Goat Tab
         */
        JPanel jp1 = new JPanel();
	    jp1.setLayout(null);
	    jp1.setBounds(0, 0, 1000, 700);
	    	    
	    /**
	     * Add Goat Information to GoatTab
	     */
	    
	    // Add Panel, Borders and Titles
        JPanel goatinfopanel = new JPanel();
        goatinfopanel.setLayout(null);
        goatinfopanel.setBounds(0, 0, 400, 615);
	    Color customColor = new Color(102,204,102);
	    goatinfopanel.setBackground(customColor);
	    
	    Border pad = new EmptyBorder(10,10,10,10);
	    Border goattitle= BorderFactory.createTitledBorder("Identification");
	    goatinfopanel.setBorder(new CompoundBorder(pad, goattitle));
	    jp1.add(goatinfopanel);

        JPanel goataddinfopanel = new JPanel();
	    goataddinfopanel.setBounds(400, 0, 600, 615);
        goataddinfopanel.setLayout(null);
	    goataddinfopanel.setBackground(customColor);
	    jp1.add(goataddinfopanel);
	
	    /**
	     * Fill in left side of GoatTab
	     */
	    
	    //Tag Number
	    
	    JLabel tagLabel = new JLabel("Tag Number: ",SwingConstants.RIGHT);
		tagLabel.setBounds(20, 30, 100, 20);
		goatinfopanel.add(tagLabel);
		
		tagField = new JTextField();
		tagField.setBounds(125, 30, 50, 20);
		goatinfopanel.add(tagField);
		tagField.setColumns(10);
		
		JLabel scrapieLabel = new JLabel("Scrapie #: ",SwingConstants.RIGHT);
		scrapieLabel.setBounds(160, 30, 80, 20);
		goatinfopanel.add(scrapieLabel);
		
		scrapieField = new JTextField();
		scrapieField.setBounds(245, 30, 80, 20);
		goatinfopanel.add(scrapieField);
		scrapieField.setColumns(20);
		
		
	    
		//Name
		
		JLabel nameLabel = new JLabel("Name: ",SwingConstants.RIGHT);
		nameLabel.setBounds(20, 60, 100, 20);
		goatinfopanel.add(nameLabel);
		
		nameField = new JTextField();
		nameField.setBounds(125, 60, 200, 20);
		goatinfopanel.add(nameField);
		nameField.setColumns(40);
		
		//NKA Reg Number
		
		JLabel nkaLabel = new JLabel("NKR Num: ",SwingConstants.RIGHT);
		nkaLabel.setBounds(20, 90, 100, 20);
		goatinfopanel.add(nkaLabel);
		
		nkaField = new JTextField();
		nkaField.setBounds(125, 90, 200, 20);
		goatinfopanel.add(nkaField);
		nkaField.setColumns(40);
		
		//AKGA Reg Number
		
		JLabel akgaLabel = new JLabel("AKGA Num: ",SwingConstants.RIGHT);
		akgaLabel.setBounds(20, 120, 100, 20);
		goatinfopanel.add(akgaLabel);
		
		akgaField = new JTextField();
		akgaField.setBounds(125, 120, 200, 20);
		goatinfopanel.add(akgaField);
		akgaField.setColumns(40);
		
		//IKGA Reg Number
		
		JLabel ikgaLabel = new JLabel("IKGA Num: ",SwingConstants.RIGHT);
		ikgaLabel.setBounds(20, 150, 100, 20);
		goatinfopanel.add(ikgaLabel);
		
		ikgaField = new JTextField();
		ikgaField.setBounds(125, 150, 200, 20);
		goatinfopanel.add(ikgaField);
		ikgaField.setColumns(40);
				
		//Tattoo Left
				
		JLabel tattooLeftLabel = new JLabel("Tattoo Left: ",SwingConstants.RIGHT);
		tattooLeftLabel.setBounds(20, 180, 100, 20);
		goatinfopanel.add(tattooLeftLabel);
				
		tattooLeftField = new JTextField();
		tattooLeftField.setBounds(125, 180, 50, 20);
		goatinfopanel.add(tattooLeftField);
		tattooLeftField.setColumns(5);
				
		//Tattoo Right
				
		JLabel tattooRightLabel = new JLabel("Right: ",SwingConstants.RIGHT);
		tattooRightLabel.setBounds(165, 180, 100, 20);
		goatinfopanel.add(tattooRightLabel);
				
		tattooRightField = new JTextField();
		tattooRightField.setBounds(270, 180, 50, 20);
		goatinfopanel.add(tattooRightField);
		tattooRightField.setColumns(5);
				
		//Microchip
				
		JLabel microLabel = new JLabel("Microchip: ",SwingConstants.RIGHT);
		microLabel.setBounds(20, 210, 100, 20);
		goatinfopanel.add(microLabel);
				
		microField = new JTextField();
		microField.setBounds(125, 210, 200, 20);
		goatinfopanel.add(microField);
		microField.setColumns(24);
				
		//Color
				
		JLabel colorLabel = new JLabel("Color: ",SwingConstants.RIGHT);
		colorLabel.setBounds(20, 240, 100, 20);
		goatinfopanel.add(colorLabel);
		
		colorField = new JTextField();
		colorField.setBounds(125, 240, 200, 20);
		goatinfopanel.add(colorField);
		colorField.setColumns(24);	
				
		//Gender
				
		JLabel genderLabel = new JLabel("Gender: ",SwingConstants.RIGHT);
		genderLabel.setBounds(20, 270, 100, 20);
		goatinfopanel.add(genderLabel);
				
		doeButton = new JRadioButton("Doe");
		doeButton.setBounds(125, 270, 80, 20);
		doeButton.setBackground(customColor);
		goatinfopanel.add(doeButton);
						
		buckButton = new JRadioButton("Buck");
		buckButton.setBounds(200, 270, 100, 20);
		buckButton.setBackground(customColor);
		goatinfopanel.add(buckButton);
				
		genderGroup = new ButtonGroup();
		genderGroup.add(doeButton);
		genderGroup.add(buckButton);
				
		//Group
		
		JLabel groupLabel = new JLabel("Group: ",SwingConstants.RIGHT);
		groupLabel.setBounds(20, 300, 100, 20);
		goatinfopanel.add(groupLabel);
		
		String[] groupStrings = {"","Does", "Bucks", "Doeling", "Buckling", "Sold", "Deceased"};
		groupBox = new JComboBox<String>(groupStrings);;
		groupBox.setBounds(125, 300, 200, 20);
		goatinfopanel.add(groupBox);
				
		//Birth date
		
		JLabel birthLabel = new JLabel("Birthdate: ",SwingConstants.RIGHT);
		birthLabel.setBounds(20, 330, 100, 20);
		goatinfopanel.add(birthLabel);
		
		birthField = new JTextField();
		birthField.setBounds(125, 330, 100, 20);
		goatinfopanel.add(birthField);
		birthField.setColumns(10);
		
		JLabel birthFormatLabel = new JLabel("mm/dd/yyyy",SwingConstants.RIGHT);
		birthFormatLabel.setBounds(195, 330, 100, 20);
		goatinfopanel.add(birthFormatLabel);
		
		//Notes
				
		JLabel notesLabel = new JLabel("Notes: ",SwingConstants.RIGHT);
		notesLabel.setBounds(20, 360, 100, 20);
		goatinfopanel.add(notesLabel);
				
		notesField = new JTextArea(20,20);
		notesField.setBounds(125, 360, 200, 190);
		notesField.setLineWrap(true);
		notesField.setWrapStyleWord(true);
		goatinfopanel.add(notesField);

		JButton saveButton = new JButton("Save");
		saveButton.setBounds(55,560, 100, 30);
		goatinfopanel.add(saveButton);
		
		JButton cancelButton = new JButton("Cancel");
		cancelButton.setBounds(190,560,100, 30);
		goatinfopanel.add(cancelButton);

		//Action Listers for SAVE and CANCEL Buttons
		saveButton.addActionListener(new ActionListener() {
	    	  public void actionPerformed(ActionEvent e) {
	        	saveGoat(); 
	    		 
	    		
	    		  
	          }
	      });
		
		cancelButton.addActionListener(new ActionListener() {
	    	  public void actionPerformed(ActionEvent e) {
	        	cancelGoat();         	  
	          }
	      });
		

		/**
		 * Add Kidding, Breed and Purchase sections to 
		 * right side of GoatTab
		 */
		

		/**
		 * Create Kid, Breed and Purchase Panels
		 */
		JPanel kidPanel = new JPanel();
		kidPanel.setBackground(customColor);
		Border kidTitle= BorderFactory.createTitledBorder("Kidding Information");
	    kidPanel.setBorder(new CompoundBorder(pad, kidTitle));
	    kidPanel.setLayout(null);
	    kidPanel.setBounds(0, 0, 340, 260);
	    JPanel breedPanel = new JPanel();
	    breedPanel.setBackground(customColor);
	    Border breedTitle= BorderFactory.createTitledBorder("Breed Information");
	    breedPanel.setBorder(new CompoundBorder(pad, breedTitle));
	    breedPanel.setLayout(null);
	    breedPanel.setBounds(0, 250, 340, 160);
	    
		JPanel purchasePanel = new JPanel();
		purchasePanel.setBackground(customColor);
		Border purchaseTitle= BorderFactory.createTitledBorder("Purchase Information");
	    purchasePanel.setBorder(new CompoundBorder(pad, purchaseTitle));
		purchasePanel.setLayout(null);
		purchasePanel.setBounds(0, 400, 340, 210);
		
		goataddinfopanel.add(kidPanel);
		goataddinfopanel.add(breedPanel);
		goataddinfopanel.add(purchasePanel);

		/**
		 * Fill Kidding Information Panel
		 */
		
		//Dam
		JLabel damLabel = new JLabel("Dam: ",SwingConstants.RIGHT);
		damLabel.setBounds(0, 30, 100, 20);
		kidPanel.add(damLabel);
				
		
		String[] damStrings = cc.myQuery.getnames("SELECT name From GOAT.HERD WHERE HERDGROUP = 'Does'");
		damBox = new JComboBox<String>(damStrings);;
		damBox.setBounds(105, 30, 200, 20);
		kidPanel.add(damBox);
		
		firstlactationCB = new JCheckBox("Doe's first lactation");
		firstlactationCB.setBounds(105, 60, 200, 20);
		firstlactationCB.setBackground(customColor);
		kidPanel.add(firstlactationCB);

		
		//Sire
		JLabel sireLabel = new JLabel("Buck: ",SwingConstants.RIGHT);
		sireLabel.setBounds(0, 90, 100, 20);
		kidPanel.add(sireLabel);
		
		String[] sireStrings = cc.myQuery.getnames("SELECT name From GOAT.HERD WHERE HERDGROUP = 'Bucks'");
		sireBox = new JComboBox<String>(sireStrings);;
		sireBox.setBounds(105, 90, 200, 20);
		kidPanel.add(sireBox);
		
		JLabel bWeightLabel = new JLabel("Birth Weight: ",SwingConstants.RIGHT);
		bWeightLabel.setBounds(0, 120, 100, 20);
		kidPanel.add(bWeightLabel);
		
		bWeightField = new JTextField();
		bWeightField.setBounds(105, 120, 50, 20);
		kidPanel.add(bWeightField);
		bWeightField.setColumns(4);
		
		//Birth Rank
		JLabel bRankLabel = new JLabel("Birth Rank: ",SwingConstants.RIGHT);
		bRankLabel.setBounds(0, 150, 100, 20);
		kidPanel.add(bRankLabel);
				
		String[] bRankStrings = {"","Single", "Twin", "Triplet", "Quadruplet", "Quintuplet"};
		bRankBox = new JComboBox<String>(bRankStrings);;
		bRankBox.setBounds(105, 150, 200, 20);
		kidPanel.add(bRankBox);
		
		//Birth Notes
		JLabel bnotesLabel = new JLabel("Birth Notes: ",SwingConstants.RIGHT);
		bnotesLabel.setBounds(0, 180, 100, 20);
		kidPanel.add(bnotesLabel);
						
		bnotesField = new JTextArea();
		bnotesField.setBounds(105, 180, 200, 50);
		bnotesField.setLineWrap(true);
		bnotesField.setWrapStyleWord(true);
		bnotesField.setColumns(200);
		bnotesField.setLineWrap(true);
		bnotesField.setWrapStyleWord(true);
		kidPanel.add(bnotesField);
				
		
		/**
		 * Fill Breed Information Panel
		 */
		
		//Breed(Dam)
		JLabel bDamLabel = new JLabel("Dam: ",SwingConstants.RIGHT);
		bDamLabel.setBounds(10, 40, 90, 20);
		breedPanel.add(bDamLabel);
		
		String[] bDamStrings = {"","100% NZ Kiko", "FullBlood Kiko", "7/8 Kiko", "3/4 Kiko", "1/2 Kiko", "Boer", "Savannah", "Spanish", "Other"};
		bDamBox = new JComboBox<String>(bDamStrings);;
		bDamBox.setBounds(105, 40, 200, 20);
		breedPanel.add(bDamBox);
		
		//Breed(Sire)
		JLabel bSireLabel = new JLabel("Sire: ",SwingConstants.RIGHT);
		bSireLabel.setBounds(10, 70, 90, 20);
		breedPanel.add(bSireLabel);
		
		String[] bSireStrings = {"","100% NZ Kiko", "FullBlood Kiko", "7/8 Kiko", "3/4 Kiko", "1/2 Kiko", "Boer", "Savannah", "Spanish", "Other"};
		bSireBox = new JComboBox<String>(bSireStrings);;
		bSireBox.setBounds(105, 70, 200, 20);
		breedPanel.add(bSireBox);
		
		//Percentage
		JLabel percentLabel = new JLabel("Percentage: ",SwingConstants.RIGHT);
		percentLabel.setBounds(10, 100, 90, 20);
		breedPanel.add(percentLabel);
		
		String[] percentStrings = {"","100% NZ", "FullBlood", "87.5% (7/8)", "75% (3/4)", "50% (1/2)","GeneMaster", "Premier GeneMaster", "Kiko GeneMaster"};
		percentBox = new JComboBox<String>(percentStrings);;
		percentBox.setBounds(105, 100, 150, 20);
		breedPanel.add(percentBox);
		
		/**
		 * Fill Purchase Information Panel
		 */
		
		// Purchase Date
		JLabel pDateLabel = new JLabel("Purchase Date: ",SwingConstants.RIGHT);
		pDateLabel.setBounds(10, 40, 100, 20);
		purchasePanel.add(pDateLabel);
		
		pDateField = new JTextField();
		pDateField.setBounds(115, 40, 100, 20);
		purchasePanel.add(pDateField);
		pDateField.setColumns(10);
		
		JLabel pDateFormatLabel = new JLabel("mm/dd/yyy",SwingConstants.RIGHT);
		pDateFormatLabel.setBounds(185, 40, 100, 20);
		purchasePanel.add(pDateFormatLabel);
		
		//Price
		JLabel priceLabel = new JLabel("Price: ",SwingConstants.RIGHT);
		priceLabel.setBounds(10, 70, 100, 20);
		purchasePanel.add(priceLabel);
		
		priceField = new JTextField();
		priceField.setBounds(115, 70, 200, 20);
		purchasePanel.add(priceField);
		
		//Seller
		JLabel sellerLabel = new JLabel("Seller: ",SwingConstants.RIGHT);
		sellerLabel.setBounds(10, 100, 100, 20);
		purchasePanel.add(sellerLabel);
				
		sellerField = new JTextField();
		sellerField.setBounds(115, 100, 200, 20);
		purchasePanel.add(sellerField);
		
		//Seller Notes
		JLabel sellernotesLabel = new JLabel("Seller Notes: ",SwingConstants.RIGHT);
		sellernotesLabel.setBounds(10, 130, 100, 20);
		purchasePanel.add(sellernotesLabel);
				
		sellernotesField = new JTextArea(20,20);
		sellernotesField.setBounds(115, 130, 200, 50);
		sellernotesField.setLineWrap(true);
		sellernotesField.setWrapStyleWord(true);
		purchasePanel.add(sellernotesField);
		cc.mydb.jtp.addTab("Goat", jp1); 
	}

	public void saveGoat() {
		
		
		//Check fields to make sure they are valid before adding to database.
		
		boolean OK2Save = true;
		
		// Check tag field to see if it exist in database.
		boolean tagFound = cc.myQuery.checktag("SELECT tag From GOAT.HERD WHERE tag = '" + tagField.getText() + "'" );
		if (tagFound) {
			JOptionPane.showMessageDialog(null, "This tag number already exist in database", "Tag Error",JOptionPane.WARNING_MESSAGE);
			tagField.setBackground(Color.YELLOW);
			OK2Save = false;
		} 
		// Check name Field to make sure it is not blank
		if (OK2Save) {
			if (nameField.getText().isEmpty()) {
				JOptionPane.showMessageDialog(null, "Name Required", "Name Error",JOptionPane.WARNING_MESSAGE);
				nameField.setBackground(Color.YELLOW);
				OK2Save = false;
			}
		}
		//Make sure a group is selected
		if (OK2Save) {
			if (groupBox.getSelectedIndex() < 1) {
				JOptionPane.showMessageDialog(null, "Select a Group for this Goat", "Group Error",JOptionPane.WARNING_MESSAGE);
				groupBox.setBackground(Color.YELLOW);
				OK2Save = false;
			}
			
		} 
		
		
		//Check Birth date to make sure it is a valid date.
		if (!pDateField.getText().isEmpty())  {
			OKdate = gooddate.mmddyyyy(birthField.getText().trim());
			if (!OKdate) {
				JOptionPane.showMessageDialog(null, "Birth Date invalid", "Date Error",JOptionPane.WARNING_MESSAGE);
				birthField.setBackground(Color.YELLOW);
				OK2Save = false;
			}
		}

		//Check Purchase date to make sure it is a valid date
		if (!pDateField.getText().isEmpty())  {
			OKdate = gooddate.mmddyyyy(pDateField.getText().trim());
			if (!OKdate) {
				JOptionPane.showMessageDialog(null, "Purchase Date invalid", "Date Error",JOptionPane.WARNING_MESSAGE);
				pDateField.setBackground(Color.YELLOW);
				OK2Save = false;
			}
		}
		
		notesField.setText(notesField.getText().replace("'", ""));
		notesField.setText(notesField.getText().replace("\"", ""));
		bnotesField.setText(bnotesField.getText().replace("'", ""));
		bnotesField.setText(bnotesField.getText().replace("\"", ""));
		sellernotesField.setText(sellernotesField.getText().replace("'", ""));
		sellernotesField.setText(sellernotesField.getText().replace("\"", ""));
		
		String gender = new String();
		String firstlactation = new String();
		if (doeButton.isSelected()) {
			   gender = "doe";
		   }
		if (buckButton.isSelected()) {
			   gender = "buck";
		   }
		if (firstlactationCB.isSelected()) {
			firstlactation = "yes";
		} else{
			firstlactation = "no";
		}
		
		
		// Save data to database
		String myinsert = new String();
		myinsert = "INSERT INTO GOAT.HERD (TAG, SCRAPIE, NAME, NKR, AKGA, IKGA, TATTOOL, ";
		myinsert = myinsert + "TATTOOR, MICROCHIP, COLOR, GENDER, HERDGROUP, BIRTHDATE, NOTES, OWNED)";
		myinsert = myinsert + "VALUES ('";
		myinsert = myinsert + tagField.getText().trim() + "', '";
		myinsert = myinsert + scrapieField.getText().trim() + "', '";
		myinsert = myinsert + nameField.getText().trim() + "', '";
		myinsert = myinsert + nkaField.getText().trim() + "', '";
		myinsert = myinsert + akgaField.getText().trim() + "', '";
		myinsert = myinsert + ikgaField.getText().trim() + "', '";
		myinsert = myinsert + tattooLeftField.getText().trim() + "', '";
		myinsert = myinsert + tattooRightField.getText().trim() + "', '";
		myinsert = myinsert + microField.getText().trim() + "', '";
		myinsert = myinsert + colorField.getText().trim() + "', '";
		myinsert = myinsert + gender + "', '";
		myinsert = myinsert + String.valueOf(groupBox.getSelectedItem()).trim() + "', '";
		myinsert = myinsert + birthField.getText().trim() + "', '";
		myinsert = myinsert + notesField.getText().trim() + "', '";
		myinsert = myinsert + "yes')";
		cc.myQuery.updateGoat(myinsert);
		
		myinsert = "UPDATE Goat.Herd SET ";
		myinsert = myinsert +  "DAM ='" + String.valueOf(damBox.getSelectedItem()).trim() + "', ";
		myinsert = myinsert +  "FIRSTLACTATION = '" + firstlactation + "', ";
		myinsert = myinsert +  "BUCK ='" + String.valueOf(sireBox.getSelectedItem()).trim() + "', ";
		myinsert = myinsert +  "BIRTHWEIGHT ='" + bWeightField.getText().trim() + "', ";
		myinsert = myinsert +  "BIRTHRANK ='" + String.valueOf(bRankBox.getSelectedItem()).trim() + "', ";
		myinsert = myinsert +  "BIRTHNOTES ='" + bnotesField.getText().trim() + "', ";
		myinsert = myinsert +  "DAMBREED ='" + String.valueOf(bDamBox.getSelectedItem()).trim() + "', ";
		myinsert = myinsert +  "SIREBREED ='" + String.valueOf(bSireBox.getSelectedItem()).trim() + "', ";
		myinsert = myinsert +  "PERCENTAGE ='" + String.valueOf(percentBox.getSelectedItem()).trim() + "', ";		
		myinsert = myinsert +  "PURCHASEDATE ='" + pDateField.getText().trim() + "', ";
		myinsert = myinsert +  "PRICE ='" + priceField.getText().trim() + "', ";
		myinsert = myinsert +  "SELLER ='" + sellerField.getText().trim() + "', ";
		myinsert = myinsert +  "SELLERNOTES ='" + sellernotesField.getText().trim() + "', ";
		myinsert = myinsert +  "SOLD ='no', ";
		myinsert = myinsert +  "DEATH ='no'";
		myinsert = myinsert +  " WHERE TAG='"  + tagField.getText().trim() + "'";
				
		
		cc.myQuery.updateGoat(myinsert);
		
		cc.myTree.updateTree(nameField.getText().trim());  //Does this work?  Part of test menu item?
		
		cancelGoat();
		
	}
	
	public void cancelGoat() {
		scrapieField.setText(null);
		tagField.setText(null);
		tagField.setBackground(Color.WHITE);
		nameField.setText(null);
		nameField.setBackground(Color.WHITE);
		nkaField.setText(null);
		akgaField.setText(null);
		ikgaField.setText(null);
		tattooLeftField.setText(null);
		tattooRightField.setText(null);
		microField.setText(null);
		colorField.setText(null);
		genderGroup.clearSelection();
		groupBox.setSelectedItem("");
		groupBox.setBackground(Color.WHITE);
		birthField.setText(null);
		birthField.setBackground(Color.WHITE);
		notesField.setText(null);
		damBox.setSelectedItem("");
		firstlactationCB.setSelected(false);
		sireBox.setSelectedItem("");
		bWeightField.setText(null);
		bRankBox.setSelectedItem("");
		bnotesField.setText(null);
		bDamBox.setSelectedItem("");
		bSireBox.setSelectedItem("");
		percentBox.setSelectedItem("");
		pDateField.setText(null);
		pDateField.setBackground(Color.WHITE);
		priceField.setText(null);
		sellerField.setText(null);
		sellernotesField.setText(null);
	}

}
