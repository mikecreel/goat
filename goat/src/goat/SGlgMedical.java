package goat;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

public class SGlgMedical {
	
	ShowGoat SG;
	Control cc;

	public SGlgMedical(ShowGoat SG, Control cc) {
		this.SG = SG;
		this.cc = cc;
	}

	public void displayMedical() {

		JPanel medicalPanel = new JPanel();
		medicalPanel.setLayout(null);
		medicalPanel.setBackground(SG.customColor);
		SG.lgjtp.addTab("Medical", medicalPanel);
		
		
		//Medical Date//
		
		JTextField conditiondateField = new JTextField();
		conditiondateField.setBounds(10, 20, 100, 20);
		conditiondateField.setColumns(10);
		medicalPanel.add(conditiondateField);
		
		JLabel conditiondateFormatLabel = new JLabel("mm/dd/yyyy",SwingConstants.RIGHT);
		conditiondateFormatLabel.setBounds(10, 40, 80, 20);
		medicalPanel.add(conditiondateFormatLabel);
		
		//Procedure
		
		JLabel procedureLabel = new JLabel("Procedure: ",SwingConstants.RIGHT);
		procedureLabel.setBounds(125, 20, 75, 20);
		medicalPanel.add(procedureLabel);
		
		String[] procedureStrings = {"De-Worming ", "Vaccines ", "Hoof Trimiming", "Other"};
		JComboBox<String> procedureBox = new JComboBox<String>(procedureStrings);;
		procedureBox.setBounds(205, 20, 300, 20);
		medicalPanel.add(procedureBox);
		
		//Dosage
		
		JLabel dosageLabel = new JLabel("Dosage: ",SwingConstants.RIGHT);
		dosageLabel.setBounds(505, 20, 100, 20);
		medicalPanel.add(dosageLabel);
		
		JTextField dosageField = new JTextField();
		dosageField.setBounds(605, 20, 200, 20);
		dosageField.setColumns(40);
		medicalPanel.add(dosageField);
		
		//Cost
		
		JLabel costLabel = new JLabel("Cost: ",SwingConstants.RIGHT);
		costLabel.setBounds(790, 20, 75, 20);
		medicalPanel.add(costLabel);
		
		JTextField costField = new JTextField();
		costField.setBounds(865, 20, 100, 20);
		medicalPanel.add(costField);
				
		//Medical Note
		
		JLabel mnoteLabel = new JLabel("Note: ",SwingConstants.RIGHT);
		mnoteLabel.setBounds(125, 50, 75, 20);
		medicalPanel.add(mnoteLabel);
		
		JTextField mnoteField = new JTextField();
		mnoteField.setBounds(205, 50, 600, 20);
		medicalPanel.add(mnoteField);
		
//TODO  Add medical procedure save button
		
		//Create table to display notes from database
		
		String[] col = {"Date", "Procedure", "Dosage", "Cost", "Note"};
		
		DefaultTableModel medmodel;
		medmodel = new DefaultTableModel(col,100);
		
		
		SG.medtable=new JTable(medmodel){ 
			private static final long serialVersionUID = 1L; 
			@Override public boolean isCellEditable(int arg0, int arg1) { return false; }};
	    
		TableColumnModel medcolumnModel = SG.medtable.getColumnModel();
	    medcolumnModel.getColumn(0).setPreferredWidth(100);
	    medcolumnModel.getColumn(1).setPreferredWidth(225);
	    medcolumnModel.getColumn(2).setPreferredWidth(100);
	    medcolumnModel.getColumn(3).setPreferredWidth(75);
	    medcolumnModel.getColumn(4).setPreferredWidth(450);
		
//	    SG.medtable.setValueAt("RecCreated",0,0);
//	    SG.medtable.setValueAt(SG.SGdata.getNotes(),0,1);
//		String [][] mednotesarray = SG.SGquery.getmednotes("SELECT notedate, note From GOAT.NOTES WHERE ID = " + SG.SGdata.getId());
//		for (int x = 1; x < 100; x=x+1){
//			SG.medtable.setValueAt(notesarray[x-1][0],x,0);
//			SG.medtable.setValueAt(notesarray[x-1][1],x,1);
//			
//		}
		
		JScrollPane medscrollpane = new JScrollPane(SG.medtable);
	    medscrollpane.setBounds(10, 80, 960, 300);
	    medicalPanel.add(medscrollpane);
	
	}

}
