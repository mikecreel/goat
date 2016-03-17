package goat;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

public class SGlgNotes {
	
	ShowGoat SG;
	Control cc;

	public SGlgNotes(ShowGoat SG, Control cc) {
		this.SG = SG;
		this.cc = cc;
	}

	public void displayNotes() {
		// Notes Panel

		JPanel notesPanel = new JPanel();
		notesPanel.setLayout(null);
		notesPanel.setBackground(SG.customColor);
		SG.lgjtp.addTab("Notes", notesPanel);
		
		
		//Note Date
		
		JTextField notedateField = new JTextField();
		notedateField.setBounds(10, 20, 100, 20);
		notedateField.setColumns(10);
		notesPanel.add(notedateField);
		
		JLabel notedateFormatLabel = new JLabel("mm/dd/yyyy",SwingConstants.RIGHT);
		notedateFormatLabel.setBounds(10, 40, 80, 20);
		notesPanel.add(notedateFormatLabel);
		
		//Note Label
		
		JLabel noteLabel = new JLabel("Note:",SwingConstants.RIGHT);
		noteLabel.setBounds(110, 20, 50, 20);
		notesPanel.add(noteLabel);
		
		//This is where a new note is added.
		
		JTextArea notesField = new JTextArea();
		notesField.setLineWrap(true);
		notesField.setWrapStyleWord(true);
		notesField.setBounds(170, 20, 700, 50);
		notesPanel.add(notesField);
		
		JButton saveButton = new JButton("Save");
		saveButton.setBounds(890, 20, 70, 30);
		notesPanel.add(saveButton);
		

		//Action Listers for SAVE Note Buttons
		saveButton.addActionListener(new ActionListener() {
	    	  public void actionPerformed(ActionEvent e) {
	    		  
// TODO Check for valid note date
	    		  
	    		  // Data Checking
	    		  
	    		  notesField.setText(notesField.getText().replace("'", ""));
        		  notesField.setText(notesField.getText().replace("\"", ""));
	    		  
	    		  
	    		  String myinsert = new String();
	    		  myinsert = "INSERT INTO GOAT.NOTES (NOTE, NOTEDATE, ID)";
	    		  myinsert = myinsert + "VALUES ('";
	    		  myinsert = myinsert + notesField.getText().trim() + "', '";
	    		  myinsert = myinsert + notedateField.getText().trim() + "', ";
	    		  myinsert = myinsert + SG.SGdata.getId() + ")";
	    		  SG.SGquery.updateGoat(myinsert);
	    		  
	    		  for (int x = 0; x < 100; x=x+1){
      			  	if (SG.table.getValueAt(x, 0) == null) {
      			  		SG.table.setValueAt(notedateField.getText().trim(),x,0);
	        			SG.table.setValueAt(notesField.getText(),x,1);
	        			x=100;
	        			notedateField.setText("");
	  	    		  	notesField.setText(""); 
      			  }
      		  }
	    	  }
	      });
		
		// Text area to show note from selected row in table
		
		JTextArea displaynoteField = new JTextArea();
	    displaynoteField.setLineWrap(true);
	    displaynoteField.setWrapStyleWord(true);
	    displaynoteField.setBounds(630, 80, 320, 300);
	    displaynoteField.setText(SG.SGdata.getNotes());
	    displaynoteField.setEditable(false);
		notesPanel.add(displaynoteField);
	
		//Create table to display notes from database
		
		String[] col = {"Date", "Note"};
		
		DefaultTableModel model;
		model = new DefaultTableModel(col,100);
		
		
		SG.table=new JTable(model){ 
			private static final long serialVersionUID = 1L; 
			@Override public boolean isCellEditable(int arg0, int arg1) { return false; }};
	    
		TableColumnModel columnModel = SG.table.getColumnModel();
	    columnModel.getColumn(0).setPreferredWidth(100);
	    columnModel.getColumn(1).setPreferredWidth(500);
		
	    SG.table.setValueAt("RecCreated",0,0);
	    SG.table.setValueAt(SG.SGdata.getNotes(),0,1);
		String [][] notesarray = SG.SGquery.getnotes("SELECT notedate, note From GOAT.NOTES WHERE ID = " + SG.SGdata.getId());
		for (int x = 1; x < 100; x=x+1){
			SG.table.setValueAt(notesarray[x-1][0],x,0);
			SG.table.setValueAt(notesarray[x-1][1],x,1);
			
		}
		
		SG.table.setCellSelectionEnabled(false);
		ListSelectionModel cellSelectionModel = SG.table.getSelectionModel();
		cellSelectionModel.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		cellSelectionModel.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {
				String selectedData = null;

				int[] selectedRow = SG.table.getSelectedRows();
				int[] selectedColumns = SG.table.getSelectedColumns();

				for (int i = 0; i < selectedRow.length; i++) {
					for (int j = 0; j < selectedColumns.length; j++) {
						selectedData = (String) SG.table.getValueAt(selectedRow[i], 1);
					}
		        }
		        displaynoteField.setText(selectedData);
		   }

		});
		
		JScrollPane scrollpane = new JScrollPane(SG.table);
	    scrollpane.setBounds(10, 80, 600, 300);
	    notesPanel.add(scrollpane);
	    
		

	}

}
