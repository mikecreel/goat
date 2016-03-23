package goat;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.AbstractButton;
import javax.swing.ButtonModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import util.Checkdate;
import util.FormatDate;

public class SGsmDeathSold {
	
	ShowGoat SG;
	Control cc;

	public SGsmDeathSold(ShowGoat SG, Control cc) {
		this.SG = SG;
		this.cc = cc;
	}

	public void displayDeathSold() {
// FIXME After cancel of edit.  Tab is not reset to beginning.		
		//////////////////////////////
		//Setup the deceased/sold tab
		//////////////////////////////
		
		JPanel deceasedsoldPanel = new JPanel();
		deceasedsoldPanel.setLayout(null);
		SG.smjtp.addTab("Deceased / Sold", deceasedsoldPanel);
		deceasedsoldPanel.setBackground(SG.customColor);
		
		//Deceased Check Box
		
		JCheckBox deceasedCB = new JCheckBox("Deceased");
		deceasedCB.setBounds(110, 10, 150, 20);
		deceasedCB.setBackground(SG.customColor);
		
		String deceased = SG.SGdata.getDeath();
		if (deceased == null) {
			deceased = "no";
		}
		if (deceased.equals("yes")) {
			deceasedCB.setSelected(true);
		}else {
			deceasedCB.setSelected(false);
		}
		deceasedCB.setEnabled(false);
		deceasedsoldPanel.add(deceasedCB);
		
		//Death Date
		
		JLabel deceaseddateLabel = new JLabel("Deceased Date: ",SwingConstants.RIGHT);
		deceaseddateLabel.setBounds(10, 40, 100, 20);
		deceasedsoldPanel.add(deceaseddateLabel);
		
		JTextField deceaseddateField = new JTextField();
		deceaseddateField.setBounds(115, 40, 100, 20);
		deceaseddateField.setColumns(10);
		deceaseddateField.setText(SG.SGdata.getDeathdate());
		deceaseddateField.setEditable(false);
		deceasedsoldPanel.add(deceaseddateField);
		
		//On Focus Lost, check for correct date format
		
		deceaseddateField.addFocusListener(new FocusListener() {
			public void focusGained(FocusEvent e) {
				//No event here
			}

			public void focusLost(FocusEvent e) {
				Checkdate gooddate = new Checkdate();

				if (gooddate.mmddyyyy(deceaseddateField.getText().trim())) {
					FormatDate myFormatDate = new FormatDate();
					deceaseddateField.setText(myFormatDate.FormatMyDate(deceaseddateField.getText()));
				} else {
					JOptionPane.showMessageDialog(deceasedsoldPanel,
							"Not a valid date.",
							"Error",
							JOptionPane.WARNING_MESSAGE);
					deceaseddateField.setText("");
					deceaseddateField.requestFocus();
				}

			}
		});

		
		
		
		
		JLabel dateFielddateFormatLabel = new JLabel("mm/dd/yyyy",SwingConstants.RIGHT);
		dateFielddateFormatLabel.setBounds(185, 40, 100, 20);
		deceasedsoldPanel.add(dateFielddateFormatLabel);
		
		//Death Notes
		JLabel dnotesLabel = new JLabel("Death Notes: ",SwingConstants.RIGHT);
		dnotesLabel.setBounds(10, 70, 100, 20);
		deceasedsoldPanel.add(dnotesLabel);
					
		JTextArea dnotesField = new JTextArea(20,20);
		dnotesField.setBounds(115, 70, 300, 50);
		dnotesField.setLineWrap(true);
		dnotesField.setWrapStyleWord(true);
		dnotesField.setText(SG.SGdata.getDnotes());
		dnotesField.setEditable(false);
		deceasedsoldPanel.add(dnotesField);		
		
		if (!deceasedCB.isSelected()) {
			deceaseddateLabel.setVisible(false);
			deceaseddateField.setVisible(false);
			dateFielddateFormatLabel.setVisible(false);
			dnotesLabel.setVisible(false);
			dnotesField.setVisible(false);
		} 
			
		
		//Sold Check Box
		
		JCheckBox soldCB = new JCheckBox("Sold");
		soldCB.setBounds(450, 10, 50, 20);
		soldCB.setBackground(SG.customColor);
		String sold = SG.SGdata.getSold();
		
		if (sold == null) {
			sold = "no";
		}
		if (sold.equals("yes")) {
		soldCB.setSelected(true);
		}else {
		soldCB.setSelected(false);
		}
		soldCB.setEnabled(false);
		deceasedsoldPanel.add(soldCB);
		
		//Sold Date
		
		JLabel solddateLabel = new JLabel("Sell Date: ",SwingConstants.RIGHT);
		solddateLabel.setBounds(500, 10, 100, 20);
		deceasedsoldPanel.add(solddateLabel);
			
		JTextField solddateField = new JTextField();
		solddateField.setBounds(600, 10, 100, 20);
		solddateField.setColumns(10);
		solddateField.setText(SG.SGdata.getSolddate());
		solddateField.setEditable(false);
		deceasedsoldPanel.add(solddateField);
			
		JLabel solddateFormatLabel = new JLabel("mm/dd/yyyy",SwingConstants.RIGHT);
		solddateFormatLabel.setBounds(680, 10, 100, 20);
		deceasedsoldPanel.add(solddateFormatLabel);
		
		//On Focus Lost, check for correct date format

		solddateField.addFocusListener(new FocusListener() {
			public void focusGained(FocusEvent e) {
				//No event here
			}

			public void focusLost(FocusEvent e) {
				Checkdate gooddate = new Checkdate();

				if (gooddate.mmddyyyy(solddateField.getText().trim())) {
					FormatDate myFormatDate = new FormatDate();
					solddateField.setText(myFormatDate.FormatMyDate(solddateField.getText()));
				} else {
					JOptionPane.showMessageDialog(deceasedsoldPanel,
							"Not a valid date.",
							"Error",
							JOptionPane.WARNING_MESSAGE);
					solddateField.setText("");
					solddateField.requestFocus();
				}

			}
		});

		
		//Amount
		
		JLabel amountLabel = new JLabel("Amount: ",SwingConstants.RIGHT);
		amountLabel.setBounds(500, 40, 100, 20);
		deceasedsoldPanel.add(amountLabel);
			
		JTextField amountField = new JTextField();
		amountField.setBounds(600, 40, 60, 20);
		amountField.setColumns(10);
		amountField.setText(SG.SGdata.getAmount());
		amountField.setEditable(false);
		deceasedsoldPanel.add(amountField);
		
		//Fees
		
		JLabel feesLabel = new JLabel("Fees: ",SwingConstants.RIGHT);
		feesLabel.setBounds(700, 40, 100, 20);
		deceasedsoldPanel.add(feesLabel);
			
		JTextField feesField = new JTextField();
		feesField.setBounds(800, 40, 60, 20);
		feesField.setColumns(10);
		feesField.setText(SG.SGdata.getAmount());
		feesField.setEditable(false);
		deceasedsoldPanel.add(feesField);
		
		//Sold Notes
		JLabel snotesLabel = new JLabel("Sold Notes: ",SwingConstants.RIGHT);
		snotesLabel.setBounds(450, 70, 100, 20);
		deceasedsoldPanel.add(snotesLabel);
							
		JTextArea snotesField = new JTextArea(20,20);
		snotesField.setBounds(550, 70, 310, 50);
		snotesField.setLineWrap(true);
		snotesField.setWrapStyleWord(true);
		snotesField.setText(SG.SGdata.getSoldnote());
		snotesField.setEditable(false);
		deceasedsoldPanel.add(snotesField);	
		
		if(!soldCB.isSelected()) {
			solddateLabel.setVisible(false);
			solddateField.setVisible(false);
			solddateFormatLabel.setVisible(false);
			amountLabel.setVisible(false);
			amountField.setVisible(false);
			feesLabel.setVisible(false);
			feesField.setVisible(false);
			snotesLabel.setVisible(false);
			snotesField.setVisible(false);
		}
		
		
		
		
		//Add edit/save button to tab
		JButton btnEditSave = new JButton("edit");
		btnEditSave.setBounds(875, 60, 80, 20);
		deceasedsoldPanel.add(btnEditSave);
		//Add cancel button to tab
		JButton btnCancel = new JButton("cancel");
		btnCancel.setBounds(875, 90, 80, 20);
		deceasedsoldPanel.add(btnCancel);
		btnCancel.setVisible(false);
		
		btnEditSave.addActionListener(new ActionListener() {
	          public void actionPerformed(ActionEvent e) {
	        	  if (btnEditSave.getText().equals("edit")) {
	        		  btnEditSave.setText("Save");
	        		  btnCancel.setVisible(true);
	        		  deceasedCB.setEnabled(true);
	        		  soldCB.setEnabled(true);
	        		  
	        	  } else {
	        		  btnEditSave.setText("edit");
	        		  btnCancel.setVisible(false);
	        		  deceasedCB.setEnabled(false);
	        		  soldCB.setEnabled(false);
	        		  
	        		  String myinsert;
	        		  String deceasedCBstatus = null;
	        		  String soldCBstatus = null;
	        		  
	        		  if (deceasedCB.isSelected()) {
	        			  deceasedCBstatus = "yes";
	        		  } else {
	        			  deceasedCBstatus = "no";
	        		  }
	        		  if (soldCB.isSelected()) {
	        			  soldCBstatus = "yes";
	        		  } else {
	        			  soldCBstatus = "no";
	        		  }
	        		  
	        		  
	        		  //Remove " ' from notes Fields.
	        		  snotesField.setText(snotesField.getText().replace("'", ""));
	        		  snotesField.setText(snotesField.getText().replace("\"", ""));
	        		  dnotesField.setText(dnotesField.getText().replace("'", ""));
	        		  dnotesField.setText(dnotesField.getText().replace("\"", ""));
	        		  
	        		  
	        		  myinsert = "UPDATE Goat.Herd SET ";
	        		  myinsert = myinsert +  "SOLD ='" + soldCBstatus + "', ";
	        		  myinsert = myinsert +  "SOLDDATE = '" + solddateField.getText().trim() + "', ";
	        		  myinsert = myinsert +  "AMOUNT = '" + amountField.getText().trim() + "', ";
	        		  myinsert = myinsert +  "FEES ='" + feesField.getText().trim() + "', ";
	        		  myinsert = myinsert +  "SOLDNOTE ='" + snotesField.getText().trim() + "', ";
	        		  myinsert = myinsert +  "DEATH ='" + deceasedCBstatus + "', ";
	        		  myinsert = myinsert +  "DEATHDATE ='" + deceaseddateField.getText().trim() + "', ";
	        		  myinsert = myinsert +  "HERDGROUP = 'Deceased', ";
	        		  myinsert = myinsert +  "DNOTES ='" + dnotesField.getText().trim() + "'";		
	        		  myinsert = myinsert +  " WHERE ID= "  + SG.SGdata.getId();
	        		  System.out.println(myinsert);
	        		  SG.SGquery.updateGoat(myinsert);
	        		  SG.SGquery.getmygoat("SELECT * From GOAT.HERD WHERE name = '" + SG.SGdata.getName() + "'");
	        	  }
	        	}
	       });
		
		btnCancel.addActionListener(new ActionListener() {
	          public void actionPerformed(ActionEvent e) {
	        	 	  btnEditSave.setText("edit");
	        		  btnCancel.setVisible(false);
	        		  deceasedCB.setEnabled(false);
	        		  soldCB.setEnabled(false);
	        		  
	        	  }
	       });
		

		// Define ChangeListener for Deceased Check Box
	    ChangeListener changeListener = new ChangeListener() {
	    	public void stateChanged(ChangeEvent changeEvent) {
	    		AbstractButton abstractButton = (AbstractButton)changeEvent.getSource();
	    		ButtonModel buttonModel = abstractButton.getModel();
	    			boolean state = buttonModel.isSelected();
	    			deceaseddateLabel.setVisible(state);
	    			deceaseddateField.setVisible(state);
	    			dateFielddateFormatLabel.setVisible(state);
	    			dnotesLabel.setVisible(state);
	    			dnotesField.setVisible(state);
	    			soldCB.setVisible(!state);
	    			if (btnEditSave.getText().equals("Save")) {
	    				deceaseddateField.setEditable(true);
	    				dnotesField.setEditable(true);
	    			} else {
	    				deceaseddateField.setEditable(false);
	    				dnotesField.setEditable(false);
	    			}
					
	    		
	    	}
	    };
	    deceasedCB.addChangeListener(changeListener);
	    
	 // Define ChangeListener for Sold Check Box
	    ChangeListener soldchangeListener = new ChangeListener() {
	    	public void stateChanged(ChangeEvent changeEvent) {
	    		AbstractButton abstractButton = (AbstractButton)changeEvent.getSource();
	    		ButtonModel buttonModel = abstractButton.getModel();
	    			boolean soldstate = buttonModel.isSelected();
	    			solddateLabel.setVisible(soldstate);
					solddateField.setVisible(soldstate);
					solddateFormatLabel.setVisible(soldstate);
					amountLabel.setVisible(soldstate);
					amountField.setVisible(soldstate);
					feesLabel.setVisible(soldstate);
					feesField.setVisible(soldstate);
					snotesLabel.setVisible(soldstate);
					snotesField.setVisible(soldstate);
	    			deceasedCB.setVisible(!soldstate);
	    			if (btnEditSave.getText().equals("Save")) {
	    				solddateField.setEditable(true);
	    				amountField.setEditable(true);
	    				feesField.setEditable(true);
	    				snotesField.setEditable(true);
	    			} else {
	    				solddateField.setEditable(false);
	    				amountField.setEditable(false);
	    				feesField.setEditable(false);
	    				snotesField.setEditable(false);
	    			}
					
	    		
	    	}
	    };
	    soldCB.addChangeListener(soldchangeListener);
	    
	    
	}

}
