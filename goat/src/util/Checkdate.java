package util;

import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Checkdate {

	boolean OKdate = true;

	public boolean mmddyyyy (String cdate) {
		OKdate = true;
		if (!cdate.isEmpty())  {
			SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
			dateFormat.setLenient(false);
			try {
				dateFormat.parse(cdate.trim());
			} catch (ParseException pe) {
				OKdate = false;	
			}	
		} else {
			OKdate = false;
		}
		
	return OKdate;
}


}