package goat;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

public class SGlgCondition {
	
	ShowGoat SG;
	Control cc;

	public SGlgCondition(ShowGoat SG, Control cc) {
		this.SG = SG;
		this.cc = cc;
	}

	public void displayCondition() {

		//Condition Panel
		
		JPanel conditionPanel = new JPanel();
		conditionPanel.setLayout(null);
		SG.lgjtp.addTab("Condition", conditionPanel);
		conditionPanel.setBackground(SG.customColor);
		
		//Condition Date//
		
		JTextField conditiondateField = new JTextField();
		conditiondateField.setBounds(10, 20, 100, 20);
		conditiondateField.setColumns(10);
		conditionPanel.add(conditiondateField);
		
		JLabel conditiondateFormatLabel = new JLabel("mm/dd/yyyy",SwingConstants.RIGHT);
		conditiondateFormatLabel.setBounds(10, 40, 80, 20);
		conditionPanel.add(conditiondateFormatLabel);
		
		//Body Condition
		
		JLabel bodyLabel = new JLabel("Body Condition: ",SwingConstants.RIGHT);
		bodyLabel.setBounds(150, 20, 100, 20);
		conditionPanel.add(bodyLabel);
		
		String[] bodyStrings = {"1. Severe Under Conditioning ", "2. Frame Obvious ", "3. Frame and Covering Well Balanced", "4. Frame not as Visible as Covering", "5. Severe Over Conditioning"};
		JComboBox<String> bodyBox = new JComboBox<String>(bodyStrings);;
		bodyBox.setBounds(250, 20, 300, 20);
		conditionPanel.add(bodyBox);
		
		//Score
		
		JLabel scoreLabel = new JLabel("FAMACHA Score: ",SwingConstants.RIGHT);
		scoreLabel.setBounds(600, 20, 100, 20);
		conditionPanel.add(scoreLabel);
		
		String[] scoreStrings = {"1. Optimal ", "2. Acceptable", "3. Borderline ", "4. Dangerous", "5. Fatal"};
		JComboBox<String> scoreBox = new JComboBox<String>(scoreStrings);;
		scoreBox.setBounds(700, 20, 200, 20);
		conditionPanel.add(scoreBox);
				
		//Condition Notes		
				
		JLabel conditionnotesLabel = new JLabel("Condition Notes: ",SwingConstants.RIGHT);
		conditionnotesLabel.setBounds(150, 50, 100, 20);
		conditionPanel.add(conditionnotesLabel);
												
		JTextArea conditionnotesField = new JTextArea(20,20);
		conditionnotesField.setBounds(250, 50, 500, 50);
		conditionnotesField.setLineWrap(true);
		conditionnotesField.setWrapStyleWord(true);
		conditionPanel.add(conditionnotesField);			
				
		
		//Create condition table 
		
		String[] conditioncolumns = {"Date", "Score", "Body Condition", "Notes"};
		
		DefaultTableModel conditionmodel;
		conditionmodel = new DefaultTableModel(conditioncolumns,100);
		
		
		SG.condtable = new JTable(conditionmodel){ 
			private static final long serialVersionUID = 1L; 
			@Override public boolean isCellEditable(int arg0, int arg1) { return false; }};
	    
		TableColumnModel ccolumnModel = SG.condtable.getColumnModel();
	    ccolumnModel.getColumn(0).setPreferredWidth(80);
	    ccolumnModel.getColumn(1).setPreferredWidth(250);
	    ccolumnModel.getColumn(2).setPreferredWidth(100);
	    ccolumnModel.getColumn(3).setPreferredWidth(650);

	    String [][] condsarray = SG.SGquery.getconds("SELECT conddate, condition, famacha, condnote From GOAT.COND WHERE ID = " + SG.SGdata.getId());
		for (int x = 0; x < 100; x=x+1){
			SG.condtable.setValueAt(condsarray[x][0],x,0);
			SG.condtable.setValueAt(condsarray[x][1],x,1);
			SG.condtable.setValueAt(condsarray[x][2],x,2);
			SG.condtable.setValueAt(condsarray[x][3],x,3);
			
		}
	    
	    JScrollPane conditionscrollpane = new JScrollPane(SG.condtable);
	    conditionscrollpane.setBounds(10, 120, 960, 260);
	    conditionPanel.add(conditionscrollpane);
	    
	    //Add edit/save button to tab
	    JButton btnSave = new JButton("Save");
	    btnSave.setBounds(820, 60, 80, 20);
	    conditionPanel.add(btnSave);
	    //Add cancel button to tab
	    JButton btnCancel = new JButton("Cancel");
	    btnCancel.setBounds(820, 90, 80, 20);
	    conditionPanel.add(btnCancel);

	    btnSave.addActionListener(new ActionListener() {
	          public void actionPerformed(ActionEvent e) {
	        		  String myinsert;
	        		  
	        		  //TODO Verify  date is correct format
	        		  
	        		  //Data Checking
	        		  
	        		  conditionnotesField.setText(conditionnotesField.getText().replace("'", ""));
	        		  conditionnotesField.setText(conditionnotesField.getText().replace("\"", ""));
	        		  
	        		  
	        		  myinsert = "INSERT INTO Goat.Cond (CONDDATE, CONDITION, FAMACHA, CONDNOTE, ID) VALUES ('";
	        		  myinsert = myinsert +  conditiondateField.getText().trim() + "', '";
	        		  myinsert = myinsert +  bodyBox.getSelectedItem() + "', '";
	        		  myinsert = myinsert +  scoreBox.getSelectedItem() + "', '";
	        		  myinsert = myinsert +  conditionnotesField.getText().trim() + "', ";		
	        		  myinsert = myinsert +  Integer.valueOf(SG.SGdata.getId()) + ")";
	        		  System.out.println(myinsert);
	        		  SG.SGquery.updateGoat(myinsert);
	        		  SG.SGquery.getmygoat("SELECT * From GOAT.HERD WHERE name = '" + SG.SGdata.getName() + "'");
	        		  
	        		  for (int x = 0; x < 100; x=x+1){
	        			  	if (SG.condtable.getValueAt(x, 0) == null) {
	        			  		SG.condtable.setValueAt(conditiondateField.getText().trim(),x,0);
		        				SG.condtable.setValueAt(bodyBox.getSelectedItem(),x,1);
		        				SG.condtable.setValueAt(scoreBox.getSelectedItem(),x,2);
		        				SG.condtable.setValueAt(conditionnotesField.getText().trim(),x,3);
		        				x=100;
	        			  	}
	        		  }
	        		  
	        	}
	       });
		
		btnCancel.addActionListener(new ActionListener() {
	          public void actionPerformed(ActionEvent e) {
	        	 	 
	        		  
	        	  }
	       });
		

	  		

	}

}
