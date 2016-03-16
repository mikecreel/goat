package goat;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class SGsmID {
	
	ShowGoat SG;
	Control cc;
	
	public SGsmID(ShowGoat SG, Control cc) {
		this.SG = SG;
		this.cc = cc;
	}
	
	public void displayID () {
		
		//////////////////////////////
		//Setup the identification tab
		//////////////////////////////

		JPanel idPanel = new JPanel();
		idPanel.setLayout(null);
		SG.smjtp.addTab("Identification", idPanel);
		idPanel.setBackground(SG.customColor);

		JLabel nkrLabel = new JLabel("NKR Num: ",SwingConstants.RIGHT);
		nkrLabel.setBounds(10, 20, 100, 20);
		idPanel.add(nkrLabel);

		JTextField nkrField = new JTextField();
		nkrField.setBounds(115, 20, 200, 20);
		nkrField.setColumns(40);
		nkrField.setText(SG.SGdata.getNkr());
		idPanel.add(nkrField);
		nkrField.setEditable(false);

		//AKGA Reg Number

		JLabel akgaLabel = new JLabel("AKGA Num: ",SwingConstants.RIGHT);
		akgaLabel.setBounds(315, 20, 100, 20);
		idPanel.add(akgaLabel);

		JTextField akgaField = new JTextField();
		akgaField.setBounds(415, 20, 200, 20);
		akgaField.setColumns(40);
		akgaField.setText(SG.SGdata.getAkga());
		idPanel.add(akgaField);
		akgaField.setEditable(false);

		//IKGA Reg Number

		JLabel ikgaLabel = new JLabel("IKGA Num: ",SwingConstants.RIGHT);
		ikgaLabel.setBounds(600, 20, 100, 20);
		idPanel.add(ikgaLabel);

		JTextField ikgaField = new JTextField();
		ikgaField.setBounds(700, 20, 200, 20);
		ikgaField.setColumns(40);
		ikgaField.setText(SG.SGdata.getIkga());
		idPanel.add(ikgaField);
		ikgaField.setEditable(false);

		//Tattoo Left

		JLabel tattooLeftLabel = new JLabel("Tattoo Left: ",SwingConstants.RIGHT);
		tattooLeftLabel.setBounds(10, 50, 100, 20);
		idPanel.add(tattooLeftLabel);

		JTextField tattooLeftField = new JTextField();
		tattooLeftField.setBounds(115, 50, 50, 20);
		tattooLeftField.setColumns(5);
		tattooLeftField.setText(SG.SGdata.getTattool());
		idPanel.add(tattooLeftField);
		tattooLeftField.setEditable(false);

		//Tattoo Right

		JLabel tattooRightLabel = new JLabel("Right: ",SwingConstants.RIGHT);
		tattooRightLabel.setBounds(160, 50, 100, 20);
		idPanel.add(tattooRightLabel);

		JTextField tattooRightField = new JTextField();
		tattooRightField.setBounds(265, 50, 50, 20);
		tattooRightField.setColumns(5);
		tattooRightField.setText(SG.SGdata.getTattoor());
		idPanel.add(tattooRightField);
		tattooRightField.setEditable(false);

		//Microchip

		JLabel microLabel = new JLabel("Microchip: ",SwingConstants.RIGHT);
		microLabel.setBounds(315, 50, 100, 20);
		idPanel.add(microLabel);

		JTextField microField = new JTextField();
		microField.setBounds(415, 50, 200, 20);
		microField.setColumns(24);
		microField.setText(SG.SGdata.getMicrochip());
		idPanel.add(microField);
		microField.setEditable(false);
		
		JLabel scrapieLabel = new JLabel("Scrapie Tag: ",SwingConstants.RIGHT);
		scrapieLabel.setBounds(600, 50, 100, 20);
		idPanel.add(scrapieLabel);

		JTextField scrapieField = new JTextField();
		scrapieField.setBounds(700, 50, 100, 20);
		scrapieField.setColumns(20);
		scrapieField.setText(SG.SGdata.getScrapie());
		idPanel.add(scrapieField);
		scrapieField.setEditable(false);
		
		//Add edit/save button to tab
		JButton btnEditSave = new JButton("edit");
	    btnEditSave.setBounds(700, 90, 80, 20);
	    idPanel.add(btnEditSave);
	    
		//Add cancel button to tab
		JButton btnCancel = new JButton("cancel");
		btnCancel.setBounds(800, 90, 80, 20);
		idPanel.add(btnCancel);
		btnCancel.setVisible(false);
		
		btnEditSave.addActionListener(new ActionListener() {
	          public void actionPerformed(ActionEvent e) {
	        	  if (btnEditSave.getText().equals("edit")) {
	        		  btnEditSave.setText("Save");
	        		  btnCancel.setVisible(true);
	        		  nkrField.setEditable(true);
	        		  akgaField.setEditable(true);
	        		  ikgaField.setEditable(true);
	        		  tattooLeftField.setEditable(true);
	        		  tattooRightField.setEditable(true);
	        		  microField.setEditable(true);
	        		  scrapieField.setEditable(true);
	        	  } else {
	        		  btnEditSave.setText("edit");
	        		  btnCancel.setVisible(false);	        		  
	        		  nkrField.setEditable(false);
	        		  akgaField.setEditable(false);
	        		  ikgaField.setEditable(false);
	        		  tattooLeftField.setEditable(false);
	        		  tattooRightField.setEditable(false);
	        		  microField.setEditable(false);
	        		  scrapieField.setEditable(false);
	        		  String myinsert;
	        		  myinsert = "UPDATE Goat.Herd SET ";
	        		  myinsert = myinsert +  "NKR ='" + nkrField.getText().trim() + "', ";
	        		  myinsert = myinsert +  "AKGA = '" + akgaField.getText().trim() + "', ";
	        		  myinsert = myinsert +  "IKGA ='" + ikgaField.getText().trim() + "', ";
	        		  myinsert = myinsert +  "TATTOOL ='" + tattooLeftField.getText().trim() + "', ";
	        		  myinsert = myinsert +  "TATTOOR ='" + tattooRightField.getText().trim() + "', ";
		    		  myinsert = myinsert +  "MICROCHIP ='" + microField.getText().trim() + "', ";
		    		  myinsert = myinsert +  "SCRAPIE ='" + scrapieField.getText().trim() + "'";		
		    		  myinsert = myinsert +  " WHERE ID= "  + SG.SGdata.getId();
	        		  SG.SGquery.updateGoat(myinsert);
	        	  }
	        	  }
	       });
		
		btnCancel.addActionListener(new ActionListener() {
	          public void actionPerformed(ActionEvent e) {
	        	 	  btnEditSave.setText("edit");
	        		  btnCancel.setVisible(false);	        		  
	        		  nkrField.setEditable(false);
	        		  akgaField.setEditable(false);
	        		  ikgaField.setEditable(false);
	        		  tattooLeftField.setEditable(false);
	        		  tattooRightField.setEditable(false);
	        		  microField.setEditable(false);
	        		  scrapieField.setEditable(false);
	        		  nkrField.setText(SG.SGdata.getNkr());
	        		  akgaField.setText(SG.SGdata.getAkga());
	        		  ikgaField.setText(SG.SGdata.getIkga());
	        		  tattooLeftField.setText(SG.SGdata.getTattool());
	        		  tattooRightField.setText(SG.SGdata.getTattoor());
	        		  microField.setText(SG.SGdata.getMicrochip());
	        		  scrapieField.setText(SG.SGdata.getScrapie());
	        	  }
	       });
		
	}

}
