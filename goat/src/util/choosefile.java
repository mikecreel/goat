package util;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

public class choosefile {

	public JFileChooser chooser;
	public FileNameExtensionFilter filter;
	
	public choosefile(String ftext, String fext) {
		chooser = new JFileChooser();
		filter = new FileNameExtensionFilter(ftext,fext);
	}
		
	public String myfile() {
		String filestring = null;
		chooser.setFileFilter(filter);
		int returnVal = chooser.showOpenDialog(chooser);
    
		if(returnVal == JFileChooser.APPROVE_OPTION) {
			
            filestring = chooser.getCurrentDirectory().getPath();
			filestring = filestring + "\\" + chooser.getSelectedFile().getName();
		}
		
		return filestring;
	}
}