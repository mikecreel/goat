package goat;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class SGsmParentage {
	
	ShowGoat SG;
	Control cc;

	public SGsmParentage(ShowGoat SG, Control cc) {
		this.SG = SG;
		this.cc = cc;
	}

	public void displayParentage() {
		
		//////////////////////////////
		//Setup the parentage tab
		//////////////////////////////
//FIXME This needs work.  Selection of blood should not occur until after update button is pushed.		
		JPanel parentagePanel = new JPanel();
		parentagePanel.setLayout(null);
		parentagePanel.setBackground(SG.customColor);
		SG.smjtp.addTab("Parentage", parentagePanel);
		
		JLabel damLabel = new JLabel("Dam: ",SwingConstants.RIGHT);
		damLabel.setBounds(0, 30, 100, 20);
		parentagePanel.add(damLabel);
		
		String[] damStrings = SG.SGquery.getnames("SELECT name From GOAT.HERD WHERE HERDGROUP = 'Does'");
		JComboBox<String> damBox = new JComboBox<String>(damStrings);
		damBox.setBounds(105, 30, 250, 20);
		damBox.setSelectedItem(SG.SGdata.getDam());
		damBox.setVisible(false);
		parentagePanel.add(damBox);
		
		JTextField damField = new JTextField();
		damField.setBounds(105, 30, 250, 20);
		damField.setText(SG.SGdata.getDam());
		parentagePanel.add(damField);
		damField.setEditable(false);
		
		
		JLabel sireLabel = new JLabel("Sire: ",SwingConstants.RIGHT);
		sireLabel.setBounds(300, 30, 100, 20);
		parentagePanel.add(sireLabel);
		
		String[] sireStrings = SG.SGquery.getnames("SELECT name From GOAT.HERD WHERE HERDGROUP = 'Bucks'");
		JComboBox<String> sireBox = new JComboBox<String>(sireStrings);
		sireBox.setBounds(405, 30, 250, 20);
		sireBox.setSelectedItem(SG.SGdata.getSire());
		sireBox.setVisible(false);
		parentagePanel.add(sireBox);
		
		JTextField sireField = new JTextField();
		sireField.setBounds(405, 30, 250, 20);
		sireField.setText(SG.SGdata.getSire());
		parentagePanel.add(sireField);
		sireField.setEditable(false);
		
		
		JLabel dambreedLabel = new JLabel(SG.SGdata.getDambreed());
		dambreedLabel.setBounds(115, 60, 200, 20);
		dambreedLabel.setFont(new Font("Dialog", Font.PLAIN, 18));
		parentagePanel.add(dambreedLabel);
		
		JLabel sirebreedLabel = new JLabel(SG.SGdata.getSirebreed());
		sirebreedLabel.setBounds(415, 60, 200, 20);
		sirebreedLabel.setFont(new Font("Dialog", Font.PLAIN, 18));
		parentagePanel.add(sirebreedLabel);
		
		JLabel percentageLabel = new JLabel("Percentage: ",SwingConstants.RIGHT);
		percentageLabel.setBounds(650, 30, 100, 20);
		parentagePanel.add(percentageLabel);
		
		String[] percentageStrings = {"","100% NZ", "PureBlood", "87.5% (7/8)", "75% (3/4)", "50% (1/2)","GeneMaster", "Premier GeneMaster", "Kiko GeneMaster"};
		JComboBox<String> percentageBox = new JComboBox<String>(percentageStrings);;
		percentageBox.setBounds(755, 30, 200, 20);
		percentageBox.setSelectedItem(SG.SGdata.getPercentage());
		percentageBox.setVisible(false);
		parentagePanel.add(percentageBox);
		
		JTextField percentageField = new JTextField();
		percentageField.setBounds(755, 30, 200, 20);
		percentageField.setText(SG.SGdata.getPercentage());
		parentagePanel.add(percentageField);
		percentageField.setEditable(false);
		
		//Add edit/save button to tab
		JButton btnEditSave = new JButton("edit");
		btnEditSave.setBounds(755, 60, 80, 20);
		parentagePanel.add(btnEditSave);
		//Add cancel button to tab
		JButton btnCancel = new JButton("cancel");
		btnCancel.setBounds(755, 90, 80, 20);
		parentagePanel.add(btnCancel);
		btnCancel.setVisible(false);
		// Dam and Sire Percentage update button
		JButton btnUpdate = new JButton("Update");
		btnUpdate.setBounds(655, 90, 80, 20);
		parentagePanel.add(btnUpdate);
		btnUpdate.setVisible(false);
		
		
		
		btnEditSave.addActionListener(new ActionListener() {
	          public void actionPerformed(ActionEvent e) {
	        	  if (btnEditSave.getText().equals("edit")) {
	        		  btnEditSave.setText("Save");
	        		  btnEditSave.setEnabled(false);
	        		  btnUpdate.setVisible(true);
	        		  btnCancel.setVisible(true);
	        		  damField.setVisible(false);
	        		  sireField.setVisible(false);
	        		  percentageField.setVisible(false);
	        		  damBox.setVisible(true);
	        		  sireBox.setVisible(true);
	        		  percentageBox.setVisible(true);
	        	  } else {
	        		  btnEditSave.setText("edit");
	        		  btnEditSave.setEnabled(true);
	        		  btnCancel.setVisible(false);
	        		  btnUpdate.setVisible(false);
	        		  damField.setVisible(true);
	        		  sireField.setVisible(true);
	        		  percentageField.setVisible(true);
	        		  damBox.setVisible(false);
	        		  sireBox.setVisible(false);
	        		  percentageBox.setVisible(false);
	        		  
	        		  
	        		  String myinsert;
	        		  
	        		  myinsert = "UPDATE Goat.Herd SET ";
	        		  myinsert = myinsert +  "DAM ='" + damBox.getSelectedItem() + "', ";
	        		  myinsert = myinsert +  "DAMBREED = '" + dambreedLabel.getText() + "', ";
	        		  myinsert = myinsert +  "BUCK ='" + sireBox.getSelectedItem() + "', ";
	        		  myinsert = myinsert +  "SIREBREED ='" + sirebreedLabel.getText() + "', ";
	        		  myinsert = myinsert +  "PERCENTAGE ='" + percentageBox.getSelectedItem() + "'";		
	        		  myinsert = myinsert +  " WHERE ID= "  + SG.SGdata.getId();
	        		  System.out.println(myinsert);		
	        		  SG.SGquery.updateGoat(myinsert);
	        		  SG.SGquery.getmygoat("SELECT * From GOAT.HERD WHERE name = '" + SG.SGdata.getName() + "'");
	        		  percentageField.setText(SG.SGdata.getPercentage());
	        		  dambreedLabel.setText(SG.SGdata.getDambreed());
	        		  sirebreedLabel.setText(SG.SGdata.getSirebreed());
	        		  
	        	  }
	        	}
	       });
		
		btnCancel.addActionListener(new ActionListener() {
	          public void actionPerformed(ActionEvent e) {
	        	 	  btnEditSave.setText("edit");
	        		  btnCancel.setVisible(false);
	        		  btnUpdate.setVisible(false);
	        		  damField.setVisible(true);
	        		  sireField.setVisible(true);
	        		  percentageField.setVisible(true);
	        		  damBox.setVisible(false);
	        		  sireBox.setVisible(false);
	        		  percentageBox.setVisible(false);
	        		  damField.setText(SG.SGdata.getDam());
	        		  sireField.setText(SG.SGdata.getSire());
	        		  percentageField.setText(SG.SGdata.getPercentage());
	        		  dambreedLabel.setText(SG.SGdata.getDambreed());
	        		  sirebreedLabel.setText(SG.SGdata.getSirebreed());
	        		  
	        		  
	          }
    	});
	     
		btnUpdate.addActionListener(new ActionListener() {
	          public void actionPerformed(ActionEvent e) {
	        	  String myquery = "SELECT * From GOAT.HERD WHERE name = '" + sireBox.getSelectedItem() + "'";
	        	  sirebreedLabel.setText(SG.SGquery.getsingledata(myquery, "Percentage"));	  
	        	  myquery = "SELECT * From GOAT.HERD WHERE name = '" + damBox.getSelectedItem() + "'";
	        	  dambreedLabel.setText(SG.SGquery.getsingledata(myquery, "Percentage"));  
	        	  btnEditSave.setEnabled(true);
	          }
  	});
		
	}
}	
	


