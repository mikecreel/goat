package goat;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

public class SGlgKids {
	
	ShowGoat SG;
	Control cc;

	public SGlgKids(ShowGoat SG, Control cc) {
		this.SG = SG;
		this.cc = cc;
	}

	public void displayKids() {
		JPanel kidsPanel = new JPanel();
		kidsPanel.setLayout(null);
		SG.lgjtp.addTab("Kids", kidsPanel);
		kidsPanel.setBackground(SG.customColor);
		String Other;
		
		if (SG.SGdata.getGender().trim().equals("doe")) {
			Other = "Sire";
		} else {
			Other = "Dam";
		}
		
		String[] col = {"Birth Date", "Name", Other};
		
		DefaultTableModel model;
		model = new DefaultTableModel(col,100);
		
		SG.kidstable=new JTable(model){ 
			private static final long serialVersionUID = 1L; 
			@Override public boolean isCellEditable(int arg0, int arg1) { return false; }};
	    
		TableColumnModel columnModel = SG.kidstable.getColumnModel();
	    columnModel.getColumn(0).setPreferredWidth(100);
	    columnModel.getColumn(1).setPreferredWidth(250);
	    columnModel.getColumn(2).setPreferredWidth(250);
	    
	    String myquery;
	    
	    if (SG.SGdata.getGender().equals("doe")) {
	    	myquery = "SELECT birthdate, buck, dam, id From GOAT.HERD WHERE DAM = '" + SG.SGdata.getName() +"'";
	    } else {
	    	
	    	myquery = "SELECT birthdate, buck, dam, id From GOAT.HERD WHERE BUCK = '" + SG.SGdata.getName() +"'";
	    }
	    
	    String [][] kidsarray = SG.SGquery.getkids(myquery);
		
	    for (int x = 0; x < 100; x=x+1){
			if (!(kidsarray[x][0] == null)) {
				SG.kidstable.setValueAt(kidsarray[x][0],x,0);
				SG.kidstable.setValueAt(SG.SGquery.getname(kidsarray[x][3]),x,1);
				if (SG.SGdata.getGender().trim().equals("doe")) {
					SG.kidstable.setValueAt(kidsarray[x][1],x,2);
				} else {
					SG.kidstable.setValueAt(kidsarray[x][2],x,2);
				}
				
			}
		}
		
		
		JScrollPane scrollpane = new JScrollPane(SG.kidstable);
	    scrollpane.setBounds(10, 10, 960, 370);
	    kidsPanel.add(scrollpane);
		
		
		
	}

}
