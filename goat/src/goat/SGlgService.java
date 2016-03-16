package goat;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

public class SGlgService {
	
	ShowGoat SG;
	Control cc;

	public SGlgService(ShowGoat SG, Control cc) {
		this.SG = SG;
		this.cc = cc;
	}

	public void displayService() {
		JPanel servicePanel = new JPanel();
		servicePanel.setLayout(null);
		SG.lgjtp.addTab("Service", servicePanel);
		servicePanel.setBackground(SG.customColor);
		
		String[] col = {"Date", "Doe", "Note", "Est Kidding Date"};
		
		DefaultTableModel model;
		model = new DefaultTableModel(col,100);
		
		SG.servicetable=new JTable(model){ 
			private static final long serialVersionUID = 1L; 
			@Override public boolean isCellEditable(int arg0, int arg1) { return false; }};
	    
		TableColumnModel columnModel = SG.servicetable.getColumnModel();
	    columnModel.getColumn(0).setPreferredWidth(80);
	    columnModel.getColumn(1).setPreferredWidth(250);
	    columnModel.getColumn(2).setPreferredWidth(500);
	    columnModel.getColumn(3).setPreferredWidth(80);
	    
	    String [][] servicearray = SG.SGquery.getbreeding("SELECT bdate, id, buckname, estkiddate, note From GOAT.BREEDING WHERE BUCKNAME = '" + SG.SGdata.getName() +"'", false);
		for (int x = 0; x < 100; x=x+1){
			if (!(servicearray[x][0] == null)) {
				SG.servicetable.setValueAt(servicearray[x][0],x,0);
				SG.servicetable.setValueAt(SG.SGquery.getname(servicearray[x][1]),x,1);
				SG.servicetable.setValueAt(servicearray[x][2],x,2);
				SG.servicetable.setValueAt(servicearray[x][3],x,3);
			}
		}
		
		JScrollPane scrollpane = new JScrollPane(SG.servicetable);
	    scrollpane.setBounds(10, 10, 960, 370);
	    servicePanel.add(scrollpane);
		
		
		
		
	}

}