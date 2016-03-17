package goat;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Locale;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

import util.Checkdate;

public class SGlgWeight {

	ShowGoat SG;
	Control cc;
	String BirthDate;
	float BirthWeight;
	String WeanDate;
	float WeanWeight;
	boolean postWeanWeight = true;
	LocalDate weandate;
	LocalDate birthdate;
	JLabel weandaysLabel;
	JLabel weanweightLabel;
	
	
	public SGlgWeight(ShowGoat SG, Control cc) {
		this.SG = SG;
		this.cc = cc;
	}

	public void displayWeight() {
		JPanel weightsPanel = new JPanel();
		weightsPanel.setLayout(null);
		SG.lgjtp.addTab("Weights", weightsPanel);
		weightsPanel.setBackground(SG.customColor);
		
		//Weight Date//

		JTextField weightdateField = new JTextField();
		weightdateField.setBounds(10, 20, 100, 20);
		weightdateField.setColumns(10);
		weightsPanel.add(weightdateField);
		
		JLabel weightdateFormatLabel = new JLabel("mm/dd/yyyy",SwingConstants.RIGHT);
		weightdateFormatLabel.setBounds(10, 40, 80, 20);
		weightsPanel.add(weightdateFormatLabel);
		
		JLabel weightLabel = new JLabel("Weight:",SwingConstants.RIGHT);
		weightLabel.setBounds(150, 20, 50, 20);
		weightsPanel.add(weightLabel);
		
		JTextField weightField = new JTextField();
		weightField.setBounds(210, 20, 50, 20);
		weightField.setColumns(10);
		weightsPanel.add(weightField);
		
		JCheckBox wwCB = new JCheckBox("Wean Weight");
		wwCB.setBounds(300, 20, 120, 20);
		wwCB.setBackground(SG.customColor);
		weightsPanel.add(wwCB);
		
		JButton addButton = new JButton("Add");
		addButton.setBounds(425, 20, 70, 20);
		weightsPanel.add(addButton);
		
		//Calculated weaning weight
		
		JLabel weanageLabel = new JLabel("Weaned Age:",SwingConstants.RIGHT);
		weanageLabel.setBounds(550, 20, 100, 20);
		weightsPanel.add(weanageLabel);
		
		weandaysLabel = new JLabel("0",SwingConstants.LEFT);
		weandaysLabel.setBounds(675, 20, 50, 20);
		weightsPanel.add(weandaysLabel);
		
		JLabel adjweanweightLabel = new JLabel("Adjusted Wean Weight:",SwingConstants.RIGHT);
		adjweanweightLabel.setBounds(750, 20, 150, 20);
		weightsPanel.add(adjweanweightLabel);
		
		weanweightLabel = new JLabel("0.00",SwingConstants.LEFT);
		weanweightLabel.setBounds(925, 20, 50, 20);
		weightsPanel.add(weanweightLabel);
	
		//Action Listers for Add Button
		addButton.addActionListener(new ActionListener() {
	    	  public void actionPerformed(ActionEvent e) {
// TODO Wean weight calculation not working suspect a bad date 2/17/2016 vs 02/17/2016
	    		  Checkdate gooddate = new Checkdate();
	    		  Boolean OK2Save = gooddate.mmddyyyy(weightdateField.getText().trim());
	    		  //Make sure weight is a valid weight (float)
	    		  
	    		  if (OK2Save) {
	    		  
	    			  String ww = null;
	    			  if (wwCB.isSelected()) {
	    				  ww = "yes";
	    			  } else {
	    				  ww = "no";
	    			  }
	    			  String myinsert = new String();
	    			  myinsert = "INSERT INTO GOAT.WEIGHT (WW, WEIGHT, WDATE, ID)";
	    			  myinsert = myinsert + "VALUES ('";
	    			  myinsert = myinsert + ww + "', '";
	    			  myinsert = myinsert + weightField.getText().trim() + "','";
	    			  myinsert = myinsert + weightdateField.getText().trim() + "', ";
	    			  myinsert = myinsert + SG.SGdata.getId() + ")";
	    		  
	    			  SG.SGquery.updateGoat(myinsert);
	    			  
	    			  for (int x = 0; x < 100; x=x+1){
	        			  	if (SG.weighttable.getValueAt(x, 0) == null) {
	        			  		SG.weighttable.setValueAt(weightdateField.getText().trim(),x,0);
		        				SG.weighttable.setValueAt(weightField.getText().trim(),x,1);
		        				SG.weighttable.setValueAt(ww,x,2);
		        				x=100;
	        			  	}
	        		  }
	    			  
	    			  postWeanWeight = true;
	    			  if (ww.contains("yes")) {
							wwCB.setVisible(false);
							WeanDate = weightdateField.getText().trim();
							try {
								WeanWeight = Float.parseFloat(weightField.getText().trim());
								} catch (Exception e1) {
									postWeanWeight = false;
								}
						}
	    			  
	    			  caculateWeanWeight();
	    			  
	    			  
	    			  
	    			   
	    			  weightField.setText("");
	    			  weightdateField.setText("");
	    			  
	    		  }	else {
	    			  JOptionPane.showMessageDialog(null, "Weigh Date invalid", "Date Error",JOptionPane.WARNING_MESSAGE);
	    		  }
	    	  }
	      });
		
		//Create table to display weights from database
		
				String[] col = {"Date", "Weight", "Wean Weight"};
				
				DefaultTableModel model;
				model = new DefaultTableModel(col,100);
				
				
				SG.weighttable=new JTable(model){ 
					private static final long serialVersionUID = 1L; 
					@Override public boolean isCellEditable(int arg0, int arg1) { return false; }};
			    
				TableColumnModel columnModel = SG.weighttable.getColumnModel();
			    columnModel.getColumn(0).setPreferredWidth(100);
			    columnModel.getColumn(1).setPreferredWidth(500);
			    columnModel.getColumn(2).setPreferredWidth(100);
				
			    SG.weighttable.setValueAt(SG.SGdata.getBirthdate(),0,0);
			    SG.weighttable.setValueAt(SG.SGdata.getBirthweight(),0,1);
			    SG.weighttable.setValueAt("Birth",0,2);
				String [][] weightsarray = SG.SGquery.getweights("SELECT wdate, weight, ww From GOAT.WEIGHT WHERE ID = " + SG.SGdata.getId());
				
				for (int x = 1; x < 100; x=x+1){
					SG.weighttable.setValueAt(weightsarray[x-1][0],x,0);
					SG.weighttable.setValueAt(weightsarray[x-1][1],x,1);
					SG.weighttable.setValueAt(weightsarray[x-1][2],x,2);
					
					if(weightsarray[x-1][2] != null) {
						if (weightsarray[x-1][2].contains("yes")) {
							wwCB.setVisible(false);
							WeanDate = weightsarray[x-1][0];
							try {
								WeanWeight = Float.parseFloat(weightsarray[x-1][1]);
								} catch (Exception e) {
									postWeanWeight = false;
								}
						}
					}
				}
				
				caculateWeanWeight();
				
				JScrollPane scrollpane = new JScrollPane(SG.weighttable);
			    scrollpane.setBounds(10, 80, 600, 300);
			    weightsPanel.add(scrollpane);
	}//TODO Appears and incorrect date will screw up the weight calculation
	
	private void caculateWeanWeight() {
		//Calculate Adjusted Weaning Weight
		
		// Format dates
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyy", Locale.ENGLISH);
		BirthDate = SG.SGdata.getBirthdate();
		
		//Parse variables
		try {
			BirthWeight = Float.parseFloat(SG.SGdata.getBirthweight());
			weandate = LocalDate.parse(WeanDate, formatter);
			birthdate = LocalDate.parse(BirthDate, formatter);
		} catch (Exception e) {
			postWeanWeight = false;
		}
		
		//Only do this if all variables are parsed correctly
		if (postWeanWeight) {
			int days=(int) ChronoUnit.DAYS.between(birthdate, weandate);
			float gained = WeanWeight - BirthWeight;
			float perday = gained/days;
		
			float adjweanweight = (perday * 90) + BirthWeight;
		
			weandaysLabel.setText(Integer.toString(days));
			String weanweightformatted = Float.toString(adjweanweight);
			if (weanweightformatted.length() > 6) {
				weanweightformatted = weanweightformatted.substring(0,5);					
			}	
			weanweightLabel.setText(weanweightformatted);
		}
		
	}
	

}
