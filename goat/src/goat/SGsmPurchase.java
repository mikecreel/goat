package goat;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class SGsmPurchase {
	
	ShowGoat SG;
	Control cc;

	public SGsmPurchase(ShowGoat SG, Control cc) {
		this.SG = SG;
		this.cc = cc;
	}

	public void displayPurchase() {
		
		//////////////////////////////
		//Setup the purchase tab
		//////////////////////////////
		
		JPanel purchasePanel = new JPanel();
		purchasePanel.setLayout(null);
		SG.smjtp.addTab("Purchase Information", purchasePanel);
		purchasePanel.setBackground(SG.customColor);
		
		//Purchase Date
		
		JLabel pdateLabel = new JLabel("Purchase Date: ",SwingConstants.RIGHT);
		pdateLabel.setBounds(10, 20, 100, 20);
		purchasePanel.add(pdateLabel);
		
		JTextField pdateField = new JTextField();
		pdateField.setBounds(115, 20, 100, 20);
		pdateField.setColumns(10);
		pdateField.setText(SG.SGdata.getPurchasedate());
		pdateField.setEditable(false);
		purchasePanel.add(pdateField);
		
		JLabel pdateFormatLabel = new JLabel("mm/dd/yyyy",SwingConstants.RIGHT);
		pdateFormatLabel.setBounds(185, 20, 100, 20);
		purchasePanel.add(pdateFormatLabel);
		
		//Price
		
		JLabel priceLabel = new JLabel("Price: ",SwingConstants.RIGHT);
		priceLabel.setBounds(280, 20, 100, 20);
		purchasePanel.add(priceLabel);
		
		JTextField priceField = new JTextField();
		priceField.setBounds(400, 20, 200, 20);
		priceField.setText(SG.SGdata.getPrice());
		priceField.setEditable(false);
		purchasePanel.add(priceField);
		
		//Seller
		JLabel sellerLabel = new JLabel("Seller: ",SwingConstants.RIGHT);
		sellerLabel.setBounds(605, 20, 100, 20);
		purchasePanel.add(sellerLabel);
			
		JTextField sellerField = new JTextField();
		sellerField.setBounds(715, 20, 200, 20);
		sellerField.setText(SG.SGdata.getSeller());
		sellerField.setEditable(false);
		purchasePanel.add(sellerField);
		
		//Seller Notes
		JLabel sellernotesLabel = new JLabel("Seller Notes: ",SwingConstants.RIGHT);
		sellernotesLabel.setBounds(10, 60, 100, 20);
		purchasePanel.add(sellernotesLabel);
			
		JTextArea sellernotesField = new JTextArea(20,20);
		sellernotesField.setBounds(115, 60, 700, 50);
		sellernotesField.setLineWrap(true);
		sellernotesField.setWrapStyleWord(true);
		sellernotesField.setText(SG.SGdata.getSellernotes());
		sellernotesField.setEditable(false);
		purchasePanel.add(sellernotesField);
		
		//Add edit/save button to tab
		JButton btnEditSave = new JButton("edit");
		btnEditSave.setBounds(850, 60, 80, 20);
		purchasePanel.add(btnEditSave);
		//Add cancel button to tab
		JButton btnCancel = new JButton("cancel");
		btnCancel.setBounds(850, 90, 80, 20);
		purchasePanel.add(btnCancel);
		btnCancel.setVisible(false);
		
		btnEditSave.addActionListener(new ActionListener() {
	          public void actionPerformed(ActionEvent e) {
	        	  if (btnEditSave.getText().equals("edit")) {
	        		  btnEditSave.setText("Save");
	        		  btnCancel.setVisible(true);
	        		  pdateField.setEditable(true);
	        		  priceField.setEditable(true);
	        		  sellernotesField.setEditable(true);
	        		  sellerField.setEditable(true);
	        		  
	        	  } else {
	        		  btnEditSave.setText("edit");
	        		  btnCancel.setVisible(false);
	        		  pdateField.setEditable(false);
	        		  priceField.setEditable(false);
	        		  sellernotesField.setEditable(false);
	        		  sellerField.setEditable(false);

	        		  //Data checking
	        		  
	        		  sellernotesField.setText(sellernotesField.getText().replace("'", ""));
	        		  sellernotesField.setText(sellernotesField.getText().replace("\"", ""));
	        		  
	        		  
	        		  
	        		  String myinsert;
	        		  
	        		  myinsert = "UPDATE Goat.Herd SET ";
	        		  myinsert = myinsert +  "PURCHASEDATE ='" + pdateField.getText().trim() + "', ";
	        		  myinsert = myinsert +  "PRICE = '" + priceField.getText().trim() + "', ";
	        		  myinsert = myinsert +  "SELLER ='" + sellerField.getText().trim() + "', ";
	        		  myinsert = myinsert +  "SELLERNOTES ='" + sellernotesField.getText().trim() + "'";		
	        		  myinsert = myinsert +  " WHERE ID= "  + SG.SGdata.getId();
	        		  System.out.println(myinsert);		
	        		  SG.SGquery.updateGoat(myinsert);
	        		  SG.SGquery.getmygoat("SELECT * From GOAT.HERD WHERE name = '" + SG.SGdata.getName() + "'");
	        		  pdateField.setText(SG.SGdata.getPurchasedate());
	        		  priceField.setText(SG.SGdata.getPrice());
	        		  sellerField.setText(SG.SGdata.getSeller());
	        		  sellernotesField.setText(SG.SGdata.getSellernotes());
	        		  
	        	  }
	        	}
	       });
		
		btnCancel.addActionListener(new ActionListener() {
	          public void actionPerformed(ActionEvent e) {
	        	 	  btnEditSave.setText("edit");
	        		  btnCancel.setVisible(false);
	        		  pdateField.setEditable(false);
	        		  priceField.setEditable(false);
	        		  sellernotesField.setEditable(false);
	        		  sellerField.setEditable(false);
	        		  pdateField.setText(SG.SGdata.getPurchasedate());
	        		  priceField.setText(SG.SGdata.getPrice());
	        		  sellerField.setText(SG.SGdata.getSeller());
	        		  sellernotesField.setText(SG.SGdata.getSellernotes());
	        		  
	          }
  	});

		
	}

}
